package ir.nasim;

import android.view.KeyEvent;

/* renamed from: ir.nasim.hm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14357hm7 {
    public static final boolean a(KeyEvent keyEvent) {
        return keyEvent.getAction() == 0 && !Character.isISOControl(keyEvent.getUnicodeChar());
    }
}
