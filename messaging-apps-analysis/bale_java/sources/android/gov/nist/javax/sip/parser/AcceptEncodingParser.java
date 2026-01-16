package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.ParserCore;
import android.gov.nist.core.Token;
import android.gov.nist.javax.sip.header.AcceptEncoding;
import android.gov.nist.javax.sip.header.AcceptEncodingList;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class AcceptEncodingParser extends HeaderParser {
    public AcceptEncodingParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        AcceptEncodingList acceptEncodingList = new AcceptEncodingList();
        if (ParserCore.debug) {
            dbg_enter("AcceptEncodingParser.parse");
        }
        try {
            headerName(TokenTypes.ACCEPT_ENCODING);
            if (this.lexer.startsId()) {
                while (true) {
                    AcceptEncoding acceptEncoding = new AcceptEncoding();
                    if (this.lexer.startsId()) {
                        acceptEncoding.setEncoding(this.lexer.match(4095).getTokenValue());
                        while (this.lexer.lookAhead(0) == ';') {
                            this.lexer.match(59);
                            this.lexer.SPorHT();
                            Token tokenMatch = this.lexer.match(4095);
                            this.lexer.SPorHT();
                            if (this.lexer.lookAhead() == '=') {
                                this.lexer.match(61);
                                this.lexer.SPorHT();
                                Token tokenMatch2 = this.lexer.match(4095);
                                if (tokenMatch.getTokenValue().equalsIgnoreCase("q")) {
                                    try {
                                        acceptEncoding.setQValue(Float.parseFloat(tokenMatch2.getTokenValue()));
                                    } catch (InvalidArgumentException e) {
                                        throw createParseException(e.getMessage());
                                    } catch (NumberFormatException e2) {
                                        throw createParseException(e2.getMessage());
                                    }
                                } else {
                                    acceptEncoding.setParameter(tokenMatch.getTokenValue(), tokenMatch2.getTokenValue());
                                }
                                this.lexer.SPorHT();
                            } else {
                                acceptEncoding.setParameter(tokenMatch.getTokenValue(), "");
                            }
                        }
                    }
                    acceptEncodingList.add((AcceptEncodingList) acceptEncoding);
                    if (this.lexer.lookAhead(0) != ',') {
                        break;
                    }
                    this.lexer.match(44);
                    this.lexer.SPorHT();
                }
            } else {
                acceptEncodingList.add((AcceptEncodingList) new AcceptEncoding());
            }
            if (ParserCore.debug) {
                dbg_leave("AcceptEncodingParser.parse");
            }
            return acceptEncodingList;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("AcceptEncodingParser.parse");
            }
            throw th;
        }
    }

    protected AcceptEncodingParser(Lexer lexer) {
        super(lexer);
    }
}
