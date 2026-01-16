package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.SecurityServer;
import android.gov.nist.javax.sip.header.ims.SecurityServerList;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class SecurityServerParser extends SecurityAgreeParser {
    public SecurityServerParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        dbg_enter("SecuriryServer parse");
        try {
            headerName(TokenTypes.SECURITY_SERVER);
            return (SecurityServerList) super.parse(new SecurityServer());
        } finally {
            dbg_leave("SecuriryServer parse");
        }
    }

    protected SecurityServerParser(Lexer lexer) {
        super(lexer);
    }
}
