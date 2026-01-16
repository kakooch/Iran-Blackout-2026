package androidMessenger.timerHelper;

import ir.aaap.messengercore.TimerHelper;
import org.rbmain.messenger.Utilities;

/* loaded from: classes.dex */
public class TimerHelperImpl implements TimerHelper {
    @Override // ir.aaap.messengercore.TimerHelper
    public void postRunnableDelayed(Runnable runnable, long j) {
        if (runnable != null) {
            Utilities.coreQueue.postRunnable(runnable, j);
        }
    }

    @Override // ir.aaap.messengercore.TimerHelper
    public void cancelRunnable(Runnable runnable) {
        if (runnable != null) {
            Utilities.coreQueue.cancelRunnable(runnable);
        }
    }
}
