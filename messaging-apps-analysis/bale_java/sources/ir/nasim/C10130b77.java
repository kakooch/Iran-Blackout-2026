package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import ir.nasim.tgwidgets.editor.messenger.C21457d;

/* renamed from: ir.nasim.b77, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C10130b77 extends AbstractC16333l57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        f(t1, z, true);
    }

    public void f(T1 t1, boolean z, boolean z2) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.h = t1.f(z);
        if ((this.b & 2) != 0) {
            this.f = t1.c(z);
        }
        this.g = t1.e(z);
        C18727p87 c18727p87 = new C18727p87();
        this.d = c18727p87;
        c18727p87.c = -this.h;
        c18727p87.d = 97;
        C18727p87 c18727p872 = new C18727p87();
        this.e = c18727p872;
        c18727p872.c = -this.h;
        c18727p872.d = 99;
        if (!z2 || this.f == null) {
            return;
        }
        try {
            this.i = new BitmapDrawable(C21457d.j0(this.f, "b"));
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
    }
}
