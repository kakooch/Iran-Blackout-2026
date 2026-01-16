package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.DialogTimeoutEvent;
import java.util.EventObject;

/* loaded from: classes.dex */
public class SIPDialogErrorEvent extends EventObject {
    public static final int DIALOG_ACK_NOT_RECEIVED_TIMEOUT = 1;
    public static final int DIALOG_ACK_NOT_SENT_TIMEOUT = 2;
    public static final int DIALOG_ERROR_INTERNAL_COULD_NOT_TAKE_ACK_SEM = 5;
    public static final int DIALOG_REINVITE_TIMEOUT = 3;
    public static final int EARLY_STATE_TIMEOUT = 4;
    private SIPClientTransaction clientTransaction;
    private int errorID;

    SIPDialogErrorEvent(SIPDialog sIPDialog, int i) {
        super(sIPDialog);
        this.errorID = i;
    }

    public SIPClientTransaction getClientTransaction() {
        return this.clientTransaction;
    }

    public int getErrorID() {
        return this.errorID;
    }

    public void setClientTransaction(SIPClientTransaction sIPClientTransaction) {
        this.clientTransaction = sIPClientTransaction;
    }

    public SIPDialogErrorEvent(SIPDialog sIPDialog, DialogTimeoutEvent.Reason reason) {
        super(sIPDialog);
        if (reason == DialogTimeoutEvent.Reason.AckNotReceived) {
            this.errorID = 1;
            return;
        }
        if (reason == DialogTimeoutEvent.Reason.AckNotSent) {
            this.errorID = 2;
            return;
        }
        if (reason == DialogTimeoutEvent.Reason.ReInviteTimeout) {
            this.errorID = 3;
        } else if (reason == DialogTimeoutEvent.Reason.CannotAcquireAckSemaphoreForOk) {
            this.errorID = 5;
        } else if (reason == DialogTimeoutEvent.Reason.EarlyStateTimeout) {
            this.errorID = 4;
        }
    }

    public SIPDialogErrorEvent(SIPDialog sIPDialog, SIPClientTransaction sIPClientTransaction, DialogTimeoutEvent.Reason reason) {
        this(sIPDialog, reason);
        this.clientTransaction = sIPClientTransaction;
    }
}
