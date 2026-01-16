package org.acra.sender;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.JobIntentService;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.acra.ACRA;
import org.acra.collections.ImmutableList;
import org.acra.config.CoreConfiguration;
import org.acra.file.CrashReportFileNameParser;
import org.acra.file.ReportLocator;
import org.acra.util.InstanceCreator;
import org.acra.util.ToastSender;

/* loaded from: classes.dex */
public class SenderService extends JobIntentService {
    private final ReportLocator locator = new ReportLocator(this);

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        if (!intent.hasExtra("acraConfig")) {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "SenderService was started but no valid intent was delivered, will now quit");
                return;
            }
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("onlySendSilentReports", false);
        CoreConfiguration coreConfiguration = (CoreConfiguration) intent.getSerializableExtra("acraConfig");
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "About to start sending reports from SenderService");
        }
        try {
            List<ReportSender> senderInstances = getSenderInstances(coreConfiguration);
            File[] approvedReports = this.locator.getApprovedReports();
            ReportDistributor reportDistributor = new ReportDistributor(this, coreConfiguration, senderInstances);
            CrashReportFileNameParser crashReportFileNameParser = new CrashReportFileNameParser();
            int i = 0;
            boolean z = false;
            for (File file : approvedReports) {
                boolean z2 = !crashReportFileNameParser.isSilent(file.getName());
                if (!booleanExtra || !z2) {
                    z |= z2;
                    if (i >= 5) {
                        break;
                    } else if (reportDistributor.distribute(file)) {
                        i++;
                    }
                }
            }
            if (z) {
                final String strReportSendSuccessToast = i > 0 ? coreConfiguration.reportSendSuccessToast() : coreConfiguration.reportSendFailureToast();
                if (strReportSendSuccessToast != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: org.acra.sender.-$$Lambda$SenderService$f8Vy6oVjYlbZobkLAebzyL9bFSc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onHandleWork$0$SenderService(strReportSendSuccessToast);
                        }
                    });
                }
            }
        } catch (Exception e) {
            ACRA.log.e(ACRA.LOG_TAG, "", e);
        }
        if (ACRA.DEV_LOGGING) {
            ACRA.log.d(ACRA.LOG_TAG, "Finished sending reports from SenderService");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onHandleWork$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onHandleWork$0$SenderService(String str) {
        ToastSender.sendToast(this, str, 1);
    }

    private List<ReportSender> getSenderInstances(CoreConfiguration coreConfiguration) {
        ImmutableList<Class<? extends ReportSenderFactory>> immutableListReportSenderFactoryClasses = coreConfiguration.reportSenderFactoryClasses();
        List listCreate = !immutableListReportSenderFactoryClasses.isEmpty() ? new InstanceCreator().create(immutableListReportSenderFactoryClasses) : coreConfiguration.pluginLoader().loadEnabled(coreConfiguration, ReportSenderFactory.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = listCreate.iterator();
        while (it.hasNext()) {
            arrayList.add(((ReportSenderFactory) it.next()).create(getApplication(), coreConfiguration));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new NullSender());
        }
        return arrayList;
    }
}
