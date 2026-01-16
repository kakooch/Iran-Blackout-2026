package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.HostNameParser;
import android.gov.nist.core.NameValue;
import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Token;
import android.gov.nist.javax.sip.header.Protocol;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.header.ViaList;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ViaParser extends HeaderParser {
    public ViaParser(String str) {
        super(str);
    }

    private void parseVia(Via via) throws ParseException {
        this.lexer.match(4095);
        Token nextToken = this.lexer.getNextToken();
        this.lexer.SPorHT();
        this.lexer.match(47);
        this.lexer.SPorHT();
        this.lexer.match(4095);
        this.lexer.SPorHT();
        Token nextToken2 = this.lexer.getNextToken();
        this.lexer.SPorHT();
        this.lexer.match(47);
        this.lexer.SPorHT();
        this.lexer.match(4095);
        this.lexer.SPorHT();
        Token nextToken3 = this.lexer.getNextToken();
        this.lexer.SPorHT();
        Protocol protocol = new Protocol();
        protocol.setProtocolName(nextToken.getTokenValue());
        protocol.setProtocolVersion(nextToken2.getTokenValue());
        protocol.setTransport(nextToken3.getTokenValue());
        via.setSentProtocol(protocol);
        via.setSentBy(new HostNameParser(getLexer()).hostPort(true));
        this.lexer.SPorHT();
        while (this.lexer.lookAhead(0) == ';') {
            this.lexer.consume(1);
            this.lexer.SPorHT();
            NameValue nameValue = nameValue();
            if (nameValue.getName().equals("branch") && ((String) nameValue.getValueAsObject()) == null) {
                throw new ParseException("null branch Id", this.lexer.getPtr());
            }
            via.setParameter(nameValue);
            this.lexer.SPorHT();
        }
        if (this.lexer.lookAhead(0) == '(') {
            this.lexer.selectLexer("charLexer");
            this.lexer.consume(1);
            StringBuilder sb = new StringBuilder();
            while (true) {
                char cLookAhead = this.lexer.lookAhead(0);
                if (cLookAhead == ')') {
                    this.lexer.consume(1);
                    break;
                }
                if (cLookAhead == '\\') {
                    sb.append(this.lexer.getNextToken().getTokenValue());
                    this.lexer.consume(1);
                    sb.append(this.lexer.getNextToken().getTokenValue());
                    this.lexer.consume(1);
                } else {
                    if (cLookAhead == '\n') {
                        break;
                    }
                    sb.append(cLookAhead);
                    this.lexer.consume(1);
                }
            }
            via.setComment(sb.toString());
        }
    }

    @Override // android.gov.nist.core.ParserCore
    protected NameValue nameValue() {
        String tokenValue;
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("nameValue");
        }
        try {
            this.lexer.match(4095);
            Token nextToken = this.lexer.getNextToken();
            this.lexer.SPorHT();
            try {
                boolean z2 = false;
                if (this.lexer.lookAhead(0) != '=') {
                    NameValue nameValue = new NameValue(nextToken.getTokenValue().toLowerCase(), null);
                    if (z) {
                        dbg_leave("nameValue");
                    }
                    return nameValue;
                }
                this.lexer.consume(1);
                this.lexer.SPorHT();
                if (nextToken.getTokenValue().compareToIgnoreCase("received") == 0) {
                    tokenValue = this.lexer.byteStringNoSemicolon();
                } else if (this.lexer.lookAhead(0) == '\"') {
                    tokenValue = this.lexer.quotedString();
                    z2 = true;
                } else {
                    this.lexer.match(4095);
                    tokenValue = this.lexer.getNextToken().getTokenValue();
                }
                NameValue nameValue2 = new NameValue(nextToken.getTokenValue().toLowerCase(), tokenValue);
                if (z2) {
                    nameValue2.setQuotedValue();
                }
                if (z) {
                    dbg_leave("nameValue");
                }
                return nameValue2;
            } catch (ParseException unused) {
                NameValue nameValue3 = new NameValue(nextToken.getTokenValue(), null);
                if (ParserCore.debug) {
                    dbg_leave("nameValue");
                }
                return nameValue3;
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("nameValue");
            }
            throw th;
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("parse");
        }
        try {
            ViaList viaList = new ViaList();
            this.lexer.match(TokenTypes.VIA);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            do {
                Via via = new Via();
                parseVia(via);
                viaList.add((ViaList) via);
                this.lexer.SPorHT();
                if (this.lexer.lookAhead(0) == ',') {
                    this.lexer.consume(1);
                    this.lexer.SPorHT();
                }
            } while (this.lexer.lookAhead(0) != '\n');
            this.lexer.match(10);
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            return viaList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    public ViaParser(Lexer lexer) {
        super(lexer);
    }
}
