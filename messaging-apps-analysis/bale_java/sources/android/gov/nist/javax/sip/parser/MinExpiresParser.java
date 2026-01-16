package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.MinExpires;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class MinExpiresParser extends HeaderParser {
    public MinExpiresParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("MinExpiresParser.parse");
        }
        MinExpires minExpires = new MinExpires();
        try {
            headerName(TokenTypes.MIN_EXPIRES);
            minExpires.setHeaderName(SIPHeaderNames.MIN_EXPIRES);
            try {
                minExpires.setExpires(Integer.parseInt(this.lexer.number()));
                this.lexer.SPorHT();
                this.lexer.match(10);
                if (z) {
                    dbg_leave("MinExpiresParser.parse");
                }
                return minExpires;
            } catch (InvalidArgumentException e) {
                throw createParseException(e.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("MinExpiresParser.parse");
            }
            throw th;
        }
    }

    protected MinExpiresParser(Lexer lexer) {
        super(lexer);
    }
}
