package co.com.sofkau.mongo.board;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MongoDBRepositoryBoard extends ReactiveMongoRepository<BoardDocument, String>, ReactiveQueryByExampleExecutor<BoardDocument>, ReactiveCrudRepository<BoardDocument,String> {
}
