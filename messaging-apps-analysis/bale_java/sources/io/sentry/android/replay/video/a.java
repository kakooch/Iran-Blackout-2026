package io.sentry.android.replay.video;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.io.File;

/* loaded from: classes3.dex */
public final class a {
    private final File a;
    private int b;
    private int c;
    private final int d;
    private final int e;
    private final String f;

    public a(File file, int i, int i2, int i3, int i4, String str) {
        AbstractC13042fc3.i(file, "file");
        AbstractC13042fc3.i(str, "mimeType");
        this.a = file;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = str;
    }

    public final int a() {
        return this.e;
    }

    public final File b() {
        return this.a;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        return this.f;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f);
    }

    public final int f() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "MuxerConfig(file=" + this.a + ", recordingWidth=" + this.b + ", recordingHeight=" + this.c + ", frameRate=" + this.d + ", bitRate=" + this.e + ", mimeType=" + this.f + ')';
    }

    public /* synthetic */ a(File file, int i, int i2, int i3, int i4, String str, int i5, ED1 ed1) {
        this(file, i, i2, i3, i4, (i5 & 32) != 0 ? "video/avc" : str);
    }
}
