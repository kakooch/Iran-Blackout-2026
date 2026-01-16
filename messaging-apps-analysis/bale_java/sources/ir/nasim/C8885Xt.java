package ir.nasim;

import android.content.ContentResolver;
import android.provider.Settings;

/* renamed from: ir.nasim.Xt, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C8885Xt {
    public float a(ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
