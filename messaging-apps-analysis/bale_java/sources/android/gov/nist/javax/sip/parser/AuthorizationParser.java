package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.header.Authorization;
import android.gov.nist.javax.sip.header.SIPHeader;

/* loaded from: classes.dex */
public class AuthorizationParser extends ChallengeParser {
    public AuthorizationParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        dbg_enter("parse");
        try {
            headerName(TokenTypes.AUTHORIZATION);
            Authorization authorization = new Authorization();
            super.parse(authorization);
            return authorization;
        } finally {
            dbg_leave("parse");
        }
    }

    protected AuthorizationParser(Lexer lexer) {
        super(lexer);
    }
}
