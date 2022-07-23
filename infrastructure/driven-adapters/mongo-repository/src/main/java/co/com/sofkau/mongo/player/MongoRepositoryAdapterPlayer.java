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
        return null;
    }

    @Override
    public Mono<Player> assignCardToPlayer(String playerId, Player player) {
        return null;
    }


    public Mono <Player> surrenderPlayer(String playerId, Player player){
        player.setPlayerId(playerId);
        return repository
                .save(new PlayerDocument(player.getPlayerId(), player.getEmail(), player.getGlobalScore(),player.getLocalScore(),player.getCards()))
                .flatMap(p -> Mono.just(player));
    }




}
