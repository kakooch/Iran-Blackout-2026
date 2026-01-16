package android.gov.nist.javax.sip.address;

import ir.nasim.FY2;
import ir.nasim.UP5;
import ir.nasim.W46;
import java.util.ListIterator;

/* loaded from: classes.dex */
public interface RouterExt extends W46 {
    @Override // ir.nasim.W46
    /* synthetic */ FY2 getNextHop(UP5 up5);

    /* synthetic */ ListIterator getNextHops(UP5 up5);

    @Override // ir.nasim.W46
    /* synthetic */ FY2 getOutboundProxy();

    void transactionTimeout(FY2 fy2);
}
