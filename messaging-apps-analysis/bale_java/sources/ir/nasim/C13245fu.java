package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13406gA3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.fu, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13245fu implements CharSequence {
    public static final c e = new c(null);
    private static final InterfaceC8230Vb6 f = AbstractC8984Yb6.h();
    private final List a;
    private final String b;
    private final List c;
    private final List d;

    /* renamed from: ir.nasim.fu$a */
    public interface a {
    }

    /* renamed from: ir.nasim.fu$c */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fu$e */
    public static final class e implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(((d) obj).h()), Integer.valueOf(((d) obj2).h()));
        }
    }

    public C13245fu(List list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = list;
        this.b = str;
        if (list != null) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < size; i++) {
                d dVar = (d) list.get(i);
                if (dVar.g() instanceof C12863fI6) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    AbstractC13042fc3.g(dVar, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                    arrayList.add(dVar);
                } else if (dVar.g() instanceof C15396jW4) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    AbstractC13042fc3.g(dVar, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>");
                    arrayList2.add(dVar);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.c = arrayList;
        this.d = arrayList2;
        List listA1 = arrayList2 != null ? AbstractC15401jX0.a1(arrayList2, new e()) : null;
        List list2 = listA1;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        C16143km4 c16143km4D = AbstractC19568qa3.d(((d) AbstractC15401jX0.q0(listA1)).f());
        int size2 = listA1.size();
        for (int i2 = 1; i2 < size2; i2++) {
            d dVar2 = (d) listA1.get(i2);
            while (true) {
                if (c16143km4D.b == 0) {
                    break;
                }
                int iH = c16143km4D.h();
                if (dVar2.h() >= iH) {
                    c16143km4D.m(c16143km4D.b - 1);
                } else if (!(dVar2.f() <= iH)) {
                    N73.a("Paragraph overlap not allowed, end " + dVar2.f() + " should be less than or equal to " + iH);
                }
            }
            c16143km4D.j(dVar2.f());
        }
    }

    public final C13245fu a(UA2 ua2) {
        b bVar = new b(this);
        bVar.i(ua2);
        return bVar.o();
    }

    public char b(int i) {
        return this.b.charAt(i);
    }

    public final List c() {
        return this.a;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return b(i);
    }

    public int d() {
        return this.b.length();
    }

    public final List e(int i, int i2) {
        List listM;
        List list = this.a;
        if (list != null) {
            listM = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                d dVar = (d) obj;
                if ((dVar.g() instanceof AbstractC13406gA3) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                    listM.add(obj);
                }
            }
        } else {
            listM = AbstractC10360bX0.m();
        }
        AbstractC13042fc3.g(listM, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return listM;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13245fu)) {
            return false;
        }
        C13245fu c13245fu = (C13245fu) obj;
        return AbstractC13042fc3.d(this.b, c13245fu.b) && AbstractC13042fc3.d(this.a, c13245fu.a);
    }

    public final List f() {
        return this.d;
    }

    public final List g() {
        List list = this.c;
        return list == null ? AbstractC10360bX0.m() : list;
    }

    public final List h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        List list = this.a;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final List i(int i, int i2) {
        List list = this.a;
        if (list == null) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) list.get(i3);
            if ((dVar.g() instanceof AY6) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                arrayList.add(BY6.a(dVar));
            }
        }
        return arrayList;
    }

    public final List j(String str, int i, int i2) {
        List list = this.a;
        if (list == null) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) list.get(i3);
            if ((dVar.g() instanceof AY6) && AbstractC13042fc3.d(str, dVar.i()) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                arrayList.add(BY6.a(dVar));
            }
        }
        return arrayList;
    }

    public final String k() {
        return this.b;
    }

    public final List l(int i, int i2) {
        List listM;
        List list = this.a;
        if (list != null) {
            listM = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                d dVar = (d) obj;
                if ((dVar.g() instanceof AbstractC3914Cw7) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                    listM.add(obj);
                }
            }
        } else {
            listM = AbstractC10360bX0.m();
        }
        AbstractC13042fc3.g(listM, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return listM;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return d();
    }

    public final List m(int i, int i2) {
        List listM;
        List list = this.a;
        if (list != null) {
            listM = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = list.get(i3);
                d dVar = (d) obj;
                if ((dVar.g() instanceof C12255eI7) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                    listM.add(obj);
                }
            }
        } else {
            listM = AbstractC10360bX0.m();
        }
        AbstractC13042fc3.g(listM, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return listM;
    }

    public final boolean n(C13245fu c13245fu) {
        return AbstractC13042fc3.d(this.a, c13245fu.a);
    }

    public final boolean o(int i, int i2) {
        List list = this.a;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) list.get(i3);
            if ((dVar.g() instanceof AbstractC13406gA3) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                return true;
            }
        }
        return false;
    }

    public final boolean p(String str, int i, int i2) {
        List list = this.a;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) list.get(i3);
            if ((dVar.g() instanceof AY6) && AbstractC13042fc3.d(str, dVar.i()) && AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                return true;
            }
        }
        return false;
    }

    public final C13245fu q(UA2 ua2) {
        b bVar = new b(this);
        bVar.j(ua2);
        return bVar.o();
    }

    public final C13245fu r(C13245fu c13245fu) {
        b bVar = new b(this);
        bVar.f(c13245fu);
        return bVar.o();
    }

    @Override // java.lang.CharSequence
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C13245fu subSequence(int i, int i2) {
        if (!(i <= i2)) {
            N73.a("start (" + i + ") should be less or equal to end (" + i2 + ')');
        }
        if (i == 0 && i2 == this.b.length()) {
            return this;
        }
        String strSubstring = this.b.substring(i, i2);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return new C13245fu(AbstractC13836gu.f(this.a, i, i2), strSubstring);
    }

    public final C13245fu t(long j) {
        return subSequence(C4301En7.l(j), C4301En7.k(j));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.b;
    }

    /* renamed from: ir.nasim.fu$b */
    public static final class b implements Appendable {
        private final StringBuilder a;
        private final List b;
        private final List c;
        private final a d;

        /* renamed from: ir.nasim.fu$b$a */
        public static final class a {
            private final b a;
            private final List b = new ArrayList();

            public a(b bVar) {
                this.a = bVar;
            }
        }

        public b(int i) {
            this.a = new StringBuilder(i);
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new a(this);
        }

        public final void a(AbstractC13406gA3.a aVar, int i, int i2) {
            this.c.add(new C1245b(aVar, i, i2, null, 8, null));
        }

        public final void b(C12863fI6 c12863fI6, int i, int i2) {
            this.c.add(new C1245b(c12863fI6, i, i2, null, 8, null));
        }

        @Override // java.lang.Appendable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b append(char c) {
            this.a.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b append(CharSequence charSequence) {
            if (charSequence instanceof C13245fu) {
                f((C13245fu) charSequence);
            } else {
                this.a.append(charSequence);
            }
            return this;
        }

        @Override // java.lang.Appendable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b append(CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof C13245fu) {
                g((C13245fu) charSequence, i, i2);
            } else {
                this.a.append(charSequence, i, i2);
            }
            return this;
        }

        public final void f(C13245fu c13245fu) {
            int length = this.a.length();
            this.a.append(c13245fu.k());
            List listC = c13245fu.c();
            if (listC != null) {
                int size = listC.size();
                for (int i = 0; i < size; i++) {
                    d dVar = (d) listC.get(i);
                    this.c.add(new C1245b(dVar.g(), dVar.h() + length, dVar.f() + length, dVar.i()));
                }
            }
        }

        public final void g(C13245fu c13245fu, int i, int i2) {
            int length = this.a.length();
            this.a.append((CharSequence) c13245fu.k(), i, i2);
            List listH = AbstractC13836gu.h(c13245fu, i, i2, null, 4, null);
            if (listH != null) {
                int size = listH.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d dVar = (d) listH.get(i3);
                    this.c.add(new C1245b(dVar.g(), dVar.h() + length, dVar.f() + length, dVar.i()));
                }
            }
        }

        public final void h(String str) {
            this.a.append(str);
        }

        public final void i(UA2 ua2) {
            List list = this.c;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List list2 = (List) ua2.invoke(C1245b.c((C1245b) list.get(i), 0, 1, null));
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList2.add(C1245b.e.a((d) list2.get(i2)));
                }
                AbstractC13610gX0.D(arrayList, arrayList2);
            }
            this.c.clear();
            this.c.addAll(arrayList);
        }

        public final void j(UA2 ua2) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.set(i, C1245b.e.a((d) ua2.invoke(C1245b.c((C1245b) this.c.get(i), 0, 1, null))));
            }
        }

        public final void k() {
            if (!(!this.b.isEmpty())) {
                N73.c("Nothing to pop.");
            }
            ((C1245b) this.b.remove(r0.size() - 1)).a(this.a.length());
        }

        public final void l(int i) {
            if (!(i < this.b.size())) {
                N73.c(i + " should be less than " + this.b.size());
            }
            while (this.b.size() - 1 >= i) {
                k();
            }
        }

        public final int m(String str, String str2) {
            C1245b c1245b = new C1245b(AY6.a(AY6.b(str2)), this.a.length(), 0, str, 4, null);
            this.b.add(c1245b);
            this.c.add(c1245b);
            return this.b.size() - 1;
        }

        public final int n(C12863fI6 c12863fI6) {
            C1245b c1245b = new C1245b(c12863fI6, this.a.length(), 0, null, 12, null);
            this.b.add(c1245b);
            this.c.add(c1245b);
            return this.b.size() - 1;
        }

        public final C13245fu o() {
            String string = this.a.toString();
            List list = this.c;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((C1245b) list.get(i)).b(this.a.length()));
            }
            return new C13245fu(string, arrayList);
        }

        /* renamed from: ir.nasim.fu$b$b, reason: collision with other inner class name */
        private static final class C1245b {
            public static final a e = new a(null);
            private final Object a;
            private final int b;
            private int c;
            private final String d;

            /* renamed from: ir.nasim.fu$b$b$a */
            public static final class a {
                private a() {
                }

                public final C1245b a(d dVar) {
                    return new C1245b(dVar.g(), dVar.h(), dVar.f(), dVar.i());
                }

                public /* synthetic */ a(ED1 ed1) {
                    this();
                }
            }

            public C1245b(Object obj, int i, int i2, String str) {
                this.a = obj;
                this.b = i;
                this.c = i2;
                this.d = str;
            }

            public static /* synthetic */ d c(C1245b c1245b, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = RecyclerView.UNDEFINED_DURATION;
                }
                return c1245b.b(i);
            }

            public final void a(int i) {
                this.c = i;
            }

            public final d b(int i) {
                int i2 = this.c;
                if (i2 != Integer.MIN_VALUE) {
                    i = i2;
                }
                if (!(i != Integer.MIN_VALUE)) {
                    N73.c("Item.end should be set first");
                }
                return new d(this.a, this.b, i, this.d);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C1245b)) {
                    return false;
                }
                C1245b c1245b = (C1245b) obj;
                return AbstractC13042fc3.d(this.a, c1245b.a) && this.b == c1245b.b && this.c == c1245b.c && AbstractC13042fc3.d(this.d, c1245b.d);
            }

            public int hashCode() {
                Object obj = this.a;
                return ((((((obj == null ? 0 : obj.hashCode()) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.a + ", start=" + this.b + ", end=" + this.c + ", tag=" + this.d + ')';
            }

            public /* synthetic */ C1245b(Object obj, int i, int i2, String str, int i3, ED1 ed1) {
                this(obj, i, (i3 & 4) != 0 ? RecyclerView.UNDEFINED_DURATION : i2, (i3 & 8) != 0 ? "" : str);
            }
        }

        public /* synthetic */ b(int i, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? 16 : i);
        }

        public b(String str) {
            this(0, 1, null);
            h(str);
        }

        public b(C13245fu c13245fu) {
            this(0, 1, null);
            f(c13245fu);
        }
    }

    /* renamed from: ir.nasim.fu$d */
    public static final class d {
        private final Object a;
        private final int b;
        private final int c;
        private final String d;

        public d(Object obj, int i, int i2, String str) {
            this.a = obj;
            this.b = i;
            this.c = i2;
            this.d = str;
            if (i <= i2) {
                return;
            }
            N73.a("Reversed range is not supported");
        }

        public static /* synthetic */ d e(d dVar, Object obj, int i, int i2, String str, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                obj = dVar.a;
            }
            if ((i3 & 2) != 0) {
                i = dVar.b;
            }
            if ((i3 & 4) != 0) {
                i2 = dVar.c;
            }
            if ((i3 & 8) != 0) {
                str = dVar.d;
            }
            return dVar.d(obj, i, i2, str);
        }

        public final Object a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final d d(Object obj, int i, int i2, String str) {
            return new d(obj, i, i2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c && AbstractC13042fc3.d(this.d, dVar.d);
        }

        public final int f() {
            return this.c;
        }

        public final Object g() {
            return this.a;
        }

        public final int h() {
            return this.b;
        }

        public int hashCode() {
            Object obj = this.a;
            return ((((((obj == null ? 0 : obj.hashCode()) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public final String i() {
            return this.d;
        }

        public String toString() {
            return "Range(item=" + this.a + ", start=" + this.b + ", end=" + this.c + ", tag=" + this.d + ')';
        }

        public d(Object obj, int i, int i2) {
            this(obj, i, i2, "");
        }
    }

    public /* synthetic */ C13245fu(String str, List list, List list2, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? AbstractC10360bX0.m() : list, (i & 4) != 0 ? AbstractC10360bX0.m() : list2);
    }

    public C13245fu(String str, List list, List list2) {
        this(AbstractC13836gu.d(list, list2), str);
    }

    public /* synthetic */ C13245fu(String str, List list, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? AbstractC10360bX0.m() : list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C13245fu(String str, List list) {
        List list2 = list;
        this(list2.isEmpty() ? null : list2, str);
    }
}
