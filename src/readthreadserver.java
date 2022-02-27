import java.util.*;
public class readthreadserver implements Runnable{
    private Thread thr;
    private NetworkUtil nc;
    private Hashtable<String,NetworkUtil> table;



    public readthreadserver( Hashtable<String,NetworkUtil> table,NetworkUtil nc) {
        this.table=table;
        this.thr=new Thread(this);
        this.nc = nc;
        thr.start();
    }

    public void run(){
        while(true)
        {
            Object o = nc.read();
            if(o instanceof String) {
                String s= (String ) o;

                StringTokenizer st=new StringTokenizer(s,":");
                String receiver=st.nextToken();
                String s1 =st.nextToken();
                NetworkUtil nc2= table.get(receiver);

                nc2.write(s1);
            }
            else if(o instanceof Move) {
                Move m = (Move) o;
                NetworkUtil nc2= table.get(m.getreceiver());
                try {
                    nc2.write(m);
                }catch (Exception e){
                   e.printStackTrace();
                }
            }
        }
    }
}
