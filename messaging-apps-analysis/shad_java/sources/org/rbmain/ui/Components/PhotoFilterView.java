package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.PhotoEditRadioCell;
import org.rbmain.ui.Cells.PhotoEditToolCell;
import org.rbmain.ui.Components.FilterShaders;
import org.rbmain.ui.Components.PhotoEditorSeekBar;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes5.dex */
public class PhotoFilterView extends FrameLayout implements FilterShaders.FilterShadersDelegate {
    private Bitmap bitmapToEdit;
    private float blurAngle;
    private PhotoFilterBlurControl blurControl;
    private float blurExcludeBlurSize;
    private Point blurExcludePoint;
    private float blurExcludeSize;
    private ImageView blurItem;
    private FrameLayout blurLayout;
    private TextView blurLinearButton;
    private TextView blurOffButton;
    private TextView blurRadialButton;
    private int blurType;
    private TextView cancelTextView;
    private int contrastTool;
    private float contrastValue;
    private ImageView curveItem;
    private FrameLayout curveLayout;
    private RadioButton[] curveRadioButton;
    private PhotoFilterCurvesControl curvesControl;
    private CurvesToolValue curvesToolValue;
    private TextView doneTextView;
    private FilterGLThread eglThread;
    private int enhanceTool;
    private float enhanceValue;
    private int exposureTool;
    private float exposureValue;
    private int fadeTool;
    private float fadeValue;
    private int grainTool;
    private float grainValue;
    private int highlightsTool;
    private float highlightsValue;
    private boolean inBubbleMode;
    private boolean isMirrored;
    private MediaController.SavedFilterState lastState;
    private int orientation;
    private boolean ownsTextureView;
    private PaintingOverlay paintingOverlay;
    private RecyclerListView recyclerListView;
    private int rowsCount;
    private int saturationTool;
    private float saturationValue;
    private int selectedTool;
    private int shadowsTool;
    private float shadowsValue;
    private int sharpenTool;
    private float sharpenValue;
    private boolean showOriginal;
    private int softenSkinTool;
    private float softenSkinValue;
    private TextureView textureView;
    private int tintHighlightsColor;
    private int tintHighlightsTool;
    private int tintShadowsColor;
    private int tintShadowsTool;
    private FrameLayout toolsView;
    private ImageView tuneItem;
    private int vignetteTool;
    private float vignetteValue;
    private int warmthTool;
    private float warmthValue;

    public static class CurvesValue {
        public float[] cachedDataPoints;
        public float blacksLevel = 0.0f;
        public float shadowsLevel = 25.0f;
        public float midtonesLevel = 50.0f;
        public float highlightsLevel = 75.0f;
        public float whitesLevel = 100.0f;

        public float[] getDataPoints() {
            if (this.cachedDataPoints == null) {
                interpolateCurve();
            }
            return this.cachedDataPoints;
        }

