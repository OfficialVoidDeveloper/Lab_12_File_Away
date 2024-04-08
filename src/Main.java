import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

/*
* TODO For File Away
*   1: Open the file after the user specifies it with JFileChooser
*   2: Read each line one at a time and keep track of how many lines are read
*   3: Count How many words there are
*   4: Keep track of total characters in that file.
* */


public class Main {
    public static void main(String[] args)
    {
        String readOrWriteFile;
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        JFileChooser chooser = new JFileChooser();
        File workingDir = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDir);


        do {
            System.out.println("Would you like to read or write file? [w|r]: ");
            readOrWriteFile = sc.nextLine();

            if(readOrWriteFile.equalsIgnoreCase("w")){
                WriteFile(chooser);
                done = true;
            }else if (readOrWriteFile.equalsIgnoreCase("r")){
                ReadFile(chooser);
                done = true;
            }else{
                System.out.println("Invalid Input: Please Try Again");
                continue;
            }
        }while(!done);
    }

    public static void WriteFile(JFileChooser chooser){
        File selectedFile;
        String rec;
        String prevText;
        ArrayList<String> lines = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        try {
            if(chooser.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while (reader.ready()){
                    prevText = reader.readLine();
                    lines.add(prevText);
                }
                reader.close();
                for (String words : lines) {
                    writer.write(words, 0, words.length());
                    writer.newLine();
                }
                do {
                    System.out.println("\nEnter the name of a Devil Fruit from One Piece (ex: Mera Mera no mi): ");
                    rec = sc.nextLine();
                    writer.write(rec, 0, rec.length());
                    writer.newLine();
                    System.out.println("\nWould you like to Enter more? [y|n]: ");
                    if (sc.nextLine().equalsIgnoreCase("n")) {
                        writer.flush();
                        writer.close();
                        done = true;
                    }

                }while(!done);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFile(JFileChooser chooser){
        File selectedFile;
        String rec = "";

        try {
            if(chooser.showOpenDialog(null) ==  JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();


                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                ArrayList <String> words = new ArrayList<>();
                int line = 0;
                int word = 0;
                int charCount = 0;
                while(reader.ready()){
                    rec = reader.readLine();
                    words.add(rec);
                    line++;
                    System.out.printf("\nLine %4d: %-60s ", line, rec);
                }
                reader.close();
                int i = 0;
                String[] wordsWords;
                for(String wordStr : words){
                    i += 1;
                    wordsWords = wordStr.split(" ");
                    word += wordsWords.length;
                    charCount += words.get(i-1).length();
                }
                System.out.println("\n================================================");
                System.out.println("\nTotal Line Count: "+line);
                System.out.println("Total Word Count: "+word);
                System.out.println("Total Character Count: "+charCount);
                System.out.println("\n\nData file read!");

            }

        } catch(FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }




}
