package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ach implements abw {
    private final Context a;
    private final abw b;

    public ach(Context context) {
        this(context, cv.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abw
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final acg a() {
        return new acg(this.a, ((acm) this.b).a());
    }

    public ach(Context context, String str) {
        acm acmVar = new acm(str);
        this.a = context.getApplicationContext();
        this.b = acmVar;
    }
}
