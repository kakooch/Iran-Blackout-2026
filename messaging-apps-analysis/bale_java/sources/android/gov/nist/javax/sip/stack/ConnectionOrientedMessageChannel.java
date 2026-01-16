package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.IOExceptionEventExt;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.SipListenerExt;
import android.gov.nist.javax.sip.SipProviderImpl;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.ThreadAffinityTask;
import android.gov.nist.javax.sip.header.RetryAfter;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.header.ViaList;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.Pipeline;
import android.gov.nist.javax.sip.parser.PipelinedMsgParser;
import android.gov.nist.javax.sip.parser.SIPMessageListener;
import ir.nasim.FY2;
import ir.nasim.InterfaceC17579nC3;
import ir.nasim.KD6;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.ParseException;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/* loaded from: classes.dex */
public abstract class ConnectionOrientedMessageChannel extends MessageChannel implements SIPMessageListener, Runnable, RawMessageChannel {
    private static StackLogger logger = CommonLogger.getLogger(ConnectionOrientedMessageChannel.class);
    protected boolean isCached;
    private Semaphore keepAliveSemaphore;
    private long keepAliveTimeout;
    protected String key;
    private volatile long lastKeepAliveReceivedTime;
    protected String myAddress;
    protected InputStream myClientInputStream;
    protected PipelinedMsgParser myParser;
    protected int myPort;
    protected Socket mySock;
    protected Thread mythread;
    protected InetAddress peerAddress;
    protected String peerAddressAdvertisedInHeaders;
    protected int peerPort;
    protected String peerProtocol;
    private SIPStackTimerTask pingKeepAliveTimeoutTask;
    protected SIPTransactionStack sipStack;
    protected boolean isRunning = true;
    protected int peerPortAdvertisedInHeaders = -1;

    class KeepAliveTimeoutTimerTask extends SIPStackTimerTask {
        KeepAliveTimeoutTimerTask() {
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return null;
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            if (ConnectionOrientedMessageChannel.logger.isLoggingEnabled(32)) {
                ConnectionOrientedMessageChannel.logger.logDebug("~~~ Starting processing of KeepAliveTimeoutEvent( " + ConnectionOrientedMessageChannel.this.peerAddress.getHostAddress() + "," + ConnectionOrientedMessageChannel.this.peerPort + ")...");
            }
            ConnectionOrientedMessageChannel.this.close(true, true);
            SIPTransactionStack sIPTransactionStack = ConnectionOrientedMessageChannel.this.sipStack;
            if (!(sIPTransactionStack instanceof SipStackImpl)) {
                KD6 sipListener = sIPTransactionStack.getSipListener();
                if (sipListener instanceof SipListenerExt) {
                    SipListenerExt sipListenerExt = (SipListenerExt) sipListener;
                    IOExceptionEventExt.Reason reason = IOExceptionEventExt.Reason.KeepAliveTimeout;
                    ConnectionOrientedMessageChannel connectionOrientedMessageChannel = ConnectionOrientedMessageChannel.this;
                    String str = connectionOrientedMessageChannel.myAddress;
                    int i = connectionOrientedMessageChannel.myPort;
                    String hostAddress = connectionOrientedMessageChannel.peerAddress.getHostAddress();
                    ConnectionOrientedMessageChannel connectionOrientedMessageChannel2 = ConnectionOrientedMessageChannel.this;
                    sipListenerExt.processIOException(new IOExceptionEventExt(this, reason, str, i, hostAddress, connectionOrientedMessageChannel2.peerPort, connectionOrientedMessageChannel2.getTransport()));
                    return;
                }
                return;
            }
            Iterator<SipProviderImpl> sipProviders = ((SipStackImpl) sIPTransactionStack).getSipProviders();
            while (sipProviders.hasNext()) {
                SipProviderImpl next = sipProviders.next();
                KD6 sipListener2 = next.getSipListener();
                for (InterfaceC17579nC3 interfaceC17579nC3 : next.getListeningPoints()) {
                    if (sipListener2 != null && (sipListener2 instanceof SipListenerExt) && interfaceC17579nC3.getIPAddress().equalsIgnoreCase(ConnectionOrientedMessageChannel.this.myAddress) && interfaceC17579nC3.getPort() == ConnectionOrientedMessageChannel.this.myPort && interfaceC17579nC3.getTransport().equalsIgnoreCase(ConnectionOrientedMessageChannel.this.getTransport())) {
                        IOExceptionEventExt.Reason reason2 = IOExceptionEventExt.Reason.KeepAliveTimeout;
                        ConnectionOrientedMessageChannel connectionOrientedMessageChannel3 = ConnectionOrientedMessageChannel.this;
                        String str2 = connectionOrientedMessageChannel3.myAddress;
                        int i2 = connectionOrientedMessageChannel3.myPort;
                        String hostAddress2 = connectionOrientedMessageChannel3.peerAddress.getHostAddress();
                        ConnectionOrientedMessageChannel connectionOrientedMessageChannel4 = ConnectionOrientedMessageChannel.this;
                        ((SipListenerExt) sipListener2).processIOException(new IOExceptionEventExt(next, reason2, str2, i2, hostAddress2, connectionOrientedMessageChannel4.peerPort, connectionOrientedMessageChannel4.getTransport()));
                    }
                }
            }
        }
    }

