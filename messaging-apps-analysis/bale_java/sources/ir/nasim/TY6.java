package ir.nasim;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: classes3.dex */
public class TY6 {
    private final Resources a;
    private final String b;

    public TY6(Context context) {
        AbstractC3795Cj5.j(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.b = resources.getResourcePackageName(AbstractC21840uD5.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.a.getIdentifier(str, "string", this.b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
