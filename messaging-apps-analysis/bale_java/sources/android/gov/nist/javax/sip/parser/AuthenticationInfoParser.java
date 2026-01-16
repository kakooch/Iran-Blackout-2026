package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AuthenticationInfo;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class AuthenticationInfoParser extends ParametersParser {
    public AuthenticationInfoParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("AuthenticationInfoParser.parse");
        }
        try {
            headerName(TokenTypes.AUTHENTICATION_INFO);
            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setHeaderName(SIPHeaderNames.AUTHENTICATION_INFO);
            this.lexer.SPorHT();
            NameValue nameValue = super.nameValue();
            if ("".equals(nameValue.getValue()) && !nameValue.isValueQuoted()) {
                authenticationInfo.setScheme(nameValue.getKey());
                nameValue = super.nameValue();
            }
            authenticationInfo.setParameter(nameValue);
            this.lexer.SPorHT();
            while (this.lexer.lookAhead(0) == ',') {
                this.lexer.match(44);
                this.lexer.SPorHT();
                authenticationInfo.setParameter(super.nameValue());
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (ParserCore.debug) {
                dbg_leave("AuthenticationInfoParser.parse");
            }
            return authenticationInfo;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("AuthenticationInfoParser.parse");
            }
            throw th;
        }
    }

    protected AuthenticationInfoParser(Lexer lexer) {
        super(lexer);
    }
}
