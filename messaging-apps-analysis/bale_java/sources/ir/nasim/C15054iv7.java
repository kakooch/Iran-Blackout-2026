package ir.nasim;

import ir.nasim.AbstractC20754sY7;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.iv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15054iv7 {
    public static final a e = new a(null);
    private static final C15054iv7 f = new C15054iv7(0, AbstractC10360bX0.m());
    private final int[] a;
    private final List b;
    private final int c;
    private final List d;

    /* renamed from: ir.nasim.iv7$a */
    public static final class a {
        private a() {
        }

        public final C15054iv7 a() {
            return C15054iv7.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C15054iv7(int[] iArr, List list, int i, List list2) {
        AbstractC13042fc3.i(iArr, "originalPageOffsets");
        AbstractC13042fc3.i(list, "data");
        this.a = iArr;
        this.b = list;
        this.c = i;
        this.d = list2;
        if (!(!(iArr.length == 0))) {
            throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
        }
        if (list2 == null || list2.size() == list.size()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("If originalIndices (size = ");
        AbstractC13042fc3.f(list2);
        sb.append(list2.size());
        sb.append(") is provided, it must be same length as data (size = ");
        sb.append(list.size());
        sb.append(')');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final List b() {
        return this.b;
    }

    public final List c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    public final int[] e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C15054iv7.class != obj.getClass()) {
            return false;
        }
        C15054iv7 c15054iv7 = (C15054iv7) obj;
        return Arrays.equals(this.a, c15054iv7.a) && AbstractC13042fc3.d(this.b, c15054iv7.b) && this.c == c15054iv7.c && AbstractC13042fc3.d(this.d, c15054iv7.d);
    }

    public final AbstractC20754sY7.a f(int i, int i2, int i3, int i4, int i5) {
        C24411ya3 c24411ya3N;
        int i6 = this.c;
        List list = this.d;
        if (list != null && (c24411ya3N = AbstractC10360bX0.n(list)) != null && c24411ya3N.B(i)) {
            i = ((Number) this.d.get(i)).intValue();
        }
        return new AbstractC20754sY7.a(i6, i, i2, i3, i4, i5);
    }

    public int hashCode() {
        int iHashCode = ((((Arrays.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        List list = this.d;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.a) + ", data=" + this.b + ", hintOriginalPageOffset=" + this.c + ", hintOriginalIndices=" + this.d + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C15054iv7(int i, List list) {
        this(new int[]{i}, list, i, null);
        AbstractC13042fc3.i(list, "data");
    }
}
