package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class FG3 extends AbstractC19230q0 {
    public List a;

    public FG3() {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int iM = c19084pl0.m(1);
        int i2 = 0;
        while (i2 < iM) {
            arrayList.add(new J44(0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524287, null));
            i2++;
            i = 1;
        }
        u(c19084pl0.p(i, arrayList));
    }

    public final List s() {
        List list = this.a;
        if (list != null) {
            return list;
        }
        AbstractC13042fc3.y("messages");
        return null;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.m(1, s());
    }

    public final void u(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.a = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FG3(byte[] bArr) {
        this();
        AbstractC13042fc3.i(bArr, "data");
        load(bArr);
    }
}
