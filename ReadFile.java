package ICP_PROJECT;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class ReadFile {
    public static ArrayList<String[]> ReadFile(String filename){
        ArrayList<String[]> fileContent = new ArrayList<>();
        BufferedReader reader = null;
        try{
            File file = new File(filename);
            reader = new BufferedReader(new FileReader(file));
            String contentF;
            String [] fieldObjects;
            String [] newObject;

            while ((contentF = reader.readLine()) != null){

                fieldObjects = contentF.split(",");
                fileContent.add(fieldObjects);
            }
        }catch(FileNotFoundException fNE){
            fNE.printStackTrace();
        }catch(IOException ie){
            ie.printStackTrace();
        }
        finally {
            try{
                if(reader != null)
                    reader.close();
            } catch(IOException ep){
                ep.printStackTrace();
            }

        } return fileContent;
    }
}
