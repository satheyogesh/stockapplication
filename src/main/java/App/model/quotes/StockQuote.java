package App.model.quotes;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"1. symbol",
"2. price",
"3. volume",
"4. timestamp"
})
public class StockQuote {

@JsonProperty("1. symbol")
private String _1Symbol;
@JsonProperty("2. price")
private String _2Price;
@JsonProperty("3. volume")
private String _3Volume;
@JsonProperty("4. timestamp")
private String _4Timestamp;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public StockQuote() {
}

/**
* 
* @param _3Volume
* @param _4Timestamp
* @param _1Symbol
* @param _2Price
*/
public StockQuote(String _1Symbol, String _2Price, String _3Volume, String _4Timestamp) {
super();
this._1Symbol = _1Symbol;
this._2Price = _2Price;
this._3Volume = _3Volume;
this._4Timestamp = _4Timestamp;
}

@JsonProperty("1. symbol")
public String get1Symbol() {
return _1Symbol;
}

@JsonProperty("1. symbol")
public void set1Symbol(String _1Symbol) {
this._1Symbol = _1Symbol;
}

@JsonProperty("2. price")
public String get2Price() {
return _2Price;
}

@JsonProperty("2. price")
public void set2Price(String _2Price) {
this._2Price = _2Price;
}

@JsonProperty("3. volume")
public String get3Volume() {
return _3Volume;
}

@JsonProperty("3. volume")
public void set3Volume(String _3Volume) {
this._3Volume = _3Volume;
}

@JsonProperty("4. timestamp")
public String get4Timestamp() {
return _4Timestamp;
}

@JsonProperty("4. timestamp")
public void set4Timestamp(String _4Timestamp) {
this._4Timestamp = _4Timestamp;
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