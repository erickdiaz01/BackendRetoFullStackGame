package co.com.sofkau.usecase.game.dealcards;

import co.com.sofkau.model.objectvalues.CardInGame;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.gateways.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Caso de uso que realiza la reparticion de las cartas una vez se cumple con un minimo de jugadores
 * para empezar a jugar y apostar las cartas
 */
@RequiredArgsConstructor
public class DealCardsUseCase {
    private final GameRepository gameRepository;

    /**
     * Metodo que obtiene por parametros el ID del juego y el juego en donde esta alojado el tablero para
     * que el tablero con su mazo principal desordene las cartas e inyecte 5 cartas a cada jugador que esta en el
     * juego
     * @param gameId {String}
     * @param game {Game}
     * @return {Mono<Game>}
     */
    public Mono<Game> dealCards(String gameId, Game game){

        game.getPlayers().stream().forEach(player -> {
            var barajaASortear = new ArrayList<Card>();
            barajaASortear.addAll(game.getBoard().getPrincipalMallet());
            Collections.shuffle(barajaASortear);
           var cardsPlayer=barajaASortear.stream().limit(5).map(card -> {
                        game.getBoard().getPrincipalMallet().remove(card);
                       return  new CardInGame(player.getPlayerId(),card);
                    }
            ).collect(Collectors.toSet());
            player.setCards(cardsPlayer);
        });
        return gameRepository.dealCards(gameId,game);
    }
}
