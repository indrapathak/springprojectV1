package com.SpringBootJavaProject.LearningProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootJavaProject.LearningProject.model.NodeData;
import com.SpringBootJavaProject.LearningProject.repository.NodeDataRepository;

@Service
public class NodeService {
	@Autowired
	private NodeDataRepository nodeRepository;

	public NodeData addNew(NodeData dataValues) {
		System.out.println("the data that is to be added is" + dataValues);
		return nodeRepository.save(dataValues);
	}

	// Retrieve Operation
	public List<NodeData> getAll() {
		return nodeRepository.findAll();
	}

	public NodeData getByNodeId(String nodeId) {
		return nodeRepository.findByNodeId(nodeId);
	}

	public List<NodeData> getListByNodeId(String nodeId) {
		return nodeRepository.findListByNodeId(nodeId);
	}

	// Update operation
	public NodeData update(String nodeId, int pf, int voltage, int OEE, int frequecy, int current) {
		NodeData p = nodeRepository.findByNodeId(nodeId);
		p.setCurrent(current);
		p.setVoltage(voltage);
		p.setFrequecy(frequecy);
		p.setOEE(OEE);
		p.setPf(pf);
		return nodeRepository.save(p);
	}

	public List<NodeData> getListByNodeIdUsingSpringData(String nodeId) {
		// TODO Auto-generated method stub
		return nodeRepository.findByQueryObject(nodeId);
	}

	public List<NodeData> getAggregatedDataValues(String nodeId) {

		return nodeRepository.AggregationQuery(nodeId);
	}

}
