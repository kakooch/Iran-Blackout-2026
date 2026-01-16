package ir.nasim;

import android.webkit.WebView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.g20, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13323g20 {
    private final InterfaceC20315ro1 a;
    private final InterfaceC8327Vm4 b;
    private final InterfaceC9102Ym4 c;
    private final InterfaceC9102Ym4 d;

    /* renamed from: ir.nasim.g20$a */
    private interface a {

        /* renamed from: ir.nasim.g20$a$a, reason: collision with other inner class name */
        public static final class C1246a implements a {
            public static final C1246a a = new C1246a();

            private C1246a() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C1246a);
            }

            public int hashCode() {
                return -496252785;
            }

            public String toString() {
                return "Reload";
            }
        }
    }

    /* renamed from: ir.nasim.g20$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C13323g20.this.c(null, this);
        }
    }

    /* renamed from: ir.nasim.g20$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ WebView d;

        /* renamed from: ir.nasim.g20$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ WebView a;

            a(WebView webView) {
                this.a = webView;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                if (!(aVar instanceof a.C1246a)) {
                    throw new IllegalStateException();
                }
                this.a.reload();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(WebView webView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = webView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13323g20.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C13323g20.this.b;
                a aVar = new a(this.d);
                this.b = 1;
                if (interfaceC8327Vm4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.g20$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13323g20.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C13323g20.this.b;
                a.C1246a c1246a = a.C1246a.a;
                this.b = 1;
                if (interfaceC8327Vm4.a(c1246a, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C13323g20(InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = interfaceC20315ro1;
        this.b = AbstractC11420cy6.b(0, 0, null, 7, null);
        Boolean bool = Boolean.FALSE;
        this.c = AbstractC13472gH6.d(bool, null, 2, null);
        this.d = AbstractC13472gH6.d(bool, null, 2, null);
    }

    public final boolean b() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.webkit.WebView r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C13323g20.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.g20$b r0 = (ir.nasim.C13323g20.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.g20$b r0 = new ir.nasim.g20$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            ir.nasim.AbstractC10685c16.b(r7)
            goto L47
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.WM3 r7 = ir.nasim.C12366eV1.c()
            ir.nasim.g20$c r2 = new ir.nasim.g20$c
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13323g20.c(android.webkit.WebView, ir.nasim.rm1):java.lang.Object");
    }

    public final void d() {
        AbstractC10533bm0.d(this.a, null, null, new d(null), 3, null);
    }

    public final void e(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }

    public final void f(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }
}
