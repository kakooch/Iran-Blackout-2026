package ir.nasim;

import com.google.android.gms.common.Feature;

/* renamed from: ir.nasim.sh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20843sh8 {
    public static final Feature a;
    public static final Feature b;
    public static final Feature c;
    public static final Feature d;
    public static final Feature[] e;

    static {
        Feature feature = new Feature("sms_code_autofill", 2L);
        a = feature;
        Feature feature2 = new Feature("sms_code_browser", 2L);
        b = feature2;
        Feature feature3 = new Feature("sms_retrieve", 1L);
        c = feature3;
        Feature feature4 = new Feature("user_consent", 3L);
        d = feature4;
        e = new Feature[]{feature, feature2, feature3, feature4};
    }
}
