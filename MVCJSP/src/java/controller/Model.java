package controller;
import java.io.Serializable;
import java.sql.Connection;

/**
 *
 * @author RODRIGO
*Esta classe controla o asseco ao banco de dados
*Teremos os seguintes metodos:
*inserir, pesquisar*, editar, atualizar, excluir
* pesquisar(listar e listar todos)
*/
public class Model implements Serializable{
    //declarar as variáveis que ultilizaremos ao longo
    //desta classe
    
    //variável que irá receber uma conexão do banco
    private Connection connection = null;
    
    //variável para retomar o estado de uma operação
    private String statusMessage;
    
    //metudos da classe
    public void insert(Object aluno){
        this.statusMessage = "Inserido com sucesso!";
    } 
   
}
