package org.linphone.core;

import org.linphone.core.ConferenceScheduler;

/* loaded from: classes3.dex */
public interface ConferenceSchedulerListener {
    void onInvitationsSent(ConferenceScheduler conferenceScheduler, Address[] addressArr);

    void onStateChanged(ConferenceScheduler conferenceScheduler, ConferenceScheduler.State state);
}
