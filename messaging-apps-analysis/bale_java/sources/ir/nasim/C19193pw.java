package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.pw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19193pw extends AbstractC24063xz {
    private String a;
    private byte[] b;

    public C19193pw(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.d(2);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 7;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.a;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        byte[] bArr = this.b;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct BinaryMessage{}";
    }

    public C19193pw() {
    }
}
