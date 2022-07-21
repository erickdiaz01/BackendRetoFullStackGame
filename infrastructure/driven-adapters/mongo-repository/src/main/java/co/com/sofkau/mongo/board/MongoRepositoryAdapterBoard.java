package co.com.sofkau.mongo.board;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Repository
public class MongoRepositoryAdapterBoard extends AdapterOperations<Board, BoardDocument, String, MongoDBRepositoryBoard>
        implements BoardRepository
{

    public MongoRepositoryAdapterBoard(MongoDBRepositoryBoard repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Board.class/* change for domain model */));
    }

    @Override
    public Mono<Board> update(String boardId, Board board) {
        return null;
    }
}
