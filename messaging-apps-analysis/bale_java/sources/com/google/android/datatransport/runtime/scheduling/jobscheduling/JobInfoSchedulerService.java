package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import ir.nasim.AbstractC5792Kv7;
import ir.nasim.AbstractC6945Pq5;
import ir.nasim.C7470Rv7;

/* loaded from: classes2.dex */
public class JobInfoSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        C7470Rv7.f(getApplicationContext());
        AbstractC5792Kv7.a aVarD = AbstractC5792Kv7.a().b(string).d(AbstractC6945Pq5.b(i));
        if (string2 != null) {
            aVarD.c(Base64.decode(string2, 0));
        }
        C7470Rv7.c().e().v(aVarD.a(), i2, new Runnable() { // from class: ir.nasim.lj3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
