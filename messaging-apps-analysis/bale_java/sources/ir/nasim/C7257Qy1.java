package ir.nasim;

import livekit.org.webrtc.DataChannel;

/* renamed from: ir.nasim.Qy1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7257Qy1 implements DataChannel.Observer {
    static final /* synthetic */ InterfaceC5239Im3[] g = {AbstractC10882cM5.f(new C5942Lm4(C7257Qy1.class, "disposed", "getDisposed()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(C7257Qy1.class, "bufferedAmount", "getBufferedAmount()J", 0)), AbstractC10882cM5.f(new C5942Lm4(C7257Qy1.class, "state", "getState()Llivekit/org/webrtc/DataChannel$State;", 0))};
    private final DataChannel a;
    private final DataChannel.Observer b;
    private final FF5 c;
    private final C9927an4 d;
    private final C9927an4 e;
    private final C9927an4 f;

    /* renamed from: ir.nasim.Qy1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            C7257Qy1.this.c().unregisterObserver();
            C7257Qy1.this.c().close();
            C7257Qy1.this.c().dispose();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C7257Qy1(DataChannel dataChannel, DataChannel.Observer observer, FF5 ff5) {
        AbstractC13042fc3.i(dataChannel, "dataChannel");
        AbstractC13042fc3.i(observer, "dataMessageListener");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.a = dataChannel;
        this.b = observer;
        this.c = ff5;
        this.d = AbstractC5508Jq2.c(Boolean.FALSE, null, 2, null);
        this.e = AbstractC5508Jq2.c(0L, null, 2, null);
        this.f = AbstractC5508Jq2.c(dataChannel.state(), null, 2, null);
    }

    private final void e(long j) {
        this.e.i(this, g[1], Long.valueOf(j));
    }

    private final void f(boolean z) {
        this.d.i(this, g[0], Boolean.valueOf(z));
    }

    private final void g(DataChannel.State state) {
        this.f.i(this, g[2], state);
    }

    public final void a() {
        synchronized (this) {
            if (d()) {
                return;
            }
            f(true);
            e(0L);
            C19938rB7 c19938rB7 = C19938rB7.a;
            IF5.d(this.c, new a());
        }
    }

    public final long b() {
        return ((Number) this.e.h(this, g[1])).longValue();
    }

    public final DataChannel c() {
        return this.a;
    }

    public final boolean d() {
        return ((Boolean) this.d.h(this, g[0])).booleanValue();
    }

    @Override // livekit.org.webrtc.DataChannel.Observer
    public void onBufferedAmountChange(long j) {
        e(this.a.bufferedAmount());
    }

    @Override // livekit.org.webrtc.DataChannel.Observer
    public void onMessage(DataChannel.Buffer buffer) {
        AbstractC13042fc3.i(buffer, "buffer");
        this.b.onMessage(buffer);
    }

    @Override // livekit.org.webrtc.DataChannel.Observer
    public void onStateChange() {
        g(this.a.state());
    }
}
