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
public final class Menu {
    
    private Pilha pilha;
    private Fila fila;
    private Lista lista;
    
    public Menu(){
        boolean erro = true;
        int opcao;
        
            while(erro){
                try {
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Estrutura de Dados\n\nEscolha uma opção:\n\n"
                            + "1- Nova Pilha\n2- Nova Fila\n3- Nova Lista","Menu Principal",JOptionPane.DEFAULT_OPTION));
                    switch(opcao){
                        case(1):{
                            trataErro(this.pilha);
                            break;
                        }
                        case(2):{
                            trataErro(this.fila);
                            break;
                        }
                        case(3):{
                            trataErro(this.lista);
                            break;
                        }
                        default:{
                            String r;
                                r = JOptionPane.showInputDialog(null,"Sair? (S / N)");
                                if(r.equals("s") || r.equals("S")){
                                    JOptionPane.showMessageDialog(null,"@Author: ericlau.githubrrbb@gmail.com  ");
                                    System.exit(0);
                                }
                            break;
                        }
                    }//fim switch
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Valor Inválido!");
                }
            }//fim while (erro)
    }
    
    public void trataErro(Pilha p){
        try {
              p = new Pilha();
                                
            }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Valor Inválido!\n*todos os dados existentes foram triturados!");
            }
    }

    public void trataErro(Fila f){
        try {
              f = new Fila();
                                
            }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Valor Inválido!\n*todos os dados existentes foram triturados!");
            }
    }   
    
    private void trataErro(Lista l){
        try{
            l = new Lista();
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"Valor Inválido!\n*todos os dados existentes foram triturados!");  
        }
    }
}
