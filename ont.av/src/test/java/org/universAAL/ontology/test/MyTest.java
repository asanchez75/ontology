package org.universAAL.ontology.test;

import org.universAAL.middleware.bus.junit.BusTestCase;
import org.universAAL.ontology.AVActivator;
import org.universAAL.ontology.PhWorldActivator;

public class MyTest extends BusTestCase {

    protected void setUp() throws Exception {
	super.setUp();
	new PhWorldActivator().start(mc);
	new AVActivator().start(mc);
    }

    public void test() {
    }
}
