package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.ServiceRoute;
import android.gov.nist.javax.sip.header.ims.ServiceRouteList;
import android.gov.nist.javax.sip.parser.AddressParametersParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class ServiceRouteParser extends AddressParametersParser {
    public ServiceRouteParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        ServiceRouteList serviceRouteList = new ServiceRouteList();
        if (ParserCore.debug) {
            dbg_enter("ServiceRouteParser.parse");
        }
        try {
            this.lexer.match(TokenTypes.SERVICE_ROUTE);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            while (true) {
                ServiceRoute serviceRoute = new ServiceRoute();
                super.parse((AddressParametersHeader) serviceRoute);
                serviceRouteList.add((ServiceRouteList) serviceRoute);
                this.lexer.SPorHT();
                if (this.lexer.lookAhead(0) != ',') {
                    break;
                }
                this.lexer.match(44);
                this.lexer.SPorHT();
            }
            if (this.lexer.lookAhead(0) != '\n') {
                throw createParseException("unexpected char");
            }
            if (ParserCore.debug) {
                dbg_leave("ServiceRouteParser.parse");
            }
            return serviceRouteList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("ServiceRouteParser.parse");
            }
            throw th;
        }
    }

    protected ServiceRouteParser(Lexer lexer) {
        super(lexer);
    }
}
