package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.cw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11395cw extends AbstractC10632bw {
    private int a;
    private byte[] b;

    public C11395cw(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        throw new IOException("Parsing is unsupported");
    }

    @Override // ir.nasim.AbstractC10632bw
    public int s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.j(this.b);
    }
}
