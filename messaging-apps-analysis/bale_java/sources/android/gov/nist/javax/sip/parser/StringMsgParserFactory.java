package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;

/* loaded from: classes.dex */
public class StringMsgParserFactory implements MessageParserFactory {
    private static StringMsgParser msgParser = new StringMsgParser();

    @Override // android.gov.nist.javax.sip.parser.MessageParserFactory
    public MessageParser createMessageParser(SIPTransactionStack sIPTransactionStack) {
        return msgParser;
    }
}
