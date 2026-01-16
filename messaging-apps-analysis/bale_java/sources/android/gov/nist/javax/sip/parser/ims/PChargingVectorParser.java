package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PChargingVector;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.ParametersParser;
import android.gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PChargingVectorParser extends ParametersParser implements TokenTypes {
    public PChargingVectorParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("parse");
        }
        try {
            headerName(TokenTypes.P_VECTOR_CHARGING);
            PChargingVector pChargingVector = new PChargingVector();
            while (this.lexer.lookAhead(0) != '\n') {
                try {
                    parseParameter(pChargingVector);
                    this.lexer.SPorHT();
                    char cLookAhead = this.lexer.lookAhead(0);
                    if (cLookAhead == '\n' || cLookAhead == 0) {
                        break;
                    }
                    this.lexer.match(59);
                    this.lexer.SPorHT();
                } catch (ParseException e) {
                    throw e;
                }
            }
            super.parse(pChargingVector);
            if (pChargingVector.getParameter(ParameterNamesIms.ICID_VALUE) != null) {
                return pChargingVector;
            }
            throw new ParseException("Missing a required Parameter : icid-value", 0);
        } finally {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
        }
    }

    protected void parseParameter(PChargingVector pChargingVector) {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parseParameter");
        }
        try {
            pChargingVector.setParameter(nameValue('='));
            if (z) {
                dbg_leave("parseParameter");
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parseParameter");
            }
            throw th;
        }
    }

    protected PChargingVectorParser(Lexer lexer) {
        super(lexer);
    }
}
