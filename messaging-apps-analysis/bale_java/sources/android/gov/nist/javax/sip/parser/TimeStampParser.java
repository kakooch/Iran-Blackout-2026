package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.TimeStamp;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class TimeStampParser extends HeaderParser {
    public TimeStampParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("TimeStampParser.parse");
        }
        TimeStamp timeStamp = new TimeStamp();
        try {
            headerName(TokenTypes.TIMESTAMP);
            timeStamp.setHeaderName(SIPHeaderNames.TIMESTAMP);
            this.lexer.SPorHT();
            String strNumber = this.lexer.number();
            try {
                try {
                    if (this.lexer.lookAhead(0) == '.') {
                        this.lexer.match(46);
                        timeStamp.setTimeStamp(Float.parseFloat(strNumber + Separators.DOT + this.lexer.number()));
                    } else {
                        timeStamp.setTime(Long.parseLong(strNumber));
                    }
                    this.lexer.SPorHT();
                    if (this.lexer.lookAhead(0) != '\n') {
                        String strNumber2 = this.lexer.number();
                        try {
                            try {
                                if (this.lexer.lookAhead(0) == '.') {
                                    this.lexer.match(46);
                                    timeStamp.setDelay(Float.parseFloat(strNumber2 + Separators.DOT + this.lexer.number()));
                                } else {
                                    timeStamp.setDelay(Integer.parseInt(strNumber2));
                                }
                            } catch (InvalidArgumentException e) {
                                throw createParseException(e.getMessage());
                            }
                        } catch (NumberFormatException e2) {
                            throw createParseException(e2.getMessage());
                        }
                    }
                    if (z) {
                        dbg_leave("TimeStampParser.parse");
                    }
                    return timeStamp;
                } catch (NumberFormatException e3) {
                    throw createParseException(e3.getMessage());
                }
            } catch (InvalidArgumentException e4) {
                throw createParseException(e4.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("TimeStampParser.parse");
            }
            throw th;
        }
    }

    protected TimeStampParser(Lexer lexer) {
        super(lexer);
    }
}
