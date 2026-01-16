package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeaderList;
import android.gov.nist.javax.sip.header.ims.SecurityAgree;
import android.gov.nist.javax.sip.header.ims.SecurityClient;
import android.gov.nist.javax.sip.header.ims.SecurityClientList;
import android.gov.nist.javax.sip.header.ims.SecurityServer;
import android.gov.nist.javax.sip.header.ims.SecurityServerList;
import android.gov.nist.javax.sip.header.ims.SecurityVerify;
import android.gov.nist.javax.sip.header.ims.SecurityVerifyList;
import android.gov.nist.javax.sip.parser.HeaderParser;
import android.gov.nist.javax.sip.parser.Lexer;
import java.text.ParseException;

/* loaded from: classes.dex */
public class SecurityAgreeParser extends HeaderParser {
    public SecurityAgreeParser(String str) {
        super(str);
    }

    public SIPHeaderList parse(SecurityAgree securityAgree) throws ParseException {
        SIPHeaderList securityVerifyList;
        if (securityAgree.getClass().isInstance(new SecurityClient())) {
            securityVerifyList = new SecurityClientList();
        } else if (securityAgree.getClass().isInstance(new SecurityServer())) {
            securityVerifyList = new SecurityServerList();
        } else {
            if (!securityAgree.getClass().isInstance(new SecurityVerify())) {
                return null;
            }
            securityVerifyList = new SecurityVerifyList();
        }
        this.lexer.SPorHT();
        this.lexer.match(4095);
        securityAgree.setSecurityMechanism(this.lexer.getNextToken().getTokenValue());
        this.lexer.SPorHT();
        char cLookAhead = this.lexer.lookAhead(0);
        if (cLookAhead == '\n') {
            securityVerifyList.add((SIPHeaderList) securityAgree);
            return securityVerifyList;
        }
        if (cLookAhead == ';') {
            this.lexer.match(59);
        }
        this.lexer.SPorHT();
        while (this.lexer.lookAhead(0) != '\n') {
            parseParameter(securityAgree);
            this.lexer.SPorHT();
            char cLookAhead2 = this.lexer.lookAhead(0);
            if (cLookAhead2 == '\n' || cLookAhead2 == 0) {
                break;
            }
            if (cLookAhead2 == ',') {
                securityVerifyList.add((SIPHeaderList) securityAgree);
                if (securityAgree.getClass().isInstance(new SecurityClient())) {
                    securityAgree = new SecurityClient();
                } else if (securityAgree.getClass().isInstance(new SecurityServer())) {
                    securityAgree = new SecurityServer();
                } else if (securityAgree.getClass().isInstance(new SecurityVerify())) {
                    securityAgree = new SecurityVerify();
                }
                this.lexer.match(44);
                this.lexer.SPorHT();
                this.lexer.match(4095);
                securityAgree.setSecurityMechanism(this.lexer.getNextToken().getTokenValue());
            }
            this.lexer.SPorHT();
            if (this.lexer.lookAhead(0) == ';') {
                this.lexer.match(59);
            }
            this.lexer.SPorHT();
        }
        securityVerifyList.add((SIPHeaderList) securityAgree);
        return securityVerifyList;
    }

    protected void parseParameter(SecurityAgree securityAgree) {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parseParameter");
        }
        try {
            securityAgree.setParameter(nameValue('='));
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

    protected SecurityAgreeParser(Lexer lexer) {
        super(lexer);
    }
}
