package ir.nasim;

import android.content.Context;
import android.os.Build;

/* renamed from: ir.nasim.Gu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4842Gu2 {
    public static final C4842Gu2 a = new C4842Gu2();

    private C4842Gu2() {
    }

    public final int a(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return C5076Hu2.a.a(context);
        }
        return 0;
    }
}
