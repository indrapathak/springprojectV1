package com.SpringBootJavaProject.LearningProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NodeData {
	@Id
	String id;
	String nodeId;
	int current;
	int voltage;
	int pf;
	int OEE;
//	int frequecy;

	public NodeData(int current, int voltage, int pf, int OEE, int frequecy, String nodeId) {
		this.current = current;
		this.voltage = voltage;
		// this.frequecy = frequecy;
		this.OEE = OEE;
		this.pf = pf;
		this.nodeId = nodeId;

	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getOEE() {
		return OEE;
	}

	public void setOEE(int OEE) {
		OEE = this.OEE;
	}

//	public int getFrequecy() {
//		return frequecy;
//	}
//
//	public void setFrequecy(int frequecy) {
//		this.frequecy = frequecy;
//	}
}
