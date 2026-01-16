package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.sY7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20754sY7 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    /* renamed from: ir.nasim.sY7$a */
    public static final class a extends AbstractC20754sY7 {
        private final int e;
        private final int f;

        public a(int i, int i2, int i3, int i4, int i5, int i6) {
            super(i3, i4, i5, i6, null);
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.AbstractC20754sY7
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.e == aVar.e && this.f == aVar.f && d() == aVar.d() && c() == aVar.c() && a() == aVar.a() && b() == aVar.b();
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC20754sY7
        public int hashCode() {
            return super.hashCode() + Integer.hashCode(this.e) + Integer.hashCode(this.f);
        }

        public String toString() {
            return AbstractC16016kZ6.i("ViewportHint.Access(\n            |    pageOffset=" + this.e + ",\n            |    indexInPage=" + this.f + ",\n            |    presentedItemsBefore=" + d() + ",\n            |    presentedItemsAfter=" + c() + ",\n            |    originalPageOffsetFirst=" + a() + ",\n            |    originalPageOffsetLast=" + b() + ",\n            |)", null, 1, null);
        }
    }

    /* renamed from: ir.nasim.sY7$b */
    public static final class b extends AbstractC20754sY7 {
        public b(int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4, null);
        }

        public String toString() {
            return AbstractC16016kZ6.i("ViewportHint.Initial(\n            |    presentedItemsBefore=" + d() + ",\n            |    presentedItemsAfter=" + c() + ",\n            |    originalPageOffsetFirst=" + a() + ",\n            |    originalPageOffsetLast=" + b() + ",\n            |)", null, 1, null);
        }
    }

    /* renamed from: ir.nasim.sY7$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ AbstractC20754sY7(int i, int i2, int i3, int i4, ED1 ed1) {
        this(i, i2, i3, i4);
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public final int e(EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        int i = c.a[enumC16433lG3.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
        }
        if (i == 2) {
            return this.a;
        }
        if (i == 3) {
            return this.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC20754sY7)) {
            return false;
        }
        AbstractC20754sY7 abstractC20754sY7 = (AbstractC20754sY7) obj;
        return this.a == abstractC20754sY7.a && this.b == abstractC20754sY7.b && this.c == abstractC20754sY7.c && this.d == abstractC20754sY7.d;
    }

    public int hashCode() {
        return Integer.hashCode(this.a) + Integer.hashCode(this.b) + Integer.hashCode(this.c) + Integer.hashCode(this.d);
    }

    private AbstractC20754sY7(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }
}
