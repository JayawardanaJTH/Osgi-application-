package assignpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	public ServiceRegistration<?> serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		AssignImpl assignImpl = new AssignImpl();
		
		/*
		 * Register the publisher
		 * Here publisher is register using the publisher name and pass the reference for it implementation
		 */
		serviceRegistration = bundleContext.registerService(IAssign.class.getName(), assignImpl, null);
		
		System.out.println("Assign Service Registerd");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		serviceRegistration.unregister();
		
		System.out.println("Assign Service Unregisterd");
	}

}
