package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Kz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5820Kz extends AbstractC17902nl0 {
    private List a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.o(1);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.l(1, this.a);
    }

    public String toString() {
        return "struct MessagesDeleteDates{}";
    }
}
