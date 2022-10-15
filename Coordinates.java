public class Coordinates {
    int row_number;
    int col_number;

    Coordinates(int row_number,int col_number){
        this.row_number = row_number;
        this.col_number = col_number;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("["+row_number+","+col_number+"]");
        return sb.toString();
    }
}
