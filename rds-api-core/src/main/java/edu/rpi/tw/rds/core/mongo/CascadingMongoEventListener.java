package edu.rpi.tw.rds.core.mongo;

import com.mongodb.DBObject;
import edu.rpi.tw.rds.core.model.Identifiable;
import edu.rpi.tw.rds.core.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * @author szednik
 */
public class CascadingMongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoOperations mongoOperations;

    private IdentityService identityService;

    @Override
    public void onBeforeConvert(final Object source) {
        super.onBeforeConvert(source);

        ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {

            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);

                if (field.isAnnotationPresent(DBRef.class)
                        && field.isAnnotationPresent(CascadeSave.class)) {

                    final Object fieldValue = field.get(source);

                    if (fieldValue == null) {
                        return;
                    }

                    if (fieldValue instanceof Collection) {
                        Collection collectionFieldValue = (Collection) fieldValue;
                        for (Object collectionValue : collectionFieldValue) {
                            this.saveFieldValue(collectionValue);
                        }
                    } else {
                        this.saveFieldValue(fieldValue);
                    }
                }
            }

            private void saveFieldValue(final Object fieldValue) {
                DbRefFieldCallback callback = new DbRefFieldCallback();
                ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

                if (!callback.isIdFound()) {
                    throw new MappingException("Cannot perform cascade save on child object without id set");
                }

                mongoOperations.save(fieldValue);
            }

        });
    }

    private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {
        private boolean idFound;

        public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
            ReflectionUtils.makeAccessible(field);

            if (field.isAnnotationPresent(Id.class)) {
                idFound = true;
            }
        }

        public boolean isIdFound() {
            return idFound;
        }
    }

    @Override
    public void onBeforeSave(Object source, DBObject dbo) {
        super.onBeforeSave(source, dbo);
        if(identityService != null) {
            if (Identifiable.class.isAssignableFrom(source.getClass())) {
                Identifiable obj = (Identifiable) source;
                identityService.update(obj);
            }
        }
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }
}
