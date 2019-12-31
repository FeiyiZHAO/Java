package javaproject;
import java.lang.*;
import javax.swing.JLabel;



public class Counter extends Thread{

	
	private JLabel jl2;
    private JLabel jl3;
    long time;

    
    public void run() {
        long minute = 0;
        long seconds = 0;
 
        while (time >= 0) {
            minute = time / 60;
            seconds = time - minute * 60;
            jl2.setText(minute + " min");
            jl3.setText(seconds + " s");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time--;
        }
 
    }
    

    public Counter(long t) {
        jl2 = new JLabel();
        jl3 = new JLabel();
        this.time = t;
 
    }
    
    public JLabel getJl2()
    {
    	return jl2;
    }
    public JLabel getJl3()
    {
    	return jl3;
    }
    public long getTime()
    {
    	return time;
    }

}