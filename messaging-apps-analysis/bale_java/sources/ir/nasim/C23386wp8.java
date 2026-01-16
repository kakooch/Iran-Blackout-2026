package ir.nasim;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

/* renamed from: ir.nasim.wp8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23386wp8 implements InterfaceC21610tp8 {
    private static C23386wp8 c;
    private final Context a;
    private final ContentObserver b;

    private C23386wp8() {
        this.a = null;
        this.b = null;
    }

    static C23386wp8 b(Context context) {
        C23386wp8 c23386wp8;
        synchronized (C23386wp8.class) {
            try {
                if (c == null) {
                    c = F35.c(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C23386wp8(context) : new C23386wp8();
                }
                c23386wp8 = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c23386wp8;
    }

    static synchronized void e() {
        Context context;
        try {
            C23386wp8 c23386wp8 = c;
            if (c23386wp8 != null && (context = c23386wp8.a) != null && c23386wp8.b != null) {
                context.getContentResolver().unregisterContentObserver(c.b);
            }
            c = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC21610tp8
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String a(final String str) {
        Context context = this.a;
        if (context != null && !AbstractC13204fp8.a(context)) {
            try {
                return (String) AbstractC20332rp8.a(new InterfaceC20923sp8() { // from class: ir.nasim.up8
                    @Override // ir.nasim.InterfaceC20923sp8
                    public final Object zza() {
                        return this.a.d(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    final /* synthetic */ String d(String str) {
        return AbstractC11334cp8.a(this.a.getContentResolver(), str, null);
    }

    private C23386wp8(Context context) {
        this.a = context;
        C22790vp8 c22790vp8 = new C22790vp8(this, null);
        this.b = c22790vp8;
        context.getContentResolver().registerContentObserver(AbstractC11334cp8.a, true, c22790vp8);
    }
}
