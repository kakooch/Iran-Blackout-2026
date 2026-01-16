package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Separators;
import android.gov.nist.core.Token;
import android.gov.nist.javax.sip.header.InReplyTo;
import android.gov.nist.javax.sip.header.InReplyToList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes.dex */
public class InReplyToParser extends HeaderParser {
    public InReplyToParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("InReplyToParser.parse");
        }
        InReplyToList inReplyToList = new InReplyToList();
        try {
            headerName(TokenTypes.IN_REPLY_TO);
            while (this.lexer.lookAhead(0) != '\n') {
                InReplyTo inReplyTo = new InReplyTo();
                inReplyTo.setHeaderName(SIPHeaderNames.IN_REPLY_TO);
                this.lexer.match(4095);
                Token nextToken = this.lexer.getNextToken();
                if (this.lexer.lookAhead(0) == '@') {
                    this.lexer.match(64);
                    this.lexer.match(4094);
                    inReplyTo.setCallId(nextToken.getTokenValue() + Separators.AT + this.lexer.getNextToken().getTokenValue());
                } else {
                    inReplyTo.setCallId(nextToken.getTokenValue());
                }
                this.lexer.SPorHT();
                inReplyToList.add((InReplyToList) inReplyTo);
                while (this.lexer.lookAhead(0) == ',') {
                    this.lexer.match(44);
                    this.lexer.SPorHT();
                    InReplyTo inReplyTo2 = new InReplyTo();
                    this.lexer.match(4095);
                    Token nextToken2 = this.lexer.getNextToken();
                    if (this.lexer.lookAhead(0) == '@') {
                        this.lexer.match(64);
                        this.lexer.match(4094);
                        inReplyTo2.setCallId(nextToken2.getTokenValue() + Separators.AT + this.lexer.getNextToken().getTokenValue());
                    } else {
                        inReplyTo2.setCallId(nextToken2.getTokenValue());
                    }
                    inReplyToList.add((InReplyToList) inReplyTo2);
                }
            }
            if (ParserCore.debug) {
                dbg_leave("InReplyToParser.parse");
            }
            return inReplyToList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("InReplyToParser.parse");
            }
            throw th;
        }
    }

    protected InReplyToParser(Lexer lexer) {
        super(lexer);
    }
}
