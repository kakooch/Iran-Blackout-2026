package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.ThreadAffinityTask;
import android.gov.nist.javax.sip.address.ParameterNames;
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
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.MessageParser;
import android.gov.nist.javax.sip.parser.ParseExceptionListener;
import ir.nasim.FY2;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class UDPMessageChannel extends MessageChannel implements ParseExceptionListener, Runnable, RawMessageChannel {
    private static final StackLogger logger = CommonLogger.getLogger(UDPMessageChannel.class);
    private static Hashtable<String, PingBackTimerTask> pingBackRecord = new Hashtable<>();
    private DatagramPacket incomingPacket;
    private String myAddress;
    protected MessageParser myParser;
    protected int myPort;
    private Thread mythread;
    private InetAddress peerAddress;
    private InetAddress peerPacketSourceAddress;
    private int peerPacketSourcePort;
    private int peerPort;
    private String peerProtocol;
    private long receptionTime;
    protected SIPTransactionStack sipStack;

    class PingBackTimerTask extends SIPStackTimerTask {
        String ipAddress;
        int port;

        public PingBackTimerTask(String str, int i) {
            this.ipAddress = str;
            this.port = i;
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return null;
        }

        public int hashCode() {
            return (this.ipAddress + ":" + this.port).hashCode();
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            UDPMessageChannel.pingBackRecord.remove(this.ipAddress + ":" + this.port);
        }
    }

    protected UDPMessageChannel(SIPTransactionStack sIPTransactionStack, UDPMessageProcessor uDPMessageProcessor, String str) {
        this.mythread = null;
        this.messageProcessor = uDPMessageProcessor;
        this.sipStack = sIPTransactionStack;
        this.myParser = sIPTransactionStack.getMessageParserFactory().createMessageParser(this.sipStack);
        this.mythread = new Thread(this);
        this.myAddress = uDPMessageProcessor.getIpAddress().getHostAddress();
        this.myPort = uDPMessageProcessor.getPort();
        this.mythread.setName(str);
        this.mythread.setDaemon(true);
        this.mythread.start();
    }

    private void processIncomingDataPacket(DatagramPacket datagramPacket) throws IOException {
        this.peerAddress = datagramPacket.getAddress();
        int length = datagramPacket.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket.getData(), 0, bArr, 0, length);
        StackLogger stackLogger = logger;
        if (stackLogger.isLoggingEnabled(32)) {
            stackLogger.logDebug("UDPMessageChannel: processIncomingDataPacket : peerAddress = " + this.peerAddress.getHostAddress() + Separators.SLASH + datagramPacket.getPort() + " Length = " + length);
        }
        try {
            this.receptionTime = System.currentTimeMillis();
            boolean z = true;
            SIPMessage sIPMessage = this.myParser.parseSIPMessage(bArr, true, false, this);
            if (sIPMessage instanceof SIPRequest) {
                String sipVersion = ((SIPRequest) sIPMessage).getRequestLine().getSipVersion();
                if (!sipVersion.equals(SIPConstants.SIP_VERSION_STRING)) {
                    sendMessage(((SIPRequest) sIPMessage).createResponse(505, "Bad version " + sipVersion).toString().getBytes(), this.peerAddress, datagramPacket.getPort(), "UDP", false);
                    return;
                }
                if (!((SIPRequest) sIPMessage).getMethod().equalsIgnoreCase(((SIPRequest) sIPMessage).getCSeqHeader().getMethod())) {
                    sendMessage(((SIPRequest) sIPMessage).createResponse(400).encodeAsBytes(getTransport()), this.peerAddress, datagramPacket.getPort(), "UDP", false);
                    return;
                }
            }
            if (sIPMessage == null) {
                if (stackLogger.isLoggingEnabled(32)) {
                    stackLogger.logDebug("Rejecting message !  + Null message parsed.");
                }
                String str = datagramPacket.getAddress().getHostAddress() + ":" + datagramPacket.getPort();
                if (pingBackRecord.get(str) != null || this.sipStack.getMinKeepAliveInterval() <= 0) {
                    stackLogger.logDebug("Not sending ping back");
                    return;
                }
                byte[] bytes = "\r\n\r\n".getBytes();
                DatagramPacket datagramPacket2 = new DatagramPacket(bytes, 0, bytes.length, datagramPacket.getAddress(), datagramPacket.getPort());
                PingBackTimerTask pingBackTimerTask = new PingBackTimerTask(datagramPacket.getAddress().getHostAddress(), datagramPacket.getPort());
                pingBackRecord.put(str, pingBackTimerTask);
                this.sipStack.getTimer().schedule(pingBackTimerTask, this.sipStack.getMinKeepAliveInterval() * 1000);
                ((UDPMessageProcessor) this.messageProcessor).sock.send(datagramPacket2);
                return;
            }
            Via topmostVia = sIPMessage.getTopmostVia();
            if (sIPMessage.getFrom() == null || sIPMessage.getTo() == null || sIPMessage.getCallId() == null || sIPMessage.getCSeq() == null || topmostVia == null) {
                String str2 = new String(bArr);
                if (stackLogger.isLoggingEnabled()) {
                    stackLogger.logError("bad message " + str2);
                    stackLogger.logError(">>> Dropped Bad Msg From = " + sIPMessage.getFrom() + "To = " + sIPMessage.getTo() + "CallId = " + sIPMessage.getCallId() + "CSeq = " + sIPMessage.getCSeq() + "Via = " + sIPMessage.getViaHeaders());
                    return;
                }
                return;
            }
            SIPEventInterceptor sIPEventInterceptor = this.sipStack.sipEventInterceptor;
            if (sIPEventInterceptor != null) {
                sIPEventInterceptor.beforeMessage(sIPMessage);
            }
            if (sIPMessage instanceof SIPRequest) {
                FY2 fy2ResolveAddress = this.sipStack.addressResolver.resolveAddress(topmostVia.getHop());
                this.peerPort = fy2ResolveAddress.getPort();
                this.peerProtocol = topmostVia.getTransport();
                this.peerPacketSourceAddress = datagramPacket.getAddress();
                this.peerPacketSourcePort = datagramPacket.getPort();
                try {
                    this.peerAddress = datagramPacket.getAddress();
                    boolean zHasParameter = topmostVia.hasParameter("rport");
                    if (!this.sipStack.isPatchRport() || zHasParameter || topmostVia.getPort() == this.peerPacketSourcePort) {
                        z = zHasParameter;
                    } else if (stackLogger.isLoggingEnabled(32)) {
                        stackLogger.logDebug("setting rport since viaPort " + topmostVia.getPort() + " different than peerPacketSourcePort " + this.peerPacketSourcePort + " so that the response can be routed back");
                    }
                    if (z || !fy2ResolveAddress.getHost().equals(this.peerAddress.getHostAddress())) {
                        topmostVia.setParameter("received", this.peerAddress.getHostAddress());
                    }
                    if (z) {
                        topmostVia.setParameter("rport", Integer.toString(this.peerPacketSourcePort));
                    }
                } catch (ParseException e) {
                    InternalErrorHandler.handleException(e);
                }
            } else {
                this.peerPacketSourceAddress = datagramPacket.getAddress();
                this.peerPacketSourcePort = datagramPacket.getPort();
                this.peerAddress = datagramPacket.getAddress();
                this.peerPort = datagramPacket.getPort();
                this.peerProtocol = topmostVia.getTransport();
            }
            processMessage(sIPMessage);
            SIPEventInterceptor sIPEventInterceptor2 = this.sipStack.sipEventInterceptor;
            if (sIPEventInterceptor2 != null) {
                sIPEventInterceptor2.afterMessage(sIPMessage);
            }
        } catch (ParseException e2) {
            StackLogger stackLogger2 = logger;
            if (stackLogger2.isLoggingEnabled(32)) {
                stackLogger2.logDebug("Rejecting message !  " + new String(bArr) + Separators.SP + e2.getMessage());
            }
            String str3 = new String(bArr, 0, length);
            if (str3.startsWith("SIP/") || str3.startsWith("ACK ")) {
                return;
            }
            String strCreateBadReqRes = createBadReqRes(str3, e2);
            if (strCreateBadReqRes == null) {
                if (stackLogger2.isLoggingEnabled(32)) {
                    stackLogger2.logDebug("Could not formulate automatic 400 Bad Request");
                    return;
                }
                return;
            }
            if (stackLogger2.isLoggingEnabled(32)) {
                stackLogger2.logDebug("Sending automatic 400 Bad Request:");
                stackLogger2.logDebug(strCreateBadReqRes);
            }
            try {
                sendMessage(strCreateBadReqRes.getBytes(), this.peerAddress, datagramPacket.getPort(), "UDP", false);
            } catch (IOException e3) {
                logger.logException(e3);
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public void close() {
        Thread thread = this.mythread;
        if (thread != null) {
            thread.interrupt();
            this.mythread = null;
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass().equals(obj.getClass())) {
            return getKey().equals(((UDPMessageChannel) obj).getKey());
        }
        return false;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getHost() {
        return this.messageProcessor.getIpAddress().getHostAddress();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getKey() {
        return MessageChannel.getKey(this.peerAddress, this.peerPort, "UDP");
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getPeerAddress() {
        return this.peerAddress.getHostAddress();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    protected InetAddress getPeerInetAddress() {
        return this.peerAddress;
    }

    public String getPeerName() {
        return this.peerAddress.getHostName();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public InetAddress getPeerPacketSourceAddress() {
        return this.peerPacketSourceAddress;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public int getPeerPacketSourcePort() {
        return this.peerPacketSourcePort;
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
    public int getPort() {
        return ((UDPMessageProcessor) this.messageProcessor).getPort();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public SIPTransactionStack getSIPStack() {
        return this.sipStack;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getTransport() {
        return ParameterNames.UDP;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getViaHost() {
        return this.myAddress;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public int getViaPort() {
        return this.myPort;
    }

    @Override // android.gov.nist.javax.sip.parser.ParseExceptionListener
    public void handleException(ParseException parseException, SIPMessage sIPMessage, Class cls, String str, String str2) throws ParseException {
        StackLogger stackLogger = logger;
        if (stackLogger.isLoggingEnabled(32)) {
            stackLogger.logDebug("Parsing Issue " + parseException.getMessage());
        }
        if (cls == null || !(cls.equals(From.class) || cls.equals(To.class) || cls.equals(CSeq.class) || cls.equals(Via.class) || cls.equals(CallID.class) || cls.equals(ContentLength.class) || cls.equals(RequestLine.class) || cls.equals(StatusLine.class))) {
            sIPMessage.addUnparsed(str);
        } else {
            if (!stackLogger.isLoggingEnabled(32)) {
                throw parseException;
            }
            stackLogger.logDebug("BAD MESSAGE! " + str2);
            throw parseException;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isReliable() {
        return false;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isSecure() {
        return false;
    }

    @Override // android.gov.nist.javax.sip.stack.RawMessageChannel
    public void processMessage(SIPMessage sIPMessage) {
        sIPMessage.setRemoteAddress(this.peerAddress);
        sIPMessage.setRemotePort(getPeerPort());
        sIPMessage.setLocalPort(getPort());
        sIPMessage.setLocalAddress(getMessageProcessor().getIpAddress());
        StackLogger stackLogger = logger;
        if (stackLogger.isLoggingEnabled(16)) {
            stackLogger.logInfo("Setting SIPMessage peerPacketSource to: " + this.peerPacketSourceAddress + ":" + this.peerPacketSourcePort);
        }
        sIPMessage.setPeerPacketSourceAddress(this.peerPacketSourceAddress);
        sIPMessage.setPeerPacketSourcePort(this.peerPacketSourcePort);
        if (sIPMessage instanceof SIPRequest) {
            SIPRequest sIPRequest = (SIPRequest) sIPMessage;
            if (stackLogger.isLoggingEnabled(16)) {
                this.sipStack.serverLogger.logMessage(sIPMessage, getPeerHostPort().toString(), getHost() + ":" + this.myPort, false, this.receptionTime);
            }
            ServerRequestInterface serverRequestInterfaceNewSIPServerRequest = this.sipStack.newSIPServerRequest(sIPRequest, this);
            if (serverRequestInterfaceNewSIPServerRequest == null) {
                if (stackLogger.isLoggingEnabled()) {
                    stackLogger.logWarning("Null request interface returned -- dropping request");
                    return;
                }
                return;
            }
            if (stackLogger.isLoggingEnabled(32)) {
                stackLogger.logDebug("About to process " + sIPRequest.getFirstLine() + Separators.SLASH + serverRequestInterfaceNewSIPServerRequest);
            }
            try {
                serverRequestInterfaceNewSIPServerRequest.processRequest(sIPRequest, this);
                if (stackLogger.isLoggingEnabled(32)) {
                    stackLogger.logDebug("Done processing " + sIPRequest.getFirstLine() + Separators.SLASH + serverRequestInterfaceNewSIPServerRequest);
                    return;
                }
                return;
            } finally {
                if ((serverRequestInterfaceNewSIPServerRequest instanceof SIPTransaction) && !((SIPServerTransaction) serverRequestInterfaceNewSIPServerRequest).passToListener()) {
                    ((SIPTransaction) serverRequestInterfaceNewSIPServerRequest).releaseSem();
                }
            }
        }
        SIPResponse sIPResponse = (SIPResponse) sIPMessage;
        try {
            sIPResponse.checkHeaders();
            if (stackLogger.isLoggingEnabled(16)) {
                this.sipStack.serverLogger.logMessage((SIPMessage) sIPResponse, getPeerHostPort().toString(), getHost() + ":" + this.myPort, false, this.receptionTime);
            }
            ServerResponseInterface serverResponseInterfaceNewSIPServerResponse = this.sipStack.newSIPServerResponse(sIPResponse, this);
            if (serverResponseInterfaceNewSIPServerResponse == null) {
                if (stackLogger.isLoggingEnabled(32)) {
                    stackLogger.logDebug("null sipServerResponse as could not acquire semaphore or the valve dropped the message.");
                    return;
                }
                return;
            }
            try {
                if (!(serverResponseInterfaceNewSIPServerResponse instanceof SIPClientTransaction) || ((SIPClientTransaction) serverResponseInterfaceNewSIPServerResponse).checkFromTag(sIPResponse)) {
                    serverResponseInterfaceNewSIPServerResponse.processResponse(sIPResponse, this);
                    if (serverResponseInterfaceNewSIPServerResponse instanceof SIPTransaction) {
                        SIPTransaction sIPTransaction = (SIPTransaction) serverResponseInterfaceNewSIPServerResponse;
                        if (sIPTransaction.passToListener()) {
                            return;
                        }
                        sIPTransaction.releaseSem();
                        return;
                    }
                    return;
                }
                if (stackLogger.isLoggingEnabled()) {
                    stackLogger.logError("Dropping response message with invalid tag >>> " + sIPResponse);
                }
            } finally {
                if (serverResponseInterfaceNewSIPServerResponse instanceof SIPTransaction) {
                    SIPTransaction sIPTransaction2 = (SIPTransaction) serverResponseInterfaceNewSIPServerResponse;
                    if (!sIPTransaction2.passToListener()) {
                        sIPTransaction2.releaseSem();
                    }
                }
            }
        } catch (ParseException unused) {
            if (logger.isLoggingEnabled()) {
                logger.logError("Dropping Badly formatted response message >>> " + sIPResponse);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(4:(1:8)|(1:10)|(5:43|12|(1:18)(1:16)|19|(2:46|21)(1:(3:48|23|53)(4:47|24|41|25)))(0)|51)(2:45|30)|39|31|35|(2:50|37)(2:52|51)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        android.gov.nist.javax.sip.stack.UDPMessageChannel.logger.logError("Error while processing incoming UDP packet" + java.util.Arrays.toString(r3.getData()), r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[Catch: InterruptedException -> 0x0049, TryCatch #2 {InterruptedException -> 0x0049, blocks: (B:12:0x0026, B:14:0x002e, B:16:0x003a, B:19:0x0053, B:24:0x005b, B:18:0x004b), top: B:43:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0006 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r9 = this;
            android.gov.nist.javax.sip.stack.MessageProcessor r0 = r9.messageProcessor
            android.gov.nist.javax.sip.stack.UDPMessageProcessor r0 = (android.gov.nist.javax.sip.stack.UDPMessageProcessor) r0
            r1 = 0
            r2 = r1
        L6:
            android.gov.nist.javax.sip.stack.SIPTransactionStack r3 = r9.sipStack
            int r4 = r3.threadPoolSize
            r5 = -1
            if (r4 == r5) goto L65
            if (r2 != 0) goto L1f
            android.gov.nist.core.ThreadAuditor r3 = r3.getThreadAuditor()
            if (r3 == 0) goto L1f
            android.gov.nist.javax.sip.stack.SIPTransactionStack r2 = r9.sipStack
            android.gov.nist.core.ThreadAuditor r2 = r2.getThreadAuditor()
            android.gov.nist.core.ThreadAuditor$ThreadHandle r2 = r2.addCurrentThread()
        L1f:
            if (r2 == 0) goto L24
            r2.ping()
        L24:
            if (r2 == 0) goto L4b
            android.gov.nist.javax.sip.stack.SIPTransactionStack r3 = r9.sipStack     // Catch: java.lang.InterruptedException -> L49
            android.gov.nist.core.ThreadAuditor r3 = r3.getThreadAuditor()     // Catch: java.lang.InterruptedException -> L49
            if (r3 == 0) goto L4b
            android.gov.nist.javax.sip.stack.SIPTransactionStack r3 = r9.sipStack     // Catch: java.lang.InterruptedException -> L49
            android.gov.nist.core.ThreadAuditor r3 = r3.getThreadAuditor()     // Catch: java.lang.InterruptedException -> L49
            boolean r3 = r3.isEnabled()     // Catch: java.lang.InterruptedException -> L49
            if (r3 == 0) goto L4b
            java.util.concurrent.BlockingQueue<android.gov.nist.javax.sip.stack.DatagramQueuedMessageDispatch> r3 = r0.messageQueue     // Catch: java.lang.InterruptedException -> L49
            long r6 = r2.getPingIntervalInMillisecs()     // Catch: java.lang.InterruptedException -> L49
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.InterruptedException -> L49
            java.lang.Object r3 = r3.poll(r6, r4)     // Catch: java.lang.InterruptedException -> L49
            android.gov.nist.javax.sip.stack.DatagramQueuedMessageDispatch r3 = (android.gov.nist.javax.sip.stack.DatagramQueuedMessageDispatch) r3     // Catch: java.lang.InterruptedException -> L49
            goto L53
        L49:
            r3 = r1
            goto L60
        L4b:
            java.util.concurrent.BlockingQueue<android.gov.nist.javax.sip.stack.DatagramQueuedMessageDispatch> r3 = r0.messageQueue     // Catch: java.lang.InterruptedException -> L49
            java.lang.Object r3 = r3.take()     // Catch: java.lang.InterruptedException -> L49
            android.gov.nist.javax.sip.stack.DatagramQueuedMessageDispatch r3 = (android.gov.nist.javax.sip.stack.DatagramQueuedMessageDispatch) r3     // Catch: java.lang.InterruptedException -> L49
        L53:
            boolean r4 = r0.isRunning     // Catch: java.lang.InterruptedException -> L49
            if (r4 != 0) goto L58
            return
        L58:
            if (r3 != 0) goto L5b
            goto L6
        L5b:
            java.net.DatagramPacket r3 = r3.packet     // Catch: java.lang.InterruptedException -> L49
            r9.incomingPacket = r3     // Catch: java.lang.InterruptedException -> L60
            goto L67
        L60:
            boolean r4 = r0.isRunning
            if (r4 != 0) goto L67
            return
        L65:
            java.net.DatagramPacket r3 = r9.incomingPacket
        L67:
            r9.processIncomingDataPacket(r3)     // Catch: java.lang.Exception -> L6b
            goto L8a
        L6b:
            r4 = move-exception
            android.gov.nist.core.StackLogger r6 = android.gov.nist.javax.sip.stack.UDPMessageChannel.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Error while processing incoming UDP packet"
            r7.append(r8)
            byte[] r3 = r3.getData()
            java.lang.String r3 = java.util.Arrays.toString(r3)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r6.logError(r3, r4)
        L8a:
            android.gov.nist.javax.sip.stack.SIPTransactionStack r3 = r9.sipStack
            int r3 = r3.threadPoolSize
            if (r3 != r5) goto L6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.stack.UDPMessageChannel.run():void");
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public void sendMessage(final SIPMessage sIPMessage) {
        StackLogger stackLogger = logger;
        if (stackLogger.isLoggingEnabled(16) && this.sipStack.isLogStackTraceOnMessageSend()) {
            if (!(sIPMessage instanceof SIPRequest) || ((SIPRequest) sIPMessage).getRequestLine() == null) {
                stackLogger.logStackTrace(16);
            } else {
                stackLogger.logStackTrace(16);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                for (MessageProcessor messageProcessor : this.sipStack.getMessageProcessors()) {
                    if (messageProcessor.getIpAddress().equals(this.peerAddress) && messageProcessor.getPort() == this.peerPort && messageProcessor.getTransport().equalsIgnoreCase(this.peerProtocol)) {
                        Object objCreateMessageChannel = messageProcessor.createMessageChannel(this.peerAddress, this.peerPort);
                        if (objCreateMessageChannel instanceof RawMessageChannel) {
                            final RawMessageChannel rawMessageChannel = (RawMessageChannel) objCreateMessageChannel;
                            getSIPStack().getSelfRoutingThreadpoolExecutor().execute(new ThreadAffinityTask() { // from class: android.gov.nist.javax.sip.stack.UDPMessageChannel.1
                                @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                                public Object getThreadHash() {
                                    return sIPMessage.getCallId().getCallId();
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        rawMessageChannel.processMessage((SIPMessage) sIPMessage.clone());
                                    } catch (Exception e) {
                                        if (UDPMessageChannel.logger.isLoggingEnabled(4)) {
                                            UDPMessageChannel.logger.logError("Error self routing message cause by: ", e);
                                        }
                                    }
                                }
                            });
                            StackLogger stackLogger2 = logger;
                            if (stackLogger2.isLoggingEnabled(32)) {
                                stackLogger2.logDebug("Self routing message");
                            }
                            if (stackLogger2.isLoggingEnabled(16) && !sIPMessage.isNullRequest()) {
                                logMessage(sIPMessage, this.peerAddress, this.peerPort, jCurrentTimeMillis);
                                return;
                            } else {
                                if (stackLogger2.isLoggingEnabled(32)) {
                                    stackLogger2.logDebug("Sent EMPTY Message");
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                sendMessage(sIPMessage.encodeAsBytes(getTransport()), this.peerAddress, this.peerPort, this.peerProtocol, sIPMessage instanceof SIPRequest);
                sIPMessage.setRemoteAddress(this.peerAddress);
                sIPMessage.setRemotePort(this.peerPort);
                sIPMessage.setLocalPort(getPort());
                sIPMessage.setLocalAddress(getMessageProcessor().getIpAddress());
                StackLogger stackLogger3 = logger;
                if (stackLogger3.isLoggingEnabled(16) && !sIPMessage.isNullRequest()) {
                    logMessage(sIPMessage, this.peerAddress, this.peerPort, jCurrentTimeMillis);
                } else if (stackLogger3.isLoggingEnabled(32)) {
                    stackLogger3.logDebug("Sent EMPTY Message");
                }
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                logger.logError("An exception occured while sending message", e2);
                throw new IOException("An exception occured while sending message");
            }
        } catch (Throwable th) {
            StackLogger stackLogger4 = logger;
            if (stackLogger4.isLoggingEnabled(16) && !sIPMessage.isNullRequest()) {
                logMessage(sIPMessage, this.peerAddress, this.peerPort, jCurrentTimeMillis);
            } else if (stackLogger4.isLoggingEnabled(32)) {
                stackLogger4.logDebug("Sent EMPTY Message");
            }
            throw th;
        }
    }

    protected UDPMessageChannel(SIPTransactionStack sIPTransactionStack, UDPMessageProcessor uDPMessageProcessor, DatagramPacket datagramPacket) {
        this.mythread = null;
        this.incomingPacket = datagramPacket;
        this.messageProcessor = uDPMessageProcessor;
        this.sipStack = sIPTransactionStack;
        this.myParser = sIPTransactionStack.getMessageParserFactory().createMessageParser(this.sipStack);
        this.myAddress = uDPMessageProcessor.getIpAddress().getHostAddress();
        this.myPort = uDPMessageProcessor.getPort();
        Thread thread = new Thread(this);
        this.mythread = thread;
        thread.setDaemon(true);
        this.mythread.start();
    }

    protected UDPMessageChannel(InetAddress inetAddress, int i, SIPTransactionStack sIPTransactionStack, UDPMessageProcessor uDPMessageProcessor) {
        this.mythread = null;
        this.peerAddress = inetAddress;
        this.peerPort = i;
        this.peerProtocol = "UDP";
        this.messageProcessor = uDPMessageProcessor;
        this.myAddress = uDPMessageProcessor.getIpAddress().getHostAddress();
        this.myPort = uDPMessageProcessor.getPort();
        this.sipStack = sIPTransactionStack;
        this.myParser = sIPTransactionStack.getMessageParserFactory().createMessageParser(sIPTransactionStack);
        StackLogger stackLogger = logger;
        if (stackLogger.isLoggingEnabled(32)) {
            stackLogger.logDebug("Creating message channel " + inetAddress.getHostAddress() + Separators.SLASH + i);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    protected void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws IOException {
        DatagramSocket datagramSocket;
        boolean z2;
        StackLogger stackLogger = logger;
        if (stackLogger.isLoggingEnabled(16) && this.sipStack.isLogStackTraceOnMessageSend()) {
            stackLogger.logStackTrace(16);
        }
        if (i == -1) {
            if (stackLogger.isLoggingEnabled(32)) {
                stackLogger.logDebug(getClass().getName() + ":sendMessage: Dropping reply!");
            }
            throw new IOException("Receiver port not set ");
        }
        if (stackLogger.isLoggingEnabled(32)) {
            stackLogger.logDebug("sendMessage " + inetAddress.getHostAddress() + Separators.SLASH + i + Separators.RETURN + "messageSize =  " + bArr.length + " message = " + new String(bArr));
            stackLogger.logDebug("*******************\n");
        }
        DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, inetAddress, i);
        try {
            if (this.sipStack.udpFlag) {
                datagramSocket = ((UDPMessageProcessor) this.messageProcessor).sock;
                z2 = false;
            } else {
                datagramSocket = new DatagramSocket();
                z2 = true;
            }
            datagramSocket.send(datagramPacket);
            if (z2) {
                datagramSocket.close();
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            InternalErrorHandler.handleException(e2);
        }
    }

    protected void sendMessage(byte[] bArr, InetAddress inetAddress, int i, String str, boolean z) throws IOException {
        DatagramSocket datagramSocketCreateDatagramSocket;
        if (i == -1) {
            StackLogger stackLogger = logger;
            if (stackLogger.isLoggingEnabled(32)) {
                stackLogger.logDebug(getClass().getName() + ":sendMessage: Dropping reply!");
            }
            throw new IOException("Receiver port not set ");
        }
        StackLogger stackLogger2 = logger;
        if (stackLogger2.isLoggingEnabled(32)) {
            stackLogger2.logDebug(":sendMessage " + inetAddress.getHostAddress() + Separators.SLASH + i + Separators.RETURN + " messageSize = " + bArr.length);
        }
        if (str.compareToIgnoreCase("UDP") == 0) {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, inetAddress, i);
            try {
                SIPTransactionStack sIPTransactionStack = this.sipStack;
                if (sIPTransactionStack.udpFlag) {
                    datagramSocketCreateDatagramSocket = ((UDPMessageProcessor) this.messageProcessor).sock;
                } else {
                    datagramSocketCreateDatagramSocket = sIPTransactionStack.getNetworkLayer().createDatagramSocket();
                }
                if (stackLogger2.isLoggingEnabled(32)) {
                    stackLogger2.logDebug("sendMessage " + inetAddress.getHostAddress() + Separators.SLASH + i + Separators.RETURN + new String(bArr));
                }
                datagramSocketCreateDatagramSocket.send(datagramPacket);
                if (this.sipStack.udpFlag) {
                    return;
                }
                datagramSocketCreateDatagramSocket.close();
                return;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                InternalErrorHandler.handleException(e2);
                return;
            }
        }
        OutputStream outputStream = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), inetAddress, i, ParameterNames.TCP, bArr, z, this).getOutputStream();
        outputStream.write(bArr, 0, bArr.length);
        outputStream.flush();
    }
}
