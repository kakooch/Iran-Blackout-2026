package org.webrtc;

import android.media.MediaCodecInfo;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: org.webrtc.-$$Lambda$MediaCodecUtils$2a7tPlee9qsf_7lHzR8WPINZSpo, reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$MediaCodecUtils$2a7tPlee9qsf_7lHzR8WPINZSpo implements Comparator, j$.util.Comparator {
    public static final /* synthetic */ $$Lambda$MediaCodecUtils$2a7tPlee9qsf_7lHzR8WPINZSpo INSTANCE = new $$Lambda$MediaCodecUtils$2a7tPlee9qsf_7lHzR8WPINZSpo();

    private /* synthetic */ $$Lambda$MediaCodecUtils$2a7tPlee9qsf_7lHzR8WPINZSpo() {
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((MediaCodecInfo) obj).getName().compareTo(((MediaCodecInfo) obj2).getName());
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ Comparator reversed() {
        return Collections.reverseOrder(this);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ Comparator thenComparing(Function function) {
        return a.E(this, Comparator.CC.comparing(function));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }
}
