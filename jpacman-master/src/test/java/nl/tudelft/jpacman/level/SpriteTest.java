package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpriteTest {
    @Test
    void testGetSprite() {
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);
        Player player = playerFactory.createPacMan();

        assertThat(player.getSprite()).isNotNull();
    }
}
