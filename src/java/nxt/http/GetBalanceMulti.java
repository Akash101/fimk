package nxt.http;

import java.util.List;

import nxt.Account;
import nxt.NxtException;

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
        return JSONData.accountsBalance(accounts);
    }

}
