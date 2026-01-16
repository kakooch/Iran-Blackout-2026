package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;

/* loaded from: classes.dex */
public interface PrivacyHeader extends HU2 {
    public static final String NAME = "Privacy";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    /* synthetic */ String getName();

    String getPrivacy();

    void setPrivacy(String str);
}
