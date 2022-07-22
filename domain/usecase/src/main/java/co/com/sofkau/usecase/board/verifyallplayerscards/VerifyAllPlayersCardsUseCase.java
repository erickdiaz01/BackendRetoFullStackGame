package co.com.sofkau.usecase.board.verifyallplayerscards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class VerifyAllPlayersCardsUseCase {
    private final BoardRepository boardRepository;

//TODO
    public Mono<Board> verifyAllplayersCards(String boardId,Board board){
        return boardRepository.verifyAllPlayersCards(boardId,board);
    }
}
