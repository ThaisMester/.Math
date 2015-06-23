/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Igor
 */
public class Tabuada extends Jogo {
    public Tabuada() {
        nome = "Tabuada";
    }
    
    public void iniciarTabuada(JTextField NumeroX, JTextField NumeroY)
    {
        setX(sortearNumeroDoIntervaloXEY(0,10));
        setY(sortearNumeroDoIntervaloXEY(0,10));
        String novoX = "" + getX();
        String novoY = "" + getY();
        NumeroX.setText(novoX);
        NumeroY.setText(novoY);
    }
    
    public void testaRespostaTabuada(int resposta, int opcao, int numeroDeJogadas, JPanel TelaTabuada, JPanel TelaInicio, JTextField RespostaTabuada,Ranking rnk,Partida part,Aluno al1,Arquivo arq)
    {
        setResultadoJogador(resposta);
        if (parcial(getX(),getY(),getResultadoJogador())==1)
        {
            setNumeroJogadas(numeroDeJogadas);
            JOptionPane.showMessageDialog(TelaTabuada, "Resposta correta!");
            TelaTabuada.setVisible(false);
            TelaTabuada.setVisible(true);
            RespostaTabuada.setText(null);
        }
        else
        {
            setNumeroJogadas(numeroDeJogadas);
            JOptionPane.showMessageDialog(TelaTabuada, "Resposta incorreta!");
            JOptionPane.showMessageDialog(TelaTabuada, "Você acertou "+getAcertos()+" de "+getNumeroJogadas()+".");
            rnk = new Ranking(opcao,getAcertos(),al1.getNome(),null);
            part = new Partida(al1,getAcertos(),getErro(),resultado(getAcertos(),getNumeroJogadas()),getNome());
            arq = new Arquivo();
            arq.escreveTXT(part, "saida");
            TelaTabuada.setVisible(false);
            TelaInicio.setVisible(true);
        }
    }
}