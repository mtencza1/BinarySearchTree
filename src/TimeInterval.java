



public class TimeInterval extends OrderedPair<Double> implements Comparable<TimeInterval>{

   
    
    
    
    
    
    
    public TimeInterval(Double p1, Double p2) {
        super(p1, p2);
        if(p1>= p2){
            throw new IllegalArgumentException("Not a time interval");
        }
        
    }

    @Override
    public int compareTo(TimeInterval interval) {
        if(this.Interval() > interval.Interval()){
            return 1;
        }
        if(this.Interval() < interval.Interval()){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object o){
        return this.compareTo((TimeInterval)o) == 0;
    }
    public double Interval(){
        return (this.getP2() - this.getP1());
    }
    
    public static TimeInterval fromString(String s){
        char [] c;
        double p1, p2;
        String d1,d2;
        d1 = "";
        d2 = "";
        c = s.toCharArray();
        boolean comma = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ','){
                comma = true;
                continue;
            }
            if(comma == false){
                d1+= s.charAt(i);
            }
            else{
                d2+= s.charAt(i);
            }
        }
        
        p1 = Double.parseDouble(d1);
        p2 = Double.parseDouble(d2);
        
        TimeInterval interval = new TimeInterval(p1, p2);
        
        return interval;
        
    }
    
    @Override
    public String toString(){
        String s = "(";
        s+= Double.toString(this.getP1());
        s+= ',';
        s+= Double.toString(this.getP2());
        s+= ')';
        return s;
        
    }
                
        
    
    
    
}