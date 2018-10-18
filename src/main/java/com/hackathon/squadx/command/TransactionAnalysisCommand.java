package com.hackathon.squadx.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hackathon.squadx.client.SquadXHttpClient;
import com.hackathon.squadx.model.TransactionsRequest;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;

import rx.Observable;

public class TransactionAnalysisCommand extends HystrixObservableCommand<Map<String,Object>> {
	
	private final SquadXHttpClient client;
	private final HttpServletRequest request;
	private final TransactionsRequest transactionsRequest;
	
	public TransactionAnalysisCommand(HttpServletRequest request, SquadXHttpClient client, TransactionsRequest transactionsRequest) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("analysis"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("/discover-transactions"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionTimeoutInMilliseconds(60000)
						.withExecutionIsolationSemaphoreMaxConcurrentRequests(50)
						));
		this.request= request;
		this.client= client;
		this.transactionsRequest= transactionsRequest;
	}

	@Override
	protected Observable<Map<String, Object>> construct() {
		return client.discoverTransactions(request,transactionsRequest);
	}

}
