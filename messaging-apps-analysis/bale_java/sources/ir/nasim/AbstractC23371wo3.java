package ir.nasim;

import android.view.KeyEvent;

/* renamed from: ir.nasim.wo3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23371wo3 {
    public static final long a(KeyEvent keyEvent) {
        return AbstractC9353Zo3.a(keyEvent.getKeyCode());
    }

    public static final int b(KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        return action != 0 ? action != 1 ? AbstractC22775vo3.a.c() : AbstractC22775vo3.a.b() : AbstractC22775vo3.a.a();
    }

    public static final int c(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar();
    }

    public static final boolean d(KeyEvent keyEvent) {
        return keyEvent.isAltPressed();
    }

    public static final boolean e(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    public static final boolean f(KeyEvent keyEvent) {
        return keyEvent.isShiftPressed();
    }
}
