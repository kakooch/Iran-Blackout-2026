package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PUserDatabaseHeader extends InterfaceC20733sW4, HU2 {
    public static final String NAME = "P-User-Database";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getDatabaseName();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setDatabaseName(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);
}
