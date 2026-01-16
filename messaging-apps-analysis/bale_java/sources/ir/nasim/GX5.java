package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class GX5 extends AbstractC10365bX5 {
    private List b;

    public static GX5 s(byte[] bArr) {
        return (GX5) AbstractC16720ll0.b(new GX5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = new ArrayList();
        Iterator it = c19084pl0.l(1).iterator();
        while (it.hasNext()) {
            this.b.add(AbstractC25211zv.r((byte[]) it.next()));
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c19675ql0.b(1, ((AbstractC25211zv) it.next()).q());
        }
    }

    public String toString() {
        return "response GetAdProvider{}";
    }
}
