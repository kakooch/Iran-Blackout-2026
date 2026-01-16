package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_authorization;
import org.rbmain.tgnet.TLRPC$TL_webAuthorization;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class SessionCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private int currentAccount;
    private TextView detailExTextView;
    private TextView detailTextView;
    private BackupImageView imageView;
    private TextView nameTextView;
    private boolean needDivider;
    private TextView onlineTextView;

    public SessionCell(Context context, int i) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(1.0f);
        if (i == 1) {
            boolean z = LocaleController.isRTL;
            addView(linearLayout, LayoutHelper.createFrame(-1, 30.0f, (z ? 5 : 3) | 48, z ? 15 : 49, 11.0f, z ? 49 : 15, 0.0f));
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            this.avatarDrawable = avatarDrawable;
            avatarDrawable.setTextSize(AndroidUtilities.dp(10.0f));
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(10.0f));
            View view = this.imageView;
            boolean z2 = LocaleController.isRTL;
            addView(view, LayoutHelper.createFrame(20, 20.0f, (z2 ? 5 : 3) | 48, z2 ? 0 : 21, 13.0f, z2 ? 21 : 0, 0.0f));
        } else {
            boolean z3 = LocaleController.isRTL;
            addView(linearLayout, LayoutHelper.createFrame(-1, 30.0f, (z3 ? 5 : 3) | 48, z3 ? 15 : 21, 11.0f, z3 ? 21 : 15, 0.0f));
        }
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        textView.setTextColor(Theme.getColor(i2));
        this.nameTextView.setTextSize(1, 16.0f);
        this.nameTextView.setLines(1);
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        TextView textView2 = new TextView(context);
        this.onlineTextView = textView2;
        textView2.setTextSize(1, 14.0f);
        this.onlineTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 48);
        if (LocaleController.isRTL) {
            linearLayout.addView(this.onlineTextView, LayoutHelper.createLinear(-2, -1, 51, 0, 2, 0, 0));
            linearLayout.addView(this.nameTextView, LayoutHelper.createLinear(0, -1, 1.0f, 53, 10, 0, 0, 0));
        } else {
            linearLayout.addView(this.nameTextView, LayoutHelper.createLinear(0, -1, 1.0f, 51, 0, 0, 10, 0));
            linearLayout.addView(this.onlineTextView, LayoutHelper.createLinear(-2, -1, 53, 0, 2, 0, 0));
        }
        TextView textView3 = new TextView(context);
        this.detailTextView = textView3;
        textView3.setTextColor(Theme.getColor(i2));
        this.detailTextView.setTextSize(1, 14.0f);
        this.detailTextView.setLines(1);
        this.detailTextView.setMaxLines(1);
        this.detailTextView.setSingleLine(true);
        this.detailTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.detailTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        addView(this.detailTextView, LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 36.0f, 21.0f, 0.0f));
        TextView textView4 = new TextView(context);
        this.detailExTextView = textView4;
        textView4.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        this.detailExTextView.setTextSize(1, 14.0f);
        this.detailExTextView.setLines(1);
        this.detailExTextView.setMaxLines(1);
        this.detailExTextView.setSingleLine(true);
        this.detailExTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.detailExTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        addView(this.detailExTextView, LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 59.0f, 21.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(90.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setSession(TLObject tLObject, boolean z) {
        String firstName;
        this.needDivider = z;
        if (tLObject instanceof TLRPC$TL_authorization) {
            TLRPC$TL_authorization tLRPC$TL_authorization = (TLRPC$TL_authorization) tLObject;
            if (tLRPC$TL_authorization.canTerminate) {
                setAlpha(1.0f);
            } else {
                setAlpha(0.6f);
            }
            this.nameTextView.setText(String.format(Locale.US, "%s %s", tLRPC$TL_authorization.app_name, tLRPC$TL_authorization.app_version));
            if ((tLRPC$TL_authorization.flags & 1) != 0) {
                int i = Theme.key_windowBackgroundWhiteValueText;
                setTag(Integer.valueOf(i));
                this.onlineTextView.setText(LocaleController.getString("Online", R.string.Online));
                this.onlineTextView.setTextColor(Theme.getColor(i));
            } else {
                int i2 = Theme.key_windowBackgroundWhiteGrayText3;
                setTag(Integer.valueOf(i2));
                this.onlineTextView.setText(LocaleController.stringForMessageListDate(tLRPC$TL_authorization.date_active));
                this.onlineTextView.setTextColor(Theme.getColor(i2));
            }
            StringBuilder sb = new StringBuilder();
            if (tLRPC$TL_authorization.ip.length() != 0) {
                sb.append(tLRPC$TL_authorization.ip);
            }
            if (tLRPC$TL_authorization.country.length() != 0) {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append("— ");
                sb.append(tLRPC$TL_authorization.country);
            }
            this.detailExTextView.setText(sb);
            StringBuilder sb2 = new StringBuilder();
            if (tLRPC$TL_authorization.device_model.length() != 0) {
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                sb2.append(tLRPC$TL_authorization.device_model);
            }
            if (tLRPC$TL_authorization.system_version.length() != 0 || tLRPC$TL_authorization.platform.length() != 0) {
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                if (tLRPC$TL_authorization.platform.length() != 0) {
                    sb2.append(tLRPC$TL_authorization.platform);
                }
                if (tLRPC$TL_authorization.system_version.length() != 0) {
                    if (tLRPC$TL_authorization.platform.length() != 0) {
                        sb2.append(" ");
                    }
                    sb2.append(tLRPC$TL_authorization.system_version);
                }
            }
            if (!tLRPC$TL_authorization.official_app) {
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                sb2.append(LocaleController.getString("UnofficialApp", R.string.UnofficialApp));
                sb2.append(" (ID: ");
                sb2.append(tLRPC$TL_authorization.api_id);
                sb2.append(")");
            }
            this.detailTextView.setText(sb2);
            return;
        }
        if (tLObject instanceof TLRPC$TL_webAuthorization) {
            TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization = (TLRPC$TL_webAuthorization) tLObject;
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(tLRPC$TL_webAuthorization.bot_id));
            this.nameTextView.setText(tLRPC$TL_webAuthorization.domain);
            if (user != null) {
                this.avatarDrawable.setInfo(user);
                firstName = UserObject.getFirstName(user);
                this.imageView.setForUserOrChat(user, this.avatarDrawable);
            } else {
                firstName = BuildConfig.FLAVOR;
            }
            int i3 = Theme.key_windowBackgroundWhiteGrayText3;
            setTag(Integer.valueOf(i3));
            this.onlineTextView.setText(LocaleController.stringForMessageListDate(tLRPC$TL_webAuthorization.date_active));
            this.onlineTextView.setTextColor(Theme.getColor(i3));
            StringBuilder sb3 = new StringBuilder();
            if (tLRPC$TL_webAuthorization.ip.length() != 0) {
                sb3.append(tLRPC$TL_webAuthorization.ip);
            }
            if (tLRPC$TL_webAuthorization.region.length() != 0) {
                if (sb3.length() != 0) {
                    sb3.append(" ");
                }
                sb3.append("— ");
                sb3.append(tLRPC$TL_webAuthorization.region);
            }
            this.detailExTextView.setText(sb3);
            StringBuilder sb4 = new StringBuilder();
            if (!TextUtils.isEmpty(firstName)) {
                sb4.append(firstName);
            }
            if (tLRPC$TL_webAuthorization.browser.length() != 0) {
                if (sb4.length() != 0) {
                    sb4.append(", ");
                }
                sb4.append(tLRPC$TL_webAuthorization.browser);
            }
            if (tLRPC$TL_webAuthorization.platform.length() != 0) {
                if (sb4.length() != 0) {
                    sb4.append(", ");
                }
                sb4.append(tLRPC$TL_webAuthorization.platform);
            }
            this.detailTextView.setText(sb4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }
}
