package ir.nasim;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes5.dex */
public abstract class OI2 {
    public static com.bumptech.glide.b a(Context context) {
        return com.bumptech.glide.b.c(context);
    }

    public static VI2 b(Context context) {
        return (VI2) com.bumptech.glide.b.t(context);
    }

    public static VI2 c(View view) {
        return (VI2) com.bumptech.glide.b.u(view);
    }

    public static VI2 d(Fragment fragment) {
        return (VI2) com.bumptech.glide.b.v(fragment);
    }

    public static VI2 e(FragmentActivity fragmentActivity) {
        return (VI2) com.bumptech.glide.b.w(fragmentActivity);
    }
}
