package teacherpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Teacher Publisher started");
		serviceRegistration = bundleContext.registerService(ITeacher.class.getName(), new TeacherImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Teacher Publisher stopped");
		serviceRegistration.unregister();
		
	}

}
