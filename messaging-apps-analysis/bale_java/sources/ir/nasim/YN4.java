package ir.nasim;

import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class YN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public YN4(QN4 qn4) {
        this.a = qn4;
    }

    public static YN4 a(QN4 qn4) {
        return new YN4(qn4);
    }

    public static OkHttpClient c(QN4 qn4) {
        return qn4.h();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public OkHttpClient get() {
        return c(this.a);
    }
}
