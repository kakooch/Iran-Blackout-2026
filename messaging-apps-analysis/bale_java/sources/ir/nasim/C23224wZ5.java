package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.wZ5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23224wZ5 extends AbstractC10365bX5 {
    private List b;

    public static C23224wZ5 s(byte[] bArr) {
        return (C23224wZ5) AbstractC16720ll0.b(new C23224wZ5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C16993mD());
        }
        this.b = c19084pl0.p(1, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
    }

    public String toString() {
        return "response GetUsersDefaultCardNumber{}";
    }
}
