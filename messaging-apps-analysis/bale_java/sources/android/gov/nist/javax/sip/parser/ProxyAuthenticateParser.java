package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.header.ProxyAuthenticate;
import android.gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ProxyAuthenticateParser extends ChallengeParser {
    public ProxyAuthenticateParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.PROXY_AUTHENTICATE);
        ProxyAuthenticate proxyAuthenticate = new ProxyAuthenticate();
        super.parse(proxyAuthenticate);
        return proxyAuthenticate;
    }

    protected ProxyAuthenticateParser(Lexer lexer) {
        super(lexer);
    }
}
