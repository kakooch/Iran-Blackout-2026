package ir.nasim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.b98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C10151b98 implements InterfaceC24081y07 {
    private final List a;
    private final long[] b;
    private final long[] c;

    public C10151b98(List list) {
        this.a = Collections.unmodifiableList(new ArrayList(list));
        this.b = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            V88 v88 = (V88) list.get(i);
            int i2 = i * 2;
            long[] jArr = this.b;
            jArr[i2] = v88.b;
            jArr[i2 + 1] = v88.c;
        }
        long[] jArr2 = this.b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(V88 v88, V88 v882) {
        return Long.compare(v88.b, v882.b);
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int a(long j) {
        int iE = AbstractC9683aN7.e(this.c, j, false, false);
        if (iE < this.c.length) {
            return iE;
        }
        return -1;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public List h(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            long[] jArr = this.b;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                V88 v88 = (V88) this.a.get(i);
                C14451hw1 c14451hw1 = v88.a;
                if (c14451hw1.e == -3.4028235E38f) {
                    arrayList2.add(v88);
                } else {
                    arrayList.add(c14451hw1);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: ir.nasim.a98
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C10151b98.c((V88) obj, (V88) obj2);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((V88) arrayList2.get(i3)).a.c().h((-1) - i3, 1).a());
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC24081y07
    public long i(int i) {
        AbstractC20011rK.a(i >= 0);
        AbstractC20011rK.a(i < this.c.length);
        return this.c[i];
    }

    @Override // ir.nasim.InterfaceC24081y07
    public int j() {
        return this.c.length;
    }
}
