package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.header.RetryAfter;
import android.gov.nist.javax.sip.message.MessageFactoryImpl;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.gov.nist.javax.sip.stack.MessageChannel;
import android.gov.nist.javax.sip.stack.SIPClientTransaction;
import android.gov.nist.javax.sip.stack.SIPDialog;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import android.gov.nist.javax.sip.stack.SIPTransaction;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.gov.nist.javax.sip.stack.ServerRequestInterface;
import android.gov.nist.javax.sip.stack.ServerResponseInterface;
import android.javax.sip.SipException;
import ir.nasim.C13253fu7;
import ir.nasim.C23720xP1;
import ir.nasim.HU2;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC5044Hq6;

/* loaded from: classes.dex */
class DialogFilter implements ServerRequestInterface, ServerResponseInterface {
    private static StackLogger logger = CommonLogger.getLogger(DialogFilter.class);
    protected ListeningPointImpl listeningPoint;
    private SIPTransactionStack sipStack;
    protected SIPTransaction transactionChannel;

    public DialogFilter(SIPTransactionStack sIPTransactionStack) {
        this.sipStack = sIPTransactionStack;
    }

    private void sendBadRequestResponse(SIPRequest sIPRequest, SIPServerTransaction sIPServerTransaction, String str) {
        if (sIPServerTransaction.getState() != C13253fu7.i) {
            SIPResponse sIPResponseCreateResponse = sIPRequest.createResponse(400);
            if (str != null) {
                sIPResponseCreateResponse.setReasonPhrase(str);
            }
            InterfaceC5044Hq6 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
            if (defaultServerHeader != null) {
                sIPResponseCreateResponse.setHeader(defaultServerHeader);
            }
            try {
                if (sIPRequest.getMethod().equals(TokenNames.INVITE)) {
                    this.sipStack.addTransactionPendingAck(sIPServerTransaction);
                }
                sIPServerTransaction.sendResponse(sIPResponseCreateResponse);
                sIPServerTransaction.releaseSem();
            } catch (Exception e) {
                logger.logError("Problem sending error response", e);
                sIPServerTransaction.releaseSem();
                this.sipStack.removeTransaction(sIPServerTransaction);
            }
        }
    }

    private void sendCallOrTransactionDoesNotExistResponse(SIPRequest sIPRequest, SIPServerTransaction sIPServerTransaction) {
        if (sIPServerTransaction.getState() != C13253fu7.i) {
            SIPResponse sIPResponseCreateResponse = sIPRequest.createResponse(481);
            InterfaceC5044Hq6 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
            if (defaultServerHeader != null) {
                sIPResponseCreateResponse.setHeader(defaultServerHeader);
            }
            try {
                if (sIPRequest.getMethod().equals(TokenNames.INVITE)) {
                    this.sipStack.addTransactionPendingAck(sIPServerTransaction);
                }
                sIPServerTransaction.sendResponse(sIPResponseCreateResponse);
                sIPServerTransaction.releaseSem();
            } catch (Exception e) {
                logger.logError("Problem sending error response", e);
                sIPServerTransaction.releaseSem();
                this.sipStack.removeTransaction(sIPServerTransaction);
            }
        }
    }

    private void sendLoopDetectedResponse(SIPRequest sIPRequest, SIPServerTransaction sIPServerTransaction) {
        SIPResponse sIPResponseCreateResponse = sIPRequest.createResponse(482);
        if (sIPServerTransaction.getState() != C13253fu7.i) {
            InterfaceC5044Hq6 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
            if (defaultServerHeader != null) {
                sIPResponseCreateResponse.setHeader(defaultServerHeader);
            }
            try {
                this.sipStack.addTransactionPendingAck(sIPServerTransaction);
                sIPServerTransaction.sendResponse(sIPResponseCreateResponse);
                sIPServerTransaction.releaseSem();
            } catch (Exception e) {
                logger.logError("Problem sending error response", e);
                sIPServerTransaction.releaseSem();
                this.sipStack.removeTransaction(sIPServerTransaction);
            }
        }
    }

    private void sendRequestPendingResponse(SIPRequest sIPRequest, SIPServerTransaction sIPServerTransaction) {
        if (sIPServerTransaction.getState() != C13253fu7.i) {
            InterfaceC10981cX5 interfaceC10981cX5CreateResponse = sIPRequest.createResponse(491);
            HU2 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
            if (defaultServerHeader != null) {
                interfaceC10981cX5CreateResponse.setHeader(defaultServerHeader);
            }
            try {
                RetryAfter retryAfter = new RetryAfter();
                retryAfter.setRetryAfter(1);
                interfaceC10981cX5CreateResponse.setHeader(retryAfter);
                if (sIPRequest.getMethod().equals(TokenNames.INVITE)) {
                    this.sipStack.addTransactionPendingAck(sIPServerTransaction);
                }
                sIPServerTransaction.sendResponse(interfaceC10981cX5CreateResponse);
                sIPServerTransaction.releaseSem();
            } catch (Exception e) {
                logger.logError("Problem sending error response", e);
                sIPServerTransaction.releaseSem();
                this.sipStack.removeTransaction(sIPServerTransaction);
            }
        }
    }

