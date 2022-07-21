package co.com.sofkau.mongo;

import co.com.sofkau.model.carta.Carta;
import co.com.sofkau.model.carta.gateways.CartaRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Carta, CardDocument, String, MongoDBRepository>
implements CartaRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
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
