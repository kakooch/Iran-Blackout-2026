package android.gov.nist.javax.sdp.parser;

import android.gov.nist.core.NameValue;
import android.gov.nist.javax.sdp.fields.KeyField;
import android.gov.nist.javax.sdp.fields.SDPField;
import java.text.ParseException;

/* loaded from: classes.dex */
public class KeyFieldParser extends SDPParser {
    public KeyFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    public KeyField keyField() throws ParseException {
        NameValue nameValue;
        try {
            this.lexer.match(107);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            KeyField keyField = new KeyField();
            new NameValue();
            int iMarkInputPosition = this.lexer.markInputPosition();
            try {
                String nextToken = this.lexer.getNextToken(':');
                this.lexer.consume(1);
                nameValue = new NameValue(nextToken.trim(), this.lexer.getRest().trim());
            } catch (ParseException unused) {
                this.lexer.rewindInputPosition(iMarkInputPosition);
                String rest = this.lexer.getRest();
                if (rest == null) {
                    throw new ParseException(this.lexer.getBuffer(), this.lexer.getPtr());
                }
                nameValue = new NameValue(rest.trim(), null);
            }
            keyField.setType(nameValue.getName());
            keyField.setKeyData((String) nameValue.getValueAsObject());
            this.lexer.SPorHT();
            return keyField;
        } catch (Exception unused2) {
            throw new ParseException(this.lexer.getBuffer(), this.lexer.getPtr());
        }
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return keyField();
    }
}
