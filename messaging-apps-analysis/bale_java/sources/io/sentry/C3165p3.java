package io.sentry;

import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: io.sentry.p3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3165p3 {
    private Double a;
    private Double b;
    private io.sentry.protocol.p m;
    private Set c = new CopyOnWriteArraySet();
    private Set d = new CopyOnWriteArraySet();
    private String e = null;
    private String f = null;
    private a g = a.MEDIUM;
    private int h = 1;
    private long i = 30000;
    private long j = 5000;
    private long k = 3600000;
    private boolean l = true;
    private boolean n = false;

    /* renamed from: io.sentry.p3$a */
    public enum a {
        LOW(0.8f, 50000, 10),
        MEDIUM(1.0f, 75000, 30),
        HIGH(1.0f, 100000, 50);

        public final int bitRate;
        public final int screenshotQuality;
        public final float sizeScale;

        a(float f, int i, int i2) {
            this.sizeScale = f;
            this.bitRate = i;
            this.screenshotQuality = i2;
        }

        public String serializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public C3165p3(boolean z, io.sentry.protocol.p pVar) {
        if (z) {
            return;
        }
        u(true);
        t(true);
        this.c.add("android.webkit.WebView");
        this.c.add("android.widget.VideoView");
        this.c.add("androidx.media3.ui.PlayerView");
        this.c.add("com.google.android.exoplayer2.ui.PlayerView");
        this.c.add("com.google.android.exoplayer2.ui.StyledPlayerView");
        this.m = pVar;
    }

    public void a(String str) {
        this.c.add(str);
    }

    public void b(String str) {
        this.d.add(str);
    }

    public long c() {
        return this.i;
    }

    public int d() {
        return this.h;
    }

    public Set e() {
        return this.c;
    }

    public String f() {
        return this.e;
    }

    public Double g() {
        return this.b;
    }

    public a h() {
        return this.g;
    }

    public io.sentry.protocol.p i() {
        return this.m;
    }

    public long j() {
        return this.k;
    }

    public Double k() {
        return this.a;
    }

    public long l() {
        return this.j;
    }

    public Set m() {
        return this.d;
    }

    public String n() {
        return this.f;
    }

    public boolean o() {
        return this.n;
    }

    public boolean p() {
        return k() != null && k().doubleValue() > 0.0d;
    }

    public boolean q() {
        return g() != null && g().doubleValue() > 0.0d;
    }

    public boolean r() {
        return this.l;
    }

    public void s(boolean z) {
        this.n = z;
    }

    public void t(boolean z) {
        if (z) {
            a("android.widget.ImageView");
            this.d.remove("android.widget.ImageView");
        } else {
            b("android.widget.ImageView");
            this.c.remove("android.widget.ImageView");
        }
    }

    public void u(boolean z) {
        if (z) {
            a("android.widget.TextView");
            this.d.remove("android.widget.TextView");
        } else {
            b("android.widget.TextView");
            this.c.remove("android.widget.TextView");
        }
    }

    public void v(Double d) {
        if (io.sentry.util.y.f(d)) {
            this.b = d;
            return;
        }
        throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    public void w(io.sentry.protocol.p pVar) {
        this.m = pVar;
    }

    public void x(Double d) {
        if (io.sentry.util.y.f(d)) {
            this.a = d;
            return;
        }
        throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }
}
