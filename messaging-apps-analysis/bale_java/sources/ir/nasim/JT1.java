package ir.nasim;

import android.content.Context;

/* loaded from: classes3.dex */
public class JT1 {
    private final float a;

    public JT1(float f) {
        this.a = f;
    }

    public static JT1 a(Context context) {
        return new JT1(context.getResources().getDisplayMetrics().density);
    }

    public int b(int i) {
        return (int) ((i * this.a) + 0.5f);
    }
}
