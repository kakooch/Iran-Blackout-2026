package ir.nasim;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* renamed from: ir.nasim.Ko, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5721Ko {
    public static volatile Context b;
    public static final C5721Ko a = new C5721Ko();
    public static volatile boolean c = true;
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ho
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C5721Ko.m();
        }
    });
    private static final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Io
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Long.valueOf(C5721Ko.j());
        }
    });
    private static final InterfaceC9173Yu3 f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Jo
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(C5721Ko.l());
        }
    });

    private C5721Ko() {
    }

    private final long e() {
        return ((Number) e.getValue()).longValue();
    }

    private final PackageInfo f(String str, int i) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = d().getPackageManager().getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
            AbstractC13042fc3.f(packageInfo);
            return packageInfo;
        }
        PackageInfo packageInfo2 = d().getPackageManager().getPackageInfo(str, i);
        AbstractC13042fc3.f(packageInfo2);
        return packageInfo2;
    }

    static /* synthetic */ PackageInfo g(C5721Ko c5721Ko, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return c5721Ko.f(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j() {
        C5721Ko c5721Ko = a;
        String packageName = c5721Ko.d().getPackageName();
        AbstractC13042fc3.h(packageName, "getPackageName(...)");
        return ES4.a(g(c5721Ko, packageName, 0, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l() {
        return (int) a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m() {
        C5721Ko c5721Ko = a;
        String packageName = c5721Ko.d().getPackageName();
        AbstractC13042fc3.h(packageName, "getPackageName(...)");
        String str = g(c5721Ko, packageName, 0, 2, null).versionName;
        return str == null ? "" : str;
    }

    public final Context d() {
        Context context = b;
        if (context != null) {
            return context;
        }
        AbstractC13042fc3.y("applicationContext");
        return null;
    }

    public final int h() {
        return ((Number) f.getValue()).intValue();
    }

    public final String i() {
        return (String) d.getValue();
    }

    public final void k(Context context) {
        AbstractC13042fc3.i(context, "<set-?>");
        b = context;
    }
}
