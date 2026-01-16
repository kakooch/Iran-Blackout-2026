package ir.nasim;

import okhttp3.OkHttpClient;
import okhttp3.WebSocket;

/* renamed from: ir.nasim.lC6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16400lC6 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;

    public C16400lC6(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
    }

    public static C16400lC6 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55) {
        return new C16400lC6(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55);
    }

    public static io.livekit.android.room.l c(WebSocket.Factory factory, AbstractC11279ck3 abstractC11279ck3, OkHttpClient okHttpClient, AbstractC13778go1 abstractC13778go1, InterfaceC13220fr4 interfaceC13220fr4) {
        return new io.livekit.android.room.l(factory, abstractC11279ck3, okHttpClient, abstractC13778go1, interfaceC13220fr4);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public io.livekit.android.room.l get() {
        return c((WebSocket.Factory) this.a.get(), (AbstractC11279ck3) this.b.get(), (OkHttpClient) this.c.get(), (AbstractC13778go1) this.d.get(), (InterfaceC13220fr4) this.e.get());
    }
}
