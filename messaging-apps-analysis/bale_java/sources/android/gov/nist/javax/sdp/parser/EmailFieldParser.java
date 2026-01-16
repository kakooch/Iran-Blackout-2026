package android.gov.nist.javax.sdp.parser;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sdp.fields.Email;
import android.gov.nist.javax.sdp.fields.EmailAddress;
import android.gov.nist.javax.sdp.fields.EmailField;
import android.gov.nist.javax.sdp.fields.SDPField;
import java.text.ParseException;

/* loaded from: classes.dex */
public class EmailFieldParser extends SDPParser {
    public EmailFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    public EmailField emailField() throws ParseException {
        try {
            this.lexer.match(101);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            EmailField emailField = new EmailField();
            EmailAddress emailAddress = new EmailAddress();
            String rest = this.lexer.getRest();
            emailAddress.setDisplayName(getDisplayName(rest.trim()));
            emailAddress.setEmail(getEmail(rest));
            emailField.setEmailAddress(emailAddress);
            return emailField;
        } catch (Exception unused) {
            throw new ParseException(this.lexer.getBuffer(), this.lexer.getPtr());
        }
    }

    public String getDisplayName(String str) {
        String strSubstring = null;
        try {
            int iIndexOf = str.indexOf(Separators.LPAREN);
            int iIndexOf2 = str.indexOf(Separators.RPAREN);
            if (iIndexOf != -1) {
                strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            } else {
                int iIndexOf3 = str.indexOf(Separators.LESS_THAN);
                if (iIndexOf3 != -1) {
                    strSubstring = str.substring(0, iIndexOf3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strSubstring;
    }

    public Email getEmail(String str) {
        Email email = new Email();
        try {
            int iIndexOf = str.indexOf(Separators.LPAREN);
            if (iIndexOf != -1) {
                String strSubstring = str.substring(0, iIndexOf);
                int iIndexOf2 = strSubstring.indexOf(Separators.AT);
                if (iIndexOf2 != -1) {
                    email.setUserName(strSubstring.substring(0, iIndexOf2));
                    email.setHostName(strSubstring.substring(iIndexOf2 + 1));
                }
            } else {
                int iIndexOf3 = str.indexOf(Separators.LESS_THAN);
                int iIndexOf4 = str.indexOf(Separators.GREATER_THAN);
                if (iIndexOf3 != -1) {
                    String strSubstring2 = str.substring(iIndexOf3 + 1, iIndexOf4);
                    int iIndexOf5 = strSubstring2.indexOf(Separators.AT);
                    if (iIndexOf5 != -1) {
                        email.setUserName(strSubstring2.substring(0, iIndexOf5));
                        email.setHostName(strSubstring2.substring(iIndexOf5 + 1));
                    }
                } else {
                    int iIndexOf6 = str.indexOf(Separators.AT);
                    str.indexOf(Separators.RETURN);
                    if (iIndexOf6 != -1) {
                        email.setUserName(str.substring(0, iIndexOf6));
                        email.setHostName(str.substring(iIndexOf6 + 1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return emailField();
    }
}
