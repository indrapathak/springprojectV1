package com.SpringBootJavaProject.LearningProject.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.SpringBootJavaProject.LearningProject.model.NodeData;

public class NodeDataRepositoryImpl implements QueryInterfaceRepository {
	private MongoOperations operations;
	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	public void QueryInterfaceRepository(MongoOperations operations) {

		this.operations = operations;
	}

	@Override
	public List<NodeData> findByQueryObject(String nodeId) {

		System.out.println(" NODE ID is  " + nodeId);

		LocalDate calDate = LocalDate.parse("2020-09-07");
		LocalDateTime startDate = calDate.atStartOfDay();
		LocalDateTime endDate = calDate.plusDays(1).atStartOfDay();
		System.out.println("The start and end dates are " + startDate + "  " + endDate);
		Query query = new Query(Criteria.where("nodeId").is(nodeId));

		return operations.find(query, NodeData.class);

	}

	@Override
	public List<NodeData> AggregationQuery(String nodeId) {

		System.out.println(" NODE ID is  " + nodeId);
////////// Query is not agrregate query it is for testing all these and it is working
		Query query = new Query().addCriteria(Criteria.where("current").gt(2).and("nodeId").is("abc123"))
				.with(Sort.by("ascending", "current")).limit(20);
		System.out.println("the query output is " + query);
		return mongoTemplate.find(query, NodeData.class);
////////////////////////////////////////////////////////////////////////////////////////

//		Aggregation aggregation = Aggregation
//				.newAggregation(Aggregation.group("nodeId").sum("current").as("totalCurrent"));
//
//		AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "NodeData", NodeData.class);
//
//		System.out.println("the data from the aggregation query is " + results);

		//////////////////////////////////////////////

//		Aggregation aggregation = newAggregation(Criteria.where("nodeId").is(nodeId)),
//				group("nodId").sum("current", "voltage", "OEE").as("totalCurrent", "totalVoltage", "totalOEE"));
//		AggregationResults<NodeData> groupResults = operations.aggregate(aggregation, NodeData.class);

//		Aggregation agg = newAggregation(match(Criteria.where("nodeId").is("abc123")),
//				group("nodeId").sum("current").as("totalCurrent"), project("totalCurrent")	);
//
//		// Convert the aggregation result into a List
//		AggregationResults<NodeData> data = mongoTemplate.aggregate(agg, NodeData.class);
//		List<NodeData> result = data ;
//		List<NodeData> result = groupResults.getMappedResults();

	}

}
