package ir.nasim;

import com.google.android.exoplayer2.upstream.cache.Cache;
import ir.nasim.EX1;

/* renamed from: ir.nasim.qp7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19722qp7 implements InterfaceC14123hO3 {
    public static final C19722qp7 a = new C19722qp7();

    private C19722qp7() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public EX1.b a(Throwable th) {
        AbstractC13042fc3.i(th, "input");
        if (th instanceof Cache.CacheException) {
            return new EX1.b.a((Cache.CacheException) th);
        }
        return null;
    }
}
