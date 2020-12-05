import java.time.LocalDate;

public class Beers extends Drinks {
    protected float degree;
    public Beers(String m, double p, LocalDate L,float d){
        super(m,p,L,30);
        degree=d;
    }
    public Beers(String m,float d){
        name=m;
        degree=d;
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Beers)){
            return false;
        }
        else{
            return ((Beers) obj).name.equals(this.name) &&((Beers) obj).degree==this.degree;
            //度数不一样的酒可不能混在一起
        }
    }
}
