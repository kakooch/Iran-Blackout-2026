package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import ir.nasim.PW;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes8.dex */
public class NovaHomeBadger implements PW {
    @Override // ir.nasim.PW
    public List a() {
        return Arrays.asList("com.teslacoilsw.launcher");
    }

    @Override // ir.nasim.PW
    public void b(Context context, ComponentName componentName, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ParameterNames.TAG, componentName.getPackageName() + Separators.SLASH + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }
}
