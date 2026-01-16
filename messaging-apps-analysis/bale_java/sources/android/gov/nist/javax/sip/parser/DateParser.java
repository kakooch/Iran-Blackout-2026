package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPDateHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import java.util.Calendar;

/* loaded from: classes.dex */
public class DateParser extends HeaderParser {
    public DateParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("DateParser.parse");
        }
        try {
            headerName(TokenTypes.DATE);
            wkday();
            this.lexer.match(44);
            this.lexer.match(32);
            Calendar calendarDate = date();
            this.lexer.match(32);
            time(calendarDate);
            this.lexer.match(32);
            String lowerCase = this.lexer.ttoken().toLowerCase();
            if (!"gmt".equals(lowerCase)) {
                throw createParseException("Bad Time Zone " + lowerCase);
            }
            this.lexer.match(10);
            SIPDateHeader sIPDateHeader = new SIPDateHeader();
            sIPDateHeader.setDate(calendarDate);
            if (z) {
                dbg_leave("DateParser.parse");
            }
            return sIPDateHeader;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("DateParser.parse");
            }
            throw th;
        }
    }

    protected DateParser(Lexer lexer) {
        super(lexer);
    }
}
