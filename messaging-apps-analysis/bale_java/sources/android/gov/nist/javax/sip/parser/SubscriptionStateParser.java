package android.gov.nist.javax.sip.parser;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.ParserCore;
import android.gov.nist.javax.sip.header.SIPHeader;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.SubscriptionState;
import android.javax.sip.InvalidArgumentException;

/* loaded from: classes.dex */
public class SubscriptionStateParser extends HeaderParser {
    public SubscriptionStateParser(String str) {
        super(str);
    }

    @Override // android.gov.nist.javax.sip.parser.HeaderParser
    public SIPHeader parse() {
        if (ParserCore.debug) {
            dbg_enter("SubscriptionStateParser.parse");
        }
        SubscriptionState subscriptionState = new SubscriptionState();
        try {
            headerName(TokenTypes.SUBSCRIPTION_STATE);
            subscriptionState.setHeaderName(SIPHeaderNames.SUBSCRIPTION_STATE);
            this.lexer.match(4095);
            subscriptionState.setState(this.lexer.getNextToken().getTokenValue());
            while (this.lexer.lookAhead(0) == ';') {
                this.lexer.match(59);
                this.lexer.SPorHT();
                NameValue nameValue = nameValue('=');
                if (nameValue.getName().equalsIgnoreCase("reason")) {
                    subscriptionState.setReasonCode(nameValue.getValue());
                } else if (nameValue.getName().equalsIgnoreCase("expires")) {
                    try {
                        subscriptionState.setExpires(Integer.parseInt(nameValue.getValue()));
                    } catch (InvalidArgumentException e) {
                        throw createParseException(e.getMessage());
                    } catch (NumberFormatException e2) {
                        throw createParseException(e2.getMessage());
                    }
                } else if (nameValue.getName().equalsIgnoreCase("retry-after")) {
                    try {
                        subscriptionState.setRetryAfter(Integer.parseInt(nameValue.getValue()));
                    } catch (InvalidArgumentException e3) {
                        throw createParseException(e3.getMessage());
                    } catch (NumberFormatException e4) {
                        throw createParseException(e4.getMessage());
                    }
                } else {
                    subscriptionState.setParameter(nameValue);
                }
                this.lexer.SPorHT();
            }
            if (ParserCore.debug) {
                dbg_leave("SubscriptionStateParser.parse");
            }
            return subscriptionState;
        } catch (Throwable th) {
            if (ParserCore.debug) {
                dbg_leave("SubscriptionStateParser.parse");
            }
            throw th;
        }
    }

    protected SubscriptionStateParser(Lexer lexer) {
        super(lexer);
    }
}
