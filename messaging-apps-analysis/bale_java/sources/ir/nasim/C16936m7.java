package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.util.HashMap;

/* renamed from: ir.nasim.m7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16936m7 {
    public static final C16936m7 a = new C16936m7();

    private C16936m7() {
    }

    public final void a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, Integer num) {
        AbstractC13042fc3.i(str, "headline");
        AbstractC13042fc3.i(str2, "id");
        AbstractC13042fc3.i(str3, "linkTitle");
        AbstractC13042fc3.i(str4, "serajEvent");
        AbstractC13042fc3.i(str5, "peerType");
        HashMap map = new HashMap();
        map.put("ad_item_uid", Integer.valueOf(AbstractC5969Lp4.f()));
        map.put("ad_item_id", str2);
        map.put("ad_item_provider", "bale");
        map.put("ad_item_state", ConstantDeviceInfo.APP_PLATFORM);
        map.put("ad_item_title", str);
        map.put("tag_1", Integer.valueOf(i));
        map.put("tag_2", Integer.valueOf(i2));
        map.put("action_type", Integer.valueOf(i3));
        map.put("link_title", str3);
        map.put("peer_type", str5);
        if (num != null) {
            map.put("peer_id", Integer.valueOf(num.intValue()));
        }
        C3343Am.i(str4, map);
    }
}
