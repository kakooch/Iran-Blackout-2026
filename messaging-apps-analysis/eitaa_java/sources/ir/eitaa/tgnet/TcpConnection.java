package ir.eitaa.tgnet;

import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import jawnae.pyronet.PyroClient;
import jawnae.pyronet.PyroException;
import jawnae.pyronet.PyroSelector;

/* loaded from: classes.dex */
public class TcpConnection extends ConnectionContext {
    private PyroClient client;
    public TcpConnectionState connectionState;
    private int currentAccount;
    private int currentAddressFlag;
    private int datacenterId;
    public TcpConnectionDelegate delegate;
    private int failedConnectionCount;
    private boolean firstPacket;
    private String hostAddress;
    private int hostPort;
    private int lastPacketLength;
    private Timer reconnectTimer;
    private NativeByteBuffer restOfTheData;
    public int transportRequestClass;
    private boolean wasConnected;
    private static PyroSelector[] selector = new PyroSelector[3];
    static volatile Integer nextChannelToken = 1;
    public volatile int channelToken = 0;
    private boolean hasSomeDataSinceLastConnect = false;
    private int willRetryConnectCount = 5;
    private boolean isNextPort = false;
    private final Object timerSync = new Object();

    public interface TcpConnectionDelegate {
        void tcpConnectionClosed(TcpConnection connection);

        void tcpConnectionConnected(TcpConnection connection);

        void tcpConnectionReceivedData(TcpConnection connection, NativeByteBuffer data, int length);
    }

    public enum TcpConnectionState {
        TcpConnectionStageIdle,
        TcpConnectionStageConnecting,
        TcpConnectionStageReconnecting,
        TcpConnectionStageConnected,
        TcpConnectionStageSuspended
    }

    @Override // jawnae.pyronet.PyroClientListener
    public void sentData(PyroClient client, int bytes) {
    }

    public TcpConnection(int did, int currentAccount) {
        PyroSelector[] pyroSelectorArr = selector;
        if (pyroSelectorArr[currentAccount] == null) {
            pyroSelectorArr[currentAccount] = new PyroSelector(currentAccount);
            selector[currentAccount].spawnNetworkThread("network thread");
            BuffersStorage.getInstance();
        }
        this.datacenterId = did;
        this.connectionState = TcpConnectionState.TcpConnectionStageIdle;
        this.currentAccount = currentAccount;
    }

    static int generateChannelToken() {
        Integer num = nextChannelToken;
        nextChannelToken = Integer.valueOf(nextChannelToken.intValue() + 1);
        return num.intValue();
    }

    public int getDatacenterId() {
        return this.datacenterId;
    }

