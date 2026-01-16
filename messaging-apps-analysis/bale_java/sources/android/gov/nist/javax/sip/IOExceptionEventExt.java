package android.gov.nist.javax.sip;

import ir.nasim.UZ2;

/* loaded from: classes.dex */
public class IOExceptionEventExt extends UZ2 {
    private final String myHost;
    private final int myPort;
    private Reason reason;

    public enum Reason {
        KeepAliveTimeout
    }

    public IOExceptionEventExt(Object obj, Reason reason, String str, int i, String str2, int i2, String str3) {
        super(obj, str2, i2, str3);
        this.myHost = str;
        this.myPort = i;
        this.reason = reason;
    }

    public String getLocalHost() {
        return this.myHost;
    }

    public int getLocalPort() {
        return this.myPort;
    }

    public String getPeerHost() {
        return getHost();
    }

    public int getPeerPort() {
        return getPort();
    }

    public Reason getReason() {
        return this.reason;
    }

    @Override // java.util.EventObject
    public String toString() {
        return "KeepAliveTimeoutEvent{myHost='" + this.myHost + "', myPort=" + this.myPort + ", peerHost='" + getHost() + "', peerPort=" + getPort() + ", transport='" + getTransport() + "'}";
    }
}
