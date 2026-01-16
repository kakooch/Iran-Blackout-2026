package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentity;
import android.gov.nist.javax.sip.header.ims.PAssertedIdentityList;
import android.gov.nist.javax.sip.parser.AddressParametersParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class PAssertedIdentityParser extends AddressParametersParser implements TokenTypes {
    public PAssertedIdentityParser(String str) {
        super(str);
        this.allowParameters = false;
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("AssertedIdentityParser.parse");
        }
        PAssertedIdentityList pAssertedIdentityList = new PAssertedIdentityList();
        try {
            headerName(TokenTypes.P_ASSERTED_IDENTITY);
            PAssertedIdentity pAssertedIdentity = new PAssertedIdentity();
            pAssertedIdentity.setHeaderName("P-Asserted-Identity");
            super.parse((AddressParametersHeader) pAssertedIdentity);
            pAssertedIdentityList.add((PAssertedIdentityList) pAssertedIdentity);
            this.lexer.SPorHT();
            while (this.lexer.lookAhead(0) == ',') {
                this.lexer.match(44);
                this.lexer.SPorHT();
                PAssertedIdentity pAssertedIdentity2 = new PAssertedIdentity();
                super.parse((AddressParametersHeader) pAssertedIdentity2);
                pAssertedIdentityList.add((PAssertedIdentityList) pAssertedIdentity2);
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (ParserCore.debug) {
                dbg_leave("AssertedIdentityParser.parse");
            }
            return pAssertedIdentityList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("AssertedIdentityParser.parse");
            }
            throw th;
        }
    }

    protected PAssertedIdentityParser(Lexer lexer) {
        super(lexer);
        this.allowParameters = false;
    }
}
