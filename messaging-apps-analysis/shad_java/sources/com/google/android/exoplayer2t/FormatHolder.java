package com.google.android.exoplayer2t;

import com.google.android.exoplayer2t.drm.DrmSession;

/* loaded from: classes.dex */
public final class FormatHolder {
    public DrmSession<?> drmSession;
    public Format format;
    public boolean includesDrmSession;

    public void clear() {
        this.includesDrmSession = false;
        this.drmSession = null;
        this.format = null;
    }
}
