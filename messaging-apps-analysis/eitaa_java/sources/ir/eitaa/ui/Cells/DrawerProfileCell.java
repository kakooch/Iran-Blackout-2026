package ir.eitaa.ui.Cells;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.SnowflakesEffect;

/* loaded from: classes3.dex */
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
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setLines(1);
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setGravity(3);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 16.0f, 0.0f, 76.0f, 28.0f));
        TextView textView2 = new TextView(context);
        this.phoneTextView = textView2;
        textView2.setTextSize(1, 13.0f);
        this.phoneTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.phoneTextView.setLines(1);
        this.phoneTextView.setMaxLines(1);
        this.phoneTextView.setSingleLine(true);
        this.phoneTextView.setGravity(3);
        addView(this.phoneTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 16.0f, 0.0f, 76.0f, 9.0f));
        ImageView imageView2 = new ImageView(context);
        this.arrowView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.arrowView.setImageResource(R.drawable.menu_expand);
        addView(this.arrowView, LayoutHelper.createFrame(59, 59, 85));
        setArrowState(false);
        this.sunDrawable = new RLottieDrawable(R.raw.sun, "2131624028", AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), true, (int[]) null);
        if (isCurrentThemeDay()) {
            this.sunDrawable.setCustomEndFrame(36);
        } else {
            this.sunDrawable.setCustomEndFrame(0);
            this.sunDrawable.setCurrentFrame(36);
        }
        this.sunDrawable.setPlayInDirectionOfCustomEndFrame(true);
        this.darkThemeView = new RLottieImageView(context) { // from class: ir.eitaa.ui.Cells.DrawerProfileCell.1
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                if (DrawerProfileCell.this.sunDrawable.getCustomEndFrame() != 0) {
                    info.setText(LocaleController.getString("AccDescrSwitchToNightTheme", R.string.AccDescrSwitchToNightTheme));
                } else {
                    info.setText(LocaleController.getString("AccDescrSwitchToDayTheme", R.string.AccDescrSwitchToDayTheme));
                }
            }
        };
        this.sunDrawable.beginApplyLayerColors();
        int color = Theme.getColor("chats_menuName");
        this.sunDrawable.setLayerColor("Sunny.**", color);
        this.sunDrawable.setLayerColor("Path 6.**", color);
        this.sunDrawable.setLayerColor("Path.**", color);
        this.sunDrawable.setLayerColor("Path 5.**", color);
        this.sunDrawable.commitApplyLayerColors();
        this.darkThemeView.setScaleType(ImageView.ScaleType.CENTER);
        this.darkThemeView.setAnimation(this.sunDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            RLottieImageView rLottieImageView = this.darkThemeView;
            int color2 = Theme.getColor("listSelectorSDK21");
            this.darkThemeBackgroundColor = color2;
            rLottieImageView.setBackgroundDrawable(Theme.createSelectorDrawable(color2, 1, AndroidUtilities.dp(17.0f)));
            Theme.setRippleDrawableForceSoftware((RippleDrawable) this.darkThemeView.getBackground());
        }
        this.darkThemeView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$DrawerProfileCell$mxr6iT7mLEE3XqVB9NPeLAjWg94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$DrawerProfileCell(view);
            }
        });
        addView(this.darkThemeView, LayoutHelper.createFrame(48, 48.0f, 85, 0.0f, 0.0f, 6.0f, 90.0f));
        if (Theme.getEventType() == 0) {
            SnowflakesEffect snowflakesEffect = new SnowflakesEffect();
            this.snowflakesEffect = snowflakesEffect;
            snowflakesEffect.setColorKey("chats_menuName");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$new$0$DrawerProfileCell(android.view.View r6) {
        /*
            r5 = this;
            boolean r6 = ir.eitaa.ui.Cells.DrawerProfileCell.switchingTheme
            if (r6 == 0) goto L5
            return
        L5:
            r6 = 1
            ir.eitaa.ui.Cells.DrawerProfileCell.switchingTheme = r6
            int r6 = ir.eitaa.messenger.UserConfig.selectedAccount
            android.content.SharedPreferences r6 = ir.eitaa.messenger.MessagesController.getMainSettings(r6)
            r0 = 0
            java.lang.String r1 = "day_theme"
            java.lang.String r0 = r6.getString(r1, r0)
            ir.eitaa.ui.ActionBar.Theme$ThemeInfo r1 = ir.eitaa.ui.ActionBar.Theme.getTheme(r0)
            java.lang.String r2 = "Blue"
            if (r1 != 0) goto L1e
            r0 = r2
        L1e:
            java.lang.String r1 = "dark_theme"
            java.lang.String r3 = "Dark Blue"
            java.lang.String r6 = r6.getString(r1, r3)
            ir.eitaa.ui.ActionBar.Theme$ThemeInfo r1 = ir.eitaa.ui.ActionBar.Theme.getTheme(r6)
            if (r1 != 0) goto L2d
            r6 = r3
        L2d:
            ir.eitaa.ui.ActionBar.Theme$ThemeInfo r1 = ir.eitaa.ui.ActionBar.Theme.getActiveTheme()
            boolean r4 = r0.equals(r6)
            if (r4 == 0) goto L4d
            boolean r4 = r1.isDark()
            if (r4 != 0) goto L4b
            boolean r4 = r0.equals(r3)
            if (r4 != 0) goto L4b
            java.lang.String r4 = "Night"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L4e
        L4b:
            r3 = r6
            goto L4f
        L4d:
            r3 = r6
        L4e:
            r2 = r0
        L4f:
            java.lang.String r6 = r1.getKey()
            boolean r6 = r2.equals(r6)
            r0 = 0
            if (r6 == 0) goto L66
            ir.eitaa.ui.ActionBar.Theme$ThemeInfo r1 = ir.eitaa.ui.ActionBar.Theme.getTheme(r3)
            ir.eitaa.ui.Components.RLottieDrawable r2 = r5.sunDrawable
            r3 = 36
            r2.setCustomEndFrame(r3)
            goto L6f
        L66:
            ir.eitaa.ui.ActionBar.Theme$ThemeInfo r1 = ir.eitaa.ui.ActionBar.Theme.getTheme(r2)
            ir.eitaa.ui.Components.RLottieDrawable r2 = r5.sunDrawable
            r2.setCustomEndFrame(r0)
        L6f:
            int r2 = ir.eitaa.messenger.UserConfig.selectedAccount
            if (r6 == 0) goto L76
            java.lang.String r3 = "Dark"
            goto L78
        L76:
            java.lang.String r3 = "Day"
        L78:
            int r2 = ir.eitaa.ui.ActionBar.Theme.getDefaultAccentId(r2, r3)
            r1.currentAccentId = r2
            int r2 = ir.eitaa.ui.ActionBar.Theme.selectedAutoNightType
            if (r2 == 0) goto L9e
            android.content.Context r2 = r5.getContext()
            r3 = 2131690178(0x7f0f02c2, float:1.9009392E38)
            java.lang.String r4 = "AutoNightModeOff"
            java.lang.String r3 = ir.eitaa.messenger.LocaleController.getString(r4, r3)
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
            ir.eitaa.ui.ActionBar.Theme.selectedAutoNightType = r0
            ir.eitaa.ui.ActionBar.Theme.saveAutoNightThemeConfig()
            ir.eitaa.ui.ActionBar.Theme.cancelAutoNightThemeCallbacks()
        L9e:
            r5.switchTheme(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.DrawerProfileCell.lambda$new$0$DrawerProfileCell(android.view.View):void");
    }

    private void switchTheme(Theme.ThemeInfo themeInfo, boolean toDark) {
        int[] iArr = new int[2];
        this.darkThemeView.getLocationInWindow(iArr);
        iArr[0] = iArr[0] + (this.darkThemeView.getMeasuredWidth() / 2);
        iArr[1] = iArr[1] + (this.darkThemeView.getMeasuredHeight() / 2);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, themeInfo, Boolean.FALSE, iArr, -1, Boolean.valueOf(toDark), this.darkThemeView);
    }

    private boolean isCurrentThemeDay() {
        SharedPreferences mainSettings = MessagesController.getMainSettings(UserConfig.selectedAccount);
        String string = mainSettings.getString("day_theme", "Blue");
        if (Theme.getTheme(string) == null) {
            string = "Blue";
        }
        String string2 = mainSettings.getString("dark_theme", "Dark Blue");
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(148.0f) + AndroidUtilities.statusBarHeight, 1073741824));
            return;
        }
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(148.0f), 1073741824));
        } catch (Exception e) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(148.0f));
            FileLog.e(e);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws InterruptedException {
        int serviceMessageColor;
        boolean z;
        Drawable cachedWallpaper = Theme.getCachedWallpaper();
        boolean z2 = (applyBackground(false).equals("chats_menuTopBackground") || !Theme.isCustomTheme() || Theme.isPatternWallpaper() || cachedWallpaper == null || (cachedWallpaper instanceof ColorDrawable) || (cachedWallpaper instanceof GradientDrawable)) ? false : true;
        if (!z2 && Theme.hasThemeKey("chats_menuTopShadowCats")) {
            serviceMessageColor = Theme.getColor("chats_menuTopShadowCats");
            z = true;
        } else {
            if (Theme.hasThemeKey("chats_menuTopShadow")) {
                serviceMessageColor = Theme.getColor("chats_menuTopShadow");
            } else {
                serviceMessageColor = Theme.getServiceMessageColor() | (-16777216);
            }
            z = false;
        }
        Integer num = this.currentColor;
        if (num == null || num.intValue() != serviceMessageColor) {
            this.currentColor = Integer.valueOf(serviceMessageColor);
            this.shadowView.getDrawable().setColorFilter(new PorterDuffColorFilter(serviceMessageColor, PorterDuff.Mode.MULTIPLY));
        }
        int color = Theme.getColor("chats_menuName");
        Integer num2 = this.currentMoonColor;
        if (num2 == null || num2.intValue() != color) {
            this.currentMoonColor = Integer.valueOf(color);
            this.sunDrawable.beginApplyLayerColors();
            this.sunDrawable.setLayerColor("Sunny.**", this.currentMoonColor.intValue());
            this.sunDrawable.setLayerColor("Path 6.**", this.currentMoonColor.intValue());
            this.sunDrawable.setLayerColor("Path.**", this.currentMoonColor.intValue());
            this.sunDrawable.setLayerColor("Path 5.**", this.currentMoonColor.intValue());
            this.sunDrawable.commitApplyLayerColors();
        }
        this.nameTextView.setTextColor(Theme.getColor("chats_menuName"));
        if (z2) {
            this.phoneTextView.setTextColor(Theme.getColor("chats_menuPhone"));
            if (this.shadowView.getVisibility() != 0) {
                this.shadowView.setVisibility(0);
            }
            if ((cachedWallpaper instanceof ColorDrawable) || (cachedWallpaper instanceof GradientDrawable)) {
                cachedWallpaper.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                cachedWallpaper.draw(canvas);
                color = Theme.getColor("listSelectorSDK21");
            } else if (cachedWallpaper instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) cachedWallpaper).getBitmap();
                float fMax = Math.max(getMeasuredWidth() / bitmap.getWidth(), getMeasuredHeight() / bitmap.getHeight());
                int measuredWidth = (int) (getMeasuredWidth() / fMax);
                int measuredHeight = (int) (getMeasuredHeight() / fMax);
                int width = (bitmap.getWidth() - measuredWidth) / 2;
                int height = (bitmap.getHeight() - measuredHeight) / 2;
                this.srcRect.set(width, height, measuredWidth + width, measuredHeight + height);
                this.destRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
                try {
                    canvas.drawBitmap(bitmap, this.srcRect, this.destRect, this.paint);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
                color = (Theme.getServiceMessageColor() & 16777215) | 1342177280;
            }
        } else {
            color = z ? 0 : 4;
            if (this.shadowView.getVisibility() != color) {
                this.shadowView.setVisibility(color);
            }
            this.phoneTextView.setTextColor(Theme.getColor("chats_menuPhoneCats"));
            super.onDraw(canvas);
            color = Theme.getColor("listSelectorSDK21");
        }
        if (color != 0) {
            if (color != this.darkThemeBackgroundColor) {
                Paint paint = this.backPaint;
                this.darkThemeBackgroundColor = color;
                paint.setColor(color);
                if (Build.VERSION.SDK_INT >= 21) {
                    Drawable background = this.darkThemeView.getBackground();
                    this.darkThemeBackgroundColor = color;
                    Theme.setSelectorDrawableColor(background, color, true);
                }
            }
            if (z2 && (cachedWallpaper instanceof BitmapDrawable)) {
                canvas.drawCircle(this.darkThemeView.getX() + (this.darkThemeView.getMeasuredWidth() / 2), this.darkThemeView.getY() + (this.darkThemeView.getMeasuredHeight() / 2), AndroidUtilities.dp(17.0f), this.backPaint);
            }
        }
        SnowflakesEffect snowflakesEffect = this.snowflakesEffect;
        if (snowflakesEffect != null) {
            snowflakesEffect.onDraw(this, canvas);
        }
    }

    public boolean isInAvatar(float x, float y) {
        return x >= ((float) this.avatarImageView.getLeft()) && x <= ((float) this.avatarImageView.getRight()) && y >= ((float) this.avatarImageView.getTop()) && y <= ((float) this.avatarImageView.getBottom());
    }

    public boolean hasAvatar() {
        return this.avatarImageView.getImageReceiver().hasNotThumb();
    }

    public void setAccountsShown(boolean value, boolean animated) {
        if (this.accountsShown == value) {
            return;
        }
        this.accountsShown = value;
        setArrowState(animated);
    }

    public void setUser(TLRPC$User user, boolean accounts) {
        if (user == null) {
            return;
        }
        this.accountsShown = accounts;
        if (!isCurrentThemeDay()) {
            this.sunDrawable.setCustomEndFrame(36);
        } else {
            this.sunDrawable.setCustomEndFrame(0);
            this.sunDrawable.setCurrentFrame(36);
        }
        this.darkThemeView.playAnimation();
        setArrowState(false);
        this.nameTextView.setText(UserObject.getUserName(user));
        this.phoneTextView.setText(PhoneFormat.getInstance().format("+" + user.phone));
        AvatarDrawable avatarDrawable = new AvatarDrawable(user);
        avatarDrawable.setColor(Theme.getColor("avatar_backgroundInProfileBlue"));
        this.avatarImageView.setForUserOrChat(user, avatarDrawable);
        applyBackground(true);
    }

    public String applyBackground(boolean force) {
        String str = (String) getTag();
        String str2 = (!Theme.hasThemeKey("chats_menuTopBackground") || Theme.getColor("chats_menuTopBackground") == 0) ? "chats_menuTopBackgroundCats" : "chats_menuTopBackground";
        if (force || !str2.equals(str)) {
            setBackgroundColor(Theme.getColor(str2));
            setTag(str2);
        }
        return str2;
    }

    public void updateColors() {
        SnowflakesEffect snowflakesEffect = this.snowflakesEffect;
        if (snowflakesEffect != null) {
            snowflakesEffect.updateColors();
        }
    }

    private void setArrowState(boolean animated) {
        int i;
        String str;
        float f = this.accountsShown ? 180.0f : 0.0f;
        if (animated) {
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
