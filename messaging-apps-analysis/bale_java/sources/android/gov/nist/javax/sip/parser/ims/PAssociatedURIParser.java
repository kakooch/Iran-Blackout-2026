package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PAssociatedURI;
import android.gov.nist.javax.sip.header.ims.PAssociatedURIList;
import android.gov.nist.javax.sip.parser.AddressParametersParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class PAssociatedURIParser extends AddressParametersParser {
    public PAssociatedURIParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("PAssociatedURIParser.parse");
        }
        PAssociatedURIList pAssociatedURIList = new PAssociatedURIList();
        try {
            headerName(TokenTypes.P_ASSOCIATED_URI);
            PAssociatedURI pAssociatedURI = new PAssociatedURI();
            pAssociatedURI.setHeaderName("P-Associated-URI");
            super.parse((AddressParametersHeader) pAssociatedURI);
            pAssociatedURIList.add((PAssociatedURIList) pAssociatedURI);
            this.lexer.SPorHT();
            while (this.lexer.lookAhead(0) == ',') {
                this.lexer.match(44);
                this.lexer.SPorHT();
                PAssociatedURI pAssociatedURI2 = new PAssociatedURI();
                super.parse((AddressParametersHeader) pAssociatedURI2);
                pAssociatedURIList.add((PAssociatedURIList) pAssociatedURI2);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (ParserCore.debug) {
                dbg_leave("PAssociatedURIParser.parse");
            }
            return pAssociatedURIList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("PAssociatedURIParser.parse");
            }
            throw th;
        }
    }

    protected PAssociatedURIParser(Lexer lexer) {
        super(lexer);
    }
}
