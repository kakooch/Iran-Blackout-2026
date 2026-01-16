package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class JJRankObject {

    /* renamed from: me, reason: collision with root package name */
    public boolean f2me = false;
    public String mobile;
    public String name;
    public int points;
    public int rank;

    public String getName() {
        if (this.f2me) {
            return "من";
        }
        String str = this.name;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            return this.name;
        }
        return this.mobile;
    }
}
