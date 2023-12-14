public class Parameters {
    private String algorithm = "shift";
    private int shift = 0;
    private String operation = "enc";
    private String message = "";
    private String input = "";
    private String output = "";

    public Parameters(String[] args) {
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-mode")) setOperation(args[i + 1]);
            if(args[i].equals("-key")) setShift(Integer.parseInt(args[i + 1]));
            if(args[i].equals("-data")) setMessage(args[i + 1]);
            if(args[i].equals("-in")) setInput(args[i + 1]);
            if(args[i].equals("-out")) setOutput(args[i + 1]);
            if(args[i].equals("-alg")) setAlgorithm(args[i + 1]);
        }
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
