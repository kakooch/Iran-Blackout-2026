package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.ThreadAffinityIdentifier;

/* loaded from: classes.dex */
public abstract class SIPStackTimerTask implements ThreadAffinityIdentifier {
    Object timerTask = null;

    public void cleanUpBeforeCancel() {
    }

    public Object getSipTimerTask() {
        return this.timerTask;
    }

    public abstract void runTask();

    public void setSipTimerTask(Object obj) {
        this.timerTask = obj;
    }
}
