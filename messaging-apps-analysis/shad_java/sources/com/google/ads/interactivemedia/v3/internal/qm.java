package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes.dex */
final /* synthetic */ class qm implements qu {
    static final qu a = new qm();

    private qm() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qu
    public final int a(Object obj) {
        int i = qv.a;
        String str = ((qg) obj).a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (aeu.a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
