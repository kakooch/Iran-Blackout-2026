package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class SocketTimeoutAuditor extends SIPStackTimerTask {
    private static StackLogger logger = CommonLogger.getLogger(SocketTimeoutAuditor.class);
    private NIOHandler nioHandler;
    long nioSocketMaxIdleTime;

    public SocketTimeoutAuditor(long j, NIOHandler nIOHandler) {
        this.nioSocketMaxIdleTime = j;
        this.nioHandler = nIOHandler;
    }

    @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
    public Object getThreadHash() {
        return null;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
    public void runTask() {
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("keys to check for inactivity removal " + this.nioHandler.channelMap.keySet());
            }
            Iterator<Map.Entry<SocketChannel, NioTcpMessageChannel>> it = this.nioHandler.channelMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<SocketChannel, NioTcpMessageChannel> next = it.next();
                SocketChannel key = next.getKey();
                NioTcpMessageChannel value = next.getValue();
                if (System.currentTimeMillis() - value.getLastActivityTimestamp() > this.nioSocketMaxIdleTime) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Will remove socket " + value.key + " lastActivity=" + value.getLastActivityTimestamp() + " current= " + System.currentTimeMillis() + " socketChannel = " + key);
                    }
                    value.close();
                    it = this.nioHandler.channelMap.entrySet().iterator();
                } else if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("don't remove socket " + value.key + " as lastActivity=" + value.getLastActivityTimestamp() + " and current= " + System.currentTimeMillis() + " socketChannel = " + key);
                }
            }
        } catch (Exception unused) {
        }
    }
}
