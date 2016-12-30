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
public final class Pilha extends LittleData {
    
            private String conf;
            private int p = 0;
    
            // Construtor

            public Pilha(){
               this.il = null;
               int opcao;
               boolean ativa = true;
               while(ativa){
                   opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha um opção\n"
                           + "1- Iniciar\n2- Remover\n3- Inserir\n4- Mostrar","Estrutura - PILHA",JOptionPane.QUESTION_MESSAGE));
                   switch(opcao){
                       case(1):{
                           iniciar();
                           break;
                       }
                       case(2):{
                           removerFinal();
                           break;
                       }
                       case(3):{
                           inserir();
                           break;
                       }
                       case(4):{
                           mostre();
                           break;
                       }
                       case(999):{
                           geradorLista();
                           break;
                       }
                       case(2249):{
                           mostreTudo();
                           break;
                       }
                       default:{
                           String r = JOptionPane.showInputDialog(null,"Voltar ao menu principal ? (S / N)\n*a pilha será apagada caso saia");
                           if(r.equals("s") || r.equals("S")){
                               ativa = false;
                           }
                           break;
                       }
                   }
               }
            
            
            }
          
          @Override
          public void iniciar(){
              if(this.il == null){
                  this.aux = new LittleData();
                  /*this.aux.setCodigo(gerarCodigo());
                  this.aux.setNome(gerarNome());
                  this.il = aux;
                  this.il.setProx(null);
                  this.fl = this.il;*/
                  
                  try {
                      this.aux.setCodigo(Integer.parseInt(JOptionPane.showInputDialog(null,"Codigo: ")));
                      this.aux.setNome(JOptionPane.showInputDialog(null,"Nome: "));
                      this.conf = JOptionPane.showInputDialog(null,"Confima? (S / N)");
                      if(this.conf.equals("s") || this.conf.equals("S")){
                          this.il = aux;
                          this.il.setProx(null);
                          this.fl = this.il;
                      }
                      
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null,"Incompatibilidade de Tipos");
                  }//fim catch*/
              }else{
                  JOptionPane.showMessageDialog(null,"Já foi iniciada!");
              }
          }
          
          @Override
          public void removerFinal(){
              if(this.il != null){
                  if(this.il == this.fl){
                      try {
                          this.conf = JOptionPane.showInputDialog(null,"Remover ["+this.fl.getNome()+"] ? (S / N)");
                          if(this.conf.equals("s") || this.conf.equals("S")){
                               this.il = this.il.getProx();
                               p=0;
                          }else {
                              JOptionPane.showMessageDialog(null,"Nenhum dado foi removido!");
                          }
                         
                      }catch(Exception e){
                          JOptionPane.showMessageDialog(null,"Erro de Entrada - Nenhum dado foi removido!");
                      }
                      
                  }else {
                          
                        try {
                          this.conf = JOptionPane.showInputDialog(null,"Remover ["+this.fl.getNome()+"] ? (S / N)");
                          if(this.conf.equals("s") || this.conf.equals("S")){
                               this.aux = this.il;
                               while(this.aux.getProx() != this.fl){
                                  this.aux = this.aux.getProx();
                               }
                               this.aux.setProx(null);
                               this.fl = this.aux;
                               p--;
                          }else {
                              JOptionPane.showMessageDialog(null,"Nenhum dado foi removido!");
                          }
                         
                      }catch(Exception e){
                          JOptionPane.showMessageDialog(null,"Erro de Entrada - Nenhum dado foi removido!\nReinicie a operação no menu");
                      }
                  }
                  
              }else {
                  JOptionPane.showMessageDialog(null,"Não há dados!");
              }
          }
          
          @Override
          public void mostre(){
              if(this.il != null){
                  JOptionPane.showMessageDialog(null,"Codigo: " + this.fl.getCodigo() + "\nNome: " + this.fl.getNome());
              }else{
                  JOptionPane.showMessageDialog(null,"Não há dados!");
              }
          }
          
          @Override
          public void inserir(){
              if(this.il != null){
                  this.aux = new LittleData();
                  try{
                      this.aux.setCodigo(Integer.parseInt(JOptionPane.showInputDialog(null,"Código: ")));
                      this.aux.setNome(JOptionPane.showInputDialog(null,"Nome: "));
                      this.conf = JOptionPane.showInputDialog(null,"Confirma? (S / N)");
                      if(this.conf.equals("s") || this.conf.equals("S")){
                          this.fl.setProx(this.aux);
                          this.fl = aux;
                          this.fl.setProx(null);
                          p++;
                      }else{
                          JOptionPane.showMessageDialog(null,"Ação Cancelada, os dados foram perdidos!");
                      }
                      
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null,"Error! Os dados foram perdidos!\nReinicie a operação no menu");
                  }
              }else{
                  iniciar();
              }
          }
          
        private void geradorLista(){
            this.il = null;
            
            for(int i=0; i<100; i++){
                this.aux = new LittleData();
                this.aux.setCodigo(gerarCodigo());
                this.aux.setNome(gerarNome());
                if(i<1){
                    this.il = aux;
                    this.il.setProx(null);
                    this.fl = this.il;
                }else{
                    this.fl.setProx(this.aux);
                    this.fl = this.aux;
                    this.fl.setProx(null);
                }
                p++;
            }
            JOptionPane.showMessageDialog(null,"Uma Pilha com 100 elementos foi gerada!");
        }
        
        @Override
        public void mostreTudo(){
            LittleData fim;
            if(il!=null){
                this.aux = this.il;
                fim = this.fl;
                while(this.il != fim){
                JOptionPane.showMessageDialog(null,"Codigo: " + fim.getCodigo() + "\nNome: " + fim.getNome(),p+"ª posição",JOptionPane.INFORMATION_MESSAGE);
                p--;
                while(this.aux.getProx()!= fim){
                     this.aux = this.aux.getProx();
                    }
                  fim = this.aux;
                  this.aux = this.il;
                }
                JOptionPane.showMessageDialog(null,"Codigo: " + fim.getCodigo() + "\nNome: " + fim.getNome(),p+"ª posição",JOptionPane.INFORMATION_MESSAGE);
            }
        }
   
}//fim Classe
