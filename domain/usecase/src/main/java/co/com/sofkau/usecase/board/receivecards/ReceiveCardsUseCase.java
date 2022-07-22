package co.com.sofkau.usecase.board.receivecards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ReceiveCardsUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> receiveCards(String boardId,Board board){
        return boardRepository.receiveCards(boardId,board);
    }
}
