package ir.resaneh1.iptv.fragment.home.sectionInfo;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.UIView.CirclePagerIndicatorDecorationAdSection;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DummyIndicator.kt */
/* loaded from: classes3.dex */
public final class DummyIndicator extends View {
    private CirclePagerIndicatorDecorationAdSection indicator;
    private boolean isActive;
    private RecyclerView recyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DummyIndicator(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public final CirclePagerIndicatorDecorationAdSection getIndicator() {
        return this.indicator;
    }

    public final void setIndicator(CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection) {
        this.indicator = circlePagerIndicatorDecorationAdSection;
        if (circlePagerIndicatorDecorationAdSection == null) {
            return;
        }
        circlePagerIndicatorDecorationAdSection.setCallback(new IndicatorCallback() { // from class: ir.resaneh1.iptv.fragment.home.sectionInfo.DummyIndicator$indicator$1
            @Override // ir.resaneh1.iptv.fragment.home.sectionInfo.IndicatorCallback
            public void onDrawOver() {
                this.this$0.invalidate();
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int totalHeight;
        CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection;
        int totalWidth = 0;
        if (!this.isActive || (circlePagerIndicatorDecorationAdSection = this.indicator) == null || this.recyclerView == null) {
            totalHeight = 0;
        } else {
            Intrinsics.checkNotNull(circlePagerIndicatorDecorationAdSection);
            totalWidth = circlePagerIndicatorDecorationAdSection.getTotalWidth(this.recyclerView);
            CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection2 = this.indicator;
            Intrinsics.checkNotNull(circlePagerIndicatorDecorationAdSection2);
            totalHeight = circlePagerIndicatorDecorationAdSection2.getTotalHeight();
        }
        if (totalWidth > 0 && totalHeight > 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(totalWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(totalHeight, 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection = this.indicator;
        if (circlePagerIndicatorDecorationAdSection == null || this.recyclerView == null) {
            return;
        }
        Intrinsics.checkNotNull(circlePagerIndicatorDecorationAdSection);
        circlePagerIndicatorDecorationAdSection.drawOver(canvas, this.recyclerView, true);
    }
}
