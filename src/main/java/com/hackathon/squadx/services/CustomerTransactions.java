package com.hackathon.squadx.services;

import javax.servlet.http.HttpServletRequest;

import com.hackathon.squadx.model.TransactionAnalysis;

import rx.Single;

public interface CustomerTransactions {
	Single<TransactionAnalysis> discoverTransactions(HttpServletRequest httpReq);
}
