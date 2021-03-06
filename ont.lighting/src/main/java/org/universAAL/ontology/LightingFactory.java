/*
	Copyright 2007-2014 Fraunhofer IGD, http://www.igd.fraunhofer.de
	Fraunhofer-Gesellschaft - Institute for Computer Graphics Research

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
package org.universAAL.ontology;

import org.universAAL.middleware.rdf.Resource;
import org.universAAL.middleware.rdf.ResourceFactory;
import org.universAAL.ontology.lighting.Beaming;
import org.universAAL.ontology.lighting.BeamingSource;
import org.universAAL.ontology.lighting.BlinkableBeaming;
import org.universAAL.ontology.lighting.BlinkableBeamingSource;
import org.universAAL.ontology.lighting.BlinkableLightSource;
import org.universAAL.ontology.lighting.BlinkableLighting;
import org.universAAL.ontology.lighting.LightSource;
import org.universAAL.ontology.lighting.Lighting;

/**
 * @author mtazari
 * @author Carsten Stockloew
 */
public class LightingFactory implements ResourceFactory {
	// private static final int NAMESPACE_LENGTH = LIGHTING_NAMESPACE.length();
	// private static final String PROP_ORIG_INDIVIDUAL = LIGHTING_NAMESPACE
	// + LightingFactory.class.hashCode();

	public LightingFactory() {
	}

	public Resource createInstance(String classURI, String instanceURI, int factoryIndex) {
		/*
		 * General comment for this implementation: we assume that this method
		 * is only called by the static method Resource.getResource() => we
		 * assume that the case of registered named resources is already handled
		 * there
		 */

		switch (factoryIndex) {
		case 0:
			return new LightSource(instanceURI);
		case 1:
			return new BeamingSource(instanceURI);
		case 2:
			return new BlinkableLightSource(instanceURI);
		case 3:
			return new BlinkableBeamingSource(instanceURI);
		case 4:
			return new Lighting(instanceURI);
		case 5:
			return new Beaming(instanceURI);
		case 6:
			return new BlinkableLighting(instanceURI);
		case 7:
			return new BlinkableBeaming(instanceURI);
		}

		// if (classURI == null || !classURI.startsWith(LIGHTING_NAMESPACE))
		// return null;
		// String className = classURI.substring(NAMESPACE_LENGTH);
		// if (className.equals("Beaming"))
		// return new Beaming(instanceURI);
		// if (className.equals("BeamingSource"))
		// return new BeamingSource(instanceURI);
		// if (className.equals("BlinkableBeaming"))
		// return new BlinkableBeaming(instanceURI);
		// if (className.equals("BlinkableBeamingSource"))
		// return new BlinkableBeamingSource(instanceURI);
		// if (className.equals("BlinkableLighting"))
		// return new BlinkableLighting(instanceURI);
		// if (className.equals("BlinkableLightSource"))
		// return new BlinkableLightSource(instanceURI);
		// if (className.equals("Lighting"))
		// return new Lighting(instanceURI);
		// if (className.equals("LightSource"))
		// return new LightSource(instanceURI);
		return null;
	}
}
