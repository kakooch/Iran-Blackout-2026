package android.gov.nist.javax.sip.header.extensions;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface JoinHeader extends InterfaceC20733sW4, HU2 {
    public static final String NAME = "Join";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getCallId();

    String getFromTag();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    String getToTag();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setCallId(String str);

    void setFromTag(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setToTag(String str);
}
