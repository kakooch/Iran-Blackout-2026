package ir.nasim;

import android.content.Context;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class XS2 {
    public static final XS2 a = new XS2();
    private static final InterfaceC18376oZ2 b = new C18967pZ2();

    private XS2() {
    }

    public static final OkHttpClient a() {
        return c(null, 1, null);
    }

    public static final OkHttpClient b(Context context) {
        AbstractC13042fc3.i(context, "context");
        return ((InterfaceC8129Uq4) C92.a(context, InterfaceC8129Uq4.class)).U0();
    }

    public static /* synthetic */ OkHttpClient c(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = C5721Ko.a.d();
        }
        return b(context);
    }

    public static final C6517Nv5 d(String str, String str2, byte[] bArr, String[] strArr, String[] strArr2, Integer num) {
        return b.a(str, null, str2, bArr, strArr, strArr2, num);
    }
}
