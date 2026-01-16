package jawnae.pyronet;

import ir.eitaa.tgnet.NativeByteBuffer;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class PyroClient {
    public int currentAccount;
    private boolean doEagerWrite;
    private boolean doShutdown;
    private final SelectionKey key;
    private long lastEventTime;
    private final List<PyroClientListener> listeners;
    private final ByteStream outbound;
    private final PyroSelector selector;
    private long timeout;

    PyroClient(PyroSelector selector, InetSocketAddress bind, InetSocketAddress host, int currentAccount) throws IOException {
        this(selector, bindAndConfigure(selector, SocketChannel.open(), bind));
        ((SocketChannel) this.key.channel()).connect(host);
        this.currentAccount = currentAccount;
    }

    PyroClient(PyroSelector selector, SelectionKey key) {
        this.doEagerWrite = false;
        this.doShutdown = false;
        this.timeout = 0L;
        this.selector = selector;
        selector.checkThread();
        this.key = key;
        key.attach(this);
        this.outbound = new ByteStream();
        this.listeners = new CopyOnWriteArrayList();
        this.lastEventTime = System.currentTimeMillis();
    }

    public void addListener(PyroClientListener listener) {
        this.selector.checkThread();
        this.listeners.add(listener);
    }

    public void removeListener(PyroClientListener listener) {
        this.selector.checkThread();
        this.listeners.remove(listener);
    }

    public PyroSelector selector() {
        return this.selector;
    }

    public InetSocketAddress getRemoteAddress() {
        return (InetSocketAddress) ((SocketChannel) this.key.channel()).socket().getRemoteSocketAddress();
    }

    public void setTimeout(int ms) throws IOException {
        this.selector.checkThread();
        ((SocketChannel) this.key.channel()).socket().setSoTimeout(ms);
        this.lastEventTime = System.currentTimeMillis();
        this.timeout = ms;
    }

    public void write(NativeByteBuffer data) throws PyroException {
        this.selector.checkThread();
        if (this.key.isValid()) {
            if (this.doShutdown) {
                throw new PyroException("shutting down");
            }
            this.outbound.append(data);
            if (this.doEagerWrite) {
                try {
                    onReadyToWrite(System.currentTimeMillis());
                    return;
                } catch (IOException e) {
                    onConnectionError(e);
                    this.key.cancel();
                    return;
                } catch (NotYetConnectedException unused) {
                    adjustWriteOp();
                    return;
                }
            }
            adjustWriteOp();
        }
    }

    public void dropConnection() {
        this.selector.checkThread();
        if (isDisconnected()) {
            return;
        }
        new Runnable() { // from class: jawnae.pyronet.PyroClient.1
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                try {
                    if (PyroClient.this.key.channel().isOpen()) {
                        PyroClient.this.key.channel().close();
                    }
                } catch (Exception unused) {
                    PyroClient.this.selector().scheduleTask(this);
                }
            }
        }.run();
        onConnectionError("local");
    }

    public boolean isDisconnected() {
        this.selector.checkThread();
        return !this.key.channel().isOpen();
    }

    void onInterestOp(long now) {
        if (!this.key.isValid()) {
            onConnectionError("remote");
            return;
        }
        try {
            if (this.key.isConnectable()) {
                onReadyToConnect(now);
            }
            if (this.key.isReadable()) {
                onReadyToRead(now);
            }
            if (this.key.isWritable()) {
                onReadyToWrite(now);
            }
        } catch (Exception e) {
            onConnectionError(e);
            this.key.cancel();
        }
    }

    boolean didTimeout(long now) {
        long j = this.timeout;
        return j != 0 && now - this.lastEventTime > j;
    }

    private void onReadyToConnect(long now) throws IOException {
        this.selector.checkThread();
        this.lastEventTime = now;
        this.selector.adjustInterestOp(this.key, 8, false);
        ((SocketChannel) this.key.channel()).finishConnect();
        Iterator<PyroClientListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().connectedClient(this);
        }
    }

    private void onReadyToRead(long now) throws IOException {
        this.selector.checkThread();
        this.lastEventTime = now;
        SocketChannel socketChannel = (SocketChannel) this.key.channel();
        ByteBuffer byteBuffer = this.selector.networkBuffer;
        byteBuffer.clear();
        if (socketChannel.read(byteBuffer) == -1) {
            throw new EOFException();
        }
        byteBuffer.flip();
        Iterator<PyroClientListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().receivedData(this, byteBuffer);
        }
    }

    private int onReadyToWrite(long now) throws IOException {
        this.selector.checkThread();
        ByteBuffer byteBuffer = this.selector.networkBuffer;
        byteBuffer.clear();
        this.outbound.get(byteBuffer);
        byteBuffer.flip();
        int iWrite = byteBuffer.hasRemaining() ? ((SocketChannel) this.key.channel()).write(byteBuffer) : 0;
        if (iWrite > 0) {
            this.outbound.discard(iWrite);
        }
        Iterator<PyroClientListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().sentData(this, iWrite);
        }
        adjustWriteOp();
        if (this.doShutdown && !this.outbound.hasData()) {
            dropConnection();
        }
        return iWrite;
    }

    void onConnectionError(final Object cause) {
        this.selector.checkThread();
        try {
            this.key.channel().close();
            if (cause instanceof ConnectException) {
                Iterator<PyroClientListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().unconnectableClient(this, (Exception) cause);
                }
                return;
            }
            if (cause instanceof EOFException) {
                Iterator<PyroClientListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().disconnectedClient(this);
                }
                return;
            }
            if (cause instanceof IOException) {
                Iterator<PyroClientListener> it3 = this.listeners.iterator();
                while (it3.hasNext()) {
                    it3.next().droppedClient(this, (IOException) cause);
                }
                return;
            }
            if (!(cause instanceof String)) {
                Iterator<PyroClientListener> it4 = this.listeners.iterator();
                while (it4.hasNext()) {
                    it4.next().unconnectableClient(this, null);
                }
            } else if (cause.equals("local")) {
                Iterator<PyroClientListener> it5 = this.listeners.iterator();
                while (it5.hasNext()) {
                    it5.next().disconnectedClient(this);
                }
            } else if (cause.equals("remote")) {
                Iterator<PyroClientListener> it6 = this.listeners.iterator();
                while (it6.hasNext()) {
                    it6.next().droppedClient(this, null);
                }
            } else {
                throw new IllegalStateException("illegal cause: " + cause);
            }
        } catch (Exception unused) {
            this.selector.scheduleTask(new Runnable() { // from class: jawnae.pyronet.PyroClient.2
                @Override // java.lang.Runnable
                public void run() {
                    PyroClient.this.onConnectionError(cause);
                }
            });
        }
    }

    public String toString() {
        return PyroClient.class.getSimpleName() + "[" + getAddressText() + "]";
    }

    private String getAddressText() {
        if (!this.key.channel().isOpen()) {
            return "closed";
        }
        InetSocketAddress remoteAddress = getRemoteAddress();
        if (remoteAddress == null) {
            return "connecting";
        }
        return remoteAddress.getAddress().getHostAddress() + "@" + remoteAddress.getPort();
    }

    void adjustWriteOp() {
        this.selector.checkThread();
        this.selector.adjustInterestOp(this.key, 4, this.outbound.hasData());
    }

    static SelectionKey bindAndConfigure(PyroSelector selector, SocketChannel channel, InetSocketAddress bind) throws IOException {
        selector.checkThread();
        channel.socket().bind(bind);
        return configure(selector, channel, true);
    }

    static SelectionKey configure(PyroSelector selector, SocketChannel channel, boolean connect) throws IOException {
        selector.checkThread();
        channel.configureBlocking(false);
        channel.socket().setSoLinger(true, 4);
        channel.socket().setReuseAddress(false);
        channel.socket().setKeepAlive(false);
        channel.socket().setTcpNoDelay(true);
        channel.socket().setReceiveBufferSize(65536);
        channel.socket().setSendBufferSize(65536);
        return selector.register(channel, connect ? 9 : 1);
    }
}
