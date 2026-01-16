package android.gov.nist.javax.sip.header.extensions;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import ir.nasim.InterfaceC5634Ke2;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface SessionExpiresHeader extends InterfaceC20733sW4, HU2, InterfaceC5634Ke2 {
    public static final String NAME = "Session-Expires";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    int getExpires();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    String getRefresher();

    /* synthetic */ String getValue();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setExpires(int i);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setRefresher(String str);

    /* synthetic */ void setValue(String str);
}
