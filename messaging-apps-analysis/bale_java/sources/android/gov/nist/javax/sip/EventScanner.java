package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.core.ThreadAuditor;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.SIPClientTransaction;
import android.gov.nist.javax.sip.stack.SIPDialog;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.gov.nist.javax.sip.stack.SIPTransaction;
import ir.nasim.AbstractC17125mR5;
import ir.nasim.C13844gu7;
import ir.nasim.C23720xP1;
import ir.nasim.C3626Bq7;
import ir.nasim.CX5;
import ir.nasim.KD6;
import ir.nasim.MP1;
import ir.nasim.UZ2;
import java.util.EventObject;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class EventScanner implements Runnable {
    private static StackLogger logger = CommonLogger.getLogger(EventScanner.class);
    private boolean isStopped;
    private SipStackImpl sipStack;
    private AtomicInteger refCount = new AtomicInteger(0);
    private BlockingQueue<EventWrapper> pendingEvents = new LinkedBlockingQueue();

    public EventScanner(SipStackImpl sipStackImpl) {
        Thread thread = new Thread(this);
        thread.setDaemon(false);
        this.sipStack = sipStackImpl;
        thread.setName("EventScannerThread");
        thread.start();
    }

    private void deliverDialogTerminatedEvent(MP1 mp1, EventWrapper eventWrapper, KD6 kd6) {
        if (kd6 != null) {
            try {
                kd6.processDialogTerminated(mp1);
            } catch (AbstractMethodError unused) {
                if (logger.isLoggingEnabled()) {
                    logger.logWarning("Unable to call sipListener.processDialogTerminated");
                }
            } catch (Exception e) {
                logger.logException(e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e A[Catch: Exception -> 0x000c, TryCatch #0 {Exception -> 0x000c, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x000e, B:10:0x0018), top: B:15:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void deliverDialogTimeoutEvent(android.gov.nist.javax.sip.DialogTimeoutEvent r1, android.gov.nist.javax.sip.EventWrapper r2, ir.nasim.KD6 r3) {
        /*
            r0 = this;
            if (r3 == 0) goto Le
            boolean r2 = r3 instanceof android.gov.nist.javax.sip.SipListenerExt     // Catch: java.lang.Exception -> Lc
            if (r2 == 0) goto Le
            android.gov.nist.javax.sip.SipListenerExt r3 = (android.gov.nist.javax.sip.SipListenerExt) r3     // Catch: java.lang.Exception -> Lc
            r3.processDialogTimeout(r1)     // Catch: java.lang.Exception -> Lc
            goto L25
        Lc:
            r1 = move-exception
            goto L20
        Le:
            android.gov.nist.core.StackLogger r1 = android.gov.nist.javax.sip.EventScanner.logger     // Catch: java.lang.Exception -> Lc
            r2 = 32
            boolean r1 = r1.isLoggingEnabled(r2)     // Catch: java.lang.Exception -> Lc
            if (r1 == 0) goto L25
            android.gov.nist.core.StackLogger r1 = android.gov.nist.javax.sip.EventScanner.logger     // Catch: java.lang.Exception -> Lc
            java.lang.String r2 = "DialogTimeoutEvent not delivered"
            r1.logDebug(r2)     // Catch: java.lang.Exception -> Lc
            goto L25
        L20:
            android.gov.nist.core.StackLogger r2 = android.gov.nist.javax.sip.EventScanner.logger
            r2.logException(r1)
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.EventScanner.deliverDialogTimeoutEvent(android.gov.nist.javax.sip.DialogTimeoutEvent, android.gov.nist.javax.sip.EventWrapper, ir.nasim.KD6):void");
    }

    private void deliverIOExceptionEvent(UZ2 uz2, EventWrapper eventWrapper, KD6 kd6) {
        if (kd6 != null) {
            try {
                kd6.processIOException(uz2);
            } catch (Exception e) {
                logger.logException(e);
            }
        }
    }

    private void deliverRequestEvent(AbstractC17125mR5 abstractC17125mR5, EventWrapper eventWrapper, KD6 kd6) {
        SIPDialog sIPDialog;
        try {
            SIPRequest sIPRequest = (SIPRequest) abstractC17125mR5.getRequest();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("deliverEvent : " + sIPRequest.getFirstLine() + " transaction " + eventWrapper.transaction + " sipEvent.serverTx = " + abstractC17125mR5.getServerTransaction());
            }
            SIPServerTransaction sIPServerTransaction = (SIPServerTransaction) this.sipStack.findTransaction((SIPMessage) sIPRequest, true);
            if (sIPServerTransaction == null || sIPServerTransaction.passToListener()) {
                if (this.sipStack.findPendingTransaction(sIPRequest.getTransactionId()) != null) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("transaction already exists!!");
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Done processing Message " + ((SIPRequest) abstractC17125mR5.getRequest()).getFirstLine());
                    }
                    SIPTransaction sIPTransaction = eventWrapper.transaction;
                    if (sIPTransaction != null && ((SIPServerTransaction) sIPTransaction).passToListener()) {
                        ((SIPServerTransaction) eventWrapper.transaction).releaseSem();
                    }
                    SIPTransaction sIPTransaction2 = eventWrapper.transaction;
                    if (sIPTransaction2 != null) {
                        this.sipStack.removePendingTransaction((SIPServerTransaction) sIPTransaction2);
                    }
                    if (eventWrapper.transaction.getMethod().equals(TokenNames.ACK)) {
                        eventWrapper.transaction.setState(5);
                        return;
                    }
                    return;
                }
                this.sipStack.putPendingTransaction((SIPServerTransaction) eventWrapper.transaction);
            } else {
                if (!sIPRequest.getMethod().equals(TokenNames.ACK) || !sIPServerTransaction.isInviteTransaction() || (sIPServerTransaction.getLastResponseStatusCode() / 100 != 2 && !this.sipStack.isNon2XXAckPassedToListener())) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("transaction already exists! " + sIPServerTransaction);
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Done processing Message " + ((SIPRequest) abstractC17125mR5.getRequest()).getFirstLine());
                    }
                    SIPTransaction sIPTransaction3 = eventWrapper.transaction;
                    if (sIPTransaction3 != null && ((SIPServerTransaction) sIPTransaction3).passToListener()) {
                        ((SIPServerTransaction) eventWrapper.transaction).releaseSem();
                    }
                    SIPTransaction sIPTransaction4 = eventWrapper.transaction;
                    if (sIPTransaction4 != null) {
                        this.sipStack.removePendingTransaction((SIPServerTransaction) sIPTransaction4);
                    }
                    if (eventWrapper.transaction.getMethod().equals(TokenNames.ACK)) {
                        eventWrapper.transaction.setState(5);
                        return;
                    }
                    return;
                }
                if (!this.sipStack.isNon2XXAckPassedToListener() && logger.isLoggingEnabled(32)) {
                    logger.logDebug("Detected broken client sending ACK with same branch! Passing...");
                }
            }
            sIPRequest.setTransaction(eventWrapper.transaction);
            try {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Calling listener " + sIPRequest.getFirstLine());
                    logger.logDebug("Calling listener " + eventWrapper.transaction);
                }
                if (kd6 != null) {
                    kd6.processRequest(abstractC17125mR5);
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Done processing Message " + sIPRequest.getFirstLine());
                }
                SIPTransaction sIPTransaction5 = eventWrapper.transaction;
                if (sIPTransaction5 != null && (sIPDialog = (SIPDialog) sIPTransaction5.getDialog()) != null) {
                    sIPDialog.requestConsumed();
                }
            } catch (Exception e) {
                logger.logException(e);
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Done processing Message " + ((SIPRequest) abstractC17125mR5.getRequest()).getFirstLine());
            }
            SIPTransaction sIPTransaction6 = eventWrapper.transaction;
            if (sIPTransaction6 != null && ((SIPServerTransaction) sIPTransaction6).passToListener()) {
                ((SIPServerTransaction) eventWrapper.transaction).releaseSem();
            }
            SIPTransaction sIPTransaction7 = eventWrapper.transaction;
            if (sIPTransaction7 != null) {
                this.sipStack.removePendingTransaction((SIPServerTransaction) sIPTransaction7);
            }
            if (eventWrapper.transaction.getMethod().equals(TokenNames.ACK)) {
                eventWrapper.transaction.setState(5);
            }
        } catch (Throwable th) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Done processing Message " + ((SIPRequest) abstractC17125mR5.getRequest()).getFirstLine());
            }
            SIPTransaction sIPTransaction8 = eventWrapper.transaction;
            if (sIPTransaction8 != null && ((SIPServerTransaction) sIPTransaction8).passToListener()) {
                ((SIPServerTransaction) eventWrapper.transaction).releaseSem();
            }
            SIPTransaction sIPTransaction9 = eventWrapper.transaction;
            if (sIPTransaction9 != null) {
                this.sipStack.removePendingTransaction((SIPServerTransaction) sIPTransaction9);
            }
            if (eventWrapper.transaction.getMethod().equals(TokenNames.ACK)) {
                eventWrapper.transaction.setState(5);
            }
            throw th;
        }
    }

    private void deliverResponseEvent(CX5 cx5, EventWrapper eventWrapper, KD6 kd6) {
        try {
            SIPResponse sIPResponse = (SIPResponse) cx5.getResponse();
            SIPDialog sIPDialog = (SIPDialog) cx5.getDialog();
            try {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Calling listener " + kd6 + " for " + sIPResponse.getFirstLine());
                }
                if (kd6 != null) {
                    SIPTransaction sIPTransaction = eventWrapper.transaction;
                    if (sIPTransaction != null) {
                        sIPTransaction.setPassToListener();
                    }
                    kd6.processResponse(cx5);
                }
                if (sIPDialog != null && ((sIPDialog.getState() == null || !sIPDialog.getState().equals(C23720xP1.g)) && (sIPResponse.getStatusCode() == 481 || sIPResponse.getStatusCode() == 408))) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Removing dialog on 408 or 481 response");
                    }
                    sIPDialog.doDeferredDelete();
                }
                if (sIPResponse.getCSeq().getMethod().equals(TokenNames.INVITE) && sIPDialog != null && sIPResponse.getStatusCode() == 200) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Warning! unacknowledged dialog. " + sIPDialog.getState());
                    }
                    sIPDialog.doDeferredDeleteIfNoAckSent(sIPResponse.getCSeq().getSeqNumber());
                }
            } catch (Exception e) {
                logger.logException(e);
            }
            SIPClientTransaction sIPClientTransaction = (SIPClientTransaction) eventWrapper.transaction;
            if (sIPClientTransaction != null && 3 == sIPClientTransaction.getInternalState() && !sIPClientTransaction.getMethod().equals(TokenNames.INVITE)) {
                sIPClientTransaction.clearState();
            }
            SIPTransaction sIPTransaction2 = eventWrapper.transaction;
            if (sIPTransaction2 == null || !sIPTransaction2.passToListener()) {
                return;
            }
            eventWrapper.transaction.releaseSem();
        } catch (Throwable th) {
            SIPTransaction sIPTransaction3 = eventWrapper.transaction;
            if (sIPTransaction3 != null && sIPTransaction3.passToListener()) {
                eventWrapper.transaction.releaseSem();
            }
            throw th;
        }
    }

    private void deliverTimeoutEvent(C3626Bq7 c3626Bq7, EventWrapper eventWrapper, KD6 kd6) {
        if (kd6 != null) {
            try {
                kd6.processTimeout(c3626Bq7);
            } catch (Exception e) {
                logger.logException(e);
            }
        }
    }

    private void deliverTransactionTerminatedEvent(C13844gu7 c13844gu7, EventWrapper eventWrapper, KD6 kd6) {
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("About to deliver transactionTerminatedEvent");
                logger.logDebug("tx = " + c13844gu7.a());
                logger.logDebug("tx = " + c13844gu7.b());
            }
            if (kd6 != null) {
                kd6.processTransactionTerminated(c13844gu7);
            }
        } catch (AbstractMethodError unused) {
            if (logger.isLoggingEnabled()) {
                logger.logWarning("Unable to call sipListener.processTransactionTerminated");
            }
        } catch (Exception e) {
            logger.logException(e);
        }
    }

    public void addEvent(EventWrapper eventWrapper) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("addEvent " + eventWrapper);
        }
        if (this.pendingEvents.offer(eventWrapper)) {
            return;
        }
        logger.logWarning("reached queue capacity limit couldn't addEvent " + eventWrapper);
    }

    public void deliverEvent(EventWrapper eventWrapper) {
        EventObject eventObject = eventWrapper.sipEvent;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sipEvent = " + eventObject + "source = " + eventObject.getSource());
        }
        boolean z = eventObject instanceof UZ2;
        KD6 sipListener = !z ? ((SipProviderImpl) eventObject.getSource()).getSipListener() : this.sipStack.getSipListener();
        if (eventObject instanceof AbstractC17125mR5) {
            deliverRequestEvent((AbstractC17125mR5) eventObject, eventWrapper, sipListener);
            return;
        }
        if (eventObject instanceof CX5) {
            deliverResponseEvent((CX5) eventObject, eventWrapper, sipListener);
            return;
        }
        if (eventObject instanceof C3626Bq7) {
            deliverTimeoutEvent((C3626Bq7) eventObject, eventWrapper, sipListener);
            return;
        }
        if (eventObject instanceof DialogTimeoutEvent) {
            deliverDialogTimeoutEvent((DialogTimeoutEvent) eventObject, eventWrapper, sipListener);
            return;
        }
        if (z) {
            deliverIOExceptionEvent((UZ2) eventObject, eventWrapper, sipListener);
            return;
        }
        if (eventObject instanceof C13844gu7) {
            deliverTransactionTerminatedEvent((C13844gu7) eventObject, eventWrapper, sipListener);
            return;
        }
        if (eventObject instanceof MP1) {
            deliverDialogTerminatedEvent((MP1) eventObject, eventWrapper, sipListener);
            return;
        }
        logger.logFatalError("bad event" + eventObject);
    }

    public void forceStop() {
        this.isStopped = true;
        this.refCount.set(0);
    }

    public void incrementRefcount() {
        this.refCount.incrementAndGet();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ThreadAuditor.ThreadHandle threadHandleAddCurrentThread = this.sipStack.getThreadAuditor() != null ? this.sipStack.getThreadAuditor().addCurrentThread() : null;
            while (!this.isStopped) {
                if (threadHandleAddCurrentThread != null) {
                    threadHandleAddCurrentThread.ping();
                }
                try {
                    deliverEvent(this.pendingEvents.take());
                } catch (InterruptedException e) {
                    if (logger.isLoggingEnabled(4)) {
                        logger.logError("Interrupted!", e);
                    }
                    if (!logger.isLoggingEnabled(32) || this.isStopped) {
                        return;
                    }
                    logger.logFatalError("Event scanner exited abnormally");
                    return;
                } catch (Exception e2) {
                    if (logger.isLoggingEnabled()) {
                        logger.logError("Unexpected exception caught while delivering event -- carrying on bravely", e2);
                    }
                }
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Stopped event scanner!!");
            }
            if (!logger.isLoggingEnabled(32) || this.isStopped) {
                return;
            }
            logger.logFatalError("Event scanner exited abnormally");
        } catch (Throwable th) {
            if (logger.isLoggingEnabled(32) && !this.isStopped) {
                logger.logFatalError("Event scanner exited abnormally");
            }
            throw th;
        }
    }

    public void stop() {
        if (this.refCount.get() == 0) {
            this.isStopped = true;
        }
    }
}
