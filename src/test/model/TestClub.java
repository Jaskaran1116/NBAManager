package model;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClub {
    Club c1;
    Club c2;
    Club c3;

    Player p1;
    Player p2;
    Player p3;
    Player p4;
    Player p5;
    Player p6;
    Player p7;
    Player p8;
    Player p9;
    Set<String> playerNameList;


    int clubPoints;

    @BeforeEach
    void setup() {
        p1 = new Player("Lebron James", PositionType.SF, 10,10);
        p2 = new Player("Kevin Durant", PositionType.PF, 8,5);
        p3 = new Player("Stephen Curry", PositionType.SG, 20, 10);
        p4 = new Player("Anthony Davis", PositionType.C, 15, 4);
        p5 = new Player("James Harden", PositionType.PG, 25,10);
        p6 = new Player("Blake Griffin", PositionType.PF, 12,8);
        p7 = new Player("Klay Thompson", PositionType.SG, 19,10);
        p8 = new Player("Kyrie Irving", PositionType.PG, 20,14);
        p9 = new Player("Tim Duncan", PositionType.C, 14,7);

        c1 = new Club();
        c2 = new Club();
        c3 = new Club();
        playerNameList = new HashSet<>();

        clubPoints = 0;

    }


    @Test
    void testGetAndSetNameOfClub() {
        c1.setClubName("Miami Heats");
        c2.setClubName("Los Angeles Lakers");
        c3.setClubName("Brooklyn Nets");
        assertEquals("Miami Heats", c1.getClubName() );
        assertEquals("Los Angeles Lakers", c2.getClubName());
        assertEquals("Brooklyn Nets", c3.getClubName());
    }



    @Test
    void testSizeOfSquad() {
        try {
            c1.addPlayer(p1);
            c1.addPlayer(p2);
            c1.addPlayer(p3);
            c1.addPlayer(p4);
            c1.addPlayer(p5);
            c1.addPlayer(p6);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        assertEquals(6, c1.squadSize());

    }

    @Test
    void testForAddPlayer() {
        try {
            c1.addPlayer(p1);
            c1.addPlayer(p2);
            c1.addPlayer(p3);
            c1.addPlayer(p4);
            c1.addPlayer(p5);
            c1.addPlayer(p6);
            assertEquals(6, c1.squadSize());
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        try {
            c1.addPlayer(p7);
            fail("Should have thrown ClubFullException");
        } catch (ClubFullException e) {
            //Do nothing
        }
        assertEquals(6, c1.squadSize());
    }

    @Test
    void testForGetPlayer() {
        try {
            c1.addPlayer(p1);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        try {
            c1.addPlayer(p2);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        assertEquals(p1, c1.getPlayer("Lebron James"));
        assertEquals(p2, c1.getPlayer("Kevin Durant"));
    }

    @Test
    void testForGetPlayerNames() {
        assertTrue(c1.getPlayerNames().isEmpty());

        try {
            c2.addPlayer(p2);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        try {
            c2.addPlayer(p3);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }

        assertTrue(c2.getPlayerNames().contains("Kevin Durant"));
        assertTrue(c2.getPlayerNames().contains("Stephen Curry"));
    }

    @Test
    void testForTotalClubPoints() {
        assertEquals(c1.getAndSetTotalPoints(), 0);

        try {
            c2.addPlayer(p1);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        try {
            c2.addPlayer(p2);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }

        clubPoints = p1.calculateFantasyPoints() + p2.calculateFantasyPoints();
        assertEquals(c2.getAndSetTotalPoints(), clubPoints);

        try {
            c3.addPlayer(p5);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        try {
            c3.addPlayer(p6);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
        try {
            c3.addPlayer(p7);
        } catch (ClubFullException e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }

        clubPoints = p5.calculateFantasyPoints() + p6.calculateFantasyPoints() + p7.calculateFantasyPoints();
        assertEquals(c3.getAndSetTotalPoints(), clubPoints);

    }

}
