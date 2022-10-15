public class Jumper {
    Coordinates start;
    Coordinates end;
    String name;

    public Jumper(Coordinates start,Coordinates end){
        this.start = start;
        this.end = end;

        if(start.row_number > end.row_number){
            this.name = "ladder";
        }
        else{
            this.name = "Snake";
        }
    }
}
