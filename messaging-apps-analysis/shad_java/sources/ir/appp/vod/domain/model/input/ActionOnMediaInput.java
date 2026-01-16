package ir.appp.vod.domain.model.input;

import ir.appp.vod.domain.model.output.VodMediaEntity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionOnMediaInput.kt */
/* loaded from: classes3.dex */
public final class ActionOnMediaInput {
    public ActionOnMediaInput(String mediaId, VodMediaEntity.LikeStatus action) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(action, "action");
    }
}
