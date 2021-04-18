package subjectpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	public ServiceRegistration<?> serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		SubjectImpl subjectImpl = new SubjectImpl();
		
		serviceRegistration = bundleContext.registerService(ISubject.class.getName(), subjectImpl, null);
		
		System.out.println("Subjetc Service Registered.");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		serviceRegistration.unregister();
		
		System.out.println("Subject Service Unregistered");
	}
}
