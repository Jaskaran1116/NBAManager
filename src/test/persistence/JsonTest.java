package persistence;

import model.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {


    protected void checkClubs(String name, Club club, LinkedList<Player> squad, int clubPoints) {
        assertEquals(name, club.getClubName());
        checkPlayers(squad, club.getPlayers());
        assertEquals(clubPoints, club.getAndSetTotalPoints());

    }

    protected void checkPlayer(Player player, String playerName, PositionType positionType,
                               int playerBaskets, int playerAssist) {

        assertEquals(playerName, player.getPlayerName());
        assertEquals(positionType, player.getType());
        assertEquals(playerBaskets, player.getPlayerBasket());
        assertEquals(playerAssist, player.getPlayerAssist());
    }

    private void checkPlayers(LinkedList<Player> playerList1, LinkedList<Player> playerList2) {
        for (int i = 0; i < playerList1.size(); i++) {
            checkPlayer(playerList2.get(i), playerList1.get(i).getPlayerName(), playerList1.get(i).getType(),
                    playerList1.get(i).getPlayerBasket(), playerList1.get(i).getPlayerAssist());
        }
    }


}
