package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.RecordRoute;
import android.gov.nist.javax.sip.header.RecordRouteList;
import android.gov.nist.javax.sip.header.SIPHeader;

/* loaded from: classes.dex */
public class RecordRouteParser extends AddressParametersParser {
    public RecordRouteParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        char cLookAhead;
        RecordRouteList recordRouteList = new RecordRouteList();
        if (ParserCore.debug) {
            dbg_enter("RecordRouteParser.parse");
        }
        try {
            this.lexer.match(TokenTypes.RECORD_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            while (true) {
                RecordRoute recordRoute = new RecordRoute();
                super.parse((AddressParametersHeader) recordRoute);
                recordRouteList.add((RecordRouteList) recordRoute);
                this.lexer.SPorHT();
                cLookAhead = this.lexer.lookAhead(0);
                if (cLookAhead != ',') {
                    break;
                }
                this.lexer.match(44);
                this.lexer.SPorHT();
            }
            if (cLookAhead == '\n') {
                return recordRouteList;
            }
            throw createParseException("unexpected char");
        } finally {
            if (ParserCore.debug) {
                dbg_leave("RecordRouteParser.parse");
            }
        }
    }

    protected RecordRouteParser(Lexer lexer) {
        super(lexer);
    }
}
