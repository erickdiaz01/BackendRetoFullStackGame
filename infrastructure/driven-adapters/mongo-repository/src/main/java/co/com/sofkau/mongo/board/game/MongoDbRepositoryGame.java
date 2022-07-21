package co.com.sofkau.mongo.board.game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MongoDbRepositoryGame extends ReactiveMongoRepository<GameDocument, String>, ReactiveQueryByExampleExecutor<GameDocument>, ReactiveCrudRepository<GameDocument,String> {
}
