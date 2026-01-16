package ir.nasim;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.cq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11344cq8 {
    private static volatile Mp8 h;
    public static final /* synthetic */ int l = 0;
    final Lp8 a;
    final String b;
    private final Object c;
    private volatile int d = -1;
    private volatile Object e;
    private final boolean f;
    private static final Object g = new Object();
    private static final AtomicReference i = new AtomicReference();
    private static final C13214fq8 j = new C13214fq8(Dp8.a, null);
    private static final AtomicInteger k = new AtomicInteger();

    /* synthetic */ AbstractC11344cq8(Lp8 lp8, String str, Object obj, boolean z, AbstractC10581bq8 abstractC10581bq8) {
        if (lp8.b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.a = lp8;
        this.b = str;
        this.c = obj;
        this.f = true;
    }

    public static void d() {
        k.incrementAndGet();
    }

    public static void e(final Context context) {
        if (h == null) {
            Object obj = g;
            synchronized (obj) {
                try {
                    if (h == null) {
                        synchronized (obj) {
                            Mp8 mp8 = h;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (mp8 == null || mp8.a() != context) {
                                C18541op8.e();
                                AbstractC11965dq8.c();
                                C23386wp8.e();
                                h = new C15586jp8(context, AbstractC19733qq8.a(new InterfaceC16778lq8() { // from class: ir.nasim.Cp8
                                    @Override // ir.nasim.InterfaceC16778lq8
                                    public final Object zza() {
                                        Context context2 = context;
                                        int i2 = AbstractC11344cq8.l;
                                        return AbstractC23976xp8.a(context2);
                                    }
                                }));
                                k.incrementAndGet();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
    }

    abstract Object a(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x002f, B:20:0x003d, B:26:0x0069, B:28:0x0073, B:44:0x00a4, B:46:0x00b4, B:48:0x00c8, B:49:0x00cb, B:50:0x00cf, B:32:0x007c, B:34:0x0082, B:38:0x0094, B:40:0x009a, B:43:0x00a2, B:37:0x0092, B:24:0x0059, B:51:0x00d4, B:52:0x00d9, B:53:0x00da), top: B:59:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x002f, B:20:0x003d, B:26:0x0069, B:28:0x0073, B:44:0x00a4, B:46:0x00b4, B:48:0x00c8, B:49:0x00cb, B:50:0x00cf, B:32:0x007c, B:34:0x0082, B:38:0x0094, B:40:0x009a, B:43:0x00a2, B:37:0x0092, B:24:0x0059, B:51:0x00d4, B:52:0x00d9, B:53:0x00da), top: B:59:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b() {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11344cq8.b():java.lang.Object");
    }

    public final String c() {
        String str = this.a.d;
        return this.b;
    }
}
