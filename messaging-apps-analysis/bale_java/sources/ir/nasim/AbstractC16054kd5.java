package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC16054kd5;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.kd5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16054kd5 {

    /* renamed from: ir.nasim.kd5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19206px3 c;
        final /* synthetic */ InterfaceC13346g43 d;
        final /* synthetic */ int e;
        final /* synthetic */ boolean f;
        final /* synthetic */ UA2 g;

        /* renamed from: ir.nasim.kd5$a$a, reason: collision with other inner class name */
        static final class C1355a implements InterfaceC4806Gq2 {
            final /* synthetic */ UA2 a;

            C1355a(UA2 ua2) {
                this.a = ua2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                if (obj != null) {
                    this.a.invoke(obj);
                }
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.kd5$a$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ InterfaceC13346g43 b;
            final /* synthetic */ int c;
            final /* synthetic */ boolean d;

            /* renamed from: ir.nasim.kd5$a$b$a, reason: collision with other inner class name */
            public static final class C1356a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ InterfaceC13346g43 b;
                final /* synthetic */ int c;
                final /* synthetic */ boolean d;

                /* renamed from: ir.nasim.kd5$a$b$a$a, reason: collision with other inner class name */
                public static final class C1357a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1357a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1356a.this.a(null, this);
                    }
                }

                public C1356a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC13346g43 interfaceC13346g43, int i, boolean z) {
                    this.a = interfaceC4806Gq2;
                    this.b = interfaceC13346g43;
                    this.c = i;
                    this.d = z;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.AbstractC16054kd5.a.b.C1356a.C1357a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.kd5$a$b$a$a r0 = (ir.nasim.AbstractC16054kd5.a.b.C1356a.C1357a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.kd5$a$b$a$a r0 = new ir.nasim.kd5$a$b$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        java.lang.Number r7 = (java.lang.Number) r7
                        int r7 = r7.intValue()
                        ir.nasim.g43 r2 = r6.b
                        int r4 = r6.c
                        int r7 = r7 + r4
                        boolean r5 = r6.d
                        java.lang.Object r7 = ir.nasim.AbstractC16054kd5.m(r2, r7, r5, r4)
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L50
                        return r1
                    L50:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16054kd5.a.b.C1356a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC13346g43 interfaceC13346g43, int i, boolean z) {
                this.a = interfaceC4557Fq2;
                this.b = interfaceC13346g43;
                this.c = i;
                this.d = z;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1356a(interfaceC4806Gq2, this.b, this.c, this.d), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19206px3 c19206px3, InterfaceC13346g43 interfaceC13346g43, int i, boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19206px3;
            this.d = interfaceC13346g43;
            this.e = i;
            this.f = z;
            this.g = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int y(C19206px3 c19206px3) {
            return c19206px3.s();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final C19206px3 c19206px3 = this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(AbstractC10222bH6.r(new SA2() { // from class: ir.nasim.jd5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Integer.valueOf(AbstractC16054kd5.a.y(c19206px3));
                    }
                }), this.d, this.e, this.f));
                C1355a c1355a = new C1355a(this.g);
                this.b = 1;
                if (interfaceC4557Fq2V.b(c1355a, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kd5$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ Context a;
        final /* synthetic */ InterfaceC13346g43 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;
        final /* synthetic */ long e;
        final /* synthetic */ C9348Zn7 f;
        final /* synthetic */ InterfaceC9102Ym4 g;

        b(Context context, InterfaceC13346g43 interfaceC13346g43, boolean z, int i, long j, C9348Zn7 c9348Zn7, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = context;
            this.b = interfaceC13346g43;
            this.c = z;
            this.d = i;
            this.e = j;
            this.f = c9348Zn7;
            this.g = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4, C4414Fa3 c4414Fa3) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$itemHeightPixels");
            interfaceC9102Ym4.setValue(Integer.valueOf((int) (c4414Fa3.j() & 4294967295L)));
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Context context = this.a;
            Object objP = AbstractC16054kd5.p(this.b, i, this.c, this.d);
            String string = objP != null ? objP.toString() : null;
            if (string == null) {
                string = "";
            }
            String strG = XY6.g(context, string);
            int iB = AbstractC23365wn7.a.b();
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(194641921);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.g;
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ld5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16054kd5.b.c(interfaceC9102Ym4, (C4414Fa3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC9339Zm7.b(strG, androidx.compose.foundation.layout.q.i(androidx.compose.ui.layout.e.a(aVar, (UA2) objB), C17784nZ1.q(8)), this.e, 0L, null, null, null, 0L, null, null, 0L, iB, false, 1, 0, null, this.f, interfaceC22053ub1, 48, 3120, 55288);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0484 A[PHI: r6
      0x0484: PHI (r6v21 long) = (r6v18 long), (r6v22 long) binds: [B:235:0x0482, B:231:0x047b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04a1 A[PHI: r9
      0x04a1: PHI (r9v33 ir.nasim.Zn7) = (r9v30 ir.nasim.Zn7), (r9v34 ir.nasim.Zn7) binds: [B:245:0x049f, B:241:0x0498] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(androidx.compose.ui.e r43, final ir.nasim.InterfaceC13346g43 r44, final java.lang.Object r45, int r46, ir.nasim.C9348Zn7 r47, long r48, long r50, boolean r52, final ir.nasim.UA2 r53, ir.nasim.InterfaceC22053ub1 r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16054kd5.f(androidx.compose.ui.e, ir.nasim.g43, java.lang.Object, int, ir.nasim.Zn7, long, long, boolean, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    public static final void g(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(217404029);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1758986483);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(1, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            InterfaceC13346g43 interfaceC13346g43D = AbstractC7783Te2.d(new C24411ya3(1, 99));
            C9348Zn7 c9348Zn7 = new C9348Zn7(0L, AbstractC13784go7.g(32), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, 0, 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16777213, (ED1) null);
            interfaceC22053ub1J.W(1758991899);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ed5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16054kd5.i(interfaceC9102Ym4, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            f(null, interfaceC13346g43D, 10, 0, c9348Zn7, 0L, 0L, false, (UA2) objB2, interfaceC22053ub1J, 100688256, SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fd5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16054kd5.j(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, int i) {
        interfaceC9102Ym4.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4, int i) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$valuesPickerState$delegate");
        h(interfaceC9102Ym4, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        g(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(androidx.compose.ui.e eVar, InterfaceC13346g43 interfaceC13346g43, Object obj, int i, C9348Zn7 c9348Zn7, long j, long j2, boolean z, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC13346g43, "$items");
        AbstractC13042fc3.i(ua2, "$onItemSelectedChanged");
        f(eVar, interfaceC13346g43, obj, i, c9348Zn7, j, j2, z, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, Context context, InterfaceC13346g43 interfaceC13346g43, boolean z, int i2, long j, C9348Zn7 c9348Zn7, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(interfaceC13346g43, "$items");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$itemHeightPixels");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, i, null, null, AbstractC19242q11.c(-122256392, true, new b(context, interfaceC13346g43, z, i2, j, c9348Zn7, interfaceC9102Ym4)), 6, null);
        return C19938rB7.a;
    }

    private static final androidx.compose.ui.e n(androidx.compose.ui.e eVar, final AbstractC12520el0 abstractC12520el0) {
        return androidx.compose.ui.draw.b.d(androidx.compose.ui.graphics.b.c(eVar, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, androidx.compose.ui.graphics.a.a.c(), 65535, null), new UA2() { // from class: ir.nasim.id5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC16054kd5.o(abstractC12520el0, (InterfaceC23919xk1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(AbstractC12520el0 abstractC12520el0, InterfaceC23919xk1 interfaceC23919xk1) {
        AbstractC13042fc3.i(abstractC12520el0, "$brush");
        AbstractC13042fc3.i(interfaceC23919xk1, "$this$drawWithContent");
        interfaceC23919xk1.N1();
        InterfaceC17460n02.y0(interfaceC23919xk1, abstractC12520el0, 0L, 0L, 0.0f, null, null, AbstractC7094Qg0.a.i(), 62, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object p(List list, int i, boolean z, int i2) {
        if (z) {
            return list.get(i % list.size());
        }
        int size = list.size();
        int i3 = i - i2;
        if (i3 < 0 || i3 >= size) {
            return null;
        }
        return list.get(i3);
    }

    private static final float q(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(-1225635580);
        float fD = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).D(i);
        interfaceC22053ub1.Q();
        return fD;
    }
}
