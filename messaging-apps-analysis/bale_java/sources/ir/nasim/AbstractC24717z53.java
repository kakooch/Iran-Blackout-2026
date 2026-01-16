package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Canvas;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC24717z53;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.z53, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC24717z53 {

    /* renamed from: ir.nasim.z53$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = sa2;
            this.e = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (AbstractC24717z53.g(this.e)) {
                    this.c.invoke(AbstractC6392Nk0.a(true));
                    this.b = 1;
                    if (HG1.b(250L, this) == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.d.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.z53$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        /* renamed from: ir.nasim.z53$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            int c;
            int d;
            int e;
            final /* synthetic */ int f;
            final /* synthetic */ InterfaceC9049Yg5 g;
            final /* synthetic */ InterfaceC9102Ym4 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.f = i;
                this.g = interfaceC9049Yg5;
                this.h = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.f, this.g, this.h, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005e -> B:17:0x0061). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r7.e
                    r2 = 1
                    if (r1 == 0) goto L1d
                    if (r1 != r2) goto L15
                    int r1 = r7.d
                    int r3 = r7.c
                    int r4 = r7.b
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L61
                L15:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1d:
                    ir.nasim.AbstractC10685c16.b(r8)
                    int r8 = r7.f
                    ir.nasim.Yg5 r1 = r7.g
                    r3 = 250(0xfa, float:3.5E-43)
                    float r3 = (float) r3
                    float r3 = ir.nasim.C17784nZ1.q(r3)
                    float r1 = r1.w1(r3)
                    int r1 = (int) r1
                    ir.nasim.ya3 r8 = ir.nasim.AbstractC21867uG5.y(r8, r1)
                    r1 = 20
                    ir.nasim.wa3 r8 = ir.nasim.AbstractC21867uG5.v(r8, r1)
                    int r1 = r8.o()
                    int r3 = r8.t()
                    int r8 = r8.v()
                    if (r8 <= 0) goto L4a
                    if (r1 <= r3) goto L4e
                L4a:
                    if (r8 >= 0) goto L6b
                    if (r3 > r1) goto L6b
                L4e:
                    r4 = r1
                    r1 = r8
                L50:
                    r7.b = r4
                    r7.c = r3
                    r7.d = r1
                    r7.e = r2
                    r5 = 1
                    java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                    if (r8 != r0) goto L61
                    return r0
                L61:
                    ir.nasim.Ym4 r8 = r7.h
                    float r5 = (float) r4
                    ir.nasim.AbstractC24717z53.w(r8, r5)
                    if (r4 == r3) goto L6b
                    int r4 = r4 + r1
                    goto L50
                L6b:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24717z53.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.z53$b$b, reason: collision with other inner class name */
        static final class C1802b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            int c;
            int d;
            final /* synthetic */ InterfaceC9049Yg5 e;
            final /* synthetic */ int f;
            final /* synthetic */ InterfaceC9102Ym4 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1802b(InterfaceC9049Yg5 interfaceC9049Yg5, int i, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = interfaceC9049Yg5;
                this.f = i;
                this.g = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1802b(this.e, this.f, this.g, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0043 -> B:14:0x0046). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r6.d
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    int r1 = r6.c
                    int r3 = r6.b
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L46
                L13:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1b:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Yg5 r7 = r6.e
                    float r1 = (float) r2
                    float r1 = ir.nasim.C17784nZ1.q(r1)
                    float r7 = r7.w1(r1)
                    int r7 = (int) r7
                    int r7 = 24 - r7
                    int r1 = r6.f
                    r3 = -2
                    int r7 = ir.nasim.AbstractC16234kv5.c(r1, r7, r3)
                    if (r7 > r1) goto L51
                    r3 = r1
                    r1 = r7
                L37:
                    r6.b = r3
                    r6.c = r1
                    r6.d = r2
                    r4 = 1
                    java.lang.Object r7 = ir.nasim.HG1.b(r4, r6)
                    if (r7 != r0) goto L46
                    return r0
                L46:
                    ir.nasim.Ym4 r7 = r6.g
                    float r4 = (float) r3
                    ir.nasim.AbstractC24717z53.w(r7, r4)
                    if (r3 == r1) goto L51
                    int r3 = r3 + (-2)
                    goto L37
                L51:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24717z53.b.C1802b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1802b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.z53$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            int c;
            int d;
            final /* synthetic */ int e;
            final /* synthetic */ InterfaceC9049Yg5 f;
            final /* synthetic */ InterfaceC9102Ym4 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(int i, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = i;
                this.f = interfaceC9049Yg5;
                this.g = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.e, this.f, this.g, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003d -> B:14:0x0040). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r6.d
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    int r1 = r6.c
                    int r3 = r6.b
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L40
                L13:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1b:
                    ir.nasim.AbstractC10685c16.b(r7)
                    int r7 = r6.e
                    ir.nasim.Yg5 r1 = r6.f
                    float r3 = (float) r2
                    float r3 = ir.nasim.C17784nZ1.q(r3)
                    float r1 = r1.w1(r3)
                    int r1 = (int) r1
                    int r1 = 24 - r1
                    if (r1 > r7) goto L4b
                    r3 = r7
                L31:
                    r6.b = r3
                    r6.c = r1
                    r6.d = r2
                    r4 = 1
                    java.lang.Object r7 = ir.nasim.HG1.b(r4, r6)
                    if (r7 != r0) goto L40
                    return r0
                L40:
                    ir.nasim.Ym4 r7 = r6.g
                    float r4 = (float) r3
                    ir.nasim.AbstractC24717z53.y(r7, r4)
                    if (r3 == r1) goto L4b
                    int r3 = r3 + (-1)
                    goto L31
                L4b:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24717z53.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, InterfaceC9102Ym4 interfaceC9102Ym44) {
            this.a = ua2;
            this.b = interfaceC20315ro1;
            this.c = interfaceC9102Ym4;
            this.d = interfaceC9102Ym42;
            this.e = interfaceC9102Ym43;
            this.f = interfaceC9102Ym44;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 e(UA2 ua2, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, ZG4 zg4) {
            AbstractC13042fc3.i(ua2, "$onTouch");
            AbstractC13042fc3.i(interfaceC9049Yg5, "$this_pointerInput");
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$canvasCenter$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$bigRingSize$delegate");
            ua2.invoke(Boolean.TRUE);
            float f = 60;
            if (Float.intBitsToFloat((int) (AbstractC24717z53.r(interfaceC9102Ym4) >> 32)) + interfaceC9049Yg5.w1(C17784nZ1.q(f)) > Float.intBitsToFloat((int) (zg4.t() >> 32)) && Float.intBitsToFloat((int) (zg4.t() >> 32)) > Float.intBitsToFloat((int) (AbstractC24717z53.r(interfaceC9102Ym4) >> 32)) - interfaceC9049Yg5.w1(C17784nZ1.q(f)) && Float.intBitsToFloat((int) (AbstractC24717z53.r(interfaceC9102Ym4) & 4294967295L)) + interfaceC9049Yg5.w1(C17784nZ1.q(f)) > Float.intBitsToFloat((int) (zg4.t() & 4294967295L)) && Float.intBitsToFloat((int) (zg4.t() & 4294967295L)) > Float.intBitsToFloat((int) (AbstractC24717z53.r(interfaceC9102Ym4) & 4294967295L)) - interfaceC9049Yg5.w1(C17784nZ1.q(f))) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a((int) AbstractC24717z53.f(interfaceC9102Ym42), interfaceC9049Yg5, interfaceC9102Ym42, null), 3, null);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC9102Ym4 interfaceC9102Ym42) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(ua2, "$onTouch");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$bigRingSize$delegate");
            AbstractC13042fc3.i(interfaceC9049Yg5, "$this_pointerInput");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$lastSize$delegate");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1802b(interfaceC9049Yg5, (int) AbstractC24717z53.f(interfaceC9102Ym4), interfaceC9102Ym4, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c((int) AbstractC24717z53.p(interfaceC9102Ym42), interfaceC9049Yg5, interfaceC9102Ym42, null), 3, null);
            ua2.invoke(Boolean.FALSE);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(UA2 ua2, InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43, C6616Og5 c6616Og5, ZG4 zg4) {
            AbstractC13042fc3.i(ua2, "$onTouch");
            AbstractC13042fc3.i(interfaceC9049Yg5, "$this_pointerInput");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$canvasCenter$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$lastSize$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym43, "$isCallBackCalled$delegate");
            AbstractC13042fc3.i(c6616Og5, "change");
            ua2.invoke(Boolean.TRUE);
            Float fI0 = AbstractC15401jX0.I0(AbstractC10360bX0.p(Float.valueOf(Math.abs(Float.intBitsToFloat((int) (c6616Og5.h() >> 32)) - Float.intBitsToFloat((int) (AbstractC24717z53.r(interfaceC9102Ym4) >> 32)))), Float.valueOf(Math.abs(Float.intBitsToFloat((int) (c6616Og5.h() & 4294967295L)) - Float.intBitsToFloat((int) (4294967295L & AbstractC24717z53.r(interfaceC9102Ym4)))))));
            AbstractC24717z53.q(interfaceC9102Ym42, fI0 != null ? fI0.floatValue() : 0.0f);
            if (C17784nZ1.p(interfaceC9049Yg5.o1(AbstractC24717z53.p(interfaceC9102Ym42)), C17784nZ1.q(200)) >= 0 && !AbstractC24717z53.g(interfaceC9102Ym43)) {
                AbstractC24717z53.h(interfaceC9102Ym43, true);
            }
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(final InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final UA2 ua2 = this.a;
            final InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.d;
            UA2 ua22 = new UA2() { // from class: ir.nasim.A53
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC24717z53.b.e(ua2, interfaceC9049Yg5, interfaceC20315ro1, interfaceC9102Ym4, interfaceC9102Ym42, (ZG4) obj);
                }
            };
            final InterfaceC20315ro1 interfaceC20315ro12 = this.b;
            final UA2 ua23 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym43 = this.d;
            final InterfaceC9102Ym4 interfaceC9102Ym44 = this.e;
            SA2 sa2 = new SA2() { // from class: ir.nasim.B53
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC24717z53.b.f(interfaceC20315ro12, ua23, interfaceC9102Ym43, interfaceC9049Yg5, interfaceC9102Ym44);
                }
            };
            SA2 sa22 = new SA2() { // from class: ir.nasim.C53
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC24717z53.b.g();
                }
            };
            final UA2 ua24 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym45 = this.c;
            final InterfaceC9102Ym4 interfaceC9102Ym46 = this.e;
            final InterfaceC9102Ym4 interfaceC9102Ym47 = this.f;
            Object objD = EZ1.d(interfaceC9049Yg5, ua22, sa2, sa22, new InterfaceC14603iB2() { // from class: ir.nasim.D53
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24717z53.b.h(ua24, interfaceC9049Yg5, interfaceC9102Ym45, interfaceC9102Ym46, interfaceC9102Ym47, (C6616Og5) obj, (ZG4) obj2);
                }
            }, interfaceC20295rm1);
            return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
        }
    }

    public static final void e(final long j, final int i, final String str, final SA2 sa2, final InterfaceC9664aL6 interfaceC9664aL6, final UA2 ua2, float f, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        float f2;
        int i5;
        androidx.compose.foundation.layout.h hVar;
        InterfaceC9664aL6 interfaceC9664aL62;
        InterfaceC9664aL6 interfaceC9664aL63;
        InterfaceC9664aL6 interfaceC9664aL64;
        e.a aVar;
        InterfaceC12529em.a aVar2;
        float f3;
        C19938rB7 c19938rB7;
        InterfaceC22053ub1 interfaceC22053ub12;
        final float f4;
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        AbstractC13042fc3.i(sa2, "onDragAccepted");
        AbstractC13042fc3.i(interfaceC9664aL6, "onSwipeAnimationSize");
        AbstractC13042fc3.i(ua2, "onTouch");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1997829553);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.f(j) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC9664aL6) ? 16384 : 8192;
        }
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i2 & 196608) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 131072 : 65536;
        }
        int i6 = i3 & 64;
        if (i6 != 0) {
            i4 |= 1572864;
            f2 = f;
        } else {
            f2 = f;
            if ((i2 & 1572864) == 0) {
                i4 |= interfaceC22053ub1J.c(f2) ? 1048576 : 524288;
            }
        }
        if ((i4 & 599187) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            f4 = f2;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final float f5 = i6 != 0 ? 0.0f : f2;
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
            if (objB == aVar3.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
            interfaceC22053ub1J.W(243171825);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar3.a()) {
                InterfaceC9102Ym4 interfaceC9102Ym4D = AbstractC13472gH6.d(Float.valueOf(0.0f), null, 2, null);
                interfaceC22053ub1J.s(interfaceC9102Ym4D);
                objB2 = interfaceC9102Ym4D;
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(243174059);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar3.a()) {
                InterfaceC9102Ym4 interfaceC9102Ym4D2 = AbstractC13472gH6.d(Float.valueOf(0.0f), null, 2, null);
                interfaceC22053ub1J.s(interfaceC9102Ym4D2);
                objB3 = interfaceC9102Ym4D2;
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(243176247);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar3.a()) {
                objB4 = AbstractC13472gH6.d(ZG4.d(ZG4.e((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))), null, 2, null);
                interfaceC22053ub1J.s(objB4);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) objB4;
            interfaceC22053ub1J.Q();
            final InterfaceC9664aL6 interfaceC9664aL6D = AbstractC4572Fs.d(p(interfaceC9102Ym42), null, 0.0f, null, null, interfaceC22053ub1J, 0, 30);
            InterfaceC9664aL6 interfaceC9664aL6D2 = AbstractC4572Fs.d(f(interfaceC9102Ym4), null, 0.0f, null, null, interfaceC22053ub1J, 0, 30);
            interfaceC22053ub1J.W(243183387);
            Object objB5 = interfaceC22053ub1J.B();
            if (objB5 == aVar3.a()) {
                objB5 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB5);
            }
            InterfaceC9102Ym4 interfaceC9102Ym44 = (InterfaceC9102Ym4) objB5;
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6D3 = AbstractC4572Fs.d(((Number) interfaceC9664aL6.getValue()).floatValue(), AbstractC5999Lt.k(((Number) interfaceC9664aL6.getValue()).floatValue() < 20.0f ? 0 : 200, 50, R22.m()), 0.0f, null, null, interfaceC22053ub1J, 0, 28);
            InterfaceC9664aL6 interfaceC9664aL6A = BD6.a(C24381yX0.o(DX0.d(4292467161L), 1.0f - (Math.round((((Number) interfaceC9664aL6.getValue()).floatValue() * r8) / 150) / 100), 0.0f, 0.0f, 0.0f, 14, null), null, null, null, interfaceC22053ub1J, 0, 14);
            Boolean boolValueOf = Boolean.valueOf(g(interfaceC9102Ym44));
            interfaceC22053ub1J.W(243205151);
            int i7 = 458752 & i4;
            int i8 = i4 & 7168;
            boolean z = (i7 == 131072) | (i8 == 2048);
            Object objB6 = interfaceC22053ub1J.B();
            if (z || objB6 == aVar3.a()) {
                objB6 = new a(ua2, sa2, interfaceC9102Ym44, null);
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB6, interfaceC22053ub1J, 0);
            e.a aVar4 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(aVar4, null, false, 3, null);
            interfaceC22053ub1J.W(243213457);
            boolean z2 = ((3670016 & i4) == 1048576) | (i8 == 2048);
            Object objB7 = interfaceC22053ub1J.B();
            if (z2 || objB7 == aVar3.a()) {
                objB7 = new UA2() { // from class: ir.nasim.v53
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC24717z53.k(f5, sa2, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB7);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarC = AbstractC6919Pn6.c(eVarE, true, (UA2) objB7);
            InterfaceC12529em.a aVar5 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar5.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            InterfaceC16030kb1.a aVar6 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar6.a();
            float f6 = f5;
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar6.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar6.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar6.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE2, aVar6.f());
            androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
            AbstractC11456d23.b(FV4.c(i, interfaceC22053ub1J, (i4 >> 3) & 14), null, Ac8.a(androidx.compose.foundation.layout.q.i(hVar2.h(FV0.a(androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.t(aVar4, C17784nZ1.q(48)), j, N46.g()), N46.g()), aVar5.e()), C17784nZ1.q(10)), 2.0f), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            androidx.compose.ui.e eVarH = hVar2.h(androidx.compose.foundation.layout.t.t(aVar4, C17784nZ1.q(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER)), aVar5.e());
            C19938rB7 c19938rB72 = C19938rB7.a;
            interfaceC22053ub1J.W(1670680747);
            boolean zD = interfaceC22053ub1J.D(interfaceC20315ro1) | (i7 == 131072);
            Object objB8 = interfaceC22053ub1J.B();
            if (zD || objB8 == aVar3.a()) {
                i5 = i4;
                hVar = hVar2;
                interfaceC9664aL62 = interfaceC9664aL6D2;
                interfaceC9664aL63 = interfaceC9664aL6A;
                interfaceC9664aL64 = interfaceC9664aL6D3;
                aVar = aVar4;
                aVar2 = aVar5;
                f3 = f6;
                c19938rB7 = c19938rB72;
                b bVar = new b(ua2, interfaceC20315ro1, interfaceC9102Ym43, interfaceC9102Ym4, interfaceC9102Ym42, interfaceC9102Ym44);
                interfaceC22053ub1J.s(bVar);
                objB8 = bVar;
            } else {
                hVar = hVar2;
                i5 = i4;
                aVar = aVar4;
                aVar2 = aVar5;
                interfaceC9664aL62 = interfaceC9664aL6D2;
                interfaceC9664aL63 = interfaceC9664aL6A;
                f3 = f6;
                interfaceC9664aL64 = interfaceC9664aL6D3;
                c19938rB7 = c19938rB72;
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarC2 = AbstractC21071t37.c(eVarH, c19938rB7, (PointerInputEventHandler) objB8);
            interfaceC22053ub1J.W(1670775549);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL62) | interfaceC22053ub1J.V(interfaceC9664aL63) | interfaceC22053ub1J.V(interfaceC9664aL64) | interfaceC22053ub1J.V(interfaceC9664aL6D);
            Object objB9 = interfaceC22053ub1J.B();
            if (zV || objB9 == aVar3.a()) {
                final InterfaceC9664aL6 interfaceC9664aL65 = interfaceC9664aL62;
                final InterfaceC9664aL6 interfaceC9664aL66 = interfaceC9664aL63;
                final InterfaceC9664aL6 interfaceC9664aL67 = interfaceC9664aL64;
                objB9 = new UA2() { // from class: ir.nasim.w53
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC24717z53.n(interfaceC9102Ym43, interfaceC9664aL65, interfaceC9664aL6D, interfaceC9664aL66, interfaceC9664aL67, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1J.s(objB9);
            }
            interfaceC22053ub1J.Q();
            AbstractC22443vF0.a(eVarC2, (UA2) objB9, interfaceC22053ub1J, 0);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9105Ym7.b(str, Ac8.a(androidx.compose.foundation.layout.q.m(hVar.h(aVar, aVar2.e()), 0.0f, C17784nZ1.q(83), 0.0f, 0.0f, 13, null), 3.0f), C24381yX0.b.j(), AbstractC13784go7.g(12), null, null, M10.q(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub12, ((i5 >> 6) & 14) | 3456, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122800);
            interfaceC22053ub12.u();
            f4 = f3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.x53
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24717z53.o(j, i, str, sa2, interfaceC9664aL6, ua2, f4, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    private static final float i(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    private static final long j(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((C24381yX0) interfaceC9664aL6.getValue()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(float f, final SA2 sa2, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(sa2, "$onDragAccepted");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, f);
        AbstractC9939ao6.p0(interfaceC11943do6, B26.b.a());
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.y53
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC24717z53.l(sa2));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDragAccepted");
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
        interfaceC9102Ym4.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$canvasCenter$delegate");
        AbstractC13042fc3.i(interfaceC9664aL6, "$animateBigRing");
        AbstractC13042fc3.i(interfaceC9664aL62, "$animateSize");
        AbstractC13042fc3.i(interfaceC9664aL63, "$onSwipeAnimationColorState$delegate");
        AbstractC13042fc3.i(interfaceC9664aL64, "$onSwipeAnimationState$delegate");
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        s(interfaceC9102Ym4, interfaceC17460n02.E1());
        Canvas canvasD = AbstractC7624Sn.d(interfaceC17460n02.z1().e());
        int iSaveLayer = canvasD.saveLayer(null, null);
        InterfaceC17460n02.L(interfaceC17460n02, DX0.d(3654932953L), ((Number) interfaceC9664aL6.getValue()).floatValue(), 0L, 0.0f, null, null, 0, 124, null);
        InterfaceC17460n02.L(interfaceC17460n02, j(interfaceC9664aL63), i(interfaceC9664aL64), 0L, 0.0f, null, null, 0, 124, null);
        InterfaceC17460n02.L(interfaceC17460n02, C24381yX0.b.h(), ((Number) interfaceC9664aL62.getValue()).floatValue(), 0L, 0.0f, null, null, AbstractC7094Qg0.a.a(), 60, null);
        canvasD.restoreToCount(iSaveLayer);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(long j, int i, String str, SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2, float f, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(sa2, "$onDragAccepted");
        AbstractC13042fc3.i(interfaceC9664aL6, "$onSwipeAnimationSize");
        AbstractC13042fc3.i(ua2, "$onTouch");
        e(j, i, str, sa2, interfaceC9664aL6, ua2, f, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
        interfaceC9102Ym4.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long r(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((ZG4) interfaceC9102Ym4.getValue()).t();
    }

    private static final void s(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        interfaceC9102Ym4.setValue(ZG4.d(j));
    }
}
