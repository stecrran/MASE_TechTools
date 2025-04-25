package threads;

public class Buffer {
    private StringBuffer data = new StringBuffer();

    public synchronized String getData(){
        String returnData = null;
        try {
            wait();
            returnData = data.toString();
            data = new StringBuffer();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnData;
        }

    public synchronized void setData(String text){
        this.data.append(text);
        notify();
    }
}
