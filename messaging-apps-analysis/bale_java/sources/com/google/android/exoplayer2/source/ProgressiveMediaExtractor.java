package com.google.android.exoplayer2.source;

import android.net.Uri;
import ir.nasim.C15493jg5;
import ir.nasim.C8292Vi5;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC18631oz1;
import java.util.Map;

/* loaded from: classes2.dex */
public interface ProgressiveMediaExtractor {

    public interface Factory {
        ProgressiveMediaExtractor a(C15493jg5 c15493jg5);
    }

    void a(long j, long j2);

    int b(C8292Vi5 c8292Vi5);

    void c(InterfaceC18631oz1 interfaceC18631oz1, Uri uri, Map map, long j, long j2, InterfaceC10465bf2 interfaceC10465bf2);

    void d();

    long e();

    void release();
}
