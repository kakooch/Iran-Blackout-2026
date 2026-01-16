package android.gov.nist.javax.sip.stack.sctp;

import android.gov.nist.core.HostPort;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.stack.MessageChannel;
import android.gov.nist.javax.sip.stack.MessageProcessor;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import com.sun.nio.sctp.SctpChannel;
import com.sun.nio.sctp.SctpServerChannel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* loaded from: classes.dex */
public final class SCTPMessageProcessor extends MessageProcessor implements Runnable {
    private final Set<SCTPMessageChannel> channels;
    private boolean doClose;
    private boolean isRunning;
    private SelectionKey key;
    private SctpServerChannel sctpServerChannel;
    private Selector selector;

    public SCTPMessageProcessor() {
        super("sctp");
        this.channels = new ConcurrentSkipListSet();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public MessageChannel createMessageChannel(HostPort hostPort) {
        return createMessageChannel(hostPort.getInetAddress(), hostPort.getPort());
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public int getDefaultTargetPort() {
        return SIPConstants.DEFAULT_PORT;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public int getMaximumMessageSize() {
        return Integer.MAX_VALUE;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public SIPTransactionStack getSIPStack() {
        return this.sipStack;
    }

    Selector getSelector() {
        return this.selector;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public boolean inUse() {
        return this.isRunning;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public boolean isSecure() {
        return false;
    }

    SelectionKey registerChannel(SCTPMessageChannel sCTPMessageChannel, SctpChannel sctpChannel) {
        SelectionKey selectionKeyRegister;
        synchronized (this) {
            this.selector.wakeup();
            selectionKeyRegister = sctpChannel.register(this.selector, 1, sCTPMessageChannel);
        }
        return selectionKeyRegister;
    }

    void removeChannel(SCTPMessageChannel sCTPMessageChannel) {
        this.channels.remove(sCTPMessageChannel);
    }

    @Override // java.lang.Runnable
    public void run() {
        do {
            try {
                if (this.selector.select() > 0) {
                    Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        it.remove();
                        if (next.isReadable()) {
                            ((SCTPMessageChannel) next.attachment()).readMessages();
                        } else if (next.isAcceptable()) {
                            this.channels.add(new SCTPMessageChannel(this, this.sctpServerChannel.accept()));
                        }
                    }
                }
                synchronized (this) {
                    try {
                        if (this.doClose) {
                            this.selector.close();
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    try {
                        this.selector.close();
                    } finally {
                        stop();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
        } while (this.selector.isOpen());
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public void start() throws IOException {
        SctpServerChannel sctpServerChannelOpen = SctpServerChannel.open();
        this.sctpServerChannel = sctpServerChannelOpen;
        sctpServerChannelOpen.bind(new InetSocketAddress(getIpAddress(), getPort()));
        this.sctpServerChannel.configureBlocking(false);
        Selector selectorOpen = Selector.open();
        this.selector = selectorOpen;
        this.key = this.sctpServerChannel.register(selectorOpen, 16);
        this.isRunning = true;
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.setName("SCTPMessageProcessorThread");
        thread.setPriority(10);
        thread.start();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public void stop() {
        this.isRunning = false;
        this.doClose = true;
        Iterator<SCTPMessageChannel> it = this.channels.iterator();
        while (it.hasNext()) {
            it.next().closeNoRemove();
        }
        this.channels.clear();
        try {
            try {
                this.key.cancel();
                this.sctpServerChannel.close();
                synchronized (this) {
                    this.selector.wakeup();
                }
            } catch (IOException e) {
                e.printStackTrace();
                synchronized (this) {
                    this.selector.wakeup();
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.selector.wakeup();
                throw th;
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public MessageChannel createMessageChannel(InetAddress inetAddress, int i) {
        SCTPMessageChannel sCTPMessageChannel = new SCTPMessageChannel(this, new InetSocketAddress(inetAddress, i));
        this.channels.add(sCTPMessageChannel);
        return sCTPMessageChannel;
    }
}
