package dao;

import dao.implementation.*;
import model.Pessoa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PessoasDAO {


    public void save() throws SQLException{
        String nome = JOptionPane.showInputDialog("Nome:");
        String perfil = JOptionPane.showInputDialog("Perfil");
        Pessoa newPessoa = new Pessoa(nome,perfil);
        InsertIntoDatabase insert = new InsertIntoDatabase();
        insert.function(newPessoa);
    }

    public void delete() throws SQLException{
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id."));
        DeleteByID delete = new DeleteByID();
        delete.function(id);
    }

    public void searchID() throws SQLException{
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id."));
        SearchByID search = new SearchByID();
        search.funcion(id);
    }

    public void updateID() throws SQLException{
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID que será atualizado."));
        String nome = JOptionPane.showInputDialog("Novo nome:");
        String perfil = JOptionPane.showInputDialog("Perfil");
        Pessoa newPessoa = new Pessoa(nome,perfil);
        UpdateAtID update = new UpdateAtID();
        update.function(id, newPessoa);
    }

    public void list() throws SQLException{
        ListDataBase list = new ListDataBase();
        list.function();
    }
}
