package edu.rpi.tw.rds.vocabulary;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author szednik
 */
public class RDS {

    private static OntModel m_model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

    public static final String NS = "http://data.rpi.edu/ns#";

    public static String getURI() {return NS;}

    public static final Resource NAMESPACE = m_model.createResource( NS );

    public static final ObjectProperty ckanPage = m_model.createObjectProperty( "http://data.rpi.edu/ns#ckanPage" );

    public static final ObjectProperty vivoPage = m_model.createObjectProperty( "http://data.rpi.edu/ns#vivoPage" );

}
