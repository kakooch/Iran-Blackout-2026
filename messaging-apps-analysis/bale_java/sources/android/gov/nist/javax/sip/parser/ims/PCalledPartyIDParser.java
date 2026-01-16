package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PCalledPartyID;
import android.gov.nist.javax.sip.parser.AddressParametersParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class PCalledPartyIDParser extends AddressParametersParser {
    public PCalledPartyIDParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("PCalledPartyIDParser.parse");
        }
        try {
            this.lexer.match(TokenTypes.P_CALLED_PARTY_ID);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            PCalledPartyID pCalledPartyID = new PCalledPartyID();
            super.parse((AddressParametersHeader) pCalledPartyID);
            if (z) {
                dbg_leave("PCalledPartyIDParser.parse");
            }
            return pCalledPartyID;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("PCalledPartyIDParser.parse");
            }
            throw th;
        }
    }

    protected PCalledPartyIDParser(Lexer lexer) {
        super(lexer);
    }
}
