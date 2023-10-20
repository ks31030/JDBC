package com.kh.dtoProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productModel {
	private Connection connection;
	public productModel(Connection connection) {
		this.connection = connection;
	}
	public List<productDTO> getProducts(){
		List<productDTO> products = new ArrayList<>();
		String query = "SELECT * FROM PRODUCTS";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				productDTO product = new productDTO();
				product.setProductId(result.getInt("product_id"));
				product.setProductName(result.getString("product_name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				product.setStockQuantity(result.getInt("stock_quantity"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
