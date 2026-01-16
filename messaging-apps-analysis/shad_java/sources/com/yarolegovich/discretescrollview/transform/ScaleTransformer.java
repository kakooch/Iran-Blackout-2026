package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import com.yarolegovich.discretescrollview.transform.Pivot;

/* loaded from: classes3.dex */
public class ScaleTransformer implements DiscreteScrollItemTransformer {
    private Pivot pivotX = Pivot.X.CENTER.create();
    private Pivot pivotY = Pivot.Y.CENTER.create();
    private float minScale = 0.8f;
    private float maxMinDiff = 0.2f;

    @Override // com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer
    public void transformItem(View view, float f) {
        this.pivotX.setOn(view);
        this.pivotY.setOn(view);
        float fAbs = this.minScale + (this.maxMinDiff * (1.0f - Math.abs(f)));
        view.setScaleX(fAbs);
        view.setScaleY(fAbs);
    }

    public static class Builder {
        private ScaleTransformer transformer = new ScaleTransformer();
        private float maxScale = 1.0f;

        public Builder setMinScale(float f) {
            this.transformer.minScale = f;
            return this;
        }

        public ScaleTransformer build() {
            ScaleTransformer scaleTransformer = this.transformer;
            scaleTransformer.maxMinDiff = this.maxScale - scaleTransformer.minScale;
            return this.transformer;
        }
    }
}
