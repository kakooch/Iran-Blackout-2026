package ir.nasim;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.rG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19978rG2 {
    private final Context a;
    private final InterfaceC9173Yu3 b;

    public C19978rG2(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qG2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19978rG2.b(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap.Config b(C19978rG2 c19978rG2) {
        Object objB;
        AbstractC13042fc3.i(c19978rG2, "this$0");
        try {
            C9475a16.a aVar = C9475a16.b;
            Object systemService = c19978rG2.a.getSystemService("activity");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager activityManager = (ActivityManager) systemService;
            DisplayMetrics displayMetrics = c19978rG2.a.getResources().getDisplayMetrics();
            objB = C9475a16.b((activityManager.isLowRamDevice() || activityManager.getMemoryClass() <= 128 || displayMetrics.widthPixels * displayMetrics.heightPixels <= 921600) ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Bitmap.Config config = Bitmap.Config.RGB_565;
        if (C9475a16.g(objB)) {
            objB = config;
        }
        return (Bitmap.Config) objB;
    }

    private final Bitmap.Config c() {
        return (Bitmap.Config) this.b.getValue();
    }

    public final Bitmap.Config d() {
        return c();
    }
}
