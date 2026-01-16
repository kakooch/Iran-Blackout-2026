package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C15060iw3;
import ir.nasim.InterfaceC15468je0;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.jw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15651jw3 extends e.c implements InterfaceC22696vg4, InterfaceC15468je0, InterfaceC21655tu3 {
    public static final b s = new b(null);
    public static final int t = 8;
    private static final a u = new a();
    private InterfaceC16242kw3 o;
    private C15060iw3 p;
    private boolean q;
    private EnumC24286yM4 r;

    /* renamed from: ir.nasim.jw3$a */
    public static final class a implements InterfaceC15468je0.a {
        private final boolean a;

        a() {
        }

        @Override // ir.nasim.InterfaceC15468je0.a
        public boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.jw3$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jw3$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            try {
                iArr[EnumC12613eu3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12613eu3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.jw3$d */
    public static final class d implements InterfaceC15468je0.a {
        final /* synthetic */ C12889fL5 b;
        final /* synthetic */ int c;

        d(C12889fL5 c12889fL5, int i) {
            this.b = c12889fL5;
            this.c = i;
        }

        @Override // ir.nasim.InterfaceC15468je0.a
        public boolean a() {
            return C15651jw3.this.x2((C15060iw3.a) this.b.a, this.c);
        }
    }

    /* renamed from: ir.nasim.jw3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.h(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C15651jw3(InterfaceC16242kw3 interfaceC16242kw3, C15060iw3 c15060iw3, boolean z, EnumC24286yM4 enumC24286yM4) {
        this.o = interfaceC16242kw3;
        this.p = c15060iw3;
        this.q = z;
        this.r = enumC24286yM4;
    }

    private final C15060iw3.a w2(C15060iw3.a aVar, int i) {
        int iB = aVar.b();
        int iA = aVar.a();
        if (y2(i)) {
            iA++;
        } else {
            iB--;
        }
        return this.p.a(iB, iA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x2(C15060iw3.a aVar, int i) {
        if (z2(i)) {
            return false;
        }
        if (y2(i)) {
            if (aVar.a() >= this.o.a() - 1) {
                return false;
            }
        } else if (aVar.b() <= 0) {
            return false;
        }
        return true;
    }

    private final boolean y2(int i) {
        InterfaceC15468je0.b.a aVar = InterfaceC15468je0.b.a;
        if (InterfaceC15468je0.b.h(i, aVar.c())) {
            return false;
        }
        if (!InterfaceC15468je0.b.h(i, aVar.b())) {
            if (InterfaceC15468je0.b.h(i, aVar.a())) {
                return this.q;
            }
            if (InterfaceC15468je0.b.h(i, aVar.d())) {
                if (this.q) {
                    return false;
                }
            } else if (InterfaceC15468je0.b.h(i, aVar.e())) {
                int i2 = c.a[KG1.n(this).ordinal()];
                if (i2 == 1) {
                    return this.q;
                }
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.q) {
                    return false;
                }
            } else {
                if (!InterfaceC15468je0.b.h(i, aVar.f())) {
                    androidx.compose.foundation.lazy.layout.b.c();
                    throw new KotlinNothingValueException();
                }
                int i3 = c.a[KG1.n(this).ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        return this.q;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (this.q) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean z2(int i) {
        InterfaceC15468je0.b.a aVar = InterfaceC15468je0.b.a;
        if (!(InterfaceC15468je0.b.h(i, aVar.a()) ? true : InterfaceC15468je0.b.h(i, aVar.d()))) {
            if (!(InterfaceC15468je0.b.h(i, aVar.e()) ? true : InterfaceC15468je0.b.h(i, aVar.f()))) {
                if (!(InterfaceC15468je0.b.h(i, aVar.c()) ? true : InterfaceC15468je0.b.h(i, aVar.b()))) {
                    androidx.compose.foundation.lazy.layout.b.c();
                    throw new KotlinNothingValueException();
                }
            } else if (this.r == EnumC24286yM4.a) {
                return true;
            }
        } else if (this.r == EnumC24286yM4.b) {
            return true;
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC15468je0
    public Object A0(int i, UA2 ua2) {
        if (this.o.a() <= 0 || !this.o.c() || !b2()) {
            return ua2.invoke(u);
        }
        int iE = y2(i) ? this.o.e() : this.o.d();
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = this.p.a(iE, iE);
        int i2 = AbstractC23053wG5.i(this.o.b() * 2, this.o.a());
        Object objInvoke = null;
        int i3 = 0;
        while (objInvoke == null && x2((C15060iw3.a) c12889fL5.a, i) && i3 < i2) {
            C15060iw3.a aVarW2 = w2((C15060iw3.a) c12889fL5.a, i);
            this.p.e((C15060iw3.a) c12889fL5.a);
            c12889fL5.a = aVarW2;
            i3++;
            AbstractC23431wu3.d(this);
            objInvoke = ua2.invoke(new d(c12889fL5, i));
        }
        this.p.e((C15060iw3.a) c12889fL5.a);
        AbstractC23431wu3.d(this);
        return objInvoke;
    }

    public final void A2(InterfaceC16242kw3 interfaceC16242kw3, C15060iw3 c15060iw3, boolean z, EnumC24286yM4 enumC24286yM4) {
        this.o = interfaceC16242kw3;
        this.p = c15060iw3;
        this.q = z;
        this.r = enumC24286yM4;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new e(abstractC21430te5L0), 4, null);
    }

    @Override // ir.nasim.InterfaceC22696vg4
    public AbstractC22106ug4 o0() {
        return AbstractC23292wg4.b(AbstractC4616Fw7.a(AbstractC16059ke0.a(), this));
    }
}
