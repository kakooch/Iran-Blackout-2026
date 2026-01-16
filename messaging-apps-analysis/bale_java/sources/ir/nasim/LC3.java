package ir.nasim;

import android.content.Context;
import ir.nasim.C13388g85;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class LC3 extends AbstractC17457n0 {
    public static final a g = new a(null);
    public static final int h = 8;
    private int c;
    private boolean d;
    private long e;
    private C13388g85 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LC3(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentLocalContainer");
        this.e = -1L;
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalLive");
        VG3 vg3 = (VG3) abstractC19230q0C;
        this.c = vg3.D();
        this.d = vg3.E();
        this.e = vg3.C();
        C13388g85.a aVar = C13388g85.l;
        String strU = vg3.u();
        AbstractC13042fc3.h(strU, "getFileDescriptor(...)");
        String fileName = vg3.getFileName();
        AbstractC13042fc3.h(fileName, "getFileName(...)");
        this.f = aVar.a(strU, fileName, vg3.getCaption(), vg3.getFileSize(), vg3.z(), vg3.y(), new C22694vg2(vg3.s()));
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String strV = l().v();
        if (strV.length() != 0) {
            return strV;
        }
        String string = context.getString(AbstractC12217eE5.message_holder_content_live);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(LC3.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.LiveContent");
        LC3 lc3 = (LC3) obj;
        return this.c == lc3.c && this.d == lc3.d && this.e == lc3.e && AbstractC13042fc3.d(this.f, lc3.f);
    }

    public int hashCode() {
        return (((((this.c * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.media_live);
        AbstractC13042fc3.h(string, "getString(...)");
        String strV = l().v();
        if (!(!AbstractC20762sZ6.n0(strV))) {
            strV = null;
        }
        if (strV == null) {
            return string;
        }
        String str = string + ": " + strV;
        return str == null ? string : str;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return s().l();
    }

    public final LC3 r(int i, boolean z, C13388g85 c13388g85) {
        LC3 lc3;
        AbstractC13042fc3.i(c13388g85, "media");
        AbstractC18048o0 abstractC18048o0I = i();
        if (abstractC18048o0I instanceof C8540Wk1) {
            lc3 = new LC3((C8540Wk1) abstractC18048o0I);
        } else {
            if (!(abstractC18048o0I instanceof C11909dl1)) {
                throw new RuntimeException("Unknown content type");
            }
            lc3 = new LC3((C11909dl1) abstractC18048o0I);
        }
        lc3.c = i;
        lc3.d = z;
        lc3.f = c13388g85;
        return lc3;
    }

    public final C23345wl7 s() {
        C23345wl7 c23345wl7T;
        C13388g85 c13388g85 = this.f;
        return (c13388g85 == null || (c23345wl7T = c13388g85.t()) == null) ? C23345wl7.g.b("", new ArrayList()) : c23345wl7T;
    }

    public final long t() {
        return this.e;
    }

    public final C13388g85 u() {
        return this.f;
    }

    public final int v() {
        return this.c;
    }

    public final boolean w() {
        return this.d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LC3(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        this.e = -1L;
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiLiveMessage");
        C16265kz c16265kz = (C16265kz) abstractC24063xzC;
        this.c = c16265kz.y();
        this.d = c16265kz.z();
        this.e = c16265kz.u();
        this.f = new C13388g85(new C11909dl1(c16265kz.w()));
    }
}
