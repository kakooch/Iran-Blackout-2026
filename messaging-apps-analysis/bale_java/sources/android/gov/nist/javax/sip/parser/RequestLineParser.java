package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.address.GenericURI;
import android.gov.nist.javax.sip.header.RequestLine;

/* loaded from: classes.dex */
public class RequestLineParser extends Parser {
    public RequestLineParser(String str) {
        this.lexer = new Lexer("method_keywordLexer", str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"REGISTER sip:192.168.0.68 SIP/2.0\n", "REGISTER sip:company.com SIP/2.0\n", "INVITE sip:3660@166.35.231.140 SIP/2.0\n", "INVITE sip:user@company.com SIP/2.0\n", "REGISTER sip:[2001::1]:5060;transport=tcp SIP/2.0\n", "REGISTER sip:[2002:800:700:600:30:4:6:1]:5060;transport=udp SIP/2.0\n", "REGISTER sip:[3ffe:800:700::30:4:6:1]:5060;transport=tls SIP/2.0\n", "REGISTER sip:[2001:720:1710:0:201:29ff:fe21:f403]:5060;transport=udp SIP/2.0\n", "OPTIONS sip:135.180.130.133 SIP/2.0\n"};
        for (int i = 0; i < 9; i++) {
            RequestLine requestLine = new RequestLineParser(strArr2[i]).parse();
            System.out.println("encoded = " + requestLine.encode());
        }
    }

    public RequestLine parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parse");
        }
        try {
            RequestLine requestLine = new RequestLine();
            String strMethod = method();
            this.lexer.SPorHT();
            requestLine.setMethod(strMethod);
            this.lexer.selectLexer("sip_urlLexer");
            GenericURI genericURIUriReference = new URLParser(getLexer()).uriReference(true);
            this.lexer.SPorHT();
            requestLine.setUri(genericURIUriReference);
            this.lexer.selectLexer("request_lineLexer");
            requestLine.setSipVersion(sipVersion());
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (z) {
                dbg_leave("parse");
            }
            return requestLine;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    public RequestLineParser(Lexer lexer) {
        this.lexer = lexer;
        lexer.selectLexer("method_keywordLexer");
    }
}
