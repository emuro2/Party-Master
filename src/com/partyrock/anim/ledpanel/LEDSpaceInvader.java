package com.partyrock.anim.ledpanel;

import java.util.ArrayList;
import java.util.EnumSet;

import org.eclipse.swt.graphics.Color;


import com.partyrock.LightMaster;
import com.partyrock.anim.ElementAnimation;
import com.partyrock.element.ElementController;
import com.partyrock.element.ElementType;
import com.partyrock.element.led.LEDPanelController;
import com.partyrock.settings.Saver;
import com.partyrock.settings.SectionSettings;


/**
 * This is a basic animation that will wipe an LED panel from top to bottom with a given color
 * 
 * @author Matthew & Erik
 * 
 */

public class LEDSpaceInvader extends ElementAnimation
{
	

    // The color to fade to
    private Color color;
    private Color color1;

    
    // The number of rows we've faded


    public LEDSpaceInvader(LightMaster master, int startTime, ArrayList<ElementController> elementList, double duration) {
        super(master, startTime, elementList, duration);

        // Tell the animation system to call our animation's step() method repeatedly so we can animate over time
        needsIncrements();

        // Set a new default color of white
        color = sysColor((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        color1 = sysColor((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

    }

    /**
     * This method is called once when the animation is created. You can use it to get user configurable settings like a
     * Color (as we do in this case)

    /**
     * Since we're doing something over time, we need to implement increment()
     * 
     * @param percentage The percentage of the way through the animation we are. This is between 0 and 1
     */
    public void increment(double percentage) {
 


        // For every element we're given
        for (ElementController controller : getElements()) {
            // We only put LEDS in our getSupportedTypes(), so that's all we're going to get.
            LEDPanelController panel = (LEDPanelController) controller;
            int num = (int) (percentage * 16);

            
            if (num < 16) {


                    	if(num%2==0){
                    		for(int x = 3; x < 12; x++){
                    			for(int y =2; y < 14; y++){
                        			panel.setColor(x, y, color);
                        			//eyes
                        			paint();
                        			//ears
                        			paintFeat(color);

                    			}
                    		
                    		}
                    	}

                    	
                    	else{
                    		for(int x = 3; x < 12; x++){
                    			for(int y =2; y < 14; y++){
                        			panel.setColor(x, y, color1);
                        			//eyes
                        			paint();
                        			//ears
                        			paintFeat(color1);

                    			}
                    		}
                    	}
                        
                        
                    
                    num++;
                }

            }

       }
               
        
    public void paint(){
    	
    	
        for (ElementController controller : getElements()) {
            // We only put LEDS in our getSupportedTypes(), so that's all we're going to get.
            LEDPanelController panel = (LEDPanelController) controller;
            	
            for(int x = 4; x < 9; x++){
            	for(int y =4; y < 6; y++){
            		panel.setColor(x, y, sysColor(255,255,255));
				
            	}
            }
            
            for(int x = 4; x < 9; x++){
            	for(int y =9; y < 11; y++){
            		panel.setColor(x, y, sysColor(255,255,255));
				
            	}
            }
        }

    }
    

public void paintFeat(Color col){
    	
    	
   for (ElementController controller : getElements()) {
       // We only put LEDS in our getSupportedTypes(), so that's all we're going to get.
       LEDPanelController panel = (LEDPanelController) controller;
            	    
       	//left ear
        panel.setColor(0, 2, col);
		panel.setColor(0, 3, col);
		panel.setColor(1, 2, col);
		panel.setColor(1, 3, col);
	
		panel.setColor(2, 4, col);
		panel.setColor(2, 5, col);
	
		
		//right ear
        panel.setColor(0, 14, col);
		panel.setColor(0, 13, col);
		panel.setColor(1, 14, col);
		panel.setColor(1, 13, col);
	
		panel.setColor(2, 11, col);
		panel.setColor(2, 12, col);
		
	
		//left arm
        panel.setColor(8, 0, col);
		panel.setColor(8, 1, col);
        panel.setColor(9, 0, col);
		panel.setColor(9, 1, col);
	
		//right arm
        panel.setColor(8, 15, col);
		panel.setColor(8, 14, col);
        panel.setColor(9, 15, col);
		panel.setColor(9, 14, col);
		
		//mouth
        panel.setColor(12, 4, col);
		panel.setColor(12, 5, col);
		panel.setColor(13, 4, col);
		panel.setColor(13, 5, col);
		
        panel.setColor(12, 10, col);
		panel.setColor(12, 11, col);
		panel.setColor(13, 10, col);
		panel.setColor(13, 11, col);
	
        panel.setColor(14, 9, col);
		panel.setColor(15, 9, col);
		panel.setColor(15, 8, col);
		panel.setColor(14, 8, col);
		
        panel.setColor(14, 6, col);
		panel.setColor(15, 6, col);
		panel.setColor(15, 7, col);
		panel.setColor(14, 7, col);
   }
}
    
    public Color getRandomColor() {
        return sysColor((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    
    /**
     * This returns the kind of elements we support with this animation. In this case, it's simply LED Panels
     */
    public static EnumSet<ElementType> getSupportedTypes() {
        return EnumSet.of(ElementType.LEDS);
    }

    /**
     * Saves the variables to a file so we can reconstruct this Animation object the next time we restart the software
     */
    protected void saveSettings(SectionSettings settings) {
        settings.put("color", Saver.saveColor(color));
    }

    /**
     * Loads the variables saved in saveSettings() to make this animation match how it was before
     */
    protected void loadSettings(SectionSettings settings) {
        color = Saver.loadColor(settings.get("color"), this);
    }


}