package com.javaworld.sample.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.HelloService;

public class Activator implements BundleActivator {

	HelloServiceTracker helloServiceTracker;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!!");
		helloServiceTracker = new HelloServiceTracker(context);
		helloServiceTracker.open();
		HelloService helloService = (HelloService) helloServiceTracker.getService();
		System.out.println(helloService.sayHello());
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
//		context.ungetService(helloServiceReference);
		helloServiceTracker.close();
	}

}
