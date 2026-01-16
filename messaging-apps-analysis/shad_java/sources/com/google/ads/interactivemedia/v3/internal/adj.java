package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adj extends abr {
    private final int a;
    private final byte[] b;
    private final DatagramPacket c;
    private Uri d;
    private DatagramSocket e;
    private MulticastSocket f;
    private InetAddress g;
    private InetSocketAddress h;
    private boolean i;
    private int j;

    public adj() {
        super(true);
        this.a = 8000;
        byte[] bArr = new byte[2000];
        this.b = bArr;
        this.c = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.j == 0) {
            try {
                this.e.receive(this.c);
                int length = this.c.getLength();
                this.j = length;
                i(length);
            } catch (IOException e) {
                throw new adi(e);
            }
        }
        int length2 = this.c.getLength();
        int i3 = this.j;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.b, length2 - i3, bArr, i, iMin);
        this.j -= iMin;
        return iMin;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        Uri uri = acbVar.a;
        this.d = uri;
        String host = uri.getHost();
        int port = this.d.getPort();
        g(acbVar);
        try {
            this.g = InetAddress.getByName(host);
            this.h = new InetSocketAddress(this.g, port);
            if (this.g.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.h);
                this.f = multicastSocket;
                multicastSocket.joinGroup(this.g);
                this.e = this.f;
            } else {
                this.e = new DatagramSocket(this.h);
            }
            try {
                this.e.setSoTimeout(8000);
                this.i = true;
                h(acbVar);
                return -1L;
            } catch (SocketException e) {
                throw new adi(e);
            }
        } catch (IOException e2) {
            throw new adi(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws IOException {
        this.d = null;
        MulticastSocket multicastSocket = this.f;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.g);
            } catch (IOException unused) {
            }
            this.f = null;
        }
        DatagramSocket datagramSocket = this.e;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.e = null;
        }
        this.g = null;
        this.h = null;
        this.j = 0;
        if (this.i) {
            this.i = false;
            j();
        }
    }
}
