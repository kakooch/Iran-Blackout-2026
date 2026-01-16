package ir.nasim;

import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.eT2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12349eT2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final DF2 a;
    private WeakReference b;

    /* renamed from: ir.nasim.eT2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C12349eT2(DF2 df2) {
        AbstractC13042fc3.i(df2, "getConnectionStateUseCase");
        this.a = df2;
        this.b = new WeakReference(null);
    }

    public final void a(WeakReference weakReference) {
        AbstractC13042fc3.i(weakReference, "<set-?>");
        this.b = weakReference;
    }
}
