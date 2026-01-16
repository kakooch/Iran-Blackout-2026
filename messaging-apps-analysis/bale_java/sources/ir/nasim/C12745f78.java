package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* renamed from: ir.nasim.f78, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12745f78 {
    public static final C12745f78 a = new C12745f78();

    /* renamed from: ir.nasim.f78$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC7188Qq4 e;
        final /* synthetic */ ZV0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC7188Qq4 interfaceC7188Qq4, ZV0 zv0) {
            super(1);
            this.e = interfaceC7188Qq4;
            this.f = zv0;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6944Pq4 invoke(ConnectivityManager.NetworkCallback networkCallback) {
            AbstractC13042fc3.i(networkCallback, "networkCallback");
            C6944Pq4 c6944Pq4 = new C6944Pq4(networkCallback, this.e);
            this.f.a(c6944Pq4);
            return c6944Pq4;
        }
    }

    private C12745f78() {
    }

    public final InterfaceC3503Bd1 a(C17625nH4 c17625nH4) {
        AbstractC13042fc3.i(c17625nH4, "okHttpConnectionWarmer");
        return c17625nH4;
    }

    public final ConnectivityManager b(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    public final UA2 c(ZV0 zv0, InterfaceC7188Qq4 interfaceC7188Qq4) {
        AbstractC13042fc3.i(zv0, "closeableManager");
        AbstractC13042fc3.i(interfaceC7188Qq4, "registrar");
        return new a(interfaceC7188Qq4, zv0);
    }

    public final InterfaceC7188Qq4 d(ConnectivityManager connectivityManager) {
        AbstractC13042fc3.i(connectivityManager, "connectivityManager");
        return new C7422Rq4(connectivityManager);
    }

    public final InterfaceC13220fr4 e(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new C12569eq(context);
    }

    public final OkHttpClient f(OkHttpClient okHttpClient) {
        return okHttpClient == null ? new OkHttpClient() : okHttpClient;
    }

    public final WebSocket.Factory g(OkHttpClient okHttpClient) {
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        return okHttpClient;
    }
}
