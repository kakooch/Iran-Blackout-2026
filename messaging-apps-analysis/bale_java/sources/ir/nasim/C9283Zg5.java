package ir.nasim;

import android.os.SystemClock;
import android.view.MotionEvent;
import java.util.List;

/* renamed from: ir.nasim.Zg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9283Zg5 implements InterfaceC8274Vg5 {
    public UA2 b;
    private TQ5 c;
    private boolean d;
    private final AbstractC8040Ug5 e = new b();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Zg5$a */
    private static final class a {
        public static final a a = new a("Unknown", 0);
        public static final a b = new a("Dispatching", 1);
        public static final a c = new a("NotDispatching", 2);
        private static final /* synthetic */ a[] d;
        private static final /* synthetic */ F92 e;

        static {
            a[] aVarArrA = a();
            d = aVarArrA;
            e = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    /* renamed from: ir.nasim.Zg5$b */
    public static final class b extends AbstractC8040Ug5 {
        private a b = a.a;

        /* renamed from: ir.nasim.Zg5$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C9283Zg5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C9283Zg5 c9283Zg5) {
                super(1);
                this.e = c9283Zg5;
            }

            public final void a(MotionEvent motionEvent) {
                this.e.k().invoke(motionEvent);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((MotionEvent) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Zg5$b$b, reason: collision with other inner class name */
        static final class C0806b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C9283Zg5 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0806b(C9283Zg5 c9283Zg5) {
                super(1);
                this.f = c9283Zg5;
            }

            public final void a(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 0) {
                    this.f.k().invoke(motionEvent);
                } else {
                    b.this.b = ((Boolean) this.f.k().invoke(motionEvent)).booleanValue() ? a.b : a.c;
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((MotionEvent) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Zg5$b$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C9283Zg5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C9283Zg5 c9283Zg5) {
                super(1);
                this.e = c9283Zg5;
            }

            public final void a(MotionEvent motionEvent) {
                this.e.k().invoke(motionEvent);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((MotionEvent) obj);
                return C19938rB7.a;
            }
        }

        b() {
        }

        private final void h(C3534Bg5 c3534Bg5) {
            List listC = c3534Bg5.c();
            List list = listC;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C6616Og5) listC.get(i)).p()) {
                    if (this.b == a.b) {
                        InterfaceC11379cu3 interfaceC11379cu3B = b();
                        if (interfaceC11379cu3B == null) {
                            throw new IllegalStateException("layoutCoordinates not set".toString());
                        }
                        AbstractC10488bh5.b(c3534Bg5, interfaceC11379cu3B.p0(ZG4.b.c()), new a(C9283Zg5.this));
                    }
                    this.b = a.c;
                    return;
                }
            }
            InterfaceC11379cu3 interfaceC11379cu3B2 = b();
            if (interfaceC11379cu3B2 == null) {
                throw new IllegalStateException("layoutCoordinates not set".toString());
            }
            AbstractC10488bh5.c(c3534Bg5, interfaceC11379cu3B2.p0(ZG4.b.c()), new C0806b(C9283Zg5.this));
            if (this.b == a.b) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C6616Og5) listC.get(i2)).a();
                }
                C7286Rb3 c7286Rb3E = c3534Bg5.e();
                if (c7286Rb3E == null) {
                    return;
                }
                c7286Rb3E.e(!C9283Zg5.this.f());
            }
        }

        private final void i() {
            this.b = a.a;
            C9283Zg5.this.l(false);
        }

        @Override // ir.nasim.AbstractC8040Ug5
        public boolean c() {
            return true;
        }

        @Override // ir.nasim.AbstractC8040Ug5
        public void d() {
            if (this.b == a.b) {
                AbstractC10488bh5.a(SystemClock.uptimeMillis(), new c(C9283Zg5.this));
                i();
            }
        }

        @Override // ir.nasim.AbstractC8040Ug5
        public void e(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
            boolean z;
            List listC = c3534Bg5.c();
            if (C9283Zg5.this.f()) {
                z = true;
                break;
            }
            int size = listC.size();
            for (int i = 0; i < size; i++) {
                C6616Og5 c6616Og5 = (C6616Og5) listC.get(i);
                if (AbstractC3768Cg5.b(c6616Og5) || AbstractC3768Cg5.d(c6616Og5)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (this.b != a.c) {
                if (enumC4002Dg5 == EnumC4002Dg5.a && z) {
                    h(c3534Bg5);
                }
                if (enumC4002Dg5 == EnumC4002Dg5.c && !z) {
                    h(c3534Bg5);
                }
            }
            if (enumC4002Dg5 == EnumC4002Dg5.c) {
                int size2 = listC.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (!AbstractC3768Cg5.d((C6616Og5) listC.get(i2))) {
                        return;
                    }
                }
                i();
            }
        }
    }

    public final boolean f() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC8274Vg5
    public AbstractC8040Ug5 j() {
        return this.e;
    }

    public final UA2 k() {
        UA2 ua2 = this.b;
        if (ua2 != null) {
            return ua2;
        }
        AbstractC13042fc3.y("onTouchEvent");
        return null;
    }

    public final void l(boolean z) {
        this.d = z;
    }

    public final void m(UA2 ua2) {
        this.b = ua2;
    }

    public final void n(TQ5 tq5) {
        TQ5 tq52 = this.c;
        if (tq52 != null) {
            tq52.b(null);
        }
        this.c = tq5;
        if (tq5 == null) {
            return;
        }
        tq5.b(this);
    }
}
