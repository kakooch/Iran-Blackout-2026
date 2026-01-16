package android.gov.nist.javax.sip.stack;

import java.net.InetAddress;

/* loaded from: classes.dex */
public interface MessageProcessorFactory {
    MessageProcessor createMessageProcessor(SIPTransactionStack sIPTransactionStack, InetAddress inetAddress, int i, String str);
}
