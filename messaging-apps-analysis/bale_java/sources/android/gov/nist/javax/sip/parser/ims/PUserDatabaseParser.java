package android.gov.nist.javax.sip.parser.ims;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.ims.PUserDatabase;
import android.gov.nist.javax.sip.parser.Lexer;
import android.gov.nist.javax.sip.parser.ParametersParser;
import android.gov.nist.javax.sip.parser.TokenTypes;
import java.text.ParseException;

/* loaded from: classes.dex */
public class PUserDatabaseParser extends ParametersParser implements TokenTypes {
    public PUserDatabaseParser(String str) {
        super(str);
    }

    private void parseheader(PUserDatabase pUserDatabase) throws ParseException {
        StringBuilder sb = new StringBuilder();
        this.lexer.match(60);
        while (this.lexer.hasMoreChars()) {
            char nextChar = this.lexer.getNextChar();
            if (nextChar != '>' && nextChar != '\n') {
                sb.append(nextChar);
            }
        }
        pUserDatabase.setDatabaseName(sb.toString());
        super.parse(pUserDatabase);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("PUserDatabase.parse");
        }
        try {
            this.lexer.match(TokenTypes.P_USER_DATABASE);
            this.lexer.SPorHT();
            this.lexer.match(58);
            this.lexer.SPorHT();
            PUserDatabase pUserDatabase = new PUserDatabase();
            parseheader(pUserDatabase);
            if (z) {
                dbg_leave("PUserDatabase.parse");
            }
            return pUserDatabase;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("PUserDatabase.parse");
            }
            throw th;
        }
    }

    public PUserDatabaseParser(Lexer lexer) {
        super(lexer);
    }
}
