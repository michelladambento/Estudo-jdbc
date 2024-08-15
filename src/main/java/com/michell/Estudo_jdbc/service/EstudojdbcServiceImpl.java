package com.michell.Estudo_jdbc.service;

import com.michell.Estudo_jdbc.database.DatabaseConnection;
import com.michell.Estudo_jdbc.entities.Produto;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudojdbcServiceImpl implements EstudojdbcService {


    @Override
    public List<Produto> findAllProdutc() {
        String query = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {


            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getLong("id"));
                produto.setDescription(resultSet.getString("description"));
                produto.setQtd(resultSet.getInt("qtd"));
                produto.setPrice(resultSet.getBigDecimal("price"));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;

    }

}
