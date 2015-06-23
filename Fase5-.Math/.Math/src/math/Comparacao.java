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
 * @author Thaís
 */
public class Comparacao extends Jogo {
    int comp;
    private String[] comparadores = {"MAIOR QUE", "MENOR QUE"};
    
     Comparacao() {
       comp = 0;
       nome = "Comparacao";
        
     }
    
    
    public void setComp(int novoComp)
    {
        comp=novoComp;
    }
    
    public int getComp()
    {
        return comp;
    }
    
    public void iniciarComparacao(JTextField NumeroX, JTextField NumeroY)
    {
        
        setX(sortearNumeroDoIntervaloXEY(-10,10));
        setComp(sortearNumeroDoIntervaloXEY(1, 2));
        if (getComp()==1) {
            do
                setY(sortearNumeroDoIntervaloXEY(-10,10));
            while (getY()>=getX());
        
        
        }
        if(getComp()==2)
        {
            do
                setY(sortearNumeroDoIntervaloXEY(-10,10));
            while (getY()<=getX());
        }
        String novoX = null;
        if(getX()==-10)
            novoX = "" + getX();
        else
            if((getX()>-10)&&(getX()<0))
                novoX = " " + getX();
            else
                if(getX()>=0)
                    novoX = "  " + getX();
        String novoY = null;
        novoY = "" + getY();
        NumeroX.setText(novoX);
        NumeroY.setText(novoY);
    }
    
    public void testaRespostaComparacao(int resposta, JPanel TelaComp, JPanel TelaInicio,int numeroDeJogadas, int opcao, Aluno al1, Ranking rnk, Partida part, Arquivo arq)
    {
        setResultadoJogador(resposta);
        if(parcial(getComp(),getResultadoJogador())==1)
        {
            setNumeroJogadas(numeroDeJogadas);
            JOptionPane.showMessageDialog(TelaComp,"Resposta correta!");
            TelaComp.setVisible(false);
            TelaComp.setVisible(true);
        }
        else
        {
            setNumeroJogadas(numeroDeJogadas);
            JOptionPane.showMessageDialog(TelaComp, "Resposta incorreta!");
            JOptionPane.showMessageDialog(TelaComp, "Você acertou "+getAcertos()+" de "+getNumeroJogadas()+".");
            rnk = new Ranking(opcao,getAcertos(),al1.getNome(),null);
            part = new Partida(al1,getAcertos(),getErro(),resultado(getAcertos(),getNumeroJogadas()),getNome());
            arq = new Arquivo();
            arq.escreveTXT(part, "saida");
            TelaComp.setVisible(false);
            TelaInicio.setVisible(true);
        }
    }
}
