package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.wl7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23345wl7 extends AbstractC17457n0 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final String c;
    private final AbstractC9585aD d;
    private final ArrayList e;
    private final C5118Hz f;

    /* renamed from: ir.nasim.wl7$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ C23345wl7 c(a aVar, String str, ArrayList arrayList, int i, Object obj) {
            if ((i & 2) != 0) {
                arrayList = new ArrayList();
            }
            return aVar.b(str, arrayList);
        }

        public final C23345wl7 a(String str) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            return c(this, str, null, 2, null);
        }

        public final C23345wl7 b(String str, ArrayList arrayList) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(arrayList, "mentions");
            return new C23345wl7(new C11909dl1(new ZC(str, arrayList, null, null)));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23345wl7(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiTextMessage");
        ZC zc = (ZC) abstractC24063xzC;
        this.c = zc.z();
        List listW = zc.w();
        AbstractC13042fc3.g(listW, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
        this.e = (ArrayList) listW;
        this.d = zc.u();
        this.f = zc.y();
    }

    public static final C23345wl7 r(String str) {
        return g.a(str);
    }

    public static final C23345wl7 s(String str, ArrayList arrayList) {
        return g.b(str, arrayList);
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C23345wl7.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.TextContent");
        C23345wl7 c23345wl7 = (C23345wl7) obj;
        return AbstractC13042fc3.d(this.c, c23345wl7.c) && AbstractC13042fc3.d(this.d, c23345wl7.d) && AbstractC13042fc3.d(this.e, c23345wl7.e) && AbstractC13042fc3.d(this.f, c23345wl7.f);
    }

    public int hashCode() {
        int iHashCode = this.c.hashCode() * 31;
        AbstractC9585aD abstractC9585aD = this.d;
        int iHashCode2 = (((iHashCode + (abstractC9585aD != null ? abstractC9585aD.hashCode() : 0)) * 31) + this.e.hashCode()) * 31;
        C5118Hz c5118Hz = this.f;
        return iHashCode2 + (c5118Hz != null ? c5118Hz.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        return this.c;
    }

    public final ArrayList t() {
        return this.e;
    }

    public final C5118Hz u() {
        return this.f;
    }

    public final String v() {
        return this.c;
    }

    public final AbstractC9585aD w() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return this;
    }
}
