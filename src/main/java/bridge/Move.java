package bridge;

public enum Move {
    NONE(0, " "),
    POSSIBLE(1, "O"),
    IMPOSSIBLE(2, "X");

    private final int number;
    private final String result;

    Move(int number, String result) {
        this.number = number;
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public int getNumber(){
        return number;
    }

    public static Move findMove(boolean canMove){
        if(canMove){
            return POSSIBLE;
        }
        return IMPOSSIBLE;
    }
}