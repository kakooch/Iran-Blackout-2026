package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.Debug;
import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.javax.sip.InvalidArgumentException;
import java.text.ParseException;

/* loaded from: classes.dex */
public class CSeqParser extends HeaderParser {
    public CSeqParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() throws ParseException {
        try {
            CSeq cSeq = new CSeq();
            headerName(TokenTypes.CSEQ);
            cSeq.setSeqNumber(Long.parseLong(this.lexer.number()));
            this.lexer.SPorHT();
            cSeq.setMethod(SIPRequest.getCannonicalName(method()).intern());
            this.lexer.SPorHT();
            this.lexer.match(10);
            return cSeq;
        } catch (InvalidArgumentException e) {
            Debug.printStackTrace(e);
            throw createParseException(e.getMessage());
        } catch (NumberFormatException e2) {
            Debug.printStackTrace(e2);
            throw createParseException("Number format exception");
        }
    }

    protected CSeqParser(Lexer lexer) {
        super(lexer);
    }
}
