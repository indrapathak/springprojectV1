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
	int frequency;

	public NodeData(int current, int voltage, int pf, int OEE, int frequecy, String nodeId) {
		this.current = current;
		this.voltage = voltage;
		this.frequency = frequency;
		this.OEE = OEE;
		this.pf = pf;
		this.nodeId = nodeId;

	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
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

}
