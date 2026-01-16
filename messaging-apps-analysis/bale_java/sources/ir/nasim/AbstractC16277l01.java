package ir.nasim;

import java.util.Comparator;

/* renamed from: ir.nasim.l01, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16277l01 {
    private static final AbstractC16277l01 a = new a();
    private static final AbstractC16277l01 b = new b(-1);
    private static final AbstractC16277l01 c = new b(1);

    /* renamed from: ir.nasim.l01$a */
    class a extends AbstractC16277l01 {
        a() {
            super(null);
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 d(int i, int i2) {
            return k(AbstractC8236Vc3.e(i, i2));
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 e(long j, long j2) {
            return k(AbstractC24852zJ3.a(j, j2));
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 f(Object obj, Object obj2, Comparator comparator) {
            return k(comparator.compare(obj, obj2));
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 g(boolean z, boolean z2) {
            return k(AbstractC8778Xh0.a(z, z2));
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 h(boolean z, boolean z2) {
            return k(AbstractC8778Xh0.a(z2, z));
        }

        @Override // ir.nasim.AbstractC16277l01
        public int i() {
            return 0;
        }

        AbstractC16277l01 k(int i) {
            return i < 0 ? AbstractC16277l01.b : i > 0 ? AbstractC16277l01.c : AbstractC16277l01.a;
        }
    }

    private AbstractC16277l01() {
    }

    public static AbstractC16277l01 j() {
        return a;
    }

    public abstract AbstractC16277l01 d(int i, int i2);

    public abstract AbstractC16277l01 e(long j, long j2);

    public abstract AbstractC16277l01 f(Object obj, Object obj2, Comparator comparator);

    public abstract AbstractC16277l01 g(boolean z, boolean z2);

    public abstract AbstractC16277l01 h(boolean z, boolean z2);

    public abstract int i();

    /* synthetic */ AbstractC16277l01(a aVar) {
        this();
    }

    /* renamed from: ir.nasim.l01$b */
    private static final class b extends AbstractC16277l01 {
        final int d;

        b(int i) {
            super(null);
            this.d = i;
        }

        @Override // ir.nasim.AbstractC16277l01
        public int i() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 d(int i, int i2) {
            return this;
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 e(long j, long j2) {
            return this;
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 g(boolean z, boolean z2) {
            return this;
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 h(boolean z, boolean z2) {
            return this;
        }

        @Override // ir.nasim.AbstractC16277l01
        public AbstractC16277l01 f(Object obj, Object obj2, Comparator comparator) {
            return this;
        }
    }
}
