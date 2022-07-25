package football.player;

public class Player {

    private final String name;
    private final int goal;

    public Player(String name, int goals) {
        this.name = name;
        this.goal = goals;
    }

    public String getName() {
        return name;
    }

    public int getGoal() {
        return goal;
    }
}
