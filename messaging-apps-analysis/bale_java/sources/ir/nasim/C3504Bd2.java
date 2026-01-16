package ir.nasim;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C18807pH4;
import okhttp3.OkHttpClient;

/* renamed from: ir.nasim.Bd2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3504Bd2 {
    public final a.c a(Cache cache, OkHttpClient okHttpClient) {
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        a.c cVarJ = new a.c().h(cache).k(new C18807pH4.b(okHttpClient)).i(new C8180Uw1()).j(2);
        AbstractC13042fc3.h(cVarJ, "setFlags(...)");
        return cVarJ;
    }

    public final HC6 b() {
        return IC6.a;
    }
}
