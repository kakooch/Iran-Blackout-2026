package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.ListeningPointExt;
import java.net.InetAddress;
import java.nio.channels.SocketChannel;

/* loaded from: classes.dex */
public class NioWebSocketMessageProcessor extends NioTcpMessageProcessor {
    private static StackLogger logger = CommonLogger.getLogger(NioWebSocketMessageProcessor.class);

    public NioWebSocketMessageProcessor(InetAddress inetAddress, SIPTransactionStack sIPTransactionStack, int i) {
        super(inetAddress, sIPTransactionStack, i);
        this.transport = ListeningPointExt.WS;
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageProcessor
    ConnectionOrientedMessageChannel constructMessageChannel(InetAddress inetAddress, int i) {
        return new NioWebSocketMessageChannel(inetAddress, i, this.sipStack, this);
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageProcessor
    public NioTcpMessageChannel createMessageChannel(NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) {
        NioWebSocketMessageChannel nioWebSocketMessageChannel = (NioWebSocketMessageChannel) this.nioHandler.getMessageChannel(socketChannel);
        if (nioWebSocketMessageChannel != null) {
            return nioWebSocketMessageChannel;
        }
        NioWebSocketMessageChannel nioWebSocketMessageChannel2 = new NioWebSocketMessageChannel(this.sipStack, nioTcpMessageProcessor, socketChannel);
        this.nioHandler.putMessageChannel(socketChannel, nioWebSocketMessageChannel2);
        return nioWebSocketMessageChannel2;
    }
}
