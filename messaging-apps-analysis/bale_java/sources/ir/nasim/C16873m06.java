package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.m06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16873m06 extends AbstractC10365bX5 {
    private int b;
    private byte[] c;
    private List d;

    public static C16873m06 s(byte[] bArr) {
        return (C16873m06) AbstractC16720ll0.b(new C16873m06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        this.c = c19084pl0.d(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new C4167Dz());
        }
        this.d = c19084pl0.p(3, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.b);
        byte[] bArr = this.c;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        c19675ql0.m(3, this.d);
    }

    public String toString() {
        return "response ReactionsResponse{}";
    }
}
