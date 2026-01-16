package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.ErrorInfo;
import android.gov.nist.javax.sip.header.ErrorInfoList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class ErrorInfoParser extends ParametersParser {
    public ErrorInfoParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("ErrorInfoParser.parse");
        }
        ErrorInfoList errorInfoList = new ErrorInfoList();
        try {
            headerName(TokenTypes.ERROR_INFO);
            while (this.lexer.lookAhead(0) != '\n') {
                while (true) {
                    ErrorInfo errorInfo = new ErrorInfo();
                    errorInfo.setHeaderName(SIPHeaderNames.ERROR_INFO);
                    this.lexer.SPorHT();
                    this.lexer.match(60);
                    errorInfo.setErrorInfo(new URLParser((Lexer) this.lexer).uriReference(true));
                    this.lexer.match(62);
                    this.lexer.SPorHT();
                    super.parse(errorInfo);
                    errorInfoList.add((ErrorInfoList) errorInfo);
                    if (this.lexer.lookAhead(0) == ',') {
                        this.lexer.match(44);
                    }
                }
            }
            return errorInfoList;
        } finally {
            if (ParserCore.debug) {
                dbg_leave("ErrorInfoParser.parse");
            }
        }
    }

    protected ErrorInfoParser(Lexer lexer) {
        super(lexer);
    }
}
