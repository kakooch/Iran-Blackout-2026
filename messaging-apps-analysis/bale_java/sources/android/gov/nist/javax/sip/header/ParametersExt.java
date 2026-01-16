package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface ParametersExt extends InterfaceC20733sW4 {
    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    String getParameter(String str, boolean z);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setQuotedParameter(String str, String str2);
}
