






public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T>{

    
    
    
    private BinaryTreeNode<T> rootNode;
    private int size;
    
    
   
    
    @Override
    public void add(T element) {
        if(rootNode == null){
            BinaryTreeNode newRoot = new BinaryTreeNode(element);
            rootNode = newRoot;
            size++;
        }
        else{
            BinaryTreeNode temp = new BinaryTreeNode(element);
            add(element, rootNode);
            size++;
            
               
            
            
        }
                
    }
    public BinaryTreeNode add(T element, BinaryTreeNode current){
        if(current == null){
          BinaryTreeNode b = new BinaryTreeNode(element);
          
            return b;
        }
        else{
            if(lessThan(element, current) ){
                current.setLeft(add(element, current.getLeft()));
                (add(element, current.getLeft())).setParent(current);
            }
            if( (element.compareTo((T)(current.getData()))) > 0 ){
                current.setRight(add(element, current.getRight()));
                (add(element, current.getRight())).setParent(current);
            }
            return current;
        }
        
    }
    public boolean lessThan(T element, BinaryTreeNode b){
        if(( element.compareTo((T)(b.getData()))) < 0  ){
            return true;
        }
        else{
            return false;
        }
    }
    public  boolean lessThan(BinaryTreeNode a,BinaryTreeNode  b){
        if(( ((T)(a.getData())).compareTo((T)(b.getData()))) < 0  ){
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean isLeaf(BinaryTreeNode b){
        if(b.getLeft() == null && b.getRight() == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public void remove(T element) {
        BinaryTreeNode current = 
                find(element);
       
        if(isLeaf(current)){
            if(current.equals(current.getParent().getLeft())){
                current.getParent().setLeft(null);
            }
            else{
                current.getParent().setRight(null);
            }
        }
        // if it has 1 child
        if((current.getLeft() == null && current.getRight()!= null ) ||
           (current.getLeft() != null && current.getRight() == null) ){
           // if its the parents left child
            if(current.equals(current.getParent().getLeft())){
                //if the node has a left child
                if(current.getLeft() != null){
                   current.getParent().setLeft(current.getLeft()); 
                }
                else{
                    current.getParent().setLeft(current.getRight());
                }
            }
            //if its parents right child
            else{
                //if node has a right child
                if(current.getRight() != null){
                    current.getParent().setRight(current.getRight());
                }
                else{
                    current.getParent().setRight(current.getLeft());
                }
                
            }
        }
        
        //two children
        if(current.getLeft() != null && current.getRight()!= null){
            
            BinaryTreeNode min = findMin(current.getRight());
            T minData = (T)min.getData();
            current.setData(minData);
            if(min.getRight() != null){
                current.setRight(min.getRight());
            }
            else{
                current.setRight(min.getLeft());
            }
            
        }
        
        
        
        
    }

    @Override
    public BinaryTreeNode find(T element) {
        return find(element,rootNode);
    }
    public BinaryTreeNode find(T element, BinaryTreeNode current ){
     
        if(current == null || element.equals(current.getData())){
            
            return current;
        }
        if(element.compareTo((T)current.getData()) < 0){
            return find(element,current.getLeft());
        }
        else{
            return find(element,current.getRight());
        }
        
    }
    public BinaryTreeNode findMin(){
        return findMin(rootNode);
    }
    public BinaryTreeNode findMin(BinaryTreeNode min){
        if(min.getLeft() != null){
                min = min.getLeft();
              return findMin(min);
            }
        else{
            return min;
        }
         
    }

   
    public void print() {
        rootNode.print();
    }
    
    
    public BinaryTreeNode getRoot(){
        return rootNode;
    }

   

   
    
    
    
    
    
    
}