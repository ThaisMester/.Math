/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Victor
 */
public class Partida implements Serializable {
    String nome, nome_jogo, data;
    int mat,acert, err, result;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    public Partida() {
        
    }
    
    Partida(Aluno al1,int acertos, int erros, int resultado,String nomeJogo) {
        Date d = GregorianCalendar.getInstance().getTime();  
        SimpleDateFormat sds = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        data=sds.format(d);
        
        acert = acertos;
        err = erros;
        result = resultado;
        nome_jogo = nomeJogo;       
        nome = al1.getNome();
        mat = al1.getMatricula();
        
    }

    public int getAcert() {
        return acert;
    }

    public void setAcert(int acert) {
        this.acert = acert;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_jogo() {
        return nome_jogo;
    }

    public void setNome_jogo(String nome_jogo) {
        this.nome_jogo = nome_jogo;
    }
}
