package com.facebook.stetho.inspector.elements.android;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
abstract class ViewHighlightOverlays {
    abstract void highlightView(View view, Rect rect, int i);

    abstract void removeHighlight(View view);

    ViewHighlightOverlays() {
    }

    static ViewHighlightOverlays newInstance() {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewHighlightOverlaysJellybeanMR2();
        }
        return new NoOpViewHighlightOverlays();
    }

    private static class NoOpViewHighlightOverlays extends ViewHighlightOverlays {
        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void highlightView(View view, Rect rect, int i) {
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void removeHighlight(View view) {
        }

        private NoOpViewHighlightOverlays() {
        }
    }

    private static class ViewHighlightOverlaysJellybeanMR2 extends ViewHighlightOverlays {
        private static final int MARGIN_OVERLAY_COLOR = -1426797922;
        private static final int PADDING_OVERLAY_COLOR = -1430332746;
        private final HighlightDrawable[] mHighlightDrawables;
        private final MainHighlightDrawable mMainHighlightDrawable;

        ViewHighlightOverlaysJellybeanMR2() {
            MainHighlightDrawable mainHighlightDrawable = new MainHighlightDrawable();
            this.mMainHighlightDrawable = mainHighlightDrawable;
            this.mHighlightDrawables = new HighlightDrawable[]{mainHighlightDrawable, new PaddingTopHighlightDrawable(), new PaddingBottomHighlightDrawable(), new PaddingRightHighlightDrawable(), new PaddingLeftHighlightDrawable(), new MarginTopHighlightDrawable(), new MarginBottomHighlightDrawable(), new MarginRightHighlightDrawable(), new MarginLeftHighlightDrawable()};
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void highlightView(View view, Rect rect, int i) {
            this.mMainHighlightDrawable.setColor(i);
            if (rect.isEmpty()) {
                this.mMainHighlightDrawable.setBounds(0, 0, view.getWidth(), view.getHeight());
            } else {
                this.mMainHighlightDrawable.setBounds(rect);
            }
            int length = this.mHighlightDrawables.length;
            for (int i2 = 0; i2 < length; i2++) {
                HighlightDrawable highlightDrawable = this.mHighlightDrawables[i2];
                highlightDrawable.highlightView(view);
                view.getOverlay().add(highlightDrawable);
            }
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void removeHighlight(View view) {
            for (HighlightDrawable highlightDrawable : this.mHighlightDrawables) {
                view.getOverlay().remove(highlightDrawable);
            }
        }

        static abstract class HighlightDrawable extends ColorDrawable {
            protected final Rect mMargins;
            protected final Rect mPaddings;

            HighlightDrawable(int i) {
                super(i);
                this.mMargins = new Rect();
                this.mPaddings = new Rect();
            }

            public HighlightDrawable() {
                this.mMargins = new Rect();
                this.mPaddings = new Rect();
            }

            void highlightView(View view) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    Rect rect = this.mMargins;
                    rect.left = marginLayoutParams.leftMargin;
                    rect.top = marginLayoutParams.topMargin;
                    rect.right = marginLayoutParams.rightMargin;
                    rect.bottom = marginLayoutParams.bottomMargin;
                } else {
                    Rect rect2 = this.mMargins;
                    rect2.left = 0;
                    rect2.top = 0;
                    rect2.right = 0;
                    rect2.bottom = 0;
                }
                this.mPaddings.left = view.getPaddingLeft();
                this.mPaddings.top = view.getPaddingTop();
                this.mPaddings.right = view.getPaddingRight();
                this.mPaddings.bottom = view.getPaddingBottom();
            }
        }

        static class MainHighlightDrawable extends HighlightDrawable {
            MainHighlightDrawable() {
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect clipBounds = canvas.getClipBounds();
                Rect rect = this.mMargins;
                clipBounds.inset(-(rect.right + rect.left), -(rect.top + rect.bottom));
                if (Build.VERSION.SDK_INT < 26) {
                    canvas.clipRect(clipBounds, Region.Op.REPLACE);
                } else {
                    canvas.clipOutRect(clipBounds);
                }
                super.draw(canvas);
            }
        }

        static class PaddingTopHighlightDrawable extends HighlightDrawable {
            PaddingTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                int i = this.mPaddings.left;
                int width = view.getWidth();
                Rect rect = this.mPaddings;
                setBounds(i, 0, width - rect.right, rect.top);
            }
        }

        static class PaddingBottomHighlightDrawable extends HighlightDrawable {
            PaddingBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(this.mPaddings.left, view.getHeight() - this.mPaddings.bottom, view.getWidth() - this.mPaddings.right, view.getHeight());
            }
        }

        static class PaddingRightHighlightDrawable extends HighlightDrawable {
            PaddingRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(view.getWidth() - this.mPaddings.right, 0, view.getWidth(), view.getHeight());
            }
        }

        static class PaddingLeftHighlightDrawable extends HighlightDrawable {
            PaddingLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, this.mPaddings.left, view.getHeight());
            }
        }

        static class MarginTopHighlightDrawable extends HighlightDrawable {
            MarginTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, view.getWidth(), this.mMargins.top);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                canvas.translate(0.0f, -this.mMargins.top);
                super.draw(canvas);
            }
        }

        static class MarginBottomHighlightDrawable extends HighlightDrawable {
            MarginBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, view.getHeight() - this.mMargins.bottom, view.getWidth(), view.getHeight());
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(0.0f, rect.bottom + rect.top);
                super.draw(canvas);
            }
        }

        static class MarginRightHighlightDrawable extends HighlightDrawable {
            MarginRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                int width = view.getWidth() - this.mMargins.right;
                int width2 = view.getWidth();
                int height = view.getHeight();
                Rect rect = this.mMargins;
                setBounds(width, 0, width2, height + rect.top + rect.bottom);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(rect.right, -(rect.top + rect.bottom));
                super.draw(canvas);
            }
        }

        static class MarginLeftHighlightDrawable extends HighlightDrawable {
            MarginLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                int i = this.mMargins.left;
                int height = view.getHeight();
                Rect rect = this.mMargins;
                setBounds(0, 0, i, height + rect.top + rect.bottom);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(-(rect.left + rect.right), 0.0f);
                super.draw(canvas);
            }
        }
    }
}
