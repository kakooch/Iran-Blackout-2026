package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10316bS1;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.bS1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC10316bS1 {

    /* renamed from: ir.nasim.bS1$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ String b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        /* renamed from: ir.nasim.bS1$a$a, reason: collision with other inner class name */
        static final class C0906a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C0906a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.bS1$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            b(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC14603iB2 interfaceC14603iB2, String str, UA2 ua2, String str2, String str3, String str4, String str5) {
            this.a = interfaceC14603iB2;
            this.b = str;
            this.c = ua2;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC14603iB2 interfaceC14603iB2, Dialog dialog, boolean z) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$positiveButtonClicked");
            AbstractC13042fc3.i(dialog, "$dialog");
            interfaceC14603iB2.invoke(dialog, Boolean.valueOf(z));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, Dialog dialog) {
            AbstractC13042fc3.i(ua2, "$negativeButtonClicked");
            AbstractC13042fc3.i(dialog, "$dialog");
            ua2.invoke(dialog);
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(570375615, true, new C0906a(this.f), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1434145729, true, new b(this.g), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(-1471372918);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
            final InterfaceC14603iB2 interfaceC14603iB2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ZR1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC10316bS1.a.d(interfaceC14603iB2, dialog, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            String str = this.b;
            InterfaceC19114po0.c.b bVar = InterfaceC19114po0.c.b.a;
            interfaceC22053ub1.W(-1471366398);
            boolean zV2 = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.D(dialog);
            final UA2 ua22 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.aS1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10316bS1.a.f(ua22, dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.I(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, ua2, str, bVar, (SA2) objB2, this.d, null, this.e, false, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.c.b.b << 21), 0, 5120);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bS1$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ String b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        /* renamed from: ir.nasim.bS1$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.bS1$b$b, reason: collision with other inner class name */
        static final class C0907b implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            C0907b(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(UA2 ua2, String str, UA2 ua22, String str2, String str3, String str4) {
            this.a = ua2;
            this.b = str;
            this.c = ua22;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, Dialog dialog) {
            AbstractC13042fc3.i(ua2, "$positiveButtonClicked");
            AbstractC13042fc3.i(dialog, "$it");
            ua2.invoke(dialog);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, Dialog dialog) {
            AbstractC13042fc3.i(ua2, "$negativeButtonClicked");
            AbstractC13042fc3.i(dialog, "$it");
            ua2.invoke(dialog);
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-2090838428, true, new a(this.e), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1720734242, true, new C0907b(this.f), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(916107778);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
            final UA2 ua2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.cS1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10316bS1.b.d(ua2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String str = this.b;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(916113378);
            boolean zV2 = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.D(dialog);
            final UA2 ua22 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.dS1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10316bS1.b.f(ua22, dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa2, str, c1454b, (SA2) objB2, this.d, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(Context context, InterfaceC18633oz3 interfaceC18633oz3, String str, String str2, String str3, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, String str4, String str5) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "viewLifecycleOwner");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "checkBox");
        AbstractC13042fc3.i(interfaceC14603iB2, "positiveButtonClicked");
        AbstractC13042fc3.i(ua2, "negativeButtonClicked");
        AbstractC13042fc3.i(str4, "positiveButtonText");
        AbstractC13042fc3.i(str5, "negativeButtonText");
        AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(-867596294, true, new a(interfaceC14603iB2, str4, ua2, str5, str3, str, str2)), 4, null).show();
    }

    public static final Dialog b(Context context, InterfaceC18633oz3 interfaceC18633oz3, String str, String str2, UA2 ua2, UA2 ua22, String str3, String str4) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC18633oz3, "viewLifecycleOwner");
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(ua2, "positiveButtonClicked");
        AbstractC13042fc3.i(ua22, "negativeButtonClicked");
        AbstractC13042fc3.i(str3, "positiveButtonText");
        AbstractC13042fc3.i(str4, "negativeButtonText");
        return AbstractC21375tZ.c(context, interfaceC18633oz3, null, AbstractC19242q11.c(1778413760, true, new b(ua2, str3, ua22, str4, str, str2)), 4, null);
    }
}
