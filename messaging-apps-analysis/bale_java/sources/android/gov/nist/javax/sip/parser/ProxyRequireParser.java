package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.ProxyRequire;
import android.gov.nist.javax.sip.header.ProxyRequireList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class ProxyRequireParser extends HeaderParser {
    public ProxyRequireParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        ProxyRequireList proxyRequireList = new ProxyRequireList();
        if (ParserCore.debug) {
            dbg_enter("ProxyRequireParser.parse");
        }
        try {
            headerName(TokenTypes.PROXY_REQUIRE);
            while (this.lexer.lookAhead(0) != '\n') {
                ProxyRequire proxyRequire = new ProxyRequire();
                proxyRequire.setHeaderName(SIPHeaderNames.PROXY_REQUIRE);
                this.lexer.match(4095);
                proxyRequire.setOptionTag(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                proxyRequireList.add((ProxyRequireList) proxyRequire);
                while (this.lexer.lookAhead(0) == ',') {
                    this.lexer.match(44);
                    this.lexer.SPorHT();
                    ProxyRequire proxyRequire2 = new ProxyRequire();
                    this.lexer.match(4095);
                    proxyRequire2.setOptionTag(this.lexer.getNextToken().getTokenValue());
                    this.lexer.SPorHT();
                    proxyRequireList.add((ProxyRequireList) proxyRequire2);
                }
            }
            return proxyRequireList;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("ProxyRequireParser.parse");
            }
        }
    }

    protected ProxyRequireParser(Lexer lexer) {
        super(lexer);
    }
}
