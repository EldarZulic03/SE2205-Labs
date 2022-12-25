package Q_LE2;

public class Pair <Y,N>{
    private Y key; //intializing
    private N value; //initializing

    public Pair(Y  key,N value){
        this.key = key;
        this.value = value;
    }//constructor

    public void setKey(Y key) {
        this.key = key;
    }//setter

    public void setValue(N value) {
        this.value = value;
    }//setter

    public Y getKey() {
        return key;
    }//getter

    public N getValue() {
        return value;
    }//getter
}
