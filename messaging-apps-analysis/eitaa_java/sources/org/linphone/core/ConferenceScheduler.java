package org.linphone.core;

/* loaded from: classes3.dex */
public interface ConferenceScheduler {
    void addListener(ConferenceSchedulerListener conferenceSchedulerListener);

    void cancelConference(ConferenceInfo conferenceInfo);

    Account getAccount();

    Core getCore();

    ConferenceInfo getInfo();

    long getNativePointer();

    Object getUserData();

    void removeListener(ConferenceSchedulerListener conferenceSchedulerListener);

    void sendInvitations(ChatRoomParams chatRoomParams);

    void setAccount(Account account);

    void setInfo(ConferenceInfo conferenceInfo);

    void setUserData(Object obj);

    String toString();

    public enum State {
        Idle(0),
        Error(1),
        AllocationPending(2),
        Ready(3),
        Updating(4);

        protected final int mValue;

        State(int i) {
            this.mValue = i;
        }

        public static State fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Idle;
            }
            if (i == 1) {
                return Error;
            }
            if (i == 2) {
                return AllocationPending;
            }
            if (i == 3) {
                return Ready;
            }
            if (i == 4) {
                return Updating;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for State");
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
