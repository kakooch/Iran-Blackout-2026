package io.sentry.android.replay;

import ir.nasim.AbstractC13042fc3;
import java.io.File;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public final class b {
    private final File a;
    private final int b;
    private final long c;

    public b(File file, int i, long j) {
        AbstractC13042fc3.i(file, MediaStreamTrack.VIDEO_TRACK_KIND);
        this.a = file;
        this.b = i;
        this.c = j;
    }

    public final File a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "GeneratedVideo(video=" + this.a + ", frameCount=" + this.b + ", duration=" + this.c + ')';
    }
}
