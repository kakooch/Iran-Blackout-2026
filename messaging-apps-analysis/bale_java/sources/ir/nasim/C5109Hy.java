package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Hy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5109Hy extends AbstractC17902nl0 {
    private List a;

    public C5109Hy(List list) {
        this.a = list;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C4875Gy());
        }
        this.a = c19084pl0.p(1, arrayList);
    }

    public List q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
    }

    public String toString() {
        return "struct InlineKeyboardButtonList{}";
    }

    public C5109Hy() {
    }
}
