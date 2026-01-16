package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import ir.nasim.AbstractC9903al0;
import ir.nasim.PW;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

/* loaded from: classes8.dex */
public class ApexHomeBadger implements PW {
    @Override // ir.nasim.PW
    public List a() {
        return Arrays.asList("com.anddoes.launcher");
    }

    @Override // ir.nasim.PW
    public void b(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i);
        intent.putExtra("class", componentName.getClassName());
        AbstractC9903al0.c(context, intent);
    }
}
