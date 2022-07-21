package co.com.sofkau.usecase.board.selectwinnercard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SelectWinnerCardUseCase {
    private final BoardRepository boardRepository;

    public Mono<Board> selectWinnerCard(String boardId,Board board){
        return boardRepository.selectWinnerCard(boardId,board);
    }

}
