package adminsubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	
	public void start(BundleContext bundleContext) throws Exception {
		
		MainUI frame = new MainUI();
		frame.setVisible(true);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
