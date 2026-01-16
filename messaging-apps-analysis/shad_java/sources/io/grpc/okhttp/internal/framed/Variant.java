package io.grpc.okhttp.internal.framed;

import okio.BufferedSink;
import okio.BufferedSource;

/* loaded from: classes3.dex */
public interface Variant {
    FrameReader newReader(BufferedSource bufferedSource, boolean z);

    FrameWriter newWriter(BufferedSink bufferedSink, boolean z);
}
