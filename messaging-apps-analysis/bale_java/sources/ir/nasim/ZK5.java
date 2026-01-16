package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class ZK5 {
    private final UE2 a;
    private final List b;

    public ZK5(UE2 ue2) {
        this.a = ue2;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new VE2(ue2, new int[]{1}));
    }

    private VE2 a(int i) {
        if (i >= this.b.size()) {
            List list = this.b;
            VE2 ve2I = (VE2) list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                UE2 ue2 = this.a;
                ve2I = ve2I.i(new VE2(ue2, new int[]{1, ue2.c((size - 1) + ue2.d())}));
                this.b.add(ve2I);
            }
        }
        return (VE2) this.b.get(i);
    }

    public void b(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        VE2 ve2A = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new VE2(this.a, iArr2).j(i, 1).b(ve2A)[1].e();
        int length2 = i - iArrE.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }
}
