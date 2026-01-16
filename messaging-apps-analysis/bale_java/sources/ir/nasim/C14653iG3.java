package ir.nasim;

import ir.nasim.AbstractC13460gG3;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iG3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14653iG3 {
    public static final a f = new a(null);
    private static final C14653iG3 g;
    private final AbstractC13460gG3 a;
    private final AbstractC13460gG3 b;
    private final AbstractC13460gG3 c;
    private final boolean d;
    private final boolean e;

    /* renamed from: ir.nasim.iG3$a */
    public static final class a {
        private a() {
        }

        public final C14653iG3 a() {
            return C14653iG3.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.iG3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        AbstractC13460gG3.c.a aVar = AbstractC13460gG3.c.b;
        g = new C14653iG3(aVar.b(), aVar.b(), aVar.b());
    }

    public C14653iG3(AbstractC13460gG3 abstractC13460gG3, AbstractC13460gG3 abstractC13460gG32, AbstractC13460gG3 abstractC13460gG33) {
        AbstractC13042fc3.i(abstractC13460gG3, "refresh");
        AbstractC13042fc3.i(abstractC13460gG32, "prepend");
        AbstractC13042fc3.i(abstractC13460gG33, "append");
        this.a = abstractC13460gG3;
        this.b = abstractC13460gG32;
        this.c = abstractC13460gG33;
        this.d = (abstractC13460gG3 instanceof AbstractC13460gG3.a) || (abstractC13460gG33 instanceof AbstractC13460gG3.a) || (abstractC13460gG32 instanceof AbstractC13460gG3.a);
        this.e = (abstractC13460gG3 instanceof AbstractC13460gG3.c) && (abstractC13460gG33 instanceof AbstractC13460gG3.c) && (abstractC13460gG32 instanceof AbstractC13460gG3.c);
    }

    public static /* synthetic */ C14653iG3 c(C14653iG3 c14653iG3, AbstractC13460gG3 abstractC13460gG3, AbstractC13460gG3 abstractC13460gG32, AbstractC13460gG3 abstractC13460gG33, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC13460gG3 = c14653iG3.a;
        }
        if ((i & 2) != 0) {
            abstractC13460gG32 = c14653iG3.b;
        }
        if ((i & 4) != 0) {
            abstractC13460gG33 = c14653iG3.c;
        }
        return c14653iG3.b(abstractC13460gG3, abstractC13460gG32, abstractC13460gG33);
    }

    public final C14653iG3 b(AbstractC13460gG3 abstractC13460gG3, AbstractC13460gG3 abstractC13460gG32, AbstractC13460gG3 abstractC13460gG33) {
        AbstractC13042fc3.i(abstractC13460gG3, "refresh");
        AbstractC13042fc3.i(abstractC13460gG32, "prepend");
        AbstractC13042fc3.i(abstractC13460gG33, "append");
        return new C14653iG3(abstractC13460gG3, abstractC13460gG32, abstractC13460gG33);
    }

    public final AbstractC13460gG3 d() {
        return this.c;
    }

    public final AbstractC13460gG3 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14653iG3)) {
            return false;
        }
        C14653iG3 c14653iG3 = (C14653iG3) obj;
        return AbstractC13042fc3.d(this.a, c14653iG3.a) && AbstractC13042fc3.d(this.b, c14653iG3.b) && AbstractC13042fc3.d(this.c, c14653iG3.c);
    }

    public final AbstractC13460gG3 f() {
        return this.a;
    }

    public final boolean g() {
        return this.d;
    }

    public final boolean h() {
        return this.e;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final C14653iG3 i(EnumC16433lG3 enumC16433lG3, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(abstractC13460gG3, "newState");
        int i = b.a[enumC16433lG3.ordinal()];
        if (i == 1) {
            return c(this, null, null, abstractC13460gG3, 3, null);
        }
        if (i == 2) {
            return c(this, null, abstractC13460gG3, null, 5, null);
        }
        if (i == 3) {
            return c(this, abstractC13460gG3, null, null, 6, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return "LoadStates(refresh=" + this.a + ", prepend=" + this.b + ", append=" + this.c + ')';
    }
}
