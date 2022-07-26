package co.com.sofkau.usecase.board.changestateviewcards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.objectvalues.CardInGame;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;



@RequiredArgsConstructor
public class ChangeStateViewCardsUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> changeStateViewOfCards(String boardId, Board board){
         /*board.getCardsInGame().entrySet()
                .stream()
                .map(stringCardInGameEntry ->
                board.getCardsInGame()
                        .put(stringCardInGameEntry.getKey(),new CardInGame(stringCardInGameEntry.getValue().getCard(),stringCardInGameEntry.getValue().isViewed()==true?false:true))
                );*/
        board.getCardsInGame().forEach((s, cardInGame) -> {

               board.getCardsInGame().put(s,new CardInGame(cardInGame.getCard(), true));
            if(cardInGame.isViewed()==true){
                cardInGame.setViewed(false);
            }else {
                cardInGame.setViewed(true);
            }
               board.getCardsInGame().put(s,cardInGame);
        });

        return boardRepository.changeStateViewCards(boardId,board);
    }
}
