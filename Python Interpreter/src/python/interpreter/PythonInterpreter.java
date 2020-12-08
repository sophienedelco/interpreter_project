/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package python.interpreter;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sophienedelco
 */
public class PythonInterpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Grab file name from user to read in
        
        Scanner scanner = new Scanner(System.in);
        
        List<String> fileInput = new ArrayList<>();
        
        System.out.println("Please type the name of the Python file to interpret: ");
        String fileName = scanner.nextLine();
        scanner.close();
        
        //Use file name to open file + scan in contents
 
        try{
            File pythonFile = new File(fileName);
            Scanner file = new Scanner(pythonFile);
            while(file.hasNextLine()){
                String input = file.nextLine();
                if(!input.matches("#.*"))
                {
                    fileInput.add(input);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Error reading input file");
        }
        
        //Check to make sure it was read in: 
        for(String inputLine : fileInput)
        {
            System.out.println(inputLine);
        }
        
    }
    
}
