package ir.nasim;

import ir.nasim.AbstractC20754sY7;
import ir.nasim.PT4;
import ir.nasim.VS4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.dT4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11708dT4 implements InterfaceC3516Be5 {
    public static final a e = new a(null);
    private static final C11708dT4 f = new C11708dT4(VS4.b.g.e());
    private final List a;
    private int b;
    private int c;
    private int d;

    /* renamed from: ir.nasim.dT4$a */
    public static final class a {
        private a() {
        }

        public final C11708dT4 a(VS4.b bVar) {
            if (bVar != null) {
                return new C11708dT4(bVar);
            }
            C11708dT4 c11708dT4 = C11708dT4.f;
            AbstractC13042fc3.g(c11708dT4, "null cannot be cast to non-null type androidx.paging.PageStore<T of androidx.paging.PageStore.Companion.initial>");
            return c11708dT4;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dT4$b */
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

    public C11708dT4(List list, int i, int i2) {
        AbstractC13042fc3.i(list, "pages");
        this.a = AbstractC15401jX0.p1(list);
        this.b = j(list);
        this.c = i;
        this.d = i2;
    }

    private final void g(int i) {
        if (i < 0 || i >= f()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + f());
        }
    }

    private final PT4 h(VS4.a aVar) {
        int i = i(new C24411ya3(aVar.g(), aVar.f()));
        this.b = a() - i;
        if (aVar.e() == EnumC16433lG3.PREPEND) {
            int iB = b();
            this.c = aVar.i();
            return new PT4.c(i, b(), iB);
        }
        int iC = c();
        this.d = aVar.i();
        return new PT4.b(b() + a(), i, aVar.i(), iC);
    }

    private final int i(C24411ya3 c24411ya3) {
        Iterator it = this.a.iterator();
        int size = 0;
        while (it.hasNext()) {
            C15054iv7 c15054iv7 = (C15054iv7) it.next();
            int[] iArrE = c15054iv7.e();
            int length = iArrE.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (c24411ya3.B(iArrE[i])) {
                    size += c15054iv7.b().size();
                    it.remove();
                    break;
                }
                i++;
            }
        }
        return size;
    }

    private final int j(List list) {
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((C15054iv7) it.next()).b().size();
        }
        return size;
    }

    private final int l() {
        Integer numK0 = AbstractC10242bK.K0(((C15054iv7) AbstractC15401jX0.q0(this.a)).e());
        AbstractC13042fc3.f(numK0);
        return numK0.intValue();
    }

    private final int m() {
        Integer numJ0 = AbstractC10242bK.J0(((C15054iv7) AbstractC15401jX0.C0(this.a)).e());
        AbstractC13042fc3.f(numJ0);
        return numJ0.intValue();
    }

    private final PT4 o(VS4.b bVar) {
        int iJ = j(bVar.j());
        int i = b.a[bVar.h().ordinal()];
        if (i == 1) {
            throw new IllegalStateException("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
        }
        if (i == 2) {
            int iB = b();
            this.a.addAll(0, bVar.j());
            this.b = a() + iJ;
            this.c = bVar.l();
            List listJ = bVar.j();
            ArrayList arrayList = new ArrayList();
            Iterator it = listJ.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, ((C15054iv7) it.next()).b());
            }
            return new PT4.d(arrayList, b(), iB);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        int iC = c();
        int iA = a();
        List list = this.a;
        list.addAll(list.size(), bVar.j());
        this.b = a() + iJ;
        this.d = bVar.k();
        int iB2 = b() + iA;
        List listJ2 = bVar.j();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = listJ2.iterator();
        while (it2.hasNext()) {
            AbstractC13610gX0.D(arrayList2, ((C15054iv7) it2.next()).b());
        }
        return new PT4.a(iB2, arrayList2, c(), iC);
    }

    @Override // ir.nasim.InterfaceC3516Be5
    public int a() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC3516Be5
    public int b() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC3516Be5
    public int c() {
        return this.d;
    }

    public final AbstractC20754sY7.a e(int i) {
        int i2 = 0;
        int iB = i - b();
        while (iB >= ((C15054iv7) this.a.get(i2)).b().size() && i2 < AbstractC10360bX0.o(this.a)) {
            iB -= ((C15054iv7) this.a.get(i2)).b().size();
            i2++;
        }
        return ((C15054iv7) this.a.get(i2)).f(iB, i - b(), ((f() - i) - c()) - 1, l(), m());
    }

    @Override // ir.nasim.InterfaceC3516Be5
    public int f() {
        return b() + a() + c();
    }

    @Override // ir.nasim.InterfaceC3516Be5
    public Object getItem(int i) {
        int size = this.a.size();
        int i2 = 0;
        while (i2 < size) {
            int size2 = ((C15054iv7) this.a.get(i2)).b().size();
            if (size2 > i) {
                break;
            }
            i -= size2;
            i2++;
        }
        return ((C15054iv7) this.a.get(i2)).b().get(i);
    }

    public final Object k(int i) {
        g(i);
        int iB = i - b();
        if (iB < 0 || iB >= a()) {
            return null;
        }
        return getItem(iB);
    }

    public final AbstractC20754sY7.b n() {
        int iA = a() / 2;
        return new AbstractC20754sY7.b(iA, iA, l(), m());
    }

    public final PT4 p(VS4 vs4) {
        AbstractC13042fc3.i(vs4, "pageEvent");
        if (vs4 instanceof VS4.b) {
            return o((VS4.b) vs4);
        }
        if (vs4 instanceof VS4.a) {
            return h((VS4.a) vs4);
        }
        throw new IllegalStateException("Paging received an event to process StaticList or LoadStateUpdate while\nprocessing Inserts and Drops. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    public final C11066cg3 q() {
        int iB = b();
        int iC = c();
        List list = this.a;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((C15054iv7) it.next()).b());
        }
        return new C11066cg3(iB, iC, arrayList);
    }

    public String toString() {
        int iA = a();
        ArrayList arrayList = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            arrayList.add(getItem(i));
        }
        return "[(" + b() + " placeholders), " + AbstractC15401jX0.A0(arrayList, null, null, null, 0, null, null, 63, null) + ", (" + c() + " placeholders)]";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11708dT4(VS4.b bVar) {
        this(bVar.j(), bVar.l(), bVar.k());
        AbstractC13042fc3.i(bVar, "insertEvent");
    }
}
