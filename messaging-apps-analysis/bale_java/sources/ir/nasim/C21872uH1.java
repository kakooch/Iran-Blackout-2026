package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ir.nasim.uH1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21872uH1 extends AbstractC17902nl0 {
    private HashMap a = new HashMap();

    public static C21872uH1 q(byte[] bArr) {
        return (C21872uH1) AbstractC16720ll0.b(new C21872uH1(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a.clear();
        int iM = c19084pl0.m(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iM; i++) {
            arrayList.add(new C21198tH1());
        }
        for (C21198tH1 c21198tH1 : c19084pl0.p(1, arrayList)) {
            this.a.put(c21198tH1.q(), c21198tH1);
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
