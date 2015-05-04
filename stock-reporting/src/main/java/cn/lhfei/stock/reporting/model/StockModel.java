/*
 * Copyright 2010-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.lhfei.stock.reporting.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since  Apr 26, 2015
 */
public class StockModel implements Serializable {

	private static final long serialVersionUID = 4773521058899667129L;
	

	/**
	 * @return 股票代码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code 股票代码 to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return 交易日期
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date 交易日期to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return 星期
	 */
	public int getWeek() {
		return week;
	}
	/**
	 * @param 星期
	 */
	public void setWeek(int week) {
		this.week = week;
	}
	/**
	 * @return 开盘价
	 */
	public double getOpeningPrice() {
		return openingPrice;
	}
	/**
	 * @param openingPrice 开盘价 to set
	 */
	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}
	/**
	 * @return the maxPrice
	 */
	public double getMaxPrice() {
		return maxPrice;
	}
	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	/**
	 * @return the minPrice
	 */
	public double getMinPrice() {
		return minPrice;
	}
	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	/**
	 * @return the closingPrice
	 */
	public double getClosingPrice() {
		return closingPrice;
	}
	/**
	 * @param closingPrice the closingPrice to set
	 */
	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}
	/**
	 * @return 成交量
	 */
	public int getTurnover() {
		return turnover;
	}
	/**
	 * @param 成交量
	 */
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	/**
	 * @return 成交额
	 */
	public double getTotalVolume() {
		return totalVolume;
	}
	/**
	 * @param 成交额
	 */
	public void setTotalVolume(double totalVolume) {
		this.totalVolume = totalVolume;
	}
	
	
	private String code;			// 股票代码
	private Date date;			// 交易日期
	private int week;				// 星期
	private double openingPrice;	// 开盘价 
	private double maxPrice;
	private double minPrice;
	private double closingPrice;	// 收盘价
	private int turnover;			// 成交量
	private double totalVolume;		// 成交额

}
