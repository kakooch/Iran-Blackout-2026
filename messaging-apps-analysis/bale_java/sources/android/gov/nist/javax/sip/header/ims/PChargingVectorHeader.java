package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PChargingVectorHeader extends HU2, InterfaceC20733sW4 {
    public static final String NAME = "P-Charging-Vector";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getICID();

    String getICIDGeneratedAt();

    /* synthetic */ String getName();

    String getOriginatingIOI();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    String getTerminatingIOI();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setICID(String str);

    void setICIDGeneratedAt(String str);

    void setOriginatingIOI(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setTerminatingIOI(String str);
}
