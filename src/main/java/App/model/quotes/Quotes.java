package App.model.quotes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Meta Data",
"Stock Quotes"
})
public class Quotes {

@JsonProperty("Meta Data")
private MetaData metaData;
@JsonProperty("Stock Quotes")
private List<StockQuote> stockQuotes = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Quotes() {
}

/**
* 
* @param stockQuotes
* @param metaData
*/
public Quotes(MetaData metaData, List<StockQuote> stockQuotes) {
super();
this.metaData = metaData;
this.stockQuotes = stockQuotes;
}

@JsonProperty("Meta Data")
public MetaData getMetaData() {
return metaData;
}

@JsonProperty("Meta Data")
public void setMetaData(MetaData metaData) {
this.metaData = metaData;
}

@JsonProperty("Stock Quotes")
public List<StockQuote> getStockQuotes() {
return stockQuotes;
}

@JsonProperty("Stock Quotes")
public void setStockQuotes(List<StockQuote> stockQuotes) {
this.stockQuotes = stockQuotes;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}