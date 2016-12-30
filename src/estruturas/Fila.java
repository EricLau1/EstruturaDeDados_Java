/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import javax.swing.JOptionPane;

/**
 *
 * @author eric
 */
public final class Fila extends LittleData {
    
   private boolean ativa;
   private String conf;
    
    public Fila(){
        this.ativa = true;
        this.il = null;
        int opcao;
        while(this.ativa){
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma opção:\n1- Iniciar\n2- Mostre\n3- Inserir\n4- Remover",
                    "Estrutura - FILA",JOptionPane.QUESTION_MESSAGE));
            switch(opcao){
                case(1):{
                    iniciar();
                    break;
                }
                case(2):{
                    mostre();
                    break;
                }
                case(3):{
                    inserir();
                    break;
                }
                case(4):{
                    removerInicio();
                    break;
                }
                default:{
                    this.conf = JOptionPane.showInputDialog(null,"Voltar menu principal? (S / N)\n"
                            + "*a fila atual será apagada! ");
                    if(this.conf.equals("s") || this.conf.equals("S")){
                        this.ativa = false;
                    }
                    break;
                }
            }//fim switch
        }
    }
    
    @Override
    public void iniciar(){
        if(this.il == null){
            this.aux = new LittleData();
            this.aux = erroData(this.aux);
            if(this.aux != null){
                this.il = this.aux;
                this.il.setProx(null);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Ja foi iniciada!");
        }
    }
    
    @Override
    public void mostre(){
        if(this.il != null){
            JOptionPane.showMessageDialog(null,"Código: "+this.il.getCodigo()+"\nNome: "+this.il.getNome());
        }else{
            JOptionPane.showMessageDialog(null,"Não há dados!");
        }
    }
    
    @Override
    public void inserir(){
        if(this.il != null){
            this.aux = new LittleData();
            this.aux = erroData(this.aux);
            if(this.aux != null){
                this.fl = this.il;
                while(this.fl.getProx()!= null){
                    this.fl.setProx(this.fl.getProx());
                }
                this.fl.setProx(this.aux);
            }else{
                JOptionPane.showMessageDialog(null,"Dados não foram adicionados!");
            }
        }else{
            iniciar();
        }
    }
    
    @Override
    public void removerInicio(){
        if(this.il != null){
            try{
                this.conf = JOptionPane.showInputDialog(null,"Remover ["+this.il.getNome()+"] ? (S / N)");
                if(this.conf.equals("s") || this.conf.equals("S")){
                   this.il = this.il.getProx();
                }else{
                   JOptionPane.showMessageDialog(null,"Nenhum dado foi removido!");
                }
            }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Nenhum dado foi removido!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Não há dados!");
        }
    }
    
    protected LittleData erroData(LittleData a){
        try {
            a.setCodigo(Integer.parseInt(JOptionPane.showInputDialog(null,"Código:")));
            a.setNome(JOptionPane.showInputDialog(null,"Nome:"));
            this.conf = JOptionPane.showInputDialog(null,"Confirma? (S / N)");
            if(this.conf.equals("s") || this.conf.equals("S")){
                return a;
            }else{
                JOptionPane.showMessageDialog(null,"Ação cancelada, nenhum dado adicionado!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Valor Invalido");
        }
        return null;
    }
    
}
