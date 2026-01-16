package org.linphone.core;

/* loaded from: classes3.dex */
public interface Player {
    void addListener(PlayerListener playerListener);

    void close();

    Object createWindowId();

    Core getCore();

    int getCurrentPosition();

    int getDuration();

    boolean getIsVideoAvailable();

    long getNativePointer();

    State getState();

    Object getUserData();

    float getVolumeGain();

    int open(String str);

    int pause();

    void removeListener(PlayerListener playerListener);

    int seek(int i);

    void setUserData(Object obj);

    void setVolumeGain(float f);

    void setWindowId(Object obj);

    int start();

    String toString();

    public enum State {
        Closed(0),
        Paused(1),
        Playing(2);

        protected final int mValue;

        State(int i) {
            this.mValue = i;
        }

        public static State fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Closed;
            }
            if (i == 1) {
                return Paused;
            }
            if (i == 2) {
                return Playing;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for State");
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
