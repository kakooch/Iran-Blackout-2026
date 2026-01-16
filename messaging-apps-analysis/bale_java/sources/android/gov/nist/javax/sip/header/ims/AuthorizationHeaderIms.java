package android.gov.nist.javax.sip.header.ims;

import ir.nasim.InterfaceC21815uA7;
import ir.nasim.VR;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface AuthorizationHeaderIms extends VR {
    public static final String NO = "no";
    public static final String YES = "yes";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    /* synthetic */ String getAlgorithm();

    @Override // ir.nasim.VR
    /* synthetic */ String getCNonce();

    String getIntegrityProtected();

    /* synthetic */ String getName();

    @Override // ir.nasim.VR
    /* synthetic */ String getNonce();

    /* synthetic */ int getNonceCount();

    /* synthetic */ String getOpaque();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    /* synthetic */ String getQop();

    @Override // ir.nasim.VR
    /* synthetic */ String getRealm();

    @Override // ir.nasim.VR
    /* synthetic */ String getResponse();

    /* synthetic */ String getScheme();

    @Override // ir.nasim.VR
    /* synthetic */ InterfaceC21815uA7 getURI();

    @Override // ir.nasim.VR
    /* synthetic */ String getUsername();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    @Override // ir.nasim.VR
    /* synthetic */ void setAlgorithm(String str);

    @Override // ir.nasim.VR
    /* synthetic */ void setCNonce(String str);

    void setIntegrityProtected(String str);

    @Override // ir.nasim.VR
    /* synthetic */ void setNonce(String str);

    @Override // ir.nasim.VR
    /* synthetic */ void setNonceCount(int i);

    @Override // ir.nasim.VR
    /* synthetic */ void setOpaque(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    @Override // ir.nasim.VR
    /* synthetic */ void setQop(String str);

    @Override // ir.nasim.VR
    /* synthetic */ void setRealm(String str);

    @Override // ir.nasim.VR
    /* synthetic */ void setResponse(String str);

    /* synthetic */ void setScheme(String str);

    /* synthetic */ void setURI(InterfaceC21815uA7 interfaceC21815uA7);

    @Override // ir.nasim.VR
    /* synthetic */ void setUsername(String str);
}