        public float[] interpolateCurve() {
            float f = this.blacksLevel;
            int i = 1;
            float f2 = 0.0f;
            float f3 = this.whitesLevel;
            float[] fArr = {-0.001f, f / 100.0f, 0.0f, f / 100.0f, 0.25f, this.shadowsLevel / 100.0f, 0.5f, this.midtonesLevel / 100.0f, 0.75f, this.highlightsLevel / 100.0f, 1.0f, f3 / 100.0f, 1.001f, f3 / 100.0f};
            ArrayList arrayList = new ArrayList(100);
            ArrayList arrayList2 = new ArrayList(100);
            arrayList2.add(Float.valueOf(fArr[0]));
            arrayList2.add(Float.valueOf(fArr[1]));
            int i2 = 1;
            while (i2 < 5) {
                int i3 = (i2 - 1) * 2;
                float f4 = fArr[i3];
                float f5 = fArr[i3 + i];
                int i4 = i2 * 2;
                float f6 = fArr[i4];
                float f7 = fArr[i4 + 1];
                int i5 = i2 + 1;
                int i6 = i5 * 2;
                float f8 = fArr[i6];
                float f9 = fArr[i6 + 1];
                int i7 = (i2 + 2) * 2;
                float f10 = fArr[i7];
                float f11 = fArr[i7 + i];
                int i8 = 1;
                while (i8 < 100) {
                    float f12 = i8 * 0.01f;
                    float f13 = f12 * f12;
                    float f14 = f13 * f12;
                    float f15 = ((f6 * 2.0f) + ((f8 - f4) * f12) + (((((f4 * 2.0f) - (f6 * 5.0f)) + (f8 * 4.0f)) - f10) * f13) + (((((f6 * 3.0f) - f4) - (f8 * 3.0f)) + f10) * f14)) * 0.5f;
                    float fMax = Math.max(f2, Math.min(1.0f, ((f7 * 2.0f) + ((f9 - f5) * f12) + (((((2.0f * f5) - (5.0f * f7)) + (4.0f * f9)) - f11) * f13) + (((((f7 * 3.0f) - f5) - (3.0f * f9)) + f11) * f14)) * 0.5f));
                    if (f15 > f4) {
                        arrayList2.add(Float.valueOf(f15));
                        arrayList2.add(Float.valueOf(fMax));
                    }
                    if ((i8 - 1) % 2 == 0) {
                        arrayList.add(Float.valueOf(fMax));
                    }
                    i8++;
                    f2 = 0.0f;
                }
                arrayList2.add(Float.valueOf(f8));
                arrayList2.add(Float.valueOf(f9));
                i2 = i5;
                i = 1;
                f2 = 0.0f;
            }
            arrayList2.add(Float.valueOf(fArr[12]));
            arrayList2.add(Float.valueOf(fArr[13]));
            this.cachedDataPoints = new float[arrayList.size()];
            int i9 = 0;
            while (true) {
                float[] fArr2 = this.cachedDataPoints;
                if (i9 >= fArr2.length) {
                    break;
                }
                fArr2[i9] = ((Float) arrayList.get(i9)).floatValue();
                i9++;
            }
            int size = arrayList2.size();
            float[] fArr3 = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                fArr3[i10] = ((Float) arrayList2.get(i10)).floatValue();
            }
            return fArr3;
        }

