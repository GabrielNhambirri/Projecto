/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;

/**
 *
 * @author admin
 */
public interface Menus {
    //Interface com Strings usadas nos menus
    
    public final String MENU_PRINCIPAL =
              "        MENU        \n"
            + "--------------------\n"
            + "[1] - Gestao\n" 
            + "[2] - Estaticas\n"
            + "[3] - Pesquisas\n"
            + "[4] - Listagens";
    
    public final String MENU_GESTAO =
              "--------------------\n"
            + "        GESTÃO      \n"
            + "--------------------\n"
            + "[1] - Inserir nova equipe\n"
            + "[2] - Atualizar uma equipe\n"
            + "[3] - Remover uma equipe\n"
            + "[4] - Inserir novo jogo\n"
            + "[5] - Atualizar um jogo\n"
            + "[6] - Eliminar Jogo\n";
    
    public final String MENU_ESTATISTICAS =
              "--------------------\n"
            + "    ESTATISTICAS    \n"
            + "--------------------\n"
            + "[1] - Equipe com mais golos marcados\n"
            + "[2] - Equipe com mais golos sofridos\n"
            + "[3] - Equipe com media de idade mais alta\n"
            + "[4] - Equipe com media de idade mais baixa\n"
            + "[5] - Jogador(es) mais velho(s)\n"
            + "[6] - Jogador(es) mais novo(s)\n"
            + "[7] - Jogo(s) com mais golos\n"
            + "[8] - Jogo com menos golos\n";
    
    public final String MENU_PESQUISAS =
              "--------------------\n"
            + "      PESQUISAR     \n"
            + "--------------------\n"
            + "[1] - Jogador\n"
            + "[2] - Jogos\n";
    
    public final String MENU_LISTAGEM =
              "--------------------\n"
            + "        LISTAR      \n"
            + "--------------------\n"
            + "[1] - Equipes\n"
            + "[2] - Jogos\n";
    
    public final String MENU_ACTUALIZAR_EQUIPE =
              "--------------------------\n"
            + "      ACTUALIZAR_EQUIPE   \n"
            + "--------------------------\n"
            + "[1] - Nome da Equipe\n"
            + "[2] - Nome do Treinador\n"
            + "[3] - Adicionar Jogador\n"
            + "[4] - Remover Jogador";
         
    
}
