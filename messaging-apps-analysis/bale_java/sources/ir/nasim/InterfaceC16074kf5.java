package ir.nasim;

import android.os.Build;
import android.view.View;

/* renamed from: ir.nasim.kf5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC16074kf5 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.kf5$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final InterfaceC16074kf5 a() {
            if (LM3.d(0, 1, null)) {
                return Build.VERSION.SDK_INT == 28 ? C16665lf5.b : C17256mf5.b;
            }
            throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
        }
    }

    InterfaceC15483jf5 a(View view, boolean z, long j, float f, float f2, boolean z2, WH1 wh1, float f3);

    boolean b();
}
