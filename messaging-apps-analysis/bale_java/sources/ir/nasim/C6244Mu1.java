package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.text.Spannable;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;

/* renamed from: ir.nasim.Mu1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6244Mu1 {
    private final Spannable a;
    private final Spannable b;
    private final Spannable c;
    private final Spannable d;
    private final int e;
    private final boolean f;
    private final CrowdfundingContentInfo g;
    private final AbstractC17757nW1.c h;

    public C6244Mu1(Spannable spannable, Spannable spannable2, Spannable spannable3, Spannable spannable4, int i, boolean z, CrowdfundingContentInfo crowdfundingContentInfo, AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(spannable, "body");
        AbstractC13042fc3.i(spannable2, "amountDetails");
        AbstractC13042fc3.i(spannable4, "progressDetails");
        AbstractC13042fc3.i(crowdfundingContentInfo, ParameterNames.INFO);
        AbstractC13042fc3.i(cVar, "graphical");
        this.a = spannable;
        this.b = spannable2;
        this.c = spannable3;
        this.d = spannable4;
        this.e = i;
        this.f = z;
        this.g = crowdfundingContentInfo;
        this.h = cVar;
    }

    public final Spannable a() {
        return this.b;
    }

    public final AbstractC17757nW1.c b() {
        return this.h;
    }

    public final CrowdfundingContentInfo c() {
        return this.g;
    }

    public final int d() {
        return this.e;
    }

    public final Spannable e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6244Mu1)) {
            return false;
        }
        C6244Mu1 c6244Mu1 = (C6244Mu1) obj;
        return AbstractC13042fc3.d(this.a, c6244Mu1.a) && AbstractC13042fc3.d(this.b, c6244Mu1.b) && AbstractC13042fc3.d(this.c, c6244Mu1.c) && AbstractC13042fc3.d(this.d, c6244Mu1.d) && this.e == c6244Mu1.e && this.f == c6244Mu1.f && AbstractC13042fc3.d(this.g, c6244Mu1.g) && AbstractC13042fc3.d(this.h, c6244Mu1.h);
    }

    public final Spannable f() {
        return this.c;
    }

    public final boolean g() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Spannable spannable = this.c;
        return ((((((((((iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        Spannable spannable = this.a;
        Spannable spannable2 = this.b;
        Spannable spannable3 = this.c;
        Spannable spannable4 = this.d;
        return "CrowdFunding(body=" + ((Object) spannable) + ", amountDetails=" + ((Object) spannable2) + ", remainingTime=" + ((Object) spannable3) + ", progressDetails=" + ((Object) spannable4) + ", progress=" + this.e + ", isInProgress=" + this.f + ", info=" + this.g + ", graphical=" + this.h + Separators.RPAREN;
    }
}
