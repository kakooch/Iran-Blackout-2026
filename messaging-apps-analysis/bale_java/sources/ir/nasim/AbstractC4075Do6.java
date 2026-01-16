package ir.nasim;

import ir.nasim.AT;

/* renamed from: ir.nasim.Do6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC4075Do6 {

    /* renamed from: ir.nasim.Do6$a */
    public static abstract class a {
        public abstract AbstractC4075Do6 a();

        abstract a b(C11515d82 c11515d82);

        abstract a c(AbstractC18976pa2 abstractC18976pa2);

        abstract a d(InterfaceC19191pv7 interfaceC19191pv7);

        public abstract a e(AbstractC5792Kv7 abstractC5792Kv7);

        public abstract a f(String str);
    }

    AbstractC4075Do6() {
    }

    public static a a() {
        return new AT.b();
    }

    public abstract C11515d82 b();

    abstract AbstractC18976pa2 c();

    public byte[] d() {
        return (byte[]) e().apply(c().b());
    }

    abstract InterfaceC19191pv7 e();

    public abstract AbstractC5792Kv7 f();

    public abstract String g();
}
