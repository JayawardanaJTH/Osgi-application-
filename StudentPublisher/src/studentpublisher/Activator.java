package studentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Student Publisher started");
		serviceRegistration = bundleContext.registerService(IStudent.class.getName(), new StudentImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Student Publisher stopped");
		serviceRegistration.unregister();
	}

}
