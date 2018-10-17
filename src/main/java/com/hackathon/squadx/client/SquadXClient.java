package com.hackathon.squadx.client;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import rx.Single;

public interface SquadXClient {
	Single<Map<String,Object>> discoverTransactions(HttpServletRequest httpReq);
}
