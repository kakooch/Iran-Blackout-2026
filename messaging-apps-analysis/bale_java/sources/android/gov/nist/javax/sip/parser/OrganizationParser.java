package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.Organization;
import android.gov.nist.javax.sip.header.SIPHeader;

/* loaded from: classes.dex */
public class OrganizationParser extends HeaderParser {
    public OrganizationParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("OrganizationParser.parse");
        }
        Organization organization = new Organization();
        try {
            headerName(TokenTypes.ORGANIZATION);
            organization.setOrganization(this.lexer.getRest().trim());
            if (z) {
                dbg_leave("OrganizationParser.parse");
            }
            return organization;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("OrganizationParser.parse");
            }
            throw th;
        }
    }

    protected OrganizationParser(Lexer lexer) {
        super(lexer);
    }
}
