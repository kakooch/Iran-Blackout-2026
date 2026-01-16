package ir.nasim;

import androidx.compose.ui.e;

/* loaded from: classes2.dex */
public abstract class TG4 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(e.c cVar, SA2 sa2) {
        UG4 ug4X1 = cVar.X1();
        if (ug4X1 == null) {
            ug4X1 = new UG4((SG4) cVar);
            cVar.q2(ug4X1);
        }
        KG1.p(cVar).getSnapshotObserver().i(ug4X1, UG4.b.a(), sa2);
    }
}
