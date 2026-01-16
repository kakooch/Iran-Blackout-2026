package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
public abstract class PT4 {

    public static final class a extends PT4 {
        private final int a;
        private final List b;
        private final int c;
        private final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, List list, int i2, int i3) {
            super(null);
            AbstractC13042fc3.i(list, "inserted");
            this.a = i;
            this.b = list;
            this.c = i2;
            this.d = i3;
        }

        public final List a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final int d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && this.d == aVar.d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Integer.hashCode(this.a) + this.b.hashCode() + Integer.hashCode(this.c) + Integer.hashCode(this.d);
        }

        public String toString() {
            return AbstractC16016kZ6.i("PagingDataEvent.Append loaded " + this.b.size() + " items (\n                    |   startIndex: " + this.a + "\n                    |   first item: " + AbstractC15401jX0.s0(this.b) + "\n                    |   last item: " + AbstractC15401jX0.F0(this.b) + "\n                    |   newPlaceholdersBefore: " + this.c + "\n                    |   oldPlaceholdersBefore: " + this.d + "\n                    |)\n                    |", null, 1, null);
        }
    }

    public static final class b extends PT4 {
        private final int a;
        private final int b;
        private final int c;
        private final int d;

        public b(int i, int i2, int i3, int i4) {
            super(null);
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final int d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Integer.hashCode(this.a) + Integer.hashCode(this.b) + Integer.hashCode(this.c) + Integer.hashCode(this.d);
        }

        public String toString() {
            return AbstractC16016kZ6.i("PagingDataEvent.DropAppend dropped " + this.b + " items (\n                    |   startIndex: " + this.a + "\n                    |   dropCount: " + this.b + "\n                    |   newPlaceholdersBefore: " + this.c + "\n                    |   oldPlaceholdersBefore: " + this.d + "\n                    |)\n                    |", null, 1, null);
        }
    }

    public static final class c extends PT4 {
        private final int a;
        private final int b;
        private final int c;

        public c(int i, int i2, int i3) {
            super(null);
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.a == cVar.a && this.b == cVar.b && this.c == cVar.c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Integer.hashCode(this.a) + Integer.hashCode(this.b) + Integer.hashCode(this.c);
        }

        public String toString() {
            return AbstractC16016kZ6.i("PagingDataEvent.DropPrepend dropped " + this.a + " items (\n                    |   dropCount: " + this.a + "\n                    |   newPlaceholdersBefore: " + this.b + "\n                    |   oldPlaceholdersBefore: " + this.c + "\n                    |)\n                    |", null, 1, null);
        }
    }

    public static final class d extends PT4 {
        private final List a;
        private final int b;
        private final int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, int i, int i2) {
            super(null);
            AbstractC13042fc3.i(list, "inserted");
            this.a = list;
            this.b = i;
            this.c = i2;
        }

        public final List a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (AbstractC13042fc3.d(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + Integer.hashCode(this.b) + Integer.hashCode(this.c);
        }

        public String toString() {
            return AbstractC16016kZ6.i("PagingDataEvent.Prepend loaded " + this.a.size() + " items (\n                    |   first item: " + AbstractC15401jX0.s0(this.a) + "\n                    |   last item: " + AbstractC15401jX0.F0(this.a) + "\n                    |   newPlaceholdersBefore: " + this.b + "\n                    |   oldPlaceholdersBefore: " + this.c + "\n                    |)\n                    |", null, 1, null);
        }
    }

    public static final class e extends PT4 {
        private final InterfaceC3516Be5 a;
        private final InterfaceC3516Be5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC3516Be5 interfaceC3516Be5, InterfaceC3516Be5 interfaceC3516Be52) {
            super(null);
            AbstractC13042fc3.i(interfaceC3516Be5, "newList");
            AbstractC13042fc3.i(interfaceC3516Be52, "previousList");
            this.a = interfaceC3516Be5;
            this.b = interfaceC3516Be52;
        }

        public final InterfaceC3516Be5 a() {
            return this.a;
        }

        public final InterfaceC3516Be5 b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.a.b() == eVar.a.b() && this.a.c() == eVar.a.c() && this.a.f() == eVar.a.f() && this.a.a() == eVar.a.a() && this.b.b() == eVar.b.b() && this.b.c() == eVar.b.c() && this.b.f() == eVar.b.f() && this.b.a() == eVar.b.a()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + this.b.hashCode();
        }

        public String toString() {
            return AbstractC16016kZ6.i("PagingDataEvent.Refresh loaded newList\n                    |   newList (\n                    |       placeholdersBefore: " + this.a.b() + "\n                    |       placeholdersAfter: " + this.a.c() + "\n                    |       size: " + this.a.f() + "\n                    |       dataCount: " + this.a.a() + "\n                    |   )\n                    |   previousList (\n                    |       placeholdersBefore: " + this.b.b() + "\n                    |       placeholdersAfter: " + this.b.c() + "\n                    |       size: " + this.b.f() + "\n                    |       dataCount: " + this.b.a() + "\n                    |   )\n                    |", null, 1, null);
        }
    }

    private PT4() {
    }

    public /* synthetic */ PT4(ED1 ed1) {
        this();
    }
}
