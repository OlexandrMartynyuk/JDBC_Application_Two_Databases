package dao.models;

public class Television {

	private long id;
	private int size;
	private String vendor, resolution;
	private boolean smarttv;

	public Television(long id, String vendor, int size, String resolution, boolean smarttv) {
		this.id = id;
		this.vendor = vendor;
		this.size = size;
		this.resolution = resolution;
		this.smarttv = smarttv;
	}

	public Television() {
		this.vendor = null;
		this.size = 0;
		this.resolution = null;

	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendor() {
		return vendor;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getResolution() {
		return resolution;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSmartTv(boolean smarttv) {
		this.smarttv = smarttv;
	}
	
	public boolean getSmartTv() {
		return smarttv;
	}
	
}
