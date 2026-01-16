package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Jz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5586Jz extends AbstractC24063xz {
    private int a;
    private byte[] b;

    public C5586Jz(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        throw new IOException("Parsing is unsupported");
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.j(this.b);
    }
}
