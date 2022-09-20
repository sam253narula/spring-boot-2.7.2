package com.example.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YearlyFinancialReport {

	@Id
	private Integer id;
	
	@Column(name = "FINANCIAL_YEAR")
	private String year;
	
	@Column(name = "NET_REVENUE")
	private int netRevenue;
	
	@Column(name = "MATERIAL_COST")
	private int materialCost;
	
	@Column(name = "NET_PROFIT")
	private int netProfit;
}
