package Auxx;

public class Add {
    public static int aux=1;

    public Add(){}

    public static int add(){
        if(aux==29){
            aux=1;
        }
        return aux++;
    }
}
