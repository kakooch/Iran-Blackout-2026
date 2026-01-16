package ir.nasim;

import android.content.Context;
import android.os.Build;

/* loaded from: classes5.dex */
public final class TA6 {
    public static final TA6 a = new TA6();

    private TA6() {
    }

    public final InterfaceC7742Sz6 a(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new XE1(context);
    }

    public final InterfaceC10056b03 b(Context context) {
        AbstractC13042fc3.i(context, "context");
        return Build.VERSION.SDK_INT >= 26 ? new C12579er(context) : new OA4();
    }
}
