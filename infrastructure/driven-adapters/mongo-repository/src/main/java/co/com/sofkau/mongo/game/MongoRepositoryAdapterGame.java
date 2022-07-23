package co.com.sofkau.mongo.game;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.player.Player;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Repository
public class MongoRepositoryAdapterGame extends AdapterOperations<Game, GameDocument, String, MongoDbRepositoryGame>
        implements GameRepository  {

    public MongoRepositoryAdapterGame(MongoDbRepositoryGame repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Game.class));
    }


    @Override
    public Mono<Game> addPlayerGame(String id, Game game) {
        game.setId(id);
        return repository.save(new GameDocument(game.getBoard(),game.getPlayers()))
                .flatMap(elemet->Mono.just(game));
    }

    @Override
    public Flux<Card> assingDeck(Set<Card> card) {
        return null;
    }

    @Override
    public Mono<Player> Winner(String id) {
        return null;
    }

    @Override
    public Mono<Long> countPlayers(String gameId, Game game) {
        return Mono.just(game.getPlayers().stream().count());
    }
}

