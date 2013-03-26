package models;

import java.util.List;

public class ColumnValue<T> {
	
	private Class<? extends T> type;
	private Object value;
	private List<String> tags;
	
	public ColumnValue(Class<? extends T> type, Object value, List<String> tags) {
		this.type = type;
		setValue(value);
		setTags(tags);
	}
	
	public Class<? extends T> getType() {
		return type;
	}
	
	public T getValueAsType() {
		return type.cast(value);
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
