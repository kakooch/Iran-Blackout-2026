package ir.nasim;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface ND6 extends InterfaceC21815uA7, InterfaceC20733sW4 {
    String getHeader(String str);

    Iterator getHeaderNames();

    String getHost();

    String getMAddrParam();

    String getMethodParam();

    int getPort();

    int getTTLParam();

    String getTransportParam();

    String getUser();

    String getUserParam();

    String getUserPassword();

    boolean hasLrParam();

    boolean isSecure();

    void setHost(String str);

    void setMAddrParam(String str);

    void setPort(int i);

    void setSecure(boolean z);

    void setTransportParam(String str);

    void setUser(String str);
}
