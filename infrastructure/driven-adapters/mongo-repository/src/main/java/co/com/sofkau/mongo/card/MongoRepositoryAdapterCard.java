package co.com.sofkau.mongo.card;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterCard extends AdapterOperations<Card, CardDocument, String, MongoDBRepositoryCard>
implements CardRepository
{

    public MongoRepositoryAdapterCard(MongoDBRepositoryCard repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Card.class));
    }

    @Override
    public Mono<Card> update(String idCard, Card card) {
        //TODO
        return null;
    }
}
