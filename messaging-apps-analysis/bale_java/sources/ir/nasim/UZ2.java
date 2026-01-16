package ir.nasim;

import java.util.EventObject;

/* loaded from: classes.dex */
public class UZ2 extends EventObject {
    private String m_host;
    private int m_port;
    private String m_transport;

    public UZ2(Object obj, String str, int i, String str2) {
        super(obj);
        this.m_host = str;
        this.m_port = i;
        this.m_transport = str2;
    }

    public String getHost() {
        return this.m_host;
    }

    public int getPort() {
        return this.m_port;
    }

    public String getTransport() {
        return this.m_transport;
    }
}
