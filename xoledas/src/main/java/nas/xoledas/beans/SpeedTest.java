package nas.xoledas.beans;

import javax.persistence.*;

@Entity
@Table(name="t_speedtest")
public class SpeedTest {
	
	@Id
    @GeneratedValue
	private Long id;
	private Integer ping;
	private Integer upload;
	private Integer download;
	/**
	 * @param ping
	 * @param upload
	 * @param download
	 */
	public SpeedTest(Integer ping, Integer upload, Integer download) {
		super();
		this.ping = ping;
		this.upload = upload;
		this.download = download;
	}
	/**
	 * @return the ping
	 */
	public Integer getPing() {
		return ping;
	}
	/**
	 * @param ping the ping to set
	 */
	public void setPing(Integer ping) {
		this.ping = ping;
	}
	/**
	 * @return the upload
	 */
	public Integer getUpload() {
		return upload;
	}
	/**
	 * @param upload the upload to set
	 */
	public void setUpload(Integer upload) {
		this.upload = upload;
	}
	/**
	 * @return the download
	 */
	public Integer getDownload() {
		return download;
	}
	/**
	 * @param download the download to set
	 */
	public void setDownload(Integer download) {
		this.download = download;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpeedTest [ping=" + ping + ", upload=" + upload + ", download=" + download + "]";
	}
	
	

}
