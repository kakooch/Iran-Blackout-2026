package ir.nasim;

import android.content.Context;
import android.content.Intent;
import ir.nasim.features.profile.avatar.NewViewAvatarActivity;

/* loaded from: classes6.dex */
public final class XV7 {
    public static final XV7 a = new XV7();

    private XV7() {
    }

    public static final Intent a(int i, Context context) {
        AbstractC13042fc3.i(context, "context");
        Intent intentT3 = NewViewAvatarActivity.T3(i, context);
        AbstractC13042fc3.h(intentT3, "viewAvatar(...)");
        return intentT3;
    }

    public static final Intent b(int i, Context context, ZN2 zn2) {
        AbstractC13042fc3.i(context, "context");
        Intent intentU3 = NewViewAvatarActivity.U3(i, context, zn2);
        AbstractC13042fc3.h(intentU3, "viewGroupAvatar(...)");
        return intentU3;
    }
}
