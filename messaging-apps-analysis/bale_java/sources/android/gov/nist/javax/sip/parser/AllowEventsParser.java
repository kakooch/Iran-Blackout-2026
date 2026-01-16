package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AllowEvents;
import android.gov.nist.javax.sip.header.AllowEventsList;
import android.gov.nist.javax.sip.header.SIPHeader;

/* loaded from: classes.dex */
public class AllowEventsParser extends HeaderParser {
    public AllowEventsParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("AllowEventsParser.parse");
        }
        AllowEventsList allowEventsList = new AllowEventsList();
        try {
            headerName(TokenTypes.ALLOW_EVENTS);
            AllowEvents allowEvents = new AllowEvents();
            this.lexer.match(4095);
            allowEvents.setEventType(this.lexer.getNextToken().getTokenValue());
            allowEventsList.add((AllowEventsList) allowEvents);
            this.lexer.SPorHT();
            while (this.lexer.lookAhead(0) == ',') {
                this.lexer.match(44);
                this.lexer.SPorHT();
                AllowEvents allowEvents2 = new AllowEvents();
                this.lexer.match(4095);
                allowEvents2.setEventType(this.lexer.getNextToken().getTokenValue());
                allowEventsList.add((AllowEventsList) allowEvents2);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (ParserCore.debug) {
                dbg_leave("AllowEventsParser.parse");
            }
            return allowEventsList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("AllowEventsParser.parse");
            }
            throw th;
        }
    }

    protected AllowEventsParser(Lexer lexer) {
        super(lexer);
    }
}
