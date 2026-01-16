package ir.nasim;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.File;

/* loaded from: classes5.dex */
public final class DD6 {
    public static final DD6 a = new DD6();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.CD6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return DD6.b();
        }
    });
    public static final int c = 8;

    private DD6() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.google.android.exoplayer2.upstream.cache.h b() {
        return new com.google.android.exoplayer2.upstream.cache.h(new File(C4053Dm2.w()), new IA4(), new HD1(new NA4(C5721Ko.a.d(), "VideoDownloadedParts")));
    }

    public static final com.google.android.exoplayer2.upstream.cache.h c() {
        return (com.google.android.exoplayer2.upstream.cache.h) b.getValue();
    }

    public final Cache d() {
        return c();
    }
}
