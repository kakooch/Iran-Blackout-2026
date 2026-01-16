package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import ir.nasim.tgwidgets.editor.messenger.C21457d;

/* renamed from: ir.nasim.gh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13714gh7 extends AbstractC20852si7 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.i = (iE & 4) != 0;
        this.d = t1.f(z);
        if ((this.b & 2) != 0) {
            this.g = t1.c(z);
        }
        this.h = t1.e(z);
        C18727p87 c18727p87 = new C18727p87();
        this.e = c18727p87;
        c18727p87.c = -this.d;
        c18727p87.d = 97;
        C18727p87 c18727p872 = new C18727p87();
        this.f = c18727p872;
        c18727p872.c = -this.d;
        c18727p872.d = 99;
        if (this.g != null) {
            try {
                this.j = new BitmapDrawable(C21457d.j0(this.g, "b"));
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
        }
    }
}
