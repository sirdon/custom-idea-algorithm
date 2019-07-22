package idea.bin;
// A simple command-line interface for the IDEA file encryption module.

import java.util.*;
import java.io.*;
import idea.bin.IdeaFileEncryption;
import idea.bin.IdeaFileEncryption.Mode;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class IdeaCmd {

public static void main (String[] args) throws Exception {
    long startTime = System.currentTimeMillis();
    long stopTime;
    long elapsedTime =0;
    long totaltime=0;
   // The syntax of the command line parameters is kept compatible with that of IDEA V1.1 (IDEA_CMD.C, ETH version).
   // It's a subset of the original command line syntax and has a very simple, fixed structure.
   /*if (args.length == 0) {
      System.out.println("IDEA file encryption utility.");
      System.out.println("Syntax: [-e | -d] -k keyString inputFile outputFile");
      System.out.println("Home page: http://www.source-code.biz/idea/java");
      return; }
   if (args.length != 5) {
      throw new Exception("Invalid number of command line arguments."); }
   boolean encrypt;
   if ("-e".equals(args[0])) {
      encrypt = true; }
    else if ("-d".equals(args[0])) {
      encrypt = false; }
    else {
      throw new Exception("First command line argument must be -e or -d."); }
   if (!"-k".equals(args[1])) {
      throw new Exception("Second command line argument must be -k."); }
   String charKey = args[2];D:
   String inputFileName = args[3];
   String outputFileName = args[4];*/
   
    WritableWorkbook myexcel = Workbook.createWorkbook(new File("D:\\datafile.csv"));
    WritableSheet mysheet = myexcel.createSheet("mysheet",0);
    // Scanner for user input
    Scanner user = new Scanner( System.in ); 
    String  inputFileName, outputFileName;
    // prepare the input file
    System.out.print("Input File Name: ");
    inputFileName =user.nextLine().trim();// "C:\\Users\\amit\\Desktop\\project\\sample.txt"; 
    File input = new File( inputFileName );      
    Scanner scan = new Scanner( input );      
    Label l = new Label(0,0,"File Name");
    mysheet.addCell(l);
    
    Label l2 = new Label(1,0,"Execution Time of MyIdea");
    mysheet.addCell(l2);
    
    
    // prepare the output file
    System.out.print("Output File Name: ");
    //Enter the iteration file number
    int n=1;
    for(int file=1;file<=n;file++){
    System.out.print("Execution time for file "+ file + " is = ");
    outputFileName = user.nextLine().trim();//"D:\\MyIdea\\MyideaDecryptOutputFile"+ file+".txt";//user.nextLine().trim();//
    PrintWriter output = new PrintWriter( outputFileName );  
    System.out.println("Enter the encryption/decryption key ");
    String charKey = user.nextLine().trim();//"sfjdkl";
    System.out.println("If you want to encrypt press 1 and press 2 for decrypt ");
    int edchoice;  boolean encrypt;
    edchoice = user.nextInt();
    if(edchoice==1) encrypt = true;
    else encrypt = false;
   IdeaFileEncryption.cryptFile(inputFileName, outputFileName, charKey, encrypt, IdeaFileEncryption.Mode.CBC);
   
   stopTime = System.currentTimeMillis();
   elapsedTime = stopTime - startTime;
   totaltime+=elapsedTime;
   System.out.println(elapsedTime/1000 +" Sec "+  elapsedTime%1000 + "  miliSeconds "); startTime = System.currentTimeMillis(); 
   
    Label l3 =new Label(0,file,"File "+file);
    mysheet.addCell(l3);
    
    Label l4 =new Label(1,file,String.valueOf(elapsedTime));
    mysheet.addCell(l4);
  
    }
     myexcel.write();
     myexcel.close();
    System.out.println("Total execution time = "+totaltime/1000+" seconds "+totaltime%1000+" miliseconds");
    System.out.println("Average ececution time = "+totaltime/(1000*n)+" seconds "+(totaltime%1000)/n+" miliseconds");
    
    }

}

