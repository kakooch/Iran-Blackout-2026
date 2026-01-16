package com.neovisionaries.ws.client;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

/* loaded from: classes3.dex */
public class SocketInitiator {
    private final Address mAddress;
    private final int mConnectTimeout;
    private final int mFallbackDelay;
    private final DualStackMode mMode;
    private final String[] mServerNames;
    private final SocketFactory mSocketFactory;

    private class Signal {
        private final CountDownLatch mLatch = new CountDownLatch(1);
        private final int mMaxDelay;

        Signal(SocketInitiator socketInitiator, int i) {
            this.mMaxDelay = i;
        }

        boolean isDone() {
            return this.mLatch.getCount() == 0;
        }

        void await() throws InterruptedException {
            this.mLatch.await(this.mMaxDelay, TimeUnit.MILLISECONDS);
        }

        void done() {
            this.mLatch.countDown();
        }
    }

    private class SocketRacer extends Thread {
        private final int mConnectTimeout;
        private final Signal mDoneSignal;
        private final SocketFuture mFuture;
        private String[] mServerNames;
        private final SocketAddress mSocketAddress;
        private final SocketFactory mSocketFactory;
        private final Signal mStartSignal;

        SocketRacer(SocketInitiator socketInitiator, SocketFuture socketFuture, SocketFactory socketFactory, SocketAddress socketAddress, String[] strArr, int i, Signal signal, Signal signal2) {
            this.mFuture = socketFuture;
            this.mSocketFactory = socketFactory;
            this.mSocketAddress = socketAddress;
            this.mServerNames = strArr;
            this.mConnectTimeout = i;
            this.mStartSignal = signal;
            this.mDoneSignal = signal2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            Socket socketCreateSocket = null;
            try {
                Signal signal = this.mStartSignal;
                if (signal != null) {
                    signal.await();
                }
                if (this.mFuture.hasSocket()) {
                    return;
                }
                socketCreateSocket = this.mSocketFactory.createSocket();
                SNIHelper.setServerNames(socketCreateSocket, this.mServerNames);
                socketCreateSocket.connect(this.mSocketAddress, this.mConnectTimeout);
                complete(socketCreateSocket);
            } catch (Exception e) {
                abort(e);
                if (socketCreateSocket != null) {
                    try {
                        socketCreateSocket.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        private void complete(Socket socket) {
            synchronized (this.mFuture) {
                if (this.mDoneSignal.isDone()) {
                    return;
                }
                this.mFuture.setSocket(this, socket);
                this.mDoneSignal.done();
            }
        }

        void abort(Exception exc) {
            synchronized (this.mFuture) {
                if (this.mDoneSignal.isDone()) {
                    return;
                }
                this.mFuture.setException(exc);
                this.mDoneSignal.done();
            }
        }
    }

    private class SocketFuture {
        private Exception mException;
        private CountDownLatch mLatch;
        private List<SocketRacer> mRacers;
        private Socket mSocket;

        private SocketFuture(SocketInitiator socketInitiator) {
        }

        synchronized boolean hasSocket() {
            return this.mSocket != null;
        }

        synchronized void setSocket(SocketRacer socketRacer, Socket socket) {
            List<SocketRacer> list;
            if (this.mLatch == null || (list = this.mRacers) == null) {
                throw new IllegalStateException("Cannot set socket before awaiting!");
            }
            if (this.mSocket == null) {
                this.mSocket = socket;
                for (SocketRacer socketRacer2 : list) {
                    if (socketRacer2 != socketRacer) {
                        socketRacer2.abort(new InterruptedException());
                        socketRacer2.interrupt();
                    }
                }
            } else {
                try {
                    socket.close();
                } catch (IOException unused) {
                }
            }
            this.mLatch.countDown();
        }

        synchronized void setException(Exception exc) {
            CountDownLatch countDownLatch = this.mLatch;
            if (countDownLatch == null || this.mRacers == null) {
                throw new IllegalStateException("Cannot set exception before awaiting!");
            }
            if (this.mException == null) {
                this.mException = exc;
            }
            countDownLatch.countDown();
        }

        Socket await(List<SocketRacer> list) throws Exception {
            this.mRacers = list;
            this.mLatch = new CountDownLatch(this.mRacers.size());
            Iterator<SocketRacer> it = this.mRacers.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
            this.mLatch.await();
            Socket socket = this.mSocket;
            if (socket != null) {
                return socket;
            }
            Exception exc = this.mException;
            if (exc != null) {
                throw exc;
            }
            throw new WebSocketException(WebSocketError.SOCKET_CONNECT_ERROR, "No viable interface to connect");
        }
    }

    public SocketInitiator(SocketFactory socketFactory, Address address, int i, String[] strArr, DualStackMode dualStackMode, int i2) {
        this.mSocketFactory = socketFactory;
        this.mAddress = address;
        this.mConnectTimeout = i;
        this.mServerNames = strArr;
        this.mMode = dualStackMode;
        this.mFallbackDelay = i2;
    }

    public Socket establish(InetAddress[] inetAddressArr) throws Exception {
        SocketInitiator socketInitiator = this;
        SocketFuture socketFuture = new SocketFuture();
        ArrayList arrayList = new ArrayList(inetAddressArr.length);
        int length = inetAddressArr.length;
        int i = 0;
        Signal signal = null;
        int i2 = 0;
        while (i2 < length) {
            InetAddress inetAddress = inetAddressArr[i2];
            DualStackMode dualStackMode = socketInitiator.mMode;
            if ((dualStackMode != DualStackMode.IPV4_ONLY || (inetAddress instanceof Inet4Address)) && (dualStackMode != DualStackMode.IPV6_ONLY || (inetAddress instanceof Inet6Address))) {
                int i3 = i + socketInitiator.mFallbackDelay;
                Signal signal2 = new Signal(socketInitiator, i3);
                arrayList.add(new SocketRacer(this, socketFuture, socketInitiator.mSocketFactory, new InetSocketAddress(inetAddress, socketInitiator.mAddress.getPort()), socketInitiator.mServerNames, socketInitiator.mConnectTimeout, signal, signal2));
                i = i3;
                signal = signal2;
            }
            i2++;
            socketInitiator = this;
        }
        return socketFuture.await(arrayList);
    }
}