        public boolean isDefault() {
            return ((double) Math.abs(this.blacksLevel - 0.0f)) < 1.0E-5d && ((double) Math.abs(this.shadowsLevel - 25.0f)) < 1.0E-5d && ((double) Math.abs(this.midtonesLevel - 50.0f)) < 1.0E-5d && ((double) Math.abs(this.highlightsLevel - 75.0f)) < 1.0E-5d && ((double) Math.abs(this.whitesLevel - 100.0f)) < 1.0E-5d;
        }
    }

    public static class CurvesToolValue {
        public int activeType;
        public ByteBuffer curveBuffer;
        public CurvesValue luminanceCurve = new CurvesValue();
        public CurvesValue redCurve = new CurvesValue();
        public CurvesValue greenCurve = new CurvesValue();
        public CurvesValue blueCurve = new CurvesValue();

        public CurvesToolValue() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(MediaController.MAX_WIDTH_HEIGHT_SIZE);
            this.curveBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }

        public void fillBuffer() {
            this.curveBuffer.position(0);
            float[] dataPoints = this.luminanceCurve.getDataPoints();
            float[] dataPoints2 = this.redCurve.getDataPoints();
            float[] dataPoints3 = this.greenCurve.getDataPoints();
            float[] dataPoints4 = this.blueCurve.getDataPoints();
            for (int i = 0; i < 200; i++) {
                this.curveBuffer.put((byte) (dataPoints2[i] * 255.0f));
                this.curveBuffer.put((byte) (dataPoints3[i] * 255.0f));
                this.curveBuffer.put((byte) (dataPoints4[i] * 255.0f));
                this.curveBuffer.put((byte) (dataPoints[i] * 255.0f));
            }
            this.curveBuffer.position(0);
        }

        public boolean shouldBeSkipped() {
            return this.luminanceCurve.isDefault() && this.redCurve.isDefault() && this.greenCurve.isDefault() && this.blueCurve.isDefault();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x04d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PhotoFilterView(android.content.Context r24, org.rbmain.ui.Components.VideoEditTextureView r25, android.graphics.Bitmap r26, int r27, org.rbmain.messenger.MediaController.SavedFilterState r28, org.rbmain.ui.Components.PaintingOverlay r29, int r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 1591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.PhotoFilterView.<init>(android.content.Context, org.rbmain.ui.Components.VideoEditTextureView, android.graphics.Bitmap, int, org.rbmain.messenger.MediaController$SavedFilterState, org.rbmain.ui.Components.PaintingOverlay, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(FilterGLThread filterGLThread) {
        this.eglThread = filterGLThread;
        filterGLThread.setFilterGLThreadDelegate(this);
    }

    /* renamed from: org.rbmain.ui.Components.PhotoFilterView$1, reason: invalid class name */
    class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (PhotoFilterView.this.eglThread != null || surfaceTexture == null) {
                return;
            }
            PhotoFilterView.this.eglThread = new FilterGLThread(surfaceTexture, PhotoFilterView.this.bitmapToEdit, PhotoFilterView.this.orientation, PhotoFilterView.this.isMirrored);
            PhotoFilterView.this.eglThread.setFilterGLThreadDelegate(PhotoFilterView.this);
            PhotoFilterView.this.eglThread.setSurfaceTextureSize(i, i2);
            PhotoFilterView.this.eglThread.requestRender(true, true, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (PhotoFilterView.this.eglThread != null) {
                PhotoFilterView.this.eglThread.setSurfaceTextureSize(i, i2);
                PhotoFilterView.this.eglThread.requestRender(false, true, false);
                PhotoFilterView.this.eglThread.postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.PhotoFilterView$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onSurfaceTextureSizeChanged$0();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$0() {
            if (PhotoFilterView.this.eglThread != null) {
                PhotoFilterView.this.eglThread.requestRender(false, true, false);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (PhotoFilterView.this.eglThread == null) {
                return true;
            }
            PhotoFilterView.this.eglThread.shutdown();
            PhotoFilterView.this.eglThread = null;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Point point, float f, float f2, float f3) {
        this.blurExcludeSize = f2;
        this.blurExcludePoint = point;
        this.blurExcludeBlurSize = f;
        this.blurAngle = f3;
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        this.selectedTool = 0;
        this.tuneItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        this.blurItem.setColorFilter((ColorFilter) null);
        this.curveItem.setColorFilter((ColorFilter) null);
        switchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) {
        this.selectedTool = 1;
        this.tuneItem.setColorFilter((ColorFilter) null);
        this.blurItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        this.curveItem.setColorFilter((ColorFilter) null);
        switchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(View view) {
        this.selectedTool = 2;
        this.tuneItem.setColorFilter((ColorFilter) null);
        this.blurItem.setColorFilter((ColorFilter) null);
        this.curveItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        switchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.curvesToolValue.activeType = iIntValue;
        int i = 0;
        while (i < 4) {
            this.curveRadioButton[i].setChecked(i == iIntValue, true);
            i++;
        }
        this.curvesControl.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(View view) {
        this.blurType = 0;
        updateSelectedBlurType();
        this.blurControl.setVisibility(4);
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8(View view) {
        this.blurType = 1;
        updateSelectedBlurType();
        this.blurControl.setVisibility(0);
        this.blurControl.setType(1);
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(View view) {
        this.blurType = 2;
        updateSelectedBlurType();
        this.blurControl.setVisibility(0);
        this.blurControl.setType(0);
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false);
        }
    }

    public void updateColors() {
        TextView textView = this.doneTextView;
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_dialogFloatingButton));
        }
        ImageView imageView = this.tuneItem;
        if (imageView != null && imageView.getColorFilter() != null) {
            this.tuneItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView2 = this.blurItem;
        if (imageView2 != null && imageView2.getColorFilter() != null) {
            this.blurItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView3 = this.curveItem;
        if (imageView3 != null && imageView3.getColorFilter() != null) {
            this.curveItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        }
        updateSelectedBlurType();
    }

    private void updateSelectedBlurType() {
        int i = this.blurType;
        if (i == 0) {
            Drawable drawableMutate = this.blurOffButton.getContext().getResources().getDrawable(R.drawable.blur_off).mutate();
            int i2 = Theme.key_dialogFloatingButton;
            drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            this.blurOffButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate, (Drawable) null, (Drawable) null);
            this.blurOffButton.setTextColor(Theme.getColor(i2));
            this.blurRadialButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.blur_radial, 0, 0);
            this.blurRadialButton.setTextColor(-1);
            this.blurLinearButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.blur_linear, 0, 0);
            this.blurLinearButton.setTextColor(-1);
            return;
        }
        if (i == 1) {
            this.blurOffButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.blur_off, 0, 0);
            this.blurOffButton.setTextColor(-1);
            Drawable drawableMutate2 = this.blurOffButton.getContext().getResources().getDrawable(R.drawable.blur_radial).mutate();
            int i3 = Theme.key_dialogFloatingButton;
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.MULTIPLY));
            this.blurRadialButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate2, (Drawable) null, (Drawable) null);
            this.blurRadialButton.setTextColor(Theme.getColor(i3));
            this.blurLinearButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.blur_linear, 0, 0);
            this.blurLinearButton.setTextColor(-1);
            return;
        }
        if (i == 2) {
            this.blurOffButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.blur_off, 0, 0);
            this.blurOffButton.setTextColor(-1);
            this.blurRadialButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.blur_radial, 0, 0);
            this.blurRadialButton.setTextColor(-1);
            Drawable drawableMutate3 = this.blurOffButton.getContext().getResources().getDrawable(R.drawable.blur_linear).mutate();
            int i4 = Theme.key_dialogFloatingButton;
            drawableMutate3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i4), PorterDuff.Mode.MULTIPLY));
            this.blurLinearButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate3, (Drawable) null, (Drawable) null);
            this.blurLinearButton.setTextColor(Theme.getColor(i4));
        }
    }

    public MediaController.SavedFilterState getSavedFilterState() {
        MediaController.SavedFilterState savedFilterState = new MediaController.SavedFilterState();
        savedFilterState.enhanceValue = this.enhanceValue;
        savedFilterState.exposureValue = this.exposureValue;
        savedFilterState.contrastValue = this.contrastValue;
        savedFilterState.warmthValue = this.warmthValue;
        savedFilterState.saturationValue = this.saturationValue;
        savedFilterState.fadeValue = this.fadeValue;
        savedFilterState.softenSkinValue = this.softenSkinValue;
        savedFilterState.tintShadowsColor = this.tintShadowsColor;
        savedFilterState.tintHighlightsColor = this.tintHighlightsColor;
        savedFilterState.highlightsValue = this.highlightsValue;
        savedFilterState.shadowsValue = this.shadowsValue;
        savedFilterState.vignetteValue = this.vignetteValue;
        savedFilterState.grainValue = this.grainValue;
        savedFilterState.blurType = this.blurType;
        savedFilterState.sharpenValue = this.sharpenValue;
        savedFilterState.curvesToolValue = this.curvesToolValue;
        savedFilterState.blurExcludeSize = this.blurExcludeSize;
        savedFilterState.blurExcludePoint = this.blurExcludePoint;
        savedFilterState.blurExcludeBlurSize = this.blurExcludeBlurSize;
        savedFilterState.blurAngle = this.blurAngle;
        this.lastState = savedFilterState;
        return savedFilterState;
    }

    public boolean hasChanges() {
        MediaController.SavedFilterState savedFilterState = this.lastState;
        return savedFilterState != null ? (this.enhanceValue == savedFilterState.enhanceValue && this.contrastValue == savedFilterState.contrastValue && this.highlightsValue == savedFilterState.highlightsValue && this.exposureValue == savedFilterState.exposureValue && this.warmthValue == savedFilterState.warmthValue && this.saturationValue == savedFilterState.saturationValue && this.vignetteValue == savedFilterState.vignetteValue && this.shadowsValue == savedFilterState.shadowsValue && this.grainValue == savedFilterState.grainValue && this.sharpenValue == savedFilterState.sharpenValue && this.fadeValue == savedFilterState.fadeValue && this.softenSkinValue == savedFilterState.softenSkinValue && this.tintHighlightsColor == savedFilterState.tintHighlightsColor && this.tintShadowsColor == savedFilterState.tintShadowsColor && this.curvesToolValue.shouldBeSkipped()) ? false : true : (this.enhanceValue == 0.0f && this.contrastValue == 0.0f && this.highlightsValue == 0.0f && this.exposureValue == 0.0f && this.warmthValue == 0.0f && this.saturationValue == 0.0f && this.vignetteValue == 0.0f && this.shadowsValue == 0.0f && this.grainValue == 0.0f && this.sharpenValue == 0.0f && this.fadeValue == 0.0f && this.softenSkinValue == 0.0f && this.tintHighlightsColor == 0 && this.tintShadowsColor == 0 && this.curvesToolValue.shouldBeSkipped()) ? false : true;
    }

    public void onTouch(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            TextureView textureView = this.textureView;
            if (textureView instanceof VideoEditTextureView) {
                if (((VideoEditTextureView) textureView).containsPoint(motionEvent.getX(), motionEvent.getY())) {
                    setShowOriginal(true);
                    return;
                }
                return;
            } else {
                if (motionEvent.getX() < this.textureView.getX() || motionEvent.getY() < this.textureView.getY() || motionEvent.getX() > this.textureView.getX() + this.textureView.getWidth() || motionEvent.getY() > this.textureView.getY() + this.textureView.getHeight()) {
                    return;
                }
                setShowOriginal(true);
                return;
            }
        }
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6) {
            setShowOriginal(false);
        }
    }

    private void setShowOriginal(boolean z) {
        if (this.showOriginal == z) {
            return;
        }
        this.showOriginal = z;
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            filterGLThread.requestRender(false);
        }
    }

    public void switchMode() {
        int i = this.selectedTool;
        if (i == 0) {
            this.blurControl.setVisibility(4);
            this.blurLayout.setVisibility(4);
            this.curveLayout.setVisibility(4);
            this.curvesControl.setVisibility(4);
            this.recyclerListView.setVisibility(0);
            return;
        }
        if (i == 1) {
            this.recyclerListView.setVisibility(4);
            this.curveLayout.setVisibility(4);
            this.curvesControl.setVisibility(4);
            this.blurLayout.setVisibility(0);
            if (this.blurType != 0) {
                this.blurControl.setVisibility(0);
            }
            updateSelectedBlurType();
            return;
        }
        if (i == 2) {
            this.recyclerListView.setVisibility(4);
            this.blurLayout.setVisibility(4);
            this.blurControl.setVisibility(4);
            this.curveLayout.setVisibility(0);
            this.curvesControl.setVisibility(0);
            this.curvesToolValue.activeType = 0;
            int i2 = 0;
            while (i2 < 4) {
                this.curveRadioButton[i2].setChecked(i2 == 0, false);
                i2++;
            }
        }
    }

    public void shutdown() {
        if (this.ownsTextureView) {
            FilterGLThread filterGLThread = this.eglThread;
            if (filterGLThread != null) {
                filterGLThread.shutdown();
                this.eglThread = null;
            }
            this.textureView.setVisibility(8);
            return;
        }
        TextureView textureView = this.textureView;
        if (textureView instanceof VideoEditTextureView) {
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            MediaController.SavedFilterState savedFilterState = this.lastState;
            if (savedFilterState == null) {
                videoEditTextureView.setDelegate(null);
            } else {
                this.eglThread.setFilterGLThreadDelegate(FilterShaders.getFilterShadersDelegate(savedFilterState));
            }
        }
    }

    public void init() {
        if (this.ownsTextureView) {
            this.textureView.setVisibility(0);
        }
    }

    public Bitmap getBitmap() {
        FilterGLThread filterGLThread = this.eglThread;
        if (filterGLThread != null) {
            return filterGLThread.getTexture();
        }
        return null;
    }

    private void fixLayout(int i, int i2) {
        float width;
        int height;
        float fCeil;
        float fCeil2;
        int iDp = i - AndroidUtilities.dp(28.0f);
        int iDp2 = AndroidUtilities.dp(214.0f);
        int i3 = Build.VERSION.SDK_INT;
        int i4 = i2 - (iDp2 + ((i3 < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight));
        Bitmap bitmap = this.bitmapToEdit;
        if (bitmap != null) {
            int i5 = this.orientation;
            if (i5 % 360 == 90 || i5 % 360 == 270) {
                width = bitmap.getHeight();
                height = this.bitmapToEdit.getWidth();
            } else {
                width = bitmap.getWidth();
                height = this.bitmapToEdit.getHeight();
            }
        } else {
            width = this.textureView.getWidth();
            height = this.textureView.getHeight();
        }
        float f = iDp;
        float f2 = i4;
        if (f / width > f2 / height) {
            fCeil2 = (int) Math.ceil(width * r9);
            fCeil = f2;
        } else {
            fCeil = (int) Math.ceil(r5 * r7);
            fCeil2 = f;
        }
        int iCeil = (int) Math.ceil(((f - fCeil2) / 2.0f) + AndroidUtilities.dp(14.0f));
        int iCeil2 = (int) Math.ceil(((f2 - fCeil) / 2.0f) + AndroidUtilities.dp(14.0f) + ((i3 < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight));
        int i6 = (int) fCeil2;
        int i7 = (int) fCeil;
        if (this.ownsTextureView) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textureView.getLayoutParams();
            layoutParams.leftMargin = iCeil;
            layoutParams.topMargin = iCeil2;
            layoutParams.width = i6;
            layoutParams.height = i7;
        }
        float f3 = i6;
        float f4 = i7;
        this.curvesControl.setActualArea(iCeil, iCeil2 - ((i3 < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight), f3, f4);
        this.blurControl.setActualAreaSize(f3, f4);
        ((FrameLayout.LayoutParams) this.blurControl.getLayoutParams()).height = AndroidUtilities.dp(38.0f) + i4;
        ((FrameLayout.LayoutParams) this.curvesControl.getLayoutParams()).height = i4 + AndroidUtilities.dp(28.0f);
        if (AndroidUtilities.isTablet()) {
            int iDp3 = AndroidUtilities.dp(86.0f) * 10;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.recyclerListView.getLayoutParams();
            if (iDp3 < iDp) {
                layoutParams2.width = iDp3;
                layoutParams2.leftMargin = (iDp - iDp3) / 2;
            } else {
                layoutParams2.width = -1;
                layoutParams2.leftMargin = 0;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.paintingOverlay != null && view == this.textureView) {
            canvas.save();
            canvas.translate(this.textureView.getLeft(), this.textureView.getTop());
            float measuredWidth = this.textureView.getMeasuredWidth() / this.paintingOverlay.getMeasuredWidth();
            canvas.scale(measuredWidth, measuredWidth);
            this.paintingOverlay.draw(canvas);
            canvas.restore();
        }
        return zDrawChild;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        fixLayout(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getShadowsValue() {
        return ((this.shadowsValue * 0.55f) + 100.0f) / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getHighlightsValue() {
        return ((this.highlightsValue * 0.75f) + 100.0f) / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getEnhanceValue() {
        return this.enhanceValue / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getExposureValue() {
        return this.exposureValue / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getContrastValue() {
        return ((this.contrastValue / 100.0f) * 0.3f) + 1.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getWarmthValue() {
        return this.warmthValue / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getVignetteValue() {
        return this.vignetteValue / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getSharpenValue() {
        return ((this.sharpenValue / 100.0f) * 0.6f) + 0.11f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getGrainValue() {
        return (this.grainValue / 100.0f) * 0.04f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getFadeValue() {
        return this.fadeValue / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getSoftenSkinValue() {
        return this.softenSkinValue / 100.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getTintHighlightsIntensityValue() {
        return this.tintHighlightsColor == 0 ? 0.0f : 0.5f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getTintShadowsIntensityValue() {
        return this.tintShadowsColor == 0 ? 0.0f : 0.5f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getSaturationValue() {
        float f = this.saturationValue / 100.0f;
        if (f > 0.0f) {
            f *= 1.05f;
        }
        return f + 1.0f;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public int getTintHighlightsColor() {
        return this.tintHighlightsColor;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public int getTintShadowsColor() {
        return this.tintShadowsColor;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public int getBlurType() {
        return this.blurType;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getBlurExcludeSize() {
        return this.blurExcludeSize;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getBlurExcludeBlurSize() {
        return this.blurExcludeBlurSize;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public float getBlurAngle() {
        return this.blurAngle;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public Point getBlurExcludePoint() {
        return this.blurExcludePoint;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public boolean shouldShowOriginal() {
        return this.showOriginal;
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public boolean shouldDrawCurvesPass() {
        return !this.curvesToolValue.shouldBeSkipped();
    }

    @Override // org.rbmain.ui.Components.FilterShaders.FilterShadersDelegate
    public ByteBuffer fillAndGetCurveBuffer() {
        this.curvesToolValue.fillBuffer();
        return this.curvesToolValue.curveBuffer;
    }

    public FrameLayout getToolsView() {
        return this.toolsView;
    }

    public View getCurveControl() {
        return this.curvesControl;
    }

    public View getBlurControl() {
        return this.blurControl;
    }

    public TextView getDoneTextView() {
        return this.doneTextView;
    }

    public TextView getCancelTextView() {
        return this.cancelTextView;
    }

    public class ToolsAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public ToolsAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PhotoFilterView.this.rowsCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            PhotoEditRadioCell photoEditRadioCell;
            if (i == 0) {
                PhotoEditToolCell photoEditToolCell = new PhotoEditToolCell(this.mContext);
                photoEditToolCell.setSeekBarDelegate(new PhotoEditorSeekBar.PhotoEditorSeekBarDelegate() { // from class: org.rbmain.ui.Components.PhotoFilterView$ToolsAdapter$$ExternalSyntheticLambda1
                    @Override // org.rbmain.ui.Components.PhotoEditorSeekBar.PhotoEditorSeekBarDelegate
                    public final void onProgressChanged(int i2, int i3) {
                        this.f$0.lambda$onCreateViewHolder$0(i2, i3);
                    }
                });
                photoEditRadioCell = photoEditToolCell;
            } else {
                PhotoEditRadioCell photoEditRadioCell2 = new PhotoEditRadioCell(this.mContext);
                photoEditRadioCell2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.PhotoFilterView$ToolsAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$1(view);
                    }
                });
                photoEditRadioCell = photoEditRadioCell2;
            }
            return new RecyclerListView.Holder(photoEditRadioCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(int i, int i2) {
            if (i == PhotoFilterView.this.enhanceTool) {
                PhotoFilterView.this.enhanceValue = i2;
            } else if (i == PhotoFilterView.this.highlightsTool) {
                PhotoFilterView.this.highlightsValue = i2;
            } else if (i == PhotoFilterView.this.contrastTool) {
                PhotoFilterView.this.contrastValue = i2;
            } else if (i == PhotoFilterView.this.exposureTool) {
                PhotoFilterView.this.exposureValue = i2;
            } else if (i == PhotoFilterView.this.warmthTool) {
                PhotoFilterView.this.warmthValue = i2;
            } else if (i == PhotoFilterView.this.saturationTool) {
                PhotoFilterView.this.saturationValue = i2;
            } else if (i == PhotoFilterView.this.vignetteTool) {
                PhotoFilterView.this.vignetteValue = i2;
            } else if (i == PhotoFilterView.this.shadowsTool) {
                PhotoFilterView.this.shadowsValue = i2;
            } else if (i == PhotoFilterView.this.grainTool) {
                PhotoFilterView.this.grainValue = i2;
            } else if (i == PhotoFilterView.this.sharpenTool) {
                PhotoFilterView.this.sharpenValue = i2;
            } else if (i == PhotoFilterView.this.fadeTool) {
                PhotoFilterView.this.fadeValue = i2;
            } else if (i == PhotoFilterView.this.softenSkinTool) {
                PhotoFilterView.this.softenSkinValue = i2;
            }
            if (PhotoFilterView.this.eglThread != null) {
                PhotoFilterView.this.eglThread.requestRender(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
            PhotoEditRadioCell photoEditRadioCell = (PhotoEditRadioCell) view;
            if (((Integer) photoEditRadioCell.getTag()).intValue() == PhotoFilterView.this.tintShadowsTool) {
                PhotoFilterView.this.tintShadowsColor = photoEditRadioCell.getCurrentColor();
            } else {
                PhotoFilterView.this.tintHighlightsColor = photoEditRadioCell.getCurrentColor();
            }
            if (PhotoFilterView.this.eglThread != null) {
                PhotoFilterView.this.eglThread.requestRender(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                PhotoEditRadioCell photoEditRadioCell = (PhotoEditRadioCell) viewHolder.itemView;
                photoEditRadioCell.setTag(Integer.valueOf(i));
                if (i == PhotoFilterView.this.tintShadowsTool) {
                    photoEditRadioCell.setIconAndTextAndValue(LocaleController.getString("TintShadows", R.string.TintShadows), 0, PhotoFilterView.this.tintShadowsColor);
                    return;
                } else {
                    if (i == PhotoFilterView.this.tintHighlightsTool) {
                        photoEditRadioCell.setIconAndTextAndValue(LocaleController.getString("TintHighlights", R.string.TintHighlights), 0, PhotoFilterView.this.tintHighlightsColor);
                        return;
                    }
                    return;
                }
            }
            PhotoEditToolCell photoEditToolCell = (PhotoEditToolCell) viewHolder.itemView;
            photoEditToolCell.setTag(Integer.valueOf(i));
            if (i == PhotoFilterView.this.enhanceTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Enhance", R.string.Enhance), PhotoFilterView.this.enhanceValue, 0, 100);
                return;
            }
            if (i == PhotoFilterView.this.highlightsTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Highlights", R.string.Highlights), PhotoFilterView.this.highlightsValue, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.contrastTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Contrast", R.string.Contrast), PhotoFilterView.this.contrastValue, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.exposureTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Exposure", R.string.Exposure), PhotoFilterView.this.exposureValue, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.warmthTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Warmth", R.string.Warmth), PhotoFilterView.this.warmthValue, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.saturationTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Saturation", R.string.Saturation), PhotoFilterView.this.saturationValue, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.vignetteTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Vignette", R.string.Vignette), PhotoFilterView.this.vignetteValue, 0, 100);
                return;
            }
            if (i == PhotoFilterView.this.shadowsTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Shadows", R.string.Shadows), PhotoFilterView.this.shadowsValue, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.grainTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Grain", R.string.Grain), PhotoFilterView.this.grainValue, 0, 100);
                return;
            }
            if (i == PhotoFilterView.this.sharpenTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Sharpen", R.string.Sharpen), PhotoFilterView.this.sharpenValue, 0, 100);
            } else if (i == PhotoFilterView.this.fadeTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("Fade", R.string.Fade), PhotoFilterView.this.fadeValue, 0, 100);
            } else if (i == PhotoFilterView.this.softenSkinTool) {
                photoEditToolCell.setIconAndTextAndValue(LocaleController.getString("SoftenSkin", R.string.SoftenSkin), PhotoFilterView.this.softenSkinValue, 0, 100);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (i == PhotoFilterView.this.tintShadowsTool || i == PhotoFilterView.this.tintHighlightsTool) ? 1 : 0;
        }
    }
}
