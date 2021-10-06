package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            League league = new League("MyLeague");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            League league = new League("EmptyLeague");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLeague.json");
            writer.open();
            writer.write(league);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLeague.json");
            league = reader.read();
            assertEquals("EmptyLeague", league.getName());
            assertEquals(0, league.getClubs().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            League league = new League("FixtureLeague");
            assertEquals("FixtureLeague", league.getName());
            assertEquals(0, league.getClubs().size());
            Club c1 = new Club();
            Club c2 = new Club();
            Club c3 = new Club();
            c1.setClubName("Los Angeles Lakers");
            c2.setClubName("Miami Heat");
            c3.setClubName("Boston Celtics");
            Player p1 = new Player("Lebron James", PositionType.SF, 10, 10);
            Player p2 = new Player("Kevin Durant", PositionType.PF, 10, 10);
            Player p3 = new Player("Tim Duncan", PositionType.C, 5, 2);
            generalWorkroom(league, c1, c2, c3, p1, p2, p3);
            JsonWriter writer = new JsonWriter("./data/testWriterFixtureLeague.json");
            writer.open();
            writer.write(league);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterFixtureLeague.json");
            league = reader.read();
            LinkedList<Player> c1Players = new LinkedList<>();
            LinkedList<Player> c2Players = new LinkedList<>();
            c2Players.add(p1);
            LinkedList<Player> c3Players = new LinkedList<>();
            c3Players.add(p2);
            c3Players.add(p3);
            LinkedList<Club> clubs = league.getClubs();
            assertEquals("FixtureLeague", league.getName());
            assertEquals(3, league.getClubs().size());
            checkClubs("Los Angeles Lakers", clubs.get(0), c1Players, 0);
            checkClubs("Miami Heat", clubs.get(1), c2Players, 100);
            checkClubs("Boston Celtics", clubs.get(2), c3Players, 105);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    private void generalWorkroom(League league, Club c1, Club c2, Club c3, Player p1, Player p2, Player p3) {
        c2.getPlayers().add(p1);
        c3.getPlayers().add(p2);
        c3.getPlayers().add(p3);


        league.addClub(c1);
        league.addClub(c2);
        league.addClub(c3);
    }


}
