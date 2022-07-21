package co.com.sofkau.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MongoDBRepository extends ReactiveMongoRepository<CardDocument, String>, ReactiveQueryByExampleExecutor<CardDocument>, ReactiveCrudRepository<CardDocument,String> {
}
