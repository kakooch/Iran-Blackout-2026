package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
public class YJ2 extends AbstractC25155zp3 {
    private final WJ2 i;

    public YJ2(List list) {
        super(list);
        int iMax = 0;
        for (int i = 0; i < list.size(); i++) {
            WJ2 wj2 = (WJ2) ((C24561yp3) list.get(i)).b;
            if (wj2 != null) {
                iMax = Math.max(iMax, wj2.f());
            }
        }
        this.i = new WJ2(new float[iMax], new int[iMax]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public WJ2 i(C24561yp3 c24561yp3, float f) {
        this.i.g((WJ2) c24561yp3.b, (WJ2) c24561yp3.c, f);
        return this.i;
    }
}
