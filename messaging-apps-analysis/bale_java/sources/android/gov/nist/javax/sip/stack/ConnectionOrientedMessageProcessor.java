package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Host;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class ConnectionOrientedMessageProcessor extends MessageProcessor {
    private static StackLogger logger = CommonLogger.getLogger(ConnectionOrientedMessageProcessor.class);
    protected final Map<String, ConnectionOrientedMessageChannel> incomingMessageChannels;
    protected boolean isRunning;
    protected final Map<String, ConnectionOrientedMessageChannel> messageChannels;
    protected int nConnections;
    protected ServerSocket sock;
    protected int useCount;

    public ConnectionOrientedMessageProcessor(InetAddress inetAddress, int i, String str, SIPTransactionStack sIPTransactionStack) {
        super(inetAddress, i, str, sIPTransactionStack);
        this.sipStack = sIPTransactionStack;
        this.messageChannels = new ConcurrentHashMap();
        this.incomingMessageChannels = new ConcurrentHashMap();
    }

    protected synchronized void cacheMessageChannel(ConnectionOrientedMessageChannel connectionOrientedMessageChannel) {
        try {
            String key = connectionOrientedMessageChannel.getKey();
            ConnectionOrientedMessageChannel connectionOrientedMessageChannel2 = this.messageChannels.get(key);
            if (connectionOrientedMessageChannel2 != null) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Closing " + key);
                }
                connectionOrientedMessageChannel2.close();
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Caching " + key);
            }
            this.messageChannels.put(key, connectionOrientedMessageChannel);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean closeReliableConnection(String str, int i) {
        validatePortInRange(i);
        HostPort hostPort = new HostPort();
        hostPort.setHost(new Host(str));
        hostPort.setPort(i);
        String key = MessageChannel.getKey(hostPort, "TCP");
        synchronized (this) {
            try {
                ConnectionOrientedMessageChannel connectionOrientedMessageChannel = this.messageChannels.get(key);
                if (connectionOrientedMessageChannel != null) {
                    connectionOrientedMessageChannel.close();
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug(Thread.currentThread() + " Removing channel " + key + " for processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
                    }
                    this.incomingMessageChannels.remove(key);
                    this.messageChannels.remove(key);
                    return true;
                }
                ConnectionOrientedMessageChannel connectionOrientedMessageChannel2 = this.incomingMessageChannels.get(key);
                if (connectionOrientedMessageChannel2 == null) {
                    return false;
                }
                connectionOrientedMessageChannel2.close();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug(Thread.currentThread() + " Removing incoming channel " + key + " for processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
                }
                this.incomingMessageChannels.remove(key);
                this.messageChannels.remove(key);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public int getMaximumMessageSize() {
        return Integer.MAX_VALUE;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public SIPTransactionStack getSIPStack() {
        return this.sipStack;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public boolean inUse() {
        return this.useCount != 0;
    }

    protected synchronized void remove(ConnectionOrientedMessageChannel connectionOrientedMessageChannel) {
        try {
            String key = connectionOrientedMessageChannel.getKey();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug(Thread.currentThread() + " removing " + key + " for processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
            }
            if (this.messageChannels.get(key) == connectionOrientedMessageChannel) {
                this.messageChannels.remove(key);
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug(Thread.currentThread() + " Removing incoming channel " + key + " for processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
            }
            this.incomingMessageChannels.remove(key);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean setKeepAliveTimeout(String str, int i, long j) {
        validatePortInRange(i);
        HostPort hostPort = new HostPort();
        hostPort.setHost(new Host(str));
        hostPort.setPort(i);
        String key = MessageChannel.getKey(hostPort, "TCP");
        ConnectionOrientedMessageChannel connectionOrientedMessageChannel = this.messageChannels.get(key);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug(Thread.currentThread() + " checking channel with key " + key + " : " + connectionOrientedMessageChannel + " for processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
        }
        if (connectionOrientedMessageChannel != null) {
            connectionOrientedMessageChannel.setKeepAliveTimeout(j);
            return true;
        }
        ConnectionOrientedMessageChannel connectionOrientedMessageChannel2 = this.incomingMessageChannels.get(key);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug(Thread.currentThread() + " checking incoming channel with key " + key + " : " + connectionOrientedMessageChannel2 + " for processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
        }
        if (connectionOrientedMessageChannel2 == null) {
            return false;
        }
        connectionOrientedMessageChannel2.setKeepAliveTimeout(j);
        return true;
    }

    protected void validatePortInRange(int i) {
        if (i < 1 || i > 65535) {
            throw new IllegalArgumentException("Peer port should be greater than 0 and less 65535, port = " + i);
        }
    }
}
