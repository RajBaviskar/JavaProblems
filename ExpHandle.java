public class ExpHandle {
    static class MyException extends Exception{
        public MyException(String strs){
            super(strs);
        }
    }
    public static void main(String[] args){
        try {
            //System.out.println(10 / 0);
            throw new MyException("my own exception creation");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }catch(ArithmeticException e ){
            System.out.println("please don't do this" + e.getMessage());
        }

    }
}
