package ir.nasim;

import android.app.PendingIntent;
import java.util.List;

/* loaded from: classes3.dex */
final class Wg8 extends PI6 {
    private final int a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final List f;
    private final List g;
    private final PendingIntent h;
    private final List i;

    Wg8(int i, int i2, int i3, long j, long j2, List list, List list2, PendingIntent pendingIntent, List list3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = j2;
        this.f = list;
        this.g = list2;
        this.h = pendingIntent;
        this.i = list3;
    }

    @Override // ir.nasim.PI6
    public final long a() {
        return this.d;
    }

    @Override // ir.nasim.PI6
    public final int b() {
        return this.c;
    }

    @Override // ir.nasim.PI6
    public final PendingIntent c() {
        return this.h;
    }

    @Override // ir.nasim.PI6
    public final int d() {
        return this.a;
    }

    @Override // ir.nasim.PI6
    public final int e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        List list;
        List list2;
        PendingIntent pendingIntent;
        List list3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof PI6) {
            PI6 pi6 = (PI6) obj;
            if (this.a == pi6.d() && this.b == pi6.e() && this.c == pi6.b() && this.d == pi6.a() && this.e == pi6.f() && ((list = this.f) != null ? list.equals(pi6.h()) : pi6.h() == null) && ((list2 = this.g) != null ? list2.equals(pi6.g()) : pi6.g() == null) && ((pendingIntent = this.h) != null ? pendingIntent.equals(pi6.c()) : pi6.c() == null) && ((list3 = this.i) != null ? list3.equals(pi6.i()) : pi6.i() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.PI6
    public final long f() {
        return this.e;
    }

    @Override // ir.nasim.PI6
    final List g() {
        return this.g;
    }

    @Override // ir.nasim.PI6
    final List h() {
        return this.f;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        long j = this.d;
        long j2 = this.e;
        int i4 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List list = this.f;
        int iHashCode = (i4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.g;
        int iHashCode2 = (iHashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.h;
        int iHashCode3 = (iHashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List list3 = this.i;
        return iHashCode3 ^ (list3 != null ? list3.hashCode() : 0);
    }

    @Override // ir.nasim.PI6
    final List i() {
        return this.i;
    }

    public final String toString() {
        return "SplitInstallSessionState{sessionId=" + this.a + ", status=" + this.b + ", errorCode=" + this.c + ", bytesDownloaded=" + this.d + ", totalBytesToDownload=" + this.e + ", moduleNamesNullable=" + String.valueOf(this.f) + ", languagesNullable=" + String.valueOf(this.g) + ", resolutionIntent=" + String.valueOf(this.h) + ", splitFileIntents=" + String.valueOf(this.i) + "}";
    }
}
