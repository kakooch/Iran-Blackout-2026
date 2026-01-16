package org.rbmain.ui.Cells;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import ir.medu.shad.R;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.SnowflakesEffect;

/* loaded from: classes4.dex */
public class DrawerProfileCell extends FrameLayout {
    public static boolean switchingTheme;
    private boolean accountsShown;
    private ImageView arrowView;
    private BackupImageView avatarImageView;
    private Paint backPaint;
    private Integer currentColor;
    private Integer currentMoonColor;
    private int darkThemeBackgroundColor;
    private RLottieImageView darkThemeView;
    private Rect destRect;
    private TextView nameTextView;
    private Paint paint;
    private TextView phoneTextView;
    private ImageView shadowView;
    private SnowflakesEffect snowflakesEffect;
    private Rect srcRect;
    private RLottieDrawable sunDrawable;

    public DrawerProfileCell(Context context) {
        super(context);
        this.srcRect = new Rect();
        this.destRect = new Rect();
        this.paint = new Paint();
        this.backPaint = new Paint(1);
        ImageView imageView = new ImageView(context);
        this.shadowView = imageView;
        imageView.setVisibility(4);
        this.shadowView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.shadowView.setImageResource(R.drawable.bottom_shadow);
        addView(this.shadowView, LayoutHelper.createFrame(-1, 70, 83));
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.getImageReceiver().setRoundRadius(AndroidUtilities.dp(32.0f));
        addView(this.avatarImageView, LayoutHelper.createFrame(64, 64.0f, 83, 16.0f, 0.0f, 0.0f, 67.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextSize(1, 15.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setLines(1);
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setGravity(3);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 16.0f, 0.0f, 76.0f, 28.0f));
        TextView textView2 = new TextView(context);
        this.phoneTextView = textView2;
        textView2.setTextSize(1, 13.0f);
        this.phoneTextView.setLines(1);
        this.phoneTextView.setMaxLines(1);
        this.phoneTextView.setSingleLine(true);
        this.phoneTextView.setGravity(3);
        addView(this.phoneTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 16.0f, 0.0f, 76.0f, 9.0f));
        ImageView imageView2 = new ImageView(context);
        this.arrowView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.arrowView.setImageResource(R.drawable.menu_expand);
        this.arrowView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon), PorterDuff.Mode.MULTIPLY));
        addView(this.arrowView, LayoutHelper.createFrame(59, 59, 85));
        setArrowState(false);
        this.sunDrawable = new RLottieDrawable(R.raw.sun, "2131820655", AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), true, null);
        if (isCurrentThemeDay()) {
            this.sunDrawable.setCustomEndFrame(36);
        } else {
            this.sunDrawable.setCustomEndFrame(0);
            this.sunDrawable.setCurrentFrame(36);
        }
        this.sunDrawable.setPlayInDirectionOfCustomEndFrame(true);
        RLottieImageView rLottieImageView = new RLottieImageView(context) { // from class: org.rbmain.ui.Cells.DrawerProfileCell.1
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                if (DrawerProfileCell.this.sunDrawable.getCustomEndFrame() != 0) {
                    accessibilityNodeInfo.setText(LocaleController.getString("AccDescrSwitchToNightTheme", R.string.AccDescrSwitchToNightTheme));
                } else {
                    accessibilityNodeInfo.setText(LocaleController.getString("AccDescrSwitchToDayTheme", R.string.AccDescrSwitchToDayTheme));
                }
            }
        };
        this.darkThemeView = rLottieImageView;
        rLottieImageView.setVisibility(8);
        this.sunDrawable.beginApplyLayerColors();
        int color = Theme.getColor(Theme.key_chats_name);
        this.sunDrawable.setLayerColor("Sunny.**", color);
        this.sunDrawable.setLayerColor("Path 6.**", color);
        this.sunDrawable.setLayerColor("Path.**", color);
        this.sunDrawable.setLayerColor("Path 5.**", color);
        this.sunDrawable.commitApplyLayerColors();
        this.darkThemeView.setScaleType(ImageView.ScaleType.CENTER);
        this.darkThemeView.setAnimation(this.sunDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            RLottieImageView rLottieImageView2 = this.darkThemeView;
            int color2 = Theme.getColor(Theme.key_listSelector);
            this.darkThemeBackgroundColor = color2;
            rLottieImageView2.setBackgroundDrawable(Theme.createSelectorDrawable(color2, 1, AndroidUtilities.dp(17.0f)));
            Theme.setRippleDrawableForceSoftware((RippleDrawable) this.darkThemeView.getBackground());
        }
        this.darkThemeView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Cells.DrawerProfileCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        addView(this.darkThemeView, LayoutHelper.createFrame(48, 48.0f, 85, 0.0f, 0.0f, 6.0f, 90.0f));
        if (Theme.getEventType() == 0) {
            SnowflakesEffect snowflakesEffect = new SnowflakesEffect(0);
            this.snowflakesEffect = snowflakesEffect;
            snowflakesEffect.setColorKey(Theme.key_chats_menuName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        Theme.ThemeInfo theme;
        if (switchingTheme) {
            return;
        }
        switchingTheme = true;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0);
        String string = sharedPreferences.getString("lastDayTheme", "theme_classic");
        String str = Theme.getTheme(string) != null ? string : "theme_classic";
        String string2 = sharedPreferences.getString("lastDarkTheme", "theme_dark");
        String str2 = Theme.getTheme(string2) != null ? string2 : "theme_dark";
        Theme.ThemeInfo activeTheme = Theme.getActiveTheme();
        if (str.equals(str2)) {
            if (activeTheme.isDark() || str.equals("Dark Blue") || str.equals("Night")) {
                str = "Blue";
            } else {
                str2 = "Dark Blue";
            }
        }
        boolean zEquals = str.equals(activeTheme.getKey());
        if (zEquals) {
            theme = Theme.getTheme(str2);
            this.sunDrawable.setCustomEndFrame(36);
        } else {
            theme = Theme.getTheme(str);
            this.sunDrawable.setCustomEndFrame(0);
        }
        this.darkThemeView.playAnimation();
        if (Theme.selectedAutoNightType != 0) {
            Toast.makeText(getContext(), LocaleController.getString("AutoNightModeOff", R.string.AutoNightModeOff), 0).show();
            Theme.selectedAutoNightType = 0;
            Theme.saveAutoNightThemeConfig();
            Theme.cancelAutoNightThemeCallbacks();
        }
        switchTheme(theme, zEquals);
    }

    private void switchTheme(Theme.ThemeInfo themeInfo, boolean z) {
        int[] iArr = new int[2];
        this.darkThemeView.getLocationInWindow(iArr);
        iArr[0] = iArr[0] + (this.darkThemeView.getMeasuredWidth() / 2);
        iArr[1] = iArr[1] + (this.darkThemeView.getMeasuredHeight() / 2);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, themeInfo, Boolean.FALSE, iArr, -1, Boolean.valueOf(z), this.darkThemeView);
    }

    private boolean isCurrentThemeDay() {
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0);
        String string = sharedPreferences.getString("lastDayTheme", "Blue");
        if (Theme.getTheme(string) == null) {
            string = "Blue";
        }
        String string2 = sharedPreferences.getString("lastDarkTheme", "Dark Blue");
        String str = Theme.getTheme(string2) != null ? string2 : "Dark Blue";
        Theme.ThemeInfo activeTheme = Theme.getActiveTheme();
        return ((string.equals(str) && activeTheme.isDark()) ? "Blue" : string).equals(activeTheme.getKey());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateColors();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(148.0f) + AndroidUtilities.statusBarHeight, 1073741824));
            return;
        }
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(148.0f), 1073741824));
        } catch (Exception e) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(148.0f));
            FileLog.e(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r11) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.DrawerProfileCell.onDraw(android.graphics.Canvas):void");
    }

    public boolean isInAvatar(float f, float f2) {
        return f >= ((float) this.avatarImageView.getLeft()) && f <= ((float) this.avatarImageView.getRight()) && f2 >= ((float) this.avatarImageView.getTop()) && f2 <= ((float) this.avatarImageView.getBottom());
    }

    public boolean hasAvatar() {
        return this.avatarImageView.getImageReceiver().hasNotThumb();
    }

    public void setAccountsShown(boolean z, boolean z2) {
        if (this.accountsShown == z) {
            return;
        }
        this.accountsShown = z;
        setArrowState(z2);
    }

    public void setUser(TLRPC$User tLRPC$User, boolean z) {
        if (tLRPC$User == null) {
            return;
        }
        this.accountsShown = z;
        setArrowState(false);
        this.nameTextView.setText(UserObject.getUserName(tLRPC$User));
        this.phoneTextView.setText(PhoneFormat.getInstance().format("+" + tLRPC$User.phone));
        AvatarDrawable avatarDrawable = new AvatarDrawable(tLRPC$User);
        avatarDrawable.setColor(Theme.getColor(Theme.key_avatar_backgroundInProfileBlue));
        this.avatarImageView.setForUserOrChat(tLRPC$User, avatarDrawable);
        applyBackground(true);
    }

    public int applyBackground(boolean z) {
        int iIntValue = ((Integer) getTag()).intValue();
        int i = Theme.key_actionBarDefault;
        if (z || i != iIntValue) {
            setBackgroundColor(Theme.getColor(i));
            setTag(Integer.valueOf(i));
        }
        return i;
    }

    public void updateColors() {
        SnowflakesEffect snowflakesEffect = this.snowflakesEffect;
        if (snowflakesEffect != null) {
            snowflakesEffect.updateColors();
        }
    }

    private void setArrowState(boolean z) {
        int i;
        String str;
        float f = this.accountsShown ? 180.0f : 0.0f;
        if (z) {
            this.arrowView.animate().rotation(f).setDuration(220L).setInterpolator(CubicBezierInterpolator.EASE_OUT).start();
        } else {
            this.arrowView.animate().cancel();
            this.arrowView.setRotation(f);
        }
        ImageView imageView = this.arrowView;
        if (this.accountsShown) {
            i = R.string.AccDescrHideAccounts;
            str = "AccDescrHideAccounts";
        } else {
            i = R.string.AccDescrShowAccounts;
            str = "AccDescrShowAccounts";
        }
        imageView.setContentDescription(LocaleController.getString(str, i));
    }
}
