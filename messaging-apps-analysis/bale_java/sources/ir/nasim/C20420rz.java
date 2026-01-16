package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.rz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20420rz extends AbstractC17902nl0 {
    private String a;
    private AbstractC17566nB b;

    public C20420rz(String str, AbstractC17566nB abstractC17566nB) {
        this.a = str;
        this.b = abstractC17566nB;
    }

    public String getKey() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = AbstractC17566nB.r(c19084pl0.d(2));
    }

    public AbstractC17566nB q() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        AbstractC17566nB abstractC17566nB = this.b;
        if (abstractC17566nB == null) {
            throw new IOException();
        }
        c19675ql0.b(2, abstractC17566nB.q());
    }

    public String toString() {
        return "struct MapValueItem{}";
    }

    public C20420rz() {
    }
}
