package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;
import android.os.FileObserver;
import ir.nasim.GO6;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.PN6;
import ir.nasim.QT1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes7.dex */
public final class GO6 extends VW7 {
    private final AbstractC13778go1 b;
    private final NF2 c;
    private final C24238yH1 d;
    private final BH1 e;
    private final GF2 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;
    private final InterfaceC4557Fq2 i;
    private final InterfaceC4557Fq2 j;
    private final InterfaceC10258bL6 k;

    private static final class a {
        private final long a;
        private final QT1 b;

        public a(long j, QT1 qt1) {
            AbstractC13042fc3.i(qt1, "directory");
            this.a = j;
            this.b = qt1;
        }

        public final long a() {
            return this.a;
        }

        public final QT1 b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (Long.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "DirectoryDetails(allocatedSize=" + this.a + ", directory=" + this.b + Separators.RPAREN;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            b bVar = (b) this.c;
            a[] aVarArr = (a[]) this.d;
            if (!bVar.e()) {
                return null;
            }
            GO6 go6 = GO6.this;
            ArrayList arrayList = new ArrayList(aVarArr.length);
            for (a aVar : aVarArr) {
                arrayList.add(go6.g1(aVar, bVar));
            }
            return new PN6(arrayList, bVar.c().isEmpty() ? PN6.a.b : bVar.g() ? PN6.a.c : PN6.a.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(b bVar, a[] aVarArr, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = GO6.this.new c(interfaceC20295rm1);
            cVar.c = bVar;
            cVar.d = aVarArr;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;

        public static final class a extends FileObserver {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ File b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(File file, int i, InterfaceC16204ks5 interfaceC16204ks5, File file2) {
                super(file, i);
                this.a = interfaceC16204ks5;
                this.b = file2;
            }

            @Override // android.os.FileObserver
            public void onEvent(int i, String str) {
                this.a.h(Long.valueOf(this.b.length()));
            }
        }

        public static final class b extends FileObserver {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ File b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i, String str, InterfaceC16204ks5 interfaceC16204ks5, File file) {
                super(str, i);
                this.a = interfaceC16204ks5;
                this.b = file;
            }

            @Override // android.os.FileObserver
            public void onEvent(int i, String str) {
                this.a.h(Long.valueOf(this.b.length()));
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(FileObserver fileObserver) {
            fileObserver.stopWatching();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = GO6.this.new d(interfaceC20295rm1);
            dVar.d = obj;
            return dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0093 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                ir.nasim.AbstractC10685c16.b(r8)
                goto L94
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.b
                java.io.File r1 = (java.io.File) r1
                java.lang.Object r3 = r7.d
                ir.nasim.ks5 r3 = (ir.nasim.InterfaceC16204ks5) r3
                ir.nasim.AbstractC10685c16.b(r8)
                goto L66
            L2a:
                java.lang.Object r1 = r7.d
                ir.nasim.ks5 r1 = (ir.nasim.InterfaceC16204ks5) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L4d
            L32:
                ir.nasim.AbstractC10685c16.b(r8)
                java.lang.Object r8 = r7.d
                ir.nasim.ks5 r8 = (ir.nasim.InterfaceC16204ks5) r8
                ir.nasim.GO6 r1 = ir.nasim.GO6.this
                ir.nasim.GF2 r1 = ir.nasim.GO6.V0(r1)
                r7.d = r8
                r7.c = r4
                java.lang.Object r1 = r1.a(r7)
                if (r1 != r0) goto L4a
                return r0
            L4a:
                r6 = r1
                r1 = r8
                r8 = r6
            L4d:
                java.io.File r8 = (java.io.File) r8
                long r4 = r8.length()
                java.lang.Long r4 = ir.nasim.AbstractC6392Nk0.e(r4)
                r7.d = r1
                r7.b = r8
                r7.c = r3
                java.lang.Object r3 = r1.o(r4, r7)
                if (r3 != r0) goto L64
                return r0
            L64:
                r3 = r1
                r1 = r8
            L66:
                int r8 = android.os.Build.VERSION.SDK_INT
                r4 = 29
                r5 = 4095(0xfff, float:5.738E-42)
                if (r8 < r4) goto L74
                ir.nasim.GO6$d$a r8 = new ir.nasim.GO6$d$a
                r8.<init>(r1, r5, r3, r1)
                goto L7e
            L74:
                java.lang.String r8 = r1.getAbsolutePath()
                ir.nasim.GO6$d$b r4 = new ir.nasim.GO6$d$b
                r4.<init>(r5, r8, r3, r1)
                r8 = r4
            L7e:
                r8.startWatching()
                ir.nasim.HO6 r1 = new ir.nasim.HO6
                r1.<init>()
                r8 = 0
                r7.d = r8
                r7.b = r8
                r7.c = r2
                java.lang.Object r8 = ir.nasim.AbstractC13822gs5.a(r3, r1, r7)
                if (r8 != r0) goto L94
                return r0
            L94:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GO6.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ long c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(interfaceC20295rm1);
            eVar.c = ((Number) obj).longValue();
            return eVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Number) obj).longValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            long j = this.c;
            return new C14767iS0(j > 0, j);
        }

        public final Object n(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(Long.valueOf(j), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ QT1 d;
        final /* synthetic */ GO6 e;

        public static final class a extends FileObserver {
            final /* synthetic */ InterfaceC16204ks5 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(File file, int i, InterfaceC16204ks5 interfaceC16204ks5) {
                super(file, i);
                this.a = interfaceC16204ks5;
            }

            @Override // android.os.FileObserver
            public void onEvent(int i, String str) {
                this.a.h(C19938rB7.a);
            }
        }

        public static final class b extends FileObserver {
            final /* synthetic */ InterfaceC16204ks5 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i, String str, InterfaceC16204ks5 interfaceC16204ks5) {
                super(str, i);
                this.a = interfaceC16204ks5;
            }

            @Override // android.os.FileObserver
            public void onEvent(int i, String str) {
                this.a.h(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(QT1 qt1, GO6 go6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qt1;
            this.e = go6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((FileObserver) it.next()).stopWatching();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                List<File> listE = this.d.e();
                final ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listE, 10));
                for (File file : listE) {
                    arrayList.add(Build.VERSION.SDK_INT >= 29 ? new a(file, 4095, interfaceC16204ks5) : new b(4095, file.getAbsolutePath(), interfaceC16204ks5));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((FileObserver) it.next()).startWatching();
                }
                SA2 sa2 = new SA2() { // from class: ir.nasim.IO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return GO6.f.y(arrayList);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C19938rB7 c19938rB7 = C19938rB7.a;
                this.b = 1;
                if (interfaceC4806Gq2.a(c19938rB7, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QT1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(QT1 qt1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qt1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GO6.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NF2 nf2 = GO6.this.c;
                QT1 qt1 = this.d;
                this.b = 1;
                obj = nf2.c(qt1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return new a(((Number) obj).longValue(), this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(c19938rB7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GO6.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            b bVar;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = GO6.this.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                    bVar = (b) value;
                } while (!interfaceC9336Zm4.f(value, b.b(bVar, false, false, null, false, true, 15, null)));
                if (bVar.f()) {
                    return C19938rB7.a;
                }
                C24238yH1 c24238yH1 = GO6.this.d;
                this.b = 1;
                if (c24238yH1.c(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = GO6.this.g;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, b.b((b) value2, false, false, null, false, false, 14, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GO6.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            b bVar;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = GO6.this.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                    bVar = (b) value;
                } while (!interfaceC9336Zm4.f(value, b.b(bVar, false, false, null, true, false, 23, null)));
                if (bVar.g()) {
                    return C19938rB7.a;
                }
                BH1 bh1 = GO6.this.e;
                Object[] objArr = (Object[]) GO6.this.h.getValue();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : objArr) {
                    if (bVar.c().contains(AbstractC6392Nk0.e(((a) obj2).b().b()))) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((a) it.next()).b());
                }
                this.b = 1;
                if (bh1.e(arrayList2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = GO6.this.g;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, b.b((b) value2, false, false, null, false, false, 23, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class k implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC4557Fq2[] e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                super(0);
                this.e = interfaceC4557Fq2Arr;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new a[this.e.length];
            }
        }

        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    a[] aVarArr = (a[]) ((Object[]) this.d);
                    this.b = 1;
                    if (interfaceC4806Gq2.a(aVarArr, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public k(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
            this.a = interfaceC4557Fq2Arr;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    public static final class l extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ GO6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(InterfaceC20295rm1 interfaceC20295rm1, GO6 go6) {
            super(3, interfaceC20295rm1);
            this.e = go6;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                List list = (List) this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.e.Z0((QT1) it.next()));
                }
                k kVar = new k((InterfaceC4557Fq2[]) AbstractC15401jX0.m1(arrayList).toArray(new InterfaceC4557Fq2[0]));
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, kVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = new l(interfaceC20295rm1, this.e);
            lVar.c = interfaceC4806Gq2;
            lVar.d = obj;
            return lVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC18160oB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;
        /* synthetic */ Object f;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(5, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            b bVar = (b) this.c;
            C14767iS0 c14767iS0 = (C14767iS0) this.d;
            PN6 pn6 = (PN6) this.e;
            long jA = 0;
            for (a aVar : (a[]) this.f) {
                jA += aVar.a();
            }
            return new EO6(new C3828Cn2(jA > 0, jA), c14767iS0, GO6.this.e1(bVar), pn6);
        }

        @Override // ir.nasim.InterfaceC18160oB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object s(b bVar, C14767iS0 c14767iS0, PN6 pn6, a[] aVarArr, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = GO6.this.new m(interfaceC20295rm1);
            mVar.c = bVar;
            mVar.d = c14767iS0;
            mVar.e = pn6;
            mVar.f = aVarArr;
            return mVar.invokeSuspend(C19938rB7.a);
        }
    }

    public GO6(C12232eG2 c12232eG2, AbstractC13778go1 abstractC13778go1, NF2 nf2, C24238yH1 c24238yH1, BH1 bh1, GF2 gf2) {
        AbstractC13042fc3.i(c12232eG2, "getMainDirectories");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(nf2, "getDirectorySize");
        AbstractC13042fc3.i(c24238yH1, "deleteConversations");
        AbstractC13042fc3.i(bh1, "deleteDirectoriesContent");
        AbstractC13042fc3.i(gf2, "getConversationsStorageFile");
        this.b = abstractC13778go1;
        this.c = nf2;
        this.d = c24238yH1;
        this.e = bh1;
        this.f = gf2;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new b(false, false, null, false, false, 31, null));
        this.g = interfaceC9336Zm4A;
        InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
        InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.s0(AbstractC6459Nq2.T(c12232eG2.h()), new l(null, this)), AbstractC9773aX7.a(this), aVar.c(), new a[0]);
        this.h = interfaceC10258bL6O0;
        InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.X(AbstractC6459Nq2.f(new d(null)), new e(null));
        this.i = interfaceC4557Fq2X;
        InterfaceC4557Fq2 interfaceC4557Fq2P = AbstractC6459Nq2.p(interfaceC9336Zm4A, interfaceC10258bL6O0, new c(null));
        this.j = interfaceC4557Fq2P;
        this.k = AbstractC6459Nq2.o0(AbstractC6459Nq2.n(interfaceC9336Zm4A, interfaceC4557Fq2X, interfaceC4557Fq2P, interfaceC10258bL6O0, new m(null)), AbstractC9773aX7.a(this), aVar.c(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 Z0(QT1 qt1) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.v(AbstractC6459Nq2.X(AbstractC6459Nq2.c0(AbstractC6459Nq2.k0(AbstractC6459Nq2.f(new f(qt1, this, null)), 200L), new g(null)), new h(qt1, null))), this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RN6 e1(b bVar) {
        if (bVar.d()) {
            return new RN6(bVar.f());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PN6.b g1(a aVar, b bVar) {
        boolean z = aVar.a() > 0 && bVar.c().contains(Long.valueOf(aVar.b().b()));
        QT1 qt1B = aVar.b();
        if (qt1B instanceof QT1.a) {
            return new PN6.b.a(aVar.b().b(), aVar.a(), z);
        }
        if (qt1B instanceof QT1.b) {
            return new PN6.b.C0575b(aVar.b().b(), aVar.a(), z);
        }
        if (qt1B instanceof QT1.c) {
            return new PN6.b.c(aVar.b().b(), aVar.a(), z);
        }
        if (qt1B instanceof QT1.d) {
            return new PN6.b.d(aVar.b().b(), aVar.a(), z);
        }
        if (qt1B instanceof QT1.e) {
            return new PN6.b.e(aVar.b().b(), aVar.a(), z);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final InterfaceC13730gj3 a1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(null), 3, null);
    }

    public final InterfaceC13730gj3 b1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(null), 3, null);
    }

    public final void c1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, false, false, null, false, false, 30, null)));
    }

    public final void d1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, false, false, AbstractC4597Fu6.d(), false, false, 25, null)));
    }

    public final InterfaceC10258bL6 f1() {
        return this.k;
    }

    public final void h1(long j2) {
        Object value;
        b bVar;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            bVar = (b) value;
        } while (!interfaceC9336Zm4.f(value, b.b(bVar, false, false, bVar.c().contains(Long.valueOf(j2)) ? AbstractC4846Gu6.k(bVar.c(), Long.valueOf(j2)) : AbstractC4846Gu6.m(bVar.c(), Long.valueOf(j2)), false, false, 27, null)));
    }

    public final void i1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, true, false, null, false, false, 28, null)));
    }

