package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.Subject;

/* loaded from: classes.dex */
public class SubjectParser extends HeaderParser {
    public SubjectParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        Subject subject = new Subject();
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("SubjectParser.parse");
        }
        try {
            headerName(TokenTypes.SUBJECT);
            subject.setSubject(this.lexer.getRest().trim());
            if (z) {
                dbg_leave("SubjectParser.parse");
            }
            return subject;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("SubjectParser.parse");
            }
            throw th;
        }
    }

    protected SubjectParser(Lexer lexer) {
        super(lexer);
    }
}
