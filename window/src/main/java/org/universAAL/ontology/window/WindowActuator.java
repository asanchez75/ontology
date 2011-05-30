/*
	Copyright 2008-2014 Fraunhofer IGD, http://www.igd.fraunhofer.de
	Fraunhofer Gesellschaft - Institut fuer Graphische Datenverarbeitung 
	
	See the NOTICE file distributed with this work for additional 
	information regarding copyright ownership
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	  http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */

package org.universAAL.ontology.window;

import org.universAAL.middleware.rdf.TypeMapper;
import org.universAAL.middleware.owl.supply.AbsLocation;
import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.middleware.owl.OrderingRestriction;
import org.universAAL.middleware.owl.Restriction;
import org.universAAL.ontology.phThing.Device;

/**
 * Ontological representation of a window as a device. Methods included in this
 * class are the mandatory ones for representing an ontological concept in Java
 * classes for uAAL. Usually it includes getters and setters for most of its
 * properties.
 * 
 * @author Steeven Zeiss
 * 
 * 
 */
public class WindowActuator extends Device {
    public static final String WINDOW_NAMESPACE = "http://ontology.persona.ima.igd.fhg.de/Window.owl#";
    public static final String MY_URI;
    public static final String PROP_HAS_TYPE;
    public static final String PROP_WINDOW_STATUS;
    static {
	MY_URI = WINDOW_NAMESPACE + "Window";
	PROP_HAS_TYPE = WINDOW_NAMESPACE + "hasType";
	PROP_WINDOW_STATUS = WINDOW_NAMESPACE + "windowStatus";
	register(WindowActuator.class);
    }

    public static Restriction getClassRestrictionsOnProperty(String propURI) {
	if (PROP_HAS_TYPE.equals(propURI))
	    return Restriction.getAllValuesRestrictionWithCardinality(propURI,
		    WindowType.MY_URI, 1, 1);
	if (PROP_WINDOW_STATUS.equals(propURI))
	    return OrderingRestriction.newOrderingRestriction(new Integer(100),
		    new Integer(0), true, true, Restriction
			    .getAllValuesRestrictionWithCardinality(propURI,
				    TypeMapper.getDatatypeURI(Integer.class),
				    1, 1));
	return ManagedIndividual.getClassRestrictionsOnProperty(propURI);
    }

    public static String[] getStandardPropertyURIs() {
	String[] inherited = ManagedIndividual.getStandardPropertyURIs();
	String[] toReturn = new String[inherited.length + 2];
	int i = 0;
	while (i < inherited.length) {
	    toReturn[i] = inherited[i];
	    i++;
	}
	toReturn[i++] = PROP_HAS_TYPE;
	toReturn[i] = PROP_WINDOW_STATUS;
	return toReturn;
    }

    public static String getRDFSComment() {
	return "The class of all windows.";
    }

    public static String getRDFSLabel() {
	return "Window";
    }

    public WindowActuator() {
	super();
    }

    public WindowActuator(String uri) {
	super(uri);
    }

    public WindowActuator(String uri, AbsLocation loc) {
	super(uri);
	if (loc == null)
	    throw new IllegalArgumentException();
	props.put(PROP_PHYSICAL_LOCATION, loc);
	props.put(PROP_WINDOW_STATUS, new Integer(0));
    }

    public WindowActuator(String uri, WindowType type, AbsLocation loc) {
	super(uri);
	if (type == null || loc == null)
	    throw new IllegalArgumentException();

	props.put(PROP_HAS_TYPE, type);
	props.put(PROP_PHYSICAL_LOCATION, loc);
    }

    // public Location getAmbientCoverage() {
    // return (Location) props.get(PROP_AMBIENT_COVERAGE);
    // }

    /*
     * public int getBrightness() { Integer i = (Integer)
     * props.get(PROP_SOCKET_VALUE); return (i == null)? -1 : i.intValue(); }
     */

    public WindowType getWindowType() {
	return (WindowType) props.get(PROP_HAS_TYPE);
    }

    public AbsLocation getWindowLocation() {
	return (AbsLocation) props.get(PROP_PHYSICAL_LOCATION);
    }

    // public void setAmbientCoverage(Location l) {
    // if (l != null)
    // props.put(PROP_AMBIENT_COVERAGE, l);
    // }

    // public void setBrightness(int percentage) {
    // if (percentage > -1 && percentage < 101)
    // props.put(PROP_SOCKET_VALUE, new Integer(percentage));
    // }

    public void setWindowLocation(AbsLocation l) {
	if (l != null)
	    props.put(PROP_PHYSICAL_LOCATION, l);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.universAAL.middleware.owl.ManagedIndividual#getPropSerializationType
     * (java.lang.String)
     */
    public int getPropSerializationType(String propURI) {
	return PROP_PHYSICAL_LOCATION.equals(propURI) ? PROP_SERIALIZATION_REDUCED
		: PROP_SERIALIZATION_FULL;

	// return (PROP_AMBIENT_COVERAGE.equals(propURI)
	// || PROP_SOCKET_LOCATION.equals(propURI))?
	// PROP_SERIALIZATION_REDUCED : PROP_SERIALIZATION_FULL;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.universAAL.middleware.owl.ManagedIndividual#isWellFormed()
     */
    public boolean isWellFormed() {
	return props.containsKey(PROP_HAS_TYPE)
		&& props.containsKey(PROP_PHYSICAL_LOCATION)
		&& props.contains(PROP_WINDOW_STATUS);
    }

}