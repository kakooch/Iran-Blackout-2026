package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.Priority;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class PriorityParser extends HeaderParser {
    public PriorityParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        Priority priority = (Priority) new PriorityParser(new String[]{"Priority: 8;a\n"}[0]).parse();
        System.out.println("encoded = " + priority.encode());
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("PriorityParser.parse");
        }
        Priority priority = new Priority();
        try {
            headerName(TokenTypes.PRIORITY);
            priority.setHeaderName(SIPHeaderNames.PRIORITY);
            this.lexer.SPorHT();
            priority.setPriority(this.lexer.ttokenSafe());
            this.lexer.SPorHT();
            this.lexer.match(10);
            if (z) {
                dbg_leave("PriorityParser.parse");
            }
            return priority;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("PriorityParser.parse");
            }
            throw th;
        }
    }

    protected PriorityParser(Lexer lexer) {
        super(lexer);
    }
}
