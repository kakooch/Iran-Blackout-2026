package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class VS4 {

    public static final class a extends VS4 {
        private final EnumC16433lG3 a;
        private final int b;
        private final int c;
        private final int d;

        /* renamed from: ir.nasim.VS4$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0703a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC16433lG3.values().length];
                try {
                    iArr[EnumC16433lG3.APPEND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC16433lG3.PREPEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnumC16433lG3 enumC16433lG3, int i, int i2, int i3) {
            super(null);
            AbstractC13042fc3.i(enumC16433lG3, "loadType");
            this.a = enumC16433lG3;
            this.b = i;
            this.c = i2;
            this.d = i3;
            if (enumC16433lG3 == EnumC16433lG3.REFRESH) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
            }
            if (h() <= 0) {
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + h()).toString());
            }
            if (i3 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i3).toString());
        }

        public final EnumC16433lG3 e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public final int f() {
            return this.c;
        }

        public final int g() {
            return this.b;
        }

        public final int h() {
            return (this.c - this.b) + 1;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public final int i() {
            return this.d;
        }

        public String toString() {
            String str;
            int i = C0703a.a[this.a.ordinal()];
            if (i == 1) {
                str = "end";
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
                }
                str = "front";
            }
            return AbstractC16016kZ6.i("PageEvent.Drop from the " + str + " (\n                    |   minPageOffset: " + this.b + "\n                    |   maxPageOffset: " + this.c + "\n                    |   placeholdersRemaining: " + this.d + "\n                    |)", null, 1, null);
        }
    }

    public static final class b extends VS4 {
        public static final a g;
        private static final b h;
        private final EnumC16433lG3 a;
        private final List b;
        private final int c;
        private final int d;
        private final C14653iG3 e;
        private final C14653iG3 f;

        public static final class a {
            private a() {
            }

            public static /* synthetic */ b d(a aVar, List list, int i, int i2, C14653iG3 c14653iG3, C14653iG3 c14653iG32, int i3, Object obj) {
                if ((i3 & 16) != 0) {
                    c14653iG32 = null;
                }
                return aVar.c(list, i, i2, c14653iG3, c14653iG32);
            }

            public final b a(List list, int i, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
                AbstractC13042fc3.i(list, "pages");
                AbstractC13042fc3.i(c14653iG3, "sourceLoadStates");
                return new b(EnumC16433lG3.APPEND, list, -1, i, c14653iG3, c14653iG32, null);
            }

            public final b b(List list, int i, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
                AbstractC13042fc3.i(list, "pages");
                AbstractC13042fc3.i(c14653iG3, "sourceLoadStates");
                return new b(EnumC16433lG3.PREPEND, list, i, -1, c14653iG3, c14653iG32, null);
            }

            public final b c(List list, int i, int i2, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
                AbstractC13042fc3.i(list, "pages");
                AbstractC13042fc3.i(c14653iG3, "sourceLoadStates");
                return new b(EnumC16433lG3.REFRESH, list, i, i2, c14653iG3, c14653iG32, null);
            }

            public final b e() {
                return b.h;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* renamed from: ir.nasim.VS4$b$b, reason: collision with other inner class name */
        static final class C0704b extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            Object k;
            int l;
            int m;
            /* synthetic */ Object n;
            int p;

            C0704b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.n = obj;
                this.p |= RecyclerView.UNDEFINED_DURATION;
                return b.this.a(null, this);
            }
        }

        static final class c extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            Object k;
            /* synthetic */ Object l;
            int n;

            c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.l = obj;
                this.n |= RecyclerView.UNDEFINED_DURATION;
                return b.this.c(null, this);
            }
        }

        static {
            a aVar = new a(null);
            g = aVar;
            List listE = AbstractC9766aX0.e(C15054iv7.e.a());
            AbstractC13460gG3.c.a aVar2 = AbstractC13460gG3.c.b;
            h = a.d(aVar, listE, 0, 0, new C14653iG3(aVar2.b(), aVar2.a(), aVar2.a()), null, 16, null);
        }

        public /* synthetic */ b(EnumC16433lG3 enumC16433lG3, List list, int i, int i2, C14653iG3 c14653iG3, C14653iG3 c14653iG32, ED1 ed1) {
            this(enumC16433lG3, list, i, i2, c14653iG3, c14653iG32);
        }

        public static /* synthetic */ b g(b bVar, EnumC16433lG3 enumC16433lG3, List list, int i, int i2, C14653iG3 c14653iG3, C14653iG3 c14653iG32, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                enumC16433lG3 = bVar.a;
            }
            if ((i3 & 2) != 0) {
                list = bVar.b;
            }
            List list2 = list;
            if ((i3 & 4) != 0) {
                i = bVar.c;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = bVar.d;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                c14653iG3 = bVar.e;
            }
            C14653iG3 c14653iG33 = c14653iG3;
            if ((i3 & 32) != 0) {
                c14653iG32 = bVar.f;
            }
            return bVar.f(enumC16433lG3, list2, i4, i5, c14653iG33, c14653iG32);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Type inference failed for: r10v10, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v4, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009b -> B:18:0x00bd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f2 -> B:27:0x00ff). Please report as a decompilation issue!!! */
        @Override // ir.nasim.VS4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object a(ir.nasim.InterfaceC14603iB2 r19, ir.nasim.InterfaceC20295rm1 r20) {
            /*
                Method dump skipped, instructions count: 343
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VS4.b.a(ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Type inference failed for: r13v9, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v10, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r9v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0091 -> B:18:0x00b4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00de -> B:24:0x00e6). Please report as a decompilation issue!!! */
        @Override // ir.nasim.VS4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object c(ir.nasim.InterfaceC14603iB2 r18, ir.nasim.InterfaceC20295rm1 r19) {
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VS4.b.c(ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e) && AbstractC13042fc3.d(this.f, bVar.f);
        }

        public final b f(EnumC16433lG3 enumC16433lG3, List list, int i, int i2, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
            AbstractC13042fc3.i(enumC16433lG3, "loadType");
            AbstractC13042fc3.i(list, "pages");
            AbstractC13042fc3.i(c14653iG3, "sourceLoadStates");
            return new b(enumC16433lG3, list, i, i2, c14653iG3, c14653iG32);
        }

        public final EnumC16433lG3 h() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
            C14653iG3 c14653iG3 = this.f;
            return iHashCode + (c14653iG3 == null ? 0 : c14653iG3.hashCode());
        }

        public final C14653iG3 i() {
            return this.f;
        }

        public final List j() {
            return this.b;
        }

        public final int k() {
            return this.d;
        }

        public final int l() {
            return this.c;
        }

        public final C14653iG3 m() {
            return this.e;
        }

        public String toString() {
            List listB;
            List listB2;
            Iterator it = this.b.iterator();
            int size = 0;
            while (it.hasNext()) {
                size += ((C15054iv7) it.next()).b().size();
            }
            int i = this.c;
            String strValueOf = i != -1 ? String.valueOf(i) : "none";
            int i2 = this.d;
            String strValueOf2 = i2 != -1 ? String.valueOf(i2) : "none";
            C14653iG3 c14653iG3 = this.f;
            StringBuilder sb = new StringBuilder();
            sb.append("PageEvent.Insert for ");
            sb.append(this.a);
            sb.append(", with ");
            sb.append(size);
            sb.append(" items (\n                    |   first item: ");
            C15054iv7 c15054iv7 = (C15054iv7) AbstractC15401jX0.s0(this.b);
            sb.append((c15054iv7 == null || (listB2 = c15054iv7.b()) == null) ? null : AbstractC15401jX0.s0(listB2));
            sb.append("\n                    |   last item: ");
            C15054iv7 c15054iv72 = (C15054iv7) AbstractC15401jX0.F0(this.b);
            sb.append((c15054iv72 == null || (listB = c15054iv72.b()) == null) ? null : AbstractC15401jX0.F0(listB));
            sb.append("\n                    |   placeholdersBefore: ");
            sb.append(strValueOf);
            sb.append("\n                    |   placeholdersAfter: ");
            sb.append(strValueOf2);
            sb.append("\n                    |   sourceLoadStates: ");
            sb.append(this.e);
            sb.append("\n                    ");
            String string = sb.toString();
            if (c14653iG3 != null) {
                string = string + "|   mediatorLoadStates: " + c14653iG3 + '\n';
            }
            return AbstractC16016kZ6.i(string + "|)", null, 1, null);
        }

        private b(EnumC16433lG3 enumC16433lG3, List list, int i, int i2, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
            super(null);
            this.a = enumC16433lG3;
            this.b = list;
            this.c = i;
            this.d = i2;
            this.e = c14653iG3;
            this.f = c14653iG32;
            if (enumC16433lG3 != EnumC16433lG3.APPEND && i < 0) {
                throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + i).toString());
            }
            if (enumC16433lG3 == EnumC16433lG3.PREPEND || i2 >= 0) {
                if (enumC16433lG3 == EnumC16433lG3.REFRESH && !(!list.isEmpty())) {
                    throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
                }
            } else {
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + i2).toString());
            }
        }
    }

    public static final class c extends VS4 {
        private final C14653iG3 a;
        private final C14653iG3 b;

        public /* synthetic */ c(C14653iG3 c14653iG3, C14653iG3 c14653iG32, int i, ED1 ed1) {
            this(c14653iG3, (i & 2) != 0 ? null : c14653iG32);
        }

        public final C14653iG3 e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b);
        }

        public final C14653iG3 f() {
            return this.a;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            C14653iG3 c14653iG3 = this.b;
            return iHashCode + (c14653iG3 == null ? 0 : c14653iG3.hashCode());
        }

        public String toString() {
            C14653iG3 c14653iG3 = this.b;
            String str = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.a + "\n                    ";
            if (c14653iG3 != null) {
                str = str + "|   mediatorLoadStates: " + c14653iG3 + '\n';
            }
            return AbstractC16016kZ6.i(str + "|)", null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
            super(null);
            AbstractC13042fc3.i(c14653iG3, "source");
            this.a = c14653iG3;
            this.b = c14653iG32;
        }
    }

    public static final class d extends VS4 {
        private final List a;
        private final C14653iG3 b;
        private final C14653iG3 c;

        static final class a extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            Object d;
            Object e;
            /* synthetic */ Object f;
            int h;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.f = obj;
                this.h |= RecyclerView.UNDEFINED_DURATION;
                return d.this.a(null, this);
            }
        }

        static final class b extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            Object d;
            Object e;
            /* synthetic */ Object f;
            int h;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.f = obj;
                this.h |= RecyclerView.UNDEFINED_DURATION;
                return d.this.c(null, this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, C14653iG3 c14653iG3, C14653iG3 c14653iG32) {
            super(null);
            AbstractC13042fc3.i(list, "data");
            this.a = list;
            this.b = c14653iG3;
            this.c = c14653iG32;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0073 -> B:21:0x0077). Please report as a decompilation issue!!! */
        @Override // ir.nasim.VS4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object a(ir.nasim.InterfaceC14603iB2 r9, ir.nasim.InterfaceC20295rm1 r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof ir.nasim.VS4.d.a
                if (r0 == 0) goto L13
                r0 = r10
                ir.nasim.VS4$d$a r0 = (ir.nasim.VS4.d.a) r0
                int r1 = r0.h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.h = r1
                goto L18
            L13:
                ir.nasim.VS4$d$a r0 = new ir.nasim.VS4$d$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.h
                r3 = 1
                if (r2 == 0) goto L43
                if (r2 != r3) goto L3b
                java.lang.Object r9 = r0.e
                java.lang.Object r2 = r0.d
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.c
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.b
                ir.nasim.iB2 r5 = (ir.nasim.InterfaceC14603iB2) r5
                java.lang.Object r6 = r0.a
                ir.nasim.VS4$d r6 = (ir.nasim.VS4.d) r6
                ir.nasim.AbstractC10685c16.b(r10)
                goto L77
            L3b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L43:
                ir.nasim.AbstractC10685c16.b(r10)
                java.util.List r10 = r8.a
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r10 = r10.iterator()
                r6 = r8
                r4 = r2
                r2 = r10
            L56:
                boolean r10 = r2.hasNext()
                if (r10 == 0) goto L84
                java.lang.Object r10 = r2.next()
                r0.a = r6
                r0.b = r9
                r0.c = r4
                r0.d = r2
                r0.e = r10
                r0.h = r3
                java.lang.Object r5 = r9.invoke(r10, r0)
                if (r5 != r1) goto L73
                return r1
            L73:
                r7 = r5
                r5 = r9
                r9 = r10
                r10 = r7
            L77:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L82
                r4.add(r9)
            L82:
                r9 = r5
                goto L56
            L84:
                java.util.List r4 = (java.util.List) r4
                ir.nasim.iG3 r9 = r6.b
                ir.nasim.iG3 r10 = r6.c
                ir.nasim.VS4$d r0 = new ir.nasim.VS4$d
                r0.<init>(r4, r9, r10)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VS4.d.a(ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007d -> B:21:0x0080). Please report as a decompilation issue!!! */
        @Override // ir.nasim.VS4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object c(ir.nasim.InterfaceC14603iB2 r9, ir.nasim.InterfaceC20295rm1 r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof ir.nasim.VS4.d.b
                if (r0 == 0) goto L13
                r0 = r10
                ir.nasim.VS4$d$b r0 = (ir.nasim.VS4.d.b) r0
                int r1 = r0.h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.h = r1
                goto L18
            L13:
                ir.nasim.VS4$d$b r0 = new ir.nasim.VS4$d$b
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.h
                r3 = 1
                if (r2 == 0) goto L45
                if (r2 != r3) goto L3d
                java.lang.Object r9 = r0.e
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.Object r2 = r0.d
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.c
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.b
                ir.nasim.iB2 r5 = (ir.nasim.InterfaceC14603iB2) r5
                java.lang.Object r6 = r0.a
                ir.nasim.VS4$d r6 = (ir.nasim.VS4.d) r6
                ir.nasim.AbstractC10685c16.b(r10)
                goto L80
            L3d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L45:
                ir.nasim.AbstractC10685c16.b(r10)
                java.util.List r10 = r8.a
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.ArrayList r2 = new java.util.ArrayList
                r4 = 10
                int r4 = ir.nasim.ZW0.x(r10, r4)
                r2.<init>(r4)
                java.util.Iterator r10 = r10.iterator()
                r6 = r8
                r7 = r10
                r10 = r9
                r9 = r2
                r2 = r7
            L60:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L86
                java.lang.Object r4 = r2.next()
                r0.a = r6
                r0.b = r10
                r0.c = r9
                r0.d = r2
                r0.e = r9
                r0.h = r3
                java.lang.Object r4 = r10.invoke(r4, r0)
                if (r4 != r1) goto L7d
                return r1
            L7d:
                r5 = r10
                r10 = r4
                r4 = r9
            L80:
                r9.add(r10)
                r9 = r4
                r10 = r5
                goto L60
            L86:
                java.util.List r9 = (java.util.List) r9
                ir.nasim.iG3 r10 = r6.b
                ir.nasim.iG3 r0 = r6.c
                ir.nasim.VS4$d r1 = new ir.nasim.VS4$d
                r1.<init>(r9, r10, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VS4.d.c(ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }

        public final List e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b) && AbstractC13042fc3.d(this.c, dVar.c);
        }

        public final C14653iG3 f() {
            return this.c;
        }

        public final C14653iG3 g() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            C14653iG3 c14653iG3 = this.b;
            int iHashCode2 = (iHashCode + (c14653iG3 == null ? 0 : c14653iG3.hashCode())) * 31;
            C14653iG3 c14653iG32 = this.c;
            return iHashCode2 + (c14653iG32 != null ? c14653iG32.hashCode() : 0);
        }

        public String toString() {
            C14653iG3 c14653iG3 = this.c;
            String str = "PageEvent.StaticList with " + this.a.size() + " items (\n                    |   first item: " + AbstractC15401jX0.s0(this.a) + "\n                    |   last item: " + AbstractC15401jX0.F0(this.a) + "\n                    |   sourceLoadStates: " + this.b + "\n                    ";
            if (c14653iG3 != null) {
                str = str + "|   mediatorLoadStates: " + c14653iG3 + '\n';
            }
            return AbstractC16016kZ6.i(str + "|)", null, 1, null);
        }
    }

    private VS4() {
    }

    static /* synthetic */ Object d(VS4 vs4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.g(vs4, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.map>");
        return vs4;
    }

    public Object a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return b(this, interfaceC14603iB2, interfaceC20295rm1);
    }

    public Object c(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return d(this, interfaceC14603iB2, interfaceC20295rm1);
    }

    public /* synthetic */ VS4(ED1 ed1) {
        this();
    }

    static /* synthetic */ Object b(VS4 vs4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return vs4;
    }
}
