package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.WWWAuthenticate;

/* loaded from: classes.dex */
public class WWWAuthenticateParser extends ChallengeParser {
    public WWWAuthenticateParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parse");
        }
        try {
            headerName(TokenTypes.WWW_AUTHENTICATE);
            WWWAuthenticate wWWAuthenticate = new WWWAuthenticate();
            super.parse(wWWAuthenticate);
            if (z) {
                dbg_leave("parse");
            }
            return wWWAuthenticate;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    protected WWWAuthenticateParser(Lexer lexer) {
        super(lexer);
    }
}
