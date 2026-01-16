package ir.nasim;

import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20754sY7;
import ir.nasim.VS4;
import ir.nasim.YT4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public final class ZS4 {
    private final MT4 a;
    private final List b;
    private final List c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final InterfaceC17639nJ0 i;
    private final InterfaceC17639nJ0 j;
    private final Map k;
    private C20889sm4 l;

    public static final class a {
        private final MT4 a;
        private final InterfaceC19699qn4 b;
        private final ZS4 c;

        public a(MT4 mt4) {
            AbstractC13042fc3.i(mt4, "config");
            this.a = mt4;
            this.b = AbstractC20899sn4.b(false, 1, null);
            this.c = new ZS4(mt4, null);
        }
    }

    public /* synthetic */ class b {
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ZS4.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ZS4.this.j.h(AbstractC6392Nk0.d(ZS4.this.h));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ZS4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ZS4.this.i.h(AbstractC6392Nk0.d(ZS4.this.g));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ ZS4(MT4 mt4, ED1 ed1) {
        this(mt4);
    }

    public final InterfaceC4557Fq2 e() {
        return AbstractC6459Nq2.c0(AbstractC6459Nq2.r(this.j), new c(null));
    }

    public final InterfaceC4557Fq2 f() {
        return AbstractC6459Nq2.c0(AbstractC6459Nq2.r(this.i), new d(null));
    }

    public final ZT4 g(AbstractC20754sY7.a aVar) {
        Integer numValueOf;
        List listM1 = AbstractC15401jX0.m1(this.c);
        if (aVar != null) {
            int iO = o();
            int i = -this.d;
            int iO2 = AbstractC10360bX0.o(this.c) - this.d;
            int iG = aVar.g();
            int i2 = i;
            while (i2 < iG) {
                iO += i2 > iO2 ? this.a.a : ((YT4.b.c) this.c.get(this.d + i2)).f().size();
                i2++;
            }
            int iF = iO + aVar.f();
            if (aVar.g() < i) {
                iF -= this.a.a;
            }
            numValueOf = Integer.valueOf(iF);
        } else {
            numValueOf = null;
        }
        return new ZT4(listM1, numValueOf, this.a, o());
    }

    public final void h(VS4.a aVar) {
        AbstractC13042fc3.i(aVar, "event");
        if (aVar.h() > this.c.size()) {
            throw new IllegalStateException(("invalid drop count. have " + this.c.size() + " but wanted to drop " + aVar.h()).toString());
        }
        this.k.remove(aVar.e());
        this.l.c(aVar.e(), AbstractC13460gG3.c.b.b());
        int i = b.a[aVar.e().ordinal()];
        if (i == 2) {
            int iH = aVar.h();
            for (int i2 = 0; i2 < iH; i2++) {
                this.b.remove(0);
            }
            this.d -= aVar.h();
            t(aVar.i());
            int i3 = this.g + 1;
            this.g = i3;
            this.i.h(Integer.valueOf(i3));
            return;
        }
        if (i != 3) {
            throw new IllegalArgumentException("cannot drop " + aVar.e());
        }
        int iH2 = aVar.h();
        for (int i4 = 0; i4 < iH2; i4++) {
            this.b.remove(this.c.size() - 1);
        }
        s(aVar.i());
        int i5 = this.h + 1;
        this.h = i5;
        this.j.h(Integer.valueOf(i5));
    }

    public final VS4.a i(EnumC16433lG3 enumC16433lG3, AbstractC20754sY7 abstractC20754sY7) {
        int size;
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(abstractC20754sY7, "hint");
        VS4.a aVar = null;
        if (this.a.e == Integer.MAX_VALUE || this.c.size() <= 2 || q() <= this.a.e) {
            return null;
        }
        if (enumC16433lG3 == EnumC16433lG3.REFRESH) {
            throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + enumC16433lG3).toString());
        }
        int iO = 0;
        int i = 0;
        int i2 = 0;
        while (i < this.c.size() && q() - i2 > this.a.e) {
            int[] iArr = b.a;
            if (iArr[enumC16433lG3.ordinal()] == 2) {
                size = ((YT4.b.c) this.c.get(i)).f().size();
            } else {
                List list = this.c;
                size = ((YT4.b.c) list.get(AbstractC10360bX0.o(list) - i)).f().size();
            }
            if (((iArr[enumC16433lG3.ordinal()] == 2 ? abstractC20754sY7.d() : abstractC20754sY7.c()) - i2) - size < this.a.b) {
                break;
            }
            i2 += size;
            i++;
        }
        if (i != 0) {
            int[] iArr2 = b.a;
            int iO2 = iArr2[enumC16433lG3.ordinal()] == 2 ? -this.d : (AbstractC10360bX0.o(this.c) - this.d) - (i - 1);
            int iO3 = iArr2[enumC16433lG3.ordinal()] == 2 ? (i - 1) - this.d : AbstractC10360bX0.o(this.c) - this.d;
            if (this.a.c) {
                iO = (enumC16433lG3 == EnumC16433lG3.PREPEND ? o() : n()) + i2;
            }
            aVar = new VS4.a(enumC16433lG3, iO2, iO3, iO);
        }
        return aVar;
    }

    public final int j(EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        int i = b.a[enumC16433lG3.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        }
        if (i == 2) {
            return this.g;
        }
        if (i == 3) {
            return this.h;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Map k() {
        return this.k;
    }

    public final int l() {
        return this.d;
    }

    public final List m() {
        return this.c;
    }

    public final int n() {
        if (this.a.c) {
            return this.f;
        }
        return 0;
    }

    public final int o() {
        if (this.a.c) {
            return this.e;
        }
        return 0;
    }

    public final C20889sm4 p() {
        return this.l;
    }

    public final int q() {
        Iterator it = this.c.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((YT4.b.c) it.next()).f().size();
        }
        return size;
    }

    public final boolean r(int i, EnumC16433lG3 enumC16433lG3, YT4.b.c cVar) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(cVar, "page");
        int i2 = b.a[enumC16433lG3.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (!(!this.c.isEmpty())) {
                        throw new IllegalStateException("should've received an init before append".toString());
                    }
                    if (i != this.h) {
                        return false;
                    }
                    this.b.add(cVar);
                    s(cVar.h() == Integer.MIN_VALUE ? AbstractC23053wG5.e(n() - cVar.f().size(), 0) : cVar.h());
                    this.k.remove(EnumC16433lG3.APPEND);
                }
            } else {
                if (!(!this.c.isEmpty())) {
                    throw new IllegalStateException("should've received an init before prepend".toString());
                }
                if (i != this.g) {
                    return false;
                }
                this.b.add(0, cVar);
                this.d++;
                t(cVar.i() == Integer.MIN_VALUE ? AbstractC23053wG5.e(o() - cVar.f().size(), 0) : cVar.i());
                this.k.remove(EnumC16433lG3.PREPEND);
            }
        } else {
            if (!this.c.isEmpty()) {
                throw new IllegalStateException("cannot receive multiple init calls".toString());
            }
            if (i != 0) {
                throw new IllegalStateException("init loadId must be the initial value, 0".toString());
            }
            this.b.add(cVar);
            this.d = 0;
            s(cVar.h());
            t(cVar.i());
        }
        return true;
    }

    public final void s(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this.f = i;
    }

    public final void t(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this.e = i;
    }

    public final VS4 u(YT4.b.c cVar, EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(cVar, "<this>");
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        int[] iArr = b.a;
        int i = iArr[enumC16433lG3.ordinal()];
        int size = 0;
        if (i != 1) {
            if (i == 2) {
                size = 0 - this.d;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                size = (this.c.size() - this.d) - 1;
            }
        }
        List listE = AbstractC9766aX0.e(new C15054iv7(size, cVar.f()));
        int i2 = iArr[enumC16433lG3.ordinal()];
        if (i2 == 1) {
            return VS4.b.g.c(listE, o(), n(), this.l.d(), null);
        }
        if (i2 == 2) {
            return VS4.b.g.b(listE, o(), this.l.d(), null);
        }
        if (i2 == 3) {
            return VS4.b.g.a(listE, n(), this.l.d(), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private ZS4(MT4 mt4) {
        this.a = mt4;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = arrayList;
        this.i = DJ0.b(-1, null, null, 6, null);
        this.j = DJ0.b(-1, null, null, 6, null);
        this.k = new LinkedHashMap();
        C20889sm4 c20889sm4 = new C20889sm4();
        c20889sm4.c(EnumC16433lG3.REFRESH, AbstractC13460gG3.b.b);
        this.l = c20889sm4;
    }
}
