package com.SpringBootJavaProject.LearningProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.SpringBootJavaProject.LearningProject.model.NodeData;

public class NodeDataRepositoryImpl implements QueryInterfaceRepository {
	private MongoOperations operations;

	@Autowired
	public void QueryInterfaceRepository(MongoOperations operations) {

		this.operations = operations;
	}

	@Override
	public List<NodeData> findByQueryObject(String nodeId) {

		System.out.println(" NODE ID is  " + nodeId);
//		LocalDate calDate = LocalDate.parse(date);
//		LocalDateTime startDate = calDate.atStartOfDay();
//		LocalDateTime endDate = calDate.plusDays(1).atStartOfDay();
		Query query = new Query(Criteria.where("nodeId").is(nodeId));

		return operations.find(query, NodeData.class);

	}

//	@Override
//	public List<NodeData> AggregationQuery(String nodeId) {
//
//		System.out.println(" NODE ID is  " + nodeId);
//
//		// Query query = new Query(Criteria.where("nodeId").is(nodeId));
//		Aggregation aggregation = newAggregation(match(Criteria.where("nodeId").is(nodeId)),
//				group("company").sum("current", "voltage", "OEE").as("totalCurrent", "totalVoltage", "totalOEE"));
//
//		AggregationResults<NodeData> groupResults = operations.aggregate(aggregation, NodeData.class);
//
//		// return operations.find(query, NodeData.class);
//
//	}

}
