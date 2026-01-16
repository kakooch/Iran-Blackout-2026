package android.gov.nist.javax.sip;

import ir.nasim.C13253fu7;
import ir.nasim.InterfaceC10620bu7;
import ir.nasim.InterfaceC17658nL1;
import ir.nasim.LD6;
import ir.nasim.UP5;
import java.security.cert.Certificate;
import java.util.List;

/* loaded from: classes.dex */
public interface TransactionExt extends InterfaceC10620bu7 {
    List<String> extractCertIdentities();

    /* synthetic */ Object getApplicationData();

    /* synthetic */ String getBranchId();

    String getCipherSuite();

    /* synthetic */ InterfaceC17658nL1 getDialog();

    String getHost();

    Certificate[] getLocalCertificates();

    String getPeerAddress();

    Certificate[] getPeerCertificates();

    int getPeerPort();

    int getPort();

    ReleaseReferencesStrategy getReleaseReferencesStrategy();

    /* synthetic */ UP5 getRequest();

    /* synthetic */ int getRetransmitTimer();

    LD6 getSipProvider();

    /* synthetic */ C13253fu7 getState();

    int getTimerD();

    int getTimerT2();

    int getTimerT4();

    String getTransport();

    /* synthetic */ void setApplicationData(Object obj);

    void setReleaseReferencesStrategy(ReleaseReferencesStrategy releaseReferencesStrategy);

    /* synthetic */ void setRetransmitTimer(int i);

    void setTimerD(int i);

    void setTimerT2(int i);

    void setTimerT4(int i);

    /* synthetic */ void terminate();
}
