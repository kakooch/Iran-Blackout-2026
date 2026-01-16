package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/* renamed from: io.appmetrica.analytics.impl.i4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2604i4 {
    public final Bl a;
    public final S b;
    public final Context c;

    public C2604i4(Bl bl, S s, Context context) {
        this.a = bl;
        this.b = s;
        this.c = context;
    }

    public final C2580h4 a(HashMap map) throws ExecutionException, InterruptedException {
        C2549fl c2549flE = this.a.e();
        S s = this.b;
        Context context = this.c;
        s.getClass();
        AdvertisingIdsHolder advertisingIdsHolderA = s.a(context, new C2780pd());
        return new C2580h4(C2580h4.a(c2549flE.d), C2580h4.a(c2549flE.a), C2580h4.a(c2549flE.b), C2580h4.a(c2549flE.j), C2580h4.a(c2549flE.i), C2580h4.a(Ya.a(Gl.a(c2549flE.k))), C2580h4.a(Ya.a(map)), new IdentifiersResult(advertisingIdsHolderA.getGoogle().mAdTrackingInfo == null ? null : advertisingIdsHolderA.getGoogle().mAdTrackingInfo.advId, advertisingIdsHolderA.getGoogle().mStatus, advertisingIdsHolderA.getGoogle().mErrorExplanation), new IdentifiersResult(advertisingIdsHolderA.getHuawei().mAdTrackingInfo == null ? null : advertisingIdsHolderA.getHuawei().mAdTrackingInfo.advId, advertisingIdsHolderA.getHuawei().mStatus, advertisingIdsHolderA.getHuawei().mErrorExplanation), new IdentifiersResult(advertisingIdsHolderA.getYandex().mAdTrackingInfo != null ? advertisingIdsHolderA.getYandex().mAdTrackingInfo.advId : null, advertisingIdsHolderA.getYandex().mStatus, advertisingIdsHolderA.getYandex().mErrorExplanation), C2580h4.a(Ya.a(c2549flE.h)), Em.a(), c2549flE.o + c2549flE.A.a, C2580h4.a(c2549flE.n.f));
    }
}
