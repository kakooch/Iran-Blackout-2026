package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;

/* loaded from: classes.dex */
public interface MessageParserFactory {
    MessageParser createMessageParser(SIPTransactionStack sIPTransactionStack);
}
