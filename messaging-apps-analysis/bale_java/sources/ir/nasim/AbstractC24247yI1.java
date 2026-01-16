package ir.nasim;

import ir.nasim.C24841zI1;

/* renamed from: ir.nasim.yI1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24247yI1 {

    /* renamed from: ir.nasim.yI1$a */
    public static final class a extends AbstractC24247yI1 {
        public static final a a = new a();
        private static final int b;

        static {
            C24841zI1.a aVar = C24841zI1.c;
            b = (~(aVar.k() | aVar.e())) & aVar.b();
        }

        private a() {
        }

        @Override // ir.nasim.AbstractC24247yI1
        public int a() {
            return b;
        }
    }

    /* renamed from: ir.nasim.yI1$b */
    public static final class b extends AbstractC24247yI1 {
        public static final b a = new b();

        private b() {
        }

        @Override // ir.nasim.AbstractC24247yI1
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
