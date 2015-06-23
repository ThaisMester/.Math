/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Igor
 */
public class Operadores extends Jogo {
    int operador;
    private String[] operadores = {"ADICAO","SUBTRACAO","MULTIPLICACAO","DIVISAO"};
    
    Operadores()
    {
        operador=0;
        nome = "Operadores";
    }
    
    Operadores(int novoOperador) {
        operador=novoOperador;
    }
    
    public void setOperador(int novoOperador)
    {
        operador=novoOperador;
    }
    
    public int getOperador()
    {
        return operador;
    }
    
    public void iniciarOperadores(JTextField NumeroX, JTextField NumeroY, JTextField Resultado)
    {
        int r=0;
        setX(sortearNumeroDoIntervaloXEY(0,9));
        setOperador(sortearNumeroDoIntervaloXEY(1,4));
        if (getOperador()==1) {
            setY(sortearNumeroDoIntervaloXEY(0,9));
            r = getX() + getY();
        }
        if (getOperador()==2) {
            do
                setY(sortearNumeroDoIntervaloXEY(0,9));
            while (getY()>getX());
            r = getX() - getY();
        }
        if (getOperador()==3) {
            setY(sortearNumeroDoIntervaloXEY(0,9));
            r = getX()*getY();
        }
        if (getOperador()==4) {
            do
                setY(sortearNumeroDoIntervaloXEY(1,9));
            while(getX()%getY()!=0);
            r = getX()/getY();
        }
        String novoX = "" + getX();
        String novoY = "" + getY();
        String novoR = "" + r;
        NumeroX.setText(novoX);
        NumeroY.setText(novoY);
        Resultado.setText(novoR);
    }
    
    public void testaRespostaOperadores(int resposta,int opcao, int numeroDeJogadas, JPanel TelaOperadores,JPanel TelaInicio,Ranking rnk,Partida part,Aluno al1, Arquivo arq)
    {
        setResultadoJogador(resposta);
        if(parcial(getOperador(),getResultadoJogador(),getX(),getY())==1)
        {
            setNumeroJogadas(numeroDeJogadas);
            JOptionPane.showMessageDialog(TelaOperadores, "Resposta correta!");
            TelaOperadores.setVisible(false);
            TelaOperadores.setVisible(true);
        }
        else
        {
            setNumeroJogadas(numeroDeJogadas);
            JOptionPane.showMessageDialog(TelaOperadores, "Resposta incorreta!");
            JOptionPane.showMessageDialog(TelaOperadores, "Você acertou "+getAcertos()+" de "+getNumeroJogadas()+".");
            rnk = new Ranking(opcao,getAcertos(),al1.getNome(),null);
            part = new Partida(al1,getAcertos(),getErro(),resultado(getAcertos(),getNumeroJogadas()),getNome());
            arq = new Arquivo();
            arq.escreveTXT(part, "saida");
            TelaOperadores.setVisible(false);
            TelaInicio.setVisible(true);
        }
   
    
}
}
