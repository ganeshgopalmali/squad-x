package com.hackathon.squadx.client;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.hackathon.squadx.model.TransactionsRequest;

import rx.Single;

@Service
public class SquadXHystrixClient implements SquadXClient {

	private final SquadXHttpClient client;
	private final int timeout;
	private final int maxConcurrentRequests;
	private final String groupKey;
	
	public SquadXHystrixClient(SquadXHttpClient client) {
		this.client= client;
		this.timeout= 60000;
		this.maxConcurrentRequests= 50;
		this.groupKey ="discover-transactions";
	}
	
	@Override
	public Single<Map<String, Object>> discoverTransactions(HttpServletRequest httpReq,TransactionsRequest transactionsRequest) {
		return client.discoverTransactions(httpReq, transactionsRequest).toSingle();
	}

}
