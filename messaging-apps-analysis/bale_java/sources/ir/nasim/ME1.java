package ir.nasim;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.j;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ME1 implements BO5 {
    private final Context a;
    private boolean e;
    private boolean g;
    private boolean h;
    private boolean i;
    private final com.google.android.exoplayer2.mediacodec.h b = new com.google.android.exoplayer2.mediacodec.h();
    private int c = 0;
    private long d = 5000;
    private com.google.android.exoplayer2.mediacodec.l f = com.google.android.exoplayer2.mediacodec.l.a;

    public ME1(Context context) {
        this.a = context;
    }

    @Override // ir.nasim.BO5
    public com.google.android.exoplayer2.D0[] a(Handler handler, LU7 lu7, com.google.android.exoplayer2.audio.b bVar, InterfaceC22769vn7 interfaceC22769vn7, InterfaceC3749Ce4 interfaceC3749Ce4) throws NoSuchMethodException, SecurityException {
        ArrayList arrayList = new ArrayList();
        h(this.a, this.c, this.f, this.e, handler, lu7, this.d, arrayList);
        AudioSink audioSinkC = c(this.a, this.g, this.h, this.i);
        if (audioSinkC != null) {
            b(this.a, this.c, this.f, this.e, audioSinkC, handler, bVar, arrayList);
        }
        g(this.a, interfaceC22769vn7, handler.getLooper(), this.c, arrayList);
        e(this.a, interfaceC3749Ce4, handler.getLooper(), this.c, arrayList);
        d(this.a, this.c, arrayList);
        f(this.a, handler, this.c, arrayList);
        return (com.google.android.exoplayer2.D0[]) arrayList.toArray(new com.google.android.exoplayer2.D0[0]);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:56|18|19|63|20|21|(2:62|22)|51|31|32|55|33|65|41|46) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c2, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void b(android.content.Context r17, int r18, com.google.android.exoplayer2.mediacodec.l r19, boolean r20, com.google.android.exoplayer2.audio.AudioSink r21, android.os.Handler r22, com.google.android.exoplayer2.audio.b r23, java.util.ArrayList r24) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ME1.b(android.content.Context, int, com.google.android.exoplayer2.mediacodec.l, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.b, java.util.ArrayList):void");
    }

    protected AudioSink c(Context context, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink.f().g(SM.c(context)).k(z).j(z2).l(z3 ? 1 : 0).f();
    }

    protected void d(Context context, int i, ArrayList arrayList) {
        arrayList.add(new C21835uD0());
    }

    protected void e(Context context, InterfaceC3749Ce4 interfaceC3749Ce4, Looper looper, int i, ArrayList arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.a(interfaceC3749Ce4, looper));
    }

    protected void g(Context context, InterfaceC22769vn7 interfaceC22769vn7, Looper looper, int i, ArrayList arrayList) {
        arrayList.add(new C5954Ln7(interfaceC22769vn7, looper));
    }

    protected void h(Context context, int i, com.google.android.exoplayer2.mediacodec.l lVar, boolean z, Handler handler, LU7 lu7, long j, ArrayList arrayList) throws NoSuchMethodException, SecurityException {
        Handler handler2;
        Class cls;
        String str;
        int i2;
        arrayList.add(new IW3(context, i(), lVar, j, z, handler, lu7, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                handler2 = handler;
                cls = Handler.class;
                try {
                    i2 = size + 1;
                    try {
                        arrayList.add(size, (com.google.android.exoplayer2.D0) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, LU7.class, Integer.TYPE).newInstance(Long.valueOf(j), handler2, lu7, 50));
                        str = "DefaultRenderersFactory";
                        try {
                            AbstractC18815pI3.f(str, "Loaded LibvpxVideoRenderer.");
                        } catch (ClassNotFoundException unused) {
                            size = i2;
                            i2 = size;
                            arrayList.add(i2, (com.google.android.exoplayer2.D0) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, cls, LU7.class, Integer.TYPE).newInstance(Long.valueOf(j), handler2, lu7, 50));
                            AbstractC18815pI3.f(str, "Loaded Libgav1VideoRenderer.");
                        }
                    } catch (ClassNotFoundException unused2) {
                        str = "DefaultRenderersFactory";
                    }
                } catch (ClassNotFoundException unused3) {
                    str = "DefaultRenderersFactory";
                    i2 = size;
                    arrayList.add(i2, (com.google.android.exoplayer2.D0) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, cls, LU7.class, Integer.TYPE).newInstance(Long.valueOf(j), handler2, lu7, 50));
                    AbstractC18815pI3.f(str, "Loaded Libgav1VideoRenderer.");
                }
            } catch (ClassNotFoundException unused4) {
                handler2 = handler;
                cls = Handler.class;
            }
            try {
                arrayList.add(i2, (com.google.android.exoplayer2.D0) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, cls, LU7.class, Integer.TYPE).newInstance(Long.valueOf(j), handler2, lu7, 50));
                AbstractC18815pI3.f(str, "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating AV1 extension", e);
            }
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    protected j.b i() {
        return this.b;
    }

    public ME1 j(int i) {
        this.c = i;
        return this;
    }

    protected void f(Context context, Handler handler, int i, ArrayList arrayList) {
    }
}
