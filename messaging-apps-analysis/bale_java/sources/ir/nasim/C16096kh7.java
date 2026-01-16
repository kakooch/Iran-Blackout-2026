package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import ir.nasim.tgwidgets.editor.messenger.C21457d;

/* renamed from: ir.nasim.kh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16096kh7 extends C13714gh7 {
    @Override // ir.nasim.C13714gh7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = t1.f(z);
        this.e = AbstractC20488s57.d(t1, t1.e(z), z);
        this.f = AbstractC20488s57.d(t1, t1.e(z), z);
        if ((this.b & 2) != 0) {
            this.g = t1.c(z);
            try {
                this.j = new BitmapDrawable(C21457d.j0(this.g, "b"));
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
        }
        this.h = t1.e(z);
    }
}
