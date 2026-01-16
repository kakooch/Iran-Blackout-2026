package android.gov.nist.javax.sdp.parser;

import android.gov.nist.core.Token;
import android.gov.nist.javax.sdp.fields.RepeatField;
import android.gov.nist.javax.sdp.fields.SDPField;
import android.gov.nist.javax.sdp.fields.TypedTime;
import java.text.ParseException;

/* loaded from: classes.dex */
public class RepeatFieldParser extends SDPParser {
    public RepeatFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    public TypedTime getTypedTime(String str) {
        TypedTime typedTime = new TypedTime();
        if (str.endsWith("d")) {
            typedTime.setUnit("d");
            typedTime.setTime(Integer.parseInt(str.replace('d', ' ').trim()));
        } else if (str.endsWith("h")) {
            typedTime.setUnit("h");
            typedTime.setTime(Integer.parseInt(str.replace('h', ' ').trim()));
        } else if (str.endsWith("m")) {
            typedTime.setUnit("m");
            typedTime.setTime(Integer.parseInt(str.replace('m', ' ').trim()));
        } else {
            typedTime.setUnit("s");
            if (str.endsWith("s")) {
                typedTime.setTime(Integer.parseInt(str.replace('s', ' ').trim()));
            } else {
                typedTime.setTime(Integer.parseInt(str.trim()));
            }
        }
        return typedTime;
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return repeatField();
    }

    public RepeatField repeatField() throws ParseException {
        char cLookAhead;
        try {
            this.lexer.match(114);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            RepeatField repeatField = new RepeatField();
            this.lexer.match(4095);
            Token nextToken = this.lexer.getNextToken();
            this.lexer.SPorHT();
            repeatField.setRepeatInterval(getTypedTime(nextToken.getTokenValue()));
            this.lexer.match(4095);
            Token nextToken2 = this.lexer.getNextToken();
            this.lexer.SPorHT();
            repeatField.setActiveDuration(getTypedTime(nextToken2.getTokenValue()));
            while (this.lexer.hasMoreChars() && (cLookAhead = this.lexer.lookAhead(0)) != '\n' && cLookAhead != '\r') {
                this.lexer.match(4095);
                Token nextToken3 = this.lexer.getNextToken();
                this.lexer.SPorHT();
                repeatField.addOffset(getTypedTime(nextToken3.getTokenValue()));
            }
            return repeatField;
        } catch (Exception unused) {
            throw this.lexer.createParseException();
        }
    }
}
