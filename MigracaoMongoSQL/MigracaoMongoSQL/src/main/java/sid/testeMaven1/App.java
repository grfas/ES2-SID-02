package sid.testeMaven1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        MongoRead mR = new MongoRead();
        mR.connectMongo();
        
        	
        
        	try {
        		mR.readDocuments();
//    			try{
//    				Thread.sleep(30000);
//    			} catch (InterruptedException  e) {
//    				Thread.currentThread().interrupt();
//    			}

        	} catch (Exception e) {
        		e.printStackTrace();
        	
        	}
        
    }
}
