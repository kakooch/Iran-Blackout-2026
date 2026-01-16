package ir.nasim;

import com.google.android.gms.common.Feature;

/* renamed from: ir.nasim.es8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12598es8 {
    public static final Feature a;
    public static final Feature b;
    public static final Feature c;
    public static final Feature d;
    public static final Feature e;
    public static final Feature f;
    public static final Feature g;
    public static final Feature h;
    public static final Feature i;
    public static final Feature j;
    public static final Feature k;
    public static final Feature[] l;

    static {
        Feature feature = new Feature("name_ulr_private", 1L);
        a = feature;
        Feature feature2 = new Feature("name_sleep_segment_request", 1L);
        b = feature2;
        Feature feature3 = new Feature("get_last_activity_feature_id", 1L);
        c = feature3;
        Feature feature4 = new Feature("support_context_feature_id", 1L);
        d = feature4;
        Feature feature5 = new Feature("get_current_location", 2L);
        e = feature5;
        Feature feature6 = new Feature("get_last_location_with_request", 1L);
        f = feature6;
        Feature feature7 = new Feature("set_mock_mode_with_callback", 1L);
        g = feature7;
        Feature feature8 = new Feature("set_mock_location_with_callback", 1L);
        h = feature8;
        Feature feature9 = new Feature("inject_location_with_callback", 1L);
        i = feature9;
        Feature feature10 = new Feature("location_updates_with_callback", 1L);
        j = feature10;
        Feature feature11 = new Feature("use_safe_parcelable_in_intents", 1L);
        k = feature11;
        l = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, feature11};
    }
}
