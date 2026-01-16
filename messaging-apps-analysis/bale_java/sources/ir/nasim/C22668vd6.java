package ir.nasim;

import android.app.Notification;
import android.content.Intent;

/* renamed from: ir.nasim.vd6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22668vd6 {
    private final Intent a;
    private final Integer b;
    private final Notification c;
    private final SA2 d;

    public C22668vd6(Intent intent, Integer num, Notification notification, SA2 sa2) {
        AbstractC13042fc3.i(intent, "mediaProjectionPermissionResultData");
        this.a = intent;
        this.b = num;
        this.c = notification;
        this.d = sa2;
    }

    public final Intent a() {
        return this.a;
    }

    public final Notification b() {
        return this.c;
    }

    public final Integer c() {
        return this.b;
    }

    public final SA2 d() {
        return this.d;
    }

    public /* synthetic */ C22668vd6(Intent intent, Integer num, Notification notification, SA2 sa2, int i, ED1 ed1) {
        this(intent, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : notification, (i & 8) != 0 ? null : sa2);
    }
}
