package ir.nasim;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C8393Vt7;
import ir.nasim.InterfaceC14190hV7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14801iV7 {
    private final Cache a;
    private final Context b;
    private final a.c c;
    private final JE2 d;
    private final InterfaceC19567qa2 e;

    public C14801iV7(Cache cache, Context context, a.c cVar, JE2 je2, InterfaceC19567qa2 interfaceC19567qa2) {
        AbstractC13042fc3.i(cache, "cache");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
        AbstractC13042fc3.i(je2, "generateFileHashUseCase");
        AbstractC13042fc3.i(interfaceC19567qa2, "serajAnalytics");
        this.a = cache;
        this.b = context;
        this.c = cVar;
        this.d = je2;
        this.e = interfaceC19567qa2;
    }

    public static /* synthetic */ MediaSource b(C14801iV7 c14801iV7, String str, InterfaceC14190hV7 interfaceC14190hV7, String str2, EnumC8893Xt7 enumC8893Xt7, com.google.android.exoplayer2.upstream.j jVar, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            jVar = null;
        }
        return c14801iV7.a(str, interfaceC14190hV7, str3, enumC8893Xt7, jVar);
    }

    public final MediaSource a(String str, InterfaceC14190hV7 interfaceC14190hV7, String str2, EnumC8893Xt7 enumC8893Xt7, com.google.android.exoplayer2.upstream.j jVar) {
        ProgressiveMediaSource progressiveMediaSourceA;
        String str3;
        AbstractC13042fc3.i(interfaceC14190hV7, "videoSource");
        AbstractC13042fc3.i(str2, "mediaId");
        Context context = this.b;
        String str4 = "";
        String str5 = str == null ? "" : str;
        if (interfaceC14190hV7 instanceof InterfaceC14190hV7.a) {
            com.google.android.exoplayer2.upstream.d dVar = new com.google.android.exoplayer2.upstream.d(context, AbstractC9683aN7.l0(context, context.getPackageName()));
            C2018a0 c2018a0A = new C2018a0.c().j(Uri.parse(str5)).e(str2).a();
            AbstractC13042fc3.h(c2018a0A, "build(...)");
            ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(dVar);
            if (jVar != null) {
                factory.c(jVar);
            }
            progressiveMediaSourceA = factory.a(c2018a0A);
        } else {
            if (!(interfaceC14190hV7 instanceof InterfaceC14190hV7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC14190hV7.b bVar = (InterfaceC14190hV7.b) interfaceC14190hV7;
            String strA = this.d.a(bVar.c(), bVar.b());
            C2018a0.c cVarE = new C2018a0.c().j(Uri.parse(str5)).e(str2);
            cVarE.b(bVar.a());
            C2018a0 c2018a0A2 = cVarE.i(AbstractC23348wm0.b(AbstractC4616Fw7.a("origin", enumC8893Xt7 != null ? Integer.valueOf(enumC8893Xt7.p()) : null), AbstractC4616Fw7.a("file_hash", strA), AbstractC4616Fw7.a("file_size", Long.valueOf(this.a.c(bVar.a(), 0L, -1L))))).g(C6906Pm2.o(bVar.d())).a();
            AbstractC13042fc3.h(c2018a0A2, "build(...)");
            a.c cVar = this.c;
            InterfaceC19567qa2 interfaceC19567qa2 = this.e;
            XV4 xv4A = AbstractC4616Fw7.a("file_hash", strA);
            C2018a0.h hVar = c2018a0A2.b;
            if (hVar != null && (str3 = hVar.b) != null) {
                str4 = str3;
            }
            ProgressiveMediaSource.Factory factory2 = new ProgressiveMediaSource.Factory(new C8393Vt7.b(cVar, interfaceC19567qa2, enumC8893Xt7, AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a("file_mime_type", str4))));
            if (jVar != null) {
                factory2.c(jVar);
            }
            progressiveMediaSourceA = factory2.a(c2018a0A2);
        }
        AbstractC13042fc3.h(progressiveMediaSourceA, "with(...)");
        return progressiveMediaSourceA;
    }
}
