package adminsubscriber;

import assignpublisher.IAssign;
//import org.omg.PortableServer.IdAssignmentPolicy;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import studentpublisher.IStudent;
import subjectpublisher.ISubject;
import teacherpublisher.ITeacher;

public class Activator implements BundleActivator{

	private ServiceReference<?> studentServiceReference;
	private ServiceReference<?> assignServiceReference;
	private ServiceReference<?> subjectServiceReference;
	private ServiceReference<?> teacherServiceReference;
	
	private IStudent studentService;
	private IAssign assignService;
	private ISubject subjectService;
	private ITeacher teacherService;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		studentServiceReference = bundleContext.getServiceReference(IStudent.class.getName());
		assignServiceReference = bundleContext.getServiceReference(IAssign.class.getName());
		subjectServiceReference = bundleContext.getServiceReference(ISubject.class.getName());
//		teacherServiceReference = bundleContext.getServiceReference(ITeacher.class.getName());

		
		studentService = (IStudent) bundleContext.getService(studentServiceReference);
		assignService = (IAssign) bundleContext.getService(assignServiceReference);
		subjectService = (ISubject) bundleContext.getService(subjectServiceReference);

//		teacherService = (ITeacher) bundleContext.getService(teacherServiceReference);
		
		System.out.println("Admin subscriber is started");	
		MainUI frame = new MainUI(studentService, subjectService, assignService, teacherService);
		frame.setVisible(true);
//		MainUI frame = new MainUI(studentService);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		bundleContext.ungetService(studentServiceReference);
		bundleContext.ungetService(assignServiceReference);
		bundleContext.ungetService(studentServiceReference);
		bundleContext.ungetService(teacherServiceReference);
	}

}
