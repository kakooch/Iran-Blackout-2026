package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSpec;

/* loaded from: classes.dex */
public final class DashUtil {
    public static DataSpec buildDataSpec(Representation representation, RangedUri rangedUri) {
        return new DataSpec.Builder().setUri(rangedUri.resolveUri(representation.baseUrl)).setPosition(rangedUri.start).setLength(rangedUri.length).setKey(representation.getCacheKey()).build();
    }
}
