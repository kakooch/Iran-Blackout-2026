package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.ReferTo;
import android.gov.nist.javax.sip.header.SIPHeader;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ReferToParser extends AddressParametersParser {
    public ReferToParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"Refer-To: <sip:dave@denver.example.org?Replaces=12345%40192.168.118.3%3Bto-tag%3D12345%3Bfrom-tag%3D5FFE-3994>\n", "Refer-To: <sip:+1-650-555-2222@ss1.wcom.com;user=phone>;tag=5617\n", "Refer-To: T. A. Watson <sip:watson@bell-telephone.com>\n", "Refer-To: LittleGuy <sip:UserB@there.com>\n", "Refer-To: sip:mranga@120.6.55.9\n", "Refer-To: sip:mranga@129.6.55.9 ; tag=696928473514.129.6.55.9\n"};
        for (int i = 0; i < 6; i++) {
            ReferTo referTo = (ReferTo) new ReferToParser(strArr2[i]).parse();
            System.out.println("encoded = " + referTo.encode());
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.REFER_TO);
        ReferTo referTo = new ReferTo();
        super.parse((AddressParametersHeader) referTo);
        this.lexer.match(10);
        return referTo;
    }

    protected ReferToParser(Lexer lexer) {
        super(lexer);
    }
}
