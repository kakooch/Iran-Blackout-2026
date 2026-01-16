package ir.appp.rghapp.components;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SSHPhotoEditColorView extends FrameLayout {
    private OnActionClickedListener actionClickedListener;
    private final TextView adjustHint;
    private final TextView btnHighLights;
    private final TextView btnShadows;
    private int currentHighlightColor;
    private int currentShadowColor;
    private int currentType;
    private boolean isFirstColorPicked;
    private OnColorClickedListener onColorClickedListener;
    private final LinearLayout tintButtonsContainer;
    private final int[] tintHighlighsColors;
    private final int[] tintShadowColors;

    public interface OnActionClickedListener {
        void onCancelClicked();

        void onDoneClicked();
    }

    public interface OnColorClickedListener {
        void onColorClicked(int i, int i2, int i3);
    }

    public SSHPhotoEditColorView(Context context) {
        super(context);
        this.tintShadowColors = new int[]{0, -3685842, -3699922, -3723730, -3915394, -8048953, -13747001, -13718585, -13711556};
        this.tintHighlighsColors = new int[]{0, -1645705, -1655945, -1673353, -1405768, -4818970, -8944922, -8924442, -8919423};
        this.isFirstColorPicked = true;
        this.currentType = 0;
        DisplayMetrics displayMetrics = AndroidUtilities.displayMetrics;
        float fDp2 = ((displayMetrics.heightPixels - displayMetrics.widthPixels) - AndroidUtilities.dp2(92.0f)) / AndroidUtilities.density;
        TextView textView = new TextView(context);
        this.adjustHint = textView;
        textView.setGravity(17);
        textView.setText(LocaleController.getString("TAP AGAIN TO ADJUST", R.string.rubinoTapToAdjust));
        textView.setTextColor(Theme.getColor(Theme.key_rubino_add_post_TabUnactiveText));
        textView.setTextSize(1, 14.0f);
        textView.setSingleLine(true);
        textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView.setVisibility(8);
        addView(textView, LayoutHelper.createFrame(-1, fDp2 / 2.0f, 17, 0.0f, fDp2 / 4.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.tintButtonsContainer = linearLayout;
        linearLayout.setOrientation(0);
        int i = 0;
        while (i < this.tintShadowColors.length) {
            SSHRadioButton sSHRadioButton = new SSHRadioButton(context);
            sSHRadioButton.setTag(Integer.valueOf(i));
            sSHRadioButton.setChecked(i == 0 || this.currentShadowColor == this.tintShadowColors[i]);
            this.tintButtonsContainer.addView(sSHRadioButton, LayoutHelper.createLinear(0, -1, 1.0f / this.tintShadowColors.length));
            sSHRadioButton.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            i++;
        }
        addView(this.tintButtonsContainer, LayoutHelper.createFrame(-1, -1.0f, 17, 30.0f, 0.0f, 30.0f, 6.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        TextView textView2 = new TextView(getContext());
        this.btnShadows = textView2;
        textView2.setWillNotDraw(false);
        textView2.setGravity(17);
        textView2.setText("SHADOWS");
        textView2.setTextColor(ContextCompat.getColor(context, R.color.rubino_blue));
        textView2.setTextSize(1, 14.0f);
        textView2.setSingleLine(true);
        textView2.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        linearLayout2.addView(textView2, LayoutHelper.createLinear(0, -1, 0.5f));
        TextView textView3 = new TextView(getContext());
        this.btnHighLights = textView3;
        textView3.setWillNotDraw(false);
        textView3.setGravity(17);
        textView3.setText("HIGHLIGHTS");
        textView3.setTextColor(Theme.getColor(Theme.key_rubino_add_post_TabUnactiveText));
        textView3.setTextSize(1, 14.0f);
        textView3.setSingleLine(true);
        textView3.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        linearLayout2.addView(textView3, LayoutHelper.createLinear(0, -1, 0.5f));
        addView(linearLayout2, LayoutHelper.createFrame(-1, 32, 51));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        TextView textView4 = new TextView(getContext());
        textView4.setWillNotDraw(false);
        textView4.setGravity(17);
        textView4.setText(LocaleController.getString("CANCEL", R.string.rubinoActionCancel));
        int i2 = Theme.key_rubino_add_post_TabActiveText;
        textView4.setTextColor(Theme.getColor(i2));
        textView4.setTextSize(1, 14.0f);
        textView4.setSingleLine(true);
        textView4.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$3(view);
            }
        });
        linearLayout3.addView(textView4, LayoutHelper.createLinear(0, -1, 0.5f));
        TextView textView5 = new TextView(getContext());
        textView5.setWillNotDraw(false);
        textView5.setGravity(17);
        textView5.setText(LocaleController.getString("DONE", R.string.rubinoActionDone));
        textView5.setTextColor(Theme.getColor(i2));
        textView5.setTextSize(1, 14.0f);
        textView5.setSingleLine(true);
        textView5.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView5.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$4(view);
            }
        });
        linearLayout3.addView(textView5, LayoutHelper.createLinear(0, -1, 0.5f));
        addView(linearLayout3, LayoutHelper.createFrame(-1, 44, 83));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (this.isFirstColorPicked) {
            showAdjustHint();
            this.isFirstColorPicked = false;
        } else {
            this.adjustHint.clearAnimation();
            this.adjustHint.setVisibility(8);
        }
        SSHRadioButton sSHRadioButton = (SSHRadioButton) view;
        if (this.currentType == 0) {
            this.currentShadowColor = this.tintShadowColors[((Integer) sSHRadioButton.getTag()).intValue()];
        } else {
            this.currentHighlightColor = this.tintHighlighsColors[((Integer) sSHRadioButton.getTag()).intValue()];
        }
        updateSelectedTintButton();
        OnColorClickedListener onColorClickedListener = this.onColorClickedListener;
        if (onColorClickedListener != null) {
            onColorClickedListener.onColorClicked(this.currentType, this.currentShadowColor, this.currentHighlightColor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        if (this.currentType != 0) {
            this.currentType = 0;
            updateSelectedTintButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        if (this.currentType != 1) {
            this.currentType = 1;
            updateSelectedTintButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        OnActionClickedListener onActionClickedListener = this.actionClickedListener;
        if (onActionClickedListener != null) {
            onActionClickedListener.onCancelClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) {
        OnActionClickedListener onActionClickedListener = this.actionClickedListener;
        if (onActionClickedListener != null) {
            onActionClickedListener.onDoneClicked();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
    }

    private void showAdjustHint() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                SSHPhotoEditColorView.this.adjustHint.setVisibility(0);
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(900L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditColorView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SSHPhotoEditColorView.this.adjustHint.setVisibility(8);
            }
        });
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation2.setStartOffset(3000L);
        animationSet.addAnimation(alphaAnimation2);
        this.adjustHint.startAnimation(animationSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.adjustHint.clearAnimation();
        this.adjustHint.setVisibility(8);
        this.isFirstColorPicked = true;
    }

    public void setCurrentShadowColor(int i) {
        this.currentShadowColor = i;
    }

    public void setCurrentHighlightColor(int i) {
        this.currentHighlightColor = i;
    }

    public void updateSelectedTintButton() {
        int color;
        this.btnShadows.setTextColor(this.currentType == 0 ? ContextCompat.getColor(getContext(), R.color.rubino_blue) : Theme.getColor(Theme.key_rubino_add_post_TabUnactiveText));
        this.btnHighLights.setTextColor(this.currentType == 1 ? ContextCompat.getColor(getContext(), R.color.rubino_blue) : Theme.getColor(Theme.key_rubino_add_post_TabUnactiveText));
        int childCount = this.tintButtonsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.tintButtonsContainer.getChildAt(i);
            if (childAt instanceof SSHRadioButton) {
                SSHRadioButton sSHRadioButton = (SSHRadioButton) childAt;
                int iIntValue = ((Integer) sSHRadioButton.getTag()).intValue();
                if (this.currentType == 0) {
                    sSHRadioButton.setChecked(this.currentShadowColor == this.tintShadowColors[iIntValue]);
                } else {
                    sSHRadioButton.setChecked(this.currentHighlightColor == this.tintHighlighsColors[iIntValue]);
                }
                if (iIntValue == 0) {
                    color = Theme.getColor(Theme.key_rubinoBlackColor);
                } else {
                    color = this.currentType == 0 ? this.tintShadowColors[iIntValue] : this.tintHighlighsColors[iIntValue];
                }
                sSHRadioButton.setColor(color);
                sSHRadioButton.showLine(iIntValue == 0);
            }
        }
    }

    public void setSelectedColor(int i, int i2, int i3) {
        this.currentType = i;
        this.currentShadowColor = i2;
        this.currentHighlightColor = i3;
        updateSelectedTintButton();
    }

    public void setOnColorClickedListener(OnColorClickedListener onColorClickedListener) {
        this.onColorClickedListener = onColorClickedListener;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.actionClickedListener = onActionClickedListener;
    }
}
