package androidx.compose.ui.input.key;

import androidx.compose.ui.e;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public abstract class a {
    public static final e a(e eVar, UA2 ua2) {
        return eVar.i(new KeyInputElement(ua2, null));
    }

    public static final e b(e eVar, UA2 ua2) {
        return eVar.i(new KeyInputElement(null, ua2));
    }
}
