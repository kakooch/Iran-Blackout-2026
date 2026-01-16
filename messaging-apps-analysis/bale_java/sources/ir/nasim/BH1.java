package ir.nasim;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class BH1 {
    private final AbstractC13778go1 a;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ QT1 d;
        final /* synthetic */ BH1 e;

        /* renamed from: ir.nasim.BH1$a$a, reason: collision with other inner class name */
        static final class C0289a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ BH1 c;
            final /* synthetic */ File d;
            final /* synthetic */ QT1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0289a(BH1 bh1, File file, QT1 qt1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = bh1;
                this.d = file;
                this.e = qt1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0289a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.d(this.d, this.e.a(), false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0289a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(QT1 qt1, BH1 bh1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qt1;
            this.e = bh1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0096 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                ir.nasim.AbstractC10685c16.b(r14)
                goto L97
            L16:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1e:
                ir.nasim.AbstractC10685c16.b(r14)
                goto L88
            L22:
                java.lang.Object r1 = r13.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r14)
                goto L43
            L2a:
                ir.nasim.AbstractC10685c16.b(r14)
                java.lang.Object r14 = r13.c
                r1 = r14
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.QT1 r14 = r13.d
                ir.nasim.UA2 r14 = r14.d()
                r13.c = r1
                r13.b = r4
                java.lang.Object r14 = r14.invoke(r13)
                if (r14 != r0) goto L43
                return r0
            L43:
                ir.nasim.QT1 r14 = r13.d
                java.util.List r14 = r14.e()
                java.lang.Iterable r14 = (java.lang.Iterable) r14
                ir.nasim.BH1 r10 = r13.e
                ir.nasim.QT1 r11 = r13.d
                java.util.ArrayList r12 = new java.util.ArrayList
                r4 = 10
                int r4 = ir.nasim.ZW0.x(r14, r4)
                r12.<init>(r4)
                java.util.Iterator r14 = r14.iterator()
            L5e:
                boolean r4 = r14.hasNext()
                r5 = 0
                if (r4 == 0) goto L7d
                java.lang.Object r4 = r14.next()
                java.io.File r4 = (java.io.File) r4
                ir.nasim.BH1$a$a r7 = new ir.nasim.BH1$a$a
                r7.<init>(r10, r4, r11, r5)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                r4 = r1
                ir.nasim.zG1 r4 = ir.nasim.AbstractC9323Zl0.b(r4, r5, r6, r7, r8, r9)
                r12.add(r4)
                goto L5e
            L7d:
                r13.c = r5
                r13.b = r3
                java.lang.Object r14 = ir.nasim.DV.a(r12, r13)
                if (r14 != r0) goto L88
                return r0
            L88:
                ir.nasim.QT1 r14 = r13.d
                ir.nasim.UA2 r14 = r14.c()
                r13.b = r2
                java.lang.Object r14 = r14.invoke(r13)
                if (r14 != r0) goto L97
                return r0
            L97:
                ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BH1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ List d;
        final /* synthetic */ BH1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, BH1 bh1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = bh1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                List list = this.d;
                BH1 bh1 = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(bh1.c(interfaceC20315ro1, (QT1) it.next()));
                }
                this.b = 1;
                obj = DV.a(arrayList, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public BH1(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC24823zG1 c(InterfaceC20315ro1 interfaceC20315ro1, QT1 qt1) {
        return AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(qt1, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(File file, InterfaceC6897Pl2 interfaceC6897Pl2, boolean z) {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            boolean z2 = false;
            if (fileArrListFiles != null) {
                ArrayList<File> arrayList = new ArrayList();
                boolean z3 = false;
                for (File file2 : fileArrListFiles) {
                    AbstractC13042fc3.f(file2);
                    boolean zA = interfaceC6897Pl2.a(file, file2);
                    z3 = z3 || !zA;
                    if (zA) {
                        arrayList.add(file2);
                    }
                }
                for (File file3 : arrayList) {
                    if (file3.isDirectory()) {
                        AbstractC13042fc3.f(file3);
                        d(file3, interfaceC6897Pl2, true);
                    } else {
                        file3.delete();
                    }
                }
                z2 = z3;
            }
            if (!z || z2) {
                return;
            }
            file.delete();
        }
    }

    public final Object e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new b(list, this, null), interfaceC20295rm1);
    }
}
