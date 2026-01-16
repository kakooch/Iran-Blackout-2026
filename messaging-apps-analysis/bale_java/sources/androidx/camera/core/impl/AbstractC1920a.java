package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.w;
import ir.nasim.AbstractC19849r27;
import ir.nasim.C15116j22;
import java.util.List;

/* renamed from: androidx.camera.core.impl.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1920a {
    AbstractC1920a() {
    }

    public static AbstractC1920a a(AbstractC19849r27 abstractC19849r27, int i, Size size, C15116j22 c15116j22, List list, j jVar, Range range) {
        return new C1921b(abstractC19849r27, i, size, c15116j22, list, jVar, range);
    }

    public abstract List b();

    public abstract C15116j22 c();

    public abstract int d();

    public abstract j e();

    public abstract Size f();

    public abstract AbstractC19849r27 g();

    public abstract Range h();

    public w i(j jVar) {
        w.a aVarD = w.a(f()).b(c()).d(jVar);
        if (h() != null) {
            aVarD.c(h());
        }
        return aVarD.a();
    }
}
