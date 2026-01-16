package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.InternalErrorHandler;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.DialogTimeoutEvent;
import android.gov.nist.javax.sip.address.ParameterNames;
import android.gov.nist.javax.sip.address.RouterExt;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.HopImpl;
import android.gov.nist.javax.sip.stack.MessageChannel;
import android.gov.nist.javax.sip.stack.SIPClientTransaction;
import android.gov.nist.javax.sip.stack.SIPDialog;
import android.gov.nist.javax.sip.stack.SIPDialogErrorEvent;
import android.gov.nist.javax.sip.stack.SIPDialogEventListener;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.gov.nist.javax.sip.stack.SIPTransaction;
import android.gov.nist.javax.sip.stack.SIPTransactionErrorEvent;
import android.gov.nist.javax.sip.stack.SIPTransactionEventListener;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.javax.sip.InvalidArgumentException;
import android.javax.sip.ObjectInUseException;
import android.javax.sip.SipException;
import android.javax.sip.TransactionAlreadyExistsException;
import android.javax.sip.TransactionUnavailableException;
import ir.nasim.AbstractC17125mR5;
import ir.nasim.C23720xP1;
import ir.nasim.C25169zq7;
import ir.nasim.C3626Bq7;
import ir.nasim.CV0;
import ir.nasim.CX5;
import ir.nasim.FY2;
import ir.nasim.InterfaceC10620bu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC17579nC3;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.InterfaceC5278Iq6;
import ir.nasim.KD6;
import ir.nasim.LD6;
import ir.nasim.MD6;
import ir.nasim.UP5;
import java.io.IOException;
import java.text.ParseException;
import java.util.EventObject;
import java.util.Iterator;
import java.util.TooManyListenersException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class SipProviderImpl implements LD6, SipProviderExt, SIPTransactionEventListener, SIPDialogEventListener {
    private static StackLogger logger = CommonLogger.getLogger(SipProviderImpl.class);
    private boolean automaticDialogSupportEnabled;
    private boolean dialogErrorsAutomaticallyHandled;
    protected EventScanner eventScanner;
    private ConcurrentHashMap<String, InterfaceC17579nC3> listeningPoints;
    private KD6 sipListener;
    protected SipStackImpl sipStack;

    private SipProviderImpl() {
        this.dialogErrorsAutomaticallyHandled = true;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public synchronized void addListeningPoint(InterfaceC17579nC3 interfaceC17579nC3) {
        try {
            ListeningPointImpl listeningPointImpl = (ListeningPointImpl) interfaceC17579nC3;
            SipProviderImpl sipProviderImpl = listeningPointImpl.sipProvider;
            if (sipProviderImpl != null && sipProviderImpl != this) {
                throw new ObjectInUseException("Listening point assigned to another provider");
            }
            String upperCase = listeningPointImpl.getTransport().toUpperCase();
            if (this.listeningPoints.containsKey(upperCase) && this.listeningPoints.get(upperCase) != interfaceC17579nC3) {
                throw new ObjectInUseException("Listening point already assigned for transport!");
            }
            listeningPointImpl.sipProvider = this;
            this.listeningPoints.put(upperCase, listeningPointImpl);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public void addSipListener(KD6 kd6) throws TooManyListenersException {
        SipStackImpl sipStackImpl = this.sipStack;
        KD6 kd62 = sipStackImpl.sipListener;
        if (kd62 == null) {
            sipStackImpl.sipListener = kd6;
        } else if (kd62 != kd6) {
            throw new TooManyListenersException("Stack already has a listener. Only one listener per stack allowed");
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("add SipListener " + kd6);
        }
        this.sipListener = kd6;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected SIPClientTransaction createClientTransaction(UP5 up5, FY2 fy2) throws TransactionUnavailableException {
        SIPClientTransaction sIPClientTransaction;
        if (up5 == null) {
            throw new NullPointerException("null request");
        }
        if (fy2 == null) {
            throw new NullPointerException("null hop");
        }
        if (!this.sipStack.isAlive()) {
            throw new TransactionUnavailableException("Stack is stopped");
        }
        SIPRequest sIPRequest = (SIPRequest) up5;
        if (sIPRequest.getTransaction() != null) {
            throw new TransactionUnavailableException("Transaction already assigned to request");
        }
        if (sIPRequest.getMethod().equals(TokenNames.ACK)) {
            throw new TransactionUnavailableException("Cannot create client transaction for  ACK");
        }
        if (sIPRequest.getTopmostVia() == null) {
            String transport = fy2.getTransport();
            if (transport == null) {
                transport = ParameterNames.UDP;
            }
            ListeningPointImpl listeningPointImpl = (ListeningPointImpl) getListeningPoint(transport);
            if (listeningPointImpl == null) {
                listeningPointImpl = (ListeningPointImpl) getListeningPoints()[0];
            }
            sIPRequest.setHeader(listeningPointImpl.getViaHeader());
        }
        try {
            sIPRequest.checkHeaders();
            if (sIPRequest.getTopmostVia().getBranch() != null && sIPRequest.getTopmostVia().getBranch().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE) && this.sipStack.findTransaction((SIPMessage) sIPRequest, false) != null) {
                throw new TransactionUnavailableException("Transaction already exists!");
            }
            if (sIPRequest.getMethod().equalsIgnoreCase("CANCEL") && (sIPClientTransaction = (SIPClientTransaction) this.sipStack.findCancelTransaction(sIPRequest, false)) != null) {
                SIPClientTransaction sIPClientTransactionCreateClientTransaction = this.sipStack.createClientTransaction(sIPRequest, sIPClientTransaction.getMessageChannel());
                sIPClientTransactionCreateClientTransaction.addEventListener(this);
                this.sipStack.addTransaction(sIPClientTransactionCreateClientTransaction);
                if (sIPClientTransaction.getDialog() != null) {
                    sIPClientTransactionCreateClientTransaction.setDialog((SIPDialog) sIPClientTransaction.getDialog(), sIPRequest.getDialogId(false));
                }
                return sIPClientTransactionCreateClientTransaction;
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("could not find existing transaction for " + sIPRequest + " creating a new one ");
            }
            String transport2 = fy2.getTransport();
            ListeningPointImpl listeningPointImpl2 = (ListeningPointImpl) getListeningPoint(transport2);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Got following Listenin point " + listeningPointImpl2 + " for transport " + transport2);
            }
            if (listeningPointImpl2 == null) {
                listeningPointImpl2 = (ListeningPointImpl) getListeningPoint(sIPRequest.getTopmostVia().getTransport());
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Listenig point was null using new one from Via header " + listeningPointImpl2 + " for transport " + sIPRequest.getTopmostVia().getTransport());
                }
            }
            SIPDialog dialog = this.sipStack.getDialog(sIPRequest.getDialogId(false));
            if (dialog != null && dialog.getState() == C23720xP1.g) {
                this.sipStack.removeDialog(dialog);
            }
            try {
                if (sIPRequest.getTopmostVia().getBranch() == null || !sIPRequest.getTopmostVia().getBranch().startsWith(SIPConstants.BRANCH_MAGIC_COOKIE) || this.sipStack.checkBranchId()) {
                    sIPRequest.getTopmostVia().setBranch(Utils.getInstance().generateBranchId());
                }
                Via topmostVia = sIPRequest.getTopmostVia();
                if (topmostVia.getTransport() == null) {
                    topmostVia.setTransport(transport2);
                }
                if (topmostVia.getPort() == -1) {
                    topmostVia.setPort(listeningPointImpl2.getPort());
                }
                String branch = sIPRequest.getTopmostVia().getBranch();
                SIPClientTransaction sIPClientTransactionCreateClientTransaction2 = this.sipStack.createClientTransaction(sIPRequest, this.sipStack.createMessageChannel(sIPRequest, listeningPointImpl2.getMessageProcessor(), fy2));
                if (sIPClientTransactionCreateClientTransaction2 == null) {
                    throw new TransactionUnavailableException("Cound not create tx");
                }
                sIPClientTransactionCreateClientTransaction2.setNextHop(fy2);
                sIPClientTransactionCreateClientTransaction2.setOriginalRequest(sIPRequest);
                sIPClientTransactionCreateClientTransaction2.setBranch(branch);
                if (SIPTransactionStack.isDialogCreated(sIPRequest.getMethod())) {
                    if (dialog != null) {
                        sIPClientTransactionCreateClientTransaction2.setDialog(dialog, sIPRequest.getDialogId(false));
                    } else if (isAutomaticDialogSupportEnabled()) {
                        sIPClientTransactionCreateClientTransaction2.setDialog(this.sipStack.createDialog(sIPClientTransactionCreateClientTransaction2), sIPRequest.getDialogId(false));
                    }
                } else if (dialog != null) {
                    sIPClientTransactionCreateClientTransaction2.setDialog(dialog, sIPRequest.getDialogId(false));
                }
                sIPClientTransactionCreateClientTransaction2.addEventListener(this);
                return sIPClientTransactionCreateClientTransaction2;
            } catch (InvalidArgumentException e) {
                InternalErrorHandler.handleException(e);
                throw new TransactionUnavailableException("Unexpected Exception FIXME! ", e);
            } catch (IOException e2) {
                throw new TransactionUnavailableException("Could not resolve next hop or listening point unavailable! ", e2);
            } catch (ParseException e3) {
                InternalErrorHandler.handleException(e3);
                throw new TransactionUnavailableException("Unexpected Exception FIXME! ", e3);
            }
        } catch (ParseException e4) {
            throw new TransactionUnavailableException(e4.getMessage(), e4);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.SIPDialogEventListener
    public void dialogErrorEvent(SIPDialogErrorEvent sIPDialogErrorEvent) {
        SIPDialog sIPDialog = (SIPDialog) sIPDialogErrorEvent.getSource();
        DialogTimeoutEvent.Reason reason = DialogTimeoutEvent.Reason.AckNotReceived;
        if (sIPDialogErrorEvent.getErrorID() == 2) {
            reason = DialogTimeoutEvent.Reason.AckNotSent;
        } else if (sIPDialogErrorEvent.getErrorID() == 3) {
            reason = DialogTimeoutEvent.Reason.ReInviteTimeout;
        } else if (sIPDialogErrorEvent.getErrorID() == 4) {
            reason = DialogTimeoutEvent.Reason.EarlyStateTimeout;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Dialog TimeoutError occured on " + sIPDialog);
        }
        DialogTimeoutEvent dialogTimeoutEvent = new DialogTimeoutEvent(this, sIPDialog, reason);
        dialogTimeoutEvent.setClientTransaction(sIPDialogErrorEvent.getClientTransaction());
        handleEvent(dialogTimeoutEvent, null);
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public InterfaceC17579nC3 getListeningPoint(String str) {
        if (str != null) {
            return this.listeningPoints.get(str.toUpperCase());
        }
        throw new NullPointerException("Null transport param");
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public synchronized InterfaceC17579nC3[] getListeningPoints() {
        ListeningPointImpl[] listeningPointImplArr;
        listeningPointImplArr = new ListeningPointImpl[this.listeningPoints.size()];
        this.listeningPoints.values().toArray(listeningPointImplArr);
        return listeningPointImplArr;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public InterfaceC21662tv0 getNewCallId() {
        String strGenerateCallIdentifier = Utils.getInstance().generateCallIdentifier(getListeningPoint().getIPAddress());
        CallID callID = new CallID();
        try {
            callID.setCallId(strGenerateCallIdentifier);
        } catch (ParseException unused) {
        }
        return callID;
    }

    @Override // ir.nasim.LD6
    public CV0 getNewClientTransaction(UP5 up5) {
        try {
            FY2 nextHop = this.sipStack.getNextHop((SIPRequest) up5);
            if (nextHop == null) {
                throw new TransactionUnavailableException("Cannot resolve next hop -- transaction unavailable");
            }
            SIPClientTransaction sIPClientTransactionCreateClientTransaction = createClientTransaction(up5, nextHop);
            this.sipStack.addTransaction(sIPClientTransactionCreateClientTransaction);
            return sIPClientTransactionCreateClientTransaction;
        } catch (SipException e) {
            throw new TransactionUnavailableException("Cannot resolve next hop -- transaction unavailable", e);
        }
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public InterfaceC17658nL1 getNewDialog(InterfaceC10620bu7 interfaceC10620bu7) throws SipException {
        SIPDialog sIPDialogCreateDialog;
        if (interfaceC10620bu7 == null) {
            throw new NullPointerException("Null transaction!");
        }
        if (!this.sipStack.isAlive()) {
            throw new SipException("Stack is stopped.");
        }
        if (isAutomaticDialogSupportEnabled()) {
            throw new SipException(" Error - AUTOMATIC_DIALOG_SUPPORT is on");
        }
        if (!SIPTransactionStack.isDialogCreated(interfaceC10620bu7.getRequest().getMethod())) {
            throw new SipException("Dialog cannot be created for this method " + interfaceC10620bu7.getRequest().getMethod());
        }
        SIPTransaction sIPTransaction = (SIPTransaction) interfaceC10620bu7;
        if (interfaceC10620bu7 instanceof InterfaceC5278Iq6) {
            SIPServerTransaction sIPServerTransaction = (SIPServerTransaction) interfaceC10620bu7;
            SIPResponse lastResponse = sIPServerTransaction.getLastResponse();
            if (lastResponse != null && lastResponse.getStatusCode() != 100) {
                throw new SipException("Cannot set dialog after response has been sent");
            }
            SIPRequest sIPRequest = (SIPRequest) interfaceC10620bu7.getRequest();
            sIPDialogCreateDialog = this.sipStack.getDialog(sIPRequest.getDialogId(true));
            if (sIPDialogCreateDialog == null) {
                sIPDialogCreateDialog = this.sipStack.createDialog(sIPTransaction);
                sIPDialogCreateDialog.addTransaction(sIPTransaction);
                sIPDialogCreateDialog.addRoute(sIPRequest);
                sIPTransaction.setDialog(sIPDialogCreateDialog, null);
            } else {
                sIPTransaction.setDialog(sIPDialogCreateDialog, sIPRequest.getDialogId(true));
            }
            if (sIPRequest.getMethod().equals(TokenNames.INVITE) && isDialogErrorsAutomaticallyHandled()) {
                this.sipStack.putInMergeTable(sIPServerTransaction, sIPRequest);
            }
        } else {
            SIPClientTransaction sIPClientTransaction = (SIPClientTransaction) interfaceC10620bu7;
            if (sIPClientTransaction.getLastResponse() != null) {
                throw new SipException("Cannot call this method after response is received!");
            }
            if (this.sipStack.getDialog(((SIPRequest) sIPClientTransaction.getRequest()).getDialogId(false)) != null) {
                throw new SipException("Dialog already exists!");
            }
            sIPDialogCreateDialog = this.sipStack.createDialog(sIPTransaction);
            sIPClientTransaction.setDialog(sIPDialogCreateDialog, null);
        }
        sIPDialogCreateDialog.addEventListener(this);
        return sIPDialogCreateDialog;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public InterfaceC5278Iq6 getNewServerTransaction(UP5 up5) throws TransactionUnavailableException {
        SIPServerTransaction sIPServerTransactionCreateServerTransaction;
        if (!this.sipStack.isAlive()) {
            throw new TransactionUnavailableException("Stack is stopped");
        }
        SIPRequest sIPRequest = (SIPRequest) up5;
        try {
            sIPRequest.checkHeaders();
            if (up5.getMethod().equals(TokenNames.ACK)) {
                if (logger.isLoggingEnabled()) {
                    logger.logError("Creating server transaction for ACK -- makes no sense!");
                }
                throw new TransactionUnavailableException("Cannot create Server transaction for ACK ");
            }
            if (sIPRequest.getMethod().equals(TokenNames.NOTIFY) && sIPRequest.getFromTag() != null && sIPRequest.getToTag() == null && this.sipStack.findSubscribeTransaction(sIPRequest, (ListeningPointImpl) getListeningPoint()) == null && !this.sipStack.isDeliverUnsolicitedNotify()) {
                throw new TransactionUnavailableException("Cannot find matching Subscription (and android.gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY not set)");
            }
            if (!this.sipStack.acquireSem()) {
                throw new TransactionUnavailableException("Transaction not available -- could not acquire stack lock");
            }
            try {
                if (SIPTransactionStack.isDialogCreated(sIPRequest.getMethod())) {
                    if (this.sipStack.findTransaction((SIPMessage) up5, true) != null) {
                        throw new TransactionAlreadyExistsException("server transaction already exists!");
                    }
                    sIPServerTransactionCreateServerTransaction = (SIPServerTransaction) ((SIPRequest) up5).getTransaction();
                    if (sIPServerTransactionCreateServerTransaction == null) {
                        throw new TransactionUnavailableException("Transaction not available");
                    }
                    if (sIPServerTransactionCreateServerTransaction.getOriginalRequest() == null) {
                        sIPServerTransactionCreateServerTransaction.setOriginalRequest(sIPRequest);
                    }
                    try {
                        this.sipStack.addTransaction(sIPServerTransactionCreateServerTransaction);
                        sIPServerTransactionCreateServerTransaction.addEventListener(this);
                        if (isAutomaticDialogSupportEnabled()) {
                            SIPDialog dialog = this.sipStack.getDialog(sIPRequest.getDialogId(true));
                            if (dialog == null) {
                                dialog = this.sipStack.createDialog(sIPServerTransactionCreateServerTransaction);
                            }
                            sIPServerTransactionCreateServerTransaction.setDialog(dialog, sIPRequest.getDialogId(true));
                            if (sIPRequest.getMethod().equals(TokenNames.INVITE) && isDialogErrorsAutomaticallyHandled()) {
                                this.sipStack.putInMergeTable(sIPServerTransactionCreateServerTransaction, sIPRequest);
                            }
                            dialog.addRoute(sIPRequest);
                            if (dialog.getRemoteTag() != null && dialog.getLocalTag() != null) {
                                this.sipStack.putDialog(dialog);
                            }
                        }
                    } catch (IOException unused) {
                        throw new TransactionUnavailableException("Error sending provisional response");
                    }
                } else if (isAutomaticDialogSupportEnabled()) {
                    if (((SIPServerTransaction) this.sipStack.findTransaction((SIPMessage) up5, true)) != null) {
                        throw new TransactionAlreadyExistsException("Transaction exists! ");
                    }
                    sIPServerTransactionCreateServerTransaction = (SIPServerTransaction) ((SIPRequest) up5).getTransaction();
                    if (sIPServerTransactionCreateServerTransaction == null) {
                        throw new TransactionUnavailableException("Transaction not available!");
                    }
                    if (sIPServerTransactionCreateServerTransaction.getOriginalRequest() == null) {
                        sIPServerTransactionCreateServerTransaction.setOriginalRequest(sIPRequest);
                    }
                    try {
                        this.sipStack.addTransaction(sIPServerTransactionCreateServerTransaction);
                        SIPDialog dialog2 = this.sipStack.getDialog(sIPRequest.getDialogId(true));
                        if (dialog2 != null) {
                            dialog2.addTransaction(sIPServerTransactionCreateServerTransaction);
                            dialog2.addRoute(sIPRequest);
                            sIPServerTransactionCreateServerTransaction.setDialog(dialog2, sIPRequest.getDialogId(true));
                        }
                    } catch (IOException unused2) {
                        throw new TransactionUnavailableException("Could not send back provisional response!");
                    }
                } else {
                    if (((SIPServerTransaction) this.sipStack.findTransaction((SIPMessage) up5, true)) != null) {
                        throw new TransactionAlreadyExistsException("Transaction exists! ");
                    }
                    sIPServerTransactionCreateServerTransaction = (SIPServerTransaction) ((SIPRequest) up5).getTransaction();
                    if (sIPServerTransactionCreateServerTransaction != null) {
                        if (sIPServerTransactionCreateServerTransaction.getOriginalRequest() == null) {
                            sIPServerTransactionCreateServerTransaction.setOriginalRequest(sIPRequest);
                        }
                        this.sipStack.mapTransaction(sIPServerTransactionCreateServerTransaction);
                        SIPDialog dialog3 = this.sipStack.getDialog(sIPRequest.getDialogId(true));
                        if (dialog3 != null) {
                            dialog3.addTransaction(sIPServerTransactionCreateServerTransaction);
                            dialog3.addRoute(sIPRequest);
                            sIPServerTransactionCreateServerTransaction.setDialog(dialog3, sIPRequest.getDialogId(true));
                        }
                    } else {
                        sIPServerTransactionCreateServerTransaction = this.sipStack.createServerTransaction((MessageChannel) sIPRequest.getMessageChannel());
                        if (sIPServerTransactionCreateServerTransaction == null) {
                            throw new TransactionUnavailableException("Transaction unavailable -- too many servrer transactions");
                        }
                        sIPServerTransactionCreateServerTransaction.setOriginalRequest(sIPRequest);
                        this.sipStack.mapTransaction(sIPServerTransactionCreateServerTransaction);
                        SIPDialog dialog4 = this.sipStack.getDialog(sIPRequest.getDialogId(true));
                        if (dialog4 != null) {
                            dialog4.addTransaction(sIPServerTransactionCreateServerTransaction);
                            dialog4.addRoute(sIPRequest);
                            sIPServerTransactionCreateServerTransaction.setDialog(dialog4, sIPRequest.getDialogId(true));
                        }
                    }
                }
                return sIPServerTransactionCreateServerTransaction;
            } finally {
                this.sipStack.releaseSem();
            }
        } catch (ParseException e) {
            throw new TransactionUnavailableException(e.getMessage(), e);
        }
    }

    public KD6 getSipListener() {
        return this.sipListener;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public MD6 getSipStack() {
        return this.sipStack;
    }

    public void handleEvent(EventObject eventObject, SIPTransaction sIPTransaction) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("handleEvent " + eventObject + "currentTransaction = " + sIPTransaction + "this.sipListener = " + getSipListener() + "sipEvent.source = " + eventObject.getSource());
            if (eventObject instanceof AbstractC17125mR5) {
                InterfaceC17658nL1 dialog = ((AbstractC17125mR5) eventObject).getDialog();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Dialog = " + dialog);
                }
            } else if (eventObject instanceof CX5) {
                InterfaceC17658nL1 dialog2 = ((CX5) eventObject).getDialog();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Dialog = " + dialog2);
                }
            }
            logger.logStackTrace();
        }
        EventWrapper eventWrapper = new EventWrapper(eventObject, sIPTransaction);
        if (this.sipStack.isReEntrantListener()) {
            this.eventScanner.deliverEvent(eventWrapper);
        } else {
            this.eventScanner.addEvent(eventWrapper);
        }
    }

    public boolean isAutomaticDialogSupportEnabled() {
        return this.automaticDialogSupportEnabled;
    }

    public boolean isDialogErrorsAutomaticallyHandled() {
        return this.dialogErrorsAutomaticallyHandled;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public synchronized void removeListeningPoint(InterfaceC17579nC3 interfaceC17579nC3) {
        ListeningPointImpl listeningPointImpl = (ListeningPointImpl) interfaceC17579nC3;
        if (listeningPointImpl.messageProcessor.inUse()) {
            throw new ObjectInUseException("Object is in use");
        }
        this.listeningPoints.remove(listeningPointImpl.getTransport().toUpperCase());
    }

    public synchronized void removeListeningPoints() {
        Iterator<InterfaceC17579nC3> it = this.listeningPoints.values().iterator();
        while (it.hasNext()) {
            ((ListeningPointImpl) it.next()).messageProcessor.stop();
            it.remove();
        }
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public void removeSipListener(KD6 kd6) {
        if (kd6 == getSipListener()) {
            this.sipListener = null;
        }
        Iterator<SipProviderImpl> sipProviders = this.sipStack.getSipProviders();
        boolean z = false;
        while (sipProviders.hasNext()) {
            if (sipProviders.next().getSipListener() != null) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        this.sipStack.sipListener = null;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public void sendRequest(UP5 up5) throws SipException {
        StackLogger stackLogger;
        StringBuilder sb;
        MessageChannel messageChannelCreateRawMessageChannel;
        Via topmostVia;
        String branch;
        SIPDialog dialog;
        if (!this.sipStack.isAlive()) {
            throw new SipException("Stack is stopped.");
        }
        SIPRequest sIPRequest = (SIPRequest) up5;
        if (sIPRequest.getRequestLine() != null && up5.getMethod().equals(TokenNames.ACK) && (dialog = this.sipStack.getDialog(((SIPRequest) up5).getDialogId(false))) != null && dialog.getState() != null && logger.isLoggingEnabled()) {
            logger.logWarning("Dialog exists -- you may want to use Dialog.sendAck() " + dialog.getState());
        }
        FY2 nextHop = this.sipStack.getRouter(sIPRequest).getNextHop(up5);
        if (nextHop == null) {
            throw new SipException("could not determine next hop!");
        }
        if (!sIPRequest.isNullRequest() && sIPRequest.getTopmostVia() == null) {
            throw new SipException("Invalid SipRequest -- no via header!");
        }
        try {
            try {
                try {
                    if (!sIPRequest.isNullRequest() && ((branch = (topmostVia = sIPRequest.getTopmostVia()).getBranch()) == null || branch.length() == 0)) {
                        topmostVia.setBranch(sIPRequest.getTransactionId());
                    }
                    messageChannelCreateRawMessageChannel = this.listeningPoints.containsKey(nextHop.getTransport().toUpperCase()) ? this.sipStack.createRawMessageChannel(getListeningPoint(nextHop.getTransport()).getIPAddress(), getListeningPoint(nextHop.getTransport()).getPort(), nextHop) : null;
                } catch (ParseException e) {
                    InternalErrorHandler.handleException(e);
                    if (!logger.isLoggingEnabled(32)) {
                        return;
                    }
                    stackLogger = logger;
                    sb = new StringBuilder();
                }
                if (messageChannelCreateRawMessageChannel != null) {
                    messageChannelCreateRawMessageChannel.sendMessage(sIPRequest, nextHop);
                    if (logger.isLoggingEnabled(32)) {
                        stackLogger = logger;
                        sb = new StringBuilder();
                        sb.append("done sending ");
                        sb.append(up5.getMethod());
                        sb.append(" to hop ");
                        sb.append(nextHop);
                        stackLogger.logDebug(sb.toString());
                        return;
                    }
                    return;
                }
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Could not create a message channel for " + nextHop.toString() + " listeningPoints = " + this.listeningPoints);
                }
                throw new SipException("Could not create a message channel for " + nextHop.toString());
            } catch (IOException e2) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Could not create a message channel for " + nextHop.toString() + " listeningPoints = " + this.listeningPoints + " because of an IO issue " + e2.getMessage());
                }
                throw new SipException("IO Exception occured while Sending Request", e2);
            }
        } catch (Throwable th) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("done sending " + up5.getMethod() + " to hop " + nextHop);
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.gov.nist.javax.sip.SipProviderExt
    public void sendResponse(InterfaceC10981cX5 interfaceC10981cX5) throws SipException {
        if (!this.sipStack.isAlive()) {
            throw new SipException("Stack is stopped");
        }
        SIPResponse sIPResponse = (SIPResponse) interfaceC10981cX5;
        Via topmostVia = sIPResponse.getTopmostVia();
        if (topmostVia == null) {
            throw new SipException("No via header in response!");
        }
        SIPServerTransaction sIPServerTransaction = (SIPServerTransaction) this.sipStack.findTransaction((SIPMessage) interfaceC10981cX5, true);
        if (sIPServerTransaction != null && sIPServerTransaction.getInternalState() != 5 && isAutomaticDialogSupportEnabled()) {
            throw new SipException("Transaction exists -- cannot send response statelessly");
        }
        String transport = topmostVia.getTransport();
        String received = topmostVia.getReceived();
        if (received == null) {
            received = topmostVia.getHost();
        }
        int rPort = topmostVia.getRPort();
        if (rPort == -1 && (rPort = topmostVia.getPort()) == -1) {
            rPort = (transport.equalsIgnoreCase("TLS") || transport.equalsIgnoreCase("SCTP-TLS")) ? SIPConstants.DEFAULT_TLS_PORT : SIPConstants.DEFAULT_PORT;
        }
        if (received.indexOf(":") > 0 && received.indexOf("[") < 0) {
            received = "[" + received + "]";
        }
        FY2 fy2ResolveAddress = this.sipStack.getAddressResolver().resolveAddress(new HopImpl(received, rPort, transport));
        try {
            ListeningPointImpl listeningPointImpl = (ListeningPointImpl) getListeningPoint(transport);
            if (listeningPointImpl == null) {
                throw new SipException("whoopsa daisy! no listening point found for transport " + transport);
            }
            MessageChannel messageChannelCreateRawMessageChannel = this.sipStack.createRawMessageChannel(getListeningPoint(fy2ResolveAddress.getTransport()).getIPAddress(), listeningPointImpl.port, fy2ResolveAddress);
            if (messageChannelCreateRawMessageChannel != null) {
                messageChannelCreateRawMessageChannel.sendMessage(sIPResponse);
                return;
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Could not create a message channel for " + fy2ResolveAddress.toString() + " listeningPoints = " + this.listeningPoints);
            }
            throw new SipException("Could not create a message channel for " + fy2ResolveAddress.toString());
        } catch (IOException e) {
            throw new SipException(e.getMessage());
        }
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public void setAutomaticDialogSupportEnabled(boolean z) {
        this.automaticDialogSupportEnabled = z;
        if (z) {
            this.dialogErrorsAutomaticallyHandled = true;
        }
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public void setDialogErrorsAutomaticallyHandled() {
        this.dialogErrorsAutomaticallyHandled = true;
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public synchronized void setListeningPoint(InterfaceC17579nC3 interfaceC17579nC3) {
        if (interfaceC17579nC3 == null) {
            throw new NullPointerException("Null listening point");
        }
        ListeningPointImpl listeningPointImpl = (ListeningPointImpl) interfaceC17579nC3;
        listeningPointImpl.sipProvider = this;
        String upperCase = listeningPointImpl.getTransport().toUpperCase();
        this.listeningPoints.clear();
        this.listeningPoints.put(upperCase, interfaceC17579nC3);
    }

    protected void stop() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Exiting provider");
        }
        Iterator<InterfaceC17579nC3> it = this.listeningPoints.values().iterator();
        while (it.hasNext()) {
            ((ListeningPointImpl) it.next()).removeSipProvider();
        }
        this.eventScanner.stop();
    }

    @Override // android.gov.nist.javax.sip.stack.SIPTransactionEventListener
    public void transactionErrorEvent(SIPTransactionErrorEvent sIPTransactionErrorEvent) {
        C3626Bq7 c3626Bq7;
        C3626Bq7 c3626Bq72;
        SIPTransaction sIPTransaction = (SIPTransaction) sIPTransactionErrorEvent.getSource();
        if (sIPTransactionErrorEvent.getErrorID() == 2) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("TransportError occured on " + sIPTransaction);
            }
            Object source = sIPTransactionErrorEvent.getSource();
            C25169zq7 c25169zq7 = C25169zq7.d;
            if (source instanceof SIPServerTransaction) {
                c3626Bq72 = new C3626Bq7(this, (InterfaceC5278Iq6) source, c25169zq7);
            } else {
                FY2 nextHop = ((SIPClientTransaction) source).getNextHop();
                if (this.sipStack.getRouter() instanceof RouterExt) {
                    ((RouterExt) this.sipStack.getRouter()).transactionTimeout(nextHop);
                }
                c3626Bq72 = new C3626Bq7(this, (CV0) source, c25169zq7);
            }
            handleEvent(c3626Bq72, (SIPTransaction) source);
            return;
        }
        if (sIPTransactionErrorEvent.getErrorID() != 1) {
            if (sIPTransactionErrorEvent.getErrorID() == 3) {
                Object source2 = sIPTransactionErrorEvent.getSource();
                if (((InterfaceC10620bu7) source2).getDialog() != null) {
                    InternalErrorHandler.handleException("Unexpected event !", logger);
                }
                C25169zq7 c25169zq72 = C25169zq7.c;
                handleEvent(source2 instanceof SIPServerTransaction ? new C3626Bq7(this, (InterfaceC5278Iq6) source2, c25169zq72) : new C3626Bq7(this, (CV0) source2, c25169zq72), (SIPTransaction) source2);
                return;
            }
            return;
        }
        Object source3 = sIPTransactionErrorEvent.getSource();
        C25169zq7 c25169zq73 = C25169zq7.d;
        if (source3 instanceof SIPServerTransaction) {
            c3626Bq7 = new C3626Bq7(this, (InterfaceC5278Iq6) source3, c25169zq73);
        } else {
            FY2 nextHop2 = ((SIPClientTransaction) source3).getNextHop();
            if (this.sipStack.getRouter() instanceof RouterExt) {
                ((RouterExt) this.sipStack.getRouter()).transactionTimeout(nextHop2);
            }
            c3626Bq7 = new C3626Bq7(this, (CV0) source3, c25169zq73);
        }
        handleEvent(c3626Bq7, (SIPTransaction) source3);
    }

    protected SipProviderImpl(SipStackImpl sipStackImpl) {
        this.dialogErrorsAutomaticallyHandled = true;
        EventScanner eventScanner = sipStackImpl.getEventScanner();
        this.eventScanner = eventScanner;
        this.sipStack = sipStackImpl;
        eventScanner.incrementRefcount();
        this.listeningPoints = new ConcurrentHashMap<>();
        this.automaticDialogSupportEnabled = this.sipStack.isAutomaticDialogSupportEnabled();
        this.dialogErrorsAutomaticallyHandled = this.sipStack.isAutomaticDialogErrorHandlingEnabled();
    }

    @Override // android.gov.nist.javax.sip.SipProviderExt
    public InterfaceC17579nC3 getListeningPoint() {
        if (this.listeningPoints.size() > 0) {
            return this.listeningPoints.values().iterator().next();
        }
        return null;
    }
}
