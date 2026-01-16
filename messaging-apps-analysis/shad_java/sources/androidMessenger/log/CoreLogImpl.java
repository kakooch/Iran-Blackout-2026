package androidMessenger.log;

import androidMessenger.utilites.MyLog;
import ir.aaap.messengercore.utilites.CoreLog;
import ir.resaneh1.iptv.helper.FirebaseEventSender;

/* loaded from: classes.dex */
public class CoreLogImpl implements CoreLog {
    @Override // ir.aaap.messengercore.utilites.CoreLog
    public void e(String str, String str2) {
        MyLog.e(str, str2);
    }

    @Override // ir.aaap.messengercore.utilites.CoreLog
    public void handleException(Throwable th) {
        MyLog.handleException(th);
    }

    @Override // ir.aaap.messengercore.utilites.CoreLog
    public void recordFireBaseException(Exception exc) {
        FirebaseEventSender.recordException(exc);
    }

    @Override // ir.aaap.messengercore.utilites.CoreLog
    public boolean isDebug() {
        return MyLog.isDebugAble;
    }
}
