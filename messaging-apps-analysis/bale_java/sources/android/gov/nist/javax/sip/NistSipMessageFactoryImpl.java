package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.message.SIPMessage;
import android.gov.nist.javax.sip.message.SIPRequest;
import android.gov.nist.javax.sip.message.SIPResponse;
import android.gov.nist.javax.sip.stack.MessageChannel;
import android.gov.nist.javax.sip.stack.SIPTransaction;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.gov.nist.javax.sip.stack.ServerRequestInterface;
import android.gov.nist.javax.sip.stack.ServerResponseInterface;
import android.gov.nist.javax.sip.stack.StackMessageFactory;

/* loaded from: classes.dex */
class NistSipMessageFactoryImpl implements StackMessageFactory {
    private static StackLogger logger = CommonLogger.getLogger(NistSipMessageFactoryImpl.class);
    private SIPTransactionStack sipStack;

    public NistSipMessageFactoryImpl(SIPTransactionStack sIPTransactionStack) {
        this.sipStack = sIPTransactionStack;
    }

    @Override // android.gov.nist.javax.sip.stack.StackMessageFactory
    public ServerRequestInterface newSIPServerRequest(SIPRequest sIPRequest, SIPTransaction sIPTransaction) {
        if (sIPTransaction == null || sIPRequest == null) {
            throw new IllegalArgumentException("Null Arg!");
        }
        DialogFilter dialogFilter = new DialogFilter(sIPTransaction.getSIPStack());
        dialogFilter.transactionChannel = sIPTransaction;
        ListeningPointImpl listeningPoint = sIPTransaction.getMessageProcessor().getListeningPoint();
        dialogFilter.listeningPoint = listeningPoint;
        if (listeningPoint == null) {
            return null;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Returning request interface for " + sIPRequest.getFirstLine() + Separators.SP + dialogFilter + " sipTransaction = " + sIPTransaction);
        }
        return dialogFilter;
    }

    @Override // android.gov.nist.javax.sip.stack.StackMessageFactory
    public ServerResponseInterface newSIPServerResponse(SIPResponse sIPResponse, MessageChannel messageChannel) throws Throwable {
        SIPTransaction sIPTransactionFindTransaction = this.sipStack.findTransaction((SIPMessage) sIPResponse, false);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Found Transaction " + sIPTransactionFindTransaction + " for " + sIPResponse);
        }
        if (sIPTransactionFindTransaction != null) {
            if (sIPTransactionFindTransaction.getInternalState() < 0) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Dropping response - null transaction state");
                }
                return null;
            }
            if (3 == sIPTransactionFindTransaction.getInternalState() && sIPResponse.getStatusCode() / 100 == 1) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Dropping response - late arriving " + sIPResponse.getStatusCode());
                }
                return null;
            }
        }
        DialogFilter dialogFilter = new DialogFilter(this.sipStack);
        dialogFilter.transactionChannel = sIPTransactionFindTransaction;
        dialogFilter.listeningPoint = messageChannel.getMessageProcessor().getListeningPoint();
        return dialogFilter;
    }
}
