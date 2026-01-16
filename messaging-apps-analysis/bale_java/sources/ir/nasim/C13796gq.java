package ir.nasim;

import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: ir.nasim.gq, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13796gq implements DN4 {
    private final RandomAccessFile a;

    public C13796gq(String str, int i) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rws");
        this.a = randomAccessFile;
        randomAccessFile.setLength(i);
    }

    @Override // ir.nasim.DN4
    public synchronized boolean a(int i, byte[] bArr, int i2, int i3) {
        String name;
        boolean z;
        try {
            this.a.seek(i);
            this.a.write(bArr, i2, i3);
            z = true;
        } catch (IOException e) {
            if (C13796gq.class.isAnonymousClass()) {
                name = C13796gq.class.getName();
                if (name.length() <= 23) {
                    AbstractC13042fc3.f(name);
                } else {
                    AbstractC13042fc3.f(name);
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C13796gq.class.getSimpleName();
                if (name.length() <= 23) {
                    AbstractC13042fc3.f(name);
                } else {
                    AbstractC13042fc3.f(name);
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "write", e);
            z = false;
        }
        return z;
    }

    @Override // ir.nasim.DN4
    public synchronized boolean close() {
        String name;
        boolean z;
        try {
            this.a.getFD().sync();
            this.a.close();
            z = true;
        } catch (IOException e) {
            if (C13796gq.class.isAnonymousClass()) {
                name = C13796gq.class.getName();
                if (name.length() <= 23) {
                    AbstractC13042fc3.f(name);
                } else {
                    AbstractC13042fc3.f(name);
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C13796gq.class.getSimpleName();
                if (name.length() <= 23) {
                    AbstractC13042fc3.f(name);
                } else {
                    AbstractC13042fc3.f(name);
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "close", e);
            z = false;
        }
        return z;
    }
}
