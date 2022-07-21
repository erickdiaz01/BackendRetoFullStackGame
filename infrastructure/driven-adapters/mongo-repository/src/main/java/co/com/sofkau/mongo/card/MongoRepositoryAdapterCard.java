package co.com.sofkau.mongo.card;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterCard extends AdapterOperations<Carta, CardDocument, String, MongoDBRepositoryCard>
implements CartaRepository
{

    public MongoRepositoryAdapterCard(MongoDBRepositoryCard repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Carta.class/* change for domain model */));
    }

    @Override
    public Mono<Carta> update(String idCard, Carta card) {
        //TODO
        return null;
    }
}
