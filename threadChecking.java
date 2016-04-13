package threadchecking;


public class ThreadChecking extends Thread{
    
    public void run(){
        for(int i = 0;i<10;i++){
            printMsg();
        }
        
    }
    
    public void printMsg(){
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("name: "+name);
    }

    
    public static void threadStop()throws Exception{
        
        try{
           Thread threadTwo = new Thread();
            threadTwo.start();
            if(threadTwo.isAlive()){
                System.out.println("Thread has not finished");
            }else{
                System.out.println("Finished");
            }
            long delayMillis = 5000;
            threadTwo.join(delayMillis);
            if(threadTwo.isAlive()){
                System.out.println("thread has not Finished");
            }else{
                System.out.println("Finsihed");
            }
            threadTwo.join(); 
        }catch(Exception e){
            System.out.println("Exception");
        }
        
        
        boolean stop = false;
        
    }
    
    
    
    public static void threadCheck(){
        ThreadChecking tThread = new ThreadChecking();
        tThread.setName("Thread");
        System.out.println("before start(), tThread.isAlive(): "+tThread.isAlive());
        tThread.start();
        System.out.println("just after start(), tThread.isAlive(): "+tThread.isAlive());
        for(int i = 0; i<10; i++){
            tThread.printMsg();
        }
        System.out.println("The end of main(), tThread.isAlive(): "+tThread.isAlive());
    }
    
    public static void main(String[] args) throws Exception {
        
        threadCheck();
        threadStop();
        
        
        
        
    }
    
}
