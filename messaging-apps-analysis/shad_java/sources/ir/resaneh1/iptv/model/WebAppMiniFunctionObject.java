package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.MiniFunctionObject;

/* loaded from: classes3.dex */
public class WebAppMiniFunctionObject extends MiniFunctionObject {
    public String title;
    public String track_id;

    @Override // ir.aaap.messengercore.model.MiniFunctionObject
    public String getTitle() {
        return this.title + BuildConfig.FLAVOR;
    }
}
