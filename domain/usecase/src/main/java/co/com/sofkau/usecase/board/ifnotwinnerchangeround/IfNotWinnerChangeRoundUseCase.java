package co.com.sofkau.usecase.board.ifnotwinnerchangeround;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class IfNotWinnerChangeRoundUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> ifNotWinnerChangeRound(String boardId, Board board){
        return boardRepository.ifNotWinnerChangeRound(boardId,board);
    }
}
