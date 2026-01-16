package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.SecurityVerify;
import android.gov.nist.javax.sip.header.ims.SecurityVerifyList;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class SecurityVerifyParser extends SecurityAgreeParser {
    public SecurityVerifyParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        dbg_enter("SecuriryVerify parse");
        try {
            headerName(TokenTypes.SECURITY_VERIFY);
            return (SecurityVerifyList) super.parse(new SecurityVerify());
        } finally {
            dbg_leave("SecuriryVerify parse");
        }
    }

    protected SecurityVerifyParser(Lexer lexer) {
        super(lexer);
    }
}
