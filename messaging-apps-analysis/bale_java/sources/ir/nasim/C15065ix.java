package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.ix, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15065ix extends AbstractC17902nl0 {
    private int a;
    private byte[] b;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.d(2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        byte[] bArr = this.b;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
    }

    public String toString() {
        return "struct ContainerUpdates{}";
    }
}
