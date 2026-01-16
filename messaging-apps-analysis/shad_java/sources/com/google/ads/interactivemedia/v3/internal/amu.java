package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amu implements agp<CompanionAdSlot> {
    amu() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agp
    public final /* bridge */ /* synthetic */ agj a(CompanionAdSlot companionAdSlot) {
        CompanionAdSlot companionAdSlot2 = companionAdSlot;
        int width = companionAdSlot2.getWidth();
        int height = companionAdSlot2.getHeight();
        StringBuilder sb = new StringBuilder(23);
        sb.append(width);
        sb.append("x");
        sb.append(height);
        return new ago(sb.toString());
    }
}
