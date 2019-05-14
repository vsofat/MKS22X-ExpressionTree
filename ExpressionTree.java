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
	      return  getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOperation();
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
	    else if (operation == '/'){
	      return val1 / val2;
      }
      else{
        return val1 % val2;
      }
	  }

	  public static void main(String[] args){

      ExpressionTree a = new ExpressionTree(4.0);
ExpressionTree b = new ExpressionTree(2.0);

ExpressionTree c = new ExpressionTree('+',a,b);
System.out.println(c);
System.out.println(c.toStringPostfix());
System.out.println(c.toStringPrefix());
System.out.println(c.evaluate());//6.0
System.out.println();

ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
System.out.println(d);
System.out.println(d.toStringPostfix());
System.out.println(d.toStringPrefix());
System.out.println(d.evaluate());//21
System.out.println();

ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
System.out.println(ex);
System.out.println(ex.toStringPostfix());
System.out.println(ex.toStringPrefix());
System.out.println(ex.evaluate());//20
System.out.println();

ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
System.out.println(ex);
System.out.println(ex.toStringPostfix());
System.out.println(ex.toStringPrefix());
System.out.println(ex.evaluate());//21
System.out.println();

ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
System.out.println(ex);
System.out.println(ex.toStringPostfix());
System.out.println(ex.toStringPrefix());
System.out.println(ex.evaluate());//10.5
System.out.println();

	  }


	}
