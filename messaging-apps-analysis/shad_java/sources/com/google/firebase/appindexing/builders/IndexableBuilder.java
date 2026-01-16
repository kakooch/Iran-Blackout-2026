package com.google.firebase.appindexing.builders;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zzw;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public class IndexableBuilder<T extends IndexableBuilder<?>> {
    public static void zza(@RecentlyNonNull Bundle bundle, @RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(strArr);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (strArr2.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < Math.min(strArr2.length, 100); i2++) {
                strArr2[i] = strArr2[i2];
                if (strArr2[i2] == null) {
                    StringBuilder sb = new StringBuilder(59);
                    sb.append("String at ");
                    sb.append(i2);
                    sb.append(" is null and is ignored by put method.");
                    zzw.zza(sb.toString());
                } else {
                    int i3 = 20000;
                    if (strArr2[i].length() > 20000) {
                        StringBuilder sb2 = new StringBuilder(53);
                        sb2.append("String at ");
                        sb2.append(i2);
                        sb2.append(" is too long, truncating string.");
                        zzw.zza(sb2.toString());
                        String strSubstring = strArr2[i];
                        if (strSubstring.length() > 20000) {
                            if (Character.isHighSurrogate(strSubstring.charAt(19999)) && Character.isLowSurrogate(strSubstring.charAt(20000))) {
                                i3 = 19999;
                            }
                            strSubstring = strSubstring.substring(0, i3);
                        }
                        strArr2[i] = strSubstring;
                    }
                    i++;
                }
            }
            if (i > 0) {
                bundle.putStringArray(str, (String[]) zza((String[]) Arrays.copyOfRange(strArr2, 0, i)));
                return;
            }
            return;
        }
        zzw.zza("String array is empty and is ignored by put method.");
    }

    private static <S> S[] zza(S[] sArr) {
        if (sArr.length < 100) {
            return sArr;
        }
        zzw.zza("Input Array of elements is too big, cutting off.");
        return (S[]) Arrays.copyOf(sArr, 100);
    }
}
