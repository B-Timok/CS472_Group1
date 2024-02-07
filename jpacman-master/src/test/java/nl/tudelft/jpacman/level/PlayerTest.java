package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;
import nl.tudelft.jpacman.board.Unit;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void testIsAlive() {
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);
        Player player = playerFactory.createPacMan();

        assertThat(player.isAlive()).isTrue();
    }

    @Test
    void testGetKiller() {
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);
        Player player = playerFactory.createPacMan();
        Player killer = playerFactory.createPacMan();
        player.setKiller(killer);
        assertThat(player.getKiller()).isEqualTo(killer);
    }
    
    @Test
    void testSetKiller() {
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);
        Player player = playerFactory.createPacMan();
        Player killer = playerFactory.createPacMan();
        player.setKiller(killer);
        assertThat(player.getKiller()).isEqualTo(killer);
    }
}
