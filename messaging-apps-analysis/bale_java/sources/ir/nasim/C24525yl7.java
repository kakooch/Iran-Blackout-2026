package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.yl7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24525yl7 {
    public static final a b = new a(null);
    private static final C24525yl7 c = new C24525yl7(0);
    private static final C24525yl7 d = new C24525yl7(1);
    private static final C24525yl7 e = new C24525yl7(2);
    private final int a;

    /* renamed from: ir.nasim.yl7$a */
    public static final class a {
        private a() {
        }

        public final C24525yl7 a(List list) {
            Integer numValueOf = 0;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                numValueOf = Integer.valueOf(numValueOf.intValue() | ((C24525yl7) list.get(i)).e());
            }
            return new C24525yl7(numValueOf.intValue());
        }

        public final C24525yl7 b() {
            return C24525yl7.e;
        }

        public final C24525yl7 c() {
            return C24525yl7.c;
        }

        public final C24525yl7 d() {
            return C24525yl7.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24525yl7(int i) {
        this.a = i;
    }

    public final boolean d(C24525yl7 c24525yl7) {
        int i = this.a;
        return (c24525yl7.a | i) == i;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24525yl7) && this.a == ((C24525yl7) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        if (this.a == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.a & d.a) != 0) {
            arrayList.add("Underline");
        }
        if ((this.a & e.a) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + AbstractC12806fC3.e(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
