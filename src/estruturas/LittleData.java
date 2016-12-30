/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

/**
 *
 * @author eric
 */
public  class LittleData implements Botoes{
    
    private int codigo;
    private String nome;
    private LittleData prox;
    protected LittleData il,fl,aux;
    
    // Metodos Publicos
   
    public int gerarCodigo(int num){
        int x = (int) (0+Math.random()*(num-0));
        return x;
    }
    
    public int gerarCodigo(){
        int x = (int) (0+Math.random()*(1000-0));
        return x;
    }
    
    public String gerarNome(){
        String no[] = {"Dipper","Mabel","Joel","Peach","Mario Bros","Ellie","Coringa","Arlequina","Piramide Head","Manequin de Mulher"};
        String sn[] = {"Adolescente Rebelde","Viaja nos Cogumelos","Mad Hatter","Arrasta Faca","Sem Braços","Não está neste Castelo",
            "Louca dos Gatos","Fã da Taylor Swift","Sem Criatividade","Meu nome é Nome"};
        return no[gerarCodigo(10)] + " "+ sn[gerarCodigo(10)];
    }
    
    
    // Métodos Especiais
    
    protected void setCodigo(int c){
        this.codigo = c;
    }
    
    protected int getCodigo(){
        return this.codigo;
    }
    
    protected void setNome(String n){
        this.nome = n;
    }
    
    protected String getNome(){
        return this.nome;
    }
    
    protected void setProx(LittleData lsd){
        this.prox = lsd;
    }
    
    protected LittleData getProx(){
        return this.prox;
    }

    // Métodos Abstratos
    
    @Override
    public void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchRemove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void busca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostreTudo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
