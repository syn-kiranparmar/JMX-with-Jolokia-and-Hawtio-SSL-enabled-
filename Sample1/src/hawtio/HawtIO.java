package hawtio;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import sample.jmx.Hello;

public class HawtIO {
private MBeanServer mbs = null;
	
	public HawtIO(){
		mbs = ManagementFactory.getPlatformMBeanServer();
		
		Hello helloBean = new Hello();
		ObjectName helloName = null;
		
		try{
			// Uniquely identify the MBeans and register them with the platform MBeanServer
	         helloName = new ObjectName("FOO:name=HelloBean");
	         mbs.registerMBean(helloBean, helloName);
		}
		catch(Exception e) {
			
		}
	}
	
	// Utility method: so that the application continues to run
	   private static void waitForEnterPressed() {
	      try {
	         System.out.println("Press  to continue...");
	         System.in.read();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	    }
	   
	   public static void main(String argv[]) {
		   HawtIO agent = new HawtIO();
		   System.out.println("SimpleAgent is running...");
		   agent.waitForEnterPressed();
		   
		  
		   System.out.println("SimpleAgent is running...");
	   }
}
