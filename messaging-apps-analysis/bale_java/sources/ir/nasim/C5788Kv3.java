package ir.nasim;

import ir.nasim.InterfaceC8727Xb3;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Kv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5788Kv3 {
    private final C16232kv3 a;
    private final ArrayList b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final List g;
    private List h;
    private int i;

    /* renamed from: ir.nasim.Kv3$b */
    private static final class b implements InterfaceC20387rv3 {
        public static final b a = new b();
        private static int b;
        private static int c;

        private b() {
        }

        public void a(int i) {
            b = i;
        }

        public void b(int i) {
            c = i;
        }
    }

    /* renamed from: ir.nasim.Kv3$c */
    public static final class c {
        private final int a;
        private final List b;

        public c(int i, List list) {
            this.a = i;
            this.b = list;
        }

        public final int a() {
            return this.a;
        }

        public final List b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Kv3$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i) {
            super(1);
            this.e = i;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(a aVar) {
            return Integer.valueOf(aVar.a() - this.e);
        }
    }

    public C5788Kv3(C16232kv3 c16232kv3) {
        this.a = c16232kv3;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        arrayList.add(new a(i, i, 2, null));
        this.b = arrayList;
        this.f = -1;
        this.g = new ArrayList();
        this.h = AbstractC10360bX0.m();
    }

    private final int a() {
        return ((int) Math.sqrt((f() * 1.0d) / this.i)) + 1;
    }

    private final List b(int i) {
        if (i == this.h.size()) {
            return this.h;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(C10870cL2.a(AbstractC5554Jv3.a(1)));
        }
        this.h = arrayList;
        return arrayList;
    }

    private final void g() {
        this.b.clear();
        int i = 0;
        this.b.add(new a(i, i, 2, null));
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.C5788Kv3.c c(int r11) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5788Kv3.c(int):ir.nasim.Kv3$c");
    }

    public final int d(int i) {
        int i2 = 0;
        if (f() <= 0) {
            return 0;
        }
        if (!(i < f())) {
            P73.a("ItemIndex > total count");
        }
        if (!this.a.m()) {
            return i / this.i;
        }
        int iK = AbstractC10360bX0.k(this.b, 0, 0, new d(i), 3, null);
        int i3 = 2;
        if (iK < 0) {
            iK = (-iK) - 2;
        }
        int iA = a() * iK;
        int iA2 = ((a) this.b.get(iK)).a();
        if (!(iA2 <= i)) {
            P73.a("currentItemIndex > itemIndex");
        }
        int i4 = 0;
        while (iA2 < i) {
            int i5 = iA2 + 1;
            int i6 = i(iA2, this.i - i4);
            i4 += i6;
            int i7 = this.i;
            if (i4 >= i7) {
                if (i4 == i7) {
                    iA++;
                    i4 = 0;
                } else {
                    iA++;
                    i4 = i6;
                }
            }
            if (iA % a() == 0 && iA / a() >= this.b.size()) {
                this.b.add(new a(i5 - (i4 > 0 ? 1 : 0), i2, i3, null));
            }
            iA2 = i5;
        }
        return i4 + i(i, this.i - i4) > this.i ? iA + 1 : iA;
    }

    public final int e() {
        return this.i;
    }

    public final int f() {
        return this.a.j().f();
    }

    public final void h(int i) {
        if (i != this.i) {
            this.i = i;
            g();
        }
    }

    public final int i(int i, int i2) {
        b bVar = b.a;
        bVar.a(i2);
        bVar.b(this.i);
        InterfaceC8727Xb3.a aVar = this.a.j().get(i);
        return C10870cL2.d(((C10870cL2) ((C15641jv3) aVar.c()).b().invoke(bVar, Integer.valueOf(i - aVar.b()))).g());
    }

    /* renamed from: ir.nasim.Kv3$a */
    private static final class a {
        private final int a;
        private final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public /* synthetic */ a(int i, int i2, int i3, ED1 ed1) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }
    }
}
