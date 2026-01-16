package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.To;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ToParser extends AddressParametersParser {
    public ToParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.TO);
        To to = new To();
        super.parse((AddressParametersHeader) to);
        this.lexer.match(10);
        return to;
    }

    protected ToParser(Lexer lexer) {
        super(lexer);
    }
}
