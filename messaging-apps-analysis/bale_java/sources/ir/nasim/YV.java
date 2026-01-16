package ir.nasim;

import ir.nasim.OS;

/* loaded from: classes2.dex */
public abstract class YV {

    public static abstract class a {
        public abstract YV a();

        public abstract a b(Iterable iterable);

        public abstract a c(byte[] bArr);
    }

    public static a a() {
        return new OS.b();
    }

    public abstract Iterable b();

    public abstract byte[] c();
}
