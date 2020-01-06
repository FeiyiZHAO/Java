package javaproject;

import javax.swing.JLabel;



public class Counter extends Thread{

	
	private JLabel jl2;
    private JLabel jl3;
    private Niveau niv;
    private long time;

    
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

		    //FenetreFini fini = new FenetreFini(niv.getScore());
		    FenetreFini.main(null);
    }
    

    public Counter(Niveau n) {
        jl2 = new JLabel();
        jl3 = new JLabel();
        niv = n;
        this.time = niv.getTemps();
 
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