package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;

/* renamed from: ir.nasim.t98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC21132t98 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.t98$a */
    public static final class a {
        private static final boolean b = false;
        static final /* synthetic */ a a = new a();
        private static final String c = AbstractC10882cM5.b(InterfaceC21132t98.class).p();
        private static InterfaceC21806u98 d = C19303q72.a;

        private a() {
        }

        public final InterfaceC21132t98 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return d.a(new C22396v98(Ca8.a, b(context)));
        }

        public final InterfaceC18147o98 b(Context context) {
            AbstractC13042fc3.i(context, "context");
            C6834Pe2 c6834Pe2 = null;
            try {
                WindowLayoutComponent windowLayoutComponentM = C22990w96.a.m();
                if (windowLayoutComponentM != null) {
                    c6834Pe2 = new C6834Pe2(windowLayoutComponentM);
                }
            } catch (Throwable unused) {
                if (b) {
                    Log.d(c, "Failed to load WindowExtensions");
                }
            }
            return c6834Pe2 == null ? MB6.c.a(context) : c6834Pe2;
        }
    }

    static InterfaceC21132t98 a(Context context) {
        return a.a(context);
    }

    InterfaceC4557Fq2 b(Activity activity);
}
