package co.com.sofkau.usecase.board.createboard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;


import co.com.sofkau.model.card.Card;
import co.com.sofkau.usecase.card.findallcards.FindAllCardsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

class CreateBoardUseCaseTest {
    @InjectMocks
    private CreateBoardUseCase createBoardUseCase;
    private FindAllCardsUseCase findAllCardsUseCase;

    @Mock
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);}



    @Test
    void createBoard() {

        Board board = Board.builder()
                .boardId("10").principalMallet(Set.of(
                        new Card("108", "The Hulk", "PowerFull", "/img/cards/108.jpg",216))).build();

        when(boardRepository.save(board)).thenReturn(Mono.just(board));

        StepVerifier.create(createBoardUseCase.createBoard(board)).assertNext(boardTen ->{
            Assertions.assertEquals(1, boardTen.getPrincipalMallet().size());


        }).expectComplete().verify();
    }




}