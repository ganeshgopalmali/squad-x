package com.hackathon.squadx.services;

import javax.servlet.http.HttpServletRequest;

import com.hackathon.squadx.client.SquadXClient;
import com.hackathon.squadx.model.TransactionAnalysis;
import com.hackathon.squadx.model.TransactionHistory;
import com.hackathon.squadx.model.TransactionsRequest;
import com.jayway.jsonpath.ParseContext;

import rx.Single;

public class CustomerTransactionsService implements CustomerTransactions {

	private final SquadXClient squadXClient;
	
	private final ParseContext parseContext;
	
	public CustomerTransactionsService(SquadXClient squadXClient,
			ParseContext parseContext) {
		this.squadXClient= squadXClient;
		this.parseContext= parseContext;
	}
	
	@Override
	public Single<TransactionAnalysis> discoverTransactions(HttpServletRequest httpReq, TransactionsRequest transactionsRequest) {
		return squadXClient.discoverTransactions(httpReq, transactionsRequest).map(it-> TransactionHistory.from(it,parseContext));
	}

}
