package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SSHPhotoCropView extends FrameLayout {
    private OnActionClickedListener actionClickedListener;
    private RectF animationEndValues;
    private RectF animationStartValues;
    private float bitmapGlobalScale;
    private int bitmapHeight;
    private int bitmapWidth;
    private SSHCropView cropView;
    private SSHPhotoCropViewDelegate delegate;
    private float rectSizeX;
    private float rectSizeY;
    private float rectX;
    private float rectY;
    private boolean showOnSetBitmap;
    private SSHCropRotationWheel wheelView;

    public interface OnActionClickedListener {
        void onCancelClicked();

        void onDoneClicked();
    }

    public interface SSHPhotoCropViewDelegate {
        Bitmap getBitmap();

        void onChange(boolean z);
    }

    public SSHPhotoCropView(Context context) {
        super(context);
        this.rectSizeX = 600.0f;
        this.rectSizeY = 600.0f;
        this.bitmapWidth = 1;
        this.bitmapHeight = 1;
        this.rectX = -1.0f;
        this.rectY = -1.0f;
        this.bitmapGlobalScale = 1.0f;
    }

    public void setBitmap(Bitmap bitmap, SSHCropView.SSHCropState sSHCropState, boolean z) {
        this.rectSizeX = 600.0f;
        this.rectSizeY = 600.0f;
        this.bitmapWidth = 1;
        this.bitmapHeight = 1;
        this.rectX = -1.0f;
        this.rectY = -1.0f;
        requestLayout();
        if (this.cropView == null) {
            SSHCropView sSHCropView = new SSHCropView(getContext());
            this.cropView = sSHCropView;
            sSHCropView.setListener(new SSHCropView.CropViewListener() { // from class: ir.appp.rghapp.components.SSHPhotoCropView.1
                @Override // ir.appp.rghapp.components.sshCrop.SSHCropView.CropViewListener
                public void onAspectLock(boolean z2) {
                }

                @Override // ir.appp.rghapp.components.sshCrop.SSHCropView.CropViewListener
                public void onChange(boolean z2) {
                    if (SSHPhotoCropView.this.delegate != null) {
                        SSHPhotoCropView.this.delegate.onChange(z2);
                    }
                }
            });
            this.cropView.setBottomPadding(AndroidUtilities.dp(64.0f));
            addView(this.cropView);
            SSHCropRotationWheel sSHCropRotationWheel = new SSHCropRotationWheel(getContext());
            this.wheelView = sSHCropRotationWheel;
            int i = Theme.key_windowBackgroundWhite;
            sSHCropRotationWheel.setBackgroundColor(Theme.getColor(i));
            this.wheelView.setListener(new SSHCropRotationWheel.SSHRotationWheelListener() { // from class: ir.appp.rghapp.components.SSHPhotoCropView.2
                @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHRotationWheelListener
                public void onStart() {
                    SSHPhotoCropView.this.cropView.onRotationBegan();
                }

                @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHRotationWheelListener
                public void onChange(float f) {
                    SSHPhotoCropView.this.cropView.setRotation(f);
                    if (SSHPhotoCropView.this.delegate != null) {
                        SSHPhotoCropView.this.delegate.onChange(false);
                    }
                }

                @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHRotationWheelListener
                public void onEnd(float f) {
                    SSHPhotoCropView.this.cropView.onRotationEnded();
                }
            });
            addView(this.wheelView, LayoutHelper.createFrame(-1, -2.0f, 81, 0.0f, 0.0f, 0.0f, 44.0f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setBackgroundColor(Theme.getColor(i));
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            textView.setWillNotDraw(false);
            textView.setGravity(17);
            textView.setText(LocaleController.getString("CANCEL", R.string.rubinoActionCancel));
            int i2 = Theme.key_rubino_add_post_TabActiveText;
            textView.setTextColor(Theme.getColor(i2));
            textView.setTextSize(1, 14.0f);
            textView.setSingleLine(true);
            textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoCropView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setBitmap$0(view);
                }
            });
            linearLayout.addView(textView, LayoutHelper.createLinear(0, -1, 0.5f));
            TextView textView2 = new TextView(getContext());
            textView2.setWillNotDraw(false);
            textView2.setGravity(17);
            textView2.setText(LocaleController.getString("DONE", R.string.rubinoActionDone));
            textView2.setTextColor(Theme.getColor(i2));
            textView2.setTextSize(1, 14.0f);
            textView2.setSingleLine(true);
            textView2.setTypeface(Theme.getRubinoTypeFaceMedium());
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoCropView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setBitmap$1(view);
                }
            });
            linearLayout.addView(textView2, LayoutHelper.createLinear(0, -1, 0.5f));
            addView(linearLayout, LayoutHelper.createFrame(-1, 44, 83));
        }
        if (sSHCropState != null) {
            this.wheelView.setRotation(sSHCropState.rotation, false);
        }
        this.cropView.setVisibility(0);
        this.cropView.setBitmap(bitmap, sSHCropState, z);
        if (this.showOnSetBitmap) {
            this.showOnSetBitmap = false;
            this.cropView.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBitmap$0(View view) {
        OnActionClickedListener onActionClickedListener = this.actionClickedListener;
        if (onActionClickedListener != null) {
            onActionClickedListener.onCancelClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBitmap$1(View view) {
        OnActionClickedListener onActionClickedListener = this.actionClickedListener;
        if (onActionClickedListener != null) {
            onActionClickedListener.onDoneClicked();
        }
    }

    public void reset() {
        this.wheelView.lambda$new$0();
        this.cropView.reset(true);
    }

    public void onAppear() {
        SSHCropView sSHCropView = this.cropView;
        if (sSHCropView != null) {
            sSHCropView.willShow();
        }
    }

    public void onAppeared() {
        SSHCropView sSHCropView = this.cropView;
        if (sSHCropView != null) {
            sSHCropView.show();
        } else {
            this.showOnSetBitmap = true;
        }
    }

    public void onDisappear() {
        this.cropView.hide();
    }

    public float getRectX() {
        return this.cropView.getCropLeft() - AndroidUtilities.dp(14.0f);
    }

    public float getRectY() {
        return (this.cropView.getCropTop() - AndroidUtilities.dp(14.0f)) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
    }

    public float getRectSizeX() {
        return this.cropView.getCropWidth();
    }

    public float getRectSizeY() {
        return this.cropView.getCropHeight();
    }

    public float getLimitX() {
        return this.rectX - Math.max(0.0f, (float) Math.ceil((getWidth() - (this.bitmapWidth * this.bitmapGlobalScale)) / 2.0f));
    }

    public float getLimitY() {
        return this.rectY - Math.max(0.0f, (float) Math.ceil(((getHeight() - (this.bitmapHeight * this.bitmapGlobalScale)) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)) / 2.0f));
    }

    public float getLimitWidth() {
        return (((getWidth() - AndroidUtilities.dp(14.0f)) - this.rectX) - ((int) Math.max(0.0d, Math.ceil(((getWidth() - AndroidUtilities.dp(28.0f)) - (this.bitmapWidth * this.bitmapGlobalScale)) / 2.0f)))) - this.rectSizeX;
    }

    public float getLimitHeight() {
        return ((((getHeight() - AndroidUtilities.dp(14.0f)) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)) - this.rectY) - ((int) Math.max(0.0d, Math.ceil((((getHeight() - AndroidUtilities.dp(28.0f)) - (this.bitmapHeight * this.bitmapGlobalScale)) - r0) / 2.0f)))) - this.rectSizeY;
    }

    public SSHCropView.SSHCropState getCropState() {
        return this.cropView.getCropState();
    }

    public Bitmap getBitmap() {
        SSHCropView sSHCropView = this.cropView;
        if (sSHCropView != null) {
            return sSHCropView.getResult();
        }
        return null;
    }

    public void rotate90Degrees() {
        this.cropView.rotate90Degrees();
        this.wheelView.lambda$new$0();
    }

    public void setAnimationProgress(float f) {
        RectF rectF = this.animationStartValues;
        if (rectF != null) {
            if (f == 1.0f) {
                RectF rectF2 = this.animationEndValues;
                this.rectX = rectF2.left;
                this.rectY = rectF2.top;
                this.rectSizeX = rectF2.right;
                this.rectSizeY = rectF2.bottom;
                this.animationStartValues = null;
                this.animationEndValues = null;
            } else {
                float f2 = rectF.left;
                RectF rectF3 = this.animationEndValues;
                this.rectX = f2 + ((rectF3.left - f2) * f);
                float f3 = rectF.top;
                this.rectY = f3 + ((rectF3.top - f3) * f);
                float f4 = rectF.right;
                this.rectSizeX = f4 + ((rectF3.right - f4) * f);
                float f5 = rectF.bottom;
                this.rectSizeY = f5 + ((rectF3.bottom - f5) * f);
            }
            invalidate();
        }
    }

    public void setDelegate(SSHPhotoCropViewDelegate sSHPhotoCropViewDelegate) {
        this.delegate = sSHPhotoCropViewDelegate;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.actionClickedListener = onActionClickedListener;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.delegate.getBitmap();
    }
}
