package io.sentry.clientreport;

import io.sentry.AbstractC3141l;
import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.EnumC3136k;
import io.sentry.J2;
import io.sentry.X2;
import io.sentry.Y2;
import io.sentry.protocol.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class e implements h {
    private final i a = new b();
    private final C3155n3 b;

    public e(C3155n3 c3155n3) {
        this.b = c3155n3;
    }

    private EnumC3136k f(X2 x2) {
        return X2.Event.equals(x2) ? EnumC3136k.Error : X2.Session.equals(x2) ? EnumC3136k.Session : X2.Transaction.equals(x2) ? EnumC3136k.Transaction : X2.UserFeedback.equals(x2) ? EnumC3136k.UserReport : X2.Feedback.equals(x2) ? EnumC3136k.Feedback : X2.Profile.equals(x2) ? EnumC3136k.Profile : X2.ProfileChunk.equals(x2) ? EnumC3136k.ProfileChunkUi : X2.Attachment.equals(x2) ? EnumC3136k.Attachment : X2.CheckIn.equals(x2) ? EnumC3136k.Monitor : X2.ReplayVideo.equals(x2) ? EnumC3136k.Replay : X2.Log.equals(x2) ? EnumC3136k.LogItem : EnumC3136k.Default;
    }

    private void g(f fVar, EnumC3136k enumC3136k, Long l) {
        this.b.getOnDiscard();
    }

    private void h(String str, String str2, Long l) {
        this.a.a(new d(str, str2), l);
    }

    private void j(c cVar) {
        if (cVar == null) {
            return;
        }
        for (g gVar : cVar.a()) {
            h(gVar.c(), gVar.a(), gVar.b());
        }
    }

    @Override // io.sentry.clientreport.h
    public void a(f fVar, EnumC3136k enumC3136k) {
        c(fVar, enumC3136k, 1L);
    }

    @Override // io.sentry.clientreport.h
    public void b(f fVar, C3134j2 c3134j2) {
        if (c3134j2 == null) {
            return;
        }
        try {
            Iterator it = c3134j2.c().iterator();
            while (it.hasNext()) {
                d(fVar, (J2) it.next());
            }
        } catch (Throwable th) {
            this.b.getLogger().a(Y2.ERROR, th, "Unable to record lost envelope.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.h
    public void c(f fVar, EnumC3136k enumC3136k, long j) {
        try {
            h(fVar.getReason(), enumC3136k.getCategory(), Long.valueOf(j));
            g(fVar, enumC3136k, Long.valueOf(j));
        } catch (Throwable th) {
            this.b.getLogger().a(Y2.ERROR, th, "Unable to record lost event.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.h
    public void d(f fVar, J2 j2) {
        C cK;
        if (j2 == null) {
            return;
        }
        try {
            X2 x2B = j2.J().b();
            if (X2.ClientReport.equals(x2B)) {
                try {
                    j(j2.H(this.b.getSerializer()));
                    return;
                } catch (Exception unused) {
                    this.b.getLogger().c(Y2.ERROR, "Unable to restore counts from previous client report.", new Object[0]);
                    return;
                }
            }
            EnumC3136k enumC3136kF = f(x2B);
            if (enumC3136kF.equals(EnumC3136k.Transaction) && (cK = j2.K(this.b.getSerializer())) != null) {
                List listP0 = cK.p0();
                String reason = fVar.getReason();
                EnumC3136k enumC3136k = EnumC3136k.Span;
                h(reason, enumC3136k.getCategory(), Long.valueOf(listP0.size() + 1));
                g(fVar, enumC3136k, Long.valueOf(listP0.size() + 1));
            }
            h(fVar.getReason(), enumC3136kF.getCategory(), 1L);
            g(fVar, enumC3136kF, 1L);
        } catch (Throwable th) {
            this.b.getLogger().a(Y2.ERROR, th, "Unable to record lost envelope item.", new Object[0]);
        }
    }

    @Override // io.sentry.clientreport.h
    public C3134j2 e(C3134j2 c3134j2) {
        c cVarI = i();
        if (cVarI == null) {
            return c3134j2;
        }
        try {
            this.b.getLogger().c(Y2.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList = new ArrayList();
            Iterator it = c3134j2.c().iterator();
            while (it.hasNext()) {
                arrayList.add((J2) it.next());
            }
            arrayList.add(J2.A(this.b.getSerializer(), cVarI));
            return new C3134j2(c3134j2.b(), arrayList);
        } catch (Throwable th) {
            this.b.getLogger().a(Y2.ERROR, th, "Unable to attach client report to envelope.", new Object[0]);
            return c3134j2;
        }
    }

    c i() {
        Date dateD = AbstractC3141l.d();
        List listB = this.a.b();
        if (listB.isEmpty()) {
            return null;
        }
        return new c(dateD, listB);
    }
}
