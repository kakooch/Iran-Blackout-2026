package ir.nasim;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* renamed from: ir.nasim.kj3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16112kj3 implements InterfaceC16628lb8 {
    private final Context a;
    private final InterfaceC13031fb2 b;
    private final AbstractC4684Gc6 c;

    public C16112kj3(Context context, InterfaceC13031fb2 interfaceC13031fb2, AbstractC4684Gc6 abstractC4684Gc6) {
        this.a = context;
        this.b = interfaceC13031fb2;
        this.c = abstractC4684Gc6;
    }

    private boolean d(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC16628lb8
    public void a(AbstractC5792Kv7 abstractC5792Kv7, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int iC = c(abstractC5792Kv7);
        if (!z && d(jobScheduler, iC, i)) {
            SI3.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", abstractC5792Kv7);
            return;
        }
        long jC1 = this.b.c1(abstractC5792Kv7);
        JobInfo.Builder builderC = this.c.c(new JobInfo.Builder(iC, componentName), abstractC5792Kv7.d(), jC1, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", abstractC5792Kv7.b());
        persistableBundle.putInt("priority", AbstractC6945Pq5.a(abstractC5792Kv7.d()));
        if (abstractC5792Kv7.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(abstractC5792Kv7.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        SI3.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", abstractC5792Kv7, Integer.valueOf(iC), Long.valueOf(this.c.g(abstractC5792Kv7.d(), jC1, i)), Long.valueOf(jC1), Integer.valueOf(i));
        jobScheduler.schedule(builderC.build());
    }

    @Override // ir.nasim.InterfaceC16628lb8
    public void b(AbstractC5792Kv7 abstractC5792Kv7, int i) {
        a(abstractC5792Kv7, i, false);
    }

    int c(AbstractC5792Kv7 abstractC5792Kv7) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(abstractC5792Kv7.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(AbstractC6945Pq5.a(abstractC5792Kv7.d())).array());
        if (abstractC5792Kv7.c() != null) {
            adler32.update(abstractC5792Kv7.c());
        }
        return (int) adler32.getValue();
    }
}
