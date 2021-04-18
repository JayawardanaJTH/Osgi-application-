package adminsubscriber;

import assignpublisher.IAssign;
//import org.omg.PortableServer.IdAssignmentPolicy;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import studentpublisher.IStudent;

public class Activator implements BundleActivator {

	public ServiceReference<?> studentServiceReference;
	private ServiceReference<?> assignServiceReference;
	
	private IStudent studentService;
	private IAssign assignService;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		studentServiceReference = bundleContext.getServiceReference(IStudent.class.getName());
		assignServiceReference = bundleContext.getServiceReference(IAssign.class.getName());
		
		studentService = (IStudent) bundleContext.getService(studentServiceReference);
		assignService = (IAssign) bundleContext.getService(assignServiceReference);
		
		MainUI frame = new MainUI(studentService);
		frame.setVisible(true);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		bundleContext.ungetService(studentServiceReference);
		bundleContext.ungetService(assignServiceReference);
	}

}
