package android.gov.nist.javax.sip.parser.extensions;

import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.extensions.ReferredBy;
import android.gov.nist.javax.sip.parser.AddressParametersParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ReferredByParser extends AddressParametersParser {
    public ReferredByParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"Referred-By: <sip:dave@denver.example.org?Replaces=12345%40192.168.118.3%3Bto-tag%3D12345%3Bfrom-tag%3D5FFE-3994>\n", "Referred-By: <sip:+1-650-555-2222@ss1.wcom.com;user=phone>;tag=5617\n", "Referred-By: T. A. Watson <sip:watson@bell-telephone.com>\n", "Referred-By: LittleGuy <sip:UserB@there.com>\n", "Referred-By: sip:mranga@120.6.55.9\n", "Referred-By: sip:mranga@129.6.55.9 ; tag=696928473514.129.6.55.9\n"};
        for (int i = 0; i < 6; i++) {
            ReferredBy referredBy = (ReferredBy) new ReferredByParser(strArr2[i]).parse();
            System.out.println("encoded = " + referredBy.encode());
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.REFERREDBY_TO);
        ReferredBy referredBy = new ReferredBy();
        super.parse((AddressParametersHeader) referredBy);
        this.lexer.match(10);
        return referredBy;
    }

    protected ReferredByParser(Lexer lexer) {
        super(lexer);
    }
}
