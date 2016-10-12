package com.nemo.mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ajay.kg created on 12/10/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;

}
