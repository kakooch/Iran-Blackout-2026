package io.sentry;

import io.sentry.B1;
import io.sentry.C3;
import io.sentry.C3155n3;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.protocol.C3168c;
import io.sentry.protocol.C3169d;
import io.sentry.protocol.C3171f;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: io.sentry.f2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3114f2 implements InterfaceC3092b0 {
    private final C3155n3 b;
    private final io.sentry.transport.q c;
    private final io.sentry.logger.b e;
    private final b d = new b();
    private boolean a = true;

    /* renamed from: io.sentry.f2$b */
    private static final class b implements Comparator {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3106e c3106e, C3106e c3106e2) {
            return c3106e.v().compareTo(c3106e2.v());
        }
    }

    public C3114f2(C3155n3 c3155n3) {
        this.b = (C3155n3) io.sentry.util.u.c(c3155n3, "SentryOptions is required.");
        InterfaceC3137k0 transportFactory = c3155n3.getTransportFactory();
        if (transportFactory instanceof C3108e1) {
            transportFactory = new C3031a();
            c3155n3.setTransportFactory(transportFactory);
        }
        this.c = transportFactory.a(c3155n3, new C3232z1(c3155n3).a());
        if (c3155n3.getLogs().a()) {
            this.e = new io.sentry.logger.e(c3155n3, this);
        } else {
            this.e = io.sentry.logger.f.a();
        }
    }

    private List A(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C3091b c3091b = (C3091b) it.next();
            if (c3091b.k()) {
                arrayList.add(c3091b);
            }
        }
        return arrayList;
    }

    private void B(X x, I i) {
        InterfaceC3127i0 interfaceC3127i0F = x.f();
        if (interfaceC3127i0F == null || !io.sentry.util.m.h(i, io.sentry.hints.q.class)) {
            return;
        }
        Object objG = io.sentry.util.m.g(i);
        if (!(objG instanceof io.sentry.hints.f)) {
            interfaceC3127i0F.a(O3.ABORTED, false, null);
        } else {
            ((io.sentry.hints.f) objG).c(interfaceC3127i0F.b());
            interfaceC3127i0F.a(O3.ABORTED, false, i);
        }
    }

    private List C(I i) {
        List listE = i.e();
        C3091b c3091bG = i.g();
        if (c3091bG != null) {
            listE.add(c3091bG);
        }
        C3091b c3091bI = i.i();
        if (c3091bI != null) {
            listE.add(c3091bI);
        }
        C3091b c3091bH = i.h();
        if (c3091bH != null) {
            listE.add(c3091bH);
        }
        return listE;
    }

    private T3 D(X x, I i, AbstractC3099c2 abstractC3099c2, String str) {
        if (io.sentry.util.m.h(i, io.sentry.hints.c.class)) {
            if (abstractC3099c2 != null) {
                return C3101d.c(abstractC3099c2, str, this.b).J();
            }
        } else if (x != null) {
            InterfaceC3127i0 interfaceC3127i0F = x.f();
            return interfaceC3127i0F != null ? interfaceC3127i0F.p() : io.sentry.util.F.j(x, this.b).h();
        }
        return null;
    }

    private T3 E(X x, I i, L2 l2) {
        return D(x, i, l2, l2 != null ? l2.x0() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(C3 c3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(L2 l2, I i, C3 c3) {
        if (c3 == null) {
            this.b.getLogger().c(Y2.INFO, "Session is null on scope.withSession", new Object[0]);
            return;
        }
        String strH = null;
        C3.b bVar = l2.z0() ? C3.b.Crashed : null;
        boolean z = C3.b.Crashed == bVar || l2.A0();
        String str = (l2.K() == null || l2.K().l() == null || !l2.K().l().containsKey("user-agent")) ? null : (String) l2.K().l().get("user-agent");
        Object objG = io.sentry.util.m.g(i);
        if (objG instanceof io.sentry.hints.a) {
            strH = ((io.sentry.hints.a) objG).h();
            bVar = C3.b.Abnormal;
        }
        if (c3.q(bVar, str, z, strH) && c3.m()) {
            c3.c();
        }
    }

    private L2 H(L2 l2, I i, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            D d = (D) it.next();
            try {
                boolean z = d instanceof InterfaceC3096c;
                boolean zH = io.sentry.util.m.h(i, io.sentry.hints.c.class);
                if (zH && z) {
                    l2 = d.b(l2, i);
                } else if (!zH && !z) {
                    l2 = d.b(l2, i);
                }
            } catch (Throwable th) {
                this.b.getLogger().a(Y2.ERROR, th, "An exception occurred while processing event by processor: %s", d.getClass().getName());
            }
            if (l2 == null) {
                this.b.getLogger().c(Y2.DEBUG, "Event was dropped by a processor: %s", d.getClass().getName());
                this.b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, EnumC3136k.Error);
                break;
            }
        }
        return l2;
    }

    private L2 I(L2 l2, I i, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            D d = (D) it.next();
            try {
                l2 = d.b(l2, i);
            } catch (Throwable th) {
                this.b.getLogger().a(Y2.ERROR, th, "An exception occurred while processing feedback event by processor: %s", d.getClass().getName());
            }
            if (l2 == null) {
                this.b.getLogger().c(Y2.DEBUG, "Feedback event was dropped by a processor: %s", d.getClass().getName());
                this.b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, EnumC3136k.Feedback);
                break;
            }
        }
        return l2;
    }

    private C3160o3 J(C3160o3 c3160o3, I i, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            D d = (D) it.next();
            try {
                c3160o3 = d.a(c3160o3, i);
            } catch (Throwable th) {
                this.b.getLogger().a(Y2.ERROR, th, "An exception occurred while processing replay event by processor: %s", d.getClass().getName());
            }
            if (c3160o3 == null) {
                this.b.getLogger().c(Y2.DEBUG, "Replay event was dropped by a processor: %s", d.getClass().getName());
                this.b.getClientReportRecorder().a(io.sentry.clientreport.f.EVENT_PROCESSOR, EnumC3136k.Replay);
                break;
            }
        }
        return c3160o3;
    }

    private io.sentry.protocol.C K(io.sentry.protocol.C c, I i, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            D d = (D) it.next();
            int size = c.p0().size();
            try {
                c = d.c(c, i);
            } catch (Throwable th) {
                this.b.getLogger().a(Y2.ERROR, th, "An exception occurred while processing transaction by processor: %s", d.getClass().getName());
            }
            int size2 = c == null ? 0 : c.p0().size();
            if (c == null) {
                this.b.getLogger().c(Y2.DEBUG, "Transaction was dropped by a processor: %s", d.getClass().getName());
                io.sentry.clientreport.h clientReportRecorder = this.b.getClientReportRecorder();
                io.sentry.clientreport.f fVar = io.sentry.clientreport.f.EVENT_PROCESSOR;
                clientReportRecorder.a(fVar, EnumC3136k.Transaction);
                this.b.getClientReportRecorder().c(fVar, EnumC3136k.Span, size + 1);
                break;
            }
            if (size2 < size) {
                int i2 = size - size2;
                this.b.getLogger().c(Y2.DEBUG, "%d spans were dropped by a processor: %s", Integer.valueOf(i2), d.getClass().getName());
                this.b.getClientReportRecorder().c(io.sentry.clientreport.f.EVENT_PROCESSOR, EnumC3136k.Span, i2);
            }
        }
        return c;
    }

    private boolean L() {
        io.sentry.util.x xVarA = this.b.getSampleRate() == null ? null : io.sentry.util.z.a();
        return this.b.getSampleRate() == null || xVarA == null || this.b.getSampleRate().doubleValue() >= xVarA.d();
    }

    private io.sentry.protocol.v M(C3134j2 c3134j2, I i) {
        C3155n3.b beforeEnvelopeCallback = this.b.getBeforeEnvelopeCallback();
        if (beforeEnvelopeCallback != null) {
            try {
                beforeEnvelopeCallback.a(c3134j2, i);
            } catch (Throwable th) {
                this.b.getLogger().b(Y2.ERROR, "The BeforeEnvelope callback threw an exception.", th);
            }
        }
        W2.d().c(this.b.getLogger());
        if (i == null) {
            this.c.C1(c3134j2);
        } else {
            this.c.c0(c3134j2, i);
        }
        io.sentry.protocol.v vVarA = c3134j2.b().a();
        return vVarA != null ? vVarA : io.sentry.protocol.v.b;
    }

    private boolean N(AbstractC3099c2 abstractC3099c2, I i) {
        if (io.sentry.util.m.u(i)) {
            return true;
        }
        this.b.getLogger().c(Y2.DEBUG, "Event was cached so not applying scope: %s", abstractC3099c2.G());
        return false;
    }

    private boolean O(C3 c3, C3 c32) {
        if (c32 == null) {
            return false;
        }
        if (c3 == null) {
            return true;
        }
        C3.b bVarL = c32.l();
        C3.b bVar = C3.b.Crashed;
        if (bVarL != bVar || c3.l() == bVar) {
            return c32.e() > 0 && c3.e() <= 0;
        }
        return true;
    }

    private void P(AbstractC3099c2 abstractC3099c2, Collection collection) {
        List listB = abstractC3099c2.B();
        if (listB == null || collection.isEmpty()) {
            return;
        }
        listB.addAll(collection);
        Collections.sort(listB, this.d);
    }

    private void k(X x, I i) {
        if (x != null) {
            i.a(x.C());
        }
    }

    private L2 l(L2 l2, X x, I i) {
        if (l2.Q() == null) {
            l2.g0(x.getUser());
        }
        if (l2.N() == null) {
            l2.e0(new HashMap(x.p()));
        } else {
            for (Map.Entry entry : x.p().entrySet()) {
                if (!l2.N().containsKey(entry.getKey())) {
                    l2.N().put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        C3168c c3168cC = l2.C();
        for (Map.Entry entry2 : new C3168c(x.r()).b()) {
            if (!c3168cC.a(entry2.getKey())) {
                c3168cC.k((String) entry2.getKey(), entry2.getValue());
            }
        }
        InterfaceC3117g0 interfaceC3117g0C = x.c();
        if (l2.C().i() == null) {
            if (interfaceC3117g0C == null) {
                l2.C().x(W3.v(x.z()));
            } else {
                l2.C().x(interfaceC3117g0C.v());
            }
        }
        return I(l2, i, x.H());
    }

    private AbstractC3099c2 m(AbstractC3099c2 abstractC3099c2, X x) {
        if (x != null) {
            if (abstractC3099c2.K() == null) {
                abstractC3099c2.a0(x.getRequest());
            }
            if (abstractC3099c2.Q() == null) {
                abstractC3099c2.g0(x.getUser());
            }
            if (abstractC3099c2.N() == null) {
                abstractC3099c2.e0(new HashMap(x.p()));
            } else {
                for (Map.Entry entry : x.p().entrySet()) {
                    if (!abstractC3099c2.N().containsKey(entry.getKey())) {
                        abstractC3099c2.N().put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            if (abstractC3099c2.B() == null) {
                abstractC3099c2.S(new ArrayList(x.n()));
            } else {
                P(abstractC3099c2, x.n());
            }
            if (abstractC3099c2.H() == null) {
                abstractC3099c2.X(new HashMap(x.getExtras()));
            } else {
                for (Map.Entry entry2 : x.getExtras().entrySet()) {
                    if (!abstractC3099c2.H().containsKey(entry2.getKey())) {
                        abstractC3099c2.H().put((String) entry2.getKey(), entry2.getValue());
                    }
                }
            }
            C3168c c3168cC = abstractC3099c2.C();
            for (Map.Entry entry3 : new C3168c(x.r()).b()) {
                if (!c3168cC.a(entry3.getKey())) {
                    c3168cC.k((String) entry3.getKey(), entry3.getValue());
                }
            }
        }
        return abstractC3099c2;
    }

    private L2 n(L2 l2, X x, I i) {
        if (x == null) {
            return l2;
        }
        m(l2, x);
        if (l2.x0() == null) {
            l2.I0(x.v());
        }
        if (l2.r0() == null) {
            l2.C0(x.u());
        }
        if (x.a() != null) {
            l2.D0(x.a());
        }
        InterfaceC3117g0 interfaceC3117g0C = x.c();
        if (l2.C().i() == null) {
            if (interfaceC3117g0C == null) {
                l2.C().x(W3.v(x.z()));
            } else {
                l2.C().x(interfaceC3117g0C.v());
            }
        }
        return H(l2, i, x.H());
    }

    private C3160o3 o(C3160o3 c3160o3, X x) {
        if (x != null) {
            if (c3160o3.K() == null) {
                c3160o3.a0(x.getRequest());
            }
            if (c3160o3.Q() == null) {
                c3160o3.g0(x.getUser());
            }
            if (c3160o3.N() == null) {
                c3160o3.e0(new HashMap(x.p()));
            } else {
                for (Map.Entry entry : x.p().entrySet()) {
                    if (!c3160o3.N().containsKey(entry.getKey())) {
                        c3160o3.N().put((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
            C3168c c3168cC = c3160o3.C();
            for (Map.Entry entry2 : new C3168c(x.r()).b()) {
                if (!c3168cC.a(entry2.getKey())) {
                    c3168cC.k((String) entry2.getKey(), entry2.getValue());
                }
            }
            InterfaceC3117g0 interfaceC3117g0C = x.c();
            if (c3160o3.C().i() == null) {
                if (interfaceC3117g0C == null) {
                    c3160o3.C().x(W3.v(x.z()));
                } else {
                    c3160o3.C().x(interfaceC3117g0C.v());
                }
            }
        }
        return c3160o3;
    }

    private C3134j2 p(AbstractC3099c2 abstractC3099c2, List list, C3 c3, T3 t3, C3186s1 c3186s1) {
        io.sentry.protocol.v vVar;
        ArrayList arrayList = new ArrayList();
        if (abstractC3099c2 != null) {
            arrayList.add(J2.B(this.b.getSerializer(), abstractC3099c2));
            vVar = abstractC3099c2.G();
        } else {
            vVar = null;
        }
        if (c3 != null) {
            arrayList.add(J2.G(this.b.getSerializer(), c3));
        }
        if (c3186s1 != null) {
            arrayList.add(J2.E(c3186s1, this.b.getMaxTraceFileSize(), this.b.getSerializer()));
            if (vVar == null) {
                vVar = new io.sentry.protocol.v(c3186s1.B());
            }
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(J2.z(this.b.getSerializer(), this.b.getLogger(), (C3091b) it.next(), this.b.getMaxAttachmentSize()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C3134j2(new C3139k2(vVar, this.b.getSdkVersion(), t3), arrayList);
    }

    private C3134j2 q(C3100c3 c3100c3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(J2.C(this.b.getSerializer(), c3100c3));
        return new C3134j2(new C3139k2(null, this.b.getSdkVersion(), null), arrayList);
    }

    private C3134j2 s(C3160o3 c3160o3, C3222x1 c3222x1, T3 t3, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(J2.F(this.b.getSerializer(), this.b.getLogger(), c3160o3, c3222x1, z));
        return new C3134j2(new C3139k2(c3160o3.G(), this.b.getSessionReplay().i(), t3), arrayList);
    }

    private L2 u(L2 l2, I i) {
        C3155n3.c beforeSend = this.b.getBeforeSend();
        if (beforeSend == null) {
            return l2;
        }
        try {
            return beforeSend.a(l2, i);
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private L2 v(L2 l2, I i) {
        C3155n3.c beforeSendFeedback = this.b.getBeforeSendFeedback();
        if (beforeSendFeedback == null) {
            return l2;
        }
        try {
            return beforeSendFeedback.a(l2, i);
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "The BeforeSendFeedback callback threw an exception.", th);
            return null;
        }
    }

    private C3160o3 y(C3160o3 c3160o3, I i) {
        this.b.getBeforeSendReplay();
        return c3160o3;
    }

    private io.sentry.protocol.C z(io.sentry.protocol.C c, I i) {
        C3155n3.e beforeSendTransaction = this.b.getBeforeSendTransaction();
        if (beforeSendTransaction == null) {
            return c;
        }
        try {
            return beforeSendTransaction.a(c, i);
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    C3 Q(final L2 l2, final I i, X x) {
        if (io.sentry.util.m.u(i)) {
            if (x != null) {
                return x.o(new B1.b() { // from class: io.sentry.e2
                    @Override // io.sentry.B1.b
                    public final void a(C3 c3) {
                        this.a.G(l2, i, c3);
                    }
                });
            }
            this.b.getLogger().c(Y2.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }

    @Override // io.sentry.InterfaceC3092b0
    public io.sentry.protocol.v a(C3160o3 c3160o3, X x, I i) {
        io.sentry.util.u.c(c3160o3, "SessionReplay is required.");
        if (i == null) {
            i = new I();
        }
        if (N(c3160o3, i)) {
            o(c3160o3, x);
        }
        ILogger logger = this.b.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "Capturing session replay: %s", c3160o3.G());
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        io.sentry.protocol.v vVarG = c3160o3.G() != null ? c3160o3.G() : vVar;
        C3160o3 c3160o3J = J(c3160o3, i, this.b.getEventProcessors());
        if (c3160o3J != null && (c3160o3J = y(c3160o3J, i)) == null) {
            this.b.getLogger().c(y2, "Event was dropped by beforeSendReplay", new Object[0]);
            this.b.getClientReportRecorder().a(io.sentry.clientreport.f.BEFORE_SEND, EnumC3136k.Replay);
        }
        if (c3160o3J == null) {
            return vVar;
        }
        try {
            C3134j2 c3134j2S = s(c3160o3J, i.f(), D(x, i, c3160o3J, null), io.sentry.util.m.h(i, io.sentry.hints.c.class));
            i.b();
            this.c.c0(c3134j2S, i);
            return vVarG;
        } catch (IOException e) {
            this.b.getLogger().a(Y2.WARNING, e, "Capturing event %s failed.", vVarG);
            return io.sentry.protocol.v.b;
        }
    }

    @Override // io.sentry.InterfaceC3092b0
    public io.sentry.protocol.v b(io.sentry.protocol.C c, T3 t3, X x, I i, C3186s1 c3186s1) {
        io.sentry.protocol.C cK;
        io.sentry.util.u.c(c, "Transaction is required.");
        I i2 = i == null ? new I() : i;
        if (N(c, i2)) {
            k(x, i2);
        }
        ILogger logger = this.b.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "Capturing transaction: %s", c.G());
        if (io.sentry.util.F.f(this.b.getIgnoredTransactions(), c.q0())) {
            this.b.getLogger().c(y2, "Transaction was dropped as transaction name %s is ignored", c.q0());
            io.sentry.clientreport.h clientReportRecorder = this.b.getClientReportRecorder();
            io.sentry.clientreport.f fVar = io.sentry.clientreport.f.EVENT_PROCESSOR;
            clientReportRecorder.a(fVar, EnumC3136k.Transaction);
            this.b.getClientReportRecorder().c(fVar, EnumC3136k.Span, c.p0().size() + 1);
            return io.sentry.protocol.v.b;
        }
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        io.sentry.protocol.v vVarG = c.G() != null ? c.G() : vVar;
        if (N(c, i2)) {
            cK = (io.sentry.protocol.C) m(c, x);
            if (cK != null && x != null) {
                cK = K(cK, i2, x.H());
            }
            if (cK == null) {
                this.b.getLogger().c(y2, "Transaction was dropped by applyScope", new Object[0]);
            }
        } else {
            cK = c;
        }
        if (cK != null) {
            cK = K(cK, i2, this.b.getEventProcessors());
        }
        if (cK == null) {
            this.b.getLogger().c(y2, "Transaction was dropped by Event processors.", new Object[0]);
            return vVar;
        }
        int size = cK.p0().size();
        io.sentry.protocol.C cZ = z(cK, i2);
        int size2 = cZ == null ? 0 : cZ.p0().size();
        if (cZ == null) {
            this.b.getLogger().c(y2, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            io.sentry.clientreport.h clientReportRecorder2 = this.b.getClientReportRecorder();
            io.sentry.clientreport.f fVar2 = io.sentry.clientreport.f.BEFORE_SEND;
            clientReportRecorder2.a(fVar2, EnumC3136k.Transaction);
            this.b.getClientReportRecorder().c(fVar2, EnumC3136k.Span, size + 1);
            return vVar;
        }
        if (size2 < size) {
            int i3 = size - size2;
            this.b.getLogger().c(y2, "%d spans were dropped by beforeSendTransaction.", Integer.valueOf(i3));
            this.b.getClientReportRecorder().c(io.sentry.clientreport.f.BEFORE_SEND, EnumC3136k.Span, i3);
        }
        try {
            C3134j2 c3134j2P = p(cZ, A(C(i2)), null, t3, c3186s1);
            i2.b();
            return c3134j2P != null ? M(c3134j2P, i2) : vVarG;
        } catch (SentryEnvelopeException | IOException e) {
            this.b.getLogger().a(Y2.WARNING, e, "Capturing transaction %s failed.", vVarG);
            return io.sentry.protocol.v.b;
        }
    }

    @Override // io.sentry.InterfaceC3092b0
    public void c(C3 c3, I i) {
        io.sentry.util.u.c(c3, "Session is required.");
        if (c3.h() == null || c3.h().isEmpty()) {
            this.b.getLogger().c(Y2.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            x(C3134j2.a(this.b.getSerializer(), c3, this.b.getSdkVersion()), i);
        } catch (IOException e) {
            this.b.getLogger().b(Y2.ERROR, "Failed to capture session.", e);
        }
    }

    @Override // io.sentry.InterfaceC3092b0
    public io.sentry.protocol.v d(C3171f c3171f, I i, X x) {
        L2 l2 = new L2();
        l2.C().q(c3171f);
        if (i == null) {
            i = new I();
        }
        if (c3171f.i() == null) {
            c3171f.o(x.s());
        }
        ILogger logger = this.b.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "Capturing feedback: %s", l2.G());
        if (N(l2, i) && (l2 = l(l2, x, i)) == null) {
            this.b.getLogger().c(y2, "Feedback was dropped by applyScope", new Object[0]);
            return io.sentry.protocol.v.b;
        }
        L2 l2I = I(l2, i, this.b.getEventProcessors());
        if (l2I != null && (l2I = v(l2I, i)) == null) {
            this.b.getLogger().c(y2, "Event was dropped by beforeSend", new Object[0]);
            this.b.getClientReportRecorder().a(io.sentry.clientreport.f.BEFORE_SEND, EnumC3136k.Feedback);
        }
        L2 l22 = l2I;
        if (l22 == null) {
            return io.sentry.protocol.v.b;
        }
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        io.sentry.protocol.v vVarG = l22.G() != null ? l22.G() : vVar;
        if (c3171f.h() == null) {
            this.b.getReplayController().y(Boolean.FALSE);
            io.sentry.protocol.v vVarJ = x.j();
            if (!vVarJ.equals(vVar)) {
                c3171f.n(vVarJ);
            }
        }
        try {
            C3134j2 c3134j2P = p(l22, C(i), null, E(x, i, l22), null);
            i.b();
            return c3134j2P != null ? M(c3134j2P, i) : vVarG;
        } catch (SentryEnvelopeException | IOException e) {
            this.b.getLogger().a(Y2.WARNING, e, "Capturing feedback %s failed.", vVarG);
            return io.sentry.protocol.v.b;
        }
    }

    @Override // io.sentry.InterfaceC3092b0
    public void e(C3100c3 c3100c3) {
        try {
            M(q(c3100c3), null);
        } catch (IOException e) {
            this.b.getLogger().a(Y2.WARNING, e, "Capturing log failed.", new Object[0]);
        }
    }

    @Override // io.sentry.InterfaceC3092b0
    public io.sentry.protocol.v f(C3158o1 c3158o1, X x) {
        io.sentry.util.u.c(c3158o1, "profileChunk is required.");
        this.b.getLogger().c(Y2.DEBUG, "Capturing profile chunk: %s", c3158o1.l());
        io.sentry.protocol.v vVarL = c3158o1.l();
        C3169d c3169dC = C3169d.c(c3158o1.m(), this.b);
        if (c3169dC != null) {
            c3158o1.p(c3169dC);
        }
        try {
            return M(new C3134j2(new C3139k2(vVarL, this.b.getSdkVersion(), null), Collections.singletonList(J2.D(c3158o1, this.b.getSerializer()))), null);
        } catch (SentryEnvelopeException | IOException e) {
            this.b.getLogger().a(Y2.WARNING, e, "Capturing profile chunk %s failed.", vVarL);
            return io.sentry.protocol.v.b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01b8  */
    @Override // io.sentry.InterfaceC3092b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.protocol.v g(io.sentry.L2 r12, io.sentry.X r13, io.sentry.I r14) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.C3114f2.g(io.sentry.L2, io.sentry.X, io.sentry.I):io.sentry.protocol.v");
    }

    @Override // io.sentry.InterfaceC3092b0
    public void i(boolean z) throws IOException {
        long shutdownTimeoutMillis;
        this.b.getLogger().c(Y2.INFO, "Closing SentryClient.", new Object[0]);
        if (z) {
            shutdownTimeoutMillis = 0;
        } else {
            try {
                shutdownTimeoutMillis = this.b.getShutdownTimeoutMillis();
            } catch (IOException e) {
                this.b.getLogger().b(Y2.WARNING, "Failed to close the connection to the Sentry Server.", e);
            }
        }
        r(shutdownTimeoutMillis);
        this.e.i(z);
        this.c.i(z);
        for (D d : this.b.getEventProcessors()) {
            if (d instanceof Closeable) {
                try {
                    ((Closeable) d).close();
                } catch (IOException e2) {
                    this.b.getLogger().c(Y2.WARNING, "Failed to close the event processor {}.", d, e2);
                }
            }
        }
        this.a = false;
    }

    @Override // io.sentry.InterfaceC3092b0
    public boolean isEnabled() {
        return this.a;
    }

    @Override // io.sentry.InterfaceC3092b0
    public void r(long j) {
        this.e.r(j);
        this.c.r(j);
    }

    @Override // io.sentry.InterfaceC3092b0
    public boolean t() {
        return this.c.t();
    }

    @Override // io.sentry.InterfaceC3092b0
    public io.sentry.transport.A w() {
        return this.c.w();
    }

    @Override // io.sentry.InterfaceC3092b0
    public io.sentry.protocol.v x(C3134j2 c3134j2, I i) {
        io.sentry.util.u.c(c3134j2, "SentryEnvelope is required.");
        if (i == null) {
            i = new I();
        }
        try {
            i.b();
            return M(c3134j2, i);
        } catch (IOException e) {
            this.b.getLogger().b(Y2.ERROR, "Failed to capture envelope.", e);
            return io.sentry.protocol.v.b;
        }
    }
}