    public ConnectionOrientedMessageChannel(SIPTransactionStack sIPTransactionStack) {
        this.sipStack = sIPTransactionStack;
        long reliableConnectionKeepAliveTimeout = sIPTransactionStack.getReliableConnectionKeepAliveTimeout();
        this.keepAliveTimeout = reliableConnectionKeepAliveTimeout;
        if (reliableConnectionKeepAliveTimeout > 0) {
            this.keepAliveSemaphore = new Semaphore(1);
        }
    }

    public void cancelPingKeepAliveTimeoutTaskIfStarted() {
        SIPStackTimerTask sIPStackTimerTask = this.pingKeepAliveTimeoutTask;
        if (sIPStackTimerTask == null || sIPStackTimerTask.getSipTimerTask() == null) {
            return;
        }
        try {
            this.keepAliveSemaphore.acquire();
            try {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("~~~ cancelPingKeepAliveTimeoutTaskIfStarted for MessageChannel(key=" + this.key + "), clientAddress=" + this.peerAddress + ", clientPort=" + this.peerPort + ", timeout=" + this.keepAliveTimeout + Separators.RPAREN);
                }
                this.sipStack.getTimer().cancel(this.pingKeepAliveTimeoutTask);
                this.keepAliveSemaphore.release();
            } catch (Throwable th) {
                this.keepAliveSemaphore.release();
                throw th;
            }
        } catch (InterruptedException unused) {
            logger.logError("Couldn't acquire keepAliveSemaphore");
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public void close() {
        close(true, true);
    }

    protected abstract void close(boolean z, boolean z2);

    public long getKeepAliveTimeout() {
        return this.keepAliveTimeout;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getKey() {
        String str = this.key;
        if (str != null) {
            return str;
        }
        String key = MessageChannel.getKey(this.peerAddress, this.peerPort, getTransport());
        this.key = key;
        return key;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getPeerAddress() {
        InetAddress inetAddress = this.peerAddress;
        return inetAddress != null ? inetAddress.getHostAddress() : getHost();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    protected InetAddress getPeerInetAddress() {
        return this.peerAddress;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public InetAddress getPeerPacketSourceAddress() {
        return this.peerAddress;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public int getPeerPacketSourcePort() {
        return this.peerPort;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public int getPeerPort() {
        return this.peerPort;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getPeerProtocol() {
        return this.peerProtocol;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public SIPTransactionStack getSIPStack() {
        return this.sipStack;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getViaHost() {
        return this.myAddress;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public int getViaPort() {
        return this.myPort;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isReliable() {
        return true;
    }

    public void processMessage(SIPMessage sIPMessage, InetAddress inetAddress) {
        this.peerAddress = inetAddress;
        try {
            processMessage(sIPMessage);
        } catch (Exception e) {
            if (logger.isLoggingEnabled(4)) {
                logger.logError("ERROR processing self routing", e);
            }
        }
    }

    public void rescheduleKeepAliveTimeout(long j) {
        StringBuilder sb = new StringBuilder();
        if (logger.isLoggingEnabled(32)) {
            sb.append("~~~ rescheduleKeepAliveTimeout for MessageChannel(key=" + this.key + "), clientAddress=" + this.peerAddress + ", clientPort=" + this.peerPort + ", timeout=" + this.keepAliveTimeout + "): newKeepAliveTimeout=");
            if (j == Long.MAX_VALUE) {
                sb.append("Long.MAX_VALUE");
            } else {
                sb.append(j);
            }
        }
        try {
            this.keepAliveSemaphore.acquire();
            try {
                if (this.pingKeepAliveTimeoutTask == null) {
                    this.pingKeepAliveTimeoutTask = new KeepAliveTimeoutTimerTask();
                    if (logger.isLoggingEnabled(32)) {
                        sb.append(", scheduling pingKeepAliveTimeoutTask to execute after ");
                        sb.append(this.keepAliveTimeout / 1000);
                        sb.append(" seconds");
                        logger.logDebug(sb.toString());
                    }
                    this.sipStack.getTimer().schedule(this.pingKeepAliveTimeoutTask, this.keepAliveTimeout);
                } else {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("~~~ cancelPingKeepAliveTimeout for MessageChannel(key=" + this.key + "), clientAddress=" + this.peerAddress + ", clientPort=" + this.peerPort + ", timeout=" + this.keepAliveTimeout + Separators.RPAREN);
                    }
                    this.sipStack.getTimer().cancel(this.pingKeepAliveTimeoutTask);
                    this.pingKeepAliveTimeoutTask = new KeepAliveTimeoutTimerTask();
                    if (logger.isLoggingEnabled(32)) {
                        sb.append(", scheduling pingKeepAliveTimeoutTask to execute after ");
                        sb.append(this.keepAliveTimeout / 1000);
                        sb.append(" seconds");
                        logger.logDebug(sb.toString());
                    }
                    this.sipStack.getTimer().schedule(this.pingKeepAliveTimeoutTask, this.keepAliveTimeout);
                }
                this.keepAliveSemaphore.release();
            } catch (Throwable th) {
                this.keepAliveSemaphore.release();
                throw th;
            }
        } catch (InterruptedException unused) {
            logger.logWarning("Couldn't acquire keepAliveSemaphore");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr;
        int i;
        InputStream inputStream = this.myClientInputStream;
        SIPTransactionStack sIPTransactionStack = this.sipStack;
        Pipeline pipeline = new Pipeline(inputStream, sIPTransactionStack.readTimeout, sIPTransactionStack.getTimer());
        SIPTransactionStack sIPTransactionStack2 = this.sipStack;
        PipelinedMsgParser pipelinedMsgParser = new PipelinedMsgParser(sIPTransactionStack2, this, pipeline, sIPTransactionStack2.getMaxMessageSize());
        this.myParser = pipelinedMsgParser;
        pipelinedMsgParser.processInput();
        ((ConnectionOrientedMessageProcessor) this.messageProcessor).useCount++;
        this.isRunning = true;
        while (true) {
            try {
                try {
                    try {
                        bArr = new byte[4096];
                        i = this.myClientInputStream.read(bArr, 0, 4096);
                    } catch (IOException e) {
                        try {
                            pipeline.write("\r\n\r\n".getBytes("UTF-8"));
                        } catch (Exception unused) {
                        }
                        try {
                            if (logger.isLoggingEnabled(32)) {
                                logger.logDebug("IO issue while closing socket " + e.getMessage());
                            }
                            if (this.sipStack.maxConnections != -1) {
                                synchronized (this.messageProcessor) {
                                    MessageProcessor messageProcessor = this.messageProcessor;
                                    ((ConnectionOrientedMessageProcessor) messageProcessor).nConnections--;
                                    messageProcessor.notify();
                                }
                            }
                            close();
                            pipeline.close();
                        } catch (IOException | Exception unused2) {
                        }
                        this.isRunning = false;
                        ((ConnectionOrientedMessageProcessor) this.messageProcessor).remove(this);
                        ((ConnectionOrientedMessageProcessor) this.messageProcessor).useCount--;
                        PipelinedMsgParser pipelinedMsgParser2 = this.myParser;
                        if (pipelinedMsgParser2 != null) {
                            pipelinedMsgParser2.close();
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    InternalErrorHandler.handleException(e2, logger);
                }
                if (i == -1) {
                    break;
                } else {
                    pipeline.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                this.isRunning = false;
                ((ConnectionOrientedMessageProcessor) this.messageProcessor).remove(this);
                ((ConnectionOrientedMessageProcessor) this.messageProcessor).useCount--;
                PipelinedMsgParser pipelinedMsgParser3 = this.myParser;
                if (pipelinedMsgParser3 != null) {
                    pipelinedMsgParser3.close();
                }
                throw th;
            }
        }
        pipeline.write("\r\n\r\n".getBytes("UTF-8"));
        try {
            if (this.sipStack.maxConnections != -1) {
                synchronized (this.messageProcessor) {
                    MessageProcessor messageProcessor2 = this.messageProcessor;
                    ((ConnectionOrientedMessageProcessor) messageProcessor2).nConnections--;
                    messageProcessor2.notify();
                }
            }
            pipeline.close();
            close();
        } catch (IOException unused3) {
        }
        this.isRunning = false;
        ((ConnectionOrientedMessageProcessor) this.messageProcessor).remove(this);
        ((ConnectionOrientedMessageProcessor) this.messageProcessor).useCount--;
        PipelinedMsgParser pipelinedMsgParser4 = this.myParser;
        if (pipelinedMsgParser4 != null) {
            pipelinedMsgParser4.close();
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public void sendMessage(final SIPMessage sIPMessage) throws UnsupportedEncodingException {
        if (logger.isLoggingEnabled(32) && !sIPMessage.isNullRequest()) {
            logger.logDebug("sendMessage:: " + sIPMessage.getFirstLine() + " cseq method = " + sIPMessage.getCSeq().getMethod());
        }
        for (MessageProcessor messageProcessor : getSIPStack().getMessageProcessors()) {
            if (messageProcessor.getIpAddress().getHostAddress().equals(getPeerAddress()) && messageProcessor.getPort() == getPeerPort() && messageProcessor.getTransport().equalsIgnoreCase(getPeerProtocol())) {
                getSIPStack().getSelfRoutingThreadpoolExecutor().execute(new ThreadAffinityTask() { // from class: android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel.1
                    @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                    public Object getThreadHash() {
                        return sIPMessage.getCallId().getCallId();
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ConnectionOrientedMessageChannel.this.processMessage((SIPMessage) sIPMessage.clone());
                        } catch (Exception e) {
                            if (ConnectionOrientedMessageChannel.logger.isLoggingEnabled(4)) {
                                ConnectionOrientedMessageChannel.logger.logError("Error self routing message cause by: ", e);
                            }
                        }
                    }
                });
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Self routing message");
                    return;
                }
                return;
            }
        }
        byte[] bArrEncodeAsBytes = sIPMessage.encodeAsBytes(getTransport());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.peerPortAdvertisedInHeaders <= 0 && (sIPMessage instanceof SIPResponse)) {
            Via topmostVia = ((SIPResponse) sIPMessage).getTopmostVia();
            if (topmostVia.getRPort() > 0) {
                if (topmostVia.getPort() <= 0) {
                    this.peerPortAdvertisedInHeaders = SIPConstants.DEFAULT_PORT;
                } else {
                    this.peerPortAdvertisedInHeaders = topmostVia.getPort();
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("1.Storing peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " for via port = " + topmostVia.getPort() + " via rport = " + topmostVia.getRPort() + " and peer port = " + this.peerPort + " for this channel " + this + " key " + this.key);
                }
            }
        }
        sendMessage(bArrEncodeAsBytes, sIPMessage instanceof SIPRequest);
        sIPMessage.setRemoteAddress(this.peerAddress);
        sIPMessage.setRemotePort(this.peerPort);
        sIPMessage.setLocalAddress(getMessageProcessor().getIpAddress());
        sIPMessage.setLocalPort(getPort());
        if (logger.isLoggingEnabled(16)) {
            logMessage(sIPMessage, this.peerAddress, this.peerPort, jCurrentTimeMillis);
        }
    }

    protected abstract void sendMessage(byte[] bArr, boolean z);

    @Override // android.gov.nist.javax.sip.parser.SIPMessageListener
    public void sendSingleCLRF() {
        this.lastKeepAliveReceivedTime = System.currentTimeMillis();
        Socket socket = this.mySock;
        if (socket != null && !socket.isClosed()) {
            sendMessage(Separators.NEWLINE.getBytes("UTF-8"), false);
        }
        synchronized (this) {
            try {
                if (this.isRunning) {
                    long j = this.keepAliveTimeout;
                    if (j > 0) {
                        rescheduleKeepAliveTimeout(j);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setKeepAliveTimeout(long j) {
        if (j < 0) {
            cancelPingKeepAliveTimeoutTaskIfStarted();
        }
        if (j == 0) {
            j = this.messageProcessor.getSIPStack().getReliableConnectionKeepAliveTimeout();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("~~~ setKeepAliveTimeout for MessageChannel(key=" + this.key + "), clientAddress=" + this.peerAddress + ", clientPort=" + this.peerPort + ", timeout=" + j + Separators.RPAREN);
        }
        this.keepAliveTimeout = j;
        if (this.keepAliveSemaphore == null) {
            this.keepAliveSemaphore = new Semaphore(1);
        }
        if (this.pingKeepAliveTimeoutTask == null || j <= 0) {
            return;
        }
        rescheduleKeepAliveTimeout(j);
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    protected void uncache() {
        if (!this.isCached || this.isRunning) {
            return;
        }
        ((ConnectionOrientedMessageProcessor) this.messageProcessor).remove(this);
    }

    @Override // android.gov.nist.javax.sip.parser.SIPMessageListener, android.gov.nist.javax.sip.stack.RawMessageChannel
    public void processMessage(SIPMessage sIPMessage) throws Exception {
        boolean z;
        boolean zPassToListener;
        boolean z2;
        boolean zPassToListener2;
        Socket socket;
        if (sIPMessage.getFrom() != null && sIPMessage.getTo() != null && sIPMessage.getCallId() != null && sIPMessage.getCSeq() != null && sIPMessage.getViaHeaders() != null) {
            sIPMessage.setRemoteAddress(this.peerAddress);
            sIPMessage.setRemotePort(getPeerPort());
            sIPMessage.setLocalAddress(getMessageProcessor().getIpAddress());
            sIPMessage.setLocalPort(getPort());
            sIPMessage.setPeerPacketSourceAddress(this.peerAddress);
            sIPMessage.setPeerPacketSourcePort(this.peerPort);
            ViaList viaHeaders = sIPMessage.getViaHeaders();
            if (sIPMessage instanceof SIPRequest) {
                Via via = (Via) viaHeaders.getFirst();
                FY2 fy2ResolveAddress = this.sipStack.addressResolver.resolveAddress(via.getHop());
                this.peerProtocol = via.getTransport();
                int port = via.getPort();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("hop port = " + port + " for request " + sIPMessage + " for this channel " + this + " key " + this.key);
                }
                if (port <= 0) {
                    this.peerPortAdvertisedInHeaders = SIPConstants.DEFAULT_PORT;
                } else {
                    this.peerPortAdvertisedInHeaders = port;
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("3.Storing peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " for this channel " + this + " key " + this.key);
                }
                if (this.peerAddressAdvertisedInHeaders == null) {
                    this.peerAddressAdvertisedInHeaders = fy2ResolveAddress.getHost();
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("3.Storing peerAddressAdvertisedInHeaders = " + this.peerAddressAdvertisedInHeaders + " for this channel " + this + " key " + this.key);
                    }
                }
                if (!this.sipStack.isPatchReceivedRport()) {
                    try {
                        try {
                            Socket socket2 = this.mySock;
                            if (socket2 != null) {
                                this.peerAddress = socket2.getInetAddress();
                            }
                            boolean zHasParameter = via.hasParameter("rport");
                            if (this.sipStack.isPatchRport() && !zHasParameter && via.getPort() != this.peerPort) {
                                if (logger.isLoggingEnabled(32)) {
                                    logger.logDebug("setting rport since viaPort " + via.getPort() + " different than peerPacketSourcePort " + this.peerPort + " so that the response can be routed back");
                                }
                                zHasParameter = true;
                            }
                            if (zHasParameter || !fy2ResolveAddress.getHost().equals(this.peerAddress.getHostAddress())) {
                                via.setParameter("received", this.peerAddress.getHostAddress());
                            }
                            via.setParameter("rport", Integer.toString(this.peerPort));
                        } finally {
                        }
                    } catch (ParseException e) {
                        InternalErrorHandler.handleException(e);
                    }
                } else if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("We did not use recived and rport");
                }
                if (!this.isCached && (socket = this.mySock) != null) {
                    this.isCached = true;
                    String strMakeKey = IOHandler.makeKey(this.mySock.getInetAddress(), ((InetSocketAddress) socket.getRemoteSocketAddress()).getPort());
                    MessageProcessor messageProcessor = this.messageProcessor;
                    if (messageProcessor instanceof NioTcpMessageProcessor) {
                        ((NioTcpMessageProcessor) messageProcessor).nioHandler.putSocket(strMakeKey, this.mySock.getChannel());
                    } else {
                        this.sipStack.ioHandler.putSocket(strMakeKey, this.mySock);
                    }
                    ((ConnectionOrientedMessageProcessor) this.messageProcessor).cacheMessageChannel(this);
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (sIPMessage instanceof SIPRequest) {
                SIPRequest sIPRequest = (SIPRequest) sIPMessage;
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("----Processing Message---");
                }
                if (logger.isLoggingEnabled(16)) {
                    this.sipStack.serverLogger.logMessage(sIPMessage, getPeerHostPort().toString(), this.messageProcessor.getIpAddress().getHostAddress() + ":" + this.messageProcessor.getPort(), false, jCurrentTimeMillis);
                }
                if (this.sipStack.getMaxMessageSize() > 0) {
                    if (sIPRequest.getSize() + (sIPRequest.getContentLength() == null ? 0 : sIPRequest.getContentLength().getContentLength()) > this.sipStack.getMaxMessageSize()) {
                        sendMessage(sIPRequest.createResponse(513).encodeAsBytes(getTransport()), false);
                        throw new Exception("Message size exceeded");
                    }
                }
                String sipVersion = ((SIPRequest) sIPMessage).getRequestLine().getSipVersion();
                if (sipVersion.equals(SIPConstants.SIP_VERSION_STRING)) {
                    String method = ((SIPRequest) sIPMessage).getMethod();
                    if (method.equalsIgnoreCase(((SIPRequest) sIPMessage).getCSeqHeader().getMethod())) {
                        ServerRequestInterface serverRequestInterfaceNewSIPServerRequest = this.sipStack.newSIPServerRequest(sIPRequest, this);
                        if (serverRequestInterfaceNewSIPServerRequest != null) {
                            try {
                                serverRequestInterfaceNewSIPServerRequest.processRequest(sIPRequest, this);
                                if (z2) {
                                    if (zPassToListener2) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            } finally {
                                if ((serverRequestInterfaceNewSIPServerRequest instanceof SIPTransaction) && !((SIPServerTransaction) serverRequestInterfaceNewSIPServerRequest).passToListener()) {
                                    ((SIPTransaction) serverRequestInterfaceNewSIPServerRequest).releaseSem();
                                }
                            }
                        }
                        if (this.sipStack.sipMessageValves.size() == 0) {
                            SIPMessage sIPMessageCreateResponse = sIPRequest.createResponse(503);
                            RetryAfter retryAfter = new RetryAfter();
                            try {
                                retryAfter.setRetryAfter((int) (Math.random() * 10.0d));
                                sIPMessageCreateResponse.setHeader(retryAfter);
                                sendMessage(sIPMessageCreateResponse);
                            } catch (Exception unused) {
                            }
                            if (logger.isLoggingEnabled()) {
                                logger.logWarning("Dropping message -- could not acquire semaphore");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    sendMessage(sIPRequest.createResponse(400).encodeAsBytes(getTransport()), false);
                    throw new Exception("Bad CSeq method" + sIPMessage + " method " + method);
                }
                sendMessage(((SIPRequest) sIPMessage).createResponse(505, "Bad SIP version " + sipVersion).encodeAsBytes(getTransport()), false);
                throw new Exception("Bad version ");
            }
            SIPResponse sIPResponse = (SIPResponse) sIPMessage;
            try {
                sIPResponse.checkHeaders();
                if (this.sipStack.getMaxMessageSize() > 0) {
                    if (sIPResponse.getSize() + (sIPResponse.getContentLength() != null ? sIPResponse.getContentLength().getContentLength() : 0) > this.sipStack.getMaxMessageSize()) {
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("Message size exceeded");
                            return;
                        }
                        return;
                    }
                }
                ServerResponseInterface serverResponseInterfaceNewSIPServerResponse = this.sipStack.newSIPServerResponse(sIPResponse, this);
                if (serverResponseInterfaceNewSIPServerResponse != null) {
                    try {
                        if ((serverResponseInterfaceNewSIPServerResponse instanceof SIPClientTransaction) && !((SIPClientTransaction) serverResponseInterfaceNewSIPServerResponse).checkFromTag(sIPResponse)) {
                            if (logger.isLoggingEnabled()) {
                                logger.logError("Dropping response message with invalid tag >>> " + sIPResponse);
                            }
                            if (z) {
                                if (zPassToListener) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        serverResponseInterfaceNewSIPServerResponse.processResponse(sIPResponse, this);
                        if (!(serverResponseInterfaceNewSIPServerResponse instanceof SIPTransaction) || ((SIPTransaction) serverResponseInterfaceNewSIPServerResponse).passToListener()) {
                            return;
                        }
                        ((SIPTransaction) serverResponseInterfaceNewSIPServerResponse).releaseSem();
                        return;
                    } finally {
                        if ((serverResponseInterfaceNewSIPServerResponse instanceof SIPTransaction) && !((SIPTransaction) serverResponseInterfaceNewSIPServerResponse).passToListener()) {
                            ((SIPTransaction) serverResponseInterfaceNewSIPServerResponse).releaseSem();
                        }
                    }
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("null sipServerResponse as could not acquire semaphore or the valve dropped the message.");
                    return;
                }
                return;
            } catch (ParseException unused2) {
                if (logger.isLoggingEnabled()) {
                    logger.logError("Dropping Badly formatted response message >>> " + sIPResponse);
                    return;
                }
                return;
            }
        }
        if (logger.isLoggingEnabled()) {
            String strEncode = sIPMessage.encode();
            logger.logError("bad message " + strEncode);
            logger.logError(">>> Dropped Bad Msg");
        }
    }
}
