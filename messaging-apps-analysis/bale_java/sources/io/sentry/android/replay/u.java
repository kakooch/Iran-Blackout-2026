package io.sentry.android.replay;

import android.content.Context;
import io.sentry.C3165p3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.ED1;
import ir.nasim.XV4;

/* loaded from: classes3.dex */
public final class u {
    public static final a g = new a(null);
    private final int a;
    private final int b;
    private final float c;
    private final float d;
    private final int e;
    private final int f;

    public static final class a {
        private a() {
        }

        private final int a(int i) {
            int i2 = i % 16;
            return i2 <= 8 ? i - i2 : i + (16 - i2);
        }

        public final u b(Context context, C3165p3 c3165p3, int i, int i2) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c3165p3, "sessionReplay");
            float f = i2;
            float f2 = i;
            XV4 xv4A = AbstractC4616Fw7.a(Integer.valueOf(a(AbstractC20723sV3.d((f / context.getResources().getDisplayMetrics().density) * c3165p3.h().sizeScale))), Integer.valueOf(a(AbstractC20723sV3.d((f2 / context.getResources().getDisplayMetrics().density) * c3165p3.h().sizeScale))));
            int iIntValue = ((Number) xv4A.a()).intValue();
            int iIntValue2 = ((Number) xv4A.b()).intValue();
            return new u(iIntValue2, iIntValue, iIntValue2 / f2, iIntValue / f, c3165p3.d(), c3165p3.h().bitRate);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public u(int i, int i2, float f, float f2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = i3;
        this.f = i4;
    }

    public final int a() {
        return this.f;
    }

    public final int b() {
        return this.e;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public final float e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.a == uVar.a && this.b == uVar.b && Float.compare(this.c, uVar.c) == 0 && Float.compare(this.d, uVar.d) == 0 && this.e == uVar.e && this.f == uVar.f;
    }

    public final float f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "ScreenshotRecorderConfig(recordingWidth=" + this.a + ", recordingHeight=" + this.b + ", scaleFactorX=" + this.c + ", scaleFactorY=" + this.d + ", frameRate=" + this.e + ", bitRate=" + this.f + ')';
    }
}
