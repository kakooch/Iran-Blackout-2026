package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.upstream.cache.Cache;
import ir.nasim.InterfaceC18013nw1;
import ir.nasim.InterfaceC19096pm2;
import ir.nasim.InterfaceC19365qD7;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.MX1;
import ir.nasim.database.model.file.FileState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class QG3 implements PG3 {
    public static final a d = new a(null);
    private final Cache a;
    private final UY1 b;
    private final AbstractC13778go1 c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C4995Hl2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C4995Hl2 c4995Hl2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c4995Hl2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return QG3.this.new b(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r11)
                goto L4e
            L12:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1a:
                ir.nasim.AbstractC10685c16.b(r11)
                goto L3d
            L1e:
                ir.nasim.AbstractC10685c16.b(r11)
                ir.nasim.QG3 r11 = ir.nasim.QG3.this
                ir.nasim.UY1 r4 = ir.nasim.QG3.g(r11)
                ir.nasim.Hl2 r11 = r10.d
                long r5 = r11.b()
                ir.nasim.Hl2 r11 = r10.d
                long r7 = r11.a()
                r10.b = r3
                r9 = r10
                java.lang.Object r11 = r4.i(r5, r7, r9)
                if (r11 != r0) goto L3d
                return r0
            L3d:
                ir.nasim.XY1 r11 = (ir.nasim.XY1) r11
                if (r11 != 0) goto L50
                ir.nasim.QG3 r11 = ir.nasim.QG3.this
                ir.nasim.Hl2 r1 = r10.d
                r10.b = r2
                java.lang.Object r11 = ir.nasim.QG3.i(r11, r1, r10)
                if (r11 != r0) goto L4e
                return r0
            L4e:
                ir.nasim.XY1 r11 = (ir.nasim.XY1) r11
            L50:
                r0 = 0
                if (r11 != 0) goto L5a
                ir.nasim.nw1$b r11 = new ir.nasim.nw1$b
                r1 = 0
                r11.<init>(r0, r1)
                goto Lb2
            L5a:
                ir.nasim.database.model.file.FileState r1 = r11.h()
                ir.nasim.database.model.file.FileState$Downloaded r2 = ir.nasim.database.model.file.FileState.Downloaded.INSTANCE
                boolean r2 = ir.nasim.AbstractC13042fc3.d(r1, r2)
                if (r2 == 0) goto L7a
                ir.nasim.nw1$a r0 = new ir.nasim.nw1$a
                ir.nasim.al2$a r1 = new ir.nasim.al2$a
                java.lang.String r2 = r11.f()
                long r3 = r11.g()
                r1.<init>(r2, r3)
                r0.<init>(r1)
            L78:
                r11 = r0
                goto Lb2
            L7a:
                boolean r2 = r1 instanceof ir.nasim.database.model.file.FileState.NotDownloaded
                if (r2 == 0) goto Lb3
                ir.nasim.database.model.file.FileState$NotDownloaded r1 = (ir.nasim.database.model.file.FileState.NotDownloaded) r1
                java.util.List r2 = r1.getRemainingChunkIndices()
                int r2 = r2.size()
                int r3 = r1.getChunkSize()
                int r2 = r2 * r3
                ir.nasim.pm2$a r3 = new ir.nasim.pm2$a
                java.lang.String r4 = r11.f()
                int r5 = r1.getChunkSize()
                java.util.List r1 = r1.getRemainingChunkIndices()
                r3.<init>(r4, r5, r1)
                float r1 = (float) r2
                long r4 = r11.g()
                float r11 = (float) r4
                float r1 = r1 / r11
                r11 = 1065353216(0x3f800000, float:1.0)
                float r11 = r11 - r1
                float r11 = ir.nasim.AbstractC21867uG5.d(r11, r0)
                ir.nasim.nw1$b r0 = new ir.nasim.nw1$b
                r0.<init>(r11, r3)
                goto L78
            Lb2:
                return r11
            Lb3:
                kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
                r11.<init>()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QG3.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MX1.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MX1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return QG3.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            NavigableSet navigableSetM = QG3.this.a.m(this.d.d());
            AbstractC13042fc3.h(navigableSetM, "getCachedSpans(...)");
            InterfaceC8806Xk1 interfaceC8806Xk1B = QG3.this.a.b(this.d.d());
            AbstractC13042fc3.h(interfaceC8806Xk1B, "getContentMetadata(...)");
            long jA = InterfaceC8806Xk1.a(interfaceC8806Xk1B);
            if (jA == -1) {
                return new InterfaceC18013nw1.b(0.0f, new InterfaceC19096pm2.b(AbstractC15401jX0.m1(navigableSetM)));
            }
            long jC = QG3.this.a.c(this.d.d(), 0L, jA);
            return (jC >= jA || ((long) 8) + jC >= jA) ? new InterfaceC18013nw1.a(new InterfaceC9905al2.b(jA, navigableSetM)) : new InterfaceC18013nw1.b(AbstractC23053wG5.d(jC / jA, 0.0f), new InterfaceC19096pm2.b(AbstractC15401jX0.m1(navigableSetM)));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return QG3.this.j(null, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC19365qD7 c;
        final /* synthetic */ QG3 d;
        final /* synthetic */ MX1.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC19365qD7 interfaceC19365qD7, QG3 qg3, MX1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC19365qD7;
            this.d = qg3;
            this.e = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strB;
            FileState notDownloaded;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19365qD7 interfaceC19365qD7 = this.c;
                if (interfaceC19365qD7 instanceof InterfaceC19365qD7.a) {
                    strB = ((InterfaceC9905al2.a) ((InterfaceC19365qD7.a) interfaceC19365qD7).a()).a();
                    notDownloaded = FileState.Downloaded.INSTANCE;
                } else {
                    if (!(interfaceC19365qD7 instanceof InterfaceC19365qD7.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InterfaceC19096pm2.a aVar = (InterfaceC19096pm2.a) ((InterfaceC19365qD7.b) interfaceC19365qD7).a();
                    strB = aVar.b();
                    notDownloaded = new FileState.NotDownloaded(aVar.a(), aVar.c());
                }
                UY1 uy1 = this.d.b;
                XY1[] xy1Arr = {new XY1(this.e.c().b(), this.e.c().a(), this.e.a(), this.e.b(), strB, notDownloaded)};
                this.b = 1;
                if (uy1.d(xy1Arr, this) == objE) {
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

    public QG3(Cache cache, UY1 uy1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(cache, "streamCache");
        AbstractC13042fc3.i(uy1, "downloadStateDao");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = cache;
        this.b = uy1;
        this.c = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(ir.nasim.C4995Hl2 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.QG3.d
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.QG3$d r0 = (ir.nasim.QG3.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.QG3$d r0 = new ir.nasim.QG3$d
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r7 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.e
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 == r2) goto L38
            if (r1 != r8) goto L30
            java.lang.Object r10 = r0.a
            ir.nasim.XY1 r10 = (ir.nasim.XY1) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L79
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            java.lang.Object r10 = r0.b
            ir.nasim.Hl2 r10 = (ir.nasim.C4995Hl2) r10
            java.lang.Object r1 = r0.a
            ir.nasim.QG3 r1 = (ir.nasim.QG3) r1
            ir.nasim.AbstractC10685c16.b(r11)
            goto L60
        L44:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.UY1 r1 = r9.b
            long r3 = r10.b()
            r0.a = r9
            r0.b = r10
            r0.e = r2
            r5 = -1
            r2 = r3
            r4 = r5
            r6 = r0
            java.lang.Object r11 = r1.i(r2, r4, r6)
            if (r11 != r7) goto L5f
            return r7
        L5f:
            r1 = r9
        L60:
            ir.nasim.XY1 r11 = (ir.nasim.XY1) r11
            if (r11 == 0) goto L7a
            ir.nasim.UY1 r1 = r1.b
            long r2 = r10.a()
            r0.a = r11
            r10 = 0
            r0.b = r10
            r0.e = r8
            java.lang.Object r10 = r1.e(r11, r2, r0)
            if (r10 != r7) goto L78
            return r7
        L78:
            r10 = r11
        L79:
            r11 = r10
        L7a:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.QG3.j(ir.nasim.Hl2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.PG3
    public Object a(MX1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new c(bVar, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.PG3
    public Object b(C4995Hl2 c4995Hl2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new b(c4995Hl2, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.PG3
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.b.b(interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    @Override // ir.nasim.PG3
    public Object d(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
        String strB;
        FileState notDownloaded;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            MX1.a aVar = (MX1.a) entry.getKey();
            InterfaceC19365qD7 interfaceC19365qD7 = (InterfaceC19365qD7) entry.getValue();
            if (interfaceC19365qD7 instanceof InterfaceC19365qD7.a) {
                strB = ((InterfaceC9905al2.a) ((InterfaceC19365qD7.a) interfaceC19365qD7).a()).a();
                notDownloaded = FileState.Downloaded.INSTANCE;
            } else {
                if (!(interfaceC19365qD7 instanceof InterfaceC19365qD7.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC19096pm2.a aVar2 = (InterfaceC19096pm2.a) ((InterfaceC19365qD7.b) interfaceC19365qD7).a();
                strB = aVar2.b();
                notDownloaded = new FileState.NotDownloaded(aVar2.a(), aVar2.c());
            }
            arrayList.add(new XY1(aVar.c().b(), aVar.c().a(), aVar.a(), aVar.b(), strB, notDownloaded));
        }
        Object objH = this.b.h(arrayList, interfaceC20295rm1);
        return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
    }

    @Override // ir.nasim.PG3
    public Object e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        UY1 uy1 = this.b;
        List<C4995Hl2> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (C4995Hl2 c4995Hl2 : list2) {
            arrayList.add(new C21564tl2(c4995Hl2.b(), c4995Hl2.a()));
        }
        Object objF = uy1.f(arrayList, interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    @Override // ir.nasim.PG3
    public Object f(MX1.a aVar, InterfaceC19365qD7 interfaceC19365qD7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new e(interfaceC19365qD7, this, aVar, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
