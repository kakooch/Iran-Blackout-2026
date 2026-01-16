package ir.nasim;

import android.content.Context;
import java.util.HashMap;

/* renamed from: ir.nasim.iy5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15080iy5 extends OL4 {
    public static final a n = new a(null);
    public static final int o = 8;
    private final EnumC22564vS4 c;
    private final EnumC16795ls5 d;
    private final int e;
    private final HashMap f;
    private J g;
    private final long h;
    private final String i;
    private final String j;
    private final String k;
    private final int l;
    private final String m;

    /* renamed from: ir.nasim.iy5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15080iy5(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiOrderMessage");
        AbstractC14591iA abstractC14591iAU = ((C15784kA) abstractC24063xzC).u();
        AbstractC13042fc3.g(abstractC14591iAU, "null cannot be cast to non-null type ir.nasim.core.api.ApiPsProxyOrderMessage");
        C13411gB c13411gB = (C13411gB) abstractC14591iAU;
        this.c = EnumC22564vS4.j(c13411gB.z());
        this.d = EnumC16795ls5.j(c13411gB.w());
        this.e = c13411gB.y();
        this.f = new HashMap();
        for (C20420rz c20420rz : c13411gB.u().u()) {
            AbstractC17566nB abstractC17566nBQ = c20420rz.q();
            AbstractC13042fc3.h(abstractC17566nBQ, "getValue(...)");
            if (abstractC17566nBQ instanceof OC) {
                this.f.put(EnumC21974uS4.j(c20420rz.getKey()), ((OC) abstractC17566nBQ).u());
            }
        }
        String str = this.f.get(EnumC21974uS4.MONEY_AMOUNT);
        str = str == null ? "0" : str;
        AbstractC13042fc3.g(str, "null cannot be cast to non-null type kotlin.String");
        this.h = Long.parseLong((String) str);
        if (this.d == EnumC16795ls5.CHARGE) {
            String str2 = this.f.get(EnumC21974uS4.CHARGE_TYPE);
            this.g = J.j((String) (str2 == null ? "UNSUPPORTED_VALUE" : str2));
        }
        String str3 = this.f.get(EnumC21974uS4.SERVICE_TYPE_NEW);
        str3 = str3 == null ? "UNSUPPORTED_VALUE" : str3;
        AbstractC13042fc3.g(str3, "null cannot be cast to non-null type kotlin.String");
        this.m = (String) str3;
        Object obj = this.f.get(EnumC21974uS4.OPERATOR);
        this.i = (String) (obj != null ? obj : "UNSUPPORTED_VALUE");
        String str4 = this.f.get(EnumC21974uS4.PHONE_NUMBER);
        this.j = (String) (str4 == null ? "" : str4);
        Object obj2 = this.f.get(EnumC21974uS4.PAYMENT_ID);
        this.k = (String) (obj2 != null ? obj2 : "");
        Object obj3 = this.f.get(EnumC21974uS4.BILL_OPERATOR);
        Object obj4 = obj3 != null ? obj3 : "0";
        AbstractC13042fc3.g(obj4, "null cannot be cast to non-null type kotlin.String");
        this.l = Integer.parseInt((String) obj4);
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return InterfaceC25103zk1.a.a(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C15080iy5.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PsProxyOrderContent");
        C15080iy5 c15080iy5 = (C15080iy5) obj;
        return this.e == c15080iy5.e && this.h == c15080iy5.h && this.l == c15080iy5.l && this.c == c15080iy5.c && this.d == c15080iy5.d && AbstractC13042fc3.d(this.f, c15080iy5.f) && this.g == c15080iy5.g && AbstractC13042fc3.d(this.i, c15080iy5.i) && AbstractC13042fc3.d(this.j, c15080iy5.j) && AbstractC13042fc3.d(this.k, c15080iy5.k) && AbstractC13042fc3.d(this.m, c15080iy5.m);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.e * 31) + Long.hashCode(this.h)) * 31) + this.l) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.f.hashCode()) * 31;
        J j = this.g;
        int iHashCode2 = (iHashCode + (j != null ? j.hashCode() : 0)) * 31;
        String str = this.i;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.j;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.k;
        return ((iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.m.hashCode();
    }
}
