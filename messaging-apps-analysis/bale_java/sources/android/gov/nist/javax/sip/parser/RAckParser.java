package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.RAck;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class RAckParser extends HeaderParser {
    public RAckParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("RAckParser.parse");
        }
        RAck rAck = new RAck();
        try {
            headerName(TokenTypes.RACK);
            rAck.setHeaderName(SIPHeaderNames.RACK);
            try {
                rAck.setRSequenceNumber(Long.parseLong(this.lexer.number()));
                this.lexer.SPorHT();
                rAck.setCSequenceNumber(Long.parseLong(this.lexer.number()));
                this.lexer.SPorHT();
                this.lexer.match(4095);
                rAck.setMethod(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                this.lexer.match(10);
                if (z) {
                    dbg_leave("RAckParser.parse");
                }
                return rAck;
            } catch (InvalidArgumentException e) {
                throw createParseException(e.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("RAckParser.parse");
            }
            throw th;
        }
    }

    protected RAckParser(Lexer lexer) {
        super(lexer);
    }
}
