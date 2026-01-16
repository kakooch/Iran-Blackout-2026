package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC18318oS7;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface ViaHeaderExt extends InterfaceC18318oS7 {
    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    /* synthetic */ String getBranch();

    /* synthetic */ String getHost();

    /* synthetic */ String getMAddr();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    /* synthetic */ int getPort();

    /* synthetic */ String getProtocol();

    /* synthetic */ int getRPort();

    /* synthetic */ String getReceived();

    String getSentByField();

    String getSentProtocolField();

    /* synthetic */ int getTTL();

    /* synthetic */ String getTransport();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    /* synthetic */ void setBranch(String str);

    /* synthetic */ void setHost(String str);

    /* synthetic */ void setMAddr(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    /* synthetic */ void setPort(int i);

    /* synthetic */ void setProtocol(String str);

    /* synthetic */ void setRPort();

    /* synthetic */ void setReceived(String str);

    /* synthetic */ void setTTL(int i);

    /* synthetic */ void setTransport(String str);
}
