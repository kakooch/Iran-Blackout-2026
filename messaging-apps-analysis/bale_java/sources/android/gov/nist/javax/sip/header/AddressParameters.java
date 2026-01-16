package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public interface AddressParameters extends InterfaceC20733sW4 {
    InterfaceC16609la getAddress();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    Map<String, Map.Entry<String, String>> getParameters();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setAddress(InterfaceC16609la interfaceC16609la);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);
}
