package com.SpringBootJavaProject.LearningProject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootJavaProject.LearningProject.model.NodeData;

@Repository
public interface NodeDataRepository extends MongoRepository<NodeData, String>, QueryInterfaceRepository {

//	@Autowired
//	QueryInterfaceRepository queryInterfaceRepository;

	// static MongoTemplate mongTemplate;

	public NodeData findByNodeId(String nodeId);

	public List<NodeData> findByCurrent(int current);

	public List<NodeData> findListByNodeId(String nodeId);

////	@Override
////	List<NodeData> findByQueryObject(String nodeId);
//
//	public List<NodeData> findByQueryObject(String nodeId) {
//
////		Query query = new Query(Criteria.where("nodeId").is(nodeId));
////
////		List<NodeData> data = mongTemplate.find(query, NodeData.class);
//
//		return queryInterfaceRepository.findByQueryObject(nodeId);
//	}

}
