package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.CallInfo;
import android.gov.nist.javax.sip.header.CallInfoList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class CallInfoParser extends ParametersParser {
    public CallInfoParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("CallInfoParser.parse");
        }
        CallInfoList callInfoList = new CallInfoList();
        try {
            headerName(TokenTypes.CALL_INFO);
            while (this.lexer.lookAhead(0) != '\n') {
                CallInfo callInfo = new CallInfo();
                callInfo.setHeaderName(SIPHeaderNames.CALL_INFO);
                this.lexer.SPorHT();
                this.lexer.match(60);
                callInfo.setInfo(new URLParser((Lexer) this.lexer).uriReference(true));
                this.lexer.match(62);
                this.lexer.SPorHT();
                super.parse(callInfo);
                callInfoList.add((CallInfoList) callInfo);
                while (this.lexer.lookAhead(0) == ',') {
                    this.lexer.match(44);
                    this.lexer.SPorHT();
                    CallInfo callInfo2 = new CallInfo();
                    this.lexer.SPorHT();
                    this.lexer.match(60);
                    callInfo2.setInfo(new URLParser((Lexer) this.lexer).uriReference(true));
                    this.lexer.match(62);
                    this.lexer.SPorHT();
                    super.parse(callInfo2);
                    callInfoList.add((CallInfoList) callInfo2);
                }
            }
            return callInfoList;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("CallInfoParser.parse");
            }
        }
    }

    protected CallInfoParser(Lexer lexer) {
        super(lexer);
    }
}
