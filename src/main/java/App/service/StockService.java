package App.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import App.model.movers.GainersList;
import App.model.movers.GainersLoosers;
import App.model.quotes.*;
import App.util.RestAPIUtils;

@Service
public class StockService {
	
	private  RestAPIUtils restUtil;
	
	public List<StockQuote> getStockQuotesList(String symbol)  throws Exception {


		String restUrl = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols="+symbol+"&apikey=26C16QLPBCODOWQ9";
		String strResponse = null;
		List<StockQuote> stockList = null; 
		try {
			
			restUtil = new RestAPIUtils();
			
			strResponse = restUtil.getResponseBodyString(restUtil.getHttpGetResponse(restUrl));
			ObjectMapper mapper = new ObjectMapper();

			//JSON from String to Object
			Quotes quotesData = mapper.readValue(strResponse, Quotes.class);
			stockList = quotesData.getStockQuotes();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return stockList;
		
	}
	
	public List<GainersList> getStockGainersList()  throws Exception {
		List<GainersLoosers> gainersList = null; 
		String restUrl = "https://api.iextrading.com/1.0/stock/market/list/gainers";
		String strResponse = null;
		String finalResponse = null;

		restUtil = new RestAPIUtils();
		
		strResponse = restUtil.getResponseBodyString(restUtil.getHttpGetResponse(restUrl));
		
		finalResponse = "{ \"GainersList\":" + strResponse + "}";
		  		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from String to Object
		GainersLoosers gainersLoosersObj = mapper.readValue(finalResponse, GainersLoosers.class);
		return gainersLoosersObj.getGainersList();
		
	}

	public List<GainersList> getStockLoosersList()  throws Exception {
		List<GainersLoosers> gainersList = null; 
		String restUrl = "https://api.iextrading.com/1.0/stock/market/list/losers";
		String strResponse = null;
		String finalResponse = null;

		restUtil = new RestAPIUtils();
		
		strResponse = restUtil.getResponseBodyString(restUtil.getHttpGetResponse(restUrl));
		
		finalResponse = "{ \"GainersList\":" + strResponse + "}";
		  		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from String to Object
		GainersLoosers loosersObj = mapper.readValue(finalResponse, GainersLoosers.class);
		return loosersObj.getGainersList();
		
	}

	public List<GainersList> getMostActiveList()  throws Exception {
		List<GainersLoosers> gainersList = null; 
		String restUrl = "https://api.iextrading.com/1.0/stock/market/list/mostactive";
		String strResponse = null;
		String finalResponse = null;

		restUtil = new RestAPIUtils();
		
		strResponse = restUtil.getResponseBodyString(restUtil.getHttpGetResponse(restUrl));
		
		finalResponse = "{ \"GainersList\":" + strResponse + "}";
		  		
		ObjectMapper mapper = new ObjectMapper();

		//JSON from String to Object
		GainersLoosers moversObj = mapper.readValue(finalResponse, GainersLoosers.class);
		return moversObj.getGainersList();
		
	}
	


}
