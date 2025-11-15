class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        int value;
        String fianlVal = "";
        if(operation == null){
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if(operation == ""){
            throw new IllegalArgumentException("Operation cannot be empty");
        }
        if(operation != "+" && operation != "*" && operation != "/"){
            throw new IllegalOperationException ("Operation "+"'"+operation+"'"+" does not exist");
        }
        try{
            if(operation == "+"){
                value = operand1 + operand2;
                fianlVal =  operand1 +" + "+ operand2 +" = "+  value;
                return fianlVal;
            }else if(operation == "*"){
                value = operand1 * operand2;
                fianlVal =  operand1 +" * "+ operand2 +" = "+  value;
                return fianlVal;
            }else if(operation == "/"){
                value = operand1 / operand2;
                fianlVal =  operand1 +" / "+ operand2 +" = "+  value;
                return fianlVal;
            }
        }catch(ArithmeticException A){
            throw new IllegalOperationException("Division by zero is not allowed", A);
        }
        
        return fianlVal; 
    }
}
