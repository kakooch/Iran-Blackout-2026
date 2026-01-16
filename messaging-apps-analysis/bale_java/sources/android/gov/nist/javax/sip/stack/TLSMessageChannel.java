package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.ContentLength;
import android.gov.nist.javax.sip.header.From;
import android.gov.nist.javax.sip.header.RequestLine;
import android.gov.nist.javax.sip.header.StatusLine;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class TLSMessageChannel extends ConnectionOrientedMessageChannel {
    private static StackLogger logger = CommonLogger.getLogger(TLSMessageChannel.class);
    private boolean handshakeCompleted;
    private HandshakeCompletedListener handshakeCompletedListener;

    protected TLSMessageChannel(Socket socket, SIPTransactionStack sIPTransactionStack, TLSMessageProcessor tLSMessageProcessor, String str) {
        super(sIPTransactionStack);
        this.handshakeCompleted = false;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("creating new TLSMessageChannel (incoming)");
            logger.logStackTrace();
        }
        this.mySock = (SSLSocket) socket;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            if (sIPTransactionStack.getClientAuth() != ClientAuthType.Want && sIPTransactionStack.getClientAuth() != ClientAuthType.Disabled && sIPTransactionStack.getClientAuth() != ClientAuthType.DisabledAll) {
                sSLSocket.setNeedClientAuth(true);
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("SSLServerSocket need client auth " + sSLSocket.getNeedClientAuth());
            }
        }
        this.peerAddress = this.mySock.getInetAddress();
        this.myAddress = tLSMessageProcessor.getIpAddress().getHostAddress();
        this.myClientInputStream = this.mySock.getInputStream();
        Thread thread = new Thread(this);
        this.mythread = thread;
        thread.setDaemon(true);
        this.mythread.setName(str);
        this.myPort = tLSMessageProcessor.getPort();
        int port = this.mySock.getPort();
        this.peerPort = port;
        this.key = MessageChannel.getKey(this.peerAddress, port, "TLS");
        this.messageProcessor = tLSMessageProcessor;
        this.mythread.start();
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    public void close(boolean z, boolean z2) throws IOException {
        this.isRunning = false;
        if (this.mySock != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing socket " + this.key);
            }
            try {
                this.mySock.close();
            } catch (IOException e) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Error closing socket " + e);
                }
            }
        }
        if (this.myParser != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing my parser " + this.myParser);
            }
            this.myParser.close();
        }
        if (z) {
            String strSubstring = this.key.substring(4);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing TLS socket " + strSubstring);
            }
            this.sipStack.ioHandler.removeSocket(strSubstring);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing message Channel (key = " + this.key + Separators.RPAREN + this);
            }
        } else if (logger.isLoggingEnabled(32)) {
            String strSubstring2 = this.key.substring(4);
            logger.logDebug("not removing socket key from the cached map since it has already been updated by the iohandler.sendBytes " + strSubstring2);
        }
        if (z2) {
            cancelPingKeepAliveTimeoutTaskIfStarted();
        }
    }

    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.mySock == ((TLSMessageChannel) obj).mySock;
    }

    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        return (HandshakeCompletedListenerImpl) this.handshakeCompletedListener;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getTransport() {
        return "TLS";
    }

    @Override // android.gov.nist.javax.sip.parser.ParseExceptionListener
    public void handleException(ParseException parseException, SIPMessage sIPMessage, Class cls, String str, String str2) throws ParseException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Parsing Exception: ", parseException);
        }
        if (cls == null || !(cls.equals(From.class) || cls.equals(To.class) || cls.equals(CSeq.class) || cls.equals(Via.class) || cls.equals(CallID.class) || cls.equals(ContentLength.class) || cls.equals(RequestLine.class) || cls.equals(StatusLine.class))) {
            sIPMessage.addUnparsed(str);
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Encountered bad message \n" + str2);
        }
        String string = sIPMessage.toString();
        if (string.startsWith("SIP/") || string.startsWith("ACK ")) {
            throw parseException;
        }
        String strCreateBadReqRes = createBadReqRes(string, parseException);
        if (strCreateBadReqRes == null) {
            if (!logger.isLoggingEnabled(32)) {
                throw parseException;
            }
            logger.logDebug("Could not formulate automatic 400 Bad Request");
            throw parseException;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Sending automatic 400 Bad Request:");
            logger.logDebug(strCreateBadReqRes);
        }
        try {
            sendMessage(strCreateBadReqRes.getBytes(), getPeerInetAddress(), getPeerPort(), false);
            throw parseException;
        } catch (IOException e) {
            logger.logException(e);
            throw parseException;
        }
    }

    public boolean isHandshakeCompleted() {
        return this.handshakeCompleted;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isSecure() {
        return true;
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel, java.lang.Runnable
    public void run() throws IOException {
        Socket socket = this.mySock;
        if (socket != null && (socket instanceof SSLSocket) && !this.handshakeCompleted) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            HandshakeCompletedListenerImpl handshakeCompletedListenerImpl = new HandshakeCompletedListenerImpl(this, sSLSocket);
            this.handshakeCompletedListener = handshakeCompletedListenerImpl;
            sSLSocket.addHandshakeCompletedListener(handshakeCompletedListenerImpl);
            handshakeCompletedListenerImpl.startHandshakeWatchdog();
            try {
                sSLSocket.startHandshake();
                this.handshakeCompleted = true;
                if (!getSIPStack().isSslRenegotiationEnabled()) {
                    sSLSocket.getSession().invalidate();
                    sSLSocket.setEnableSessionCreation(false);
                }
            } catch (IOException e) {
                logger.logError("A problem occured while Accepting connection", e);
                sSLSocket.removeHandshakeCompletedListener(this.handshakeCompletedListener);
                this.handshakeCompletedListener = null;
                try {
                    this.myClientInputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.myClientInputStream = null;
                    throw th;
                }
                this.myClientInputStream = null;
                try {
                    this.mySock.close();
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    this.mySock = null;
                    throw th2;
                }
                this.mySock = null;
                return;
            }
        }
        super.run();
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    protected synchronized void sendMessage(byte[] bArr, boolean z) throws IOException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendMessage isClient  = " + z);
        }
        Socket socketSendBytes = null;
        try {
            e = null;
            socketSendBytes = this.sipStack.ioHandler.sendBytes(getMessageProcessor().getIpAddress(), this.peerAddress, this.peerPort, this.peerProtocol, bArr, z, this);
        } catch (IOException e) {
            e = e;
            logger.logWarning("Failed to connect " + this.peerAddress + ":" + this.peerPort + " but trying the advertised port=" + this.peerPortAdvertisedInHeaders + " if it's different than the port we just failed on");
            logger.logError("Error is ", e);
        }
        if (socketSendBytes == null) {
            if (this.peerAddressAdvertisedInHeaders == null || this.peerPortAdvertisedInHeaders <= 0) {
                throw e;
            }
            logger.logWarning("Couldn't connect to peerAddress = " + this.peerAddress + " peerPort = " + this.peerPort + " key = " + this.key + " retrying on peerPortAdvertisedInHeaders " + this.peerPortAdvertisedInHeaders);
            InetAddress byName = InetAddress.getByName(this.peerAddressAdvertisedInHeaders);
            Socket socketSendBytes2 = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), byName, this.peerPortAdvertisedInHeaders, this.peerProtocol, bArr, z, this);
            int i = this.peerPortAdvertisedInHeaders;
            this.peerPort = i;
            this.peerAddress = byName;
            this.key = MessageChannel.getKey(byName, i, "TLS");
            logger.logWarning("retry suceeded to peerAddress = " + this.peerAddress + " peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " key = " + this.key);
            socketSendBytes = socketSendBytes2;
        }
        Socket socket = this.mySock;
        if (socketSendBytes != socket && socketSendBytes != null) {
            if (socket != null) {
                if (logger.isLoggingEnabled(8)) {
                    logger.logWarning("Old socket different than new socket on channel " + this.key);
                    logger.logStackTrace();
                    logger.logWarning("Old socket local ip address " + this.mySock.getLocalSocketAddress());
                    logger.logWarning("Old socket remote ip address " + this.mySock.getRemoteSocketAddress());
                    logger.logWarning("New socket local ip address " + socketSendBytes.getLocalSocketAddress());
                    logger.logWarning("New socket remote ip address " + socketSendBytes.getRemoteSocketAddress());
                }
                close(false, false);
            }
            if (e == null) {
                if (this.mySock != null && logger.isLoggingEnabled(8)) {
                    logger.logWarning("There was no exception for the retry mechanism so creating a new thread based on the new socket for incoming " + this.key);
                }
                this.mySock = socketSendBytes;
                this.myClientInputStream = socketSendBytes.getInputStream();
                Thread thread = new Thread(this);
                thread.setDaemon(true);
                thread.setName("TCPMessageChannelThread");
                thread.start();
            } else {
                if (logger.isLoggingEnabled(8)) {
                    logger.logWarning("There was an exception for the retry mechanism so not creating a new thread based on the new socket for incoming " + this.key);
                }
                this.mySock = socketSendBytes;
            }
        }
    }

    public void setHandshakeCompleted(boolean z) {
        this.handshakeCompleted = z;
    }

    public void setHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.handshakeCompletedListener = handshakeCompletedListener;
    }

    protected TLSMessageChannel(InetAddress inetAddress, int i, SIPTransactionStack sIPTransactionStack, TLSMessageProcessor tLSMessageProcessor) {
        super(sIPTransactionStack);
        this.handshakeCompleted = false;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("creating new TLSMessageChannel (outgoing)");
            logger.logStackTrace();
        }
        this.peerAddress = inetAddress;
        this.peerPort = i;
        this.myPort = tLSMessageProcessor.getPort();
        this.peerProtocol = "TLS";
        this.sipStack = sIPTransactionStack;
        this.myAddress = tLSMessageProcessor.getIpAddress().getHostAddress();
        this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TLS");
        this.messageProcessor = tLSMessageProcessor;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public synchronized void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws IOException {
        try {
            if (bArr != null && inetAddress != null) {
                if (this.peerPortAdvertisedInHeaders <= 0) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("receiver port = " + i + " for this channel " + this + " key " + this.key);
                    }
                    if (i <= 0) {
                        this.peerPortAdvertisedInHeaders = SIPConstants.DEFAULT_PORT;
                    } else {
                        this.peerPortAdvertisedInHeaders = i;
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("2.Storing peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " for this channel " + this + " key " + this.key);
                    }
                }
                Socket socketSendBytes = null;
                try {
                    e = null;
                    socketSendBytes = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), inetAddress, i, "TLS", bArr, z, this);
                } catch (IOException e) {
                    e = e;
                    logger.logWarning("Failed to connect " + this.peerAddress + ":" + i + " but trying the advertised port=" + this.peerPortAdvertisedInHeaders + " if it's different than the port we just failed on, rcv addr=" + inetAddress + ", port=" + i);
                    logger.logError("Error is ", e);
                }
                if (socketSendBytes == null) {
                    if (this.peerAddressAdvertisedInHeaders != null && this.peerPortAdvertisedInHeaders > 0) {
                        logger.logWarning("Couldn't connect to receiverAddress = " + inetAddress + " receiverPort = " + i + " key = " + this.key + " retrying on peerPortAdvertisedInHeaders " + this.peerPortAdvertisedInHeaders);
                        InetAddress byName = InetAddress.getByName(this.peerAddressAdvertisedInHeaders);
                        socketSendBytes = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), byName, this.peerPortAdvertisedInHeaders, "TLS", bArr, z, this);
                        int i2 = this.peerPortAdvertisedInHeaders;
                        this.peerPort = i2;
                        this.peerAddress = byName;
                        this.key = MessageChannel.getKey(byName, i2, "TLS");
                        logger.logWarning("retry suceeded to receiverAddress = " + inetAddress + " peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " key = " + this.key);
                    } else {
                        throw e;
                    }
                }
                Socket socket = this.mySock;
                if (socketSendBytes != socket && socketSendBytes != null) {
                    if (socket != null) {
                        if (logger.isLoggingEnabled(8)) {
                            logger.logWarning("Old socket different than new socket on channel " + this.key);
                            logger.logStackTrace();
                            logger.logWarning("Old socket local ip address " + this.mySock.getLocalSocketAddress());
                            logger.logWarning("Old socket remote ip address " + this.mySock.getRemoteSocketAddress());
                            logger.logWarning("New socket local ip address " + socketSendBytes.getLocalSocketAddress());
                            logger.logWarning("New socket remote ip address " + socketSendBytes.getRemoteSocketAddress());
                        }
                        close(false, false);
                    }
                    if (e == null) {
                        if (this.mySock != null && logger.isLoggingEnabled(8)) {
                            logger.logWarning("There was no exception for the retry mechanism so creating a new thread based on the new socket for incoming " + this.key);
                        }
                        this.mySock = socketSendBytes;
                        this.myClientInputStream = socketSendBytes.getInputStream();
                        Thread thread = new Thread(this);
                        thread.setDaemon(true);
                        thread.setName("TCPMessageChannelThread");
                        thread.start();
                    } else {
                        if (logger.isLoggingEnabled(8)) {
                            logger.logWarning("There was an exception for the retry mechanism so not creating a new thread based on the new socket for incoming " + this.key);
                        }
                        this.mySock = socketSendBytes;
                    }
                }
            } else {
                throw new IllegalArgumentException("Null argument");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
