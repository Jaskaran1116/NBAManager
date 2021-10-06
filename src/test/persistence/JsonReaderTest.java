package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            League league = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyLeague() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLeague.json");
        try {
            League league = reader.read();
            assertEquals("myLeague", league.getName());
            assertEquals(0, league.getClubs().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralLeague() {
        JsonReader reader = new JsonReader("./data/testReaderLeague.json");
        try {

            League league = reader.read();
            assertEquals("FixtureLeague", league.getName());
            assertEquals(2, league.getClubs().size());

            Player p1 = new Player("Lebron James", PositionType.SF, 10, 10);
            LinkedList<Player> players = new LinkedList<>();
            players.add(p1);

            assertNotNull(league.getPlayer("Lebron James"));
            assertNull(league.getPlayer("Kawai Leonard"));

            LinkedList<Club> clubs = league.getClubs();
            assertNotNull(league.getClub("Los Angeles Lakers"));
            assertNull(league.getClub("Boston Celtics"));

            checkClubs("Los Angeles Lakers", clubs.get(0), new LinkedList<>(), 0);
            checkClubs("Miami Heat", clubs.get(1), players, 100);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}