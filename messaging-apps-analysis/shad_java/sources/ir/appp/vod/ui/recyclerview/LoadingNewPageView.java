package ir.appp.vod.ui.recyclerview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.DeviceUtils;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingNewPageView.kt */
/* loaded from: classes3.dex */
public final class LoadingNewPageView extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingNewPageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        initView();
    }

    private final void initView() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        CircularProgressIndicator circularProgressIndicator = new CircularProgressIndicator(getContext());
        circularProgressIndicator.setIndicatorColor(ContextCompat.getColor(circularProgressIndicator.getContext(), R.color.svc_indicator_selected));
        circularProgressIndicator.setIndeterminate(true);
        addView(circularProgressIndicator, LayoutHelper.createFrame(50, 50, 17, 8.0f, 8.0f, 8.0f, 8.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int iDpToPx = (int) deviceUtils.dpToPx(context, 100);
        int iResolveSize = FrameLayout.resolveSize(iDpToPx, i);
        int iResolveSize2 = FrameLayout.resolveSize(iDpToPx, i2);
        if (iResolveSize2 <= AndroidUtilities.getScreenHeight(getContext()) / 2) {
            iDpToPx = iResolveSize2;
        }
        setMeasuredDimension(iResolveSize, iDpToPx);
    }
}
