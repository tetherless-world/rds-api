package edu.rpi.tw.rds.vocabulary;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author szednik
 */
public class DCAT {

    private static OntModel m_model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

    public static final String NS = "http://www.w3.org/ns/dcat#";

    public static String getURI() {return NS;}

    public static final Resource NAMESPACE = m_model.createResource( NS );

    public static final ObjectProperty accessURL = m_model.createObjectProperty( "http://www.w3.org/ns/dcat#accessURL" );

    public static final ObjectProperty downloadURL = m_model.createObjectProperty( "http://www.w3.org/ns/dcat#downloadURL" );

}
