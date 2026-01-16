package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.os.Vibrator;

/* renamed from: ir.nasim.jU2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15376jU2 {
    public static final C15376jU2 a = new C15376jU2();

    private C15376jU2() {
    }

    public final boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 31 && ((Vibrator) context.getSystemService(Vibrator.class)).areAllPrimitivesSupported(1, 7, 2);
    }
}
