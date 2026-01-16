package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC21815uA7;

/* loaded from: classes.dex */
public interface SipRequestLine {
    String getMethod();

    String getSipVersion();

    InterfaceC21815uA7 getUri();

    String getVersionMajor();

    String getVersionMinor();

    void setMethod(String str);

    void setSipVersion(String str);

    void setUri(InterfaceC21815uA7 interfaceC21815uA7);
}
