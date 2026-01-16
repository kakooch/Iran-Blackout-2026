package ir.nasim;

import ir.nasim.AbstractC13460gG3;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.d3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C11462d3 {
    private final a[] a;
    private final AbstractC13460gG3.a[] b;
    private final BJ c;
    private boolean d;

    /* renamed from: ir.nasim.d3$a */
    public enum a {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    /* renamed from: ir.nasim.d3$b */
    public static final class b {
        private final EnumC16433lG3 a;
        private ZT4 b;

        public b(EnumC16433lG3 enumC16433lG3, ZT4 zt4) {
            AbstractC13042fc3.i(enumC16433lG3, "loadType");
            AbstractC13042fc3.i(zt4, "pagingState");
            this.a = enumC16433lG3;
            this.b = zt4;
        }

        public final EnumC16433lG3 a() {
            return this.a;
        }

        public final ZT4 b() {
            return this.b;
        }

        public final void c(ZT4 zt4) {
            AbstractC13042fc3.i(zt4, "<set-?>");
            this.b = zt4;
        }
    }

    /* renamed from: ir.nasim.d3$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
            int[] iArr2 = new int[a.values().length];
            try {
                iArr2[a.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[a.REQUIRES_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[a.UNBLOCKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.d3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ EnumC16433lG3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(EnumC16433lG3 enumC16433lG3) {
            super(1);
            this.e = enumC16433lG3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(b bVar) {
            AbstractC13042fc3.i(bVar, "it");
            return Boolean.valueOf(bVar.a() == this.e);
        }
    }

    public C11462d3() {
        int length = EnumC16433lG3.values().length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            aVarArr[i] = a.UNBLOCKED;
        }
        this.a = aVarArr;
        int length2 = EnumC16433lG3.values().length;
        AbstractC13460gG3.a[] aVarArr2 = new AbstractC13460gG3.a[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            aVarArr2[i2] = null;
        }
        this.b = aVarArr2;
        this.c = new BJ();
    }

    private final AbstractC13460gG3 f(EnumC16433lG3 enumC16433lG3) {
        a aVar = this.a[enumC16433lG3.ordinal()];
        BJ bj = this.c;
        if (!(bj instanceof Collection) || !bj.isEmpty()) {
            Iterator<E> it = bj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((b) it.next()).a() == enumC16433lG3) {
                    if (aVar != a.REQUIRES_REFRESH) {
                        return AbstractC13460gG3.b.b;
                    }
                }
            }
        }
        AbstractC13460gG3.a aVar2 = this.b[enumC16433lG3.ordinal()];
        if (aVar2 != null) {
            return aVar2;
        }
        int i = c.b[aVar.ordinal()];
        if (i == 1) {
            return c.a[enumC16433lG3.ordinal()] == 1 ? AbstractC13460gG3.c.b.b() : AbstractC13460gG3.c.b.a();
        }
        if (i == 2) {
            return AbstractC13460gG3.c.b.b();
        }
        if (i == 3) {
            return AbstractC13460gG3.c.b.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(EnumC16433lG3 enumC16433lG3, ZT4 zt4) {
        Object next;
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(zt4, "pagingState");
        Iterator<E> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((b) next).a() == enumC16433lG3) {
                break;
            }
        }
        b bVar = (b) next;
        if (bVar != null) {
            bVar.c(zt4);
            return false;
        }
        a aVar = this.a[enumC16433lG3.ordinal()];
        if (aVar == a.REQUIRES_REFRESH && enumC16433lG3 != EnumC16433lG3.REFRESH) {
            this.c.add(new b(enumC16433lG3, zt4));
            return false;
        }
        if (aVar != a.UNBLOCKED && enumC16433lG3 != EnumC16433lG3.REFRESH) {
            return false;
        }
        EnumC16433lG3 enumC16433lG32 = EnumC16433lG3.REFRESH;
        if (enumC16433lG3 == enumC16433lG32) {
            k(enumC16433lG32, null);
        }
        if (this.b[enumC16433lG3.ordinal()] == null) {
            return this.c.add(new b(enumC16433lG3, zt4));
        }
        return false;
    }

    public final void b() {
        int length = this.b.length;
        for (int i = 0; i < length; i++) {
            this.b[i] = null;
        }
    }

    public final void c(EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13610gX0.K(this.c, new d(enumC16433lG3));
    }

    public final void d() {
        this.c.clear();
    }

    public final C14653iG3 e() {
        return new C14653iG3(f(EnumC16433lG3.REFRESH), f(EnumC16433lG3.PREPEND), f(EnumC16433lG3.APPEND));
    }

    public final XV4 g() {
        Object next;
        Iterator<E> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            b bVar = (b) next;
            if (bVar.a() != EnumC16433lG3.REFRESH && this.a[bVar.a().ordinal()] == a.UNBLOCKED) {
                break;
            }
        }
        b bVar2 = (b) next;
        if (bVar2 != null) {
            return AbstractC4616Fw7.a(bVar2.a(), bVar2.b());
        }
        return null;
    }

    public final ZT4 h() {
        Object next;
        Iterator<E> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((b) next).a() == EnumC16433lG3.REFRESH) {
                break;
            }
        }
        b bVar = (b) next;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public final boolean i() {
        return this.d;
    }

    public final void j(EnumC16433lG3 enumC16433lG3, a aVar) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(aVar, "state");
        this.a[enumC16433lG3.ordinal()] = aVar;
    }

    public final void k(EnumC16433lG3 enumC16433lG3, AbstractC13460gG3.a aVar) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        this.b[enumC16433lG3.ordinal()] = aVar;
    }

    public final void l(boolean z) {
        this.d = z;
    }
}
