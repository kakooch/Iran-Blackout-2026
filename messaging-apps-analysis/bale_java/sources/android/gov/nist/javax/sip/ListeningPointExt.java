package android.gov.nist.javax.sip;

import ir.nasim.InterfaceC17579nC3;
import ir.nasim.InterfaceC18318oS7;
import ir.nasim.InterfaceC7782Te1;

/* loaded from: classes.dex */
public interface ListeningPointExt extends InterfaceC17579nC3 {
    public static final String WS = "WS";
    public static final String WSS = "WSS";

    InterfaceC7782Te1 createContactHeader();

    InterfaceC18318oS7 createViaHeader();

    @Override // ir.nasim.InterfaceC17579nC3
    /* synthetic */ String getIPAddress();

    @Override // ir.nasim.InterfaceC17579nC3
    /* synthetic */ int getPort();

    /* synthetic */ String getSentBy();

    @Override // ir.nasim.InterfaceC17579nC3
    /* synthetic */ String getTransport();

    void sendHeartbeat(String str, int i);

    /* synthetic */ void setSentBy(String str);
}
