package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.address.GenericURI;

/* loaded from: classes.dex */
public class AddressParser extends Parser {
    public AddressParser(Lexer lexer) {
        this.lexer = lexer;
        lexer.selectLexer("charLexer");
    }

    public AddressImpl address(boolean z) {
        AddressImpl addressImplNameAddr;
        char cLookAhead;
        if (ParserCore.debug) {
            dbg_enter("address");
        }
        int i = 0;
        while (this.lexer.hasMoreChars() && (cLookAhead = this.lexer.lookAhead(i)) != '<' && cLookAhead != '\"' && cLookAhead != ':' && cLookAhead != '/') {
            try {
                if (cLookAhead == 0) {
                    throw createParseException("unexpected EOL");
                }
                i++;
            } catch (Throwable th) {
                if (ParserCore.debug) {
                    dbg_leave("address");
                }
                throw th;
            }
        }
        char cLookAhead2 = this.lexer.lookAhead(i);
        if (cLookAhead2 == '<' || cLookAhead2 == '\"') {
            addressImplNameAddr = nameAddr();
        } else {
            if (cLookAhead2 != ':' && cLookAhead2 != '/') {
                throw createParseException("Bad address spec");
            }
            addressImplNameAddr = new AddressImpl();
            GenericURI genericURIUriReference = new URLParser((Lexer) this.lexer).uriReference(z);
            addressImplNameAddr.setAddressType(2);
            addressImplNameAddr.setURI(genericURIUriReference);
        }
        if (ParserCore.debug) {
            dbg_leave("address");
        }
        return addressImplNameAddr;
    }

    protected AddressImpl nameAddr() {
        String nextToken;
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("nameAddr");
        }
        try {
            if (this.lexer.lookAhead(0) == '<') {
                this.lexer.consume(1);
                this.lexer.selectLexer("sip_urlLexer");
                this.lexer.SPorHT();
                GenericURI genericURIUriReference = new URLParser((Lexer) this.lexer).uriReference(true);
                AddressImpl addressImpl = new AddressImpl();
                addressImpl.setAddressType(1);
                addressImpl.setURI(genericURIUriReference);
                this.lexer.SPorHT();
                this.lexer.match(62);
                if (z) {
                    dbg_leave("nameAddr");
                }
                return addressImpl;
            }
            AddressImpl addressImpl2 = new AddressImpl();
            addressImpl2.setAddressType(1);
            if (this.lexer.lookAhead(0) == '\"') {
                nextToken = this.lexer.quotedString();
                this.lexer.SPorHT();
            } else {
                nextToken = this.lexer.getNextToken('<');
            }
            addressImpl2.setDisplayName(nextToken.trim());
            this.lexer.match(60);
            this.lexer.SPorHT();
            GenericURI genericURIUriReference2 = new URLParser((Lexer) this.lexer).uriReference(true);
            new AddressImpl();
            addressImpl2.setAddressType(1);
            addressImpl2.setURI(genericURIUriReference2);
            this.lexer.SPorHT();
            this.lexer.match(62);
            if (z) {
                dbg_leave("nameAddr");
            }
            return addressImpl2;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("nameAddr");
            }
            throw th;
        }
    }

    public AddressParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }
}
