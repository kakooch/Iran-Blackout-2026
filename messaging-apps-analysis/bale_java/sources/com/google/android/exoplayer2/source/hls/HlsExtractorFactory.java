package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.X;
import ir.nasim.C15493jg5;
import ir.nasim.C5045Hq7;
import ir.nasim.InterfaceC9845af2;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface HlsExtractorFactory {
    public static final HlsExtractorFactory a = new DefaultHlsExtractorFactory();

    HlsMediaChunkExtractor a(Uri uri, X x, List list, C5045Hq7 c5045Hq7, Map map, InterfaceC9845af2 interfaceC9845af2, C15493jg5 c15493jg5);
}
