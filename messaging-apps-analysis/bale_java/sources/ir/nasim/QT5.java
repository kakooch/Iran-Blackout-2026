package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class QT5 extends TP5 {
    private List a;
    private EnumC5550Jv b;

    public QT5(List list, EnumC5550Jv enumC5550Jv) {
        this.a = list;
        this.b = enumC5550Jv;
    }

    public static QT5 r(byte[] bArr) {
        return (QT5) AbstractC16720ll0.b(new QT5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = new ArrayList();
        Iterator it = c19084pl0.n(1).iterator();
        while (it.hasNext()) {
            this.a.add(EnumC15220jD.p(((Integer) it.next()).intValue()));
        }
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.b = EnumC5550Jv.p(iH);
        }
    }

    @Override // ir.nasim.JU2
    public int q() {
        return 225;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.f(1, ((EnumC15220jD) it.next()).j());
        }
        EnumC5550Jv enumC5550Jv = this.b;
        if (enumC5550Jv != null) {
            c19675ql0.f(2, enumC5550Jv.j());
        }
    }

    public String toString() {
        return "rpc LoadGroupedDialogs{}";
    }

    public QT5() {
    }
}
