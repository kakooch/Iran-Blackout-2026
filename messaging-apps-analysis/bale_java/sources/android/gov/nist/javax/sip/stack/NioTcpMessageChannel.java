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
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.parser.NioPipelineParser;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.NioTcpMessageProcessor;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.ParseException;
import java.util.Queue;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
public class NioTcpMessageChannel extends ConnectionOrientedMessageChannel {
    private static final int BUF_SIZE = 4096;
    private static StackLogger logger = CommonLogger.getLogger(NioTcpMessageChannel.class);
    private final ByteBuffer byteBuffer;
    protected long lastActivityTimeStamp;
    NioPipelineParser nioParser;
    protected SocketChannel socketChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected NioTcpMessageChannel(NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) {
        super(nioTcpMessageProcessor.getSIPStack());
        this.nioParser = null;
        this.byteBuffer = ByteBuffer.allocateDirect(4096);
        this.myClientInputStream = socketChannel.socket().getInputStream();
        try {
            this.peerAddress = socketChannel.socket().getInetAddress();
            this.peerPort = socketChannel.socket().getPort();
            this.socketChannel = socketChannel;
            this.mySock = socketChannel.socket();
            SIPTransactionStack sIPTransactionStack = this.sipStack;
            this.nioParser = new NioPipelineParser(sIPTransactionStack, this, sIPTransactionStack.getMaxMessageSize());
            this.peerProtocol = nioTcpMessageProcessor.transport;
            this.lastActivityTimeStamp = System.currentTimeMillis();
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, nioTcpMessageProcessor.transport);
            this.myAddress = nioTcpMessageProcessor.getIpAddress().getHostAddress();
            this.myPort = nioTcpMessageProcessor.getPort();
        } finally {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Done creating NioTcpMessageChannel " + this + " socketChannel = " + socketChannel);
            }
        }
    }

    protected void addBytes(byte[] bArr) {
        this.nioParser.addBytes(bArr);
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    protected void close(boolean z, boolean z2) throws Throwable {
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing NioTcpMessageChannel " + this + " socketChannel = " + this.socketChannel);
            }
            ((NioTcpMessageProcessor) this.messageProcessor).nioHandler.removeMessageChannel(this.socketChannel);
            SocketChannel socketChannel = this.socketChannel;
            if (socketChannel != null) {
                socketChannel.close();
            }
            NioPipelineParser nioPipelineParser = this.nioParser;
            if (nioPipelineParser != null) {
                nioPipelineParser.close();
            }
            this.isRunning = false;
            if (z) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Removing NioTcpMessageChannel " + this + " socketChannel = " + this.socketChannel);
                }
                ((NioTcpMessageProcessor) this.messageProcessor).nioHandler.removeSocket(this.socketChannel);
                ((ConnectionOrientedMessageProcessor) this.messageProcessor).remove(this);
            }
            if (z2) {
                cancelPingKeepAliveTimeoutTaskIfStarted();
            }
        } catch (IOException e) {
            logger.logError("Problem occured while closing", e);
        }
    }

    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.socketChannel == ((NioTcpMessageChannel) obj).socketChannel;
    }

    public long getLastActivityTimestamp() {
        return this.lastActivityTimeStamp;
    }

    public SocketChannel getSocketChannel() {
        return this.socketChannel;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getTransport() {
        return this.messageProcessor.transport;
    }

    @Override // android.gov.nist.javax.sip.parser.ParseExceptionListener
    public void handleException(ParseException parseException, SIPMessage sIPMessage, Class cls, String str, String str2) throws IOException, ParseException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Parsing Exception: ", parseException);
        }
        if (cls == null || !(cls.equals(From.class) || cls.equals(To.class) || cls.equals(CSeq.class) || cls.equals(Via.class) || cls.equals(CallID.class) || cls.equals(ContentLength.class) || cls.equals(RequestLine.class) || cls.equals(StatusLine.class))) {
            sIPMessage.addUnparsed(str);
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Encountered Bad Message \n" + sIPMessage.toString());
        }
        String string = sIPMessage.toString();
        if (string.startsWith("SIP/") || string.startsWith("ACK ") || this.socketChannel == null) {
            throw parseException;
        }
        if (logger.isLoggingEnabled(4)) {
            logger.logError("Malformed mandatory headers: closing socket! :" + this.socketChannel.toString());
        }
        try {
            this.socketChannel.close();
            throw parseException;
        } catch (IOException e) {
            if (!logger.isLoggingEnabled(4)) {
                throw parseException;
            }
            logger.logError("Exception while closing socket! :" + this.socketChannel.toString() + ":" + e.toString());
            throw parseException;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isSecure() {
        return false;
    }

    public void onNewSocket(byte[] bArr) {
    }

    public void readChannel() throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("NioTcpMessageChannel::readChannel");
        }
        this.isRunning = true;
        try {
            int i = this.socketChannel.read(this.byteBuffer);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Read " + i + " from socketChannel");
            }
            if (i == -1) {
                throw new IOException("End-of-stream read (-1). This is usually an indication we are stuck and it is better to disconnect.");
            }
            if (i == 0) {
                throw new IOException("The socket is giving us empty TCP packets. This is usually an indication we are stuck and it is better to disconnect.");
            }
            this.byteBuffer.flip();
            byte[] bArr = new byte[this.byteBuffer.remaining()];
            this.byteBuffer.get(bArr);
            this.byteBuffer.clear();
            addBytes(bArr);
            this.lastActivityTimeStamp = System.currentTimeMillis();
        } catch (Exception e) {
            if ((e instanceof IOException) && !(e instanceof SSLException)) {
                try {
                    this.nioParser.addBytes("\r\n\r\n".getBytes("UTF-8"));
                } catch (Exception unused) {
                }
            }
            try {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("I/O Issue closing sock " + e.getMessage() + "myAddress:myport " + this.myAddress + ":" + this.myPort + ", remoteAddress:remotePort " + this.peerAddress + ":" + this.peerPort);
                    logger.logStackTrace();
                }
                close(true, false);
            } catch (Exception e2) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Issue closing the socket " + e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    public void sendMessage(byte[] bArr, boolean z) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendMessage isClient  = " + z + " this = " + this);
        }
        this.lastActivityTimeStamp = System.currentTimeMillis();
        NIOHandler nIOHandler = ((NioTcpMessageProcessor) this.messageProcessor).nioHandler;
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel != null && socketChannel.isConnected() && this.socketChannel.isOpen()) {
            nIOHandler.putSocket(NIOHandler.makeKey(this.peerAddress, this.peerPort), this.socketChannel);
        }
        sendTCPMessage(bArr, this.peerAddress, this.peerPort, z);
    }

    public void sendTCPMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws Throwable {
        if (bArr == null || inetAddress == null) {
            logger.logError("receiverAddress = " + inetAddress);
            throw new IllegalArgumentException("Null argument");
        }
        this.lastActivityTimeStamp = System.currentTimeMillis();
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
        MessageProcessor messageProcessor = this.messageProcessor;
        NIOHandler nIOHandler = ((NioTcpMessageProcessor) messageProcessor).nioHandler;
        SocketChannel socketChannelSendBytes = nIOHandler.sendBytes(messageProcessor.getIpAddress(), inetAddress, i, this.messageProcessor.transport, bArr, z, this);
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannelSendBytes == socketChannel || socketChannelSendBytes == null) {
            return;
        }
        if (socketChannel != null) {
            if (logger.isLoggingEnabled(8)) {
                logger.logWarning("[2] Old socket different than new socket on channel " + this.key + this.socketChannel + Separators.SP + socketChannelSendBytes);
                logger.logStackTrace();
                StackLogger stackLogger = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Old socket local ip address ");
                sb.append(this.socketChannel.socket().getLocalSocketAddress());
                stackLogger.logWarning(sb.toString());
                logger.logWarning("Old socket remote ip address " + this.socketChannel.socket().getRemoteSocketAddress());
                logger.logWarning("New socket local ip address " + socketChannelSendBytes.socket().getLocalSocketAddress());
                logger.logWarning("New socket remote ip address " + socketChannelSendBytes.socket().getRemoteSocketAddress());
            }
            close(false, false);
            this.socketChannel = socketChannelSendBytes;
            nIOHandler.putMessageChannel(socketChannelSendBytes, this);
            onNewSocket(bArr);
        }
        if (this.socketChannel != null && logger.isLoggingEnabled(8)) {
            logger.logWarning("There was no exception for the retry mechanism so we keep going " + this.key);
        }
        this.socketChannel = socketChannelSendBytes;
    }

    public synchronized void triggerConnectFailure(Queue<NioTcpMessageProcessor.PendingData> queue) {
        while (queue != null) {
            if (queue.peek() == null) {
                break;
            }
            SIPTransaction sIPTransactionFindTransaction = this.sipStack.findTransaction(queue.poll().txId, false);
            if (sIPTransactionFindTransaction != null) {
                if (!(sIPTransactionFindTransaction instanceof SIPClientTransaction)) {
                    sIPTransactionFindTransaction.raiseIOExceptionEvent();
                } else if (sIPTransactionFindTransaction.getRequest() != null && !sIPTransactionFindTransaction.getRequest().getMethod().equalsIgnoreCase(TokenNames.ACK)) {
                    try {
                        processMessage(((SIPRequest) sIPTransactionFindTransaction.getRequest()).createResponse(503, "Transport error sending request."));
                    } catch (Exception e) {
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("failed to report transport error", e);
                        }
                    }
                }
            }
        }
        close();
    }

    public void triggerConnectSuccess() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Connection Success. Nothing else to do.");
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws Throwable {
        sendTCPMessage(bArr, inetAddress, i, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NioTcpMessageChannel(InetAddress inetAddress, int i, SIPTransactionStack sIPTransactionStack, NioTcpMessageProcessor nioTcpMessageProcessor) {
        super(sIPTransactionStack);
        this.nioParser = null;
        this.byteBuffer = ByteBuffer.allocateDirect(4096);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("NioTcpMessageChannel::NioTcpMessageChannel: " + inetAddress.getHostAddress() + ":" + i);
        }
        try {
            this.messageProcessor = nioTcpMessageProcessor;
            SocketChannel socketChannelCreateOrReuseSocket = nioTcpMessageProcessor.nioHandler.createOrReuseSocket(inetAddress, i);
            this.socketChannel = socketChannelCreateOrReuseSocket;
            this.peerAddress = socketChannelCreateOrReuseSocket.socket().getInetAddress();
            this.peerPort = this.socketChannel.socket().getPort();
            this.mySock = this.socketChannel.socket();
            this.peerProtocol = getTransport();
            this.nioParser = new NioPipelineParser(sIPTransactionStack, this, this.sipStack.getMaxMessageSize());
            nioTcpMessageProcessor.nioHandler.putMessageChannel(this.socketChannel, this);
            this.lastActivityTimeStamp = System.currentTimeMillis();
            this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, getTransport());
            this.myAddress = nioTcpMessageProcessor.getIpAddress().getHostAddress();
            this.myPort = nioTcpMessageProcessor.getPort();
        } finally {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("NioTcpMessageChannel::NioTcpMessageChannel: Done creating NioTcpMessageChannel " + this + " socketChannel = " + this.socketChannel);
            }
        }
    }
}
