package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class SsUtil {
    public static Uri fixManifestUri(Uri manifestUri) {
        String lastPathSegment = manifestUri.getLastPathSegment();
        return (lastPathSegment == null || !Util.toLowerInvariant(lastPathSegment).matches("manifest(\\(.+\\))?")) ? Uri.withAppendedPath(manifestUri, "Manifest") : manifestUri;
    }
}
