package edu.rpi.tw.rds.core.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

/**
 * @author szednik
 */
public class EmailAddress {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    @Field("email")
    private final String emailAddress;

    public EmailAddress(String emailAddress) {
        Assert.isTrue(isValid(emailAddress), "Invalid email address!");
        this.emailAddress = emailAddress;
    }

    public static boolean isValid(String source) {
        return PATTERN.matcher(source).matches();
    }

    public String toURI() {
        return "mailto:"+this.emailAddress;
    }

    @Override
    public String toString() {
        return this.emailAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailAddress that = (EmailAddress) o;
        return !(emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null);
    }

    @Override
    public int hashCode() {
        return emailAddress != null ? emailAddress.hashCode() : 0;
    }
}
