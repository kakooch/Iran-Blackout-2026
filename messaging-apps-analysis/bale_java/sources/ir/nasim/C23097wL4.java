package ir.nasim;

import java.security.MessageDigest;

/* renamed from: ir.nasim.wL4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23097wL4 {
    private static final b e = new a();
    private final Object a;
    private final b b;
    private final String c;
    private volatile byte[] d;

    /* renamed from: ir.nasim.wL4$b */
    public interface b {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    private C23097wL4(String str, Object obj, b bVar) {
        this.c = AbstractC3322Aj5.b(str);
        this.a = obj;
        this.b = (b) AbstractC3322Aj5.d(bVar);
    }

    public static C23097wL4 a(String str, Object obj, b bVar) {
        return new C23097wL4(str, obj, bVar);
    }

    private static b b() {
        return e;
    }

    private byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(InterfaceC14373ho3.a);
        }
        return this.d;
    }

    public static C23097wL4 e(String str) {
        return new C23097wL4(str, null, b());
    }

    public static C23097wL4 f(String str, Object obj) {
        return new C23097wL4(str, obj, b());
    }

    public Object c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C23097wL4) {
            return this.c.equals(((C23097wL4) obj).c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + "'}";
    }

    /* renamed from: ir.nasim.wL4$a */
    class a implements b {
        a() {
        }

        @Override // ir.nasim.C23097wL4.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }
}
