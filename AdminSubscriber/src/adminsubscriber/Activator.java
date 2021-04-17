package adminsubscriber;

import assignpublisher.IAssign;
import org.omg.PortableServer.IdAssignmentPolicy;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private ServiceReference<?> assignServiceReference;
	
	private IAssign assignService;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		assignServiceReference = bundleContext.getServiceReference(IAssign.class.getName());
		
		assignService = (IAssign) bundleContext.getService(assignServiceReference);
		
		MainUI frame = new MainUI();
		frame.setVisible(true);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		bundleContext.ungetService(assignServiceReference);
	}

}
