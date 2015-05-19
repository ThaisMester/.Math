/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Igor
 */
public class Arquivo {
    String diretorio = "arquivos";
    
    Arquivo() {
        
    }
    
    public void escreveTXT(Partida jogo1, String arquivo1) {
        
        java.io.File dir = new java.io.File(diretorio);
        if (!dir.exists()) {
            dir.mkdir();
        }
        Date d = GregorianCalendar.getInstance().getTime();  
        SimpleDateFormat sds = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        java.io.File arquivo = new java.io.File(dir, arquivo1 + ".txt");
        
        try {
            if (arquivo.exists()) {
                FileWriter fileWriter = new FileWriter(arquivo, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
            
                printWriter.println("");
                printWriter.println("Data: " + sds.format(d));
                printWriter.println("Nome: " + jogo1.nome);
                printWriter.println("Jogo: " + jogo1.nome_jogo);
                printWriter.println("Acertos: " + jogo1.acert);
                printWriter.println("Erros: " + jogo1.err);
            
                printWriter.flush();
                printWriter.close();
            } else {
                arquivo.createNewFile();
                FileWriter fileWriter = new FileWriter(arquivo, false);
                PrintWriter printWriter = new PrintWriter(fileWriter);
            
                printWriter.println("Data: " + sds.format(d));
                printWriter.println("Nome: " + jogo1.nome);
                printWriter.println("Jogo: " + jogo1.nome_jogo);
                printWriter.println("Acertos: " + jogo1.acert);
                printWriter.println("Erros: " + jogo1.err);
            
                printWriter.flush();
                printWriter.close();
            }
           
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        
        
    }
    
    public void leTXT(String arquivo1) {
        //java.io.File dir = new java.io.File(diretorio);
        //java.io.File arquivo = new java.io.File(dir, arquivo1 + ".txt");
        BufferedReader reader = null;
        try {
            try{
                reader = new BufferedReader(new FileReader("arquivos/saida.txt"));
                String line;
                do {
                   line=reader.readLine();
                   if(line!=null)
                       System.out.println(line);
                   
                } while(line!=null);
                
            }finally {
                if(reader!=null)
                    reader.close();
            }
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void escreveXML(Partida partida, String arquivo1) {
        java.io.File dir1 = new java.io.File(diretorio);
        if (!dir1.exists()) {
            dir1.mkdir();
        }
        
        XMLEncoder xmlEncoder = null;
        try {
            try {
            xmlEncoder = new XMLEncoder(new FileOutputStream(diretorio + "/" + arquivo1 + ".xml"));
            xmlEncoder.writeObject(partida);
            } finally {
                if(xmlEncoder != null)
                    xmlEncoder.close();
            } 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        
    }
    
    public void leXML(String arquivo1) {
        java.io.File dir1 = new java.io.File(diretorio);
        
        Partida partida = new Partida();
        try {
            XMLDecoder xmlDecoder = null;
            try {
                xmlDecoder = new XMLDecoder(new FileInputStream(diretorio + "/" + arquivo1 + ".xml"));
                partida = (Partida) xmlDecoder.readObject();
                //for(Partida p : partida) {
                    System.out.println(partida.nome);
                //}
                
            } finally {
                if(xmlDecoder != null)
                    xmlDecoder.close();
            } 
            
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
