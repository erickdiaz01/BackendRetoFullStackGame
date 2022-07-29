package co.com.sofkau.mongo.player;


import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.model.player.Player;

import co.com.sofkau.model.player.gateways.PlayerRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterPlayer extends AdapterOperations<Player, PlayerDocument, String, MongoDBRepositoryPlayer>
        implements PlayerRepository {

    public MongoRepositoryAdapterPlayer(MongoDBRepositoryPlayer repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Player.class));

    }
    @Override
    public Mono<Player> update(String playerId, Player player) {
        player.setPlayerId(playerId);
        repository.save(new PlayerDocument(player.getPlayerId(), player.getEmail(), player.getGlobalScore(),player.getLocalScore())).toFuture().join();
        return Mono.just(player);
    }


    @Override
    public Mono<Player> addGlobalScore(String playerId, Player player) {
        player.setPlayerId(playerId);
        repository.save(new PlayerDocument(player.getPlayerId(), player.getEmail(), player.getGlobalScore(),player.getLocalScore())).toFuture().join();
         return Mono.just(player);
    }


}
