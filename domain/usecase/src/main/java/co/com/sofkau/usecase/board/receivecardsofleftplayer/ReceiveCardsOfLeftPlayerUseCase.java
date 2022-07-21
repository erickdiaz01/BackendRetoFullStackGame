package co.com.sofkau.usecase.board.receivecardsofleftplayer;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ReceiveCardsOfLeftPlayerUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> receiveCardsOfLeftPlayer(String boardId, Board board){
        return boardRepository.receiveCardsOfLeftPlayer(boardId,board);
    }
}
