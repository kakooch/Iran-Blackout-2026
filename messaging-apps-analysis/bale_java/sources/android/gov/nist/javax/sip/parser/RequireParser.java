package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.Require;
import android.gov.nist.javax.sip.header.RequireList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class RequireParser extends HeaderParser {
    public RequireParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        RequireList requireList = new RequireList();
        if (ParserCore.debug) {
            dbg_enter("RequireParser.parse");
        }
        try {
            headerName(TokenTypes.REQUIRE);
            while (this.lexer.lookAhead(0) != '\n') {
                Require require = new Require();
                require.setHeaderName(SIPHeaderNames.REQUIRE);
                this.lexer.match(4095);
                require.setOptionTag(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                requireList.add((RequireList) require);
                while (this.lexer.lookAhead(0) == ',') {
                    this.lexer.match(44);
                    this.lexer.SPorHT();
                    Require require2 = new Require();
                    this.lexer.match(4095);
                    require2.setOptionTag(this.lexer.getNextToken().getTokenValue());
                    this.lexer.SPorHT();
                    requireList.add((RequireList) require2);
                }
            }
            return requireList;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("RequireParser.parse");
            }
        }
    }

    protected RequireParser(Lexer lexer) {
        super(lexer);
    }
}
