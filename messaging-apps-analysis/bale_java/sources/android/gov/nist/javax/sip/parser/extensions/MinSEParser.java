package android.gov.nist.javax.sip.parser.extensions;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.extensions.MinSE;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.ParametersParser;
import android.gov.nist.javax.sip.parser.TokenTypes;
import android.javax.sip.InvalidArgumentException;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class MinSEParser extends ParametersParser {
    public MinSEParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"Min-SE: 30\n", "Min-SE: 45;some-param=somevalue\n"};
        for (int i = 0; i < 2; i++) {
            MinSE minSE = (MinSE) new MinSEParser(strArr2[i]).parse();
            PrintStream printStream = System.out;
            printStream.println("encoded = " + minSE.encode());
            printStream.println("\ntime=" + minSE.getExpires());
            if (minSE.getParameter("some-param") != null) {
                printStream.println("some-param=" + minSE.getParameter("some-param"));
            }
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        MinSE minSE = new MinSE();
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parse");
        }
        try {
            headerName(TokenTypes.MINSE_TO);
            try {
                minSE.setExpires(Integer.parseInt(this.lexer.getNextId()));
                this.lexer.SPorHT();
                super.parse(minSE);
                if (z) {
                    dbg_leave("parse");
                }
                return minSE;
            } catch (InvalidArgumentException e) {
                throw createParseException(e.getMessage());
            } catch (NumberFormatException unused) {
                throw createParseException("bad integer format");
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("parse");
            }
            throw th;
        }
    }

    protected MinSEParser(Lexer lexer) {
        super(lexer);
    }
}
