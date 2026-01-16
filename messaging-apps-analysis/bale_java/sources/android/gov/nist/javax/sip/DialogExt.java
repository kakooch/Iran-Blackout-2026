package android.gov.nist.javax.sip;

import ir.nasim.C23720xP1;
import ir.nasim.CV0;
import ir.nasim.InterfaceC10620bu7;
import ir.nasim.InterfaceC10981cX5;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.InterfaceC21662tv0;
import ir.nasim.LD6;
import ir.nasim.UP5;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface DialogExt extends InterfaceC17658nL1 {
    /* synthetic */ UP5 createAck(long j);

    /* synthetic */ UP5 createPrack(InterfaceC10981cX5 interfaceC10981cX5);

    /* synthetic */ InterfaceC10981cX5 createReliableProvisionalResponse(int i);

    @Override // ir.nasim.InterfaceC17658nL1
    /* synthetic */ UP5 createRequest(String str);

    /* synthetic */ void delete();

    void disableSequenceNumberValidation();

    /* synthetic */ Object getApplicationData();

    /* synthetic */ InterfaceC21662tv0 getCallId();

    /* synthetic */ String getDialogId();

    /* synthetic */ InterfaceC10620bu7 getFirstTransaction();

    /* synthetic */ InterfaceC16609la getLocalParty();

    /* synthetic */ long getLocalSeqNumber();

    /* synthetic */ int getLocalSequenceNumber();

    /* synthetic */ String getLocalTag();

    InterfaceC17658nL1 getOriginalDialog();

    ReleaseReferencesStrategy getReleaseReferencesStrategy();

    /* synthetic */ InterfaceC16609la getRemoteParty();

    /* synthetic */ long getRemoteSeqNumber();

    /* synthetic */ int getRemoteSequenceNumber();

    /* synthetic */ String getRemoteTag();

    /* synthetic */ InterfaceC16609la getRemoteTarget();

    /* synthetic */ Iterator getRouteSet();

    LD6 getSipProvider();

    @Override // ir.nasim.InterfaceC17658nL1
    /* synthetic */ C23720xP1 getState();

    /* synthetic */ void incrementLocalSequenceNumber();

    boolean isForked();

    /* synthetic */ boolean isSecure();

    /* synthetic */ boolean isServer();

    /* synthetic */ void sendAck(UP5 up5);

    /* synthetic */ void sendReliableProvisionalResponse(InterfaceC10981cX5 interfaceC10981cX5);

    /* synthetic */ void sendRequest(CV0 cv0);

    /* synthetic */ void setApplicationData(Object obj);

    void setBackToBackUserAgent();

    void setEarlyDialogTimeoutSeconds(int i);

    void setReleaseReferencesStrategy(ReleaseReferencesStrategy releaseReferencesStrategy);

    /* synthetic */ void terminateOnBye(boolean z);
}
