package ir.nasim;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* renamed from: ir.nasim.tm0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C21572tm0 {
    public static final C21572tm0 a = new C21572tm0();

    private C21572tm0() {
    }

    public static final void a(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
