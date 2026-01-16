package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.core.Token;
import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PVisitedNetworkIDHeader extends InterfaceC20733sW4, HU2 {
    public static final String NAME = "P-Visited-Network-ID";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    String getVisitedNetworkID();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setVisitedNetworkID(Token token);

    void setVisitedNetworkID(String str);
}
