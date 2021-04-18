package adminsubscriber;

import assignpublisher.IAssign;
//import org.omg.PortableServer.IdAssignmentPolicy;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import studentpublisher.IStudent;
import subjectpublisher.ISubject;

public class Activator implements BundleActivator {

	public ServiceReference<?> studentServiceReference;
	private ServiceReference<?> assignServiceReference;
	private ServiceReference<?> subjectServiceReference;
	
	private IStudent studentService;
	private IAssign assignService;
	private ISubject subjectService;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		studentServiceReference = bundleContext.getServiceReference(IStudent.class.getName());
		assignServiceReference = bundleContext.getServiceReference(IAssign.class.getName());
		subjectServiceReference = bundleContext.getServiceReference(ISubject.class.getName());
		
		studentService = (IStudent) bundleContext.getService(studentServiceReference);
		assignService = (IAssign) bundleContext.getService(assignServiceReference);
		subjectService = (ISubject) bundleContext.getService(subjectServiceReference);
		
//		MainUI frame = new MainUI(studentService);
		MainUI frame = new MainUI(subjectService);
		frame.setVisible(true);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		bundleContext.ungetService(studentServiceReference);
		bundleContext.ungetService(assignServiceReference);
		bundleContext.ungetService(studentServiceReference);
	}

}
