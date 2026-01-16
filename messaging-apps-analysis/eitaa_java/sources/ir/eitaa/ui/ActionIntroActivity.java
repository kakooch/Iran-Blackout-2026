package ir.eitaa.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MrzRecognizer;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.CameraScanActivity;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.ShareLocationDrawable;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.Components.voip.CellFlickerDrawable;
import java.util.ArrayList;

@TargetApi(23)
/* loaded from: classes3.dex */
public class ActionIntroActivity extends BaseFragment implements LocationController.LocationFetchCallback {
    private TextView buttonTextView;
    private int[] colors;
    private String currentGroupCreateAddress;
    private String currentGroupCreateDisplayAddress;
    private Location currentGroupCreateLocation;
    private int currentType;
    private LinearLayout descriptionLayout;
    private TextView descriptionText;
    private TextView descriptionText2;
    private TextView[] desctiptionLines = new TextView[6];
    private Drawable drawable1;
    private Drawable drawable2;
    private boolean flickerButton;
    private RLottieImageView imageView;
    private ActionIntroQRLoginDelegate qrLoginDelegate;
    private TextView subtitleTextView;
    private TextView titleTextView;

    public interface ActionIntroQRLoginDelegate {
        void didFindQRCode(String code);
    }

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public ActionIntroActivity(int type) {
        this.currentType = type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        ?? r5 = 0;
        this.actionBar.setItemsColor(Theme.getColor("windowBackgroundWhiteGrayText2"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarWhiteSelector"), false);
        this.actionBar.setCastShadows(false);
        this.actionBar.setAddToContainer(false);
        if (!AndroidUtilities.isTablet()) {
            this.actionBar.showActionModeTop();
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ActionIntroActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ActionIntroActivity.this.finishFragment();
                }
            }
        });
        ViewGroup viewGroup = new ViewGroup(context) { // from class: ir.eitaa.ui.ActionIntroActivity.2
            /* JADX WARN: Removed duplicated region for block: B:24:0x029c  */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onMeasure(int r13, int r14) {
                /*
                    Method dump skipped, instructions count: 989
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionIntroActivity.AnonymousClass2.onMeasure(int, int):void");
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                float f;
                float f2;
                ((BaseFragment) ActionIntroActivity.this).actionBar.layout(0, 0, r, ((BaseFragment) ActionIntroActivity.this).actionBar.getMeasuredHeight());
                int i = r - l;
                int i2 = b - t;
                int i3 = ActionIntroActivity.this.currentType;
                if (i3 == 0) {
                    if (r > b) {
                        int measuredHeight = (i2 - ActionIntroActivity.this.imageView.getMeasuredHeight()) / 2;
                        ActionIntroActivity.this.imageView.layout(0, measuredHeight, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight);
                        float f3 = i;
                        float f4 = 0.4f * f3;
                        int i4 = (int) f4;
                        float f5 = i2;
                        int i5 = (int) (0.22f * f5);
                        ActionIntroActivity.this.titleTextView.layout(i4, i5, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i4, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i5);
                        int i6 = (int) (0.39f * f5);
                        ActionIntroActivity.this.descriptionText.layout(i4, i6, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i4, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i6);
                        int measuredWidth = (int) (f4 + (((f3 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                        int i7 = (int) (f5 * 0.69f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth, i7, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i7);
                        return;
                    }
                    float f6 = i2;
                    int i8 = (int) (0.188f * f6);
                    ActionIntroActivity.this.imageView.layout(0, i8, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i8);
                    int i9 = (int) (0.651f * f6);
                    ActionIntroActivity.this.titleTextView.layout(0, i9, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i9);
                    int i10 = (int) (0.731f * f6);
                    ActionIntroActivity.this.descriptionText.layout(0, i10, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i10);
                    int measuredWidth2 = (i - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                    int i11 = (int) (f6 * 0.853f);
                    ActionIntroActivity.this.buttonTextView.layout(measuredWidth2, i11, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth2, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i11);
                    return;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (r > b) {
                            float f7 = i2;
                            int measuredHeight2 = ((int) ((0.9f * f7) - ActionIntroActivity.this.imageView.getMeasuredHeight())) / 2;
                            ActionIntroActivity.this.imageView.layout(0, measuredHeight2, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight2);
                            int measuredHeight3 = measuredHeight2 + ActionIntroActivity.this.imageView.getMeasuredHeight() + AndroidUtilities.dp(10.0f);
                            ActionIntroActivity.this.subtitleTextView.layout(0, measuredHeight3, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + measuredHeight3);
                            float f8 = i;
                            float f9 = 0.4f * f8;
                            int i12 = (int) f9;
                            int i13 = (int) (0.12f * f7);
                            ActionIntroActivity.this.titleTextView.layout(i12, i13, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i12, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i13);
                            int i14 = (int) (0.26f * f7);
                            ActionIntroActivity.this.descriptionText.layout(i12, i14, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i12, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i14);
                            int measuredWidth3 = (int) (f9 + (((f8 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i15 = (int) (f7 * 0.6f);
                            ActionIntroActivity.this.buttonTextView.layout(measuredWidth3, i15, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth3, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i15);
                            int measuredHeight4 = (getMeasuredHeight() - ActionIntroActivity.this.descriptionText2.getMeasuredHeight()) - AndroidUtilities.dp(20.0f);
                            ActionIntroActivity.this.descriptionText2.layout(i12, measuredHeight4, ActionIntroActivity.this.descriptionText2.getMeasuredWidth() + i12, ActionIntroActivity.this.descriptionText2.getMeasuredHeight() + measuredHeight4);
                            return;
                        }
                        float f10 = i2;
                        int i16 = (int) (0.197f * f10);
                        ActionIntroActivity.this.imageView.layout(0, i16, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i16);
                        int i17 = (int) (0.421f * f10);
                        ActionIntroActivity.this.titleTextView.layout(0, i17, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i17);
                        int i18 = (int) (0.477f * f10);
                        ActionIntroActivity.this.subtitleTextView.layout(0, i18, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + i18);
                        int i19 = (int) (0.537f * f10);
                        ActionIntroActivity.this.descriptionText.layout(0, i19, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i19);
                        int measuredWidth4 = (i - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i20 = (int) (f10 * 0.71f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth4, i20, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth4, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i20);
                        int measuredHeight5 = (getMeasuredHeight() - ActionIntroActivity.this.descriptionText2.getMeasuredHeight()) - AndroidUtilities.dp(20.0f);
                        ActionIntroActivity.this.descriptionText2.layout(0, measuredHeight5, ActionIntroActivity.this.descriptionText2.getMeasuredWidth(), ActionIntroActivity.this.descriptionText2.getMeasuredHeight() + measuredHeight5);
                        return;
                    }
                    if (i3 == 3) {
                        if (r > b) {
                            float f11 = i2;
                            int measuredHeight6 = ((int) ((0.95f * f11) - ActionIntroActivity.this.imageView.getMeasuredHeight())) / 2;
                            ActionIntroActivity.this.imageView.layout(0, measuredHeight6, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight6);
                            int measuredHeight7 = measuredHeight6 + ActionIntroActivity.this.imageView.getMeasuredHeight() + AndroidUtilities.dp(10.0f);
                            ActionIntroActivity.this.subtitleTextView.layout(0, measuredHeight7, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + measuredHeight7);
                            float f12 = i;
                            float f13 = 0.4f * f12;
                            int i21 = (int) f13;
                            int i22 = (int) (0.12f * f11);
                            ActionIntroActivity.this.titleTextView.layout(i21, i22, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i21, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i22);
                            int i23 = (int) (0.24f * f11);
                            ActionIntroActivity.this.descriptionText.layout(i21, i23, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i21, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i23);
                            int measuredWidth5 = (int) (f13 + (((f12 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i24 = (int) (f11 * 0.8f);
                            ActionIntroActivity.this.buttonTextView.layout(measuredWidth5, i24, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth5, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i24);
                            return;
                        }
                        float f14 = i2;
                        int i25 = (int) (0.2229f * f14);
                        ActionIntroActivity.this.imageView.layout(0, i25, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i25);
                        int i26 = (int) (0.352f * f14);
                        ActionIntroActivity.this.titleTextView.layout(0, i26, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i26);
                        int i27 = (int) (0.409f * f14);
                        ActionIntroActivity.this.subtitleTextView.layout(0, i27, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + i27);
                        int i28 = (int) (0.468f * f14);
                        ActionIntroActivity.this.descriptionText.layout(0, i28, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i28);
                        int measuredWidth6 = (i - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i29 = (int) (f14 * 0.805f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth6, i29, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth6, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i29);
                        return;
                    }
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return;
                        }
                        if (r > b) {
                            int measuredHeight8 = (i2 - ActionIntroActivity.this.imageView.getMeasuredHeight()) / 2;
                            ActionIntroActivity.this.imageView.layout(0, measuredHeight8, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight8);
                            float f15 = i;
                            float f16 = 0.4f * f15;
                            int i30 = (int) f16;
                            float f17 = i2;
                            int i31 = (int) (0.08f * f17);
                            ActionIntroActivity.this.titleTextView.layout(i30, i31, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i30, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i31);
                            float f18 = f15 * 0.6f;
                            int measuredWidth7 = (int) (((f18 - ActionIntroActivity.this.descriptionLayout.getMeasuredWidth()) / 2.0f) + f16);
                            int i32 = (int) (0.25f * f17);
                            ActionIntroActivity.this.descriptionLayout.layout(measuredWidth7, i32, ActionIntroActivity.this.descriptionLayout.getMeasuredWidth() + measuredWidth7, ActionIntroActivity.this.descriptionLayout.getMeasuredHeight() + i32);
                            int measuredWidth8 = (int) (f16 + ((f18 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i33 = (int) (f17 * 0.78f);
                            ActionIntroActivity.this.buttonTextView.layout(measuredWidth8, i33, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth8, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i33);
                            return;
                        }
                        if (AndroidUtilities.displaySize.y < 1800) {
                            f = i2;
                            int i34 = (int) (0.06f * f);
                            ActionIntroActivity.this.imageView.layout(0, i34, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i34);
                            int i35 = (int) (0.463f * f);
                            ActionIntroActivity.this.titleTextView.layout(0, i35, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i35);
                            f2 = 0.543f;
                        } else {
                            f = i2;
                            int i36 = (int) (0.148f * f);
                            ActionIntroActivity.this.imageView.layout(0, i36, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i36);
                            int i37 = (int) (0.551f * f);
                            ActionIntroActivity.this.titleTextView.layout(0, i37, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i37);
                            f2 = 0.631f;
                        }
                        int i38 = (int) (f * f2);
                        int measuredWidth9 = (getMeasuredWidth() - ActionIntroActivity.this.descriptionLayout.getMeasuredWidth()) / 2;
                        ActionIntroActivity.this.descriptionLayout.layout(measuredWidth9, i38, ActionIntroActivity.this.descriptionLayout.getMeasuredWidth() + measuredWidth9, ActionIntroActivity.this.descriptionLayout.getMeasuredHeight() + i38);
                        int measuredWidth10 = (i - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i39 = (int) (i2 * 0.853f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth10, i39, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth10, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i39);
                        return;
                    }
                }
                if (r > b) {
                    int measuredHeight9 = (i2 - ActionIntroActivity.this.imageView.getMeasuredHeight()) / 2;
                    float f19 = i;
                    int measuredWidth11 = ((int) ((0.5f * f19) - ActionIntroActivity.this.imageView.getMeasuredWidth())) / 2;
                    ActionIntroActivity.this.imageView.layout(measuredWidth11, measuredHeight9, ActionIntroActivity.this.imageView.getMeasuredWidth() + measuredWidth11, ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight9);
                    float f20 = 0.4f * f19;
                    int i40 = (int) f20;
                    float f21 = i2;
                    int i41 = (int) (0.14f * f21);
                    ActionIntroActivity.this.titleTextView.layout(i40, i41, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i40, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i41);
                    int i42 = (int) (0.31f * f21);
                    ActionIntroActivity.this.descriptionText.layout(i40, i42, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i40, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i42);
                    int measuredWidth12 = (int) (f20 + (((f19 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                    int i43 = (int) (f21 * 0.78f);
                    ActionIntroActivity.this.buttonTextView.layout(measuredWidth12, i43, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth12, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i43);
                    return;
                }
                float f22 = i2;
                int i44 = (int) (0.214f * f22);
                int measuredWidth13 = (i - ActionIntroActivity.this.imageView.getMeasuredWidth()) / 2;
                ActionIntroActivity.this.imageView.layout(measuredWidth13, i44, ActionIntroActivity.this.imageView.getMeasuredWidth() + measuredWidth13, ActionIntroActivity.this.imageView.getMeasuredHeight() + i44);
                int i45 = (int) (0.414f * f22);
                ActionIntroActivity.this.titleTextView.layout(0, i45, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i45);
                int i46 = (int) (0.493f * f22);
                ActionIntroActivity.this.descriptionText.layout(0, i46, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i46);
                int measuredWidth14 = (i - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                int i47 = (int) (f22 * 0.71f);
                ActionIntroActivity.this.buttonTextView.layout(measuredWidth14, i47, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth14, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i47);
            }
        };
        this.fragmentView = viewGroup;
        viewGroup.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        ViewGroup viewGroup2 = (ViewGroup) this.fragmentView;
        viewGroup2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$ehQXt7lpVLLeSsPi2gW6rJupy7w
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ActionIntroActivity.lambda$createView$0(view, motionEvent);
            }
        });
        viewGroup2.addView(this.actionBar);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        viewGroup2.addView(rLottieImageView);
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.titleTextView.setGravity(1);
        this.titleTextView.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        this.titleTextView.setTextSize(1, 24.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        viewGroup2.addView(this.titleTextView);
        TextView textView2 = new TextView(context);
        this.subtitleTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.subtitleTextView.setGravity(1);
        float f = 15.0f;
        this.subtitleTextView.setTextSize(1, 15.0f);
        this.subtitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.subtitleTextView.setSingleLine(true);
        this.subtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int i = 2;
        if (this.currentType == 2) {
            this.subtitleTextView.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
        } else {
            this.subtitleTextView.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        }
        this.subtitleTextView.setVisibility(8);
        viewGroup2.addView(this.subtitleTextView);
        TextView textView3 = new TextView(context);
        this.descriptionText = textView3;
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.descriptionText.setGravity(1);
        this.descriptionText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText.setTextSize(1, 15.0f);
        this.descriptionText.setTypeface(AndroidUtilities.getFontFamily(false));
        if (this.currentType == 2) {
            this.descriptionText.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
        } else {
            this.descriptionText.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        }
        viewGroup2.addView(this.descriptionText);
        int i2 = 3;
        if (this.currentType == 5) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.descriptionLayout = linearLayout;
            linearLayout.setOrientation(1);
            this.descriptionLayout.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
            this.descriptionLayout.setGravity(LocaleController.isRTL ? 5 : 3);
            viewGroup2.addView(this.descriptionLayout);
            int i3 = 0;
            while (i3 < i2) {
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(r5);
                this.descriptionLayout.addView(linearLayout2, LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 0.0f, i3 != i ? 7.0f : 0.0f));
                int i4 = i3 * 2;
                this.desctiptionLines[i4] = new TextView(context);
                this.desctiptionLines[i4].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.desctiptionLines[i4].setGravity(LocaleController.isRTL ? 5 : 3);
                this.desctiptionLines[i4].setTextSize(1, f);
                this.desctiptionLines[i4].setTypeface(AndroidUtilities.getFontFamily(r5));
                TextView textView4 = this.desctiptionLines[i4];
                String str = LocaleController.isRTL ? ".%d" : "%d.";
                Object[] objArr = new Object[1];
                int i5 = i3 + 1;
                objArr[r5] = Integer.valueOf(i5);
                textView4.setText(String.format(str, objArr));
                this.desctiptionLines[i4].setTypeface(AndroidUtilities.getFontFamily(true));
                int i6 = i4 + 1;
                this.desctiptionLines[i6] = new TextView(context);
                this.desctiptionLines[i6].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.desctiptionLines[i6].setGravity(LocaleController.isRTL ? 5 : 3);
                this.desctiptionLines[i6].setTextSize(1, f);
                this.desctiptionLines[i6].setTypeface(AndroidUtilities.getFontFamily(r5));
                if (i3 == 0) {
                    this.desctiptionLines[i6].setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
                    this.desctiptionLines[i6].setHighlightColor(Theme.getColor("windowBackgroundWhiteLinkSelection"));
                    String string = LocaleController.getString("AuthAnotherClientInfo1", R.string.AuthAnotherClientInfo1);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    int iIndexOf = string.indexOf(42);
                    int iLastIndexOf = string.lastIndexOf(42);
                    if (iIndexOf != -1 && iLastIndexOf != -1 && iIndexOf != iLastIndexOf) {
                        this.desctiptionLines[i6].setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
                        spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 1, (CharSequence) "");
                        spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) "");
                        spannableStringBuilder.setSpan(new URLSpanNoUnderline(LocaleController.getString("AuthAnotherClientDownloadClientUrl", R.string.AuthAnotherClientDownloadClientUrl)), iIndexOf, iLastIndexOf - 1, 33);
                    }
                    this.desctiptionLines[i6].setText(spannableStringBuilder);
                } else if (i3 == 1) {
                    this.desctiptionLines[i6].setText(LocaleController.getString("AuthAnotherClientInfo2", R.string.AuthAnotherClientInfo2));
                } else {
                    this.desctiptionLines[i6].setText(LocaleController.getString("AuthAnotherClientInfo3", R.string.AuthAnotherClientInfo3));
                }
                if (LocaleController.isRTL) {
                    linearLayout2.setGravity(5);
                    linearLayout2.addView(this.desctiptionLines[i6], LayoutHelper.createLinear(0, -2, 1.0f));
                    linearLayout2.addView(this.desctiptionLines[i4], LayoutHelper.createLinear(-2, -2, 4.0f, 0.0f, 0.0f, 0.0f));
                } else {
                    linearLayout2.addView(this.desctiptionLines[i4], LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 4.0f, 0.0f));
                    linearLayout2.addView(this.desctiptionLines[i6], LayoutHelper.createLinear(-2, -2));
                }
                i3 = i5;
                r5 = 0;
                i2 = 3;
                f = 15.0f;
                i = 2;
            }
            this.descriptionText.setVisibility(8);
        }
        TextView textView5 = new TextView(context);
        this.descriptionText2 = textView5;
        textView5.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.descriptionText2.setGravity(1);
        this.descriptionText2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText2.setTextSize(1, 13.0f);
        this.descriptionText2.setTypeface(AndroidUtilities.getFontFamily(false));
        this.descriptionText2.setVisibility(8);
        if (this.currentType == 2) {
            this.descriptionText2.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        } else {
            this.descriptionText2.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        }
        viewGroup2.addView(this.descriptionText2);
        TextView textView6 = new TextView(context) { // from class: ir.eitaa.ui.ActionIntroActivity.3
            CellFlickerDrawable cellFlickerDrawable;

            @Override // android.widget.TextView, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (ActionIntroActivity.this.flickerButton) {
                    if (this.cellFlickerDrawable == null) {
                        CellFlickerDrawable cellFlickerDrawable = new CellFlickerDrawable();
                        this.cellFlickerDrawable = cellFlickerDrawable;
                        cellFlickerDrawable.drawFrame = false;
                        cellFlickerDrawable.repeatProgress = 2.0f;
                    }
                    this.cellFlickerDrawable.setParentWidth(getMeasuredWidth());
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    this.cellFlickerDrawable.draw(canvas, rectF, AndroidUtilities.dp(4.0f));
                    invalidate();
                }
            }
        };
        this.buttonTextView = textView6;
        textView6.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        this.buttonTextView.setGravity(17);
        this.buttonTextView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.buttonTextView.setTextSize(1, 14.0f);
        this.buttonTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), -25564, -1674199));
        viewGroup2.addView(this.buttonTextView);
        this.buttonTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$8TLlFZMM_R_n31_HGWs0owZDjco
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2$ActionIntroActivity(view);
            }
        });
        int i7 = this.currentType;
        if (i7 == 0) {
            this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.imageView.setAnimation(R.raw.channel_create, 200, 200);
            this.titleTextView.setText(LocaleController.getString("ChannelAlertTitle", R.string.ChannelAlertTitle));
            this.descriptionText.setText(LocaleController.getString("ChannelAlertText", R.string.ChannelAlertText));
            this.buttonTextView.setText(LocaleController.getString("ChannelAlertCreate2", R.string.ChannelAlertCreate2));
            this.imageView.playAnimation();
            this.flickerButton = true;
        } else if (i7 == 1) {
            this.imageView.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(100.0f), Theme.getColor("chats_archiveBackground")));
            this.imageView.setImageDrawable(new ShareLocationDrawable(context, 3));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.titleTextView.setText(LocaleController.getString("PeopleNearby", R.string.PeopleNearby));
            this.descriptionText.setText(LocaleController.getString("PeopleNearbyAccessInfo", R.string.PeopleNearbyAccessInfo));
            this.buttonTextView.setText(LocaleController.getString("PeopleNearbyAllowAccess", R.string.PeopleNearbyAllowAccess));
        } else if (i7 == 2) {
            this.subtitleTextView.setVisibility(0);
            this.descriptionText2.setVisibility(0);
            this.imageView.setImageResource(Theme.getCurrentTheme().isDark() ? R.drawable.groupsintro2 : R.drawable.groupsintro);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            TextView textView7 = this.subtitleTextView;
            String str2 = this.currentGroupCreateDisplayAddress;
            textView7.setText(str2 != null ? str2 : "");
            this.titleTextView.setText(LocaleController.getString("NearbyCreateGroup", R.string.NearbyCreateGroup));
            this.descriptionText.setText(LocaleController.getString("NearbyCreateGroupInfo", R.string.NearbyCreateGroupInfo));
            this.descriptionText2.setText(LocaleController.getString("NearbyCreateGroupInfo2", R.string.NearbyCreateGroupInfo2));
            this.buttonTextView.setText(LocaleController.getString("NearbyStartGroup", R.string.NearbyStartGroup));
        } else if (i7 == 3) {
            this.subtitleTextView.setVisibility(0);
            this.drawable1 = context.getResources().getDrawable(R.drawable.sim_old);
            this.drawable2 = context.getResources().getDrawable(R.drawable.sim_new);
            this.drawable1.setColorFilter(new PorterDuffColorFilter(Theme.getColor("changephoneinfo_image"), PorterDuff.Mode.MULTIPLY));
            this.drawable2.setColorFilter(new PorterDuffColorFilter(-25564, PorterDuff.Mode.MULTIPLY));
            this.imageView.setImageDrawable(new CombinedDrawable(this.drawable1, this.drawable2));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            UserConfig userConfig = getUserConfig();
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(userConfig.clientUserId));
            if (user == null) {
                user = userConfig.getCurrentUser();
            }
            if (user != null) {
                this.subtitleTextView.setText(PhoneFormat.getInstance().format("+" + user.phone));
            }
            this.titleTextView.setText(LocaleController.getString("PhoneNumberChange2", R.string.PhoneNumberChange2));
            this.descriptionText.setText(AndroidUtilities.replaceTags(LocaleController.getString("PhoneNumberHelp", R.string.PhoneNumberHelp)));
            this.buttonTextView.setText(LocaleController.getString("PhoneNumberChange2", R.string.PhoneNumberChange2));
        } else if (i7 == 4) {
            this.imageView.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(100.0f), Theme.getColor("chats_archiveBackground")));
            this.imageView.setImageDrawable(new ShareLocationDrawable(context, 3));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.titleTextView.setText(LocaleController.getString("PeopleNearby", R.string.PeopleNearby));
            this.descriptionText.setText(LocaleController.getString("PeopleNearbyGpsInfo", R.string.PeopleNearbyGpsInfo));
            this.buttonTextView.setText(LocaleController.getString("PeopleNearbyGps", R.string.PeopleNearbyGps));
        } else if (i7 == 5) {
            this.colors = new int[8];
            updateColors();
            this.imageView.setAnimation(R.raw.qr_login, 334, 334, this.colors);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.titleTextView.setText(LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient));
            this.buttonTextView.setText(LocaleController.getString("AuthAnotherClientScan", R.string.AuthAnotherClientScan));
            this.imageView.playAnimation();
        }
        if (this.flickerButton) {
            this.buttonTextView.setPadding(AndroidUtilities.dp(34.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(34.0f), AndroidUtilities.dp(8.0f));
            this.buttonTextView.setTextSize(1, 15.0f);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ActionIntroActivity(View view) {
        if (getParentActivity() == null) {
            return;
        }
        int i = this.currentType;
        if (i == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("step", 0);
            presentFragment(new ChannelCreateActivity(bundle), true);
            return;
        }
        if (i == 1) {
            getParentActivity().requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            return;
        }
        if (i == 2) {
            if (this.currentGroupCreateAddress == null || this.currentGroupCreateLocation == null) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putLongArray("result", new long[]{getUserConfig().getClientUserId()});
            bundle2.putInt("chatType", 4);
            bundle2.putString("address", this.currentGroupCreateAddress);
            bundle2.putParcelable("location", this.currentGroupCreateLocation);
            presentFragment(new GroupCreateFinalActivity(bundle2), true);
            return;
        }
        if (i == 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("PhoneNumberChangeTitle", R.string.PhoneNumberChangeTitle));
            builder.setMessage(LocaleController.getString("PhoneNumberAlert", R.string.PhoneNumberAlert));
            builder.setPositiveButton(LocaleController.getString("Change", R.string.Change), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$jZEdjP3V6f4Imi9fhRBJvF6OrAs
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$1$ActionIntroActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        if (i != 4) {
            if (i == 5 && getParentActivity() != null) {
                if (Build.VERSION.SDK_INT >= 23 && getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
                    getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 34);
                    return;
                } else {
                    processOpenQrReader();
                    return;
                }
            }
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$ActionIntroActivity(DialogInterface dialogInterface, int i) {
        presentFragment(new ChangePhoneActivity(), true);
    }

    @Override // ir.eitaa.messenger.LocationController.LocationFetchCallback
    public void onLocationAddressAvailable(String address, String displayAddress, Location location) {
        TextView textView = this.subtitleTextView;
        if (textView == null) {
            return;
        }
        textView.setText(address);
        this.currentGroupCreateAddress = address;
        this.currentGroupCreateDisplayAddress = displayAddress;
        this.currentGroupCreateLocation = location;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            r4 = this;
            super.onResume()
            int r0 = r4.currentType
            r1 = 4
            if (r0 != r1) goto L43
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            r2 = 1
            if (r0 < r1) goto L1e
            android.content.Context r0 = ir.eitaa.messenger.ApplicationLoader.applicationContext
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.location.LocationManager r0 = (android.location.LocationManager) r0
            boolean r0 = r0.isLocationEnabled()
            goto L39
        L1e:
            r1 = 19
            if (r0 < r1) goto L38
            android.content.Context r0 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L34
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = "location_mode"
            r3 = 0
            int r0 = android.provider.Settings.Secure.getInt(r0, r1, r3)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L32
            goto L38
        L32:
            r0 = 0
            goto L39
        L34:
            r0 = move-exception
            ir.eitaa.messenger.FileLog.e(r0)
        L38:
            r0 = 1
        L39:
            if (r0 == 0) goto L43
            ir.eitaa.ui.PeopleNearbyActivity r0 = new ir.eitaa.ui.PeopleNearbyActivity
            r0.<init>()
            r4.presentFragment(r0, r2)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionIntroActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColors() {
        int[] iArr = this.colors;
        if (iArr == null || this.imageView == null) {
            return;
        }
        iArr[0] = 3355443;
        iArr[1] = Theme.getColor("windowBackgroundWhiteBlackText");
        int[] iArr2 = this.colors;
        iArr2[2] = 16777215;
        iArr2[3] = Theme.getColor("windowBackgroundWhite");
        int[] iArr3 = this.colors;
        iArr3[4] = 5285866;
        iArr3[5] = Theme.getColor("featuredStickers_addButton");
        int[] iArr4 = this.colors;
        iArr4[6] = 2170912;
        iArr4[7] = Theme.getColor("windowBackgroundWhite");
        this.imageView.replaceColors(this.colors);
    }

    public void setGroupCreateAddress(String address, String displayAddress, Location location) throws InterruptedException {
        this.currentGroupCreateAddress = address;
        this.currentGroupCreateDisplayAddress = displayAddress;
        this.currentGroupCreateLocation = location;
        if (location == null || address != null) {
            return;
        }
        LocationController.fetchLocationAddress(location, this);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        if (getParentActivity() == null) {
            return;
        }
        if (requestCode == 2) {
            if (grantResults == null || grantResults.length == 0) {
                return;
            }
            if (grantResults[0] != 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("PermissionNoLocationPosition", R.string.PermissionNoLocationPosition));
                builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$KQJuzKqAglONtsS3nt6nyzB_AvI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onRequestPermissionsResultFragment$4$ActionIntroActivity(dialogInterface, i);
                    }
                });
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                showDialog(builder.create());
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$ddMY1KvPQ-M136FrDv3GwgQ3E3E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onRequestPermissionsResultFragment$5$ActionIntroActivity();
                }
            });
            return;
        }
        if (requestCode == 34) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                processOpenQrReader();
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder2.setMessage(LocaleController.getString("QRCodePermissionNoCamera", R.string.QRCodePermissionNoCamera));
            builder2.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$ztDPpuWeQPPL-_oFideghM_fo4k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onRequestPermissionsResultFragment$6$ActionIntroActivity(dialogInterface, i);
                }
            });
            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            builder2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestPermissionsResultFragment$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$4$ActionIntroActivity(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            getParentActivity().startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestPermissionsResultFragment$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$5$ActionIntroActivity() {
        presentFragment(new PeopleNearbyActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestPermissionsResultFragment$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$6$ActionIntroActivity(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            getParentActivity().startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setQrLoginDelegate(ActionIntroQRLoginDelegate actionIntroQRLoginDelegate) {
        this.qrLoginDelegate = actionIntroQRLoginDelegate;
    }

    private void processOpenQrReader() {
        CameraScanActivity.showAsSheet(this, false, new CameraScanActivity.CameraScanActivityDelegate() { // from class: ir.eitaa.ui.ActionIntroActivity.4
            @Override // ir.eitaa.ui.CameraScanActivity.CameraScanActivityDelegate
            public /* synthetic */ void didFindMrzInfo(MrzRecognizer.Result result) {
                CameraScanActivity.CameraScanActivityDelegate.CC.$default$didFindMrzInfo(this, result);
            }

            @Override // ir.eitaa.ui.CameraScanActivity.CameraScanActivityDelegate
            public void didFindQr(String text) {
                ActionIntroActivity.this.finishFragment(false);
                ActionIntroActivity.this.qrLoginDelegate.didFindQRCode(text);
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ActionIntroActivity$vfFYu_Yx4qerubH9cRr7ATGpBWA
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updateColors();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, themeDescriptionDelegate, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarWhiteSelector"));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.subtitleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.descriptionText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        arrayList.add(new ThemeDescription(this.buttonTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(this.buttonTextView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, null, null, null, themeDescriptionDelegate, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.buttonTextView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "featuredStickers_addButtonPressed"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[0], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[1], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[1], ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[2], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[3], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[4], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.desctiptionLines[5], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, new Drawable[]{this.drawable1}, null, "changephoneinfo_image"));
        arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, new Drawable[]{this.drawable2}, null, "changephoneinfo_image2"));
        return arrayList;
    }
}
