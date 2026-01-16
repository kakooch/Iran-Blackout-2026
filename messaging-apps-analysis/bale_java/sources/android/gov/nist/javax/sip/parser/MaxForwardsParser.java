package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.MaxForwards;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class MaxForwardsParser extends HeaderParser {
    public MaxForwardsParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        boolean z = ParserCore.debug;
        if (z) {
            dbg_enter("MaxForwardsParser.enter");
        }
        try {
            try {
                MaxForwards maxForwards = new MaxForwards();
                headerName(TokenTypes.MAX_FORWARDS);
                maxForwards.setMaxForwards(Integer.parseInt(this.lexer.number()));
                this.lexer.SPorHT();
                this.lexer.match(10);
                if (z) {
                    dbg_leave("MaxForwardsParser.leave");
                }
                return maxForwards;
            } catch (InvalidArgumentException e) {
                throw createParseException(e.getMessage());
            } catch (NumberFormatException e2) {
                throw createParseException(e2.getMessage());
            }
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("MaxForwardsParser.leave");
            }
            throw th;
        }
    }

    protected MaxForwardsParser(Lexer lexer) {
        super(lexer);
    }
}
