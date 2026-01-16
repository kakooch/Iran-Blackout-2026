package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.Accept;
import android.gov.nist.javax.sip.header.AcceptList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class AcceptParser extends ParametersParser {
    public AcceptParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("AcceptParser.parse");
        }
        AcceptList acceptList = new AcceptList();
        try {
            headerName(2068);
            Accept accept = new Accept();
            accept.setHeaderName(SIPHeaderNames.ACCEPT);
            this.lexer.SPorHT();
            if (this.lexer.startsId()) {
                this.lexer.match(4095);
                accept.setContentType(this.lexer.getNextToken().getTokenValue());
                this.lexer.match(47);
                this.lexer.match(4095);
                accept.setContentSubType(this.lexer.getNextToken().getTokenValue());
                this.lexer.SPorHT();
                super.parse(accept);
            }
            acceptList.add((AcceptList) accept);
            while (this.lexer.lookAhead(0) == ',') {
                this.lexer.match(44);
                this.lexer.SPorHT();
                Accept accept2 = new Accept();
                if (this.lexer.startsId()) {
                    this.lexer.match(4095);
                    accept2.setContentType(this.lexer.getNextToken().getTokenValue());
                    this.lexer.match(47);
                    this.lexer.match(4095);
                    accept2.setContentSubType(this.lexer.getNextToken().getTokenValue());
                    this.lexer.SPorHT();
                    super.parse(accept2);
                }
                acceptList.add((AcceptList) accept2);
            }
            if (ParserCore.debug) {
                dbg_leave("AcceptParser.parse");
            }
            return acceptList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("AcceptParser.parse");
            }
            throw th;
        }
    }

    protected AcceptParser(Lexer lexer) {
        super(lexer);
    }
}
