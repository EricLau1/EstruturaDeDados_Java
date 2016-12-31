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
public final class Lista extends LittleData{
    
    private String conf;
    private boolean ativa;
    
    public Lista(){
        this.il = null;
        this.ativa = true;
        int opcao;
        while(this.ativa){
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma opção:\n"
                    + "1- Iniciar\n2- Mostar Lista\n3- Inserir no Inicio\n4- Inserir no Final\n"
                    + "5- Remover no Inicio\n6- Remover no Final\n7- searchRemove\n8- Busca\n9- Ordenar"));
            switch(opcao){
                case(1):{
                    iniciar();
                    break;
                }
                case(2):{
                    mostreTudo();
                    break;
                }
                case(3):{
                    inserirInicio();
                    break;
                }
                case(4):{
                    inserirFinal();
                    break;
                }
                case(5):{
                    removerInicio();
                    break;
                }
                case(6):{
                    removerFinal();
                    break;
                }
                case(7):{
                    searchRemove();
                    break;
                }
                case(8):{
                    busca();
                    break;
                }
                case(9):{
                    ordenar();
                    break;
                }
                case(853211):{
                    gerarLista();
                    break;
                }
                default:{
                    this.conf = JOptionPane.showInputDialog(null,"Sair? (S / N)\n*se sair todos os dados da lista serão apagados!");
                    if(this.conf.equals("s") || this.conf.equals("S")){
                        this.ativa = false;
                    }
                    break;
                }
                
                
            }//fim switch
        }//fim while
        
    }
    
    @Override
    public void iniciar(){
        if(this.il == null){
            this.aux = new LittleData();
            this.aux = leDados(aux);
            if(this.aux != null){
                this.il = this.aux;
                this.il.setProx(null);
            }else{
                JOptionPane.showMessageDialog(null,"Tente novamente!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Ja foi iniciada!");
        }
    }
    
    @Override
    public void mostreTudo(){
        if(this.il != null){
            this.aux = this.il;
            while(this.aux != null){
                tabela(this.aux);
                this.aux = this.aux.getProx();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Não há dados!");
        }
    }
    
    @Override
    public void inserirInicio(){
        if(this.il != null){
            this.aux = new LittleData();
            this.aux = leDados(this.aux);
            if(this.aux != null){
                this.aux.setProx(this.il);
                this.il = this.aux;
            }else{
                JOptionPane.showMessageDialog(null,"Tente novamente!");
            }
        }else{
            iniciar();
        }
    }
    
    private void tabela(LittleData a){
        JOptionPane.showMessageDialog(null,"Código: "+a.getCodigo()+"\nNome: "+a.getNome());
    }
    
    @Override
    public void inserirFinal(){
        if(this.il != null){
            this.aux = new LittleData();
            this.aux = leDados(this.aux);
            if(this.aux != null){
                this.fl = this.il;
                while(this.fl.getProx() != null){
                    this.fl = this.fl.getProx();
                }
                this.fl.setProx(this.aux);
                this.aux.setProx(null);
            }else{
                JOptionPane.showMessageDialog(null,"Tente Novamente!");
            }
        }else{
            iniciar();
        }
    }
    
    @Override
    public void removerInicio(){
        if(this.il != null){
            if(erroRemove(this.il)){ //se retornar verdade
                this.il = this.il.getProx(); //inicio da lista recebe o endereço que ela aponta
            }else{
                JOptionPane.showMessageDialog(null,"Nenhum dado foi removido!");
            }
        }else{
           JOptionPane.showMessageDialog(null,"Não há dados!"); 
        }
    }
    
    @Override
    public void removerFinal(){
        if(this.il != null){
            if(this.il.getProx() == null){
                removerInicio();
            }else{
            this.fl = this.il;
            while(this.fl.getProx()!= null){ //quando a variavel prox apontar para nulo quer dizer ele é o ultimo da lista
            this.aux = this.fl; //recebe todos endenreços de fl menos o ultimo e por consequencia ele terminara com o penultimo endereço
            this.fl = this.fl.getProx();
              }
            if(erroRemove(this.fl)){
                this.aux.setProx(null);
            }else{
                JOptionPane.showMessageDialog(null,"Nenhum dados foi apagado!");
            }
          }
        }else{
            JOptionPane.showMessageDialog(null,"Não há dados!");
        }
    }
    
    @Override
    public void searchRemove(){
        if(this.il != null){
            try{
              int c = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo: "));
              this.fl = busca(c);
              if(this.fl != null){
                  if(this.fl == this.il){
                      removerInicio();
                  }else{
                      this.aux = this.il;
                      while(this.aux.getProx() != this.fl){
                          this.aux = this.aux.getProx();
                      }
                      if(erroRemove(this.fl)){ 
                          this.aux.setProx(this.fl.getProx()); // aux vai apontar para o endereço que fl aponta
                      }else{
                          JOptionPane.showMessageDialog(null,"Nenhum dado foi removido!");
                      }
                  }
              }else{
                  JOptionPane.showMessageDialog(null,"Não existe este código na lista!");
              }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Valor inválido!");
            }
        }
    }
    
    @Override
    public void busca(){
        if(this.il != null){
            try{
                int c = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o Código:"));
                this.aux = busca(c);
                if(this.aux != null){
                    tabela(this.aux);
                }else{
                    JOptionPane.showMessageDialog(null,"Não existe este código na lista!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Valor inválido!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Não há dados!");
        }
    }
    
    public LittleData busca(int x){
        this.fl = this.il;
        while(this.fl!=null){
            if(this.fl.getCodigo() == x){
               return this.fl;
            }
            this.fl = this.fl.getProx();
        }
        return null;
    }
    
    public boolean erroRemove(LittleData a){
        try {
           this.conf = JOptionPane.showInputDialog(null,"Remover ["+a.getNome()+"] ? (S / N)");
           if(this.conf.equals("s") || this.conf.equals("S")){
               return true;
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Valor inválido!");
        }
        return false;
    }
    
    public LittleData leDados(LittleData a){
            try {
                a.setCodigo(verifica(gerarCodigo()));
                JOptionPane.showMessageDialog(null,"Seu código será: "+a.getCodigo());
                a.setNome(JOptionPane.showInputDialog(null,"Nome:"));
                this.conf = JOptionPane.showInputDialog(null,"Confirma? (S / N)");
                if(this.conf.equals("s") || this.conf.equals("S")){
                    return a;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Valor Inválido, os dados foram perdidos!");
            }
        return null;
    }
    
    private int verifica(int x){
        LittleData ver;
        ver = this.il;
        while(ver != null){ // aux irá percorrer toda a lista
            if(ver.getCodigo() == x){ //se ja houver um numero igual na lista
                x = gerarCodigo(51); // x recebe um novo numero aleatorio
                ver = this.il; // aux é reiniciada
                continue; //este comando faz o programa ignorar os proximos comandos até o final do while
            }
            ver = ver.getProx();
        }
        return x; //só retorna um numero que não tenha lista
    }
    
    private void gerarLista(){
        for(int i=0; i<50; i++){
           this.aux = new LittleData();
           this.aux.setCodigo(verifica(gerarCodigo(51)));
           this.aux.setNome(gerarNome());
           if(i<1){
           this.il = this.aux;
           this.fl = this.il;
           }else{
              this.aux.setProx(null); 
              this.fl.setProx(this.aux);
              this.fl = this.fl.getProx();
           }
        }
        JOptionPane.showMessageDialog(null,"Uma lista com 50 elementos foi gerada!");
    }
    
    public void ordenar(){
        int p = 0;
        if(this.il != null){
            this.fl = this.il;
            while(this.fl != null){
                p++;
                this.fl = this.fl.getProx();
            }
            this.fl = this.il;
            LittleData n[] = new LittleData[p];
            for(int i=0; i<p; i++){
                n[i] = this.fl;
                this.fl = this.fl.getProx();
            }
            LittleData box;
            for(int i=0; i<p-1; i++){
                for(int j=i+1; j<p; j++){
                   if(n[i].getCodigo() > n[j].getCodigo()){
                       box = n[i];
                       n[i] = n[j]; // n[i] tem que ficar sempre com o menor numero
                       n[j] = box;
                    }
                }
            }
            
            this.il = n[0];
            this.aux = this.il;
            for(int i=1; i<p; i++){
                this.aux.setProx(n[i]);
                this.aux = this.aux.getProx();
            }
            this.aux.setProx(null);
            JOptionPane.showMessageDialog(null,"A lista foi Ordenada!");
        }else{
            JOptionPane.showMessageDialog(null,"Não há dados!");
        }
    }
    
   
}
