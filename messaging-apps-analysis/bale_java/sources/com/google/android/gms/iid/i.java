package com.google.android.gms.iid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import ir.nasim.AbstractC4043Dl1;
import java.io.File;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
final class i {
    i() {
    }

    static void a(Context context, String str) {
        File fileD = d(context, str);
        if (fileD.exists()) {
            fileD.delete();
        }
    }

    static void b(Context context) {
        for (File file : c(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static File c(Context context) {
        File fileJ = AbstractC4043Dl1.j(context);
        if (fileJ != null && fileJ.isDirectory()) {
            return fileJ;
        }
        Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File d(Context context, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = "com.google.InstanceId.properties";
        } else {
            try {
                String strEncodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(strEncodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(strEncodeToString);
                sb.append(".properties");
                string = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(c(context), string);
    }
}
