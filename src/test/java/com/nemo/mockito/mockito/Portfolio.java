package com.nemo.mockito.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ajay.kg created on 12/10/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

	private List<Stock> stocks;
	private StockService stockService;

	public Double getMarketValue() {
		Double finalPrice = 0.0;

		for(Stock stock : stocks) {
			System.out.println("stock: " + stock.toString());
			finalPrice += stock.getQuantity()*stockService.getPrice(stock);
		}

		return finalPrice;
	}
}
