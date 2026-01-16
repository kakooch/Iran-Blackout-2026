package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.StatusLine;
import java.text.ParseException;

/* loaded from: classes.dex */
public class StatusLineParser extends Parser {
    public StatusLineParser(String str) {
        this.lexer = new Lexer("status_lineLexer", str);
    }

    public StatusLine parse() {
        try {
            boolean z = ParserCore.debug;
            if (z) {
                dbg_enter("parse");
            }
            StatusLine statusLine = new StatusLine();
            statusLine.setSipVersion(sipVersion());
            this.lexer.SPorHT();
            statusLine.setStatusCode(statusCode());
            this.lexer.SPorHT();
            statusLine.setReasonPhrase(reasonPhrase());
            this.lexer.SPorHT();
            if (z) {
                dbg_leave("parse");
            }
            return statusLine;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    protected String reasonPhrase() {
        return this.lexer.getRest().trim();
    }

    /* JADX WARN: Finally extract failed */
    protected int statusCode() throws ParseException {
        String strNumber = this.lexer.number();
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("statusCode");
        }
        try {
            try {
                int i = Integer.parseInt(strNumber);
                if (z) {
                    dbg_leave("statusCode");
                }
                return i;
            } catch (NumberFormatException e) {
                throw new ParseException(this.lexer.getBuffer() + ":" + e.getMessage(), this.lexer.getPtr());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("statusCode");
            }
            throw th;
        }
    }

    public StatusLineParser(Lexer lexer) {
        this.lexer = lexer;
        lexer.selectLexer("status_lineLexer");
    }
}
