package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.X62;
import ir.nasim.features.smiles.panel.emoji.db.EmojiDatabase;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class T62 extends VW7 {
    private final EmojiDatabase b;
    private final HashMap c;
    private final ArrayList d;
    private ArrayList e;
    private final C20298rm4 f;
    private final C20298rm4 g;
    private final b h;
    private final ArrayList i;
    private final InterfaceC9336Zm4 j;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.T62$a$a, reason: collision with other inner class name */
        static final class C0645a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ T62 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0645a(T62 t62, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = t62;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0645a c0645a = new C0645a(this.d, interfaceC20295rm1);
                c0645a.c = obj;
                return c0645a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                List list;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    String str = (String) this.c;
                    if (str != null) {
                        if (str.length() == 0) {
                            this.d.k1();
                        } else if (new Bidi(str, -2).isLeftToRight()) {
                            InterfaceC10115b62 interfaceC10115b62H = this.d.b.H();
                            this.b = 1;
                            obj = interfaceC10115b62H.c(str, this);
                            if (obj == objE) {
                                return objE;
                            }
                            list = (List) obj;
                        } else {
                            InterfaceC10115b62 interfaceC10115b62H2 = this.d.b.H();
                            this.b = 2;
                            obj = interfaceC10115b62H2.b(str, this);
                            if (obj == objE) {
                                return objE;
                            }
                            list = (List) obj;
                        }
                    }
                    return C19938rB7.a;
                }
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    list = (List) obj;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    list = (List) obj;
                }
                C20298rm4 c20298rm4 = this.d.g;
                List list2 = list;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new X62.a(0, ((C10731c62) it.next()).a(), false));
                }
                c20298rm4.n(arrayList);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0645a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2S = AbstractC6459Nq2.s(T62.this.j, 200L);
                C0645a c0645a = new C0645a(T62.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2S, c0645a, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b {
        private final int a;
        private final int b;
        private final int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final int c() {
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
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "EmojiTabData(index=" + this.a + ", title=" + this.b + ", icon=" + this.c + Separators.RPAREN;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = this.c;
            if (str != null) {
                R62 r62 = R62.a;
                if (r62.I(str)) {
                    r62.n(this.c);
                    r62.b0();
                    r62.Z();
                    return C19938rB7.a;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                R62.a.p();
                T62.this.d.clear();
                T62 t62 = T62.this;
                this.b = 1;
                obj = t62.d1(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            T62.this.l1();
            T62.this.g.n((List) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = T62.this.j;
                this.b = 1;
                if (interfaceC9336Zm4.a("", this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return T62.this.d1(this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            C11637dL5 c11637dL5 = new C11637dL5();
            List listE = T52.e();
            T62 t62 = T62.this;
            int i = 0;
            for (Object obj2 : listE) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                Object obj3 = t62.i.get(i);
                AbstractC13042fc3.h(obj3, "get(...)");
                b bVar = (b) obj3;
                arrayList.add(new X62.b(bVar.b(), bVar.c()));
                HashMap map = t62.c;
                Integer numD = AbstractC6392Nk0.d(bVar.b());
                int i3 = c11637dL5.a;
                c11637dL5.a = i3 + 1;
                map.put(numD, AbstractC6392Nk0.d(i3));
                List list = (List) obj2;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new X62.a(bVar.b(), (String) it.next(), false));
                }
                arrayList.addAll(arrayList2);
                c11637dL5.a += arrayList2.size();
                i = i2;
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return T62.this.j1(this);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                T62 t62 = T62.this;
                this.b = 1;
                obj = t62.j1(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            T62.this.l1();
            T62.this.g.n((List) obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C20298rm4 c20298rm4;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (T62.this.d.isEmpty()) {
                    T62.this.k1();
                    return C19938rB7.a;
                }
                C20298rm4 c20298rm42 = T62.this.g;
                T62 t62 = T62.this;
                this.b = c20298rm42;
                this.c = 1;
                Object objJ1 = t62.j1(this);
                if (objJ1 == objE) {
                    return objE;
                }
                c20298rm4 = c20298rm42;
                obj = objJ1;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c20298rm4 = (C20298rm4) this.b;
                AbstractC10685c16.b(obj);
            }
            c20298rm4.n(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return T62.this.new k(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = T62.this.j;
                String strM = AbstractC20153rZ6.M(this.d, Separators.SEMICOLON, "", false, 4, null);
                this.b = 1;
                if (interfaceC9336Zm4.a(strM, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public T62(EmojiDatabase emojiDatabase) {
        AbstractC13042fc3.i(emojiDatabase, "emojiDatabase");
        this.b = emojiDatabase;
        this.c = new HashMap();
        this.d = new ArrayList();
        this.f = new C20298rm4();
        this.g = new C20298rm4();
        this.h = new b(0, AbstractC12217eE5.smiles_emoji_recent, KB5.smiles_emoji_recent);
        this.i = AbstractC10360bX0.g(new b(1, AbstractC12217eE5.smiles_emoji_emoji1, KB5.smiles_emoji_pack_1), new b(2, AbstractC12217eE5.smiles_emoji_emoji2, KB5.smiles_emoji_pack_2), new b(3, AbstractC12217eE5.smiles_emoji_emoji3, KB5.smiles_emoji_pack_3), new b(4, AbstractC12217eE5.smiles_emoji_emoji4, KB5.smiles_emoji_pack_4), new b(5, AbstractC12217eE5.smiles_emoji_emoji5, KB5.smiles_emoji_pack_5), new b(6, AbstractC12217eE5.smiles_emoji_emoji6, KB5.smiles_emoji_pack_6), new b(7, AbstractC12217eE5.smiles_emoji_emoji7, KB5.smiles_emoji_pack_7), new b(8, AbstractC12217eE5.smiles_emoji_emoji8, KB5.smiles_emoji_pack_8));
        this.j = AbstractC12281eL6.a(null);
        k1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.T62.f
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.T62$f r0 = (ir.nasim.T62.f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.T62$f r0 = new ir.nasim.T62$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.T62 r0 = (ir.nasim.T62) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L53
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            java.util.ArrayList r6 = r5.e
            if (r6 == 0) goto L3d
            goto L5a
        L3d:
            ir.nasim.go1 r6 = ir.nasim.C12366eV1.a()
            ir.nasim.T62$g r2 = new ir.nasim.T62$g
            r4 = 0
            r2.<init>(r4)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L52
            return r1
        L52:
            r0 = r5
        L53:
            r1 = r6
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r0.e = r1
            java.util.List r6 = (java.util.List) r6
        L5a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.T62.d1(ir.nasim.rm1):java.lang.Object");
    }

    private final List h1() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListF = R62.a.F();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayListF, 10));
        Iterator it = arrayListF.iterator();
        while (it.hasNext()) {
            arrayList2.add(new X62.a(this.h.b(), (String) it.next(), true));
        }
        arrayList.addAll(arrayList2);
        if (!arrayList.isEmpty()) {
            arrayList.add(0, new X62.b(this.h.b(), this.h.c()));
        }
        this.d.clear();
        this.d.addAll(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j1(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.T62.h
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.T62$h r0 = (ir.nasim.T62.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.T62$h r0 = new ir.nasim.T62$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            java.util.Collection r0 = (java.util.Collection) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            java.util.List r6 = r5.h1()
            java.util.Collection r6 = (java.util.Collection) r6
            r0.a = r6
            r0.d = r3
            java.lang.Object r0 = r5.d1(r0)
            if (r0 != r1) goto L49
            return r1
        L49:
            r4 = r0
            r0 = r6
            r6 = r4
        L4c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r6 = ir.nasim.ZW0.R0(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.T62.j1(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 k1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new i(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        ArrayList arrayList = new ArrayList();
        if (!this.d.isEmpty()) {
            arrayList.add(new b(this.h.b(), this.h.c(), this.h.a()));
        }
        arrayList.addAll(this.i);
        this.f.n(arrayList);
    }

    public final InterfaceC13730gj3 a1(String str) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new c(str, null), 2, null);
    }

    public final InterfaceC13730gj3 b1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new d(null), 2, null);
    }

    public final InterfaceC13730gj3 c1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new e(null), 2, null);
    }

    public final androidx.lifecycle.r e1() {
        return this.g;
    }

    public final androidx.lifecycle.r f1() {
        return this.f;
    }

    public final int g1(int i2) {
        if (i2 == this.h.b()) {
            return 0;
        }
        Integer num = (Integer) this.c.get(Integer.valueOf(i2));
        return (num != null ? num.intValue() : 0) + this.d.size();
    }

    public final Integer i1(int i2) {
        List list = (List) this.f.f();
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (((b) it.next()).b() == i2) {
                break;
            }
            i3++;
        }
        return Integer.valueOf(i3);
    }

    public final InterfaceC13730gj3 m1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.a(), null, new j(null), 2, null);
    }

    public final InterfaceC13730gj3 o1(String str) {
        AbstractC13042fc3.i(str, "query");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(str, null), 3, null);
    }
}
