package android.gov.nist.javax.sip.address;

import ir.nasim.ND6;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface SipURIExt extends ND6 {
    @Override // ir.nasim.InterfaceC21815uA7
    /* synthetic */ Object clone();

    @Override // ir.nasim.ND6
    /* synthetic */ String getHeader(String str);

    @Override // ir.nasim.ND6
    /* synthetic */ Iterator getHeaderNames();

    @Override // ir.nasim.ND6
    /* synthetic */ String getHost();

    @Override // ir.nasim.ND6
    /* synthetic */ String getMAddrParam();

    @Override // ir.nasim.ND6
    /* synthetic */ String getMethodParam();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // ir.nasim.ND6
    /* synthetic */ int getPort();

    @Override // ir.nasim.InterfaceC21815uA7
    /* synthetic */ String getScheme();

    @Override // ir.nasim.ND6
    /* synthetic */ int getTTLParam();

    @Override // ir.nasim.ND6
    /* synthetic */ String getTransportParam();

    @Override // ir.nasim.ND6
    /* synthetic */ String getUser();

    @Override // ir.nasim.ND6
    /* synthetic */ String getUserParam();

    @Override // ir.nasim.ND6
    /* synthetic */ String getUserPassword();

    boolean hasGrParam();

    @Override // ir.nasim.ND6
    boolean hasLrParam();

    @Override // ir.nasim.ND6
    /* synthetic */ boolean isSecure();

    @Override // ir.nasim.InterfaceC21815uA7
    /* synthetic */ boolean isSipURI();

    void removeHeader(String str);

    void removeHeaders();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    /* synthetic */ void removePort();

    void setGrParam(String str);

    /* synthetic */ void setHeader(String str, String str2);

    @Override // ir.nasim.ND6
    /* synthetic */ void setHost(String str);

    void setLrParam();

    @Override // ir.nasim.ND6
    /* synthetic */ void setMAddrParam(String str);

    /* synthetic */ void setMethodParam(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    @Override // ir.nasim.ND6
    /* synthetic */ void setPort(int i);

    @Override // ir.nasim.ND6
    /* synthetic */ void setSecure(boolean z);

    /* synthetic */ void setTTLParam(int i);

    @Override // ir.nasim.ND6
    /* synthetic */ void setTransportParam(String str);

    @Override // ir.nasim.ND6
    /* synthetic */ void setUser(String str);

    /* synthetic */ void setUserParam(String str);

    /* synthetic */ void setUserPassword(String str);
}
