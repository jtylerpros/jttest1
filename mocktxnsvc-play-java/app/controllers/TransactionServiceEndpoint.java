package controllers;

import static play.libs.Json.toJson;

import java.util.ArrayList;
import java.util.List;

import models.Transaction;
import play.mvc.Controller;
import play.mvc.Result;

public class TransactionServiceEndpoint extends Controller {
    
    public static Result getTransactionById(String id) {
    	Transaction txn = new Transaction();
    	txn.id = id;
    	txn.text = "This is transaction(" + id + ")";
    	
    	return ok(toJson(txn));
    }
    
    public static Result getTransactions() {
    	List<Transaction> txns = new ArrayList<Transaction>();
    	for (int i = 1; i <= 10; i++) {
    		txns.add(new Transaction("" + i, "Transaction " + i));
    	}    	
    	return ok(toJson(txns));
    }
  
}
