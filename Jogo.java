/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author Victor
 */
public abstract class Jogo {
    int acertos, erro, numeroJogadas,x,y,resultadoJogador;
    String nome;
    
    Jogo()
    {
        acertos=0;
        erro=0;
        numeroJogadas=0;
        x=0;
        y=0;
        resultadoJogador=0;
    }
    
    Jogo(int novoAcertos,int novoErro, int novoNumeroJogadas, int novoX, int novoY, int novoResultadoJogador)
    {
        acertos=novoAcertos;
        erro=novoErro;
        numeroJogadas=novoNumeroJogadas;
        x=novoX;
        y=novoY;
        resultadoJogador=novoResultadoJogador;
    }
    
    public static int sortearNumeroDoIntervaloXEY(int min, int max)
    {
        int numero = ((int)(java.lang.Math.random()*(max - min + 1)))+ min;
        return numero;
    }
    
    public static int resultado(int acertos, int numeroJogadas)
    {
        if ((float)acertos/(float)numeroJogadas>0.9)
            return 5;
        if (((float)acertos/(float)numeroJogadas>=0.8)&&((float)acertos/(float)numeroJogadas<0.9))
            return 4;
        if(((float)acertos/(float)numeroJogadas>=0.7)&&((float)acertos/(float)numeroJogadas<0.8))
            return 3;
        if(((float)acertos/(float)numeroJogadas>=0.6)&&((float)acertos/(float)numeroJogadas<0.7))
            return 2;
        if((float)acertos/(float)numeroJogadas<0.6)
            return 1;
        return 0;
    }
    
    public int parcial(int operador, int resultPlayer,int x,int y) {
        resultPlayer = this.verificaAmbiguidade(x,y,operador,resultPlayer);
        if(resultPlayer==operador) {
            acertos++;
            return 1;
        }
        else {
            erro++;
            return 2;
        }
    }
    
    public int parcial(int x, int y, int resposta)
    {
        if(x*y==resposta)
        {
            acertos++;
            return 1;
        }
        else
        {
            erro++;
            return 2;
        }
    }
    
    public int parcial(int comparador, int resultPlayer) {
        if(resultPlayer==comparador) {
            acertos++;
            return 1;
        }
        else {
            erro++;
            return 2;
        }
    }
    
    public int verificaAmbiguidade(float X,float Y,int OP,int resPlayer) {
        if(((OP==3)&&(X==0))||((OP==3)&&(Y==1)))
            return OP;
        else
            if(((OP==4)&&(X==0))||((OP==4)&&(Y==1)))
                return OP;
            else
                if((OP==1)&&(Y==0))
                    return OP;
                else
                    if((OP==2)&&(Y==0))
                        return OP;
                    else
                        return resPlayer;
    }
    
    public int getAcertos()
    {
        return acertos;
    }
    
    public int getErro()
    {
        return erro;
    }
    
    public void setErro(int nErro)
    {
        erro=nErro;
    }
    
    public void setAcertos(int nAcertos)
    {
        acertos=nAcertos;
    }
    
    public int getNumeroJogadas()
    {
        return numeroJogadas;
    }
    
    public void setNumeroJogadas(int nNumeroJogadas)
    {
        numeroJogadas=nNumeroJogadas;
    }
    
     public void setX(int novoX)
    {
        x=novoX;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setY(int novoY)
    {
        y=novoY;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setResultadoJogador(int novoResultadoJogador)
    {
        resultadoJogador=novoResultadoJogador;
    }
    
    public int getResultadoJogador()
    {
        return resultadoJogador;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
