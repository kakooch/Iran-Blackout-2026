package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;

/* loaded from: classes3.dex */
public class ProtoStorageClientModule {
    public ProtoStorageClient providesProtoStorageClientForCampaign(Application application) {
        return new ProtoStorageClient(application, "fiam_eligible_campaigns_cache_file");
    }

    public ProtoStorageClient providesProtoStorageClientForImpressionStore(Application application) {
        return new ProtoStorageClient(application, "fiam_impressions_store_file");
    }

    public ProtoStorageClient providesProtoStorageClientForLimiterStore(Application application) {
        return new ProtoStorageClient(application, "rate_limit_store_file");
    }
}
