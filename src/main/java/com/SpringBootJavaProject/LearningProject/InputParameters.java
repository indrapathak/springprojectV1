package com.SpringBootJavaProject.LearningProject;

import java.time.LocalDateTime;

public class InputParameters {
	private String nodeId;
	private String id;
	private int current;
	private int voltage;
	private int pf;
	private int OEE;
	private int frequency;

	private LocalDateTime timestamp;

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

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getNodeIdValue() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

}
