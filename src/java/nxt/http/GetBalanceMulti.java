package nxt.http;

import java.util.List;

import nxt.Account;
import nxt.NxtException;
import nxt.util.Convert;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public final class GetBalanceMulti extends APIServlet.APIRequestHandler {

	static final GetBalanceMulti instance = new GetBalanceMulti();

	private GetBalanceMulti() {
		super(new APITag[] {APITag.ACCOUNTS}, "account");
	}

	@Override
	JSONStreamAware processRequest(HttpServletRequest req) throws NxtException {
		List<Account> accounts = ParameterParser.getAccounts(req);
		JSONObject response = new JSONObject();
		JSONArray accountsJSONArray = new JSONArray();
		JSONObject json;
		for (Account account : accounts ) {
		    json = JSONData.accountBalance(account);
			json.put("account", Convert.rsAccount(account.getId())); 
			accountsJSONArray.add(json);
		}
		
		response.put("accounts", accountsJSONArray);
		return response;
	}

}
