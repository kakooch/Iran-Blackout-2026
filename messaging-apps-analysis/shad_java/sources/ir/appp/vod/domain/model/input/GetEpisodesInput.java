package ir.appp.vod.domain.model.input;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetEpisodesInput.kt */
/* loaded from: classes3.dex */
public final class GetEpisodesInput {
    public GetEpisodesInput(String mediaId, String seasonId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(seasonId, "seasonId");
    }
}
