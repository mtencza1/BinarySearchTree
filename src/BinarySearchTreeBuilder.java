


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BinarySearchTreeBuilder {
        
    public static void main(String[] args) {
        
        BinarySearchTree<TimeInterval> intervalTree = new BinarySearchTree<>();
        
        Scanner scanner = new Scanner(System.in);
        Set<TimeInterval> timeIntervals = new HashSet<>();
        
        String line2;
        System.out.println("Type 'Tree:' and enter the points on the same line");
                
        
        line2 = scanner.nextLine();
        if (line2.startsWith("Tree: ")) {
            Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(line2);
            while (matcher.find())
                timeIntervals.add(TimeInterval.fromString(matcher.group()));
            }
            timeIntervals.forEach(intervalTree::add);
            intervalTree.print();
            
        
        for (String line = ""; !line.equals("done"); line = scanner.nextLine()) {
            
           
            System.out.println("What would you like to do?");
            System.out.println("(i) add, (ii) remove, (iii) search, (iv) print");
            
            if(line.startsWith("add")){
                Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(line);
                while (matcher.find())
                   intervalTree.add(TimeInterval.fromString(matcher.group()));
                
            }
            else if(line.startsWith("remove")){
                Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(line);
                while (matcher.find())
                   intervalTree.remove(TimeInterval.fromString(matcher.group()));
            }
            else if(line.startsWith("search")){
                Matcher matcher = Pattern.compile("([0-9.]+,[0-9.]+)").matcher(line);
                while (matcher.find())
                   intervalTree.find(TimeInterval.fromString(matcher.group()));
            }
            else if(line.startsWith("print")){
                intervalTree.print();
            }
            
            intervalTree.print();
        }
            
        
        
            
         
        
        
    }
}