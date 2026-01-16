package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.C2035j;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC9683aN7;

/* renamed from: com.google.android.exoplayer2.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2035j implements InterfaceC2029g {
    public static final C2035j d = new C2035j(0, 0, 0);
    private static final String e = AbstractC9683aN7.r0(0);
    private static final String f = AbstractC9683aN7.r0(1);
    private static final String g = AbstractC9683aN7.r0(2);
    public static final InterfaceC2029g.a h = new InterfaceC2029g.a() { // from class: ir.nasim.YJ1
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C2035j.c(bundle);
        }
    };
    public final int a;
    public final int b;
    public final int c;

    public C2035j(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C2035j c(Bundle bundle) {
        return new C2035j(bundle.getInt(e, 0), bundle.getInt(f, 0), bundle.getInt(g, 0));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(e, this.a);
        bundle.putInt(f, this.b);
        bundle.putInt(g, this.c);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2035j)) {
            return false;
        }
        C2035j c2035j = (C2035j) obj;
        return this.a == c2035j.a && this.b == c2035j.b && this.c == c2035j.c;
    }

    public int hashCode() {
        return ((((527 + this.a) * 31) + this.b) * 31) + this.c;
    }
}
