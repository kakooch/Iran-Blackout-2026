package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import ir.nasim.HI3;
import ir.nasim.InterfaceC9244Zc2;
import ir.nasim.Za8;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SystemJobService extends JobService implements InterfaceC9244Zc2 {
    private static final String c = HI3.f("SystemJobService");
    private Za8 a;
    private final Map b = new HashMap();

    private static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // ir.nasim.InterfaceC9244Zc2
    public void d(String str, boolean z) {
        JobParameters jobParameters;
        HI3.c().a(c, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.b) {
            jobParameters = (JobParameters) this.b.remove(str);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            Za8 za8K = Za8.k(getApplicationContext());
            this.a = za8K;
            za8K.m().c(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            HI3.c().h(c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Za8 za8 = this.a;
        if (za8 != null) {
            za8.m().i(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.a == null) {
            HI3.c().a(c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String strA = a(jobParameters);
        if (TextUtils.isEmpty(strA)) {
            HI3.c().b(c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.b) {
            try {
                if (this.b.containsKey(strA)) {
                    HI3.c().a(c, String.format("Job is already being executed by SystemJobService: %s", strA), new Throwable[0]);
                    return false;
                }
                HI3.c().a(c, String.format("onStartJob for %s", strA), new Throwable[0]);
                this.b.put(strA, jobParameters);
                int i = Build.VERSION.SDK_INT;
                WorkerParameters.a aVar = new WorkerParameters.a();
                if (jobParameters.getTriggeredContentUris() != null) {
                    aVar.b = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    aVar.a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (i >= 28) {
                    aVar.c = jobParameters.getNetwork();
                }
                this.a.v(strA, aVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.a == null) {
            HI3.c().a(c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String strA = a(jobParameters);
        if (TextUtils.isEmpty(strA)) {
            HI3.c().b(c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        HI3.c().a(c, String.format("onStopJob for %s", strA), new Throwable[0]);
        synchronized (this.b) {
            this.b.remove(strA);
        }
        this.a.x(strA);
        return !this.a.m().f(strA);
    }
}
