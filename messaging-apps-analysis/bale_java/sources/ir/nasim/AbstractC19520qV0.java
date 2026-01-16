package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* renamed from: ir.nasim.qV0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19520qV0 {

    /* renamed from: ir.nasim.qV0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
            super(1);
            this.e = interfaceC9102Ym4;
            this.f = ua2;
        }

        public final void a(C13774gn7 c13774gn7) {
            this.e.setValue(c13774gn7);
            this.f.invoke(c13774gn7);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13774gn7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qV0$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C13245fu e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ C9348Zn7 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;
        final /* synthetic */ UA2 k;
        final /* synthetic */ UA2 l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C13245fu c13245fu, androidx.compose.ui.e eVar, C9348Zn7 c9348Zn7, boolean z, int i, int i2, UA2 ua2, UA2 ua22, int i3, int i4) {
            super(2);
            this.e = c13245fu;
            this.f = eVar;
            this.g = c9348Zn7;
            this.h = z;
            this.i = i;
            this.j = i2;
            this.k = ua2;
            this.l = ua22;
            this.m = i3;
            this.n = i4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC19520qV0.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC22053ub1, QJ5.a(this.m | 1), this.n);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qV0$d */
    static final class d implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ UA2 b;

        /* renamed from: ir.nasim.qV0$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
                super(1);
                this.e = interfaceC9102Ym4;
                this.f = ua2;
            }

            public final void a(long j) {
                C13774gn7 c13774gn7 = (C13774gn7) this.e.getValue();
                if (c13774gn7 != null) {
                    this.f.invoke(Integer.valueOf(c13774gn7.x(j)));
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((ZG4) obj).t());
                return C19938rB7.a;
            }
        }

        d(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2) {
            this.a = interfaceC9102Ym4;
            this.b = ua2;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new a(this.a, this.b), interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.C13245fu r26, androidx.compose.ui.e r27, ir.nasim.C9348Zn7 r28, boolean r29, int r30, int r31, ir.nasim.UA2 r32, ir.nasim.UA2 r33, ir.nasim.InterfaceC22053ub1 r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19520qV0.a(ir.nasim.fu, androidx.compose.ui.e, ir.nasim.Zn7, boolean, int, int, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* renamed from: ir.nasim.qV0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13774gn7) obj);
            return C19938rB7.a;
        }

        public final void a(C13774gn7 c13774gn7) {
        }
    }
}
