package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MrzRecognizer;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.CameraScanActivity;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.ShareLocationDrawable;
import org.rbmain.ui.Components.URLSpanNoUnderline;

/* loaded from: classes4.dex */
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
    private RLottieImageView imageView;
    private ActionIntroQRLoginDelegate qrLoginDelegate;
    private TextView subtitleTextView;
    private TextView titleTextView;

    public interface ActionIntroQRLoginDelegate {
        void didFindQRCode(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public ActionIntroActivity(int i) {
        this.currentType = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        int i;
        ActionBar actionBar = this.actionBar;
        int i2 = Theme.key_windowBackgroundWhite;
        actionBar.setBackgroundColor(Theme.getColor(i2));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        int i3 = 0;
        this.actionBar.setItemsColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarWhiteSelector), false);
        this.actionBar.setCastShadows(false);
        this.actionBar.setAddToContainer(false);
        if (!AndroidUtilities.isTablet()) {
            this.actionBar.showActionModeTop();
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ActionIntroActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i4) {
                if (i4 == -1) {
                    ActionIntroActivity.this.finishFragment();
                }
            }
        });
        ViewGroup viewGroup = new ViewGroup(context) { // from class: org.rbmain.ui.ActionIntroActivity.2
            /* JADX WARN: Removed duplicated region for block: B:24:0x029c  */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onMeasure(int r13, int r14) {
                /*
                    Method dump skipped, instructions count: 981
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionIntroActivity.AnonymousClass2.onMeasure(int, int):void");
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i4, int i5, int i6, int i7) {
                float f;
                float f2;
                ((BaseFragment) ActionIntroActivity.this).actionBar.layout(0, 0, i6, ((BaseFragment) ActionIntroActivity.this).actionBar.getMeasuredHeight());
                int i8 = i6 - i4;
                int i9 = i7 - i5;
                int i10 = ActionIntroActivity.this.currentType;
                if (i10 == 0) {
                    if (i6 > i7) {
                        int measuredHeight = (i9 - ActionIntroActivity.this.imageView.getMeasuredHeight()) / 2;
                        ActionIntroActivity.this.imageView.layout(0, measuredHeight, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight);
                        float f3 = i8;
                        float f4 = 0.4f * f3;
                        int i11 = (int) f4;
                        float f5 = i9;
                        int i12 = (int) (0.22f * f5);
                        ActionIntroActivity.this.titleTextView.layout(i11, i12, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i11, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i12);
                        int i13 = (int) (0.39f * f5);
                        ActionIntroActivity.this.descriptionText.layout(i11, i13, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i11, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i13);
                        int measuredWidth = (int) (f4 + (((f3 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                        int i14 = (int) (f5 * 0.69f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth, i14, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i14);
                        return;
                    }
                    float f6 = i9;
                    int i15 = (int) (0.188f * f6);
                    ActionIntroActivity.this.imageView.layout(0, i15, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i15);
                    int i16 = (int) (0.651f * f6);
                    ActionIntroActivity.this.titleTextView.layout(0, i16, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i16);
                    int i17 = (int) (0.731f * f6);
                    ActionIntroActivity.this.descriptionText.layout(0, i17, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i17);
                    int measuredWidth2 = (i8 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                    int i18 = (int) (f6 * 0.853f);
                    ActionIntroActivity.this.buttonTextView.layout(measuredWidth2, i18, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth2, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i18);
                    return;
                }
                if (i10 != 1) {
                    if (i10 == 2) {
                        if (i6 > i7) {
                            float f7 = i9;
                            int measuredHeight2 = ((int) ((0.9f * f7) - ActionIntroActivity.this.imageView.getMeasuredHeight())) / 2;
                            ActionIntroActivity.this.imageView.layout(0, measuredHeight2, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight2);
                            int measuredHeight3 = measuredHeight2 + ActionIntroActivity.this.imageView.getMeasuredHeight() + AndroidUtilities.dp(10.0f);
                            ActionIntroActivity.this.subtitleTextView.layout(0, measuredHeight3, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + measuredHeight3);
                            float f8 = i8;
                            float f9 = 0.4f * f8;
                            int i19 = (int) f9;
                            int i20 = (int) (0.12f * f7);
                            ActionIntroActivity.this.titleTextView.layout(i19, i20, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i19, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i20);
                            int i21 = (int) (0.26f * f7);
                            ActionIntroActivity.this.descriptionText.layout(i19, i21, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i19, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i21);
                            int measuredWidth3 = (int) (f9 + (((f8 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i22 = (int) (f7 * 0.6f);
                            ActionIntroActivity.this.buttonTextView.layout(measuredWidth3, i22, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth3, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i22);
                            int measuredHeight4 = (getMeasuredHeight() - ActionIntroActivity.this.descriptionText2.getMeasuredHeight()) - AndroidUtilities.dp(20.0f);
                            ActionIntroActivity.this.descriptionText2.layout(i19, measuredHeight4, ActionIntroActivity.this.descriptionText2.getMeasuredWidth() + i19, ActionIntroActivity.this.descriptionText2.getMeasuredHeight() + measuredHeight4);
                            return;
                        }
                        float f10 = i9;
                        int i23 = (int) (0.197f * f10);
                        ActionIntroActivity.this.imageView.layout(0, i23, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i23);
                        int i24 = (int) (0.421f * f10);
                        ActionIntroActivity.this.titleTextView.layout(0, i24, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i24);
                        int i25 = (int) (0.477f * f10);
                        ActionIntroActivity.this.subtitleTextView.layout(0, i25, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + i25);
                        int i26 = (int) (0.537f * f10);
                        ActionIntroActivity.this.descriptionText.layout(0, i26, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i26);
                        int measuredWidth4 = (i8 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i27 = (int) (f10 * 0.71f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth4, i27, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth4, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i27);
                        int measuredHeight5 = (getMeasuredHeight() - ActionIntroActivity.this.descriptionText2.getMeasuredHeight()) - AndroidUtilities.dp(20.0f);
                        ActionIntroActivity.this.descriptionText2.layout(0, measuredHeight5, ActionIntroActivity.this.descriptionText2.getMeasuredWidth(), ActionIntroActivity.this.descriptionText2.getMeasuredHeight() + measuredHeight5);
                        return;
                    }
                    if (i10 == 3) {
                        if (i6 > i7) {
                            float f11 = i9;
                            int measuredHeight6 = ((int) ((0.95f * f11) - ActionIntroActivity.this.imageView.getMeasuredHeight())) / 2;
                            ActionIntroActivity.this.imageView.layout(0, measuredHeight6, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight6);
                            int measuredHeight7 = measuredHeight6 + ActionIntroActivity.this.imageView.getMeasuredHeight() + AndroidUtilities.dp(10.0f);
                            ActionIntroActivity.this.subtitleTextView.layout(0, measuredHeight7, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + measuredHeight7);
                            float f12 = i8;
                            float f13 = 0.4f * f12;
                            int i28 = (int) f13;
                            int i29 = (int) (0.12f * f11);
                            ActionIntroActivity.this.titleTextView.layout(i28, i29, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i28, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i29);
                            int i30 = (int) (0.24f * f11);
                            ActionIntroActivity.this.descriptionText.layout(i28, i30, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i28, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i30);
                            int measuredWidth5 = (int) (f13 + (((f12 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i31 = (int) (f11 * 0.8f);
                            ActionIntroActivity.this.buttonTextView.layout(measuredWidth5, i31, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth5, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i31);
                            return;
                        }
                        float f14 = i9;
                        int i32 = (int) (0.2229f * f14);
                        ActionIntroActivity.this.imageView.layout(0, i32, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i32);
                        int i33 = (int) (0.352f * f14);
                        ActionIntroActivity.this.titleTextView.layout(0, i33, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i33);
                        int i34 = (int) (0.409f * f14);
                        ActionIntroActivity.this.subtitleTextView.layout(0, i34, ActionIntroActivity.this.subtitleTextView.getMeasuredWidth(), ActionIntroActivity.this.subtitleTextView.getMeasuredHeight() + i34);
                        int i35 = (int) (0.468f * f14);
                        ActionIntroActivity.this.descriptionText.layout(0, i35, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i35);
                        int measuredWidth6 = (i8 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i36 = (int) (f14 * 0.805f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth6, i36, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth6, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i36);
                        return;
                    }
                    if (i10 != 4) {
                        if (i10 != 5) {
                            return;
                        }
                        if (i6 > i7) {
                            int measuredHeight8 = (i9 - ActionIntroActivity.this.imageView.getMeasuredHeight()) / 2;
                            ActionIntroActivity.this.imageView.layout(0, measuredHeight8, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight8);
                            float f15 = i8;
                            float f16 = 0.4f * f15;
                            int i37 = (int) f16;
                            float f17 = i9;
                            int i38 = (int) (0.08f * f17);
                            ActionIntroActivity.this.titleTextView.layout(i37, i38, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i37, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i38);
                            float f18 = f15 * 0.6f;
                            int measuredWidth7 = (int) (((f18 - ActionIntroActivity.this.descriptionLayout.getMeasuredWidth()) / 2.0f) + f16);
                            int i39 = (int) (0.25f * f17);
                            ActionIntroActivity.this.descriptionLayout.layout(measuredWidth7, i39, ActionIntroActivity.this.descriptionLayout.getMeasuredWidth() + measuredWidth7, ActionIntroActivity.this.descriptionLayout.getMeasuredHeight() + i39);
                            int measuredWidth8 = (int) (f16 + ((f18 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i40 = (int) (f17 * 0.78f);
                            ActionIntroActivity.this.buttonTextView.layout(measuredWidth8, i40, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth8, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i40);
                            return;
                        }
                        if (AndroidUtilities.displaySize.y < 1800) {
                            f = i9;
                            int i41 = (int) (0.06f * f);
                            ActionIntroActivity.this.imageView.layout(0, i41, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i41);
                            int i42 = (int) (0.463f * f);
                            ActionIntroActivity.this.titleTextView.layout(0, i42, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i42);
                            f2 = 0.543f;
                        } else {
                            f = i9;
                            int i43 = (int) (0.148f * f);
                            ActionIntroActivity.this.imageView.layout(0, i43, ActionIntroActivity.this.imageView.getMeasuredWidth(), ActionIntroActivity.this.imageView.getMeasuredHeight() + i43);
                            int i44 = (int) (0.551f * f);
                            ActionIntroActivity.this.titleTextView.layout(0, i44, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i44);
                            f2 = 0.631f;
                        }
                        int i45 = (int) (f * f2);
                        int measuredWidth9 = (getMeasuredWidth() - ActionIntroActivity.this.descriptionLayout.getMeasuredWidth()) / 2;
                        ActionIntroActivity.this.descriptionLayout.layout(measuredWidth9, i45, ActionIntroActivity.this.descriptionLayout.getMeasuredWidth() + measuredWidth9, ActionIntroActivity.this.descriptionLayout.getMeasuredHeight() + i45);
                        int measuredWidth10 = (i8 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i46 = (int) (i9 * 0.853f);
                        ActionIntroActivity.this.buttonTextView.layout(measuredWidth10, i46, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth10, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i46);
                        return;
                    }
                }
                if (i6 > i7) {
                    int measuredHeight9 = (i9 - ActionIntroActivity.this.imageView.getMeasuredHeight()) / 2;
                    float f19 = i8;
                    int measuredWidth11 = ((int) ((0.5f * f19) - ActionIntroActivity.this.imageView.getMeasuredWidth())) / 2;
                    ActionIntroActivity.this.imageView.layout(measuredWidth11, measuredHeight9, ActionIntroActivity.this.imageView.getMeasuredWidth() + measuredWidth11, ActionIntroActivity.this.imageView.getMeasuredHeight() + measuredHeight9);
                    float f20 = 0.4f * f19;
                    int i47 = (int) f20;
                    float f21 = i9;
                    int i48 = (int) (0.14f * f21);
                    ActionIntroActivity.this.titleTextView.layout(i47, i48, ActionIntroActivity.this.titleTextView.getMeasuredWidth() + i47, ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i48);
                    int i49 = (int) (0.31f * f21);
                    ActionIntroActivity.this.descriptionText.layout(i47, i49, ActionIntroActivity.this.descriptionText.getMeasuredWidth() + i47, ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i49);
                    int measuredWidth12 = (int) (f20 + (((f19 * 0.6f) - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                    int i50 = (int) (f21 * 0.78f);
                    ActionIntroActivity.this.buttonTextView.layout(measuredWidth12, i50, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth12, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i50);
                    return;
                }
                float f22 = i9;
                int i51 = (int) (0.214f * f22);
                int measuredWidth13 = (i8 - ActionIntroActivity.this.imageView.getMeasuredWidth()) / 2;
                ActionIntroActivity.this.imageView.layout(measuredWidth13, i51, ActionIntroActivity.this.imageView.getMeasuredWidth() + measuredWidth13, ActionIntroActivity.this.imageView.getMeasuredHeight() + i51);
                int i52 = (int) (0.414f * f22);
                ActionIntroActivity.this.titleTextView.layout(0, i52, ActionIntroActivity.this.titleTextView.getMeasuredWidth(), ActionIntroActivity.this.titleTextView.getMeasuredHeight() + i52);
                int i53 = (int) (0.493f * f22);
                ActionIntroActivity.this.descriptionText.layout(0, i53, ActionIntroActivity.this.descriptionText.getMeasuredWidth(), ActionIntroActivity.this.descriptionText.getMeasuredHeight() + i53);
                int measuredWidth14 = (i8 - ActionIntroActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                int i54 = (int) (f22 * 0.71f);
                ActionIntroActivity.this.buttonTextView.layout(measuredWidth14, i54, ActionIntroActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth14, ActionIntroActivity.this.buttonTextView.getMeasuredHeight() + i54);
            }
        };
        this.fragmentView = viewGroup;
        viewGroup.setBackgroundColor(Theme.getColor(i2));
        ViewGroup viewGroup2 = (ViewGroup) this.fragmentView;
        viewGroup2.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda4
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
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        textView.setTextColor(Theme.getColor(i4));
        this.titleTextView.setGravity(1);
        this.titleTextView.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        this.titleTextView.setTextSize(1, 24.0f);
        viewGroup2.addView(this.titleTextView);
        TextView textView2 = new TextView(context);
        this.subtitleTextView = textView2;
        textView2.setTextColor(Theme.getColor(i4));
        this.subtitleTextView.setGravity(1);
        float f = 15.0f;
        this.subtitleTextView.setTextSize(1, 15.0f);
        this.subtitleTextView.setSingleLine(true);
        this.subtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.currentType == 2) {
            this.subtitleTextView.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
        } else {
            this.subtitleTextView.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        }
        this.subtitleTextView.setVisibility(8);
        viewGroup2.addView(this.subtitleTextView);
        TextView textView3 = new TextView(context);
        this.descriptionText = textView3;
        textView3.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
        this.descriptionText.setGravity(1);
        this.descriptionText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText.setTextSize(1, 15.0f);
        if (this.currentType == 2) {
            this.descriptionText.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
        } else {
            this.descriptionText.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        }
        viewGroup2.addView(this.descriptionText);
        int i5 = this.currentType;
        String str = BuildConfig.FLAVOR;
        if (i5 == 5) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.descriptionLayout = linearLayout;
            linearLayout.setOrientation(1);
            this.descriptionLayout.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
            this.descriptionLayout.setGravity(LocaleController.isRTL ? 5 : 3);
            viewGroup2.addView(this.descriptionLayout);
            int i6 = 0;
            for (int i7 = 3; i6 < i7; i7 = 3) {
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(i3);
                this.descriptionLayout.addView(linearLayout2, LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 0.0f, i6 != 2 ? 7.0f : 0.0f));
                int i8 = i6 * 2;
                this.desctiptionLines[i8] = new TextView(context);
                TextView textView4 = this.desctiptionLines[i8];
                int i9 = Theme.key_windowBackgroundWhiteBlackText;
                textView4.setTextColor(Theme.getColor(i9));
                this.desctiptionLines[i8].setGravity(LocaleController.isRTL ? 5 : 3);
                this.desctiptionLines[i8].setTextSize(1, f);
                TextView textView5 = this.desctiptionLines[i8];
                String str2 = LocaleController.isRTL ? ".%d" : "%d.";
                Object[] objArr = new Object[1];
                int i10 = i6 + 1;
                objArr[i3] = Integer.valueOf(i10);
                textView5.setText(String.format(str2, objArr));
                this.desctiptionLines[i8].setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                int i11 = i8 + 1;
                this.desctiptionLines[i11] = new TextView(context);
                this.desctiptionLines[i11].setTextColor(Theme.getColor(i9));
                this.desctiptionLines[i11].setGravity(LocaleController.isRTL ? 5 : 3);
                this.desctiptionLines[i11].setTextSize(1, f);
                if (i6 == 0) {
                    this.desctiptionLines[i11].setLinkTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
                    this.desctiptionLines[i11].setHighlightColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkSelection));
                    String string = LocaleController.getString("AuthAnotherClientInfo1", R.string.AuthAnotherClientInfo1);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    int iIndexOf = string.indexOf(42);
                    int iLastIndexOf = string.lastIndexOf(42);
                    if (iIndexOf != -1 && iLastIndexOf != -1 && iIndexOf != iLastIndexOf) {
                        this.desctiptionLines[i11].setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
                        spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 1, (CharSequence) BuildConfig.FLAVOR);
                        spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) BuildConfig.FLAVOR);
                        spannableStringBuilder.setSpan(new URLSpanNoUnderline(LocaleController.getString("AuthAnotherClientDownloadClientUrl", R.string.AuthAnotherClientDownloadClientUrl)), iIndexOf, iLastIndexOf - 1, 33);
                    }
                    this.desctiptionLines[i11].setText(spannableStringBuilder);
                } else if (i6 == 1) {
                    this.desctiptionLines[i11].setText(LocaleController.getString("AuthAnotherClientInfo2", R.string.AuthAnotherClientInfo2));
                } else if (i6 == 2) {
                    this.desctiptionLines[i11].setText(LocaleController.getString("AuthAnotherClientInfo3", R.string.AuthAnotherClientInfo3));
                }
                if (LocaleController.isRTL) {
                    linearLayout2.setGravity(5);
                    linearLayout2.addView(this.desctiptionLines[i11], LayoutHelper.createLinear(0, -2, 1.0f));
                    linearLayout2.addView(this.desctiptionLines[i8], LayoutHelper.createLinear(-2, -2, 4.0f, 0.0f, 0.0f, 0.0f));
                } else {
                    linearLayout2.addView(this.desctiptionLines[i8], LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 4.0f, 0.0f));
                    linearLayout2.addView(this.desctiptionLines[i11], LayoutHelper.createLinear(-2, -2));
                }
                i6 = i10;
                f = 15.0f;
                i3 = 0;
            }
            this.descriptionText.setVisibility(8);
        }
        TextView textView6 = new TextView(context);
        this.descriptionText2 = textView6;
        textView6.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
        this.descriptionText2.setGravity(1);
        this.descriptionText2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText2.setTextSize(1, 13.0f);
        this.descriptionText2.setVisibility(8);
        if (this.currentType == 2) {
            i = 0;
            this.descriptionText2.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        } else {
            i = 0;
            this.descriptionText2.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        }
        viewGroup2.addView(this.descriptionText2);
        TextView textView7 = new TextView(context);
        this.buttonTextView = textView7;
        textView7.setPadding(AndroidUtilities.dp(34.0f), i, AndroidUtilities.dp(34.0f), i);
        this.buttonTextView.setGravity(17);
        this.buttonTextView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        this.buttonTextView.setTextSize(1, 14.0f);
        this.buttonTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        viewGroup2.addView(this.buttonTextView);
        this.buttonTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2(view);
            }
        });
        int i12 = this.currentType;
        if (i12 == 0) {
            this.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.imageView.setAnimation(R.raw.channel_create, 200, 200);
            this.titleTextView.setText(LocaleController.getString("ChannelAlertTitle", R.string.ChannelAlertTitle));
            this.descriptionText.setText(LocaleController.getString("ChannelAlertText", R.string.ChannelAlertText));
            this.buttonTextView.setText(LocaleController.getString("ChannelAlertCreate2", R.string.ChannelAlertCreate2));
            this.imageView.playAnimation();
        } else if (i12 == 1) {
            this.imageView.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(100.0f), Theme.getColor(Theme.key_chats_archiveBackground)));
            this.imageView.setImageDrawable(new ShareLocationDrawable(context, 3));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.titleTextView.setText(LocaleController.getString("PeopleNearby", R.string.PeopleNearby));
            this.descriptionText.setText(LocaleController.getString("PeopleNearbyAccessInfo", R.string.PeopleNearbyAccessInfo));
            this.buttonTextView.setText(LocaleController.getString("PeopleNearbyAllowAccess", R.string.PeopleNearbyAllowAccess));
        } else if (i12 == 2) {
            this.subtitleTextView.setVisibility(0);
            this.descriptionText2.setVisibility(0);
            this.imageView.setImageResource(Theme.getCurrentTheme().isDark() ? R.drawable.groupsintro2 : R.drawable.groupsintro);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            TextView textView8 = this.subtitleTextView;
            String str3 = this.currentGroupCreateDisplayAddress;
            if (str3 != null) {
                str = str3;
            }
            textView8.setText(str);
            this.titleTextView.setText(LocaleController.getString("NearbyCreateGroup", R.string.NearbyCreateGroup));
            this.descriptionText.setText(LocaleController.getString("NearbyCreateGroupInfo", R.string.NearbyCreateGroupInfo));
            this.descriptionText2.setText(LocaleController.getString("NearbyCreateGroupInfo2", R.string.NearbyCreateGroupInfo2));
            this.buttonTextView.setText(LocaleController.getString("NearbyStartGroup", R.string.NearbyStartGroup));
        } else if (i12 == 3) {
            this.subtitleTextView.setVisibility(0);
            this.drawable1 = context.getResources().getDrawable(R.drawable.sim_old);
            this.drawable2 = context.getResources().getDrawable(R.drawable.sim_new);
            this.drawable1.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_changephoneinfo_image), PorterDuff.Mode.MULTIPLY));
            this.drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_changephoneinfo_image2), PorterDuff.Mode.MULTIPLY));
            this.imageView.setImageDrawable(new CombinedDrawable(this.drawable1, this.drawable2));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            UserConfig userConfig = getUserConfig();
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(userConfig.clientUserId));
            if (user == null) {
                user = userConfig.getCurrentUser();
            }
            if (user != null) {
                this.subtitleTextView.setText(PhoneFormat.getInstance().format("+" + user.phone));
            }
            this.titleTextView.setText(LocaleController.getString("PhoneNumberChange2", R.string.PhoneNumberChange2));
            this.descriptionText.setText(AndroidUtilities.replaceTags(LocaleController.getString("PhoneNumberHelp", R.string.PhoneNumberHelp)));
            this.buttonTextView.setText(LocaleController.getString("PhoneNumberChange2", R.string.PhoneNumberChange2));
        } else if (i12 == 4) {
            this.imageView.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(100.0f), Theme.getColor(Theme.key_chats_archiveBackground)));
            this.imageView.setImageDrawable(new ShareLocationDrawable(context, 3));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.titleTextView.setText(LocaleController.getString("PeopleNearby", R.string.PeopleNearby));
            this.descriptionText.setText(LocaleController.getString("PeopleNearbyGpsInfo", R.string.PeopleNearbyGpsInfo));
            this.buttonTextView.setText(LocaleController.getString("PeopleNearbyGps", R.string.PeopleNearbyGps));
        } else if (i12 == 5) {
            this.colors = new int[8];
            updateColors();
            this.imageView.setAnimation(R.raw.qr_login, 334, 334, this.colors);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.titleTextView.setText(LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient));
            this.buttonTextView.setText(LocaleController.getString("AuthAnotherClientScan", R.string.AuthAnotherClientScan));
            this.imageView.playAnimation();
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view) {
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
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(getUserConfig().getClientUserId()));
            bundle2.putIntegerArrayList("result", arrayList);
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
            builder.setPositiveButton(LocaleController.getString("Change", R.string.Change), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$1(dialogInterface, i2);
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
    public /* synthetic */ void lambda$createView$1(DialogInterface dialogInterface, int i) {
        presentFragment(new ChangePhoneActivity(), true);
    }

    @Override // org.rbmain.messenger.LocationController.LocationFetchCallback
    public void onLocationAddressAvailable(String str, String str2, Location location) {
        TextView textView = this.subtitleTextView;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        this.currentGroupCreateAddress = str;
        this.currentGroupCreateDisplayAddress = str2;
        this.currentGroupCreateLocation = location;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
            android.content.Context r0 = org.rbmain.messenger.ApplicationLoader.applicationContext
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.location.LocationManager r0 = (android.location.LocationManager) r0
            boolean r0 = r0.isLocationEnabled()
            goto L39
        L1e:
            r1 = 19
            if (r0 < r1) goto L38
            android.content.Context r0 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Throwable -> L34
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
            org.rbmain.messenger.FileLog.e(r0)
        L38:
            r0 = 1
        L39:
            if (r0 == 0) goto L43
            org.rbmain.ui.PeopleNearbyActivity r0 = new org.rbmain.ui.PeopleNearbyActivity
            r0.<init>()
            r4.presentFragment(r0, r2)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionIntroActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColors() {
        int[] iArr = this.colors;
        if (iArr == null || this.imageView == null) {
            return;
        }
        iArr[0] = 3355443;
        iArr[1] = Theme.getColor(Theme.key_windowBackgroundWhiteBlackText);
        int[] iArr2 = this.colors;
        iArr2[2] = 16777215;
        int i = Theme.key_windowBackgroundWhite;
        iArr2[3] = Theme.getColor(i);
        int[] iArr3 = this.colors;
        iArr3[4] = 5285866;
        iArr3[5] = Theme.getColor(Theme.key_featuredStickers_addButton);
        int[] iArr4 = this.colors;
        iArr4[6] = 2170912;
        iArr4[7] = Theme.getColor(i);
        this.imageView.replaceColors(this.colors);
    }

    public void setGroupCreateAddress(String str, String str2, Location location) {
        this.currentGroupCreateAddress = str;
        this.currentGroupCreateDisplayAddress = str2;
        this.currentGroupCreateLocation = location;
        if (location == null || str != null) {
            return;
        }
        LocationController.fetchLocationAddress(location, this);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (getParentActivity() == null) {
            return;
        }
        if (i == 2) {
            if (iArr == null || iArr.length == 0) {
                return;
            }
            if (iArr[0] != 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("PermissionNoLocationPosition", R.string.PermissionNoLocationPosition));
                builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onRequestPermissionsResultFragment$4(dialogInterface, i2);
                    }
                });
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                showDialog(builder.create());
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onRequestPermissionsResultFragment$5();
                }
            });
            return;
        }
        if (i == 34) {
            if (iArr.length > 0 && iArr[0] == 0) {
                processOpenQrReader();
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder2.setMessage(LocaleController.getString("QRCodePermissionNoCamera", R.string.QRCodePermissionNoCamera));
            builder2.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onRequestPermissionsResultFragment$6(dialogInterface, i2);
                }
            });
            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            builder2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$4(DialogInterface dialogInterface, int i) {
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
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$5() {
        presentFragment(new PeopleNearbyActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$6(DialogInterface dialogInterface, int i) {
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
        CameraScanActivity.showAsSheet(this, false, new CameraScanActivity.CameraScanActivityDelegate() { // from class: org.rbmain.ui.ActionIntroActivity.3
            @Override // org.rbmain.ui.CameraScanActivity.CameraScanActivityDelegate
            public /* synthetic */ void didFindMrzInfo(MrzRecognizer.Result result) {
                CameraScanActivity.CameraScanActivityDelegate.CC.$default$didFindMrzInfo(this, result);
            }

            @Override // org.rbmain.ui.CameraScanActivity.CameraScanActivityDelegate
            public void didFindQr(String str) {
                ActionIntroActivity.this.finishFragment(false);
                ActionIntroActivity.this.qrLoginDelegate.didFindQRCode(str);
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ActionIntroActivity$$ExternalSyntheticLambda6
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updateColors();
            }
        };
        View view = this.fragmentView;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(view, i, null, null, null, themeDescriptionDelegate, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarWhiteSelector));
        TextView textView = this.titleTextView;
        int i3 = ThemeDescription.FLAG_TEXTCOLOR;
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(textView, i3, null, null, null, themeDescriptionDelegate, i4));
        arrayList.add(new ThemeDescription(this.subtitleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.descriptionText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText6));
        arrayList.add(new ThemeDescription(this.buttonTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_featuredStickers_buttonText));
        arrayList.add(new ThemeDescription(this.buttonTextView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, null, null, null, themeDescriptionDelegate, Theme.key_featuredStickers_addButton));
        arrayList.add(new ThemeDescription(this.buttonTextView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_featuredStickers_addButtonPressed));
        arrayList.add(new ThemeDescription(this.desctiptionLines[0], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.desctiptionLines[1], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.desctiptionLines[1], ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteLinkText));
        arrayList.add(new ThemeDescription(this.desctiptionLines[2], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.desctiptionLines[3], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.desctiptionLines[4], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.desctiptionLines[5], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, new Drawable[]{this.drawable1}, null, Theme.key_changephoneinfo_image));
        arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, new Drawable[]{this.drawable2}, null, Theme.key_changephoneinfo_image2));
        return arrayList;
    }
}
