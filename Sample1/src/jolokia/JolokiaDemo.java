package jolokia;

import org.jolokia.client.*;
import org.jolokia.client.request.*;
import org.jolokia.jmx.JolokiaMBeanServerUtil;

import sample.jmx.Hello;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class JolokiaDemo {
	public static void main(String[] args) throws Exception {
        /*J4pClient j4pClient = new J4pClient("http://127.0.0.1:7777/jolokia/");
        J4pReadRequest req = new J4pReadRequest("java.lang:type=Memory",
                                                "HeapMemoryUsage");
        
        J4pReadResponse resp = j4pClient.execute(req);
        Map vals = resp.getValue();
        long used = (Long)vals.get("used");
        long max = (Long)vals.get("max");
        
        int usage = (int) (used * 100 / max);
        System.out.println("Memory usage: used: " + used + 
                           " / max: " + max + " = " + usage + "%");*/
		
		/*J4pClient j4pClient = new J4pClient("http://127.0.0.1:7777/jolokia/");
		J4pSearchRequest searchRequest = new J4pSearchRequest("VeriTrans:*"); 
        J4pSearchResponse searchResponse = j4pClient.execute(searchRequest); 

        List<String> mbeanNames = searchResponse.getMBeanNames(); 

        System.out.println("Size of Mbean list = " + mbeanNames.size() + "\n"); 

        for (String mbean: mbeanNames) 
        { 
            if(mbean.equalsIgnoreCase("VeriTrans:type=RegionBean")) {
            	J4pExecRequest execReq = new J4pExecRequest("VeriTrans:type=RegionBean", "update", "Rim"); 
            	j4pClient.execute(execReq);
            }
        }*/
		
		J4pClient j4pClient = new J4pClient("http://127.0.0.1:7777/jolokia/");
		J4pExecRequest execReq = new J4pExecRequest("VeriTrans:type=RegionBean", "update", "Rim"); 
    	j4pClient.execute(execReq);
    }

	public JolokiaDemo() {
		
	}
}