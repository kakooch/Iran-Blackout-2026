package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Token;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.Warning;
import android.gov.nist.javax.sip.header.WarningList;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class WarningParser extends HeaderParser {
    public WarningParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        WarningList warningList = new WarningList();
        if (ParserCore.debug) {
            dbg_enter("WarningParser.parse");
        }
        try {
            headerName(TokenTypes.WARNING);
            while (this.lexer.lookAhead(0) != '\n') {
                Warning warning = new Warning();
                warning.setHeaderName(SIPHeaderNames.WARNING);
                this.lexer.match(4095);
                try {
                    warning.setCode(Integer.parseInt(this.lexer.getNextToken().getTokenValue()));
                    this.lexer.SPorHT();
                    this.lexer.match(4095);
                    Token nextToken = this.lexer.getNextToken();
                    if (this.lexer.lookAhead(0) == ':') {
                        this.lexer.match(58);
                        this.lexer.match(4095);
                        warning.setAgent(nextToken.getTokenValue() + ":" + this.lexer.getNextToken().getTokenValue());
                    } else {
                        warning.setAgent(nextToken.getTokenValue());
                    }
                    this.lexer.SPorHT();
                    warning.setText(this.lexer.quotedString());
                    this.lexer.SPorHT();
                    warningList.add((WarningList) warning);
                    while (this.lexer.lookAhead(0) == ',') {
                        this.lexer.match(44);
                        this.lexer.SPorHT();
                        Warning warning2 = new Warning();
                        this.lexer.match(4095);
                        try {
                            warning2.setCode(Integer.parseInt(this.lexer.getNextToken().getTokenValue()));
                            this.lexer.SPorHT();
                            this.lexer.match(4095);
                            Token nextToken2 = this.lexer.getNextToken();
                            if (this.lexer.lookAhead(0) == ':') {
                                this.lexer.match(58);
                                this.lexer.match(4095);
                                warning2.setAgent(nextToken2.getTokenValue() + ":" + this.lexer.getNextToken().getTokenValue());
                            } else {
                                warning2.setAgent(nextToken2.getTokenValue());
                            }
                            this.lexer.SPorHT();
                            warning2.setText(this.lexer.quotedString());
                            this.lexer.SPorHT();
                            warningList.add((WarningList) warning2);
                        } catch (InvalidArgumentException e) {
                            throw createParseException(e.getMessage());
                        } catch (NumberFormatException e2) {
                            throw createParseException(e2.getMessage());
                        }
                    }
                } catch (InvalidArgumentException e3) {
                    throw createParseException(e3.getMessage());
                } catch (NumberFormatException e4) {
                    throw createParseException(e4.getMessage());
                }
            }
            if (ParserCore.debug) {
                dbg_leave("WarningParser.parse");
            }
            return warningList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("WarningParser.parse");
            }
            throw th;
        }
    }

    protected WarningParser(Lexer lexer) {
        super(lexer);
    }
}
