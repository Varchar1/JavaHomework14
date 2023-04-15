import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void TestWhenFirstPlayerWin() {
        Player player1 = new Player(1, "Иван", 100);
        Player player2 = new Player(12, "Антон", 80);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Иван", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestWhenSecondPlayerWin() {
        Player player1 = new Player(12, "Антон", 80);
        Player player2 = new Player(1, "Иван", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Антон", "Иван");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestWhenDraw() {
        Player player1 = new Player(12, "Антон", 100);
        Player player2 = new Player(1, "Иван", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Антон", "Иван");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestWhenFirstPlayerNotRegistered() {
        Player player1 = new Player(12, "Антон", 80);
        Player player2 = new Player(1, "Иван", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Дмитрий", "Иван");
        });
    }

    @Test
    public void TestWhenSecondPlayerNotRegistered() {
        Player player1 = new Player(12, "Антон", 80);
        Player player2 = new Player(1, "Иван", 100);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Антон", "Дмитрий");
        });
    }
}
