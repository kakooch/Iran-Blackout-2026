package android.gov.nist.javax.sip;

import ir.nasim.CX5;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC17658nL1;

/* loaded from: classes.dex */
public class ResponseEventExt extends CX5 {
    private boolean isForked;
    private boolean isRetransmission;
    private ClientTransactionExt m_originalTransaction;
    private String remoteIpAddress;
    private int remotePort;

    public ResponseEventExt(Object obj, ClientTransactionExt clientTransactionExt, InterfaceC17658nL1 interfaceC17658nL1, InterfaceC10981cX5 interfaceC10981cX5) {
        super(obj, clientTransactionExt, interfaceC17658nL1, interfaceC10981cX5);
        this.m_originalTransaction = clientTransactionExt;
    }

    public ClientTransactionExt getOriginalTransaction() {
        return this.m_originalTransaction;
    }

    public String getRemoteIpAddress() {
        return this.remoteIpAddress;
    }

    public int getRemotePort() {
        return this.remotePort;
    }

    public boolean isForkedResponse() {
        return this.isForked;
    }

    public boolean isRetransmission() {
        return this.isRetransmission;
    }

    public void setForkedResponse(boolean z) {
        this.isForked = z;
    }

    public void setOriginalTransaction(ClientTransactionExt clientTransactionExt) {
        this.m_originalTransaction = clientTransactionExt;
    }

    public void setRemoteIpAddress(String str) {
        this.remoteIpAddress = str;
    }

    public void setRemotePort(int i) {
        this.remotePort = i;
    }

    public void setRetransmission(boolean z) {
        this.isRetransmission = z;
    }
}
