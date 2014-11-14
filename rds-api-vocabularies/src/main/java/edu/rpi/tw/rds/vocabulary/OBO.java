package edu.rpi.tw.rds.vocabulary;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Created by szednik on 8/21/14.
 */
public class OBO {

    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.obolibrary.org/obo/";

    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}

    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );

    /** The OBO "has contact info" property */
    public static final ObjectProperty hasContactInfo = m_model.createObjectProperty( "http://purl.obolibrary.org/obo/ARG_2000028" );

    /** The OBO "contactInfoFor" property */
    public static final ObjectProperty contactInfoFor = m_model.createObjectProperty( "http://purl.obolibrary.org/obo/ARG_2000029" );
}
