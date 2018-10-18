package com.hackathon.squadx.client;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hackathon.squadx.model.TransactionsRequest;

import rx.Observable;

public interface SquadXHttpClient {
	
	Observable<Map<String, Object>> discoverTransactions(HttpServletRequest httpReq, TransactionsRequest transactionsRequest);

}
