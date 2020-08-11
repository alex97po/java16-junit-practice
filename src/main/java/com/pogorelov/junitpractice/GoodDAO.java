package com.pogorelov.junitpractice;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO {

    private ConnectionFactory connection = new ConnectionFactory();

    public List<Good> findAllGoods() {
        List<Good> goods = new ArrayList<>();
        try {
            ResultSet resultSet = connection.getStatement().executeQuery("SELECT * FROM catalog");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                BigDecimal singleCost = resultSet.getBigDecimal("singlecost");
                BigDecimal promoCost = resultSet.getBigDecimal("promocost");
                Integer promoCount = resultSet.getInt("promocount");
                goods.add(new Good(name, singleCost, promoCount, promoCost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
}
