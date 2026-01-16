package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.SecurityClient;
import android.gov.nist.javax.sip.header.ims.SecurityClientList;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class SecurityClientParser extends SecurityAgreeParser {
    public SecurityClientParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        dbg_enter("SecuriryClient parse");
        try {
            headerName(TokenTypes.SECURITY_CLIENT);
            return (SecurityClientList) super.parse(new SecurityClient());
        } finally {
            dbg_leave("SecuriryClient parse");
        }
    }

    protected SecurityClientParser(Lexer lexer) {
        super(lexer);
    }
}
