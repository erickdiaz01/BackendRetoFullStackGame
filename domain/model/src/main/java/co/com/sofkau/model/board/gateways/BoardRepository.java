package co.com.sofkau.model.board.gateways;

import co.com.sofkau.model.board.Board;
import reactor.core.publisher.Mono;

public interface BoardRepository {
    Mono<Board> save(Board board);
    Mono<Board> findById(String boardId);
    Mono<Board> update(String boardId,Board board);
    Mono<Void> deleteById(String boardId);
    Mono<Board> changeStateViewCards(String boardId,Board board);
    Mono<Board> ifNotWinnerChangeRound (String boardId,Board board);
    Mono<Board> selectWinnerCard(String boardId,Board board);
    Mono<Board> receiveCards(String boardId,Board board);
    Mono<Board>receiveCardsOfLeftPlayer(String boardId,Board board);
    Mono<Board> showRoundWinner(String boardId,Board board);
}