    private void sendServerInternalErrorResponse(SIPRequest sIPRequest, SIPServerTransaction sIPServerTransaction) {
        if (sIPServerTransaction.getState() != C13253fu7.i) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Sending 500 response for out of sequence message");
            }
            InterfaceC10981cX5 interfaceC10981cX5CreateResponse = sIPRequest.createResponse(SIPTransactionStack.BASE_TIMER_INTERVAL);
            interfaceC10981cX5CreateResponse.setReasonPhrase("Request out of order");
            if (MessageFactoryImpl.getDefaultServerHeader() != null) {
                interfaceC10981cX5CreateResponse.setHeader(MessageFactoryImpl.getDefaultServerHeader());
            }
            try {
                RetryAfter retryAfter = new RetryAfter();
                retryAfter.setRetryAfter(10);
                interfaceC10981cX5CreateResponse.setHeader(retryAfter);
                this.sipStack.addTransactionPendingAck(sIPServerTransaction);
                sIPServerTransaction.sendResponse(interfaceC10981cX5CreateResponse);
                sIPServerTransaction.releaseSem();
            } catch (Exception e) {
                logger.logError("Problem sending response", e);
                sIPServerTransaction.releaseSem();
                this.sipStack.removeTransaction(sIPServerTransaction);
            }
        }
    }

    private void sendTryingResponse(SIPRequest sIPRequest, SIPServerTransaction sIPServerTransaction) {
        SIPResponse sIPResponseCreateResponse = sIPRequest.createResponse(100);
        if (sIPServerTransaction.getState() != C13253fu7.i) {
            InterfaceC5044Hq6 defaultServerHeader = MessageFactoryImpl.getDefaultServerHeader();
            if (defaultServerHeader != null) {
                sIPResponseCreateResponse.setHeader(defaultServerHeader);
            }
            try {
                sIPServerTransaction.sendResponse(sIPResponseCreateResponse);
                sIPServerTransaction.releaseSem();
            } catch (Exception e) {
                logger.logError("Problem sending error response", e);
                sIPServerTransaction.releaseSem();
                this.sipStack.removeTransaction(sIPServerTransaction);
            }
        }
    }

    public String getProcessingInfo() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:411:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0851 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0873  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0a8e  */
    /* JADX WARN: Removed duplicated region for block: B:545:0x08d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.gov.nist.javax.sip.stack.ServerRequestInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processRequest(android.gov.nist.javax.sip.message.SIPRequest r21, android.gov.nist.javax.sip.stack.MessageChannel r22) {
        /*
            Method dump skipped, instructions count: 2730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.DialogFilter.processRequest(android.gov.nist.javax.sip.message.SIPRequest, android.gov.nist.javax.sip.stack.MessageChannel):void");
    }

    @Override // android.gov.nist.javax.sip.stack.ServerResponseInterface
    public void processResponse(SIPResponse sIPResponse, MessageChannel messageChannel, SIPDialog sIPDialog) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("PROCESSING INCOMING RESPONSE" + ((Object) sIPResponse.encodeMessage(new StringBuilder())));
        }
        if (this.listeningPoint == null) {
            if (logger.isLoggingEnabled()) {
                logger.logError("Dropping message: No listening point registered!");
                return;
            }
            return;
        }
        if (this.sipStack.checkBranchId() && !Utils.getInstance().responseBelongsToUs(sIPResponse)) {
            if (logger.isLoggingEnabled()) {
                logger.logError("Dropping response - topmost VIA header does not originate from this stack");
                return;
            }
            return;
        }
        SipProviderImpl provider = this.listeningPoint.getProvider();
        if (provider == null) {
            if (logger.isLoggingEnabled()) {
                logger.logError("Dropping message:  no provider");
                return;
            }
            return;
        }
        if (provider.getSipListener() == null) {
            if (logger.isLoggingEnabled()) {
                logger.logError("No listener -- dropping response!");
                return;
            }
            return;
        }
        SIPClientTransaction sIPClientTransaction = (SIPClientTransaction) this.transactionChannel;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Transaction = " + sIPClientTransaction);
        }
        if (sIPClientTransaction != null) {
            ResponseEventExt responseEventExt = new ResponseEventExt(provider, sIPClientTransaction, sIPDialog, sIPResponse);
            if (this.sipStack.getMaxForkTime() != 0 && SIPTransactionStack.isDialogCreated(sIPResponse.getCSeqHeader().getMethod())) {
                SIPClientTransaction forkedTransaction = this.sipStack.getForkedTransaction(sIPResponse.getForkId());
                if (sIPDialog != null && forkedTransaction != null) {
                    sIPDialog.checkRetransmissionForForking(sIPResponse);
                    if (forkedTransaction.getDefaultDialog() != null && !sIPDialog.equals(forkedTransaction.getDefaultDialog())) {
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("forkedId= " + sIPResponse.getForkId() + " forked dialog " + sIPDialog + " original tx " + forkedTransaction + " original dialog " + forkedTransaction.getDefaultDialog());
                        }
                        responseEventExt.setOriginalTransaction(forkedTransaction);
                        responseEventExt.setForkedResponse(true);
                    }
                }
            }
            if (sIPDialog != null && sIPResponse.getStatusCode() != 100) {
                sIPDialog.setLastResponse(sIPClientTransaction, sIPResponse);
                sIPClientTransaction.setDialog(sIPDialog, sIPDialog.getDialogId());
            }
            responseEventExt.setRetransmission(sIPResponse.isRetransmission());
            responseEventExt.setRemoteIpAddress(sIPResponse.getRemoteAddress().getHostAddress());
            responseEventExt.setRemotePort(sIPResponse.getRemotePort());
            provider.handleEvent(responseEventExt, sIPClientTransaction);
            return;
        }
        if (sIPDialog != null) {
            if (sIPResponse.getStatusCode() / 100 != 2) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Response is not a final response and dialog is found for response -- dropping response!");
                    return;
                }
                return;
            }
            if (sIPDialog.getState() == C23720xP1.g) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Dialog is terminated -- dropping response!");
                    return;
                }
                return;
            } else if (sIPDialog.isAckSeen() && sIPDialog.isAckSent() && sIPDialog.isLastAckPresent() && sIPDialog.getLastAckSentCSeq().getSeqNumber() == sIPResponse.getCSeq().getSeqNumber() && sIPResponse.getCSeq().getMethod().equals(sIPDialog.getMethod())) {
                try {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("Retransmission of OK detected: Resending last ACK");
                    }
                    sIPDialog.resendAck();
                    return;
                } catch (SipException e) {
                    logger.logError("could not resend ack", e);
                }
            }
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("could not find tx, handling statelessly Dialog =  " + sIPDialog);
        }
        ResponseEventExt responseEventExt2 = new ResponseEventExt(provider, sIPClientTransaction, sIPDialog, sIPResponse);
        if (this.sipStack.getMaxForkTime() != 0 && SIPTransactionStack.isDialogCreated(sIPResponse.getCSeqHeader().getMethod())) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Trying to find forked Transaction for forked id " + sIPResponse.getForkId());
            }
            SIPClientTransaction forkedTransaction2 = this.sipStack.getForkedTransaction(sIPResponse.getForkId());
            if (sIPDialog != null && forkedTransaction2 != null) {
                sIPDialog.checkRetransmissionForForking(sIPResponse);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("original dialog " + forkedTransaction2.getDefaultDialog() + " forked dialog " + sIPDialog);
                }
                if (forkedTransaction2.getDefaultDialog() != null && !sIPDialog.equals(forkedTransaction2.getDefaultDialog())) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("forkedId= " + sIPResponse.getForkId() + " forked dialog " + sIPDialog + " original tx " + forkedTransaction2 + " original dialog " + forkedTransaction2.getDefaultDialog());
                    }
                    responseEventExt2.setOriginalTransaction(forkedTransaction2);
                    responseEventExt2.setForkedResponse(true);
                    if (sIPClientTransaction == null && sIPDialog.getState() == C23720xP1.d && sIPResponse.getStatusCode() >= 200 && sIPResponse.getStatusCode() < 300) {
                        sIPDialog.setLastResponse(sIPClientTransaction, sIPResponse);
                    }
                }
            }
        }
        responseEventExt2.setRetransmission(sIPResponse.isRetransmission());
        responseEventExt2.setRemoteIpAddress(sIPResponse.getRemoteAddress().getHostAddress());
        responseEventExt2.setRemotePort(sIPResponse.getRemotePort());
        provider.handleEvent(responseEventExt2, sIPClientTransaction);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c1  */
    @Override // android.gov.nist.javax.sip.stack.ServerResponseInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processResponse(android.gov.nist.javax.sip.message.SIPResponse r12, android.gov.nist.javax.sip.stack.MessageChannel r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 921
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.DialogFilter.processResponse(android.gov.nist.javax.sip.message.SIPResponse, android.gov.nist.javax.sip.stack.MessageChannel):void");
    }
}
