package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.UserAgent;

/* loaded from: classes.dex */
public class UserAgentParser extends HeaderParser {
    public UserAgentParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"User-Agent: Softphone/Beta1.5 \n", "User-Agent:Nist/Beta1 (beta version) \n", "User-Agent: Nist UA (beta version)\n", "User-Agent: Nist1.0/Beta2 Ubi/vers.1.0 (very cool) \n", "User-Agent: SJphone/1.60.299a/L (SJ Labs)\n", "User-Agent: sipXecs/3.5.11 sipXecs/sipxbridge (Linux)\n"};
        for (int i = 0; i < 6; i++) {
            UserAgent userAgent = (UserAgent) new UserAgentParser(strArr2[i]).parse();
            System.out.println("encoded = " + userAgent.encode());
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("UserAgentParser.parse");
        }
        UserAgent userAgent = new UserAgent();
        try {
            headerName(TokenTypes.USER_AGENT);
            if (this.lexer.lookAhead(0) == '\n') {
                throw createParseException("empty header");
            }
            while (this.lexer.lookAhead(0) != '\n' && this.lexer.lookAhead(0) != 0) {
                if (this.lexer.lookAhead(0) == '(') {
                    userAgent.addProductToken('(' + this.lexer.comment() + ')');
                } else {
                    getLexer().SPorHT();
                    String strByteStringNoSlash = this.lexer.byteStringNoSlash();
                    if (strByteStringNoSlash == null) {
                        throw createParseException("Expected product string");
                    }
                    StringBuilder sb = new StringBuilder(strByteStringNoSlash);
                    if (this.lexer.peekNextToken().getTokenType() == 47) {
                        this.lexer.match(47);
                        getLexer().SPorHT();
                        String strByteStringNoSlash2 = this.lexer.byteStringNoSlash();
                        if (strByteStringNoSlash2 == null) {
                            throw createParseException("Expected product version");
                        }
                        sb.append(Separators.SLASH);
                        sb.append(strByteStringNoSlash2);
                    }
                    userAgent.addProductToken(sb.toString());
                }
                this.lexer.SPorHT();
            }
            if (ParserCore.debug) {
                dbg_leave("UserAgentParser.parse");
            }
            return userAgent;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("UserAgentParser.parse");
            }
            throw th;
        }
    }

    protected UserAgentParser(Lexer lexer) {
        super(lexer);
    }
}
