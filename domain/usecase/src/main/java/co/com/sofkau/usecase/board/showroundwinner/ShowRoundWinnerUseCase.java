package co.com.sofkau.usecase.board.showroundwinner;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ShowRoundWinnerUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> showRoundWinner(String boardId, Board board){


        return boardRepository.showRoundWinner(boardId,board);
    }
}
