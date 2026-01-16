package ir.nasim;

import android.os.SystemClock;
import ir.nasim.core.network.dns.model.DnsResolution;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class CL extends AbstractC24857zK {
    private static final ExecutorService m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new EL(), new RejectedExecutionHandler() { // from class: ir.nasim.zL
        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            CL.v(runnable, threadPoolExecutor);
        }
    });
    private final int c;
    private final String d;
    private Socket e;
    private InputStream f;
    private OutputStream g;
    private b h;
    private a i;
    private volatile boolean j;
    private volatile boolean k;
    private InterfaceC23154wR7 l;

    private class a extends Thread {
        private byte[] a(int i) throws IOException {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                if (CL.this.f == null) {
                    throw new IOException();
                }
                int i3 = CL.this.f.read(bArr, i2, i - i2);
                if (i3 > 0) {
                    i2 += i3;
                } else {
                    if (i3 < 0) {
                        throw new IOException();
                    }
                    Thread.yield();
                }
            }
            return bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            C19406qI3.a("ConnectionLog", CL.this.d + ": Start running reader thread", new Object[0]);
            while (CL.this.j) {
                try {
                    try {
                        byte[] bArrA = a(9);
                        C9207Yy1 c9207Yy1 = new C9207Yy1(bArrA);
                        c9207Yy1.d();
                        c9207Yy1.b();
                        int iD = c9207Yy1.d();
                        if (iD > 1048576) {
                            throw new IOException("Incorrect size");
                        }
                        byte[] bArrA2 = a(iD + 4);
                        C12658ez1 c12658ez1 = new C12658ez1();
                        c12658ez1.f(bArrA);
                        c12658ez1.f(bArrA2);
                        CL.this.x(c12658ez1.c());
                    } catch (Exception e) {
                        CL.this.r(e, "READER_THREAD_RUN");
                        C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running reader thread", new Object[0]);
                        return;
                    }
                } catch (Throwable th) {
                    C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running reader thread", new Object[0]);
                    throw th;
                }
            }
            C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running reader thread", new Object[0]);
        }

        private a() {
            setName("T_ATC_Reader" + CL.this.c);
            setPriority(1);
        }
    }

    private class b extends Thread {
        private final ConcurrentLinkedQueue a = new ConcurrentLinkedQueue();

        public b() {
            setName("T_ATC_Writer" + CL.this.c);
            setPriority(1);
        }

        public void a(byte[] bArr) {
            try {
                this.a.add(bArr);
                synchronized (this.a) {
                    this.a.notifyAll();
                }
            } catch (Exception e) {
                CL.this.r(e, "WRITER_THREAD_PUSH_PACKAGES");
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            try {
                try {
                    C19406qI3.a("ConnectionLog", CL.this.d + ": Start running writer thread", new Object[0]);
                    while (CL.this.j) {
                        synchronized (this.a) {
                            try {
                                bArr = (byte[]) this.a.poll();
                                if (bArr == null) {
                                    try {
                                        this.a.wait();
                                        bArr = (byte[]) this.a.poll();
                                    } catch (InterruptedException unused) {
                                        C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running writer thread", new Object[0]);
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (bArr != null) {
                            CL.this.g.write(bArr);
                            CL.this.g.flush();
                        }
                    }
                    C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running writer thread", new Object[0]);
                } catch (Throwable th2) {
                    C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running writer thread", new Object[0]);
                    throw th2;
                }
            } catch (Exception e) {
                CL.this.r(e, "WRITER_THREAD_RUN");
                C19406qI3.a("ConnectionLog", CL.this.d + ": Finish running writer thread", new Object[0]);
            }
        }
    }

    public CL(int i, ConnectionEndpoint connectionEndpoint, BK bk) {
        super(connectionEndpoint, bk);
        this.j = false;
        this.k = false;
        this.l = null;
        this.d = "ConnectionTcp#" + i;
        this.c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01e7 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0006, B:10:0x002f, B:11:0x0053, B:13:0x0057, B:19:0x00bb, B:21:0x00bf, B:27:0x0123, B:29:0x014b, B:33:0x0197, B:35:0x019b, B:39:0x01e7, B:41:0x01eb, B:45:0x0237, B:44:0x0211, B:38:0x01c1, B:32:0x0171, B:24:0x00e6, B:26:0x0106, B:16:0x007e, B:18:0x009e), top: B:60:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void q() {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CL.q():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(Exception exc, String str) {
        C19406qI3.a("ConnectionLog", this.d + " : crash connection occurred with caller " + str + " with exception : " + exc + " isClosed : " + this.k, new Object[0]);
        if (this.k) {
            return;
        }
        super.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.net.InetSocketAddress] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.net.InetSocketAddress] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CL.s():void");
    }

    private List t(ConnectionEndpoint connectionEndpoint) {
        if (connectionEndpoint.getTlsPublicKeyHashes() == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = connectionEndpoint.getTlsPublicKeyHashes().iterator();
        while (it.hasNext()) {
            arrayList.add("SHA256:" + it.next());
        }
        return arrayList;
    }

    private InterfaceC23154wR7 u() {
        InterfaceC23154wR7 interfaceC23154wR7 = this.l;
        if (interfaceC23154wR7 != null) {
            return interfaceC23154wR7;
        }
        InterfaceC23154wR7 interfaceC23154wR7J0 = ((InterfaceC8129Uq4) C92.a(C5721Ko.b, InterfaceC8129Uq4.class)).j0();
        this.l = interfaceC23154wR7J0;
        interfaceC23154wR7J0.initialize();
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        C19406qI3.j("ConnectionLog", "The createConnection command rejected!!", new Object[0]);
    }

    private synchronized void w(Socket socket, DnsResolution dnsResolution) {
        C19406qI3.a("ConnectionLog", this.d + ": On new socket created", new Object[0]);
        try {
            this.e = socket;
            this.f = socket.getInputStream();
            this.g = socket.getOutputStream();
            this.k = false;
            this.j = true;
            a aVar = new a();
            this.i = aVar;
            aVar.start();
            b bVar = new b();
            this.h = bVar;
            bVar.start();
            f(dnsResolution);
        } catch (Exception e) {
            r(e, "ON_SOCKET_CREATED");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(byte[] bArr) {
        if (this.j) {
            g(bArr);
            return;
        }
        C19406qI3.a("ConnectionLog", this.d + ": onRawReceived: Not connected", new Object[0]);
    }

    private static void y(long j, ConnectionEndpoint connectionEndpoint) {
        long jElapsedRealtime = -1;
        if (j != -1) {
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            } catch (Exception unused) {
                return;
            }
        }
        C19596qd1.d(C5721Ko.b).f(connectionEndpoint.getHost(), String.valueOf(jElapsedRealtime));
    }

    @Override // ir.nasim.AbstractC24857zK
    public void a() {
        q();
    }

    @Override // ir.nasim.AbstractC24857zK
    public void b() {
        C19406qI3.a("ConnectionLog", this.d + ": AsyncTcpConnection: doConnect", new Object[0]);
        try {
            m.submit(new Runnable() { // from class: ir.nasim.AL
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.a.s();
                }
            });
        } catch (Exception e) {
            C19406qI3.c("ConnectionLog", this.d + ": doConnect : create connection execution failed ", e);
            super.e();
        }
    }

    @Override // ir.nasim.AbstractC24857zK
    public void c(byte[] bArr) {
        this.h.a(bArr);
    }
}
