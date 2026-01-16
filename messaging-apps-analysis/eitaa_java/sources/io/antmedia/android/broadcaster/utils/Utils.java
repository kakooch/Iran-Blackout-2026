package io.antmedia.android.broadcaster.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class Utils {
    private static final String DOES_ENCODER_WORKS = Utils.class.getName() + ".DOES_ENCODER_WORKS";
    private static SharedPreferences sharedPreference = null;

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        if (sharedPreference == null) {
            sharedPreference = context.getSharedPreferences("applicationDetails", 0);
        }
        return sharedPreference;
    }

    public static int doesEncoderWorks(Context context) {
        return getDefaultSharedPreferences(context).getInt(DOES_ENCODER_WORKS, -1);
    }

    public static void setEncoderWorks(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(context).edit();
        editorEdit.putInt(DOES_ENCODER_WORKS, z ? 1 : 0);
        editorEdit.apply();
    }
}
