package ir.appp.wallet.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.appp.wallet.cell.bottomSheet.WalletCashOutBottomSheet;
import ir.appp.wallet.cell.bottomSheet.WalletCreditBottomSheet;
import ir.appp.wallet.cell.bottomSheet.WalletTransferBottomSheet;
import ir.appp.wallet.helper.ViewCreator;
import ir.appp.wallet.interfaces.WalletChargeListener;
import ir.appp.wallet.interfaces.WalletTransferListener;
import ir.appp.wallet.interfaces.WalletWithdrawListener;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: ViewCreator.kt */
/* loaded from: classes3.dex */
public final class ViewCreator {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ViewCreator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextView createTextView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            textView.setTypeface(Theme.getWalletTypeFaceRegular());
            textView.setTextSize(14.0f);
            return textView;
        }

        public final EditText createEditText(Context context, boolean z, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            final EditText editText = new EditText(context);
            editText.setTypeface(Theme.getWalletTypeFaceRegular());
            editText.setFilters(InputFilterHelper.getFilterMaxLine(1, editText));
            editText.setInputType(8192);
            editText.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            editText.setHintTextColor(Theme.getColor(Theme.key_dialogTextGray2));
            editText.setGravity(3);
            if (z) {
                editText.setHint(str);
                editText.setInputType(3);
                editText.addTextChangedListener(new TextWatcher() { // from class: ir.appp.wallet.helper.ViewCreator$Companion$createEditText$1$2
                    private String current = BuildConfig.FLAVOR;

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(s, "s");
                        if (Intrinsics.areEqual(s.toString(), this.current)) {
                            return;
                        }
                        editText.removeTextChangedListener(this);
                        String formattedString = NumberUtils.getPriceString(StringsKt__StringsJVMKt.replace$default(s.toString(), ",", BuildConfig.FLAVOR, false, 4, null));
                        Intrinsics.checkNotNullExpressionValue(formattedString, "formattedString");
                        this.current = formattedString;
                        editText.setText(formattedString);
                        editText.setSelection(formattedString.length());
                        editText.addTextChangedListener(this);
                    }
                });
            }
            return editText;
        }

        public final Drawable getDrawableWithColor(int i, Context context, int i2) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(context, "context");
            Drawable drawable = context.getResources().getDrawable(i);
            if (drawable instanceof ShapeDrawable) {
                ((ShapeDrawable) drawable).getPaint().setColor(i2);
            } else if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(i2);
            } else if (drawable instanceof ColorDrawable) {
                ((ColorDrawable) drawable).setColor(i2);
            }
            return drawable;
        }

        public final void initChargeBottomSheet(Context context, final int i, final WalletChargeListener chargeListener, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chargeListener, "chargeListener");
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialog);
            final WalletCreditBottomSheet walletCreditBottomSheet = new WalletCreditBottomSheet(context, i, str);
            walletCreditBottomSheet.getConfirmButtonTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.helper.ViewCreator$Companion$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewCreator.Companion.m430initChargeBottomSheet$lambda3(walletCreditBottomSheet, chargeListener, bottomSheetDialog, i, view);
                }
            });
            bottomSheetDialog.setContentView(walletCreditBottomSheet);
            bottomSheetDialog.getBehavior().setState(3);
            bottomSheetDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: initChargeBottomSheet$lambda-3, reason: not valid java name */
        public static final void m430initChargeBottomSheet$lambda3(WalletCreditBottomSheet contentView, WalletChargeListener chargeListener, BottomSheetDialog bottomSheet, int i, View view) {
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            Intrinsics.checkNotNullParameter(chargeListener, "$chargeListener");
            Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
            if (TextUtils.isEmpty(contentView.getInputEditText().getText())) {
                AndroidUtilities.shakeView(contentView.getInputEditText(), 2.0f, 0);
            } else {
                chargeListener.charge(bottomSheet, contentView.getInputEditText().getText().toString(), i);
            }
        }

        public final void initCashOutBottomSheet(Context context, final WalletWithdrawListener withdrawListener, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(withdrawListener, "withdrawListener");
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialog);
            final WalletCashOutBottomSheet walletCashOutBottomSheet = new WalletCashOutBottomSheet(context, str);
            walletCashOutBottomSheet.getConfirmButtonTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.helper.ViewCreator$Companion$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewCreator.Companion.m429initCashOutBottomSheet$lambda4(walletCashOutBottomSheet, withdrawListener, bottomSheetDialog, view);
                }
            });
            bottomSheetDialog.setContentView(walletCashOutBottomSheet);
            bottomSheetDialog.getBehavior().setState(3);
            bottomSheetDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: initCashOutBottomSheet$lambda-4, reason: not valid java name */
        public static final void m429initCashOutBottomSheet$lambda4(WalletCashOutBottomSheet contentView, WalletWithdrawListener withdrawListener, BottomSheetDialog bottomSheet, View view) {
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            Intrinsics.checkNotNullParameter(withdrawListener, "$withdrawListener");
            Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
            if (TextUtils.isEmpty(contentView.getInputEditText().getText())) {
                AndroidUtilities.shakeView(contentView.getInputEditText(), 2.0f, 0);
            } else {
                withdrawListener.withdraw(bottomSheet, contentView.getInputEditText().getText().toString());
            }
        }

        public final void initTransferBottomSheet(Context context, ChatAbsObject chatAbsObject, String str, final WalletTransferListener walletTransferListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(chatAbsObject, "chatAbsObject");
            Intrinsics.checkNotNullParameter(walletTransferListener, "walletTransferListener");
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialog);
            final WalletTransferBottomSheet walletTransferBottomSheet = new WalletTransferBottomSheet(context, chatAbsObject, str);
            walletTransferBottomSheet.getConfirmButtonTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.helper.ViewCreator$Companion$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewCreator.Companion.m431initTransferBottomSheet$lambda5(walletTransferBottomSheet, walletTransferListener, bottomSheetDialog, view);
                }
            });
            bottomSheetDialog.setContentView(walletTransferBottomSheet);
            bottomSheetDialog.getBehavior().setState(3);
            bottomSheetDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: initTransferBottomSheet$lambda-5, reason: not valid java name */
        public static final void m431initTransferBottomSheet$lambda5(WalletTransferBottomSheet contentView, WalletTransferListener walletTransferListener, BottomSheetDialog bottomSheet, View view) {
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            Intrinsics.checkNotNullParameter(walletTransferListener, "$walletTransferListener");
            Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
            if (TextUtils.isEmpty(contentView.getTransferAmountInputEditText().getText())) {
                AndroidUtilities.shakeView(contentView.getTransferAmountInputEditText(), 2.0f, 0);
                return;
            }
            String string = contentView.getTransferAmountInputEditText().getText().toString();
            Editable text = contentView.getDescriptionInputEditText().getText();
            walletTransferListener.transfer(bottomSheet, string, text == null ? null : text.toString());
        }
    }
}
