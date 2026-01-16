package org.linphone.core;

/* loaded from: classes3.dex */
public interface Tunnel {
    void addServer(TunnelConfig tunnelConfig);

    void cleanServers();

    boolean connected();

    boolean getActivated();

    String getDomain();

    Mode getMode();

    long getNativePointer();

    TunnelConfig[] getServers();

    Object getUserData();

    String getUsername();

    boolean isDualModeEnabled();

    boolean isSipEnabled();

    void reconnect();

    void removeServer(TunnelConfig tunnelConfig);

    void setDomain(String str);

    void setDualModeEnabled(boolean z);

    void setHttpProxy(String str, int i, String str2, String str3);

    void setHttpProxyAuthInfo(String str, String str2);

    void setMode(Mode mode);

    void setSipEnabled(boolean z);

    void setUserData(Object obj);

    void setUsername(String str);

    String toString();

    public enum Mode {
        Disable(0),
        Enable(1),
        Auto(2);

        protected final int mValue;

        Mode(int i) {
            this.mValue = i;
        }

        public static Mode fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Disable;
            }
            if (i == 1) {
                return Enable;
            }
            if (i == 2) {
                return Auto;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for Mode");
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
