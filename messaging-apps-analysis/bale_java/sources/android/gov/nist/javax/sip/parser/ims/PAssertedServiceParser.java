package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PAssertedService;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import android.gov.nist.javax.sip.parser.HeaderParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class PAssertedServiceParser extends HeaderParser implements TokenTypes {
    protected PAssertedServiceParser(Lexer lexer) {
        super(lexer);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("PAssertedServiceParser.parse");
        }
        try {
            this.lexer.match(TokenTypes.P_ASSERTED_SERVICE);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            PAssertedService pAssertedService = new PAssertedService();
            String buffer = this.lexer.getBuffer();
            if (buffer.contains(ParameterNamesIms.SERVICE_ID)) {
                if (buffer.contains(ParameterNamesIms.SERVICE_ID_LABEL)) {
                    if (buffer.split("3gpp-service.")[1].trim().equals("")) {
                        try {
                            throw new InvalidArgumentException("URN should atleast have one sub-service");
                        } catch (InvalidArgumentException e) {
                            e.printStackTrace();
                        }
                    } else {
                        pAssertedService.setSubserviceIdentifiers(buffer.split(ParameterNamesIms.SERVICE_ID_LABEL)[1]);
                    }
                } else if (!buffer.contains(ParameterNamesIms.APPLICATION_ID_LABEL)) {
                    try {
                        throw new InvalidArgumentException("URN is not well formed");
                    } catch (InvalidArgumentException e2) {
                        e2.printStackTrace();
                    }
                } else if (buffer.split("3gpp-application.")[1].trim().equals("")) {
                    try {
                        throw new InvalidArgumentException("URN should atleast have one sub-application");
                    } catch (InvalidArgumentException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    pAssertedService.setApplicationIdentifiers(buffer.split(ParameterNamesIms.APPLICATION_ID_LABEL)[1]);
                }
            }
            super.parse();
            return pAssertedService;
        } finally {
            if (ParserCore.debug) {
                dbg_enter("PAssertedServiceParser.parse");
            }
        }
    }

    public PAssertedServiceParser(String str) {
        super(str);
    }
}
