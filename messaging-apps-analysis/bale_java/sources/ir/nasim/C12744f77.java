package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import ir.nasim.tgwidgets.editor.messenger.C21457d;

/* renamed from: ir.nasim.f77, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C12744f77 extends C10130b77 {
    @Override // ir.nasim.C10130b77, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = AbstractC20488s57.d(t1, t1.e(z), z);
        this.e = AbstractC20488s57.d(t1, t1.e(z), z);
        if ((this.b & 2) != 0) {
            this.f = t1.c(z);
            try {
                this.i = new BitmapDrawable(C21457d.j0(this.f, "b"));
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
            }
        }
        this.g = t1.e(z);
    }
}
