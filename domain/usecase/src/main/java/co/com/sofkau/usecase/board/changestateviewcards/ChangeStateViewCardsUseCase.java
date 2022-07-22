package co.com.sofkau.usecase.board.changestateviewcards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ChangeStateViewCardsUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> changeStateViewOfCards(String boardId, Board board){
        return boardRepository.changeStateViewCards(boardId,board);
    }
}
