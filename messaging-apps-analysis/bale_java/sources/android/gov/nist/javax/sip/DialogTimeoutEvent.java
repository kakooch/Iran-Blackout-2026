package android.gov.nist.javax.sip;

import ir.nasim.CV0;
import ir.nasim.InterfaceC17658nL1;
import java.util.EventObject;

/* loaded from: classes.dex */
public class DialogTimeoutEvent extends EventObject {
    private static final long serialVersionUID = -2514000059989311925L;
    private InterfaceC17658nL1 m_dialog;
    private CV0 m_reInviteTransaction;
    private Reason m_reason;

    public enum Reason {
        AckNotReceived,
        AckNotSent,
        ReInviteTimeout,
        EarlyStateTimeout,
        CannotAcquireAckSemaphoreForOk
    }

    public DialogTimeoutEvent(Object obj, InterfaceC17658nL1 interfaceC17658nL1, Reason reason) {
        super(obj);
        this.m_reInviteTransaction = null;
        this.m_dialog = interfaceC17658nL1;
        this.m_reason = reason;
    }

    public CV0 getClientTransaction() {
        return this.m_reInviteTransaction;
    }

    public InterfaceC17658nL1 getDialog() {
        return this.m_dialog;
    }

    public Reason getReason() {
        return this.m_reason;
    }

    public void setClientTransaction(CV0 cv0) {
        this.m_reInviteTransaction = cv0;
    }
}
