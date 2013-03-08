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

public class LED_EOH extends ElementAnimation
{
	

    // The color to fade to
    private Color color;
    private Color color1;

    
    // The number of rows we've faded


    public LED_EOH(LightMaster master, int startTime, ArrayList<ElementController> elementList, double duration) {
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

            			
                    	if(num%4==0){
                    		
                    		//"E" of EOH
                    		for(int x =0; x< panel.getPanelHeight(); x++){
                    			for(int y = 0; y< 2; y++){
                    		
                    				panel.setColor(x, y, color);
                    				panel.setColor(x, y, color);
                    			}
                    		}
                    		
                    		panel.setColor(0, 2, color);
            				panel.setColor(0, 3, color);
            				panel.setColor(1, 3, color);
            				panel.setColor(1, 2, color);
            				
            				panel.setColor(0, 4, color);
            				panel.setColor(1, 4, color);
            				
            				
            				panel.setColor(7, 2, color);
            				panel.setColor(7, 3, color);
            				panel.setColor(8, 3, color);
            				panel.setColor(8, 2, color);
            				
            				panel.setColor(7, 4, color);
            				panel.setColor(8, 4, color);
            				
            				
            				panel.setColor(15, 2, color);
            				panel.setColor(15, 3, color);
            				panel.setColor(14, 3, color);
            				panel.setColor(14, 2, color);
            				
            				panel.setColor(14, 4, color);
            				panel.setColor(15, 4, color);
                    		
                    		
                    		
                    		
                    		
                    		//the "O" of EOH
                    		for(int x =0; x< panel.getPanelHeight(); x++){

                				panel.setColor(x, 6, color);
                				panel.setColor(x, 6, color);
                			
                				panel.setColor(x, 9, color);
                				panel.setColor(x, 9, color);
                    		}

                    		for(int x =0; x< 4; x++){
                    			for(int y = 7; y< 9; y++){
                    		
                    				panel.setColor(x, y, color);
                    				panel.setColor(x, y, color);
                    			}
                    		}
                    		for(int x =12; x< 16; x++){
                    			for(int y = 7; y< 9; y++){
                    		
                    				panel.setColor(x, y, color);
                    				panel.setColor(x, y, color);
                    			}
                    		} 	
                          	
                    		
                          	//"H" of EOH
                    		for(int x =0; x< panel.getPanelHeight(); x++){
                    			for(int y = 11; y< 13; y++){
                    		
                    				panel.setColor(x, y, color);
                    				panel.setColor(x, y, color);
                    			}
                    		}
                    		
            				panel.setColor(7, 13, color);
            				panel.setColor(8, 13, color);
                    		
                    		for(int x =0; x< panel.getPanelHeight(); x++){
                    			for(int y = 14; y< 16; y++){
                    		
                    				panel.setColor(x, y, color);
                    				panel.setColor(x, y, color);
                    			}
                    		}
            				
                    	}

                    	
                    	else{
                    		
                    		//E flicker
                    		for(int x =0; x< panel.getPanelHeight(); x++){
                    			for(int y = 0; y< 2; y++){
                    		
                    				panel.setColor(x, y, color1);
                    				panel.setColor(x, y, color1);
                    			}
                    		}
                    		
                    		
                    		//O flicker
                    		for(int x =0; x< panel.getPanelHeight(); x++){

                    				panel.setColor(x, 6, color1);
                    				panel.setColor(x, 6, color1);
                    			
                    				panel.setColor(x, 9, color1);
                    				panel.setColor(x, 9, color1);
                    			
                    		} 	
                    		for(int x =0; x< 4; x++){
                    			for(int y = 7; y< 9; y++){
                    		
                    				panel.setColor(x, y, color1);
                    				panel.setColor(x, y, color1);
                    			}
                    		}
                    		for(int x =12; x< 16; x++){
                    			for(int y = 7; y< 9; y++){
                    		
                    				panel.setColor(x, y, color1);
                    				panel.setColor(x, y, color1);
                    			}
                    		}
                    		
                        	
                    		//E Flicker
            				panel.setColor(0, 2, color1);
            				panel.setColor(0, 3, color1);
            				panel.setColor(1, 3, color1);
            				panel.setColor(1, 2, color1);
            				
            				panel.setColor(0, 4, color1);
            				panel.setColor(1, 4, color1);
            				
            				
            				panel.setColor(7, 2, color1);
            				panel.setColor(7, 3, color1);
            				panel.setColor(8, 3, color1);
            				panel.setColor(8, 2, color1);
            				
            				panel.setColor(7, 4, color1);
            				panel.setColor(8, 4, color1);
            				
            				
            				
            				panel.setColor(15, 2, color1);
            				panel.setColor(15, 3, color1);
            				panel.setColor(14, 3, color1);
            				panel.setColor(14, 2, color1);
            				
            				panel.setColor(14, 4, color1);
            				panel.setColor(15, 4, color1);
            				
            				
            				
                          	//"H" of EOH
                    		for(int x =0; x< panel.getPanelHeight(); x++){
                    			for(int y = 11; y< 13; y++){
                    		
                    				panel.setColor(x, y, color1);
                    				panel.setColor(x, y, color1);
                    			}
                    		}
                    		
            				panel.setColor(7, 13, color1);
            				panel.setColor(8, 13, color1);
                    		
                    		for(int x =0; x< panel.getPanelHeight(); x++){
                    			for(int y = 14; y< 16; y++){
                    		
                    				panel.setColor(x, y, color1);
                    				panel.setColor(x, y, color1);
                    			}
                    		}
            				
                    	}
                        
                        
                    
                    num++;
                }

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