package ir.nasim;

import android.graphics.Outline;

/* renamed from: ir.nasim.gN4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13524gN4 {
    public static final C13524gN4 a = new C13524gN4();

    private C13524gN4() {
    }

    public final void a(Outline outline, V05 v05) {
        if (!(v05 instanceof C19724qq)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        outline.setPath(((C19724qq) v05).u());
    }
}
