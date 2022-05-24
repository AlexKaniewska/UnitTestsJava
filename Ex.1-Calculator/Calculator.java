public class Calculator {
    private int state = 0;

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void add(int value){
        state += value;
    }
    public void mult(int value){
        state *= value;
    }
    public void subtraction(int value) {
        state -= value;
    }
    public void division(int value) {
        if (value == 0) {
            throw new ArithmeticException("You cannot divide by zero");
        }
        else {
            state /= value;
        }
    }
}