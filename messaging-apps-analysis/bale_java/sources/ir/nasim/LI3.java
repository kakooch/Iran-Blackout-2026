package ir.nasim;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes3.dex */
public class LI3 {
    private final String a;
    private final String b;
    private final AJ2 c;
    private final int d;

    public LI3(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.b = string;
        this.a = str;
        this.c = new AJ2(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.a, i)) {
            i++;
        }
        this.d = i;
    }

    public void a(String str, Object... objArr) {
        if (d(3)) {
            Log.d(this.a, c(str, objArr));
        }
    }

    public void b(String str, Object... objArr) {
        Log.e(this.a, c(str, objArr));
    }

    protected String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }

    public boolean d(int i) {
        return this.d <= i;
    }
}
