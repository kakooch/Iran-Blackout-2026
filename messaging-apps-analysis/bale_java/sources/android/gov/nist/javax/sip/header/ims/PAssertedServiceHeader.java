package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;

/* loaded from: classes.dex */
public interface PAssertedServiceHeader extends HU2 {
    public static final String NAME = "P-Asserted-Service";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getApplicationIdentifiers();

    /* synthetic */ String getName();

    String getSubserviceIdentifiers();

    void setApplicationIdentifiers(String str);

    void setSubserviceIdentifiers(String str);
}
