package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.xZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23814xZ5 extends AbstractC10365bX5 {
    private List b;

    public static C23814xZ5 s(byte[] bArr) {
        return (C23814xZ5) AbstractC16720ll0.b(new C23814xZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = new ArrayList();
        Iterator it = c19084pl0.l(1).iterator();
        while (it.hasNext()) {
            this.b.add(AbstractC19948rD.r((byte[]) it.next()));
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.b(1, ((AbstractC19948rD) it.next()).q());
        }
    }

    public String toString() {
        return "response GetUsersPresence{}";
    }
}
