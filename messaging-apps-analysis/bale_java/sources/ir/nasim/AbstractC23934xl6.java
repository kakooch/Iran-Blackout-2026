package ir.nasim;

import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.xl6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23934xl6 {
    private final com.google.android.exoplayer2.upstream.b a;
    private final k.a b;
    private final ArrayList c;
    private final a.c d;
    private final Cache e;
    private final InterfaceC16169kp0 f;
    private final Executor g;
    private final ArrayList h;

    public AbstractC23934xl6(C2018a0 c2018a0, k.a aVar, a.c cVar, Executor executor) {
        AbstractC20011rK.e(c2018a0.b);
        this.a = a(c2018a0.b.a);
        this.b = aVar;
        this.c = new ArrayList(c2018a0.b.d);
        this.d = cVar;
        this.g = executor;
        this.e = (Cache) AbstractC20011rK.e(cVar.e());
        this.f = cVar.f();
        cVar.g();
        this.h = new ArrayList();
    }

    protected static com.google.android.exoplayer2.upstream.b a(Uri uri) {
        return new b.C0164b().i(uri).b(1).a();
    }
}
