package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.m47, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16914m47 extends Thread {
    private WeakReference a;

    /* renamed from: ir.nasim.m47$a */
    public interface a {
        void d(long j);
    }

    public C16914m47(a aVar) {
        this.a = new WeakReference(aVar);
        setPriority(1);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        C22674ve2 c22674ve2 = new C22674ve2(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND, 180000, 50);
        C18809pH6 c18809pH6 = new C18809pH6();
        while (true) {
            try {
            } catch (Exception e) {
                C19406qI3.d("SyncTimeThread", e);
                c22674ve2.b();
            }
            if (c18809pH6.d("europe.pool.ntp.org", AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND)) {
                C19406qI3.a("SyncTimeThread", "Time synced successfully.", new Object[0]);
                break;
            }
            C19406qI3.a("SyncTimeThread", "Time synced failed.", new Object[0]);
            c22674ve2.b();
            long jA = c22674ve2.a();
            C19406qI3.a("SyncTimeThread", "Next attempt in " + jA + " ms", new Object[0]);
            try {
                Thread.sleep(jA);
            } catch (InterruptedException unused) {
            }
        }
        long jA2 = c18809pH6.a();
        C19406qI3.a("SyncTimeThread", "Synced. Time delta: " + jA2 + " ms", new Object[0]);
        a aVar = (a) this.a.get();
        if (aVar != null) {
            aVar.d(jA2);
        }
    }
}
