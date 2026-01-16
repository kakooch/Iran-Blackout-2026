package ir.nasim;

import android.graphics.Outline;

/* renamed from: ir.nasim.fN4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12906fN4 {
    public static final C12906fN4 a = new C12906fN4();

    private C12906fN4() {
    }

    public final void a(Outline outline, V05 v05) {
        if (!(v05 instanceof C19724qq)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        outline.setPath(((C19724qq) v05).u());
    }
}
