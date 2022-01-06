

/* 
 * Copyright (C) 2022 University of Nebraska Medical Center
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */


import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.ImageStack;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.imglib2.img.Img;
import org.scijava.plugin.Plugin;
import vtea._vtea;
import vtea.imageprocessing.AbstractImageProcessing;
import vtea.imageprocessing.ImageProcessing;

/**
 *
 * @author sethwinfree
 */
@Plugin(type = ImageProcessing.class)
public class ImageProcessingExample extends AbstractImageProcessing {

    public ImageProcessingExample() {

        VERSION = "0.1";

        AUTHOR = "Seth Winfree";

        COMMENT = "Example ImageProcessing Plugin VTEA v1.0";

        NAME = "Example_1";

        KEY = "Example1";

        protocol = new ArrayList();

        protocol.add(new JLabel("Your favorite number (pixels):"));

        protocol.add(new JTextField("42", 3));

    }

    @Override
    public boolean process(ArrayList al, ImagePlus imp) {

        JTextField radius = (JTextField) al.get(3);

        ImageStack is;

        is = imp.getImageStack();

        IJ.log("VTEA Example_1 image processing plugin version: " + VERSION + "...");
        IJ.log("Example_1 Result: " + "42");

        return true;
    }

    @Override
    public boolean process(ArrayList al, Img img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Img getPreview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getImageJMacroCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String runImageJMacroCommand(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendProgressComment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getProgressComment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean copyComponentParameter(String version, ArrayList dComponents, ArrayList sComponents) {

        try {
            dComponents.clear();

            JTextField Value = (JTextField) sComponents.get(1);

            dComponents.add(new JLabel("Your favorite number (pixels):"));
            dComponents.add((new JTextField(Value.getText(), 3)));

            return true;
        } catch (Exception e) {
            System.out.println("ERROR: Could not copy parameter(s) for " + NAME);
            return false;
        }
    }

    @Override
    public boolean loadComponentParameter(String version, ArrayList dComponents, ArrayList fields) {
        try {
            dComponents.clear();

            String Value= (String) fields.get(0);

            dComponents.add(new JLabel("Your favorite number (pixels):"));
            dComponents.add((new JTextField(Value, 3)));

            return true;

        } catch (Exception e) {

            System.out.println("ERROR: Could not copy parameter(s) for " + NAME);

            return false;
        }
    }

    @Override
    public boolean saveComponentParameter(String version, ArrayList dComponents, ArrayList fields) {
        try {
            fields.clear();
            fields.add(((JTextField) (dComponents.get(1))).getText());
            return true;

        } catch (Exception e) {

            System.out.println("ERROR: Could not copy parameter(s) for " + NAME);

            return false;
        }
    }

    
    public static void main(String[] args) {

        //set the plugins.dir property to make the plugin appear in the Plugins menu
        Class<?> clazz = _vtea.class;
        String url = clazz.getResource("/" + clazz.getName().replace('.', '/') + ".class").toString();
        String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {


                new ImageJ();
            }
        });
    }
}
