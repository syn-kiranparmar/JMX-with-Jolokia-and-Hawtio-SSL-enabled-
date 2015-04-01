package jolokia;

public class Region implements RegionMBean{

	@Override
	public String update(String regionName) {
		// TODO Auto-generated method stub
		System.out.println("Region id : " + regionName);
		return regionName + " region refreshed.";
	}

}
