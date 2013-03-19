package models;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class Transaction {
	
	private UUID id;
	private String tenantId;
	private Map<String, ColumnValue<? extends Object>> columns;
	
	public Transaction() {
		this(UUID.randomUUID(), "default Tenant", Collections.<String, ColumnValue<?>> emptyMap());
	}
	
	public Transaction(UUID id, String tenantId, Map<String, ColumnValue<? extends Object>> columns) {
		setId(id);
		setTenantId(tenantId);
		setColumns(columns);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Map<String, ColumnValue<? extends Object>> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnValue<? extends Object>> columns) {
		this.columns = columns;
	}

}
