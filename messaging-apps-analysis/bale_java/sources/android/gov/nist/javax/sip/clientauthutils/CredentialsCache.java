package android.gov.nist.javax.sip.clientauthutils;

import android.gov.nist.javax.sip.stack.SIPStackTimerTask;
import android.gov.nist.javax.sip.stack.timers.SipTimer;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.VR;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class CredentialsCache {
    private ConcurrentHashMap<String, List<VR>> authorizationHeaders = new ConcurrentHashMap<>();
    private SipTimer timer;

    class TimeoutTask extends SIPStackTimerTask {
        String callId;
        String userName;

        public TimeoutTask(String str, String str2) {
            this.callId = str2;
            this.userName = str;
        }

        @Override // android.gov.nist.javax.sip.ThreadAffinityIdentifier
        public Object getThreadHash() {
            return null;
        }

        @Override // android.gov.nist.javax.sip.stack.SIPStackTimerTask
        public void runTask() {
            CredentialsCache.this.authorizationHeaders.remove(this.callId);
        }
    }

    CredentialsCache(SipTimer sipTimer) {
        this.timer = sipTimer;
    }

    void cacheAuthorizationHeader(String str, VR vr, int i) {
        String username = vr.getUsername();
        if (str == null) {
            throw new NullPointerException("Call ID is null!");
        }
        List<VR> linkedList = this.authorizationHeaders.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.authorizationHeaders.put(str, linkedList);
        } else {
            String realm = vr.getRealm();
            ListIterator<VR> listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                if (realm.equals(listIterator.next().getRealm())) {
                    listIterator.remove();
                }
            }
        }
        linkedList.add(vr);
        TimeoutTask timeoutTask = new TimeoutTask(str, username);
        if (i != -1) {
            this.timer.schedule(timeoutTask, i * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
    }

    Collection<VR> getCachedAuthorizationHeaders(String str) {
        if (str != null) {
            return this.authorizationHeaders.get(str);
        }
        throw new NullPointerException("Null arg!");
    }

    public void removeAuthenticationHeader(String str) {
        this.authorizationHeaders.remove(str);
    }
}
