package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.ContentLength;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class ContentLengthParser extends HeaderParser {
    public ContentLengthParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("ContentLengthParser.enter");
        }
        try {
            try {
                ContentLength contentLength = new ContentLength();
                headerName(TokenTypes.CONTENT_LENGTH);
                contentLength.setContentLength(Integer.parseInt(this.lexer.number()));
                this.lexer.SPorHT();
                this.lexer.match(10);
                if (z) {
                    dbg_leave("ContentLengthParser.leave");
                }
                return contentLength;
            } catch (InvalidArgumentException e) {
                throw createParseException(e.getMessage());
            } catch (NumberFormatException e2) {
                throw createParseException(e2.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("ContentLengthParser.leave");
            }
            throw th;
        }
    }

    protected ContentLengthParser(Lexer lexer) {
        super(lexer);
    }
}
