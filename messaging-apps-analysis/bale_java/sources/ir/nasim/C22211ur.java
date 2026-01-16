package ir.nasim;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: ir.nasim.ur, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22211ur implements InterfaceC9638aI7 {
    private final Context a;

    public C22211ur(Context context) {
        this.a = context;
    }

    @Override // ir.nasim.InterfaceC9638aI7
    public void a(String str) {
        try {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException e) {
            throw new IllegalArgumentException("Can't open " + str + '.', e);
        }
    }
}
