package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;

/* loaded from: classes.dex */
public interface PMediaAuthorizationHeader extends HU2 {
    public static final String NAME = "P-Media-Authorization";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    /* synthetic */ String getName();

    String getToken();

    void setMediaAuthorizationToken(String str);
}
