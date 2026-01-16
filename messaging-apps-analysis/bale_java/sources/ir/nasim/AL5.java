package ir.nasim;

import ir.nasim.AbstractC23098wL5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public final class AL5 extends AbstractC23098wL5 implements InterfaceC5662Kh3 {
    private final Object[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AL5(C6432No4 c6432No4, Object[] objArr) {
        super(c6432No4);
        AbstractC13042fc3.i(objArr, "values");
        this.c = objArr;
    }

    @Override // ir.nasim.InterfaceC5662Kh3
    public List c() {
        Object[] objArr = this.c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            AbstractC23098wL5.a aVar = AbstractC23098wL5.b;
            AbstractC13042fc3.f(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
