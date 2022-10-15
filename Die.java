public class Die {
    public static int roll(){
        int MIN = 1,MAX = 6;
        double r = (Math.random() * (MAX-MIN) + MIN);
        return (int)r;
    }    
}
