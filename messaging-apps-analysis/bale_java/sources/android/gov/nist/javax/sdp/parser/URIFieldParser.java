package android.gov.nist.javax.sdp.parser;

import android.gov.nist.javax.sdp.fields.SDPField;
import android.gov.nist.javax.sdp.fields.URIField;
import java.text.ParseException;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class URIFieldParser extends SDPParser {
    public URIFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return uriField();
    }

    public URIField uriField() throws ParseException {
        try {
            this.lexer.match(WKSRecord.Service.UUCP_PATH);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            URIField uRIField = new URIField();
            uRIField.setURI(this.lexer.getRest().trim());
            return uRIField;
        } catch (Exception unused) {
            throw this.lexer.createParseException();
        }
    }
}
