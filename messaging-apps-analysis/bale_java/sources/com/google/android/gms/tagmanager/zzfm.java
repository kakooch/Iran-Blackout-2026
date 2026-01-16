package com.google.android.gms.tagmanager;

import java.util.Map;

/* loaded from: classes3.dex */
final class zzfm implements zzav {
    final /* synthetic */ TagManager zza;

    zzfm(TagManager tagManager) {
        this.zza = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.zzav
    public final void zza(Map<String, Object> map) {
        Object obj = map.get("event");
        if (obj != null) {
            TagManager.zzb(this.zza, obj.toString());
        }
    }
}
