package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPIfMatch;

/* loaded from: classes.dex */
public class SIPIfMatchParser extends HeaderParser {
    public SIPIfMatchParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("SIPIfMatch.parse");
        }
        SIPIfMatch sIPIfMatch = new SIPIfMatch();
        try {
            headerName(TokenTypes.SIP_IF_MATCH);
            this.lexer.SPorHT();
            this.lexer.match(4095);
            sIPIfMatch.setETag(this.lexer.getNextToken().getTokenValue());
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (z) {
                dbg_leave("SIPIfMatch.parse");
            }
            return sIPIfMatch;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("SIPIfMatch.parse");
            }
            throw th;
        }
    }

    protected SIPIfMatchParser(Lexer lexer) {
        super(lexer);
    }
}
