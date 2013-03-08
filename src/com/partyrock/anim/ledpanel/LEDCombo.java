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

public class LEDCombo extends ElementAnimation
{
	

    // The color to fade to
    private Color color;
    private Color color1;

    
    // The number of rows we've faded
    private int fadedRows = -1;

    public LEDCombo(LightMaster master, int startTime, ArrayList<ElementController> elementList, double duration) {
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
     */

    /**
     * Since we're doing something over time, we need to implement increment()
     * 
     * @param percentage The percentage of the way through the animation we are. This is between 0 and 1
     */
    public void increment(double percentage) {
        int newFadedRows = fadedRows;

        // For every element we're given
        for (ElementController controller : getElements()) {
            // We only put LEDS in our getSupportedTypes(), so that's all we're going to get.
            LEDPanelController panel = (LEDPanelController) controller;

            // How many rows should be on based on our percentage?
            int rowsOn = (int) ((percentage * panel.getPanelHeight()));

            // So if we haven't already done this
            if (fadedRows < rowsOn) {

                // The for every row we haven't done
                for (int r = fadedRows + 1; r <= rowsOn && r < panel.getPanelHeight()/2; r++) {
                    System.out.println("Doing " + r);
                    // and every column in that row
                    for (int c = 0; c < panel.getPanelWidth()/2; c++) {
                        // Set the color to the color we picked when making the animation
                        panel.setColor(r, c, color);
                        panel.setColor(c, r, color1);
                        //panel.setColor(r, r, getRandomColor());
                        
                        panel.setColor(r+panel.getPanelHeight()/2, c+ panel.getPanelWidth()/2, color);
                        panel.setColor(c+panel.getPanelWidth()/2, r+panel.getPanelWidth()/2, color1);
                        
                       
                        panel.setColor(r+panel.getPanelHeight()/2, c, color);
                        panel.setColor(c+panel.getPanelWidth()/2, r, color1);
                        
                        
                        panel.setColor(r, c+ panel.getPanelWidth()/2, color);
                        panel.setColor(c, r+panel.getPanelWidth()/2, color1);
                        
                    }
                }
                

                newFadedRows = rowsOn;
            }
        }

        fadedRows = newFadedRows;

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
