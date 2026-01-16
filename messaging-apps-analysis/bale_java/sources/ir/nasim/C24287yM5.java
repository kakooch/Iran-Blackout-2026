package ir.nasim;

import java.net.URI;
import okhttp3.OkHttpClient;

/* renamed from: ir.nasim.yM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24287yM5 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public C24287yM5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static C24287yM5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C24287yM5(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static io.livekit.android.room.h c(URI uri, String str, OkHttpClient okHttpClient, AbstractC11279ck3 abstractC11279ck3) {
        return new io.livekit.android.room.h(uri, str, okHttpClient, abstractC11279ck3);
    }

    public io.livekit.android.room.h b(URI uri, String str) {
        return c(uri, str, (OkHttpClient) this.a.get(), (AbstractC11279ck3) this.b.get());
    }
}
