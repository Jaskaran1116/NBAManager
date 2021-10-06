package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlayer {
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    Player p5;

    @BeforeEach
    void setup() {
        p1 = new Player("Lebron James", PositionType.SF, 10,10);
        p2 = new Player("Kevin Durant", PositionType.PF, 8,5);
        p3 = new Player("Stephen Curry", PositionType.SG, 20, 10);
        p4 = new Player("Anthony Davis", PositionType.C, 15, 4);
        p5 = new Player("James Harden", PositionType.PG, 25,10);
    }

    @Test
    void testGetPlayerName() {
        assertEquals("Lebron James", p1.getPlayerName());
        assertEquals("Kevin Durant", p2.getPlayerName());
        assertEquals("Stephen Curry", p3.getPlayerName());
        assertEquals("Anthony Davis", p4.getPlayerName());
        assertEquals("James Harden", p5.getPlayerName());
    }

    @Test
    void testGetPositionType() {
        assertEquals(PositionType.SF, p1.getType());
        assertEquals(PositionType.PF, p2.getType());
        assertEquals(PositionType.SG, p3.getType());
        assertEquals(PositionType.C, p4.getType());
        assertEquals(PositionType.PG, p5.getType());

    }

    @Test
    void testGetBaskets() {
        assertEquals(10, p1.getPlayerBasket());
        assertEquals(8, p2.getPlayerBasket());
        assertEquals(20, p3.getPlayerBasket());
        assertEquals(15, p4.getPlayerBasket());
        assertEquals(25, p5.getPlayerBasket());

    }

    @Test
    void testGetAssists() {
        assertEquals(10, p1.getPlayerAssist());
        assertEquals(5, p2.getPlayerAssist());
        assertEquals(10, p3.getPlayerAssist());
        assertEquals(4, p4.getPlayerAssist());
        assertEquals(10, p5.getPlayerAssist());
    }

    @Test
    void testCalculatePoints() {
        assertEquals(100, p1.calculateFantasyPoints());
        assertEquals(55, p2.calculateFantasyPoints());
        assertEquals(230, p3.calculateFantasyPoints());
        assertEquals(75, p4.calculateFantasyPoints());
        assertEquals(230, p5.calculateFantasyPoints());
    }



}