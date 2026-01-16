package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.ContentEncoding;
import android.gov.nist.javax.sip.header.ContentEncodingList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ContentEncodingParser extends HeaderParser {
    public ContentEncodingParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("ContentEncodingParser.parse");
        }
        ContentEncodingList contentEncodingList = new ContentEncodingList();
        try {
            try {
                headerName(TokenTypes.CONTENT_ENCODING);
                while (this.lexer.lookAhead(0) != '\n') {
                    ContentEncoding contentEncoding = new ContentEncoding();
                    contentEncoding.setHeaderName(SIPHeaderNames.CONTENT_ENCODING);
                    this.lexer.SPorHT();
                    this.lexer.match(4095);
                    contentEncoding.setEncoding(this.lexer.getNextToken().getTokenValue());
                    this.lexer.SPorHT();
                    contentEncodingList.add((ContentEncodingList) contentEncoding);
                    while (this.lexer.lookAhead(0) == ',') {
                        ContentEncoding contentEncoding2 = new ContentEncoding();
                        this.lexer.match(44);
                        this.lexer.SPorHT();
                        this.lexer.match(4095);
                        this.lexer.SPorHT();
                        contentEncoding2.setEncoding(this.lexer.getNextToken().getTokenValue());
                        this.lexer.SPorHT();
                        contentEncodingList.add((ContentEncodingList) contentEncoding2);
                    }
                }
                return contentEncodingList;
            } catch (ParseException e) {
                throw createParseException(e.getMessage());
            }
        } finally {
            if (ParserCore.debug) {
                dbg_leave("ContentEncodingParser.parse");
            }
        }
    }

    protected ContentEncodingParser(Lexer lexer) {
        super(lexer);
    }
}
