package ir.nasim;

import livekit.org.webrtc.RtpParameters;

/* renamed from: ir.nasim.aT7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9737aT7 {
    private final int a;
    private final int b;

    public C9737aT7(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public static /* synthetic */ C9737aT7 b(C9737aT7 c9737aT7, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = c9737aT7.a;
        }
        if ((i3 & 2) != 0) {
            i2 = c9737aT7.b;
        }
        return c9737aT7.a(i, i2);
    }

    public static /* synthetic */ RtpParameters.Encoding f(C9737aT7 c9737aT7, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            d = 1.0d;
        }
        return c9737aT7.e(str, d);
    }

    public final C9737aT7 a(int i, int i2) {
        return new C9737aT7(i, i2);
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public final RtpParameters.Encoding e(String str, double d) {
        RtpParameters.Encoding encoding = new RtpParameters.Encoding(str, true, Double.valueOf(d));
        encoding.numTemporalLayers = 1;
        encoding.maxBitrateBps = Integer.valueOf(this.a);
        encoding.maxFramerate = Integer.valueOf(this.b);
        if (d == 1.0d) {
            encoding.networkPriority = 3;
            encoding.bitratePriority = 4.0d;
        } else {
            encoding.networkPriority = 1;
            encoding.bitratePriority = 1.0d;
        }
        return encoding;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9737aT7)) {
            return false;
        }
        C9737aT7 c9737aT7 = (C9737aT7) obj;
        return this.a == c9737aT7.a && this.b == c9737aT7.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "VideoEncoding(maxBitrate=" + this.a + ", maxFps=" + this.b + ')';
    }
}
