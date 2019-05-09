public class ExpressionTree{
	  private char operation;
	  private double value;
	  private ExpressionTree ls,rs;

	  public ExpressionTree(double value){
	    this.value = value;
	    operation = '~';
	  }

	  public ExpressionTree(char operation, ExpressionTree left, ExpressionTree right){
	    this.operation = operation;
	    ls = left;
	    rs = rs;
	  }

	  public char getOperation(){
	    return operation;
	  }

	  private double getValue(){
	    return value;
	  }

	  private ExpressionTree getLeft(){
	    return ls;
	  }

	  private ExpressionTree getRight(){
	    return rs;
	  }


// children determine whether value or operation

	  private boolean isOperation(){
	    return hasChildren();
	  }
	  private boolean isValue(){
	    return !hasChildren();
	  }

	  private boolean hasChildren(){ // helps with determination
	    return ls != null && rs != null;
	  }

	  public String toString(){
	    if(isValue()){
	      return  "" + getValue();
	    }
	    else{
	      return "(" + getLeft().toString() + " " + getOperation() + " " + getRight().toString() + ")";
	    }
	  }

	  public String toStringPostfix(){
	    if(isValue()){
	      return  "" + getValue();
	    }
	    else{
	      return  getLeft().toStringPostfix() + " "
	      + getRight().toStringPostfix() + " "
	      + getOperation();
	    }
	  }

	  public String toStringPrefix(){
	    if(isValue()){
	      return  "" + getValue();
	    }
	    else{
	      return  getOperation() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
	    }
	  }

	  public double evaluate(){
	    if(isValue()){
	      return getValue();
	    }
	    else{
	      return apply(getOperation(), getLeft().evaluate(), getRight().evaluate());
	    }
	  }

	  private double apply(char op, double val1, double val2){
	    if(operation == '+'){
	      return val1 + val2;
	    }
	    else if(operation == '-'){
	      return val1 - val2;
	    }
	    else if(operation == '*'){
	      return val1 * val2;
	    }
	    else{
	      return val1 / val2;
	    }
	  }

	  public static void main(String[] args){

	    ExpressionTree first = new ExpressionTree(4.0);
	    ExpressionTree second = new ExpressionTree(2.0);


	    ExpressionTree third = new ExpressionTree('+',first,second);
	    System.out.println(third);
	    System.out.println(third.toStringPostfix());
	    System.out.println(third.toStringPrefix());
	    System.out.println(third.evaluate());//6.0
      System.out.println("6");

	    ExpressionTree four = new ExpressionTree('*',third,new ExpressionTree(3.5));
	    System.out.println(four);
	    System.out.println(four.toStringPostfix());
	    System.out.println(four.toStringPrefix());
	    System.out.println(four.evaluate());//21
      System.out.println("21");


	    ExpressionTree fifth = new ExpressionTree('-',four,new ExpressionTree(1.0));
	    System.out.println(fifth);
	    System.out.println(fifth.toStringPostfix());
	    System.out.println(fifth.toStringPrefix());
	    System.out.println(fifth.evaluate());//20
      System.out.println("20");

	    fifth = new ExpressionTree('+',new ExpressionTree(1.0),fifth);
	    System.out.println(fifth);
	    System.out.println(fifth.toStringPostfix());
	    System.out.println(fifth.toStringPrefix());
	    System.out.println(fifth.evaluate());//21
      System.out.println("21");

	    fifth = new ExpressionTree('/',fifth,new ExpressionTree(2.0));
	    System.out.println(fifth);
	    System.out.println(fifth.toStringPostfix());
	    System.out.println(fifth.toStringPrefix());
	    System.out.println(fifth.evaluate());//10.5
      System.out.println("10.5");
	  }


	}
