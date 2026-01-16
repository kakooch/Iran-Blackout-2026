package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Kw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5797Kw3 {
    private static final float a = C17784nZ1.q(2500);
    private static final float b = C17784nZ1.q(1500);
    private static final float c = C17784nZ1.q(50);

    /* renamed from: ir.nasim.Kw3$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        int f;
        int g;
        int h;
        float i;
        float j;
        float k;
        /* synthetic */ Object l;
        int m;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.m |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC5797Kw3.b(null, 0, 0, 0, null, this);
        }
    }

    /* renamed from: ir.nasim.Kw3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC5563Jw3 e;
        final /* synthetic */ int f;
        final /* synthetic */ float g;
        final /* synthetic */ C10873cL5 h;
        final /* synthetic */ C9663aL5 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ float k;
        final /* synthetic */ C11637dL5 l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;
        final /* synthetic */ C12889fL5 o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC5563Jw3 interfaceC5563Jw3, int i, float f, C10873cL5 c10873cL5, C9663aL5 c9663aL5, boolean z, float f2, C11637dL5 c11637dL5, int i2, int i3, C12889fL5 c12889fL5) {
            super(1);
            this.e = interfaceC5563Jw3;
            this.f = i;
            this.g = f;
            this.h = c10873cL5;
            this.i = c9663aL5;
            this.j = z;
            this.k = f2;
            this.l = c11637dL5;
            this.m = i2;
            this.n = i3;
            this.o = c12889fL5;
        }

        public final void a(C5064Ht c5064Ht) {
            if (!AbstractC5797Kw3.d(this.e, this.f)) {
                float fH = (this.g > 0.0f ? AbstractC23053wG5.h(((Number) c5064Ht.e()).floatValue(), this.g) : AbstractC23053wG5.d(((Number) c5064Ht.e()).floatValue(), this.g)) - this.h.a;
                float fE = this.e.e(fH);
                if (!AbstractC5797Kw3.d(this.e, this.f) && !AbstractC5797Kw3.c(this.j, this.e, this.f, this.n)) {
                    if (fH != fE) {
                        c5064Ht.a();
                        this.i.a = false;
                        return;
                    }
                    this.h.a += fH;
                    if (this.j) {
                        if (((Number) c5064Ht.e()).floatValue() > this.k) {
                            c5064Ht.a();
                        }
                    } else if (((Number) c5064Ht.e()).floatValue() < (-this.k)) {
                        c5064Ht.a();
                    }
                    if (this.j) {
                        if (this.l.a >= 2) {
                            int iB = this.f - this.e.b();
                            int i = this.m;
                            if (iB > i) {
                                this.e.c(this.f - i, 0);
                            }
                        }
                    } else if (this.l.a >= 2) {
                        int iH = this.e.h();
                        int i2 = this.f;
                        int i3 = iH - i2;
                        int i4 = this.m;
                        if (i3 > i4) {
                            this.e.c(i2 + i4, 0);
                        }
                    }
                }
            }
            if (!AbstractC5797Kw3.c(this.j, this.e, this.f, this.n)) {
                if (AbstractC5797Kw3.d(this.e, this.f)) {
                    throw new C16663lf3(InterfaceC5563Jw3.d(this.e, this.f, 0, 2, null), (C6233Mt) this.o.a);
                }
            } else {
                this.e.c(this.f, this.n);
                this.i.a = false;
                c5064Ht.a();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Kw3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ C10873cL5 f;
        final /* synthetic */ InterfaceC5563Jw3 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(float f, C10873cL5 c10873cL5, InterfaceC5563Jw3 interfaceC5563Jw3) {
            super(1);
            this.e = f;
            this.f = c10873cL5;
            this.g = interfaceC5563Jw3;
        }

        public final void a(C5064Ht c5064Ht) {
            float f = this.e;
            float fD = 0.0f;
            if (f > 0.0f) {
                fD = AbstractC23053wG5.h(((Number) c5064Ht.e()).floatValue(), this.e);
            } else if (f < 0.0f) {
                fD = AbstractC23053wG5.d(((Number) c5064Ht.e()).floatValue(), this.e);
            }
            float f2 = fD - this.f.a;
            if (f2 != this.g.e(f2) || fD != ((Number) c5064Ht.e()).floatValue()) {
                c5064Ht.a();
            }
            this.f.a += f2;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef A[Catch: lf3 -> 0x01c9, TryCatch #6 {lf3 -> 0x01c9, blocks: (B:34:0x00eb, B:36:0x00ef, B:38:0x00f5, B:51:0x0128, B:55:0x0166, B:59:0x016f), top: B:104:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x024c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x01b6 -> B:92:0x01b8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.InterfaceC5563Jw3 r42, int r43, int r44, int r45, ir.nasim.WH1 r46, ir.nasim.InterfaceC20295rm1 r47) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5797Kw3.b(ir.nasim.Jw3, int, int, int, ir.nasim.WH1, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(boolean z, InterfaceC5563Jw3 interfaceC5563Jw3, int i, int i2) {
        if (z) {
            if (interfaceC5563Jw3.h() <= i && (interfaceC5563Jw3.h() != i || interfaceC5563Jw3.g() <= i2)) {
                return false;
            }
        } else if (interfaceC5563Jw3.h() >= i && (interfaceC5563Jw3.h() != i || interfaceC5563Jw3.g() >= i2)) {
            return false;
        }
        return true;
    }

    public static final boolean d(InterfaceC5563Jw3 interfaceC5563Jw3, int i) {
        return i <= interfaceC5563Jw3.b() && interfaceC5563Jw3.h() <= i;
    }
}
