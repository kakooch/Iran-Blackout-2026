package android.gov.nist.javax.sip.parser.extensions;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.extensions.Join;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.ParametersParser;
import android.gov.nist.javax.sip.parser.TokenTypes;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class JoinParser extends ParametersParser {
    public JoinParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"Join: 12345th5z8z\n", "Join: 12345th5z8z;to-tag=tozght6-45;from-tag=fromzght789-337-2\n"};
        for (int i = 0; i < 2; i++) {
            Join join = (Join) new JoinParser(strArr2[i]).parse();
            PrintStream printStream = System.out;
            printStream.println("Parsing => " + strArr2[i]);
            printStream.print("encoded = " + join.encode() + "==> ");
            printStream.println("callId " + join.getCallId() + " from-tag=" + join.getFromTag() + " to-tag=" + join.getToTag());
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parse");
        }
        try {
            headerName(TokenTypes.JOIN_TO);
            Join join = new Join();
            this.lexer.SPorHT();
            String strByteStringNoSemicolon = this.lexer.byteStringNoSemicolon();
            this.lexer.SPorHT();
            super.parse(join);
            join.setCallId(strByteStringNoSemicolon);
            if (z) {
                dbg_leave("parse");
            }
            return join;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    protected JoinParser(Lexer lexer) {
        super(lexer);
    }
}
