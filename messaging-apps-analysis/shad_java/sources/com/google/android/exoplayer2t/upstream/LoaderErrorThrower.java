package com.google.android.exoplayer2t.upstream;

import java.io.IOException;

/* loaded from: classes.dex */
public interface LoaderErrorThrower {

    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.google.android.exoplayer2t.upstream.LoaderErrorThrower
        public void maybeThrowError() throws IOException {
        }
    }

    void maybeThrowError() throws IOException;
}
