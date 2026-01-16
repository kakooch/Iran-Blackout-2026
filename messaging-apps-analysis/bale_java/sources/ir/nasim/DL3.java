package ir.nasim;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class DL3 {
    private final C8526Wi5 a;
    private final DL3 b;
    private final String c;
    protected final DataInput d;
    private CL3 e;

    public DL3(C8526Wi5 c8526Wi5, DL3 dl3, String str) {
        this.a = c8526Wi5;
        this.b = dl3;
        this.c = str;
        this.d = new DataInputStream(c8526Wi5);
    }

    protected CL3 a() {
        return this.e;
    }

    public C8526Wi5 b() {
        return this.a;
    }

    public DL3 c() {
        return this.b;
    }

    public long d() {
        return this.a.a();
    }

    public String e() {
        return this.c;
    }

    public CL3 f() {
        CL3 cl3 = this.e;
        if (cl3 != null) {
            cl3.z();
        }
        int i = this.d.readInt();
        byte[] bArr = new byte[4];
        this.d.readFully(bArr);
        CL3 cl32 = new CL3(i == 1 ? new C21193tG5(this.a, 16L, this.d.readLong() - 16) : new C21193tG5(this.a, 8L, i - 8), this, new String(bArr, "ISO8859_1"));
        this.e = cl32;
        return cl32;
    }

    public CL3 g(String str) throws IOException {
        CL3 cl3F = f();
        if (cl3F.e().matches(str)) {
            return cl3F;
        }
        throw new IOException("atom type mismatch, expected " + str + ", got " + cl3F.e());
    }
}
