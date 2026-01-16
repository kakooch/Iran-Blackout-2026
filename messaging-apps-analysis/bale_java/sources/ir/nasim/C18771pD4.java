package ir.nasim;

import android.app.PendingIntent;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import ir.nasim.AbstractC16407lD4;

/* renamed from: ir.nasim.pD4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18771pD4 extends AbstractC16407lD4.j {
    int[] e = null;
    MediaSessionCompat.Token f;
    PendingIntent g;

    @Override // ir.nasim.AbstractC16407lD4.j
    public void b(InterfaceC10184bD4 interfaceC10184bD4) {
        AbstractC16998mD4.d(interfaceC10184bD4.a(), AbstractC16998mD4.b(AbstractC16998mD4.a(), this.e, this.f));
    }

    @Override // ir.nasim.AbstractC16407lD4.j
    public RemoteViews i(InterfaceC10184bD4 interfaceC10184bD4) {
        return null;
    }

    @Override // ir.nasim.AbstractC16407lD4.j
    public RemoteViews j(InterfaceC10184bD4 interfaceC10184bD4) {
        return null;
    }

    public C18771pD4 n(PendingIntent pendingIntent) {
        this.g = pendingIntent;
        return this;
    }

    public C18771pD4 o(MediaSessionCompat.Token token) {
        this.f = token;
        return this;
    }

    public C18771pD4 p(int... iArr) {
        this.e = iArr;
        return this;
    }

    public C18771pD4 q(boolean z) {
        return this;
    }
}
