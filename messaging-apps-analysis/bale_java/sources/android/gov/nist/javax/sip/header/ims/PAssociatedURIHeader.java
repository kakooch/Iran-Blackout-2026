package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;
import ir.nasim.IU2;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC20733sW4;
import ir.nasim.InterfaceC21815uA7;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PAssociatedURIHeader extends IU2, InterfaceC20733sW4, HU2 {
    public static final String NAME = "P-Associated-URI";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    @Override // ir.nasim.IU2
    /* synthetic */ InterfaceC16609la getAddress();

    InterfaceC21815uA7 getAssociatedURI();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    /* synthetic */ void setAddress(InterfaceC16609la interfaceC16609la);

    void setAssociatedURI(InterfaceC21815uA7 interfaceC21815uA7);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);
}