    public final void j1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, false, true, null, false, false, 28, null)));
    }

    private static final class b {
        private final boolean a;
        private final boolean b;
        private final Set c;
        private final boolean d;
        private final boolean e;

        public b(boolean z, boolean z2, Set set, boolean z3, boolean z4) {
            AbstractC13042fc3.i(set, "selectedDirectoryIds");
            this.a = z;
            this.b = z2;
            this.c = set;
            this.d = z3;
            this.e = z4;
        }

        public static /* synthetic */ b b(b bVar, boolean z, boolean z2, Set set, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = bVar.a;
            }
            if ((i & 2) != 0) {
                z2 = bVar.b;
            }
            boolean z5 = z2;
            if ((i & 4) != 0) {
                set = bVar.c;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                z3 = bVar.d;
            }
            boolean z6 = z3;
            if ((i & 16) != 0) {
                z4 = bVar.e;
            }
            return bVar.a(z, z5, set2, z6, z4);
        }

        public final b a(boolean z, boolean z2, Set set, boolean z3, boolean z4) {
            AbstractC13042fc3.i(set, "selectedDirectoryIds");
            return new b(z, z2, set, z3, z4);
        }

        public final Set c() {
            return this.c;
        }

        public final boolean d() {
            return this.a;
        }

        public final boolean e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e;
        }

        public final boolean f() {
            return this.e;
        }

        public final boolean g() {
            return this.d;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "InnerState(showDeleteChatDialog=" + this.a + ", showDeleteFilesBottomSheet=" + this.b + ", selectedDirectoryIds=" + this.c + ", isDeletingDirectoriesContent=" + this.d + ", isDeletingChatsContent=" + this.e + Separators.RPAREN;
        }

        public /* synthetic */ b(boolean z, boolean z2, Set set, boolean z3, boolean z4, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? AbstractC4597Fu6.d() : set, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }
    }
}
