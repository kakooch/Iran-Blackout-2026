package android.gov.nist.javax.sdp.parser;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sdp.fields.PhoneField;
import android.gov.nist.javax.sdp.fields.SDPField;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PhoneFieldParser extends SDPParser {
    public PhoneFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
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

    public String getPhoneNumber(String str) throws ParseException {
        try {
            int iIndexOf = str.indexOf(Separators.LPAREN);
            if (iIndexOf != -1) {
                return str.substring(0, iIndexOf).trim();
            }
            int iIndexOf2 = str.indexOf(Separators.LESS_THAN);
            return iIndexOf2 != -1 ? str.substring(iIndexOf2 + 1, str.indexOf(Separators.GREATER_THAN)) : str.trim();
        } catch (Exception unused) {
            throw new ParseException(this.lexer.getBuffer(), this.lexer.getPtr());
        }
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return phoneField();
    }

    public PhoneField phoneField() throws ParseException {
        try {
            this.lexer.match(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            PhoneField phoneField = new PhoneField();
            String rest = this.lexer.getRest();
            phoneField.setName(getDisplayName(rest.trim()));
            phoneField.setPhoneNumber(getPhoneNumber(rest));
            return phoneField;
        } catch (Exception unused) {
            throw new ParseException(this.lexer.getBuffer(), this.lexer.getPtr());
        }
    }
}
