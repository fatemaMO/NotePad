/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepaddnew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author fatema
 */
public class Notbad extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        TextArea textArea = new TextArea();
        //menubar
        MenuBar bar=new MenuBar();
        //menu
        Menu file=new Menu("File");
        Menu edit=new Menu("Edit");
        Menu help=new Menu("Help");
        //menu item for file
        MenuItem New=new  MenuItem("New");
        New.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        MenuItem open=new  MenuItem("Open");
        MenuItem save=new  MenuItem("Save");
        MenuItem exit=new  MenuItem("Exit");
        //menu item for edit
        MenuItem undo=new  MenuItem("Undo");
        MenuItem cut=new  MenuItem("Cut");
        MenuItem copy=new  MenuItem("Copy");
        MenuItem past=new  MenuItem("Past");
        MenuItem delete=new  MenuItem("Delete");
        MenuItem selectall=new  MenuItem("SelectAll");
        //menu item for edit
        MenuItem about=new  MenuItem("AboutNotepad");
        
//event file
        //event to save
        
//         save.setOnAction(new EventHandler<ActionEvent>() {
//
//          @Override
//          public void handle(ActionEvent event) {
//              FileChooser fileChooser = new FileChooser();
//
//              //Set extension filter
//              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("excel files (*.xls)", "*.xls");
//              fileChooser.getExtensionFilters().add(extFilter);
//
//              //Show save file dialog
//              File file = fileChooser.showSaveDialog(primaryStage);
//
//              if(file != null){
//                  SaveFile(file);
//                  System.out.println("hi");
//              }
//          }
//
//            private void SaveFile(File file) {
//                //To change body of generated methods, choose Tools | Templates.
//                
//            }
//      });
        
           save.setOnAction(new EventHandler<ActionEvent>() {
@Override
        public void handle(ActionEvent event) {
    try {
        FileWriter fileWriter= null;
        PrintWriter printWriter= null;
        BufferedReader bufferedReader=null;
        
//Opening a file in append mode using FileWriter
        fileWriter= new FileWriter("C:\\E\\save.text", true);
//Wrapping BufferedWriterobject in PrintWriter
        printWriter= new PrintWriter(fileWriter);
//Bringing cursor to next line
        printWriter.print(textArea.getText());
//Writing text to file
        {
            printWriter.print(textArea.getText());
        }   } catch (IOException ex) {
    }
}
           });
        
        
        //event to open
         open.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("open action");
                try {
                    FileInputStream fis= new FileInputStream("C:\\java.txt");
                    int size = fis.available();
                    byte[] b = new byte[size];
                    fis.read(b);
                    System.out.println("Size"+size+"in"+new String(b));
                    
                    textArea.appendText(new String(b));
                    fis.close();    } 
                catch (IOException ex) {
                   // Logger.getLogger(Notbad.class.getName()).log(Level.SEVERE, null, ex);
                   ex.printStackTrace();
                }
            }
         });
        //event to exit
      exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              Platform.exit();                
               
            }
             
         });
        
              
        
         
        //event to new
      New.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                         
              textArea.clear();
            }
             
         });
        
      
      
         
//event to edit
         //event to undo
         
         undo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                 textArea.undo();
            
            }
             
         });
         
         //event to copy
            
        copy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                 textArea.copy();
                 System.out.print("copy");
               
            }
             
         });
         
         
         
         //event to cut
          cut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                 textArea.cut();
               System.out.print("cut");
            }
             
         });
         
         
         //event to past
            
         past.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                 textArea.paste();
               System.out.print("past");
            }
             
         });
         //event to delete
           delete.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                 textArea.deleteText(textArea.getSelection());
               System.out.print("deleete");
            }
             
         });
         
         //event to selectAll
         selectall.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                 textArea.selectAll();
                 System.out.print("select");
               
            }
             
         });
        
        //add item to menu file
         
        file.getItems().addAll(New,open,save,exit);
       //add item to menu edit
        edit.getItems().addAll(undo,cut,copy,past,delete,selectall);
        //add item to menu help
        help.getItems().addAll(about);
        
        //add companant to pane
       
        bar.getMenus().addAll(file,edit,help);
        BorderPane pane=new BorderPane();
        pane.setTop(bar);
        pane.setCenter(textArea);
        
        
        //scen
        Scene scene = new Scene(pane, 700, 700);
        
        primaryStage.setTitle("notepadd");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
