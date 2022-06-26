import java.util.Timer; 
import java.util.TimerTask; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

  
class Timers extends TimerTask implements ActionListener
{ 

    String str="00:00:00:000";
    int hours=00,minutes=00,seconds=00,milisecond=000;
    int naag=1;
    JPanel p;
    JLabel label;
    JButton startButton,stopButton,closeButton;
    Timer t;
    Color color1,color2;
    JFrame frame;
    
    public void myStart(){ 
        t.schedule(this,1, 2); 
    }
    public void myStop(){ 
        t.cancel(); 
    }
    public void myClose(){ 
        t.purge();  
        System.exit(0);  
    }

    public Timers()
    {
        t = new Timer(); 

        frame=new JFrame("Timer By Anand Bind");
        frame.setVisible(true);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        p=new JPanel();
        p.setLayout(null);
        frame.add(p);
        p.setBackground(new Color(100,25,78));
    
        color1=new Color(25,150,35);
        color2=new Color (150,35,25);
    
    
    
        label=new JLabel();
        label.setBounds(50,25,200,50);
        label.setForeground(Color.white);
        p.add(label);
        label.setFont(new Font("Arial",Font.BOLD,30));
        label.setText(str);
    
        JLabel name=new JLabel("Developed by Anand Bind");
        name.setBounds(30,130,200,20);
        name.setForeground(Color.yellow);
        p.add(name);
        name.setFont(new Font("Arial",Font.BOLD,15));
       
    
        startButton=new JButton("Start");
        startButton.setBounds(40,90,70,20);
        startButton.addActionListener(this);
        p.add(startButton);
        
        stopButton=new JButton("Stop");
        stopButton.setBounds(115,90,70,20);
        stopButton.addActionListener(this);
        stopButton.setEnabled(false);
        p.add(stopButton);
        
        closeButton=new JButton("Close");
        closeButton.setBounds(190,90,70,20);
        closeButton.addActionListener(this);
        closeButton.setEnabled(false);
        p.add(closeButton);
    }
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource()==startButton){ 
            myStart();  
            stopButton.setEnabled(true); 
            startButton.setEnabled(false); 
        }
        else if(ev.getSource()==stopButton){ 
            myStop();  
            startButton.setEnabled(false); 
            stopButton.setEnabled(false); 
            closeButton.setEnabled(true); 
        }
        else if(ev.getSource()==closeButton)
        { 
            myClose(); 
        }
    }


    public void run() 
    { 
        milisecond1();	
    }

    public void milisecond1(){
	    if(milisecond<=999){
    	   milisecond=milisecond+2;
    	   label.setText(String.valueOf(hours)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)+":"+String.valueOf(milisecond));
    	}
    	else
        {
    		second1();	
    	}
    }

    public void second1()
    {
    	if(seconds>=59){
            minute1();
            seconds=00;
        }
        else
        {
            if(seconds%2==0){
                p.setBackground(color1);
            }
            else{ 
                p.setBackground(color2); 
            }
    
    	    ++seconds;
    	    milisecond=00;
            label.setText(String.valueOf(hours)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)+":"+String.valueOf(milisecond));
            milisecond1();
        }
    }
    public void minute1()
    {
        if(minutes>=59){ 
            hours1();
            minutes=00;
        }
	    else
        {	
            ++minutes;
            milisecond=00;
            label.setText(String.valueOf(hours)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)+":"+String.valueOf(milisecond));
            milisecond1();
        }
    }
    public void hours1()
    {
        if(hours==24)
        { 
            milisecond=00;
            seconds=0;
            minutes=0;
            hours=0;
            label.setText(String.valueOf(hours)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)+":"+String.valueOf(milisecond));
        }
        else
        {
            ++hours;
            milisecond=00;
            label.setText(String.valueOf(hours)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)+":"+String.valueOf(milisecond));
            milisecond1();
        }
    }
}

  
public class AnandBind { 
    public static void main(String[] args) {             
     new Timers(); 
    } 
} 