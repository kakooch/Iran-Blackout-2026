package ir.nasim;

import ir.nasim.core.network.dns.model.DnsResolution;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;

/* renamed from: ir.nasim.zK, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24857zK {
    private BK a;
    private ConnectionEndpoint b;

    public AbstractC24857zK(ConnectionEndpoint connectionEndpoint, BK bk) {
        this.a = bk;
        this.b = connectionEndpoint;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c(byte[] bArr);

    protected ConnectionEndpoint d() {
        return this.b;
    }

    protected final void e() {
        this.a.a();
    }

    protected final void f(DnsResolution dnsResolution) {
        this.a.b(dnsResolution);
    }

    protected final void g(byte[] bArr) {
        this.a.c(bArr);
    }
}
