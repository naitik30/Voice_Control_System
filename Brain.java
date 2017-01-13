/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speachtotext;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Naitik
 */
public class Brain {

    public boolean callCommand(String inputText) throws IOException, URISyntaxException {
        Desktop desktop = null;
        ProgramControl pc = new ProgramControl();
        System.out.println(inputText);
        if (inputText.equals("open word")) {
            pc.stratProgram("winword");
        } else if (inputText.equals("close word")) {
            pc.exitProgram("winword");

        }
        if (inputText.equals("open command")) {
            pc.stratProgram("cmd");
        } else if (inputText.equals("close command")) {
            pc.exitProgram("cmd");
        } else if (inputText.equals("open calculator")) {
            pc.stratProgram("calc");
        } else if (inputText.equals("close calculator")) {
            pc.exitProgram("Calculator");
        } else if (inputText.equals("open calculator")) {
            pc.stratProgram("calc");
        } else if (inputText.equals("close calculator")) {
            pc.exitProgram("Calculator");
        } else if (inputText.equals("open access")) {
            pc.stratProgram("msaccess");
        } else if (inputText.equals("close access")) {
            pc.exitProgram("msaccess");
        } else if (inputText.equals("open pad")) {
            pc.stratProgram("notepad");
        } else if (inputText.equals("close pad")) {
            pc.exitProgram("notepad");
        } else if (inputText.equals("open paint")) {
            pc.stratProgram("mspaint");
        } else if (inputText.equals("close paint")) {
            pc.exitProgram("mspaint");
        } else if (inputText.equals("open task manager")) {
            pc.stratProgram("taskmgr");
        } else if (inputText.equals("close task manager")) {
            pc.exitProgram("Taskmgr");
        } else if (inputText.equals("open browser")) {
            pc.stratProgram("explorer");
        } else if (inputText.equals("close browser")) {
            pc.exitProgram("MicrosoftEdge");
        } else if (inputText.equals("start excel")) {
            pc.stratProgram("excel");
        } else if (inputText.equals("stop excel")) {
            pc.exitProgram("EXCEL");
        } else if (inputText.equals("start word pad")) {
            pc.stratProgram("write");
        } else if (inputText.equals("close word pad")) {
            pc.exitProgram("wordpad");
        }

        return true;
    }

    public String calculator(String inputText) {
        String result = null;
        Map number = new HashMap();
        number.put("one", 1);
        number.put("two", 2);
        number.put("three", 3);
        number.put("four", 4);
        number.put("five", 5);
        number.put("six", 6);
        number.put("seven", 7);
        number.put("eight", 8);
        number.put("nine", 9);
        number.put("ten", 10);
        number.put("eleven", 11);
        number.put("twelve", 12);
        String[] splitdata = inputText.split(" ");

        if (splitdata[1].contains("plus")) {

            int oupput = (int) number.get(splitdata[0]) + (int) number.get(splitdata[2]);
            result = Integer.toString((int) number.get(splitdata[0])) + "+" + Integer.toString((int) number.get(splitdata[2])) + " = " + Integer.toString(oupput);
        } else if (splitdata[1].contains("minus")) {
            int oupput = (int) number.get(splitdata[0]) - (int) number.get(splitdata[2]);
            result = Integer.toString((int) number.get(splitdata[0])) + " - " + Integer.toString((int) number.get(splitdata[2])) + " = " + Integer.toString(oupput);
        } else if (splitdata[1].contains("multiply")) {
            int oupput = (int) number.get(splitdata[0]) * (int) number.get(splitdata[2]);
            result = Integer.toString((int) number.get(splitdata[0])) + " * " + Integer.toString((int) number.get(splitdata[2])) + " = " + Integer.toString(oupput);
        } else if (splitdata[1].contains("divide")) {
            int oupput = (int) number.get(splitdata[0]) / (int) number.get(splitdata[2]);
            result = Integer.toString((int) number.get(splitdata[0])) + " / " + Integer.toString((int) number.get(splitdata[2])) + " = " + Integer.toString(oupput);
        }

        return result;

    }

}
