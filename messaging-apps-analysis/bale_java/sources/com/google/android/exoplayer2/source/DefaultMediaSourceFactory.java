package com.google.android.exoplayer2.source;

import android.content.Context;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.c;
import ir.nasim.A07;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.B07;
import ir.nasim.C8292Vi5;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC12088e12;
import ir.nasim.InterfaceC12462ef2;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;
import ir.nasim.Q17;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private final DelegateFactoryLoader a;
    private a.InterfaceC0163a b;
    private MediaSource.Factory c;
    private com.google.android.exoplayer2.upstream.j d;
    private long e;
    private long f;
    private long g;
    private float h;
    private float i;
    private boolean j;

    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class DelegateFactoryLoader {
        private final InterfaceC12462ef2 a;
        private final Map b = new HashMap();
        private final Set c = new HashSet();
        private final Map d = new HashMap();
        private a.InterfaceC0163a e;
        private InterfaceC12088e12 f;
        private com.google.android.exoplayer2.upstream.j g;

        public DelegateFactoryLoader(InterfaceC12462ef2 interfaceC12462ef2) {
            this.a = interfaceC12462ef2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ MediaSource.Factory k(a.InterfaceC0163a interfaceC0163a) {
            return new ProgressiveMediaSource.Factory(interfaceC0163a, this.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private ir.nasim.Q17 l(int r5) {
            /*
                r4 = this;
                java.util.Map r0 = r4.b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L19
                java.util.Map r0 = r4.b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                ir.nasim.Q17 r5 = (ir.nasim.Q17) r5
                return r5
            L19:
                com.google.android.exoplayer2.upstream.a$a r0 = r4.e
                java.lang.Object r0 = ir.nasim.AbstractC20011rK.e(r0)
                com.google.android.exoplayer2.upstream.a$a r0 = (com.google.android.exoplayer2.upstream.a.InterfaceC0163a) r0
                java.lang.Class<com.google.android.exoplayer2.source.MediaSource$Factory> r1 = com.google.android.exoplayer2.source.MediaSource.Factory.class
                r2 = 0
                if (r5 == 0) goto L67
                r3 = 1
                if (r5 == r3) goto L57
                r3 = 2
                if (r5 == r3) goto L4a
                r3 = 3
                if (r5 == r3) goto L3a
                r1 = 4
                if (r5 == r1) goto L33
                goto L77
            L33:
                com.google.android.exoplayer2.source.e r1 = new com.google.android.exoplayer2.source.e     // Catch: java.lang.ClassNotFoundException -> L77
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L77
            L38:
                r2 = r1
                goto L77
            L3a:
                java.lang.String r0 = "com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L77
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L77
                com.google.android.exoplayer2.source.d r1 = new com.google.android.exoplayer2.source.d     // Catch: java.lang.ClassNotFoundException -> L77
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L77
                goto L38
            L4a:
                java.lang.Class<com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L77
                com.google.android.exoplayer2.source.c r3 = new com.google.android.exoplayer2.source.c     // Catch: java.lang.ClassNotFoundException -> L77
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L77
            L55:
                r2 = r3
                goto L77
            L57:
                java.lang.String r3 = "com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L77
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L77
                com.google.android.exoplayer2.source.b r3 = new com.google.android.exoplayer2.source.b     // Catch: java.lang.ClassNotFoundException -> L77
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L77
                goto L55
            L67:
                java.lang.String r3 = "com.google.android.exoplayer2.source.dash.DashMediaSource$Factory"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L77
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L77
                com.google.android.exoplayer2.source.a r3 = new com.google.android.exoplayer2.source.a     // Catch: java.lang.ClassNotFoundException -> L77
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L77
                goto L55
            L77:
                java.util.Map r0 = r4.b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L8b
                java.util.Set r0 = r4.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L8b:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.DefaultMediaSourceFactory.DelegateFactoryLoader.l(int):ir.nasim.Q17");
        }

        public MediaSource.Factory f(int i) {
            MediaSource.Factory factory = (MediaSource.Factory) this.d.get(Integer.valueOf(i));
            if (factory != null) {
                return factory;
            }
            Q17 q17L = l(i);
            if (q17L == null) {
                return null;
            }
            MediaSource.Factory factory2 = (MediaSource.Factory) q17L.get();
            InterfaceC12088e12 interfaceC12088e12 = this.f;
            if (interfaceC12088e12 != null) {
                factory2.b(interfaceC12088e12);
            }
            com.google.android.exoplayer2.upstream.j jVar = this.g;
            if (jVar != null) {
                factory2.c(jVar);
            }
            this.d.put(Integer.valueOf(i), factory2);
            return factory2;
        }

        public void m(a.InterfaceC0163a interfaceC0163a) {
            if (interfaceC0163a != this.e) {
                this.e = interfaceC0163a;
                this.b.clear();
                this.d.clear();
            }
        }

        public void n(InterfaceC12088e12 interfaceC12088e12) {
            this.f = interfaceC12088e12;
            Iterator it = this.d.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).b(interfaceC12088e12);
            }
        }

        public void o(com.google.android.exoplayer2.upstream.j jVar) {
            this.g = jVar;
            Iterator it = this.d.values().iterator();
            while (it.hasNext()) {
                ((MediaSource.Factory) it.next()).c(jVar);
            }
        }
    }

    private static final class UnknownSubtitlesExtractor implements InterfaceC9262Ze2 {
        private final X a;

        public UnknownSubtitlesExtractor(X x) {
            this.a = x;
        }

        @Override // ir.nasim.InterfaceC9262Ze2
        public void a(long j, long j2) {
        }

        @Override // ir.nasim.InterfaceC9262Ze2
        public void b(InterfaceC10465bf2 interfaceC10465bf2) {
            InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(0, 3);
            interfaceC10465bf2.o(new InterfaceC22148uk6.b(-9223372036854775807L));
            interfaceC10465bf2.s();
            interfaceC4589Ft7B.c(this.a.c().g0("text/x-unknown").K(this.a.l).G());
        }

        @Override // ir.nasim.InterfaceC9262Ze2
        public boolean d(InterfaceC9845af2 interfaceC9845af2) {
            return true;
        }

        @Override // ir.nasim.InterfaceC9262Ze2
        public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
            return interfaceC9845af2.a(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // ir.nasim.InterfaceC9262Ze2
        public void release() {
        }
    }

    public DefaultMediaSourceFactory(Context context, InterfaceC12462ef2 interfaceC12462ef2) {
        this(new c.a(context), interfaceC12462ef2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MediaSource.Factory e(Class cls) {
        return j(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ MediaSource.Factory f(Class cls, a.InterfaceC0163a interfaceC0163a) {
        return k(cls, interfaceC0163a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] g(X x) {
        A07 a07 = A07.a;
        return new InterfaceC9262Ze2[]{a07.b(x) ? new B07(a07.a(x), x) : new UnknownSubtitlesExtractor(x)};
    }

    private static MediaSource h(C2018a0 c2018a0, MediaSource mediaSource) {
        C2018a0.d dVar = c2018a0.f;
        if (dVar.a == 0 && dVar.b == Long.MIN_VALUE && !dVar.d) {
            return mediaSource;
        }
        long jB0 = AbstractC9683aN7.B0(c2018a0.f.a);
        long jB02 = AbstractC9683aN7.B0(c2018a0.f.b);
        C2018a0.d dVar2 = c2018a0.f;
        return new ClippingMediaSource(mediaSource, jB0, jB02, !dVar2.e, dVar2.c, dVar2.d);
    }

    private MediaSource i(C2018a0 c2018a0, MediaSource mediaSource) {
        AbstractC20011rK.e(c2018a0.b);
        c2018a0.b.getClass();
        return mediaSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.Factory j(Class cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaSource.Factory k(Class cls, a.InterfaceC0163a interfaceC0163a) {
        try {
            return (MediaSource.Factory) cls.getConstructor(a.InterfaceC0163a.class).newInstance(interfaceC0163a);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public MediaSource a(C2018a0 c2018a0) {
        AbstractC20011rK.e(c2018a0.b);
        String scheme = c2018a0.b.a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((MediaSource.Factory) AbstractC20011rK.e(this.c)).a(c2018a0);
        }
        C2018a0.h hVar = c2018a0.b;
        int iP0 = AbstractC9683aN7.p0(hVar.a, hVar.b);
        MediaSource.Factory factoryF = this.a.f(iP0);
        AbstractC20011rK.j(factoryF, "No suitable media source factory found for content type: " + iP0);
        C2018a0.g.a aVarC = c2018a0.d.c();
        if (c2018a0.d.a == -9223372036854775807L) {
            aVarC.k(this.e);
        }
        if (c2018a0.d.d == -3.4028235E38f) {
            aVarC.j(this.h);
        }
        if (c2018a0.d.e == -3.4028235E38f) {
            aVarC.h(this.i);
        }
        if (c2018a0.d.b == -9223372036854775807L) {
            aVarC.i(this.f);
        }
        if (c2018a0.d.c == -9223372036854775807L) {
            aVarC.g(this.g);
        }
        C2018a0.g gVarF = aVarC.f();
        if (!gVarF.equals(c2018a0.d)) {
            c2018a0 = c2018a0.c().d(gVarF).a();
        }
        MediaSource mediaSourceA = factoryF.a(c2018a0);
        AbstractC12710f43 abstractC12710f43 = ((C2018a0.h) AbstractC9683aN7.j(c2018a0.b)).f;
        if (!abstractC12710f43.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[abstractC12710f43.size() + 1];
            mediaSourceArr[0] = mediaSourceA;
            for (int i = 0; i < abstractC12710f43.size(); i++) {
                if (this.j) {
                    final X xG = new X.b().g0(((C2018a0.l) abstractC12710f43.get(i)).b).X(((C2018a0.l) abstractC12710f43.get(i)).c).i0(((C2018a0.l) abstractC12710f43.get(i)).d).e0(((C2018a0.l) abstractC12710f43.get(i)).e).W(((C2018a0.l) abstractC12710f43.get(i)).f).U(((C2018a0.l) abstractC12710f43.get(i)).g).G();
                    ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.b, new InterfaceC12462ef2() { // from class: ir.nasim.rE1
                        @Override // ir.nasim.InterfaceC12462ef2
                        public final InterfaceC9262Ze2[] c() {
                            return DefaultMediaSourceFactory.g(xG);
                        }
                    });
                    com.google.android.exoplayer2.upstream.j jVar = this.d;
                    if (jVar != null) {
                        factory.c(jVar);
                    }
                    mediaSourceArr[i + 1] = factory.a(C2018a0.f(((C2018a0.l) abstractC12710f43.get(i)).a.toString()));
                } else {
                    SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.b);
                    com.google.android.exoplayer2.upstream.j jVar2 = this.d;
                    if (jVar2 != null) {
                        factory2.b(jVar2);
                    }
                    mediaSourceArr[i + 1] = factory2.a((C2018a0.l) abstractC12710f43.get(i), -9223372036854775807L);
                }
            }
            mediaSourceA = new MergingMediaSource(mediaSourceArr);
        }
        return i(c2018a0, h(c2018a0, mediaSourceA));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory b(InterfaceC12088e12 interfaceC12088e12) {
        this.a.n((InterfaceC12088e12) AbstractC20011rK.f(interfaceC12088e12, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory c(com.google.android.exoplayer2.upstream.j jVar) {
        this.d = (com.google.android.exoplayer2.upstream.j) AbstractC20011rK.f(jVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.a.o(jVar);
        return this;
    }

    public DefaultMediaSourceFactory(a.InterfaceC0163a interfaceC0163a, InterfaceC12462ef2 interfaceC12462ef2) {
        this.b = interfaceC0163a;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(interfaceC12462ef2);
        this.a = delegateFactoryLoader;
        delegateFactoryLoader.m(interfaceC0163a);
        this.e = -9223372036854775807L;
        this.f = -9223372036854775807L;
        this.g = -9223372036854775807L;
        this.h = -3.4028235E38f;
        this.i = -3.4028235E38f;
    }
}
