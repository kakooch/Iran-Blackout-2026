package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.pi5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19059pi5 {
    private static final int a = AbstractC24791zC5.pooling_container_listener_holder_tag;
    private static final int b = AbstractC24791zC5.is_pooling_container_tag;

    public static final void a(View view, InterfaceC19650qi5 interfaceC19650qi5) {
        AbstractC13042fc3.i(view, "<this>");
        AbstractC13042fc3.i(interfaceC19650qi5, "listener");
        b(view).a(interfaceC19650qi5);
    }

    private static final C20259ri5 b(View view) {
        int i = a;
        C20259ri5 c20259ri5 = (C20259ri5) view.getTag(i);
        if (c20259ri5 != null) {
            return c20259ri5;
        }
        C20259ri5 c20259ri52 = new C20259ri5();
        view.setTag(i, c20259ri52);
        return c20259ri52;
    }

    public static final boolean c(View view) {
        AbstractC13042fc3.i(view, "<this>");
        Object tag = view.getTag(b);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean d(View view) {
        AbstractC13042fc3.i(view, "<this>");
        for (Object obj : NW7.b(view)) {
            if ((obj instanceof View) && c((View) obj)) {
                return true;
            }
        }
        return false;
    }

    public static final void e(View view, InterfaceC19650qi5 interfaceC19650qi5) {
        AbstractC13042fc3.i(view, "<this>");
        AbstractC13042fc3.i(interfaceC19650qi5, "listener");
        b(view).b(interfaceC19650qi5);
    }
}
