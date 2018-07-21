
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
"1. Information",
"2. Notes",
"3. Time Zone"
})
public class MetaData {

@JsonProperty("1. Information")
private String _1Information;
@JsonProperty("2. Notes")
private String _2Notes;
@JsonProperty("3. Time Zone")
private String _3TimeZone;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public MetaData() {
}

/**
* 
* @param _1Information
* @param _2Notes
* @param _3TimeZone
*/
public MetaData(String _1Information, String _2Notes, String _3TimeZone) {
super();
this._1Information = _1Information;
this._2Notes = _2Notes;
this._3TimeZone = _3TimeZone;
}

@JsonProperty("1. Information")
public String get1Information() {
return _1Information;
}

@JsonProperty("1. Information")
public void set1Information(String _1Information) {
this._1Information = _1Information;
}

@JsonProperty("2. Notes")
public String get2Notes() {
return _2Notes;
}

@JsonProperty("2. Notes")
public void set2Notes(String _2Notes) {
this._2Notes = _2Notes;
}

@JsonProperty("3. Time Zone")
public String get3TimeZone() {
return _3TimeZone;
}

@JsonProperty("3. Time Zone")
public void set3TimeZone(String _3TimeZone) {
this._3TimeZone = _3TimeZone;
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