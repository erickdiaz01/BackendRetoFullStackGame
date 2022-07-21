package co.com.sofkau.mongo.board.game;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterGame extends AdapterOperations<Game, GameDocument, String, MongoDbRepositoryGame>
        implements GameRepository {

    public MongoRepositoryAdapterGame(MongoDbRepositoryGame repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Game.class));

    }

    @Override
    public Mono<Player> addPlayer(Player player) {
        return null;
    }

    @Override
    public Mono<Player> Winner(String id) {
        return null;
    }
}

