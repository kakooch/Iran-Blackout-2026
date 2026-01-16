package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Host;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.ThreadAffinityTask;
import android.gov.nist.javax.sip.address.AddressImpl;
import android.gov.nist.javax.sip.header.ContentLength;
import android.gov.nist.javax.sip.header.ContentType;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.MessageFactoryImpl;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import ir.nasim.FY2;
import ir.nasim.InterfaceC5044Hq6;
import ir.nasim.InterfaceC7782Te1;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;

/* loaded from: classes.dex */
public abstract class MessageChannel {
    private static StackLogger logger = CommonLogger.getLogger(MessageChannel.class);
    static ThreadLocal<String> messageTxId = new ThreadLocal<>();
    private SIPClientTransaction encapsulatedClientTransaction;
    protected transient MessageProcessor messageProcessor;
    protected int useCount;

    private static final boolean copyHeader(String str, String str2, StringBuilder sb) {
        int iIndexOf;
        int iIndexOf2 = str2.indexOf(str);
        if (iIndexOf2 == -1 || (iIndexOf = str2.indexOf(Separators.NEWLINE, iIndexOf2)) == -1) {
            return false;
        }
        sb.append(str2.subSequence(iIndexOf2 - 2, iIndexOf));
        return true;
    }

    private static final boolean copyViaHeaders(String str, StringBuilder sb) {
        int iIndexOf = str.indexOf(SIPHeaderNames.VIA);
        boolean z = false;
        while (iIndexOf != -1) {
            int iIndexOf2 = str.indexOf(Separators.NEWLINE, iIndexOf);
            if (iIndexOf2 == -1) {
                return false;
            }
            sb.append(str.subSequence(iIndexOf - 2, iIndexOf2));
            iIndexOf = str.indexOf(SIPHeaderNames.VIA, iIndexOf2);
            z = true;
        }
        return z;
    }

    public static String getKey(InetAddress inetAddress, int i, String str) {
        return (str + ":" + inetAddress.getHostAddress().replaceAll("[\\[\\]]", "") + ":" + i).toLowerCase();
    }

    public abstract void close();

    protected final String createBadReqRes(String str, ParseException parseException) {
        StringBuilder sb = new StringBuilder(512);
        sb.append("SIP/2.0 400 Bad Request (" + parseException.getLocalizedMessage() + ')');
        if (!copyViaHeaders(str, sb) || !copyHeader(SIPHeaderNames.CSEQ, str, sb) || !copyHeader(SIPHeaderNames.CALL_ID, str, sb) || !copyHeader(SIPHeaderNames.FROM, str, sb) || !copyHeader(SIPHeaderNames.TO, str, sb)) {
            return null;
        }
        int iIndexOf = sb.indexOf(SIPHeaderNames.TO);
        if (iIndexOf != -1 && sb.indexOf(ParameterNames.TAG, iIndexOf) == -1) {
            sb.append(";tag=badreq");
        }
        InterfaceC5044Hq6 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
        if (defaultServerHeader != null) {
            sb.append(Separators.NEWLINE + defaultServerHeader.toString());
        }
        int length = str.length();
        if (!(this instanceof UDPMessageChannel) || sb.length() + length + 45 < 1300) {
            sb.append(Separators.NEWLINE + new ContentType(DialogEntity.COLUMN_MESSAGE, "sipfrag").toString());
            sb.append(Separators.NEWLINE + new ContentLength(length).toString());
            sb.append("\r\n\r\n" + str);
        } else {
            sb.append(Separators.NEWLINE + new ContentLength(0).toString());
        }
        return sb.toString();
    }

    public SIPClientTransaction getEncapsulatedClientTransaction() {
        return this.encapsulatedClientTransaction;
    }

    public String getHost() {
        return getMessageProcessor().getIpAddress().getHostAddress();
    }

    public HostPort getHostPort() {
        HostPort hostPort = new HostPort();
        hostPort.setHost(new Host(getHost()));
        hostPort.setPort(getPort());
        return hostPort;
    }

    public abstract String getKey();

    public MessageProcessor getMessageProcessor() {
        return this.messageProcessor;
    }

    public abstract String getPeerAddress();

    public HostPort getPeerHostPort() {
        HostPort hostPort = new HostPort();
        hostPort.setHost(new Host(getPeerAddress()));
        hostPort.setPort(getPeerPort());
        return hostPort;
    }

    protected abstract InetAddress getPeerInetAddress();

    public abstract InetAddress getPeerPacketSourceAddress();

    public abstract int getPeerPacketSourcePort();

    public abstract int getPeerPort();

    protected abstract String getPeerProtocol();

    public int getPort() {
        MessageProcessor messageProcessor = this.messageProcessor;
        if (messageProcessor != null) {
            return messageProcessor.getPort();
        }
        return -1;
    }

    public String getRawIpSourceAddress() {
        try {
            return InetAddress.getByName(getPeerAddress()).getHostAddress();
        } catch (Exception e) {
            InternalErrorHandler.handleException(e);
            return null;
        }
    }

    public abstract SIPTransactionStack getSIPStack();

    public abstract String getTransport();

    public Via getViaHeader() {
        Via via = new Via();
        try {
            via.setTransport(getTransport());
        } catch (ParseException unused) {
        }
        via.setSentBy(getHostPort());
        return via;
    }

    public abstract String getViaHost();

