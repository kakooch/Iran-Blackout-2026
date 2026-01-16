package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.header.ProxyAuthorization;
import android.gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ProxyAuthorizationParser extends ChallengeParser {
    public ProxyAuthorizationParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHORIZATION);
        ProxyAuthorization proxyAuthorization = new ProxyAuthorization();
        super.parse(proxyAuthorization);
        return proxyAuthorization;
    }

    protected ProxyAuthorizationParser(Lexer lexer) {
        super(lexer);
    }
}
