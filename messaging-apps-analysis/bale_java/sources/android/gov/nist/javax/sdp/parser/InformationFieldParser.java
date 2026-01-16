package android.gov.nist.javax.sdp.parser;

import android.gov.nist.javax.sdp.fields.InformationField;
import android.gov.nist.javax.sdp.fields.SDPField;
import java.text.ParseException;

/* loaded from: classes.dex */
public class InformationFieldParser extends SDPParser {
    public InformationFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    public InformationField informationField() throws ParseException {
        try {
            this.lexer.match(105);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            InformationField informationField = new InformationField();
            informationField.setInformation(this.lexer.getRest().trim());
            return informationField;
        } catch (Exception unused) {
            throw new ParseException(this.lexer.getBuffer(), this.lexer.getPtr());
        }
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return informationField();
    }
}
