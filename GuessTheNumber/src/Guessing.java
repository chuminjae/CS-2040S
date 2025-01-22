public class Guessing {

    // Your local variables here
    private int low = 0;
    private int high = 1000;

    /**
     * Implement how your algorithm should make a guess here
     */
    public int guess(){
        return (low+high) / 2;
    }
    public void update(int answer){
        if(answer == 1){
            this.high = (low + high) / 2 - 1;
        }
        else if(answer == -1){
            this.low = (low + high) / 2 + 1;
        }
    }
}
