package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface SecurityAgreeHeader extends InterfaceC20733sW4, HU2 {
    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getAlgorithm();

    String getEncryptionAlgorithm();

    String getMode();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    int getPortClient();

    int getPortServer();

    float getPreference();

    String getProtocol();

    int getSPIClient();

    int getSPIServer();

    String getSecurityMechanism();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setAlgorithm(String str);

    void setEncryptionAlgorithm(String str);

    void setMode(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setPortClient(int i);

    void setPortServer(int i);

    void setPreference(float f);

    void setProtocol(String str);

    void setSPIClient(int i);

    void setSPIServer(int i);

    void setSecurityMechanism(String str);
}
