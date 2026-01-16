package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.Event;
import android.gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

/* loaded from: classes.dex */
public class EventParser extends ParametersParser {
    public EventParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("EventParser.parse");
        }
        try {
            try {
                headerName(TokenTypes.EVENT);
                this.lexer.SPorHT();
                Event event = new Event();
                this.lexer.match(4095);
                event.setEventType(this.lexer.getNextToken().getTokenValue());
                super.parse(event);
                this.lexer.SPorHT();
                this.lexer.match(10);
                if (z) {
                    dbg_leave("EventParser.parse");
                }
                return event;
            } catch (ParseException e) {
                throw createParseException(e.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("EventParser.parse");
            }
            throw th;
        }
    }

    protected EventParser(Lexer lexer) {
        super(lexer);
    }
}
