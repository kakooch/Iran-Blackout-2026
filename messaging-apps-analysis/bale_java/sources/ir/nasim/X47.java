package ir.nasim;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class X47 implements InterfaceC4435Fc6 {
    private static final String e = HI3.f("SystemJobScheduler");
    private final Context a;
    private final JobScheduler b;
    private final Za8 c;
    private final W47 d;

    public X47(Context context, Za8 za8) {
        this(context, za8, (JobScheduler) context.getSystemService("jobscheduler"), new W47(context));
    }

    public static void b(Context context) {
        List listG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (listG = g(context, jobScheduler)) == null || listG.isEmpty()) {
            return;
        }
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            d(jobScheduler, ((JobInfo) it.next()).getId());
        }
    }

    private static void d(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            HI3.c().b(e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    private static List e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> listG = g(context, jobScheduler);
        if (listG == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : listG) {
            if (str.equals(h(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            HI3.c().b(e, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, Za8 za8) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> listG = g(context, jobScheduler);
        List listC = za8.o().N().c();
        boolean z = false;
        HashSet hashSet = new HashSet(listG != null ? listG.size() : 0);
        if (listG != null && !listG.isEmpty()) {
            for (JobInfo jobInfo : listG) {
                String strH = h(jobInfo);
                if (TextUtils.isEmpty(strH)) {
                    d(jobScheduler, jobInfo.getId());
                } else {
                    hashSet.add(strH);
                }
            }
        }
        Iterator it = listC.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!hashSet.contains((String) it.next())) {
                HI3.c().a(e, "Reconciling jobs", new Throwable[0]);
                z = true;
                break;
            }
        }
        if (z) {
            WorkDatabase workDatabaseO = za8.o();
            workDatabaseO.e();
            try {
                InterfaceC18401ob8 interfaceC18401ob8Q = workDatabaseO.Q();
                Iterator it2 = listC.iterator();
                while (it2.hasNext()) {
                    interfaceC18401ob8Q.l((String) it2.next(), -1L);
                }
                workDatabaseO.F();
                workDatabaseO.j();
            } catch (Throwable th) {
                workDatabaseO.j();
                throw th;
            }
        }
        return z;
    }

    @Override // ir.nasim.InterfaceC4435Fc6
    public void a(String str) {
        List listE = e(this.a, this.b, str);
        if (listE == null || listE.isEmpty()) {
            return;
        }
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            d(this.b, ((Integer) it.next()).intValue());
        }
        this.c.o().N().d(str);
    }

    @Override // ir.nasim.InterfaceC4435Fc6
    public boolean c() {
        return true;
    }

    @Override // ir.nasim.InterfaceC4435Fc6
    public void f(C17810nb8... c17810nb8Arr) {
        WorkDatabase workDatabaseO = this.c.o();
        H03 h03 = new H03(workDatabaseO);
        for (C17810nb8 c17810nb8 : c17810nb8Arr) {
            workDatabaseO.e();
            try {
                C17810nb8 c17810nb8G = workDatabaseO.Q().g(c17810nb8.a);
                if (c17810nb8G == null) {
                    HI3.c().h(e, "Skipping scheduling " + c17810nb8.a + " because it's no longer in the DB", new Throwable[0]);
                    workDatabaseO.F();
                } else if (c17810nb8G.b != Ta8.ENQUEUED) {
                    HI3.c().h(e, "Skipping scheduling " + c17810nb8.a + " because it is no longer enqueued", new Throwable[0]);
                    workDatabaseO.F();
                } else {
                    O47 o47B = workDatabaseO.N().b(c17810nb8.a);
                    int iD = o47B != null ? o47B.b : h03.d(this.c.i().i(), this.c.i().g());
                    if (o47B == null) {
                        this.c.o().N().a(new O47(c17810nb8.a, iD));
                    }
                    j(c17810nb8, iD);
                    workDatabaseO.F();
                }
            } finally {
                workDatabaseO.j();
            }
        }
    }

    public void j(C17810nb8 c17810nb8, int i) {
        JobInfo jobInfoA = this.d.a(c17810nb8, i);
        HI3 hi3C = HI3.c();
        String str = e;
        hi3C.a(str, String.format("Scheduling work ID %s Job ID %s", c17810nb8.a, Integer.valueOf(i)), new Throwable[0]);
        try {
            if (this.b.schedule(jobInfoA) == 0) {
                HI3.c().h(str, String.format("Unable to schedule work ID %s", c17810nb8.a), new Throwable[0]);
                if (c17810nb8.q && c17810nb8.r == QM4.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    c17810nb8.q = false;
                    HI3.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", c17810nb8.a), new Throwable[0]);
                    j(c17810nb8, i);
                }
            }
        } catch (IllegalStateException e2) {
            List listG = g(this.a, this.b);
            String str2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(listG != null ? listG.size() : 0), Integer.valueOf(this.c.o().Q().d().size()), Integer.valueOf(this.c.i().h()));
            HI3.c().b(e, str2, new Throwable[0]);
            throw new IllegalStateException(str2, e2);
        } catch (Throwable th) {
            HI3.c().b(e, String.format("Unable to schedule %s", c17810nb8), th);
        }
    }

    public X47(Context context, Za8 za8, JobScheduler jobScheduler, W47 w47) {
        this.a = context;
        this.c = za8;
        this.b = jobScheduler;
        this.d = w47;
    }
}
