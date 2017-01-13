/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speachtotext;

/**
 *
 * @author Naitik
 */
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SpeachToText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {
        try {
            URL url;
            if (args.length > 0) {
                url = new File(args[0]).toURI().toURL();
            } else {
                url = SpeachToText.class.getResource("SpeechtoText.config.xml");
            }

            System.out.println("Loading...");
            SpeechtoTextGUI gui = new SpeechtoTextGUI();
            gui.simplegui();

            ConfigurationManager cm = new ConfigurationManager(url);
            Brain brain = new Brain();
            Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
            Microphone microphone = (Microphone) cm.lookup("microphone");


            /* allocate the resource necessary for the recognizer */
            recognizer.allocate();

            /* the microphone will keep recording until the program exits */
            if (microphone.startRecording()) {

                while (true) {
                    System.out.println("Start speaking. Press Ctrl-C to quit.\n");

                    /*
                     * This method will return when the end of speech
                     * is reached. Note that the endpointer will determine
                     * the end of speech.
                     */
                    Result result = recognizer.recognize();

                    if (result != null) {
                        String resultText = result.getBestFinalResultNoFiller();
                        if (resultText.contains("plus") || resultText.contains("minus")
                                || resultText.contains("multiply") || resultText.contains("divide")) {
                            String data=   brain.calculator(resultText);
                            gui.setData(data);
                        }
                        else{
                            gui.setData(resultText);
                        brain.callCommand(resultText);

                        }

                    } else {
                        System.out.println("I can't hear what you said.\n");
                    }
                }
            } else {
                System.out.println("Cannot start microphone.");
                recognizer.deallocate();
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Problem when loading HelloWorld: " + e);
            e.printStackTrace();
        } catch (PropertyException e) {
            System.err.println("Problem configuring HelloWorld: " + e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Problem creating HelloWorld: " + e);
            e.printStackTrace();
        }
    }

}
