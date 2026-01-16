package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class NioTcpMessageProcessor extends ConnectionOrientedMessageProcessor {
    private static final int MAX_CHANGE_REQS = 10000;
    private static final int MAX_PENDING_DATA = 10000;
    private static StackLogger logger = CommonLogger.getLogger(NioTcpMessageProcessor.class);
    protected final Queue<ChangeRequest> changeRequests;
    protected ServerSocketChannel channel;
    protected NIOHandler nioHandler;
    private final Map<SocketChannel, Queue<PendingData>> pendingData;
    protected Selector selector;
    protected Thread selectorThread;

    public static class ChangeRequest {
        public static final int CHANGEOPS = 2;
        public static final int REGISTER = 1;
        public int ops;
        public SocketChannel socket;
        public int type;

        public ChangeRequest(SocketChannel socketChannel, int i, int i2) {
            this.socket = socketChannel;
            this.type = i;
            this.ops = i2;
        }

        public String toString() {
            return this.socket + " type = " + this.type + " ops = " + this.ops;
        }
    }

    public static class PendingData {
        final ByteBuffer buffer;
        final String txId;

        public PendingData(String str, ByteBuffer byteBuffer) {
            this.txId = str;
            this.buffer = byteBuffer;
        }
    }

    class ProcessorTask implements Runnable {
        public ProcessorTask() {
        }

        public void accept(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannelAccept = ((ServerSocketChannel) selectionKey.channel()).accept();
            socketChannelAccept.configureBlocking(false);
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("got a new connection! " + socketChannelAccept);
            }
            NioTcpMessageProcessor nioTcpMessageProcessor = NioTcpMessageProcessor.this;
            nioTcpMessageProcessor.createMessageChannel(nioTcpMessageProcessor, socketChannelAccept);
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Adding to selector " + socketChannelAccept);
            }
            socketChannelAccept.register(NioTcpMessageProcessor.this.selector, 1);
        }

        public void connect(SelectionKey selectionKey) throws IOException {
            final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            final NioTcpMessageChannel messageChannel = NioTcpMessageProcessor.this.nioHandler.getMessageChannel(socketChannel);
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Attempting Connect on  " + messageChannel + " socket " + socketChannel);
            }
            if (messageChannel == null) {
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("Dead socketChannel" + socketChannel + " socket " + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
                }
                selectionKey.cancel();
                return;
            }
            try {
                socketChannel.finishConnect();
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("Connected Succesfully");
                }
                if (NioTcpMessageProcessor.this.sipStack.getSelfRoutingThreadpoolExecutor() != null) {
                    NioTcpMessageProcessor.this.sipStack.getSelfRoutingThreadpoolExecutor().execute(new Runnable() { // from class: android.gov.nist.javax.sip.stack.NioTcpMessageProcessor.ProcessorTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            messageChannel.triggerConnectSuccess();
                        }
                    });
                } else {
                    messageChannel.triggerConnectSuccess();
                }
                if (NioTcpMessageProcessor.this.pendingData.get(socketChannel) == null || ((Queue) NioTcpMessageProcessor.this.pendingData.get(socketChannel)).size() <= 0) {
                    return;
                }
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("Pending Data Available, setting WRITE opts.");
                }
                selectionKey.interestOps(4);
            } catch (Exception e) {
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("Cant connect ", e);
                }
                selectionKey.cancel();
                if (NioTcpMessageProcessor.this.sipStack.getSelfRoutingThreadpoolExecutor() != null) {
                    NioTcpMessageProcessor.this.sipStack.getSelfRoutingThreadpoolExecutor().execute(new Runnable() { // from class: android.gov.nist.javax.sip.stack.NioTcpMessageProcessor.ProcessorTask.2
                        @Override // java.lang.Runnable
                        public void run() {
                            messageChannel.triggerConnectFailure((Queue) NioTcpMessageProcessor.this.pendingData.get(socketChannel));
                        }
                    });
                } else {
                    messageChannel.triggerConnectFailure((Queue) NioTcpMessageProcessor.this.pendingData.get(socketChannel));
                }
            }
        }

        public void read(SelectionKey selectionKey) throws Throwable {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            NioTcpMessageChannel messageChannel = NioTcpMessageProcessor.this.nioHandler.getMessageChannel(socketChannel);
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Got something on nioTcpMessageChannel " + messageChannel + " socket " + socketChannel);
            }
            if (messageChannel != null) {
                messageChannel.readChannel();
                return;
            }
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Dead socketChannel" + socketChannel + " socket " + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
            }
            selectionKey.cancel();
            NioTcpMessageProcessor.this.pendingData.remove(socketChannel);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            SelectionKey selectionKeyKeyFor;
            int iSelect = 0;
            while (true) {
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(64)) {
                    NioTcpMessageProcessor.logger.logTrace("Selector thread cycle begin...");
                }
                int i = 0;
                while (NioTcpMessageProcessor.this.changeRequests.peek() != null && i < 10000) {
                    ChangeRequest changeRequestPoll = NioTcpMessageProcessor.this.changeRequests.poll();
                    i++;
                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                        NioTcpMessageProcessor.logger.logDebug("ChangeRequest " + changeRequestPoll + " selector = " + NioTcpMessageProcessor.this.selector);
                    }
                    try {
                        int i2 = changeRequestPoll.type;
                        if (i2 == 1) {
                            try {
                                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                    NioTcpMessageProcessor.logger.logDebug("NIO register " + changeRequestPoll + " selector = " + NioTcpMessageProcessor.this.selector + " blocking=" + changeRequestPoll.socket.isBlocking());
                                }
                                changeRequestPoll.socket.register(NioTcpMessageProcessor.this.selector, changeRequestPoll.ops);
                            } catch (ClosedChannelException unused) {
                                NioTcpMessageProcessor.logger.logWarning("Socket closed before register ops " + changeRequestPoll.socket);
                            }
                        } else if (i2 == 2 && (selectionKeyKeyFor = changeRequestPoll.socket.keyFor(NioTcpMessageProcessor.this.selector)) != null && selectionKeyKeyFor.isValid()) {
                            selectionKeyKeyFor.interestOps(changeRequestPoll.ops);
                            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                NioTcpMessageProcessor.logger.logDebug("Change opts " + changeRequestPoll + " selector = " + NioTcpMessageProcessor.this.selector + " key = " + selectionKeyKeyFor + " blocking=" + changeRequestPoll.socket.isBlocking());
                            }
                        }
                    } catch (Exception e) {
                        NioTcpMessageProcessor.logger.logError("Problem setting changes", e);
                    }
                }
                try {
                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(64)) {
                        NioTcpMessageProcessor.logger.logTrace("Before select");
                    }
                } catch (IOException e2) {
                    NioTcpMessageProcessor.logger.logError("problem in select", e2);
                    return;
                } catch (CancelledKeyException unused2) {
                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(16)) {
                        NioTcpMessageProcessor.logger.logInfo("Looks like remote side closed a connection");
                    }
                }
                if (!NioTcpMessageProcessor.this.selector.isOpen()) {
                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(16)) {
                        NioTcpMessageProcessor.logger.logInfo("Selector is closed ");
                        return;
                    }
                    return;
                }
                iSelect = NioTcpMessageProcessor.this.selector.select();
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(64)) {
                    NioTcpMessageProcessor.logger.logTrace("After select:" + iSelect + ".CRs:" + NioTcpMessageProcessor.this.changeRequests.size());
                }
                if (iSelect <= 0) {
                    try {
                        if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                            NioTcpMessageProcessor.logger.logDebug("null selectedKeys ");
                        }
                    } catch (ClosedSelectorException unused3) {
                        if (NioTcpMessageProcessor.logger.isLoggingEnabled(16)) {
                            NioTcpMessageProcessor.logger.logInfo("Selector is closed");
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        NioTcpMessageProcessor.logger.logError("Problem in the selector loop", e3);
                    }
                } else {
                    Iterator<SelectionKey> it = NioTcpMessageProcessor.this.selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        try {
                            it.remove();
                            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                NioTcpMessageProcessor.logger.logDebug("We got selkey " + next);
                            }
                            if (next.isValid()) {
                                if (next.isAcceptable()) {
                                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                        NioTcpMessageProcessor.logger.logDebug("Accept " + next);
                                    }
                                    accept(next);
                                } else if (next.isReadable()) {
                                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                        NioTcpMessageProcessor.logger.logDebug("Read " + next);
                                    }
                                    read(next);
                                } else if (next.isWritable()) {
                                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                        NioTcpMessageProcessor.logger.logDebug("Write " + next);
                                    }
                                    write(next);
                                } else if (next.isConnectable()) {
                                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                        NioTcpMessageProcessor.logger.logDebug("Connect " + next);
                                    }
                                    connect(next);
                                }
                            } else if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                                NioTcpMessageProcessor.logger.logDebug("Invalid key found " + next);
                            }
                        } catch (Exception e4) {
                            NioTcpMessageProcessor.logger.logError("Problem processing selection key event", e4);
                        }
                    }
                }
            }
        }

        public void write(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            NioTcpMessageChannel messageChannel = NioTcpMessageProcessor.this.nioHandler.getMessageChannel(socketChannel);
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Need to write something on nioTcpMessageChannel " + messageChannel + " socket " + socketChannel);
            }
            if (messageChannel == null) {
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("Dead socketChannel" + socketChannel + " socket " + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
                }
                NioTcpMessageProcessor.this.pendingData.remove(socketChannel);
                selectionKey.cancel();
                return;
            }
            Queue queue = (Queue) NioTcpMessageProcessor.this.pendingData.get(socketChannel);
            if (queue == null || queue.isEmpty()) {
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("The queue was empty on write.");
                }
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("We wrote away all data. Setting READ interest. Queue is emtpy now size =" + queue.size());
                }
                selectionKey.interestOps(1);
                return;
            }
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Queued items for writing " + queue.size());
            }
            int i = 0;
            while (true) {
                if (queue.peek() == null || i >= 10000) {
                    break;
                }
                ByteBuffer byteBuffer = ((PendingData) queue.peek()).buffer;
                try {
                    socketChannel.write(byteBuffer);
                    int iRemaining = byteBuffer.remaining();
                    if (iRemaining <= 0) {
                        queue.remove();
                        i++;
                    } else if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                        NioTcpMessageProcessor.logger.logDebug("Socket buffer filled and more is remaining" + queue.size() + " remain = " + iRemaining);
                    }
                } catch (IOException e) {
                    if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                        NioTcpMessageProcessor.logger.logDebug("Dead socketChannel" + socketChannel + " socket " + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort() + " : error message " + e.getMessage());
                    }
                    messageChannel.close();
                    queue.remove();
                    NioTcpMessageProcessor.this.pendingData.remove(socketChannel);
                    return;
                }
            }
            if (queue.isEmpty()) {
                if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTcpMessageProcessor.logger.logDebug("We wrote away all data. Setting READ interest. Queue is emtpy now size =" + queue.size());
                }
                selectionKey.interestOps(1);
            }
            if (NioTcpMessageProcessor.logger.isLoggingEnabled(32)) {
                NioTcpMessageProcessor.logger.logDebug("Done writing");
            }
        }
    }

    public NioTcpMessageProcessor(InetAddress inetAddress, SIPTransactionStack sIPTransactionStack, int i) {
        super(inetAddress, i, "TCP", sIPTransactionStack);
        this.changeRequests = new ConcurrentLinkedQueue();
        this.pendingData = Collections.synchronizedMap(new WeakHashMap());
        this.nioHandler = new NIOHandler(sIPTransactionStack, this);
    }

    private SocketChannel blockingConnect(InetSocketAddress inetSocketAddress, InetAddress inetAddress, int i) throws IOException {
        SocketChannel socketChannelOpen = SocketChannel.open();
        if (inetAddress != null) {
            socketChannelOpen.socket().bind(new InetSocketAddress(inetAddress, 0));
        }
        socketChannelOpen.configureBlocking(true);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Init connect " + inetSocketAddress);
        }
        socketChannelOpen.socket().connect(inetSocketAddress, i);
        socketChannelOpen.configureBlocking(false);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Blocking set to false now " + inetSocketAddress);
        }
        this.changeRequests.add(new ChangeRequest(socketChannelOpen, 1, 1));
        this.selector.wakeup();
        return socketChannelOpen;
    }

    private SocketChannel nonBlockingConnect(InetSocketAddress inetSocketAddress, InetAddress inetAddress, int i) throws IOException {
        SocketChannel socketChannelOpen = SocketChannel.open();
        socketChannelOpen.configureBlocking(false);
        if (inetAddress != null) {
            socketChannelOpen.socket().bind(new InetSocketAddress(inetAddress, 0));
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Init connect " + inetSocketAddress);
        }
        socketChannelOpen.connect(inetSocketAddress);
        this.changeRequests.add(new ChangeRequest(socketChannelOpen, 1, 8));
        return socketChannelOpen;
    }

    public SocketChannel connect(InetSocketAddress inetSocketAddress, InetAddress inetAddress, int i) {
        return this.sipStack.nioMode.equals(NIOMode.BLOCKING) ? blockingConnect(inetSocketAddress, inetAddress, i) : nonBlockingConnect(inetSocketAddress, inetAddress, i);
    }

    ConnectionOrientedMessageChannel constructMessageChannel(InetAddress inetAddress, int i) {
        return new NioTcpMessageChannel(inetAddress, i, this.sipStack, this);
    }

    public NioTcpMessageChannel createMessageChannel(NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) {
        NioTcpMessageChannel messageChannel = this.nioHandler.getMessageChannel(socketChannel);
        if (messageChannel == null) {
            messageChannel = new NioTcpMessageChannel(nioTcpMessageProcessor, socketChannel);
            this.nioHandler.putMessageChannel(socketChannel, messageChannel);
        }
        messageChannel.messageProcessor = nioTcpMessageProcessor;
        messageChannel.myClientInputStream = socketChannel.socket().getInputStream();
        return messageChannel;
    }

    protected ProcessorTask createProcessorTask() {
        return new ProcessorTask();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public int getDefaultTargetPort() {
        return SIPConstants.DEFAULT_PORT;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public boolean isSecure() {
        return false;
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageProcessor
    protected synchronized void remove(ConnectionOrientedMessageChannel connectionOrientedMessageChannel) {
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug(Thread.currentThread() + " removing " + ((NioTcpMessageChannel) connectionOrientedMessageChannel).getSocketChannel() + " from processor " + getIpAddress() + ":" + getPort() + Separators.SLASH + getTransport());
            }
            this.pendingData.remove(((NioTcpMessageChannel) connectionOrientedMessageChannel).getSocketChannel());
            super.remove(connectionOrientedMessageChannel);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void send(SocketChannel socketChannel, byte[] bArr) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Sending data " + bArr.length + " bytes on socket " + socketChannel);
        }
        Queue<PendingData> concurrentLinkedQueue = this.pendingData.get(socketChannel);
        if (concurrentLinkedQueue == null) {
            synchronized (socketChannel) {
                try {
                    if (this.pendingData.containsKey(socketChannel)) {
                        concurrentLinkedQueue = this.pendingData.get(socketChannel);
                    } else {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.pendingData.put(socketChannel, concurrentLinkedQueue);
                    }
                } finally {
                }
            }
        }
        concurrentLinkedQueue.add(new PendingData(MessageChannel.messageTxId.get(), ByteBuffer.wrap(bArr)));
        if (socketChannel.isConnected()) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Connected. lets set WRITE ops.");
            }
            this.changeRequests.add(new ChangeRequest(socketChannel, 2, 4));
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Waking up selector thread");
        }
        this.selector.wakeup();
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public void start() throws IOException {
        this.selector = Selector.open();
        ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
        this.channel = serverSocketChannelOpen;
        serverSocketChannelOpen.configureBlocking(false);
        this.channel.socket().bind(new InetSocketAddress(super.getIpAddress(), super.getPort()));
        this.channel.register(this.selector, 16);
        Thread thread = new Thread(createProcessorTask());
        this.selectorThread = thread;
        thread.start();
        this.selectorThread.setName("NioSelector-" + getTransport() + '-' + getIpAddress().getHostAddress() + '/' + getPort());
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public void stop() throws IOException {
        try {
            if (this.selector.isOpen()) {
                this.selector.close();
            }
            this.nioHandler.stop();
        } catch (Exception e) {
            logger.logError("Problem closing channel ", e);
        }
        try {
            this.channel.close();
        } catch (Exception e2) {
            logger.logError("Problem closing channel ", e2);
        }
    }

    private synchronized MessageChannel createMessageChannel(String str, InetAddress inetAddress, int i) {
        ConnectionOrientedMessageChannel connectionOrientedMessageChannelConstructMessageChannel;
        try {
            connectionOrientedMessageChannelConstructMessageChannel = this.messageChannels.get(str);
            if (connectionOrientedMessageChannelConstructMessageChannel == null) {
                connectionOrientedMessageChannelConstructMessageChannel = constructMessageChannel(inetAddress, i);
                this.messageChannels.put(str, connectionOrientedMessageChannelConstructMessageChannel);
                connectionOrientedMessageChannelConstructMessageChannel.isCached = true;
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("key " + str);
                    logger.logDebug("Creating " + connectionOrientedMessageChannelConstructMessageChannel);
                }
                if (this.sipStack.nioMode.equals(NIOMode.BLOCKING)) {
                    this.selector.wakeup();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return connectionOrientedMessageChannelConstructMessageChannel;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public MessageChannel createMessageChannel(HostPort hostPort) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("NioTcpMessageProcessor::createMessageChannel: " + hostPort);
        }
        MessageChannel messageChannel = null;
        try {
            String key = MessageChannel.getKey(hostPort, this.transport);
            ConnectionOrientedMessageChannel connectionOrientedMessageChannelCreateMessageChannel = this.messageChannels.get(key);
            if (connectionOrientedMessageChannelCreateMessageChannel == null) {
                try {
                    connectionOrientedMessageChannelCreateMessageChannel = createMessageChannel(key, hostPort.getInetAddress(), hostPort.getPort());
                } catch (Throwable th) {
                    th = th;
                    messageChannel = connectionOrientedMessageChannelCreateMessageChannel;
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("MessageChannel::createMessageChannel - exit " + messageChannel);
                    }
                    throw th;
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("MessageChannel::createMessageChannel - exit " + connectionOrientedMessageChannelCreateMessageChannel);
            }
            return connectionOrientedMessageChannelCreateMessageChannel;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageProcessor
    public MessageChannel createMessageChannel(InetAddress inetAddress, int i) {
        String key = MessageChannel.getKey(inetAddress, i, this.transport);
        ConnectionOrientedMessageChannel connectionOrientedMessageChannel = this.messageChannels.get(key);
        return connectionOrientedMessageChannel == null ? createMessageChannel(key, inetAddress, i) : connectionOrientedMessageChannel;
    }
}
