package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Uz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C8205Uz extends AbstractC24063xz {
    private byte[] a;
    private byte[] b;
    private int c;
    private byte[] d;

    public C8205Uz(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        this.a = bArr;
        this.b = bArr2;
        this.c = i;
        this.d = bArr3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.d(1);
        this.b = c19084pl0.d(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.d(4);
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 11;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        byte[] bArr = this.a;
        if (bArr == null) {
            throw new IOException();
        }
        c19675ql0.b(1, bArr);
        byte[] bArr2 = this.b;
        if (bArr2 == null) {
            throw new IOException();
        }
        c19675ql0.b(2, bArr2);
        c19675ql0.f(3, this.c);
        byte[] bArr3 = this.d;
        if (bArr3 == null) {
            throw new IOException();
        }
        c19675ql0.b(4, bArr3);
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct NasimEncryptedMessage{}";
    }

    public byte[] u() {
        return this.a;
    }

    public byte[] w() {
        return this.b;
    }

    public int y() {
        return this.c;
    }

    public byte[] z() {
        return this.d;
    }

    public C8205Uz() {
    }
}
