package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.InterfaceC18892pR;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.OA2;
import ir.nasim.QR;
import ir.nasim.TR;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.dt1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11988dt1 extends VW7 {
    private static final a i = new a(null);
    public static final int j = 8;
    private final NR b;
    private final C6409Nm c;
    private final SettingsModule d;
    private final Context e;
    private TR f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;

    /* renamed from: ir.nasim.dt1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dt1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11988dt1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NR nr = C11988dt1.this.b;
                String strF = ((b) C11988dt1.this.g.getValue()).f();
                TR tr = C11988dt1.this.f;
                if (tr == null) {
                    AbstractC13042fc3.y("sourceType");
                    tr = null;
                }
                SR srC = tr.c();
                this.b = 1;
                obj = nr.a(strF, srC, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            QR qr = (QR) obj;
            if (qr instanceof QR.c) {
                C11988dt1.this.h1();
                InterfaceC9336Zm4 interfaceC9336Zm4 = C11988dt1.this.g;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, b.b((b) value2, null, null, null, false, false, false, true, false, null, null, 927, null)));
            } else {
                if (!(qr instanceof QR.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC18892pR interfaceC18892pRB = ((QR.b) qr).b();
                if (AbstractC13042fc3.d(interfaceC18892pRB, InterfaceC18892pR.a.a)) {
                    C11988dt1.this.j1(AbstractC24800zD5.features_authenticator_create_password_invalid_format);
                } else if (AbstractC13042fc3.d(interfaceC18892pRB, InterfaceC18892pR.b.a)) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = C11988dt1.this.g;
                    do {
                        value = interfaceC9336Zm42.getValue();
                    } while (!interfaceC9336Zm42.f(value, b.b((b) value, null, null, null, false, false, false, false, true, null, null, 863, null)));
                } else if (AbstractC13042fc3.d(interfaceC18892pRB, InterfaceC18892pR.d.a)) {
                    C11988dt1.this.j1(AbstractC24800zD5.error_time_out);
                } else {
                    C11988dt1.this.j1(AbstractC24800zD5.features_authenticator_validate_password_set_password_error);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.dt1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C11988dt1.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            b bVar = (b) this.c;
            return new C11367ct1(bVar.d(), bVar.c(), bVar.k(), bVar.h(), bVar.e(), !bVar.l(), 6, C11988dt1.this.Y0(bVar), C11988dt1.this.a1(bVar), C11988dt1.this.b1(bVar));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11988dt1(NR nr, C6409Nm c6409Nm, SettingsModule settingsModule, Context context) {
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(context, "context");
        this.b = nr;
        this.c = c6409Nm;
        this.d = settingsModule;
        this.e = context;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new b(null, null, null, false, false, false, false, false, null, null, 1023, null));
        this.g = interfaceC9336Zm4A;
        this.h = AbstractC6459Nq2.o0(AbstractC6459Nq2.X(interfaceC9336Zm4A, new d(null)), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), new C11367ct1(null, null, null, false, false, false, 0, null, null, null, 1023, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19114po0 Y0(b bVar) {
        return bVar.l() ? OA2.a.b : (bVar.f().length() == 6 && bVar.i().length() == 6 && AbstractC13042fc3.d(bVar.f(), bVar.i())) ? InterfaceC19114po0.b.a.a : InterfaceC19114po0.a.C1453a.a;
    }

    private final void Z0() {
        TR tr = this.f;
        if (tr == null) {
            AbstractC13042fc3.y("sourceType");
            tr = null;
        }
        XV4 xv4A = tr instanceof TR.a ? AbstractC4616Fw7.a(this.d.z0(), this.d.L0()) : tr instanceof TR.c ? AbstractC4616Fw7.a(this.d.A0(), this.d.n2()) : AbstractC4616Fw7.a("", "");
        String str = (String) xv4A.a();
        String str2 = (String) xv4A.b();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, b.b((b) value, null, null, null, false, false, false, false, false, str, str2, 255, null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC14472hy4 a1(b bVar) {
        return bVar.f().length() == 6 ? bVar.g() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null) : bVar.f().length() > 0 ? new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.e.getString(AbstractC24800zD5.passwords_length_error), null, 4, null) : bVar.g() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC14472hy4 b1(b bVar) {
        return (AbstractC13042fc3.d(bVar.f(), bVar.i()) && bVar.i().length() == 6) ? bVar.j() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null) : bVar.i().length() > 0 ? bVar.i().length() == 6 ? !AbstractC13042fc3.d(bVar.f(), bVar.i()) ? new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.e.getString(AbstractC24800zD5.passwords_not_match), null, 4, null) : new AbstractC14472hy4.a(null, null, null, 7, null) : new AbstractC14472hy4.a(Integer.valueOf(JB5.danger), this.e.getString(AbstractC24800zD5.passwords_length_error), null, 4, null) : bVar.j() ? new AbstractC14472hy4.c(null, null, null, 7, null) : new AbstractC14472hy4.d(null, null, null, 7, null);
    }

    private final void g1(TR.a aVar) {
        this.c.d("authentication_bot", AbstractC20051rO3.m(AbstractC4616Fw7.a("peer_id", Integer.valueOf(aVar.f())), AbstractC4616Fw7.a("peer_type", aVar.b()), AbstractC4616Fw7.a(DialogEntity.COLUMN_RID, Integer.valueOf(aVar.d())), AbstractC4616Fw7.a("random_id", Integer.valueOf(aVar.a())), AbstractC4616Fw7.a("source_type", Integer.valueOf(aVar.e().j()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        TR tr = this.f;
        TR tr2 = null;
        if (tr == null) {
            AbstractC13042fc3.y("sourceType");
            tr = null;
        }
        TR.a aVar = tr instanceof TR.a ? (TR.a) tr : null;
        if (aVar != null) {
            g1(aVar);
        }
        HashMap map = new HashMap();
        map.put("action_type", Integer.valueOf(EnumC18301oR.b.j()));
        TR tr3 = this.f;
        if (tr3 == null) {
            AbstractC13042fc3.y("sourceType");
            tr3 = null;
        }
        map.put("source_type", tr3.b());
        TR tr4 = this.f;
        if (tr4 == null) {
            AbstractC13042fc3.y("sourceType");
        } else {
            tr2 = tr4;
        }
        map.put("random_id", Integer.valueOf(tr2.a()));
        this.c.d("authenticator", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(int i2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, null, Integer.valueOf(i2), false, false, false, false, false, null, null, 987, null)));
    }

    public final InterfaceC10258bL6 c1() {
        return this.h;
    }

    public final void d1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "pass");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, str, null, null, true, false, false, false, false, null, null, 998, null)));
    }

    public final void e1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "secondPass");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, str, null, false, true, false, false, false, null, null, 997, null)));
    }

    public final void f1(int i2) {
        Object value;
        b bVarB;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            bVarB = (b) value;
            Integer numK = bVarB.k();
            if (numK != null && numK.intValue() == i2) {
                bVarB = b.b(bVarB, null, null, null, false, false, false, false, false, null, null, 1019, null);
            }
        } while (!interfaceC9336Zm4.f(value, bVarB));
    }

    public final void i1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, b.b((b) value, null, null, null, false, false, true, false, false, null, null, 991, null)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void k1(TR tr) {
        AbstractC13042fc3.i(tr, "eventSourceType");
        this.f = tr;
        Z0();
    }

    /* renamed from: ir.nasim.dt1$b */
    private static final class b {
        private final String a;
        private final String b;
        private final Integer c;
        private final boolean d;
        private final boolean e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final String i;
        private final String j;

        public b(String str, String str2, Integer num, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3, String str4) {
            AbstractC13042fc3.i(str, "pass");
            AbstractC13042fc3.i(str2, "secondPass");
            AbstractC13042fc3.i(str3, "descriptionText");
            AbstractC13042fc3.i(str4, "confirmationMessage");
            this.a = str;
            this.b = str2;
            this.c = num;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = z4;
            this.h = z5;
            this.i = str3;
            this.j = str4;
        }

        public static /* synthetic */ b b(b bVar, String str, String str2, Integer num, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3, String str4, int i, Object obj) {
            return bVar.a((i & 1) != 0 ? bVar.a : str, (i & 2) != 0 ? bVar.b : str2, (i & 4) != 0 ? bVar.c : num, (i & 8) != 0 ? bVar.d : z, (i & 16) != 0 ? bVar.e : z2, (i & 32) != 0 ? bVar.f : z3, (i & 64) != 0 ? bVar.g : z4, (i & 128) != 0 ? bVar.h : z5, (i & 256) != 0 ? bVar.i : str3, (i & 512) != 0 ? bVar.j : str4);
        }

        public final b a(String str, String str2, Integer num, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3, String str4) {
            AbstractC13042fc3.i(str, "pass");
            AbstractC13042fc3.i(str2, "secondPass");
            AbstractC13042fc3.i(str3, "descriptionText");
            AbstractC13042fc3.i(str4, "confirmationMessage");
            return new b(str, str2, num, z, z2, z3, z4, z5, str3, str4);
        }

        public final String c() {
            return this.j;
        }

        public final String d() {
            return this.i;
        }

        public final boolean e() {
            return this.h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h && AbstractC13042fc3.d(this.i, bVar.i) && AbstractC13042fc3.d(this.j, bVar.j);
        }

        public final String f() {
            return this.a;
        }

        public final boolean g() {
            return this.d;
        }

        public final boolean h() {
            return this.g;
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Integer num = this.c;
            return ((((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
        }

        public final String i() {
            return this.b;
        }

        public final boolean j() {
            return this.e;
        }

        public final Integer k() {
            return this.c;
        }

        public final boolean l() {
            return this.f;
        }

        public String toString() {
            return "InnerState(pass=" + this.a + ", secondPass=" + this.b + ", snackBarMessage=" + this.c + ", passHasFocus=" + this.d + ", secondPassHasFocus=" + this.e + ", isRequesting=" + this.f + ", passwordChanged=" + this.g + ", mustAuthorizeUser=" + this.h + ", descriptionText=" + this.i + ", confirmationMessage=" + this.j + Separators.RPAREN;
        }

        public /* synthetic */ b(String str, String str2, Integer num, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3, String str4, int i, ED1 ed1) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) == 0 ? z5 : false, (i & 256) != 0 ? "" : str3, (i & 512) == 0 ? str4 : "");
        }
    }
}
