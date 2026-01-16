package android.gov.nist.javax.sip;

import ir.nasim.CV0;
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

/* loaded from: classes.dex */
public interface SipProviderExt extends LD6 {
    /* synthetic */ void addListeningPoint(InterfaceC17579nC3 interfaceC17579nC3);

    /* synthetic */ void addSipListener(KD6 kd6);

    /* synthetic */ InterfaceC17579nC3 getListeningPoint();

    /* synthetic */ InterfaceC17579nC3 getListeningPoint(String str);

    /* synthetic */ InterfaceC17579nC3[] getListeningPoints();

    /* synthetic */ InterfaceC21662tv0 getNewCallId();

    @Override // ir.nasim.LD6
    /* synthetic */ CV0 getNewClientTransaction(UP5 up5);

    /* synthetic */ InterfaceC17658nL1 getNewDialog(InterfaceC10620bu7 interfaceC10620bu7);

    /* synthetic */ InterfaceC5278Iq6 getNewServerTransaction(UP5 up5);

    /* synthetic */ MD6 getSipStack();

    /* synthetic */ void removeListeningPoint(InterfaceC17579nC3 interfaceC17579nC3);

    /* synthetic */ void removeSipListener(KD6 kd6);

    /* synthetic */ void sendRequest(UP5 up5);

    /* synthetic */ void sendResponse(InterfaceC10981cX5 interfaceC10981cX5);

    /* synthetic */ void setAutomaticDialogSupportEnabled(boolean z);

    void setDialogErrorsAutomaticallyHandled();

    /* synthetic */ void setListeningPoint(InterfaceC17579nC3 interfaceC17579nC3);
}
