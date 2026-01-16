package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import ir.nasim.C13258fv2;
import ir.nasim.C17810nb8;
import ir.nasim.HI3;
import ir.nasim.InterfaceC5684Kj7;
import ir.nasim.InterfaceC9244Zc2;
import ir.nasim.Ma8;
import ir.nasim.Na8;
import ir.nasim.Za8;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public class a implements Ma8, InterfaceC9244Zc2 {
    static final String k = HI3.f("SystemFgDispatcher");
    private Context a;
    private Za8 b;
    private final InterfaceC5684Kj7 c;
    final Object d = new Object();
    String e;
    final Map f;
    final Map g;
    final Set h;
    final Na8 i;
    private b j;

    /* renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    class RunnableC0137a implements Runnable {
        final /* synthetic */ WorkDatabase a;
        final /* synthetic */ String b;

        RunnableC0137a(WorkDatabase workDatabase, String str) {
            this.a = workDatabase;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C17810nb8 c17810nb8G = this.a.Q().g(this.b);
            if (c17810nb8G == null || !c17810nb8G.b()) {
                return;
            }
            synchronized (a.this.d) {
                a.this.g.put(this.b, c17810nb8G);
                a.this.h.add(c17810nb8G);
                a aVar = a.this;
                aVar.i.d(aVar.h);
            }
        }
    }

    interface b {
        void a(int i, Notification notification);

        void c(int i, int i2, Notification notification);

        void d(int i);

        void stop();
    }

    a(Context context) {
        this.a = context;
        Za8 za8K = Za8.k(context);
        this.b = za8K;
        InterfaceC5684Kj7 interfaceC5684Kj7P = za8K.p();
        this.c = interfaceC5684Kj7P;
        this.e = null;
        this.f = new LinkedHashMap();
        this.h = new HashSet();
        this.g = new HashMap();
        this.i = new Na8(this.a, interfaceC5684Kj7P, this);
        this.b.m().c(this);
    }

    public static Intent a(Context context, String str, C13258fv2 c13258fv2) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", c13258fv2.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", c13258fv2.a());
        intent.putExtra("KEY_NOTIFICATION", c13258fv2.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, C13258fv2 c13258fv2) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", c13258fv2.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", c13258fv2.a());
        intent.putExtra("KEY_NOTIFICATION", c13258fv2.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        HI3.c().d(k, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.b.f(UUID.fromString(stringExtra));
    }

    private void h(Intent intent) {
        int iA = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        HI3.c().a(k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.j == null) {
            return;
        }
        this.f.put(stringExtra, new C13258fv2(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.e)) {
            this.e = stringExtra;
            this.j.c(intExtra, intExtra2, notification);
            return;
        }
        this.j.a(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            iA |= ((C13258fv2) ((Map.Entry) it.next()).getValue()).a();
        }
        C13258fv2 c13258fv2 = (C13258fv2) this.f.get(this.e);
        if (c13258fv2 != null) {
            this.j.c(c13258fv2.c(), iA, c13258fv2.b());
        }
    }

    private void i(Intent intent) {
        HI3.c().d(k, String.format("Started foreground service %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        this.c.b(new RunnableC0137a(this.b.o(), stringExtra));
    }

    @Override // ir.nasim.Ma8
    public void b(List list) {
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            HI3.c().a(k, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            this.b.w(str);
        }
    }

    @Override // ir.nasim.InterfaceC9244Zc2
    public void d(String str, boolean z) {
        Map.Entry entry;
        synchronized (this.d) {
            try {
                C17810nb8 c17810nb8 = (C17810nb8) this.g.remove(str);
                if (c17810nb8 != null ? this.h.remove(c17810nb8) : false) {
                    this.i.d(this.h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C13258fv2 c13258fv2 = (C13258fv2) this.f.remove(str);
        if (str.equals(this.e) && this.f.size() > 0) {
            Iterator it = this.f.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.e = (String) entry.getKey();
            if (this.j != null) {
                C13258fv2 c13258fv22 = (C13258fv2) entry.getValue();
                this.j.c(c13258fv22.c(), c13258fv22.a(), c13258fv22.b());
                this.j.d(c13258fv22.c());
            }
        }
        b bVar = this.j;
        if (c13258fv2 == null || bVar == null) {
            return;
        }
        HI3.c().a(k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(c13258fv2.c()), str, Integer.valueOf(c13258fv2.a())), new Throwable[0]);
        bVar.d(c13258fv2.c());
    }

    @Override // ir.nasim.Ma8
    public void e(List list) {
    }

    void j(Intent intent) {
        HI3.c().d(k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    void k() {
        this.j = null;
        synchronized (this.d) {
            this.i.e();
        }
        this.b.m().i(this);
    }

    void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    void m(b bVar) {
        if (this.j != null) {
            HI3.c().b(k, "A callback already exists.", new Throwable[0]);
        } else {
            this.j = bVar;
        }
    }
}
