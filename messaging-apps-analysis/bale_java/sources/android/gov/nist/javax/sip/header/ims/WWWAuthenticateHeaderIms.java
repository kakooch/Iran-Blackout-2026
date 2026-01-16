package android.gov.nist.javax.sip.header.ims;

import ir.nasim.InterfaceC21052t18;
import ir.nasim.InterfaceC21815uA7;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface WWWAuthenticateHeaderIms extends InterfaceC21052t18 {
    public static final String CK = "ck";
    public static final String IK = "ik";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    @Override // ir.nasim.InterfaceC21052t18
    /* synthetic */ String getAlgorithm();

    String getCK();

    /* synthetic */ String getDomain();

    String getIK();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC21052t18
    /* synthetic */ String getNonce();

    @Override // ir.nasim.InterfaceC21052t18
    /* synthetic */ String getOpaque();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // ir.nasim.InterfaceC21052t18
    /* synthetic */ String getQop();

    @Override // ir.nasim.InterfaceC21052t18
    /* synthetic */ String getRealm();

    @Override // ir.nasim.InterfaceC21052t18
    /* synthetic */ String getScheme();

    /* synthetic */ InterfaceC21815uA7 getURI();

    /* synthetic */ boolean isStale();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    /* synthetic */ void setAlgorithm(String str);

    void setCK(String str);

    /* synthetic */ void setDomain(String str);

    void setIK(String str);

    /* synthetic */ void setNonce(String str);

    /* synthetic */ void setOpaque(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    /* synthetic */ void setQop(String str);

    /* synthetic */ void setRealm(String str);

    /* synthetic */ void setScheme(String str);

    /* synthetic */ void setStale(boolean z);

    /* synthetic */ void setURI(InterfaceC21815uA7 interfaceC21815uA7);
}
