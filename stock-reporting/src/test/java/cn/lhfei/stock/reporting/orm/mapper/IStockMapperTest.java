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
package cn.lhfei.stock.reporting.orm.mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lhfei.stock.reporting.model.StockModel;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since  Apr 26, 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class IStockMapperTest {

	private static final Logger log = LoggerFactory.getLogger(IStockMapperTest.class);
	
	@Test
	public void create() {
		String input = "src/test/resources/data/input/stock_daily.txt";
		
		FileReader fr = null;
		BufferedReader reader = null;
		
		List<StockModel> ipList = new ArrayList<StockModel>();
		
		String code = "";
		String date = "";
		String week = "";
		String openingPrice = "";
		String maxPrice = "";
		String minPrice = "";
		String closingPrice = "";
		String turnover = "";
		String totalVolume = "";
		
		try {
			fr = new FileReader(new File(input));
			reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			
			
			
			int steps = 0;
			
			while(line != null){
				String[] items = line.split("\\t");

				if(items.length >0 && items[0] != null){
					code = items[0].trim();
				}
				if(items.length >1 && items[1] != null){
					date = items[1].trim();
				}
				if(items.length >2 && items[2] != null){
					week = items[2].trim();
				}
				if(items.length >3 && items[3] != null){
					openingPrice = items[3].trim();
				}
				if(items.length >4 && items[4] != null){
					maxPrice = items[4].trim();
				}
				
				if(items.length >5 && items[5] != null){
					minPrice = items[5].trim();
				}
				if(items.length >6 && items[6] != null){
					closingPrice = items[6].trim();
				}
				if(items.length >7 && items[7] != null){
					turnover = items[7].trim();
				}
				if(items.length >8 && items[8] != null){
					totalVolume = items[8].trim();
				}
				
				
				StockModel model = new StockModel();

				model.setCode(code);
				model.setDate(SIMPLE_DATE_FORMAT.parse(date));
				model.setWeek(Integer.parseInt(week));
				model.setOpeningPrice(Double.parseDouble(openingPrice));
				model.setMaxPrice(Double.parseDouble(maxPrice));
				model.setMinPrice(Double.parseDouble(minPrice));
				model.setClosingPrice(Double.parseDouble(closingPrice));
				model.setTurnover(Integer.parseInt(turnover));
				model.setTotalVolume(Double.parseDouble(totalVolume));
				
				ipList.add(model);
				
				if(steps > 0 && steps % BATCH_SIZE == 0){
					stockMapper.createStockLog(ipList);
					ipList = new ArrayList<StockModel>();
				}
				
				line = reader.readLine();
				steps++;
			}
			
			if(ipList.size() > 0){
				stockMapper.createStockLog(ipList);;
				
				ipList = new ArrayList<StockModel>();
			}
			
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (ParseException e) {
			log.error("{}", totalVolume);
			e.printStackTrace();
		}			
	}
	
	private static final int BATCH_SIZE = 1000;
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private IStockMapper stockMapper;
}