    public void connect() {
        if (!ConnectionsManager.isNetworkOnline()) {
            final TcpConnectionDelegate tcpConnectionDelegate = this.delegate;
            if (tcpConnectionDelegate != null) {
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tcpConnectionDelegate.tcpConnectionClosed(TcpConnection.this);
                    }
                });
                return;
            }
            return;
        }
        selector[this.currentAccount].scheduleTask(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                TcpConnection tcpConnection = TcpConnection.this;
                TcpConnectionState tcpConnectionState = tcpConnection.connectionState;
                if ((tcpConnectionState == TcpConnectionState.TcpConnectionStageConnected || tcpConnectionState == TcpConnectionState.TcpConnectionStageConnecting) && tcpConnection.client != null) {
                    return;
                }
                TcpConnection.this.connectionState = TcpConnectionState.TcpConnectionStageConnecting;
                try {
                    DataCenter dataCenterDatacenterWithId = ConnectionsManager.getInstance(UserConfig.selectedAccount).datacenterWithId(TcpConnection.this.datacenterId);
                    boolean zUseIpv6Address = ConnectionsManager.useIpv6Address();
                    TcpConnection tcpConnection2 = TcpConnection.this;
                    int i = tcpConnection2.transportRequestClass;
                    if (i == 16) {
                        tcpConnection2.currentAddressFlag = 16;
                        TcpConnection tcpConnection3 = TcpConnection.this;
                        tcpConnection3.hostAddress = dataCenterDatacenterWithId.getCurrentAddress(tcpConnection3.currentAddressFlag | (zUseIpv6Address ? 1 : 0));
                        if (TcpConnection.this.hostAddress == null) {
                            TcpConnection.this.currentAddressFlag = 0;
                            TcpConnection tcpConnection4 = TcpConnection.this;
                            tcpConnection4.hostAddress = dataCenterDatacenterWithId.getCurrentAddress((zUseIpv6Address ? 1 : 0) | tcpConnection4.currentAddressFlag);
                        }
                    } else if (i == 32) {
                        tcpConnection2.currentAddressFlag = 32;
                        TcpConnection tcpConnection5 = TcpConnection.this;
                        tcpConnection5.hostAddress = dataCenterDatacenterWithId.getCurrentAddress(tcpConnection5.currentAddressFlag | (zUseIpv6Address ? 1 : 0));
                        if (zUseIpv6Address && TcpConnection.this.hostAddress == null) {
                            TcpConnection tcpConnection6 = TcpConnection.this;
                            tcpConnection6.hostAddress = dataCenterDatacenterWithId.getCurrentAddress(tcpConnection6.currentAddressFlag);
                        }
                    } else {
                        tcpConnection2.currentAddressFlag = 64;
                        TcpConnection tcpConnection7 = TcpConnection.this;
                        tcpConnection7.hostAddress = dataCenterDatacenterWithId.getCurrentAddress(tcpConnection7.currentAddressFlag | (zUseIpv6Address ? 1 : 0));
                        if (zUseIpv6Address && TcpConnection.this.hostAddress == null) {
                            TcpConnection tcpConnection8 = TcpConnection.this;
                            tcpConnection8.hostAddress = dataCenterDatacenterWithId.getCurrentAddress(tcpConnection8.currentAddressFlag);
                        }
                    }
                    TcpConnection tcpConnection9 = TcpConnection.this;
                    tcpConnection9.hostPort = dataCenterDatacenterWithId.getCurrentPort(tcpConnection9.currentAddressFlag);
                    try {
                        synchronized (TcpConnection.this.timerSync) {
                            if (TcpConnection.this.reconnectTimer != null) {
                                TcpConnection.this.reconnectTimer.cancel();
                                TcpConnection.this.reconnectTimer = null;
                            }
                        }
                    } catch (Exception e) {
                        FileLog.e("tmessages", e);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("tmessages");
                    sb.append(String.format(TcpConnection.this + " Connecting (%s:%d), connection class %d", TcpConnection.this.hostAddress, Integer.valueOf(TcpConnection.this.hostPort), Integer.valueOf(TcpConnection.this.transportRequestClass)));
                    FileLog.d(sb.toString());
                    TcpConnection.this.firstPacket = true;
                    if (TcpConnection.this.restOfTheData != null) {
                        BuffersStorage.getInstance().reuseFreeBuffer(TcpConnection.this.restOfTheData);
                        TcpConnection.this.restOfTheData = null;
                    }
                    TcpConnection.this.lastPacketLength = 0;
                    TcpConnection.this.wasConnected = false;
                    TcpConnection.this.hasSomeDataSinceLastConnect = false;
                    if (TcpConnection.this.client != null) {
                        TcpConnection.this.client.removeListener(TcpConnection.this);
                        TcpConnection.this.client.dropConnection();
                        TcpConnection.this.client = null;
                    }
                    TcpConnection.this.client = TcpConnection.selector[TcpConnection.this.currentAccount].connect(new InetSocketAddress(TcpConnection.this.hostAddress, TcpConnection.this.hostPort));
                    TcpConnection.this.client.addListener(TcpConnection.this);
                    TcpConnection tcpConnection10 = TcpConnection.this;
                    if ((tcpConnection10.transportRequestClass & 8) != 0) {
                        tcpConnection10.client.setTimeout(23000);
                    } else {
                        tcpConnection10.client.setTimeout(23000);
                    }
                    TcpConnection.selector[TcpConnection.this.currentAccount].wakeup();
                } catch (Exception e2) {
                    TcpConnection.this.handleConnectionError(e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectionError(Exception e) throws IOException {
        try {
            synchronized (this.timerSync) {
                Timer timer = this.reconnectTimer;
                if (timer != null) {
                    timer.cancel();
                    this.reconnectTimer = null;
                }
            }
        } catch (Exception e2) {
            FileLog.e("tmessages", e2);
        }
        this.connectionState = TcpConnectionState.TcpConnectionStageReconnecting;
        final TcpConnectionDelegate tcpConnectionDelegate = this.delegate;
        if (tcpConnectionDelegate != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.3
                @Override // java.lang.Runnable
                public void run() {
                    tcpConnectionDelegate.tcpConnectionClosed(TcpConnection.this);
                }
            });
        }
        int i = this.failedConnectionCount + 1;
        this.failedConnectionCount = i;
        if (i == 1) {
            if (this.hasSomeDataSinceLastConnect) {
                this.willRetryConnectCount = 3;
            } else {
                this.willRetryConnectCount = 1;
            }
        }
        if (ConnectionsManager.isNetworkOnline()) {
            this.isNextPort = true;
            if (this.failedConnectionCount > this.willRetryConnectCount) {
                ConnectionsManager.getInstance(UserConfig.selectedAccount).datacenterWithId(this.datacenterId).nextAddress(this.currentAddressFlag);
                this.failedConnectionCount = 0;
            }
        }
        if (e != null) {
            FileLog.e("tmessages", e);
        }
        FileLog.d("tmessages - Reconnect " + this.hostAddress + ":" + this.hostPort + " " + this);
        try {
            Timer timer2 = new Timer();
            this.reconnectTimer = timer2;
            TimerTask timerTask = new TimerTask() { // from class: ir.eitaa.tgnet.TcpConnection.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() throws InterruptedException {
                    TcpConnection.selector[TcpConnection.this.currentAccount].scheduleTask(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.4.1
                        @Override // java.lang.Runnable
                        public void run() throws IOException {
                            try {
                                synchronized (TcpConnection.this.timerSync) {
                                    if (TcpConnection.this.reconnectTimer != null) {
                                        TcpConnection.this.reconnectTimer.cancel();
                                        TcpConnection.this.reconnectTimer = null;
                                    }
                                }
                            } catch (Exception e3) {
                                FileLog.e("tmessages", e3);
                            }
                            TcpConnection.this.connect();
                        }
                    });
                }
            };
            int i2 = this.failedConnectionCount;
            long j = 500;
            long j2 = i2 >= 3 ? 500L : 300L;
            if (i2 < 3) {
                j = 300;
            }
            timer2.schedule(timerTask, j2, j);
        } catch (Exception e3) {
            FileLog.e("tmessages", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suspendConnectionInternal() {
        TcpConnectionState tcpConnectionState;
        synchronized (this.timerSync) {
            Timer timer = this.reconnectTimer;
            if (timer != null) {
                timer.cancel();
                this.reconnectTimer = null;
            }
        }
        TcpConnectionState tcpConnectionState2 = this.connectionState;
        if (tcpConnectionState2 == TcpConnectionState.TcpConnectionStageIdle || tcpConnectionState2 == (tcpConnectionState = TcpConnectionState.TcpConnectionStageSuspended)) {
            return;
        }
        FileLog.d("tmessages - suspend connnection " + this);
        this.connectionState = tcpConnectionState;
        PyroClient pyroClient = this.client;
        if (pyroClient != null) {
            pyroClient.removeListener(this);
            this.client.dropConnection();
            this.client = null;
        }
        final TcpConnectionDelegate tcpConnectionDelegate = this.delegate;
        if (tcpConnectionDelegate != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.5
                @Override // java.lang.Runnable
                public void run() {
                    tcpConnectionDelegate.tcpConnectionClosed(TcpConnection.this);
                }
            });
        }
        this.firstPacket = true;
        if (this.restOfTheData != null) {
            BuffersStorage.getInstance().reuseFreeBuffer(this.restOfTheData);
            this.restOfTheData = null;
        }
        this.lastPacketLength = 0;
        this.channelToken = 0;
        this.wasConnected = false;
    }

    public void suspendConnection(boolean task) {
        if (task) {
            selector[this.currentAccount].scheduleTask(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.6
                @Override // java.lang.Runnable
                public void run() {
                    TcpConnection.this.suspendConnectionInternal();
                }
            });
        } else {
            suspendConnectionInternal();
        }
    }

    private void reconnect() {
        suspendConnection(false);
        this.connectionState = TcpConnectionState.TcpConnectionStageReconnecting;
        connect();
    }

    public void sendData(final NativeByteBuffer buff, final boolean canReuse, final boolean reportAck) {
        if (buff == null) {
            return;
        }
        selector[this.currentAccount].scheduleTask(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.7
            @Override // java.lang.Runnable
            public void run() throws PyroException {
                TcpConnection tcpConnection = TcpConnection.this;
                TcpConnectionState tcpConnectionState = tcpConnection.connectionState;
                if (tcpConnectionState == TcpConnectionState.TcpConnectionStageIdle || tcpConnectionState == TcpConnectionState.TcpConnectionStageReconnecting || tcpConnectionState == TcpConnectionState.TcpConnectionStageSuspended || tcpConnection.client == null) {
                    TcpConnection.this.connect();
                }
                if (TcpConnection.this.client == null || TcpConnection.this.client.isDisconnected()) {
                    if (canReuse) {
                        BuffersStorage.getInstance().reuseFreeBuffer(buff);
                    }
                } else {
                    buff.rewind();
                    TcpConnection.this.client.write(buff);
                    if (canReuse) {
                        BuffersStorage.getInstance().reuseFreeBuffer(buff);
                    }
                }
            }
        });
    }

    private void readData(ByteBuffer buffer) throws Exception {
        int iLimit;
        NativeByteBuffer nativeByteBuffer = this.restOfTheData;
        if (nativeByteBuffer != null) {
            int i = this.lastPacketLength;
            if (i == 0) {
                if (nativeByteBuffer.capacity() - this.restOfTheData.position() >= buffer.limit()) {
                    NativeByteBuffer nativeByteBuffer2 = this.restOfTheData;
                    nativeByteBuffer2.limit(nativeByteBuffer2.position() + buffer.limit());
                    this.restOfTheData.put(buffer);
                    buffer = this.restOfTheData.buffer;
                } else {
                    NativeByteBuffer freeBuffer = BuffersStorage.getInstance().getFreeBuffer(this.restOfTheData.limit() + buffer.limit());
                    this.restOfTheData.rewind();
                    freeBuffer.put(this.restOfTheData.buffer);
                    freeBuffer.put(buffer);
                    buffer = freeBuffer.buffer;
                    BuffersStorage.getInstance().reuseFreeBuffer(this.restOfTheData);
                    this.restOfTheData = freeBuffer;
                }
            } else {
                if (i - nativeByteBuffer.position() <= buffer.limit()) {
                    iLimit = this.lastPacketLength - this.restOfTheData.position();
                } else {
                    iLimit = buffer.limit();
                }
                int iLimit2 = buffer.limit();
                buffer.limit(iLimit);
                this.restOfTheData.put(buffer);
                buffer.limit(iLimit2);
                if (this.restOfTheData.position() != this.lastPacketLength) {
                    return;
                }
                buffer.hasRemaining();
                buffer = this.restOfTheData.buffer;
            }
        }
        buffer.rewind();
        while (buffer.hasRemaining()) {
            if (!this.hasSomeDataSinceLastConnect) {
                ConnectionsManager.getInstance(UserConfig.selectedAccount).datacenterWithId(this.datacenterId).storeCurrentAddressAndPortNum();
                this.isNextPort = false;
                this.client.setTimeout(23000);
            }
            this.hasSomeDataSinceLastConnect = true;
            if (this.delegate != null) {
                int iLimit3 = buffer.limit();
                final byte[] bArr = new byte[iLimit3];
                buffer.get(bArr);
                final NativeByteBuffer nativeByteBuffer3 = new NativeByteBuffer(iLimit3);
                nativeByteBuffer3.writeBytes(bArr);
                nativeByteBuffer3.rewind();
                final TcpConnectionDelegate tcpConnectionDelegate = this.delegate;
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.8
                    @Override // java.lang.Runnable
                    public void run() {
                        tcpConnectionDelegate.tcpConnectionReceivedData(TcpConnection.this, nativeByteBuffer3, bArr.length);
                        BuffersStorage.getInstance().reuseFreeBuffer(nativeByteBuffer3);
                    }
                });
            }
        }
    }

    public void handleDisconnect(PyroClient client, Exception e, boolean timedout) throws IOException {
        TcpConnectionState tcpConnectionState;
        synchronized (this.timerSync) {
            Timer timer = this.reconnectTimer;
            if (timer != null) {
                timer.cancel();
                this.reconnectTimer = null;
            }
        }
        if (e != null) {
            FileLog.d("tmessages - Disconnected " + this + " with error " + e);
        } else {
            FileLog.d("tmessages - Disconnected " + this);
        }
        boolean z = this.wasConnected && !this.hasSomeDataSinceLastConnect && timedout;
        this.firstPacket = true;
        if (this.restOfTheData != null) {
            BuffersStorage.getInstance().reuseFreeBuffer(this.restOfTheData);
            this.restOfTheData = null;
        }
        this.channelToken = 0;
        this.lastPacketLength = 0;
        this.wasConnected = false;
        TcpConnectionState tcpConnectionState2 = this.connectionState;
        if (tcpConnectionState2 != TcpConnectionState.TcpConnectionStageSuspended && tcpConnectionState2 != (tcpConnectionState = TcpConnectionState.TcpConnectionStageIdle)) {
            this.connectionState = tcpConnectionState;
        }
        final TcpConnectionDelegate tcpConnectionDelegate = this.delegate;
        if (tcpConnectionDelegate != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.9
                @Override // java.lang.Runnable
                public void run() {
                    tcpConnectionDelegate.tcpConnectionClosed(TcpConnection.this);
                }
            });
        }
        if (this.connectionState == TcpConnectionState.TcpConnectionStageIdle && (this.transportRequestClass & 64) != 0 && this.datacenterId == ConnectionsManager.getInstance(UserConfig.selectedAccount).currentDatacenterId) {
            int i = this.failedConnectionCount + 1;
            this.failedConnectionCount = i;
            if (i == 1) {
                if (this.hasSomeDataSinceLastConnect) {
                    this.willRetryConnectCount = 5;
                } else {
                    this.willRetryConnectCount = 1;
                }
            }
            if (ConnectionsManager.isNetworkOnline()) {
                this.isNextPort = true;
                if (this.failedConnectionCount > this.willRetryConnectCount || z) {
                    ConnectionsManager.getInstance(UserConfig.selectedAccount).datacenterWithId(this.datacenterId).nextAddress(this.currentAddressFlag);
                    this.failedConnectionCount = 0;
                }
            }
            FileLog.d("tmessages - Reconnect " + this.hostAddress + ":" + this.hostPort + " " + this);
            try {
                synchronized (this.timerSync) {
                    Timer timer2 = new Timer();
                    this.reconnectTimer = timer2;
                    TimerTask timerTask = new TimerTask() { // from class: ir.eitaa.tgnet.TcpConnection.10
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() throws InterruptedException {
                            TcpConnection.selector[TcpConnection.this.currentAccount].scheduleTask(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.10.1
                                @Override // java.lang.Runnable
                                public void run() throws IOException {
                                    try {
                                        synchronized (TcpConnection.this.timerSync) {
                                            if (TcpConnection.this.reconnectTimer != null) {
                                                TcpConnection.this.reconnectTimer.cancel();
                                                TcpConnection.this.reconnectTimer = null;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        FileLog.e("tmessages", e2);
                                    }
                                    TcpConnection.this.connect();
                                }
                            });
                        }
                    };
                    int i2 = this.failedConnectionCount;
                    timer2.schedule(timerTask, i2 > 3 ? 500L : 300L, i2 > 3 ? 500L : 300L);
                }
            } catch (Exception e2) {
                FileLog.e("tmessages", e2);
            }
        }
    }

    @Override // jawnae.pyronet.PyroClientListener
    public void connectedClient(PyroClient client) {
        this.connectionState = TcpConnectionState.TcpConnectionStageConnected;
        this.channelToken = generateChannelToken();
        this.wasConnected = true;
        StringBuilder sb = new StringBuilder();
        sb.append("tmessages - ");
        sb.append(String.format(this + " Connected (%s:%d)", this.hostAddress, Integer.valueOf(this.hostPort)));
        FileLog.d(sb.toString());
        final TcpConnectionDelegate tcpConnectionDelegate = this.delegate;
        if (tcpConnectionDelegate != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.TcpConnection.11
                @Override // java.lang.Runnable
                public void run() {
                    tcpConnectionDelegate.tcpConnectionConnected(TcpConnection.this);
                }
            });
        }
    }

    @Override // jawnae.pyronet.PyroClientListener
    public void unconnectableClient(PyroClient client, Exception cause) throws IOException {
        handleDisconnect(client, cause, false);
    }

    @Override // jawnae.pyronet.PyroClientAdapter, jawnae.pyronet.PyroClientListener
    public void droppedClient(PyroClient client, IOException cause) throws IOException {
        super.droppedClient(client, cause);
        handleDisconnect(client, cause, cause instanceof SocketTimeoutException);
    }

    @Override // jawnae.pyronet.PyroClientListener
    public void disconnectedClient(PyroClient client) throws IOException {
        handleDisconnect(client, null, false);
    }

    @Override // jawnae.pyronet.PyroClientListener
    public void receivedData(PyroClient client, ByteBuffer data) throws IOException {
        try {
            this.failedConnectionCount = 0;
            readData(data);
        } catch (Exception e) {
            FileLog.e("tmessages", e);
            reconnect();
        }
    }
}
