package org.linphone.core;

/* loaded from: classes3.dex */
public interface ConferenceInfo {
    void addParticipant(Address address);

    /* renamed from: clone */
    ConferenceInfo mo46clone();

    long getDateTime();

    String getDescription();

    int getDuration();

    String getIcalendarString();

    long getNativePointer();

    Address getOrganizer();

    Address[] getParticipants();

    State getState();

    String getSubject();

    Address getUri();

    Object getUserData();

    void removeParticipant(Address address);

    void setDateTime(long j);

    void setDescription(String str);

    void setDuration(int i);

    void setOrganizer(Address address);

    void setParticipants(Address[] addressArr);

    void setSubject(String str);

    void setUserData(Object obj);

    String toString();

    public enum State {
        New(0),
        Updated(1),
        Cancelled(2);

        protected final int mValue;

        State(int i) {
            this.mValue = i;
        }

        public static State fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return New;
            }
            if (i == 1) {
                return Updated;
            }
            if (i == 2) {
                return Cancelled;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for State");
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
