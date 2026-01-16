package android.gov.nist.javax.sip.header.ims;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface SecurityVerifyHeader extends SecurityAgreeHeader {
    public static final String NAME = "Security-Verify";

    @Override // android.gov.nist.javax.sip.header.ims.SecurityAgreeHeader, ir.nasim.HU2
    /* synthetic */ Object clone();

    @Override // android.gov.nist.javax.sip.header.ims.SecurityAgreeHeader
    /* synthetic */ String getName();

    @Override // android.gov.nist.javax.sip.header.ims.SecurityAgreeHeader, ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // android.gov.nist.javax.sip.header.ims.SecurityAgreeHeader, ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    @Override // android.gov.nist.javax.sip.header.ims.SecurityAgreeHeader, ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    @Override // android.gov.nist.javax.sip.header.ims.SecurityAgreeHeader, ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);
}
