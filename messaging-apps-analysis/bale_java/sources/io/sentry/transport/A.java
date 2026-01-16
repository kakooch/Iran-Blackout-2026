package io.sentry.transport;

import android.gov.nist.core.Separators;
import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.EnumC3136k;
import io.sentry.I;
import io.sentry.InterfaceC3102d0;
import io.sentry.J2;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import io.sentry.util.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class A implements Closeable {
    private final p a;
    private final C3155n3 b;
    private final Map c;
    private final List d;
    private Timer e;
    private final C3202a f;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            A.this.y();
        }
    }

    public interface b {
        void g(A a);
    }

    public A(p pVar, C3155n3 c3155n3) {
        this.c = new ConcurrentHashMap();
        this.d = new CopyOnWriteArrayList();
        this.e = null;
        this.f = new C3202a();
        this.a = pVar;
        this.b = c3155n3;
    }

    private void g(EnumC3136k enumC3136k, Date date) {
        Date date2 = (Date) this.c.get(enumC3136k);
        if (date2 == null || date.after(date2)) {
            this.c.put(enumC3136k, date);
            y();
            InterfaceC3102d0 interfaceC3102d0A = this.f.a();
            try {
                if (this.e == null) {
                    this.e = new Timer(true);
                }
                this.e.schedule(new a(), date);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private EnumC3136k k(String str) {
        str.hashCode();
        switch (str) {
            case "attachment":
                return EnumC3136k.Attachment;
            case "replay_video":
                return EnumC3136k.Replay;
            case "profile_chunk":
                return EnumC3136k.ProfileChunkUi;
            case "profile":
                return EnumC3136k.Profile;
            case "feedback":
                return EnumC3136k.Feedback;
            case "log":
                return EnumC3136k.LogItem;
            case "event":
                return EnumC3136k.Error;
            case "check_in":
                return EnumC3136k.Monitor;
            case "session":
                return EnumC3136k.Session;
            case "transaction":
                return EnumC3136k.Transaction;
            default:
                return EnumC3136k.Unknown;
        }
    }

    private boolean n(String str) {
        return l(k(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(io.sentry.hints.f fVar) {
        fVar.d();
        this.b.getLogger().c(Y2.DEBUG, "Disk flush envelope fired due to rate limit", new Object[0]);
    }

    private void u(I i, final boolean z) {
        io.sentry.util.m.o(i, io.sentry.hints.p.class, new m.a() { // from class: io.sentry.transport.x
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.p) obj).c(false);
            }
        });
        io.sentry.util.m.o(i, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.y
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.k) obj).d(z);
            }
        });
        io.sentry.util.m.o(i, io.sentry.hints.f.class, new m.a() { // from class: io.sentry.transport.z
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                this.a.s((io.sentry.hints.f) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).g(this);
        }
    }

    private long z(String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return 60000L;
    }

    public void G(b bVar) {
        this.d.remove(bVar);
    }

    public void H(String str, String str2, int i) {
        if (str == null) {
            if (i == 429) {
                g(EnumC3136k.All, new Date(this.a.a() + z(str2)));
                return;
            }
            return;
        }
        for (String str3 : str.split(",", -1)) {
            String[] strArrSplit = str3.replace(Separators.SP, "").split(":", -1);
            if (strArrSplit.length > 0) {
                long jZ = z(strArrSplit[0]);
                if (strArrSplit.length > 1) {
                    String str4 = strArrSplit[1];
                    Date date = new Date(this.a.a() + jZ);
                    if (str4 == null || str4.isEmpty()) {
                        g(EnumC3136k.All, date);
                    } else {
                        for (String str5 : str4.split(Separators.SEMICOLON, -1)) {
                            EnumC3136k enumC3136kValueOf = EnumC3136k.Unknown;
                            try {
                                String strB = io.sentry.util.B.b(str5);
                                if (strB != null) {
                                    enumC3136kValueOf = EnumC3136k.valueOf(strB);
                                } else {
                                    this.b.getLogger().c(Y2.ERROR, "Couldn't capitalize: %s", str5);
                                }
                            } catch (IllegalArgumentException e) {
                                this.b.getLogger().a(Y2.INFO, e, "Unknown category: %s", str5);
                            }
                            if (!EnumC3136k.Unknown.equals(enumC3136kValueOf)) {
                                g(enumC3136kValueOf, date);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            this.d.clear();
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void e(b bVar) {
        this.d.add(bVar);
    }

    public C3134j2 j(C3134j2 c3134j2, I i) {
        ArrayList arrayList = null;
        for (J2 j2 : c3134j2.c()) {
            if (n(j2.J().b().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(j2);
                this.b.getClientReportRecorder().d(io.sentry.clientreport.f.RATELIMIT_BACKOFF, j2);
            }
        }
        if (arrayList == null) {
            return c3134j2;
        }
        this.b.getLogger().c(Y2.WARNING, "%d envelope items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        for (J2 j22 : c3134j2.c()) {
            if (!arrayList.contains(j22)) {
                arrayList2.add(j22);
            }
        }
        if (!arrayList2.isEmpty()) {
            return new C3134j2(c3134j2.b(), arrayList2);
        }
        this.b.getLogger().c(Y2.WARNING, "Envelope discarded due all items rate limited.", new Object[0]);
        u(i, false);
        return null;
    }

    public boolean l(EnumC3136k enumC3136k) {
        Date date;
        Date date2 = new Date(this.a.a());
        Date date3 = (Date) this.c.get(EnumC3136k.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (EnumC3136k.Unknown.equals(enumC3136k) || (date = (Date) this.c.get(enumC3136k)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    public boolean m() {
        Date date = new Date(this.a.a());
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            Date date2 = (Date) this.c.get((EnumC3136k) it.next());
            if (date2 != null && !date.after(date2)) {
                return true;
            }
        }
        return false;
    }

    public A(C3155n3 c3155n3) {
        this(n.b(), c3155n3);
    }
}
