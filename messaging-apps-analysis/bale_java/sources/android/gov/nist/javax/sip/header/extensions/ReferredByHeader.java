package android.gov.nist.javax.sip.header.extensions;

import ir.nasim.HU2;
import ir.nasim.IU2;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface ReferredByHeader extends IU2, InterfaceC20733sW4, HU2 {
    public static final String NAME = "Referred-By";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    @Override // ir.nasim.IU2
    /* synthetic */ InterfaceC16609la getAddress();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    /* synthetic */ void setAddress(InterfaceC16609la interfaceC16609la);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);
}
