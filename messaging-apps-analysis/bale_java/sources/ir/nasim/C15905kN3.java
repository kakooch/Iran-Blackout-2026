package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC16050kd1;
import ir.nasim.core.network.dns.model.DnsResolution;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* renamed from: ir.nasim.kN3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15905kN3 implements InterfaceC16050kd1 {
    private static final Random v = new Random();
    private final BK a;
    private final C11947dp0 b;
    private final String c;
    private final AbstractC24857zK d;
    private final InterfaceC17232md1 e;
    private final InterfaceC17087mN3 f;
    private final int g;
    private final int h;
    private final int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private byte[] o;
    private DnsResolution p;
    private C10054b01 q;
    private C10054b01 r;
    private C10054b01 s;
    private final HashMap t;
    private final HashMap u;

    /* renamed from: ir.nasim.kN3$a */
    private class a implements BK {
        @Override // ir.nasim.BK
        public void a() {
            C15905kN3.this.q();
        }

        @Override // ir.nasim.BK
        public void b(DnsResolution dnsResolution) {
            C15905kN3.this.r(dnsResolution);
        }

        @Override // ir.nasim.BK
        public void c(byte[] bArr) {
            C15905kN3.this.s(bArr);
        }

        private a() {
        }
    }

    /* renamed from: ir.nasim.kN3$b */
    public static class b {
        private InterfaceC16050kd1.a a;

        public b(InterfaceC16050kd1.a aVar) {
            this.a = aVar;
        }

        public InterfaceC16050kd1.a a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.kN3$c */
    private class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            C15905kN3.this.y();
        }

        private c() {
        }
    }

    /* renamed from: ir.nasim.kN3$d */
    private class d implements Runnable {
        private String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C19406qI3.j("ConnectionLog", C15905kN3.this.c + ":Timeout " + this.a + " Going close connection from ManagedConnection", new Object[0]);
            C15905kN3.this.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C15905kN3(int i, int i2, int i3, int i4, ConnectionEndpoint connectionEndpoint, InterfaceC17232md1 interfaceC17232md1, InterfaceC17087mN3 interfaceC17087mN3, AK ak) {
        a aVar = new a();
        this.a = aVar;
        this.b = new C11947dp0();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.t = new HashMap();
        this.u = new HashMap();
        String str = "Connection#" + i;
        this.c = str;
        C19406qI3.a("ConnectionLog", str + ": ManagedConnection constructor begin", new Object[0]);
        this.g = i2;
        this.h = i3;
        this.i = i4;
        this.e = interfaceC17232md1;
        this.f = interfaceC17087mN3;
        C19406qI3.a("ConnectionLog", str + ": ManagedConnection connectionFactory.createConnection", new Object[0]);
        AbstractC24857zK abstractC24857zKA = ak.a(i, connectionEndpoint, aVar);
        this.d = abstractC24857zKA;
        C19406qI3.a("ConnectionLog", str + ": ManagedConnection create and schedule timers", new Object[0]);
        this.r = new C10054b01(new d("handshakeTimeout"));
        this.s = new C10054b01(new c());
        C10054b01 c10054b01 = new C10054b01(new d("connectionTimeout"));
        this.q = c10054b01;
        c10054b01.d(15000L);
        C19406qI3.a("ConnectionLog", str + ": ManagedConnection rawConnection.doConnect()", new Object[0]);
        abstractC24857zKA.b();
        C19406qI3.a("ConnectionLog", str + ": ManagedConnection constructor end", new Object[0]);
    }

    private void A() {
        DnsResolution dnsResolution = this.p;
        if (dnsResolution == null) {
            return;
        }
        this.p = null;
        try {
            j().a(dnsResolution.getHost(), dnsResolution.getAddresses());
        } catch (Exception e) {
            C19406qI3.c("DnsResolver", "Failed to verify " + dnsResolution, e);
        }
    }

    private synchronized void i(InterfaceC16050kd1.a aVar) {
        if (this.l) {
            C19406qI3.j("ConnectionLog", this.c + ": return from close connection because isClosed = true", new Object[0]);
            return;
        }
        this.l = true;
        this.p = null;
        try {
            synchronized (this.u) {
                try {
                    Iterator it = this.u.keySet().iterator();
                    while (it.hasNext()) {
                        ((C10054b01) this.u.get((Integer) it.next())).a();
                    }
                    Iterator it2 = this.t.keySet().iterator();
                    while (it2.hasNext()) {
                        ((C10054b01) this.t.get((Long) it2.next())).a();
                    }
                    this.t.clear();
                    this.u.clear();
                } finally {
                }
            }
            this.s.a();
            this.q.a();
            this.r.a();
        } catch (Exception e) {
            C19406qI3.c("ConnectionLog", this.c + ": Problem accrued in synchronized block : ", e);
        }
        C19406qI3.a("ConnectionLog", this.c + ": reach end of synchronized block", new Object[0]);
        try {
            if (this.m && this.n) {
                C19406qI3.a("ConnectionLog", this.c + ": call callback.onConnectionDie because isOpened and isHandshakePerformed are true", new Object[0]);
                this.e.b(aVar);
            } else {
                C19406qI3.a("ConnectionLog", this.c + ": call factoryCallback.onConnectionCreateError because isOpened = " + this.m + " and isHandshakePerformed = " + this.n, new Object[0]);
                this.f.a(this, aVar);
            }
        } catch (Exception e2) {
            C19406qI3.c("ConnectionLog", this.c + ": Problem accrued in calling callbacks block : ", e2);
        }
        C19406qI3.a("ConnectionLog", this.c + ": reach end of calling callbacks block", new Object[0]);
        try {
            C19406qI3.a("ConnectionLog", this.c + ": call rawConnection.doClose()", new Object[0]);
            this.d.a();
        } catch (Exception e3) {
            C19406qI3.c("ConnectionLog", this.c + ": Problem accrued in closing connection block : ", e3);
        }
        C19406qI3.a("ConnectionLog", this.c + ": reach end of closing connection block", new Object[0]);
    }

    private InterfaceC23154wR7 j() {
        return ((InterfaceC8129Uq4) C92.a(C5721Ko.b, InterfaceC8129Uq4.class)).j0();
    }

    private synchronized void k(byte[] bArr) {
        C10054b01 c10054b01 = (C10054b01) this.u.remove(Integer.valueOf(new C9207Yy1(bArr).d()));
        if (c10054b01 == null) {
            return;
        }
        c10054b01.a();
        v();
    }

    private synchronized void l(byte[] bArr) {
        C9207Yy1 c9207Yy1 = new C9207Yy1(bArr);
        c9207Yy1.e();
        c9207Yy1.b();
        String str = new String(c9207Yy1.c(c9207Yy1.d()), "UTF-8");
        C19406qI3.j("ConnectionLog", this.c + ": Drop received: " + str, new Object[0]);
        throw new IOException("Drop received: " + str);
    }

    private synchronized b m(byte[] bArr) {
        C19406qI3.a("ConnectionLog", "Handshake response received", new Object[0]);
        C9207Yy1 c9207Yy1 = new C9207Yy1(bArr);
        int iB = c9207Yy1.b();
        int iB2 = c9207Yy1.b();
        int iB3 = c9207Yy1.b();
        if (!Arrays.equals(c9207Yy1.c(32), AbstractC7464Rv1.f(this.o))) {
            throw new IOException("SHA 256 is incorrect");
        }
        if (iB != this.g) {
            C19406qI3.j("ConnectionLog", this.c + ": Incorrect Proto Version, expected: " + this.g + ", got " + iB + Separators.SEMICOLON, new Object[0]);
            return new b(InterfaceC16050kd1.a.MTPROTO_VERSION);
        }
        if (iB2 != this.h) {
            C19406qI3.j("ConnectionLog", this.c + ": Incorrect Api Major Version, expected: " + this.h + ", got " + iB2 + Separators.SEMICOLON, new Object[0]);
            return new b(InterfaceC16050kd1.a.APIMAJOR_VERSION);
        }
        if (iB3 == this.i) {
            this.n = true;
            this.f.b(this);
            this.r.a();
            this.s.d(300000L);
            C19406qI3.a("ConnectionLog", "Handshake successful", new Object[0]);
            return null;
        }
        C19406qI3.j("ConnectionLog", this.c + ": Incorrect Api Minor Version, expected: " + this.i + ", got " + iB3 + Separators.SEMICOLON, new Object[0]);
        return new b(InterfaceC16050kd1.a.APIMINOR_VERSION);
    }

    private synchronized void n(byte[] bArr) {
        C19406qI3.a("ConnectionLog", this.c + ": >>> Received ping lets send a pong", new Object[0]);
        t(2, bArr);
        v();
    }

    private synchronized void o(byte[] bArr) {
        C9207Yy1 c9207Yy1 = new C9207Yy1(bArr);
        if (c9207Yy1.d() != 8) {
            C19406qI3.j("ConnectionLog", this.c + ": Received incorrect pong", new Object[0]);
            throw new IOException("Incorrect pong payload size");
        }
        long jE = c9207Yy1.e();
        C19406qI3.a("ConnectionLog", this.c + ": >>> Received pong #" + jE + "...", new Object[0]);
        C10054b01 c10054b01 = (C10054b01) this.t.remove(Long.valueOf(jE));
        if (c10054b01 == null) {
            return;
        }
        c10054b01.a();
        v();
    }

    private synchronized void p(byte[] bArr) {
        this.e.a(bArr, 0, bArr.length);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        C19406qI3.a("ConnectionLog", this.c + ":  Going close connection from ManagedConnection:onRawClosed", new Object[0]);
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(DnsResolution dnsResolution) {
        if (this.l) {
            C19406qI3.a("ConnectionLog", this.c + ": onRawConnected return because isClosed = true", new Object[0]);
            return;
        }
        if (this.m) {
            C19406qI3.a("ConnectionLog", this.c + ": onRawConnected return because isOpened = true", new Object[0]);
            return;
        }
        C19406qI3.a("ConnectionLog", this.c + ": onRawConnected", new Object[0]);
        this.m = true;
        this.p = dnsResolution;
        this.q.a();
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(byte[] bArr) {
        C9207Yy1 c9207Yy1;
        int iD;
        int i;
        if (this.l) {
            C19406qI3.a("ConnectionLog", this.c + ": onRawReceived return because isClosed = true", new Object[0]);
            return;
        }
        try {
            c9207Yy1 = new C9207Yy1(bArr);
            iD = c9207Yy1.d();
            i = this.j;
        } catch (IOException e) {
            C19406qI3.c("ConnectionLog", this.c, e);
            C19406qI3.a("ConnectionLog", this.c + ":  Going close connection from ManagedConnection:onRawReceived:on exception", new Object[0]);
            close();
        }
        if (i != iD) {
            C19406qI3.j("ConnectionLog", this.c + ": Invalid package index. Expected: " + this.j + ", got: " + iD, new Object[0]);
            throw new IOException("Invalid package index. Expected: " + this.j + ", got: " + iD);
        }
        this.j = i + 1;
        int iB = c9207Yy1.b();
        byte[] bArrC = c9207Yy1.c(c9207Yy1.d());
        int iD2 = c9207Yy1.d();
        this.b.c();
        this.b.d(bArrC);
        if (((int) this.b.a()) != iD2) {
            C19406qI3.j("ConnectionLog", this.c + ": Incorrect c", new Object[0]);
            throw new IOException("Incorrect CRC32");
        }
        if (iB == 254) {
            if (this.n) {
                throw new IOException("Double Handshake");
            }
            b bVarM = m(bArrC);
            if (bVarM != null) {
                h(bVarM.a());
            }
        } else {
            if (!this.n) {
                throw new IOException("Package before Handshake");
            }
            if (iB == 0) {
                p(bArrC);
                w(iD);
            } else if (iB == 1) {
                n(bArrC);
            } else if (iB == 2) {
                o(bArrC);
            } else if (iB == 3) {
                l(bArrC);
            } else if (iB == 6) {
                k(bArrC);
            } else {
                C19406qI3.j("ConnectionLog", this.c + ": Received unknown package #" + iB, new Object[0]);
            }
            A();
        }
    }

    private synchronized void t(int i, byte[] bArr) {
        u(i, bArr, 0, bArr.length);
    }

    private synchronized void u(int i, byte[] bArr, int i2, int i3) {
        try {
            int i4 = this.k;
            this.k = i4 + 1;
            C12658ez1 c12658ez1 = new C12658ez1();
            c12658ez1.h(i4);
            c12658ez1.e(i);
            c12658ez1.h(bArr.length);
            c12658ez1.g(bArr, i2, i3);
            this.b.c();
            this.b.e(bArr, i2, i3);
            c12658ez1.h((int) this.b.a());
            if (i == 0) {
                C10054b01 c10054b01 = new C10054b01(new d("timeoutTask"));
                this.u.put(Integer.valueOf(i4), c10054b01);
                c10054b01.d(15000L);
            }
            this.d.c(c12658ez1.c());
        } catch (Throwable th) {
            throw th;
        }
    }

    private void v() {
        Iterator it = this.t.values().iterator();
        while (it.hasNext()) {
            ((C10054b01) it.next()).d(15000L);
        }
        Iterator it2 = this.u.values().iterator();
        while (it2.hasNext()) {
            ((C10054b01) it2.next()).d(15000L);
        }
        this.s.d(300000L);
    }

    private synchronized void w(int i) {
        if (this.l) {
            return;
        }
        C12658ez1 c12658ez1 = new C12658ez1();
        c12658ez1.h(i);
        t(6, c12658ez1.c());
    }

    private synchronized void x() {
        C19406qI3.a("ConnectionLog", "Starting handshake", new Object[0]);
        C12658ez1 c12658ez1 = new C12658ez1();
        c12658ez1.e(this.g);
        c12658ez1.e(this.h);
        c12658ez1.e(this.i);
        this.o = new byte[32];
        Random random = v;
        synchronized (random) {
            random.nextBytes(this.o);
        }
        c12658ez1.h(this.o.length);
        byte[] bArr = this.o;
        c12658ez1.g(bArr, 0, bArr.length);
        this.r.d(15000L);
        t(255, c12658ez1.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y() {
        if (this.l) {
            C19406qI3.a("ConnectionLog", "Return from sending ping message, because isClosed = true", new Object[0]);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C12658ez1 c12658ez1 = new C12658ez1();
        c12658ez1.h(8);
        synchronized (v) {
            c12658ez1.i(jCurrentTimeMillis);
        }
        C10054b01 c10054b01 = new C10054b01(new d("pingTimeoutTask"));
        this.t.put(Long.valueOf(jCurrentTimeMillis), c10054b01);
        c10054b01.d(1000L);
        C19406qI3.a("ConnectionLog", this.c + ": >>> Performing ping #" + jCurrentTimeMillis + "... " + c10054b01, new Object[0]);
        t(1, c12658ez1.c());
    }

    private synchronized void z(byte[] bArr, int i, int i2) {
        if (this.l) {
            return;
        }
        u(0, bArr, i, i2);
    }

    @Override // ir.nasim.InterfaceC16050kd1
    public void a() {
        this.s.d(0L);
    }

    @Override // ir.nasim.InterfaceC16050kd1
    public synchronized void b(byte[] bArr, int i, int i2) {
        if (this.l) {
            return;
        }
        try {
            z(bArr, i, i2);
        } catch (IOException e) {
            C19406qI3.c("ConnectionLog", this.c, e);
            C19406qI3.a("ConnectionLog", this.c + ":  Going close connection from ManagedConnection:post:on exception", new Object[0]);
            close();
        }
    }

    @Override // ir.nasim.InterfaceC16050kd1
    public void close() {
        synchronized (this.d) {
            C19406qI3.j("ConnectionLog", this.c + ": close", new Object[0]);
            i(InterfaceC16050kd1.a.UNKNOWN);
        }
    }

    public void h(InterfaceC16050kd1.a aVar) {
        synchronized (this.d) {
            C19406qI3.j("ConnectionLog", this.c + ": close with cause parameter", new Object[0]);
            i(aVar);
        }
    }

    @Override // ir.nasim.InterfaceC16050kd1
    public synchronized boolean isClosed() {
        return this.l;
    }
}
