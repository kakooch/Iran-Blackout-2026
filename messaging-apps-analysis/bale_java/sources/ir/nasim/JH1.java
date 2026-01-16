package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class JH1 extends AbstractC17902nl0 {
    private HashMap a = new HashMap();

    public static JH1 q(byte[] bArr) {
        return (JH1) AbstractC16720ll0.b(new JH1(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a.clear();
        int iM = c19084pl0.m(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iM; i++) {
            arrayList.add(new WG1());
        }
        for (WG1 wg1 : c19084pl0.p(1, arrayList)) {
            this.a.put(wg1.r(), wg1);
        }
    }

    public HashMap r() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, new ArrayList(this.a.values()));
    }
}
