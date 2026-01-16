package android.gov.nist.javax.sdp.parser;

import android.gov.nist.core.Token;
import android.gov.nist.javax.sdp.fields.SDPField;
import android.gov.nist.javax.sdp.fields.TypedTime;
import android.gov.nist.javax.sdp.fields.ZoneAdjustment;
import android.gov.nist.javax.sdp.fields.ZoneField;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ZoneFieldParser extends SDPParser {
    public ZoneFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    public String getSign(String str) {
        return str.startsWith("-") ? "-" : "+";
    }

    public TypedTime getTypedTime(String str) {
        TypedTime typedTime = new TypedTime();
        if (str.startsWith("-")) {
            str = str.replace('-', ' ');
        } else if (str.startsWith("+")) {
            str = str.replace('+', ' ');
        }
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
        return zoneField();
    }

    public ZoneField zoneField() throws ParseException {
        char cLookAhead;
        try {
            ZoneField zoneField = new ZoneField();
            this.lexer.match(122);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            while (this.lexer.hasMoreChars() && (cLookAhead = this.lexer.lookAhead(0)) != '\n' && cLookAhead != '\r') {
                ZoneAdjustment zoneAdjustment = new ZoneAdjustment();
                this.lexer.match(4095);
                Token nextToken = this.lexer.getNextToken();
                this.lexer.SPorHT();
                String tokenValue = nextToken.getTokenValue();
                if (tokenValue.length() > 18) {
                    tokenValue = tokenValue.substring(tokenValue.length() - 18);
                }
                zoneAdjustment.setTime(Long.parseLong(tokenValue));
                this.lexer.match(4095);
                Token nextToken2 = this.lexer.getNextToken();
                this.lexer.SPorHT();
                String sign = getSign(nextToken2.getTokenValue());
                TypedTime typedTime = getTypedTime(nextToken2.getTokenValue());
                zoneAdjustment.setSign(sign);
                zoneAdjustment.setOffset(typedTime);
                zoneField.addZoneAdjustment(zoneAdjustment);
            }
            return zoneField;
        } catch (Exception unused) {
            throw this.lexer.createParseException();
        }
    }
}
