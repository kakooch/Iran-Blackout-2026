package ir.nasim;

import android.graphics.Matrix;
import ir.nasim.C16051kd2;

/* renamed from: ir.nasim.d43, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11476d43 implements W13 {
    public static W13 c(C14935ij7 c14935ij7, long j, int i, Matrix matrix) {
        return new C14775iT(c14935ij7, j, i, matrix);
    }

    @Override // ir.nasim.W13
    public void a(C16051kd2.b bVar) {
        bVar.m(d());
    }

    @Override // ir.nasim.W13
    public abstract C14935ij7 b();

    public abstract int d();

    public abstract Matrix e();

    @Override // ir.nasim.W13
    public abstract long getTimestamp();
}
