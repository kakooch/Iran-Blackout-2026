package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;

/* loaded from: classes2.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        int iB = new Requirements(extras.getInt("requirements")).b(this);
        if (iB == 0) {
            AbstractC9683aN7.U0(this, new Intent((String) AbstractC20011rK.e(extras.getString("service_action"))).setPackage((String) AbstractC20011rK.e(extras.getString("service_package"))));
            return false;
        }
        AbstractC18815pI3.k("PlatformScheduler", "Requirements not met: " + iB);
        jobFinished(jobParameters, true);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
