package ir.nasim;

import android.os.Build;
import android.view.inputmethod.InputConnection;

/* renamed from: ir.nasim.rF4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19971rF4 {
    public static final InterfaceInputConnectionC15243jF4 a(InputConnection inputConnection, UA2 ua2) {
        int i = Build.VERSION.SDK_INT;
        return i >= 34 ? new C19380qF4(inputConnection, ua2) : i >= 25 ? new C17607nF4(inputConnection, ua2) : new C16425lF4(inputConnection, ua2);
    }
}
