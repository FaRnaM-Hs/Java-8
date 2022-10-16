package football.player;

import java.util.List;

public class PlayersWithCups extends Player{

    private final List<String> cups;

    public PlayersWithCups(String name, int goals, List<String> cups) {
        super(name, goals);
        this.cups = cups;
    }

    public List<String> getCups() {
        return cups;
    }
}
