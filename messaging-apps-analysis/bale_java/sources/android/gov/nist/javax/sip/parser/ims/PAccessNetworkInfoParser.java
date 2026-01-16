package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PAccessNetworkInfo;
import android.gov.nist.javax.sip.parser.HeaderParser;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PAccessNetworkInfoParser extends HeaderParser implements TokenTypes {
    public PAccessNetworkInfoParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        String strTtokenGenValue;
        if (ParserCore.debug) {
            dbg_enter("AccessNetworkInfoParser.parse");
        }
        try {
            headerName(TokenTypes.P_ACCESS_NETWORK_INFO);
            PAccessNetworkInfo pAccessNetworkInfo = new PAccessNetworkInfo();
            pAccessNetworkInfo.setHeaderName("P-Access-Network-Info");
            this.lexer.SPorHT();
            this.lexer.match(4095);
            pAccessNetworkInfo.setAccessType(this.lexer.getNextToken().getTokenValue());
            this.lexer.SPorHT();
            while (this.lexer.lookAhead(0) == ';') {
                this.lexer.match(59);
                this.lexer.SPorHT();
                try {
                    pAccessNetworkInfo.setParameter(super.nameValue('='));
                } catch (ParseException unused) {
                    this.lexer.SPorHT();
                    String strQuotedString = this.lexer.quotedString();
                    if (strQuotedString == null) {
                        strTtokenGenValue = this.lexer.ttokenGenValue();
                    } else {
                        strTtokenGenValue = Separators.DOUBLE_QUOTE + strQuotedString + Separators.DOUBLE_QUOTE;
                    }
                    pAccessNetworkInfo.setExtensionAccessInfo(strTtokenGenValue);
                }
                this.lexer.SPorHT();
            }
            this.lexer.SPorHT();
            this.lexer.match(10);
            return pAccessNetworkInfo;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("AccessNetworkInfoParser.parse");
            }
        }
    }

    protected PAccessNetworkInfoParser(Lexer lexer) {
        super(lexer);
    }
}
