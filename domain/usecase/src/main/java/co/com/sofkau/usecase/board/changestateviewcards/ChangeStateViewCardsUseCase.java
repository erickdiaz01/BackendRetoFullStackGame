package co.com.sofkau.usecase.board.changestateviewcards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.usecase.game.findbyid.FindGameByIdUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


/**
 * En este caso de uso se cambia el estado de 'viewed' de todas las cardsInGame que estan en el tablero, para que
 * asi se puedan mostrar desde el front y comparar los poderes de cada una y asi saber el ganador
 *
 */
@RequiredArgsConstructor
public class ChangeStateViewCardsUseCase {
    private final BoardRepository boardRepository;
    private final FindGameByIdUseCase findGameByIdUseCase;

    /**
     * Metodo que recibe por parametros el id del tablero a recorrer y el tablero en si. Se recorre
     * la lista de cartas en juego y se les cambia el estado a cada una a true
     * @param boardId {String}
     * @param board {Board}
     * @return {Mono<Board>}
     */
    public Mono<Board> changeStateViewOfCards(String boardId, Board board){

         board.getCardsInGame().stream().forEach(cardInGame -> cardInGame.setViewed(!cardInGame.isViewed()));

        return boardRepository.changeStateViewCards(boardId,board);
    }
}
