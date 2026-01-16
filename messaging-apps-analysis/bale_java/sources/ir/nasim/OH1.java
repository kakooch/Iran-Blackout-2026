package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
final class OH1 implements InterfaceC23384wp6 {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final InterfaceC14603iB2 d;

    public static final class a implements Iterator, InterfaceC17915nm3 {
        private int a = -1;
        private int b;
        private int c;
        private C24411ya3 d;
        private int e;

        a() {
            int iM = AbstractC23053wG5.m(OH1.this.b, 0, OH1.this.a.length());
            this.b = iM;
            this.c = iM;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.d = r0
                goto L9e
            Lc:
                ir.nasim.OH1 r0 = ir.nasim.OH1.this
                int r0 = ir.nasim.OH1.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.e
                int r0 = r0 + r3
                r6.e = r0
                ir.nasim.OH1 r4 = ir.nasim.OH1.this
                int r4 = ir.nasim.OH1.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.c
                ir.nasim.OH1 r4 = ir.nasim.OH1.this
                java.lang.CharSequence r4 = ir.nasim.OH1.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                ir.nasim.ya3 r0 = new ir.nasim.ya3
                int r1 = r6.b
                ir.nasim.OH1 r4 = ir.nasim.OH1.this
                java.lang.CharSequence r4 = ir.nasim.OH1.d(r4)
                int r4 = ir.nasim.AbstractC14836iZ6.f0(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9c
            L47:
                ir.nasim.OH1 r0 = ir.nasim.OH1.this
                ir.nasim.iB2 r0 = ir.nasim.OH1.c(r0)
                ir.nasim.OH1 r4 = ir.nasim.OH1.this
                java.lang.CharSequence r4 = ir.nasim.OH1.d(r4)
                int r5 = r6.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                ir.nasim.XV4 r0 = (ir.nasim.XV4) r0
                if (r0 != 0) goto L77
                ir.nasim.ya3 r0 = new ir.nasim.ya3
                int r1 = r6.b
                ir.nasim.OH1 r4 = ir.nasim.OH1.this
                java.lang.CharSequence r4 = ir.nasim.OH1.d(r4)
                int r4 = ir.nasim.AbstractC14836iZ6.f0(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                ir.nasim.ya3 r4 = ir.nasim.AbstractC21867uG5.y(r4, r2)
                r6.d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.c = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OH1.a.b():void");
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C24411ya3 next() {
            if (this.a == -1) {
                b();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            C24411ya3 c24411ya3 = this.d;
            AbstractC13042fc3.g(c24411ya3, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.d = null;
            this.a = -1;
            return c24411ya3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                b();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public OH1(CharSequence charSequence, int i, int i2, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(charSequence, "input");
        AbstractC13042fc3.i(interfaceC14603iB2, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        return new a();
    }
}
