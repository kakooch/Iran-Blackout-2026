package android.gov.nist.javax.sip.parser.extensions;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.extensions.SessionExpires;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.ParametersParser;
import android.gov.nist.javax.sip.parser.TokenTypes;
import android.javax.sip.InvalidArgumentException;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class SessionExpiresParser extends ParametersParser {
    public SessionExpiresParser(String str) {
        super(str);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"Session-Expires: 30\n", "Session-Expires: 45;refresher=uac\n"};
        for (int i = 0; i < 2; i++) {
            SessionExpires sessionExpires = (SessionExpires) new SessionExpiresParser(strArr2[i]).parse();
            PrintStream printStream = System.out;
            printStream.println("encoded = " + sessionExpires.encode());
            printStream.println("\ntime=" + sessionExpires.getExpires());
            if (sessionExpires.getParameter(SessionExpires.REFRESHER) != null) {
                printStream.println("refresher=" + sessionExpires.getParameter(SessionExpires.REFRESHER));
            }
        }
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        SessionExpires sessionExpires = new SessionExpires();
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("parse");
        }
        try {
            headerName(TokenTypes.SESSIONEXPIRES_TO);
            try {
                sessionExpires.setExpires(Integer.parseInt(this.lexer.getNextId()));
                this.lexer.SPorHT();
                super.parse(sessionExpires);
                if (z) {
                    dbg_leave("parse");
                }
                return sessionExpires;
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

    protected SessionExpiresParser(Lexer lexer) {
        super(lexer);
    }
}
