package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.rC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19939rC extends VB {
    private int a;
    private byte[] b;

    public C19939rC(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        throw new IOException("Parsing is unsupported");
    }

    @Override // ir.nasim.VB
    public int s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.j(this.b);
    }
}
