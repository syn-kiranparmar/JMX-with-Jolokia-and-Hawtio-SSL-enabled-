package main;

import static java.lang.System.out;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import jolokia.Region;
import sample.jmx.Hello;

/**
 * Main class for demonstrating Jolokia JVM Agent. This class doesn't really do
 * anything special except "live" in the JVM so that its built-in JMX MXBeans
 * can be accessed by JMX clients.
 */
public class Main
{
   private MBeanServer mbs = null;
   /**
    * Main executable function.
    *
    * @param arguments Command-line arguments: one numeric argument expected.
    */
   public static void main(final String[] arguments)
   {
	  new Main().registerMbean();
      final long numberLoops = arguments.length > 0 ? Long.parseLong(arguments[0]) : 1000000L;
      for (long count = 0; count < numberLoops; ++count)
      {
         if (count % 100 == 0)
         {
            try
            {
               Thread.sleep(10000);
            }
            catch (InterruptedException interruptedEx)
            {
               out.append("Thread's beauty sleep was interrupted.");
            }
         }
      }
   }
   
   private void registerMbean() {
	    mbs = ManagementFactory.getPlatformMBeanServer();
		
		Region regionBean = new Region();
		ObjectName regionName = null;

		try {
			// Uniquely identify the MBeans and register them with the platform
			// MBeanServer
			regionName = new ObjectName("VeriTrans:type=RegionBean");
			mbs.registerMBean(regionBean, regionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
   }
}