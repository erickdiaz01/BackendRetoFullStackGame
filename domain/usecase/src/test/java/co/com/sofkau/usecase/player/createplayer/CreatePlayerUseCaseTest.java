package co.com.sofkau.usecase.player.createplayer;

import co.com.sofkau.model.player.Player;
import co.com.sofkau.model.player.gateways.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;


class CreatePlayerUseCaseTest {

    @InjectMocks
    private CreatePlayerUseCase createPlayerUseCase;

    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);}



    @Test
    void createPlayer() {

        Player player = Player.builder()
                .playerId("1").email("asd@com").build();

        when(playerRepository.save(player)).thenReturn(Mono.just(player));

        StepVerifier.create(createPlayerUseCase.createPlayer(player)).assertNext(playerOne ->{
            Assertions.assertEquals("1",playerOne.getPlayerId());
            Assertions.assertEquals("asd@com",playerOne.getEmail());
        }).expectComplete().verify();
    }




}