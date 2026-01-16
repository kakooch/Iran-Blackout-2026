package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.ContentDisposition;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ContentDispositionParser extends ParametersParser {
    public ContentDispositionParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("ContentDispositionParser.parse");
        }
        try {
            try {
                headerName(TokenTypes.CONTENT_DISPOSITION);
                ContentDisposition contentDisposition = new ContentDisposition();
                contentDisposition.setHeaderName(SIPHeaderNames.CONTENT_DISPOSITION);
                this.lexer.SPorHT();
                this.lexer.match(4095);
                contentDisposition.setDispositionType(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                super.parse(contentDisposition);
                this.lexer.SPorHT();
                this.lexer.match(10);
                if (z) {
                    dbg_leave("ContentDispositionParser.parse");
                }
                return contentDisposition;
            } catch (ParseException e) {
                throw createParseException(e.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("ContentDispositionParser.parse");
            }
            throw th;
        }
    }

    protected ContentDispositionParser(Lexer lexer) {
        super(lexer);
    }
}
