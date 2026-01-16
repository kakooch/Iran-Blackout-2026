package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.AddressParametersHeader;
import android.gov.nist.javax.sip.header.ReplyTo;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class ReplyToParser extends AddressParametersParser {
    public ReplyToParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        ReplyTo replyTo = new ReplyTo();
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("ReplyTo.parse");
        }
        try {
            headerName(TokenTypes.REPLY_TO);
            replyTo.setHeaderName(SIPHeaderNames.REPLY_TO);
            super.parse((AddressParametersHeader) replyTo);
            if (z) {
                dbg_leave("ReplyTo.parse");
            }
            return replyTo;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("ReplyTo.parse");
            }
            throw th;
        }
    }

    protected ReplyToParser(Lexer lexer) {
        super(lexer);
    }
}
