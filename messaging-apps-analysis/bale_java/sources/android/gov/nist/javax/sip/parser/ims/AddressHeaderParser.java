package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.javax.sip.header.ims.AddressHeaderIms;
import android.gov.nist.javax.sip.parser.AddressParser;
import android.gov.nist.javax.sip.parser.HeaderParser;
import android.gov.nist.javax.sip.parser.Lexer;
import java.text.ParseException;

/* loaded from: classes.dex */
abstract class AddressHeaderParser extends HeaderParser {
    protected AddressHeaderParser(Lexer lexer) {
        super(lexer);
    }

    protected void parse(AddressHeaderIms addressHeaderIms) {
        dbg_enter("AddressHeaderParser.parse");
        try {
            try {
                addressHeaderIms.setAddress(new AddressParser(getLexer()).address(true));
            } catch (ParseException e) {
                throw e;
            }
        } finally {
            dbg_leave("AddressParametersParser.parse");
        }
    }

    protected AddressHeaderParser(String str) {
        super(str);
    }
}
