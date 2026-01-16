package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC24275yL2;
import ir.nasim.AbstractC4600Fv0;

/* renamed from: ir.nasim.yL2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC24275yL2 {

    /* renamed from: ir.nasim.yL2$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C17448mz0 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;

        /* renamed from: ir.nasim.yL2$a$a, reason: collision with other inner class name */
        static final class C1787a implements InterfaceC15796kB2 {
            final /* synthetic */ C17448mz0 a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ SA2 c;

            /* renamed from: ir.nasim.yL2$a$a$a, reason: collision with other inner class name */
            static final class C1788a implements InterfaceC14603iB2 {
                final /* synthetic */ C12889fL5 a;
                final /* synthetic */ C17448mz0 b;
                final /* synthetic */ boolean c;
                final /* synthetic */ C12889fL5 d;
                final /* synthetic */ C12889fL5 e;
                final /* synthetic */ C12889fL5 f;
                final /* synthetic */ SA2 g;
                final /* synthetic */ SA2 h;

                C1788a(C12889fL5 c12889fL5, C17448mz0 c17448mz0, boolean z, C12889fL5 c12889fL52, C12889fL5 c12889fL53, C12889fL5 c12889fL54, SA2 sa2, SA2 sa22) {
                    this.a = c12889fL5;
                    this.b = c17448mz0;
                    this.c = z;
                    this.d = c12889fL52;
                    this.e = c12889fL53;
                    this.f = c12889fL54;
                    this.g = sa2;
                    this.h = sa22;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(SA2 sa2) {
                    AbstractC13042fc3.i(sa2, "$onShareCallLink");
                    sa2.invoke();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(SA2 sa2) {
                    AbstractC13042fc3.i(sa2, "$onCopyCallLink");
                    sa2.invoke();
                    return C19938rB7.a;
                }

                public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    AbstractC4600Fv0.c cVar = new AbstractC4600Fv0.c((String) this.a.a, this.b.c(), this.c, (Long) this.d.a, null, (String) this.e.a, (Long) this.f.a, null, null, 400, null);
                    interfaceC22053ub1.W(-1896989825);
                    boolean zV = interfaceC22053ub1.V(this.g);
                    final SA2 sa2 = this.g;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.wL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC24275yL2.a.C1787a.C1788a.d(sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa22 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-1896985762);
                    boolean zV2 = interfaceC22053ub1.V(this.h);
                    final SA2 sa23 = this.h;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.xL2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC24275yL2.a.C1787a.C1788a.f(sa23);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC9413Zv0.j(cVar, sa22, (SA2) objB2, null, null, null, false, null, interfaceC22053ub1, 1572864, 184);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C1787a(C17448mz0 c17448mz0, SA2 sa2, SA2 sa22) {
                this.a = c17448mz0;
                this.b = sa2;
                this.c = sa22;
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(ir.nasim.ZY0 r11, ir.nasim.InterfaceC22053ub1 r12, int r13) {
                /*
                    r10 = this;
                    java.lang.String r0 = "$this$ModalBottomSheet"
                    ir.nasim.AbstractC13042fc3.i(r11, r0)
                    r11 = r13 & 17
                    r13 = 16
                    if (r11 != r13) goto L17
                    boolean r11 = r12.k()
                    if (r11 != 0) goto L12
                    goto L17
                L12:
                    r12.L()
                    goto L9c
                L17:
                    ir.nasim.mz0 r11 = r10.a
                    ir.nasim.Pz0 r11 = r11.f()
                    boolean r13 = r11 instanceof ir.nasim.AbstractC7031Pz0.f
                    r0 = 1
                    if (r13 == 0) goto L2a
                    ir.nasim.Pz0$f r11 = (ir.nasim.AbstractC7031Pz0.f) r11
                    boolean r11 = r11.c()
                L28:
                    r4 = r11
                    goto L36
                L2a:
                    boolean r13 = r11 instanceof ir.nasim.AbstractC7031Pz0.h
                    if (r13 != 0) goto L35
                    boolean r11 = r11 instanceof ir.nasim.AbstractC7031Pz0.j
                    if (r11 == 0) goto L33
                    goto L35
                L33:
                    r11 = 0
                    goto L28
                L35:
                    r4 = r0
                L36:
                    ir.nasim.fL5 r2 = new ir.nasim.fL5
                    r2.<init>()
                    java.lang.String r11 = ""
                    r2.a = r11
                    ir.nasim.fL5 r5 = new ir.nasim.fL5
                    r5.<init>()
                    ir.nasim.fL5 r6 = new ir.nasim.fL5
                    r6.<init>()
                    ir.nasim.fL5 r7 = new ir.nasim.fL5
                    r7.<init>()
                    ir.nasim.mz0 r13 = r10.a
                    ir.nasim.Pz0 r13 = r13.f()
                    boolean r1 = r13 instanceof ir.nasim.AbstractC7031Pz0.f
                    if (r1 == 0) goto L76
                    ir.nasim.Pz0$f r13 = (ir.nasim.AbstractC7031Pz0.f) r13
                    java.lang.String r1 = r13.d()
                    if (r1 != 0) goto L61
                    goto L62
                L61:
                    r11 = r1
                L62:
                    r2.a = r11
                    java.lang.Long r11 = r13.h()
                    r5.a = r11
                    java.lang.String r11 = r13.f()
                    r6.a = r11
                    java.lang.Long r11 = r13.e()
                    r7.a = r11
                L76:
                    ir.nasim.Nx5 r11 = ir.nasim.AbstractC13040fc1.n()
                    ir.nasim.eu3 r13 = ir.nasim.EnumC12613eu3.b
                    ir.nasim.Qx5 r11 = r11.d(r13)
                    ir.nasim.yL2$a$a$a r13 = new ir.nasim.yL2$a$a$a
                    ir.nasim.mz0 r3 = r10.a
                    ir.nasim.SA2 r8 = r10.b
                    ir.nasim.SA2 r9 = r10.c
                    r1 = r13
                    r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                    r1 = 54
                    r2 = 390260526(0x1742e72e, float:6.297657E-25)
                    ir.nasim.o11 r13 = ir.nasim.AbstractC19242q11.e(r2, r0, r13, r12, r1)
                    int r0 = ir.nasim.C7252Qx5.i
                    r0 = r0 | 48
                    ir.nasim.AbstractC11024cc1.a(r11, r13, r12, r0)
                L9c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24275yL2.a.C1787a.a(ir.nasim.ZY0, ir.nasim.ub1, int):void");
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, C17448mz0 c17448mz0, SA2 sa22, SA2 sa23) {
            this.a = sa2;
            this.b = c17448mz0;
            this.c = sa22;
            this.d = sa23;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9273Zf4.a(this.a, null, null, 0.0f, null, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, 0.0f, 0L, R51.a.a(), null, null, AbstractC19242q11.e(-1420688402, true, new C1787a(this.b, this.c, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, 805306368, 384, 3550);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final C17448mz0 c17448mz0, final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c17448mz0, "uiState");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(sa22, "onCopyCallLink");
        AbstractC13042fc3.i(sa23, "onShareCallLink");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(600336534);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c17448mz0) : interfaceC22053ub1J.D(c17448mz0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-491106863, true, new a(sa2, c17448mz0, sa23, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.vL2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24275yL2.c(c17448mz0, sa2, sa22, sa23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(C17448mz0 c17448mz0, SA2 sa2, SA2 sa22, SA2 sa23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c17448mz0, "$uiState");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(sa22, "$onCopyCallLink");
        AbstractC13042fc3.i(sa23, "$onShareCallLink");
        b(c17448mz0, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
