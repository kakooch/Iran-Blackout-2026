package ir.nasim;

import android.net.Uri;
import com.google.android.gms.internal.gtm.zzbr;
import com.google.android.gms.internal.gtm.zzbv;

/* loaded from: classes3.dex */
public final class Aj8 extends zzbr implements InterfaceC11394cv8 {
    private final zzbv a;
    private final String b;
    private final Uri c;

    public Aj8(zzbv zzbvVar, String str) {
        super(zzbvVar);
        AbstractC3795Cj5.f(str);
        this.a = zzbvVar;
        this.b = str;
        this.c = a(str);
    }

    static Uri a(String str) {
        AbstractC3795Cj5.f(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    @Override // ir.nasim.InterfaceC11394cv8
    public final Uri c() {
        return this.c;
    }
}
