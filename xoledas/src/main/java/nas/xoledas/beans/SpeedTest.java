package nas.xoledas.beans;

import java.util.Date;

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
	private Date dateTest;
	
	public SpeedTest() {
		super();
	}
	/**
	 * @param ping
	 * @param upload
	 * @param download
	 */
	public SpeedTest(Integer ping, Integer upload, Integer download, Date dt) {
		super();
		this.ping = ping;
		this.upload = upload;
		this.download = download;
		this.dateTest = dt;
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
	@Override
	public String toString() {
		return "SpeedTest [id=" + id + ", ping=" + ping + ", upload=" + upload + ", download=" + download
				+ ", dateTest=" + dateTest + "]";
	}
	/**
	 * @return the dateTest
	 */
	public Date getDateTest() {
		return dateTest;
	}
	/**
	 * @param dateTest the dateTest to set
	 */
	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}
	
	

}
