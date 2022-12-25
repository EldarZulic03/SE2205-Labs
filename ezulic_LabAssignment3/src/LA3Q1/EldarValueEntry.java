package LA3Q1;

public class EldarValueEntry {
    private Integer key;

    public EldarValueEntry(){
        key = -1;
    }

    public EldarValueEntry(Integer k){
        this.key = k;
    }

    public void setKey(Integer k){
        this.key = k;
    }

    public Integer getKey(){
        return key;
    }

}
