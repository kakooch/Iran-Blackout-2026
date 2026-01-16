package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.Expires;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class ExpiresParser extends HeaderParser {
    public ExpiresParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        Expires expires = new Expires();
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parse");
        }
        try {
            this.lexer.match(TokenTypes.EXPIRES);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            try {
                try {
                    expires.setExpires(Integer.parseInt(this.lexer.getNextId()));
                    this.lexer.match(10);
                    if (z) {
                        dbg_leave("parse");
                    }
                    return expires;
                } catch (InvalidArgumentException e) {
                    throw createParseException(e.getMessage());
                }
            } catch (NumberFormatException unused) {
                throw createParseException("bad integer format");
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    protected ExpiresParser(Lexer lexer) {
        super(lexer);
    }
}
