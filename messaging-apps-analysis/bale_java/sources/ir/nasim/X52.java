package ir.nasim;

import android.text.Editable;

/* loaded from: classes2.dex */
final class X52 extends Editable.Factory {
    private static final Object a = new Object();
    private static volatile Editable.Factory b;
    private static Class c;

    private X52() {
        try {
            c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, X52.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (b == null) {
            synchronized (a) {
                try {
                    if (b == null) {
                        b = new X52();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? C14674iI6.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
