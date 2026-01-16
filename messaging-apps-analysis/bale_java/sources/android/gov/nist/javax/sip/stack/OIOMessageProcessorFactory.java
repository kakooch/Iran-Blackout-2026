package android.gov.nist.javax.sip.stack;

import java.net.InetAddress;

/* loaded from: classes.dex */
public class OIOMessageProcessorFactory implements MessageProcessorFactory {
    @Override // android.gov.nist.javax.sip.stack.MessageProcessorFactory
    public MessageProcessor createMessageProcessor(SIPTransactionStack sIPTransactionStack, InetAddress inetAddress, int i, String str) {
        if (str.equalsIgnoreCase("UDP")) {
            UDPMessageProcessor uDPMessageProcessor = new UDPMessageProcessor(inetAddress, sIPTransactionStack, i);
            sIPTransactionStack.udpFlag = true;
            return uDPMessageProcessor;
        }
        if (str.equalsIgnoreCase("TCP")) {
            return new TCPMessageProcessor(inetAddress, sIPTransactionStack, i);
        }
        if (str.equalsIgnoreCase("TLS")) {
            return new TLSMessageProcessor(inetAddress, sIPTransactionStack, i);
        }
        if (!str.equalsIgnoreCase("SCTP")) {
            throw new IllegalArgumentException("bad transport");
        }
        try {
            MessageProcessor messageProcessor = (MessageProcessor) ClassLoader.getSystemClassLoader().loadClass("android.gov.nist.javax.sip.stack.sctp.SCTPMessageProcessor").newInstance();
            messageProcessor.initialize(inetAddress, i, sIPTransactionStack);
            return messageProcessor;
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("SCTP not supported (needs Java 7 and SCTP jar in classpath)");
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Error initializing SCTP", e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("Error initializing SCTP", e2);
        }
    }
}
