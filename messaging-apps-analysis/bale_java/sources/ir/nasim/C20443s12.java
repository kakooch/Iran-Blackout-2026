package ir.nasim;

import ir.nasim.C24708z44;
import java.util.List;

/* renamed from: ir.nasim.s12, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20443s12 implements InterfaceC6873Pi5 {
    private final long a;
    private final WH1 b;
    private final int c;
    private final InterfaceC14603iB2 d;
    private final C24708z44.a e;
    private final C24708z44.a f;
    private final C24708z44.a g;
    private final C24708z44.a h;
    private final C24708z44.b i;
    private final C24708z44.b j;
    private final C24708z44.b k;
    private final C24708z44.b l;
    private final C24708z44.b m;

    public /* synthetic */ C20443s12(long j, WH1 wh1, int i, InterfaceC14603iB2 interfaceC14603iB2, ED1 ed1) {
        this(j, wh1, i, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC6873Pi5
    public long a(C25005za3 c25005za3, long j, EnumC12613eu3 enumC12613eu3, long j2) {
        int iA;
        int i = 0;
        List listP = AbstractC10360bX0.p(this.e, this.f, C22045ua3.k(c25005za3.e()) < C4414Fa3.g(j) / 2 ? this.g : this.h);
        int size = listP.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                iA = 0;
                break;
            }
            iA = ((C24708z44.a) listP.get(i2)).a(c25005za3, j, C4414Fa3.g(j2), enumC12613eu3);
            if (i2 == AbstractC10360bX0.o(listP) || (iA >= 0 && C4414Fa3.g(j2) + iA <= C4414Fa3.g(j))) {
                break;
            }
            i2++;
        }
        List listP2 = AbstractC10360bX0.p(this.i, this.j, this.k, C22045ua3.l(c25005za3.e()) < C4414Fa3.f(j) / 2 ? this.l : this.m);
        int size2 = listP2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            int iA2 = ((C24708z44.b) listP2.get(i3)).a(c25005za3, j, C4414Fa3.f(j2));
            if (i3 == AbstractC10360bX0.o(listP2) || (iA2 >= this.c && C4414Fa3.f(j2) + iA2 <= C4414Fa3.f(j) - this.c)) {
                i = iA2;
                break;
            }
        }
        long jA = AbstractC22635va3.a(iA, i);
        this.d.invoke(c25005za3, AbstractC3239Aa3.a(jA, j2));
        return jA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20443s12)) {
            return false;
        }
        C20443s12 c20443s12 = (C20443s12) obj;
        return C19557qZ1.d(this.a, c20443s12.a) && AbstractC13042fc3.d(this.b, c20443s12.b) && this.c == c20443s12.c && AbstractC13042fc3.d(this.d, c20443s12.d);
    }

    public int hashCode() {
        return (((((C19557qZ1.g(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) C19557qZ1.h(this.a)) + ", density=" + this.b + ", verticalMargin=" + this.c + ", onPositionCalculated=" + this.d + ')';
    }

    private C20443s12(long j, WH1 wh1, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = j;
        this.b = wh1;
        this.c = i;
        this.d = interfaceC14603iB2;
        int iB0 = wh1.B0(C19557qZ1.e(j));
        C24708z44 c24708z44 = C24708z44.a;
        this.e = c24708z44.g(iB0);
        this.f = c24708z44.d(iB0);
        this.g = c24708z44.e(0);
        this.h = c24708z44.f(0);
        int iB02 = wh1.B0(C19557qZ1.f(j));
        this.i = c24708z44.h(iB02);
        this.j = c24708z44.a(iB02);
        this.k = c24708z44.c(iB02);
        this.l = c24708z44.i(i);
        this.m = c24708z44.b(i);
    }

    public /* synthetic */ C20443s12(long j, WH1 wh1, int i, InterfaceC14603iB2 interfaceC14603iB2, int i2, ED1 ed1) {
        this(j, wh1, (i2 & 4) != 0 ? wh1.B0(AbstractC22938w44.j()) : i, (i2 & 8) != 0 ? a.e : interfaceC14603iB2, null);
    }

    /* renamed from: ir.nasim.s12$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C25005za3) obj, (C25005za3) obj2);
            return C19938rB7.a;
        }

        public final void a(C25005za3 c25005za3, C25005za3 c25005za32) {
        }
    }
}
