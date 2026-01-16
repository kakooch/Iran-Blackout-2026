package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.Privacy;
import android.gov.nist.javax.sip.header.ims.PrivacyList;
import android.gov.nist.javax.sip.parser.HeaderParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;

/* loaded from: classes.dex */
public class PrivacyParser extends HeaderParser implements TokenTypes {
    public PrivacyParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"Privacy: none\n", "Privacy: none;id;user\n"};
        for (int i = 0; i < 2; i++) {
            PrivacyList privacyList = (PrivacyList) new PrivacyParser(strArr2[i]).parse();
            System.out.println("encoded = " + privacyList.encode());
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("PrivacyParser.parse");
        }
        PrivacyList privacyList = new PrivacyList();
        try {
            headerName(TokenTypes.PRIVACY);
            while (this.lexer.lookAhead(0) != '\n') {
                this.lexer.SPorHT();
                Privacy privacy = new Privacy();
                privacy.setHeaderName("Privacy");
                this.lexer.match(4095);
                privacy.setPrivacy(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                privacyList.add((PrivacyList) privacy);
                while (this.lexer.lookAhead(0) == ';') {
                    this.lexer.match(59);
                    this.lexer.SPorHT();
                    Privacy privacy2 = new Privacy();
                    this.lexer.match(4095);
                    privacy2.setPrivacy(this.lexer.getNextToken().getTokenValue());
                    this.lexer.SPorHT();
                    privacyList.add((PrivacyList) privacy2);
                }
            }
            return privacyList;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("PrivacyParser.parse");
            }
        }
    }

    protected PrivacyParser(Lexer lexer) {
        super(lexer);
    }
}
