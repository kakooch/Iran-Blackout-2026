package ir.nasim;

import java.io.ByteArrayOutputStream;

/* renamed from: ir.nasim.ye2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C24450ye2 extends ByteArrayOutputStream {
    public C24450ye2(int i) {
        super(i);
    }

    public final byte[] a() {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        AbstractC13042fc3.h(bArr, "buf");
        return bArr;
    }
}
