package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.RetryAfter;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class RetryAfterParser extends HeaderParser {
    public RetryAfterParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("RetryAfterParser.parse");
        }
        RetryAfter retryAfter = new RetryAfter();
        try {
            headerName(TokenTypes.RETRY_AFTER);
            try {
                retryAfter.setRetryAfter(Integer.parseInt(this.lexer.number()));
                this.lexer.SPorHT();
                if (this.lexer.lookAhead(0) == '(') {
                    retryAfter.setComment(this.lexer.comment());
                }
                this.lexer.SPorHT();
                while (this.lexer.lookAhead(0) == ';') {
                    this.lexer.match(59);
                    this.lexer.SPorHT();
                    this.lexer.match(4095);
                    String tokenValue = this.lexer.getNextToken().getTokenValue();
                    if (tokenValue.equalsIgnoreCase("duration")) {
                        this.lexer.match(61);
                        this.lexer.SPorHT();
                        try {
                            try {
                                retryAfter.setDuration(Integer.parseInt(this.lexer.number()));
                            } catch (NumberFormatException e) {
                                throw createParseException(e.getMessage());
                            }
                        } catch (InvalidArgumentException e2) {
                            throw createParseException(e2.getMessage());
                        }
                    } else {
                        this.lexer.SPorHT();
                        this.lexer.match(61);
                        this.lexer.SPorHT();
                        this.lexer.match(4095);
                        retryAfter.setParameter(tokenValue, this.lexer.getNextToken().getTokenValue());
                    }
                    this.lexer.SPorHT();
                }
                if (ParserCore.debug) {
                    dbg_leave("RetryAfterParser.parse");
                }
                return retryAfter;
            } catch (InvalidArgumentException e3) {
                throw createParseException(e3.getMessage());
            } catch (NumberFormatException e4) {
                throw createParseException(e4.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("RetryAfterParser.parse");
            }
            throw th;
        }
    }

    protected RetryAfterParser(Lexer lexer) {
        super(lexer);
    }
}
