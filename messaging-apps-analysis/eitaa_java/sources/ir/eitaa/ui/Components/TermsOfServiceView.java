package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_deleteAccount;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_help_acceptTermsOfService;
import ir.eitaa.tgnet.TLRPC$TL_help_termsOfService;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class TermsOfServiceView extends FrameLayout {
    private int currentAccount;
    private TLRPC$TL_help_termsOfService currentTos;
    private TermsOfServiceViewDelegate delegate;
    private ScrollView scrollView;
    private TextView textView;
    private TextView titleTextView;

    public interface TermsOfServiceViewDelegate {
        void onAcceptTerms(int account);
    }

    static /* synthetic */ void lambda$accept$7(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public TermsOfServiceView(final Context context) {
        super(context);
        setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        int i = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
        if (i > 0) {
            View view = new View(context);
            view.setBackgroundColor(-16777216);
            addView(view, new FrameLayout.LayoutParams(-1, i));
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.logo_middle);
        linearLayout.addView(imageView, LayoutHelper.createLinear(-2, -2, 3, 0, 28, 0, 0));
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.titleTextView.setTextSize(1, 17.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.titleTextView.setText(LocaleController.getString("PrivacyPolicyAndTerms", R.string.PrivacyPolicyAndTerms));
        linearLayout.addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 3, 0, 20, 0, 0));
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        this.textView.setGravity(51);
        this.textView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        linearLayout.addView(this.textView, LayoutHelper.createLinear(-1, -2, 3, 0, 15, 0, 15));
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        this.scrollView.setOverScrollMode(2);
        this.scrollView.setPadding(AndroidUtilities.dp(24.0f), i, AndroidUtilities.dp(24.0f), AndroidUtilities.dp(75.0f));
        this.scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        addView(this.scrollView, LayoutHelper.createLinear(-1, -2));
        TextView textView3 = new TextView(context);
        textView3.setText(LocaleController.getString("Decline", R.string.Decline).toUpperCase());
        textView3.setGravity(17);
        textView3.setTypeface(AndroidUtilities.getFontFamily(true));
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        textView3.setTextSize(1, 14.0f);
        textView3.setBackground(Theme.getRoundRectSelectorDrawable(Theme.getColor("windowBackgroundWhiteGrayText")));
        textView3.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(10.0f));
        addView(textView3, LayoutHelper.createFrame(-2, -2.0f, 83, 16.0f, 0.0f, 16.0f, 16.0f));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$5di2DTXt97ZTqr8VWd5gL2pcXDM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$4$TermsOfServiceView(view2);
            }
        });
        TextView textView4 = new TextView(context);
        textView4.setText(LocaleController.getString("Accept", R.string.Accept));
        textView4.setGravity(17);
        textView4.setTypeface(AndroidUtilities.getFontFamily(true));
        textView4.setTextColor(-1);
        textView4.setTextSize(1, 14.0f);
        textView4.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), -11491093, -12346402));
        textView4.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        addView(textView4, LayoutHelper.createFrame(-2, 42.0f, 85, 16.0f, 0.0f, 16.0f, 16.0f));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$biGVwUnTx54KXhr68xBrQG_gSsQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$6$TermsOfServiceView(view2);
            }
        });
        View view2 = new View(context);
        view2.setBackgroundColor(Theme.getColor("divider"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.bottomMargin = AndroidUtilities.dp(75.0f);
        layoutParams.gravity = 80;
        addView(view2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$TermsOfServiceView(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(LocaleController.getString("TermsOfService", R.string.TermsOfService));
        builder.setPositiveButton(LocaleController.getString("DeclineDeactivate", R.string.DeclineDeactivate), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$jYuOKlkz3S06GGa4lKukDdfCtFU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$new$3$TermsOfServiceView(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Back", R.string.Back), null);
        builder.setMessage(LocaleController.getString("TosUpdateDecline", R.string.TosUpdateDecline));
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$TermsOfServiceView(DialogInterface dialogInterface, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(LocaleController.getString("TosDeclineDeleteAccount", R.string.TosDeclineDeleteAccount));
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("Deactivate", R.string.Deactivate), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$5cI5YIpUDryJNyCU4yNgXYeMHCI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i2) {
                this.f$0.lambda$new$2$TermsOfServiceView(dialogInterface2, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$TermsOfServiceView(DialogInterface dialogInterface, int i) {
        final AlertDialog alertDialog = new AlertDialog(getContext(), 3);
        alertDialog.setCanCacnel(false);
        TLRPC$TL_account_deleteAccount tLRPC$TL_account_deleteAccount = new TLRPC$TL_account_deleteAccount();
        tLRPC$TL_account_deleteAccount.reason = "Decline ToS update";
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_deleteAccount, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$BA_vAxr4YCfyYKrHwgP-WTzgCOI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$1$TermsOfServiceView(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
        alertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$TermsOfServiceView(final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$FkzetGxVQK8PkxqOuz2AW8_ejWc
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$0$TermsOfServiceView(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$TermsOfServiceView(AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            MessagesController.getInstance(this.currentAccount).performLogout(0);
            return;
        }
        if (tLRPC$TL_error == null || tLRPC$TL_error.code != -1000) {
            String string = LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred);
            if (tLRPC$TL_error != null) {
                string = string + "\n" + tLRPC$TL_error.text;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(string);
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            builder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$TermsOfServiceView(View view) {
        if (this.currentTos.min_age_confirm != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle(LocaleController.getString("TosAgeTitle", R.string.TosAgeTitle));
            builder.setPositiveButton(LocaleController.getString("Agree", R.string.Agree), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$5UYUKNhGKLrq7fBURsa1C46NsCM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$5$TermsOfServiceView(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            builder.setMessage(LocaleController.formatString("TosAgeText", R.string.TosAgeText, LocaleController.formatPluralString("Years", this.currentTos.min_age_confirm)));
            builder.show();
            return;
        }
        accept();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$TermsOfServiceView(DialogInterface dialogInterface, int i) {
        accept();
    }

    private void accept() {
        this.delegate.onAcceptTerms(this.currentAccount);
        TLRPC$TL_help_acceptTermsOfService tLRPC$TL_help_acceptTermsOfService = new TLRPC$TL_help_acceptTermsOfService();
        tLRPC$TL_help_acceptTermsOfService.id = this.currentTos.id;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_help_acceptTermsOfService, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$TermsOfServiceView$SDta93uu7umRVnZw_uas6SaFfPk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                TermsOfServiceView.lambda$accept$7(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void show(int account, TLRPC$TL_help_termsOfService tos) {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tos.text);
        MessageObject.addEntitiesToText(spannableStringBuilder, tos.entities, false, false, false, false);
        addBulletsToText(spannableStringBuilder, '-', AndroidUtilities.dp(10.0f), -11491093, AndroidUtilities.dp(4.0f));
        this.textView.setText(spannableStringBuilder);
        this.currentTos = tos;
        this.currentAccount = account;
    }

    public void setDelegate(TermsOfServiceViewDelegate termsOfServiceViewDelegate) {
        this.delegate = termsOfServiceViewDelegate;
    }

    private static void addBulletsToText(SpannableStringBuilder builder, char bulletChar, int gapWidth, int color, int radius) {
        int length = builder.length() - 2;
        for (int i = 0; i < length; i++) {
            if (builder.charAt(i) == '\n') {
                int i2 = i + 1;
                if (builder.charAt(i2) == bulletChar) {
                    int i3 = i + 2;
                    if (builder.charAt(i3) == ' ') {
                        BulletSpan bulletSpan = new BulletSpan(gapWidth, color, radius);
                        builder.replace(i2, i + 3, "\u0000\u0000");
                        builder.setSpan(bulletSpan, i2, i3, 33);
                    }
                }
            }
        }
    }
}