    public HostPort getViaHostPort() {
        HostPort hostPort = new HostPort();
        hostPort.setHost(new Host(getViaHost()));
        hostPort.setPort(getViaPort());
        return hostPort;
    }

    public abstract int getViaPort();

    public abstract boolean isReliable();

    public abstract boolean isSecure();

    public void logMessage(SIPMessage sIPMessage, InetAddress inetAddress, int i, long j) {
        if (logger.isLoggingEnabled(16)) {
            if (i == -1) {
                i = SIPConstants.DEFAULT_PORT;
            }
            getSIPStack().serverLogger.logMessage(sIPMessage, getHost() + ":" + getPort(), inetAddress.getHostAddress().toString() + ":" + i, true, j);
        }
    }

    public void logResponse(SIPResponse sIPResponse, long j, String str) {
        int peerPort = getPeerPort();
        if (peerPort == 0 && sIPResponse.getContactHeaders() != null) {
            peerPort = ((AddressImpl) ((InterfaceC7782Te1) sIPResponse.getContactHeaders().getFirst()).getAddress()).getPort();
        }
        getSIPStack().serverLogger.logMessage(sIPResponse, getPeerAddress().toString() + ":" + peerPort, getHost() + ":" + getPort(), str, false, j);
    }

    public abstract void sendMessage(SIPMessage sIPMessage);

    public void sendMessage(final SIPMessage sIPMessage, FY2 fy2) throws UnknownHostException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        InetAddress byName = InetAddress.getByName(fy2.getHost());
        try {
            try {
                for (MessageProcessor messageProcessor : getSIPStack().getMessageProcessors()) {
                    if (messageProcessor.getIpAddress().equals(byName) && messageProcessor.getPort() == fy2.getPort() && messageProcessor.getTransport().equalsIgnoreCase(fy2.getTransport())) {
                        Object objCreateMessageChannel = messageProcessor.createMessageChannel(byName, fy2.getPort());
                        if (objCreateMessageChannel instanceof RawMessageChannel) {
                            final RawMessageChannel rawMessageChannel = (RawMessageChannel) objCreateMessageChannel;
                            getSIPStack().getSelfRoutingThreadpoolExecutor().execute(new ThreadAffinityTask() { // from class: android.gov.nist.javax.sip.stack.MessageChannel.1
                                @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
                                public Object getThreadHash() {
                                    return sIPMessage.getCallId().getCallId();
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        rawMessageChannel.processMessage((SIPMessage) sIPMessage.clone());
                                    } catch (Exception e) {
                                        if (MessageChannel.logger.isLoggingEnabled(4)) {
                                            MessageChannel.logger.logError("Error self routing message cause by: ", e);
                                        }
                                    }
                                }
                            });
                            if (logger.isLoggingEnabled(32)) {
                                logger.logDebug("Self routing message");
                            }
                            messageTxId.remove();
                            if (logger.isLoggingEnabled(16)) {
                                logMessage(sIPMessage, byName, fy2.getPort(), jCurrentTimeMillis);
                                return;
                            }
                            return;
                        }
                    }
                }
                messageTxId.set(sIPMessage.getTransactionId());
                sendMessage(sIPMessage.encodeAsBytes(getTransport()), byName, fy2.getPort(), sIPMessage instanceof SIPRequest);
                sIPMessage.setRemoteAddress(byName);
                sIPMessage.setRemotePort(fy2.getPort());
                sIPMessage.setLocalPort(getPort());
                sIPMessage.setLocalAddress(getMessageProcessor().getIpAddress());
                messageTxId.remove();
                if (logger.isLoggingEnabled(16)) {
                    logMessage(sIPMessage, byName, fy2.getPort(), jCurrentTimeMillis);
                }
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                if (logger.isLoggingEnabled(4)) {
                    logger.logError("Error self routing message cause by: ", e2);
                }
                throw new IOException("Error self routing message");
            }
        } finally {
        }
    }

    protected abstract void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z);

    public void setEncapsulatedClientTransaction(SIPClientTransaction sIPClientTransaction) {
        this.encapsulatedClientTransaction = sIPClientTransaction;
    }

    protected void uncache() {
    }

    public static String getKey(HostPort hostPort, String str) {
        String ipAddress = hostPort.getHost().getIpAddress();
        if (ipAddress == null) {
            ipAddress = hostPort.getHost().getHostname();
        }
        return (str + ":" + ipAddress.replaceAll("[\\[\\]]", "") + ":" + hostPort.getPort()).toLowerCase();
    }

    public void sendMessage(SIPMessage sIPMessage, InetAddress inetAddress, int i) throws UnsupportedEncodingException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrEncodeAsBytes = sIPMessage.encodeAsBytes(getTransport());
        messageTxId.set(sIPMessage.getTransactionId());
        try {
            sendMessage(bArrEncodeAsBytes, inetAddress, i, sIPMessage instanceof SIPRequest);
            messageTxId.remove();
            sIPMessage.setRemoteAddress(inetAddress);
            sIPMessage.setRemotePort(i);
            sIPMessage.setLocalPort(getPort());
            sIPMessage.setLocalAddress(getMessageProcessor().getIpAddress());
            logMessage(sIPMessage, inetAddress, i, jCurrentTimeMillis);
        } catch (Throwable th) {
            messageTxId.remove();
            throw th;
        }
    }
}
