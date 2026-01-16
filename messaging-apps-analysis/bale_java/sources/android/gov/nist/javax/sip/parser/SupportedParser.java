package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.Supported;
import android.gov.nist.javax.sip.header.SupportedList;

/* loaded from: classes.dex */
public class SupportedParser extends HeaderParser {
    public SupportedParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        SupportedList supportedList = new SupportedList();
        if (ParserCore.debug) {
            dbg_enter("SupportedParser.parse");
        }
        try {
            headerName(2068);
            this.lexer.SPorHT();
            Supported supported = new Supported();
            supported.setHeaderName(SIPHeaderNames.SUPPORTED);
            if (this.lexer.lookAhead(0) != '\n') {
                this.lexer.match(4095);
                supported.setOptionTag(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
            }
            supportedList.add((SupportedList) supported);
            while (this.lexer.lookAhead(0) == ',') {
                this.lexer.match(44);
                this.lexer.SPorHT();
                Supported supported2 = new Supported();
                this.lexer.match(4095);
                supported2.setOptionTag(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                supportedList.add((SupportedList) supported2);
            }
            if (ParserCore.debug) {
                dbg_leave("SupportedParser.parse");
            }
            return supportedList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("SupportedParser.parse");
            }
            throw th;
        }
    }

    protected SupportedParser(Lexer lexer) {
        super(lexer);
    }
}
