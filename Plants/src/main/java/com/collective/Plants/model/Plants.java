package com.collective.Plants.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANTDET")
public class Plants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seqgen;
	@Column(name = "year")
	private String year;
	@Column(name = "plant")
	private String plant;
	@Column(name = "plantname")
	private String plantname;
	@Column(name = "genid")
	private String genid;
	@Column(name = "genstat")
	private String genstat;
	@Column(name = "genntan")
	private String genntan;
	
	
	public Plants(String year, String plant, String plantname, String genid, String genstat,
			String genntan, boolean b) {
		super();
		this.year = year;
		this.plant = plant;
		this.plantname = plantname;
		this.genid = genid;
		this.genstat = genstat;
		this.genntan = genntan;
	}
	
	public Plants() {
	}
	public long getSeqgen() {
		return seqgen;
	}
	public void setSeqgen(long seqgen) {
		this.seqgen = seqgen;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getPlantname() {
		return plantname;
	}
	public void setPlantname(String plantname) {
		this.plantname = plantname;
	}
	public String getGenid() {
		return genid;
	}
	public void setGenid(String genid) {
		this.genid = genid;
	}
	public String getGenstat() {
		return genstat;
	}
	public void setGenstat(String genstat) {
		this.genstat = genstat;
	}
	public String getGenntan() {
		return genntan;
	}
	public void setGenntan(String genntan) {
		this.genntan = genntan;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Plants [seqgen=").append(seqgen).append(", year=").append(year).append(", plant=").append(plant)
				.append(", plantname=").append(plantname).append(", genid=").append(genid).append(", genstat=")
				.append(genstat).append(", genntan=").append(genntan).append("]");
		return builder.toString();
	}
	
	
	
	
	

}
