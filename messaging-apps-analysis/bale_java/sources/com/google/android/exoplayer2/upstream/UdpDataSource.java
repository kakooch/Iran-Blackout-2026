package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import ir.nasim.AbstractC20011rK;
import ir.nasim.G90;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: classes2.dex */
public final class UdpDataSource extends G90 {
    private final int e;
    private final byte[] f;
    private final DatagramPacket g;
    private Uri h;
    private DatagramSocket i;
    private MulticastSocket j;
    private InetAddress k;
    private boolean l;
    private int m;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i) {
            super(th, i);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(b bVar) throws IOException {
        Uri uri = bVar.a;
        this.h = uri;
        String str = (String) AbstractC20011rK.e(uri.getHost());
        int port = this.h.getPort();
        p(bVar);
        try {
            this.k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.k, port);
            if (this.k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.j = multicastSocket;
                multicastSocket.joinGroup(this.k);
                this.i = this.j;
            } else {
                this.i = new DatagramSocket(inetSocketAddress);
            }
            this.i.setSoTimeout(this.e);
            this.l = true;
            q(bVar);
            return -1L;
        } catch (IOException e) {
            throw new UdpDataSourceException(e, 2001);
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, 2006);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.h = null;
        MulticastSocket multicastSocket = this.j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) AbstractC20011rK.e(this.k));
            } catch (IOException unused) {
            }
            this.j = null;
        }
        DatagramSocket datagramSocket = this.i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.i = null;
        }
        this.k = null;
        this.m = 0;
        if (this.l) {
            this.l = false;
            o();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.m == 0) {
            try {
                ((DatagramSocket) AbstractC20011rK.e(this.i)).receive(this.g);
                int length = this.g.getLength();
                this.m = length;
                n(length);
            } catch (SocketTimeoutException e) {
                throw new UdpDataSourceException(e, 2002);
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2, 2001);
            }
        }
        int length2 = this.g.getLength();
        int i3 = this.m;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.f, length2 - i3, bArr, i, iMin);
        this.m -= iMin;
        return iMin;
    }

    public UdpDataSource(int i) {
        this(i, 8000);
    }

    public UdpDataSource(int i, int i2) {
        super(true);
        this.e = i2;
        byte[] bArr = new byte[i];
        this.f = bArr;
        this.g = new DatagramPacket(bArr, 0, i);
    }
}
