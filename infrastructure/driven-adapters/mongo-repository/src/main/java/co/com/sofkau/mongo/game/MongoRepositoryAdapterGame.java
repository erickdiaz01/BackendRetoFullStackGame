package co.com.sofkau.mongo.game;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterGame extends AdapterOperations<Game, GameDocument, String, MongoDbRepositoryGame>
        implements GameRepository  {

    public MongoRepositoryAdapterGame(MongoDbRepositoryGame repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Game.class));
    }


    @Override
    public Mono<Game> addPlayerGame(String gameId, Game game) {
        game.setId(gameId);
        return repository.save(new GameDocument(game.getBoard(),game.getPlayers()))
                .flatMap(elemet->Mono.just(game));
    }

    @Override
    public Mono<Game> winnerGame(String gameId, Game game) {
        game.setId(gameId);
        return repository.save(new GameDocument(game.getBoard(),game.getPlayers()))
                .flatMap(elemet->Mono.just(game));
    }


    @Override
    public Mono<Long> countPlayers(String gameId, Game game) {
        return Mono.just((long) game.getPlayers().size());
    }

    @Override
    public Mono<Game> dealCards(String gameId, Game game) {
        game.setId(gameId);
        return repository.save(new GameDocument(game.getId(),game.getBoard(),game.getPlayers(),game.getIdPlayer(),game.getRound()))
                .flatMap(gameDocument -> Mono.just(game));
    }

    @Override
    public Mono<Game> playerLosed(String gameId, Game game) {
        game.setId(gameId);
        return repository.save(new GameDocument(game.getId(),game.getBoard(),game.getPlayers(),game.getIdPlayer(),game.getRound()))
                .flatMap(gameDocument -> Mono.just(game));
    }
    public Mono<Game> surrenderPlayer(String playerId, Game game, String gameId) {

        game.setId(gameId);
        return repository.
                save(new GameDocument(game.getId(),game.getBoard(), game.getPlayers(), game.getIdPlayer(),game.getRound()))
                .map(gameDocument -> new Game(gameDocument.getId(),gameDocument.getBoard(), gameDocument.getPlayers(), gameDocument.getIdPlayer(),gameDocument.getRound()));
    }
    @Override
    public Mono<CardInGame> selectCard(CardInGame cardInGame) {
        return Mono.just(cardInGame);
    }

    @Override
    public Mono<Game> changeRound(String gameId, Game game) {
        game.setId(gameId);
        repository.save(new GameDocument(game.getId(),game.getBoard(),game.getPlayers(),game.getIdPlayer(),game.getRound())).toFuture().join();
        return Mono.just(game);
    }


    @Override
    public Mono<Game> betCardPlayer(String gameId, Game game) {
        game.setId(gameId);
     return repository.save(new GameDocument(game.getId(),game.getBoard(),game.getPlayers(),game.getIdPlayer(),game.getRound()))
                .flatMap(gameDocument -> Mono.just(game));
    }

    @Override
    public Mono<Game> selectRoudnWinner(String gameId, Game game) {
        game.setId(gameId);
        return repository.save(new GameDocument(game.getId(),game.getBoard(),game.getPlayers(),game.getIdPlayer(),game.getRound()))
                .flatMap(gameDocument -> Mono.just(game));
    }




}

