package ir.nasim;

import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.tE0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C21170tE0 implements androidx.compose.ui.focus.k {
    public static final C21170tE0 a = new C21170tE0();
    private static Boolean b;

    private C21170tE0() {
    }

    public final boolean a() {
        return b != null;
    }

    public final void c() {
        b = null;
    }

    @Override // androidx.compose.ui.focus.k
    public void u(boolean z) {
        b = Boolean.valueOf(z);
    }

    @Override // androidx.compose.ui.focus.k
    public boolean v() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        M73.c("canFocus is read before it is written");
        throw new KotlinNothingValueException();
    }
}
