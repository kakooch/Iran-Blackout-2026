package ir.nasim;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;

/* renamed from: ir.nasim.Ck0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
interface InterfaceC3799Ck0 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.Ck0$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final InterfaceC3799Ck0 a() {
            int i = Build.VERSION.SDK_INT;
            return i >= 30 ? C4750Gk0.b : i >= 29 ? C4501Fk0.b : i >= 28 ? C4267Ek0.b : C4033Dk0.b;
        }
    }

    Rect a(Activity activity);
}
