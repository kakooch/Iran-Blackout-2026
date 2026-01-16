package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.Unsupported;
import android.gov.nist.javax.sip.header.UnsupportedList;

/* loaded from: classes.dex */
public class UnsupportedParser extends HeaderParser {
    public UnsupportedParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        UnsupportedList unsupportedList = new UnsupportedList();
        if (ParserCore.debug) {
            dbg_enter("UnsupportedParser.parse");
        }
        try {
            headerName(TokenTypes.UNSUPPORTED);
            while (this.lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                Unsupported unsupported = new Unsupported();
                unsupported.setHeaderName(SIPHeaderNames.UNSUPPORTED);
                this.lexer.match(4095);
                unsupported.setOptionTag(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                unsupportedList.add((UnsupportedList) unsupported);
                while (this.lexer.lookAhead(0) == ',') {
                    this.lexer.match(44);
                    this.lexer.SPorHT();
                    Unsupported unsupported2 = new Unsupported();
                    this.lexer.match(4095);
                    unsupported2.setOptionTag(this.lexer.getNextToken().getTokenValue());
                    this.lexer.SPorHT();
                    unsupportedList.add((UnsupportedList) unsupported2);
                }
            }
            return unsupportedList;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("UnsupportedParser.parse");
            }
        }
    }

    protected UnsupportedParser(Lexer lexer) {
        super(lexer);
    }
}
