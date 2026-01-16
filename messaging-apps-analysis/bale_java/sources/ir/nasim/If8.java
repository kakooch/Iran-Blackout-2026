package ir.nasim;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;

/* loaded from: classes3.dex */
public final class If8 {
    private final SparseIntArray a = new SparseIntArray();
    private com.google.android.gms.common.b b;

    public If8(com.google.android.gms.common.b bVar) {
        AbstractC3795Cj5.j(bVar);
        this.b = bVar;
    }

    public final int a(Context context, int i) {
        return this.a.get(i, -1);
    }

    public final int b(Context context, a.f fVar) {
        AbstractC3795Cj5.j(context);
        AbstractC3795Cj5.j(fVar);
        int i = 0;
        if (!fVar.h()) {
            return 0;
        }
        int iN = fVar.n();
        int iA = a(context, iN);
        if (iA == -1) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.a.size()) {
                    i = -1;
                    break;
                }
                int iKeyAt = this.a.keyAt(i2);
                if (iKeyAt > iN && this.a.get(iKeyAt) == 0) {
                    break;
                }
                i2++;
            }
            iA = i == -1 ? this.b.h(context, iN) : i;
            this.a.put(iN, iA);
        }
        return iA;
    }

    public final void c() {
        this.a.clear();
    }
}
