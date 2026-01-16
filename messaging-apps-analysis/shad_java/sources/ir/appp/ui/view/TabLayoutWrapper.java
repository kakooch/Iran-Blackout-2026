package ir.appp.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.tabs.TabLayout;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class TabLayoutWrapper extends TabLayout {
    public TabLayoutWrapper(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Whichever), attributeSet);
    }
}
