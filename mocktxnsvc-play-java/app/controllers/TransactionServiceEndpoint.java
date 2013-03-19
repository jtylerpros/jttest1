package controllers;

import static play.libs.Json.toJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import models.ColumnValue;
import models.Transaction;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

public class TransactionServiceEndpoint extends Controller {
    
    public static Result getTransactionById(String tenant, String id) {
    	Transaction txn = new Transaction();
    	txn.setId(UUID.randomUUID());
    	txn.setTenantId(tenant);
    	Map<String, ColumnValue<? extends Object>> columns = new HashMap<String, ColumnValue<? extends Object>>();
    	columns.put("revenue", new ColumnValue<Integer>(Integer.class, 500, Arrays.asList("revenue", "measure")));
    	columns.put("margin pct", new ColumnValue<Integer>(Integer.class, 8, Arrays.asList("margin", "measure")));
    	columns.put("product", new ColumnValue<String>(String.class, "sku123", Arrays.asList("product", "dimension")));
    	columns.put("customer", new ColumnValue<String>(String.class, "cust123", Arrays.asList("customer", "dimension")));
    	txn.setColumns(columns);
    	return ok(toJson(txn));
    }
    
    public static Result getTransactions(String tenant) {
    	List<Transaction> txns = new ArrayList<Transaction>();
    	for (int i = 1; i <= 10; i++) {
    		Transaction txn = new Transaction(UUID.randomUUID(), tenant, null);
    		Map<String, ColumnValue<? extends Object>> columns = new HashMap<String, ColumnValue<? extends Object>>();
        	columns.put("revenue", new ColumnValue<Integer>(Integer.class, (int) (Math.random() * 1500), Arrays.asList("revenue", "measure")));
        	columns.put("margin pct", new ColumnValue<Integer>(Integer.class, (int) (Math.random() * 100), Arrays.asList("margin", "measure")));
        	columns.put("product", new ColumnValue<String>(String.class, "sku" + (int) (Math.random() * 10000), Arrays.asList("product", "dimension")));
        	columns.put("customer", new ColumnValue<String>(String.class, "cust" + (int) (Math.random() * 10000), Arrays.asList("customer", "dimension")));
        	txn.setColumns(columns);
    		txns.add(txn);
    	}
    	ColumnValue<? extends Object> columnValue = txns.get(0).getColumns().get("revenue");
		Integer revenue = (Integer) columnValue.getValueAsType();
		Logger.info("type of revenue is " + revenue.getClass().getName() + " and value is " + revenue);
    	
    	return ok(toJson(txns));
    }
  
}
