package ir.nasim;

import android.util.Base64;
import ir.nasim.MT;

/* renamed from: ir.nasim.Kv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5792Kv7 {

    /* renamed from: ir.nasim.Kv7$a */
    public static abstract class a {
        public abstract AbstractC5792Kv7 a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(EnumC5979Lq5 enumC5979Lq5);
    }

    public static a a() {
        return new MT.b().d(EnumC5979Lq5.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract EnumC5979Lq5 d();

    public boolean e() {
        return c() != null;
    }

    public AbstractC5792Kv7 f(EnumC5979Lq5 enumC5979Lq5) {
        return a().b(b()).d(enumC5979Lq5).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2));
    }
}
