package co.com.sofkau.mongo.player;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MongoDBRepositoryPlayer extends ReactiveMongoRepository<PlayerDocument, String>, ReactiveQueryByExampleExecutor<PlayerDocument>, ReactiveCrudRepository<PlayerDocument,String> {
}

