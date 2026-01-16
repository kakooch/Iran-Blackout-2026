package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.security.cert.Certificate;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

/* loaded from: classes.dex */
public class HandshakeCompletedListenerImpl implements HandshakeCompletedListener {
    private static StackLogger logger = CommonLogger.getLogger(HandshakeCompletedListenerImpl.class);
    private String cipherSuite;
    private final Object eventWaitObject = new Object();
    private HandshakeCompletedEvent handshakeCompletedEvent;
    private Certificate[] localCertificates;
    private Certificate[] peerCertificates;
    private SIPTransactionStack sipStack;
    private HandshakeWatchdog watchdog;

    class HandshakeWatchdog extends SIPStackTimerTask {
        Socket socket;

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return null;
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() throws IOException {
            HandshakeCompletedListenerImpl.logger.logInfo("closing socket " + this.socket + " on sslhandshaketimeout");
            try {
                this.socket.close();
            } catch (IOException unused) {
                HandshakeCompletedListenerImpl.logger.logInfo("couldn't close socket on sslhandshaketimeout");
            }
            HandshakeCompletedListenerImpl.logger.logInfo("socket closed " + this.socket + " on sslhandshaketimeout");
        }

        private HandshakeWatchdog(Socket socket) {
            this.socket = socket;
        }
    }

    public HandshakeCompletedListenerImpl(TLSMessageChannel tLSMessageChannel, Socket socket) {
        tLSMessageChannel.setHandshakeCompletedListener(this);
        SIPTransactionStack sIPStack = tLSMessageChannel.getSIPStack();
        this.sipStack = sIPStack;
        if (sIPStack.getSslHandshakeTimeout() > 0) {
            this.watchdog = new HandshakeWatchdog(socket);
        }
    }

    public String getCipherSuite() {
        return this.cipherSuite;
    }

    public HandshakeCompletedEvent getHandshakeCompletedEvent() {
        try {
            synchronized (this.eventWaitObject) {
                try {
                    if (this.handshakeCompletedEvent == null) {
                        this.eventWaitObject.wait(5000L);
                    }
                } finally {
                }
            }
        } catch (InterruptedException unused) {
        }
        return this.handshakeCompletedEvent;
    }

    public Certificate[] getLocalCertificates() {
        return this.localCertificates;
    }

    public Certificate[] getPeerCertificates() {
        return this.peerCertificates;
    }

    @Override // javax.net.ssl.HandshakeCompletedListener
    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        if (this.watchdog != null) {
            this.sipStack.getTimer().cancel(this.watchdog);
            this.watchdog = null;
        }
        this.handshakeCompletedEvent = handshakeCompletedEvent;
        synchronized (this.eventWaitObject) {
            this.eventWaitObject.notify();
        }
    }

    public void setCipherSuite(String str) {
        this.cipherSuite = str;
    }

    public void setLocalCertificates(Certificate[] certificateArr) {
        this.localCertificates = certificateArr;
    }

    public void setPeerCertificates(Certificate[] certificateArr) {
        this.peerCertificates = certificateArr;
    }

    public void startHandshakeWatchdog() {
        if (this.watchdog != null) {
            logger.logInfo("starting watchdog for socket " + this.watchdog.socket + " on sslhandshake " + this.sipStack.getSslHandshakeTimeout());
            this.sipStack.getTimer().schedule(this.watchdog, this.sipStack.getSslHandshakeTimeout());
        }
    }

    public HandshakeCompletedListenerImpl(NioTlsMessageChannel nioTlsMessageChannel, SocketChannel socketChannel) {
        nioTlsMessageChannel.setHandshakeCompletedListener(this);
        SipStackImpl sIPStack = nioTlsMessageChannel.getSIPStack();
        this.sipStack = sIPStack;
        if (sIPStack.getSslHandshakeTimeout() > 0) {
            this.watchdog = new HandshakeWatchdog(socketChannel.socket());
        }
    }
}
