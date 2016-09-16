


public class OrderedPair<T>{
    
   private final T p1;
   private final T p2;
   
   public OrderedPair(T p1, T p2){
       this.p1 = p1;
       this.p2 = p2;
   }
   
   public T getP1(){
       return this.p1;
   }
   public T getP2(){
       return this.p2;
   }
   
   @Override
   public boolean equals(java.lang.Object object){
       if(!(object instanceof OrderedPair)){
           return false;
       }
       else{
           if(this.p1.equals(((OrderedPair)object).getP1())
           && this.p2.equals(((OrderedPair)object).getP2())){
               return true;
           }
           else{
               return false;
           }
       }
       
   }
   
   
    
}

