package ir.nasim;

import android.graphics.Path;

/* renamed from: ir.nasim.Re7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7317Re7 extends AbstractC11500d67 {
    public static int i = -668906175;
    public Path h;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        byte[] bArrC = t1.c(z);
        this.g = bArrC;
        this.e = 50;
        this.d = 50;
        this.h = ir.nasim.tgwidgets.editor.messenger.G.i(ir.nasim.tgwidgets.editor.messenger.G.h(bArrC));
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(i);
        t1.o(this.b);
        t1.k(this.g);
    }
}
