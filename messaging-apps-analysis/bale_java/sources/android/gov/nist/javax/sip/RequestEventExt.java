package android.gov.nist.javax.sip;

import ir.nasim.AbstractC17125mR5;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC5278Iq6;
import ir.nasim.UP5;

/* loaded from: classes.dex */
public class RequestEventExt extends AbstractC17125mR5 {
    private String remoteIpAddress;
    private int remotePort;

    public RequestEventExt(Object obj, InterfaceC5278Iq6 interfaceC5278Iq6, InterfaceC17658nL1 interfaceC17658nL1, UP5 up5) {
        super(obj, interfaceC5278Iq6, interfaceC17658nL1, up5);
    }

    public String getRemoteIpAddress() {
        return this.remoteIpAddress;
    }

    public int getRemotePort() {
        return this.remotePort;
    }

    public void setRemoteIpAddress(String str) {
        this.remoteIpAddress = str;
    }

    public void setRemotePort(int i) {
        this.remotePort = i;
    }
}
