package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import ir.nasim.AbstractC9766aX0;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.zb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3017zb {
    public static List a(Configuration configuration) {
        return AndroidUtils.isApiAchieved(24) ? Ab.a(configuration) : AbstractC9766aX0.e(Vd.a(configuration.locale));
    }
}
