package ir.nasim;

import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: ir.nasim.qp, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19714qp implements InterfaceC17551n93 {
    private final RandomAccessFile a;

    public C19714qp(String str) {
        this.a = new RandomAccessFile(str, "r");
    }

    @Override // ir.nasim.InterfaceC17551n93
    public C9316Zk2 O0(int i, int i2) throws IOException {
        String name;
        try {
            byte[] bArr = new byte[i2];
            this.a.seek(i);
            this.a.read(bArr, 0, i2);
            return new C9316Zk2(i2, bArr);
        } catch (Exception e) {
            if (C19714qp.class.isAnonymousClass()) {
                name = C19714qp.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C19714qp.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "read", e);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.a.close();
        } catch (IOException unused) {
        }
    }
}
