package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.WebFile;
import org.rbmain.tgnet.TLRPC$TL_messageMediaInvoice;
import org.rbmain.tgnet.TLRPC$TL_payments_paymentReceipt;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class PaymentInfoCell extends FrameLayout {
    private TextView detailExTextView;
    private TextView detailTextView;
    private BackupImageView imageView;
    private TextView nameTextView;

    public PaymentInfoCell(Context context) {
        super(context);
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        addView(backupImageView, LayoutHelper.createFrame(100, 100.0f, LocaleController.isRTL ? 5 : 3, 10.0f, 10.0f, 10.0f, 0.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        int i = Theme.key_windowBackgroundWhiteBlackText;
        textView.setTextColor(Theme.getColor(i));
        this.nameTextView.setTextSize(1, 16.0f);
        this.nameTextView.setLines(1);
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view = this.nameTextView;
        boolean z = LocaleController.isRTL;
        addView(view, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 10.0f : 123.0f, 9.0f, z ? 123.0f : 10.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.detailTextView = textView2;
        textView2.setTextColor(Theme.getColor(i));
        this.detailTextView.setTextSize(1, 14.0f);
        this.detailTextView.setMaxLines(3);
        this.detailTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.detailTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view2 = this.detailTextView;
        boolean z2 = LocaleController.isRTL;
        addView(view2, LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 10.0f : 123.0f, 33.0f, z2 ? 123.0f : 10.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.detailExTextView = textView3;
        textView3.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
        this.detailExTextView.setTextSize(1, 14.0f);
        this.detailExTextView.setLines(1);
        this.detailExTextView.setMaxLines(1);
        this.detailExTextView.setSingleLine(true);
        this.detailExTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.detailExTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view3 = this.detailExTextView;
        boolean z3 = LocaleController.isRTL;
        addView(view3, LayoutHelper.createFrame(-1, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 10.0f : 123.0f, 90.0f, z3 ? 123.0f : 10.0f, 9.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        if (this.imageView.getVisibility() != 8) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(120.0f), 1073741824);
        } else {
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            measureChildWithMargins(this.detailTextView, i, 0, i2, 0);
            ((FrameLayout.LayoutParams) this.detailExTextView.getLayoutParams()).topMargin = AndroidUtilities.dp(33.0f) + this.detailTextView.getMeasuredHeight() + AndroidUtilities.dp(3.0f);
            iMakeMeasureSpec = iMakeMeasureSpec2;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), iMakeMeasureSpec);
    }

    public void setInvoice(TLRPC$TL_messageMediaInvoice tLRPC$TL_messageMediaInvoice, String str) {
        int iMin;
        this.nameTextView.setText(tLRPC$TL_messageMediaInvoice.title);
        this.detailTextView.setText(tLRPC$TL_messageMediaInvoice.description);
        this.detailExTextView.setText(str);
        if (AndroidUtilities.isTablet()) {
            iMin = AndroidUtilities.getMinTabletSide();
        } else {
            Point point = AndroidUtilities.displaySize;
            iMin = Math.min(point.x, point.y);
        }
        float f = 640;
        float fDp = f / (((int) (iMin * 0.7f)) - AndroidUtilities.dp(2.0f));
        int i = (int) (f / fDp);
        int i2 = (int) (360 / fDp);
        TLRPC$WebDocument tLRPC$WebDocument = tLRPC$TL_messageMediaInvoice.webPhoto;
        if (tLRPC$WebDocument != null && tLRPC$WebDocument.mime_type.startsWith("image/")) {
            TextView textView = this.nameTextView;
            boolean z = LocaleController.isRTL;
            textView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 10.0f : 123.0f, 9.0f, z ? 123.0f : 10.0f, 0.0f));
            TextView textView2 = this.detailTextView;
            boolean z2 = LocaleController.isRTL;
            textView2.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 10.0f : 123.0f, 33.0f, z2 ? 123.0f : 10.0f, 0.0f));
            TextView textView3 = this.detailExTextView;
            boolean z3 = LocaleController.isRTL;
            textView3.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 10.0f : 123.0f, 90.0f, z3 ? 123.0f : 10.0f, 0.0f));
            this.imageView.setVisibility(0);
            this.imageView.getImageReceiver().setImage(ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$TL_messageMediaInvoice.webPhoto)), String.format(Locale.US, "%d_%d", Integer.valueOf(i), Integer.valueOf(i2)), null, null, -1L, null, tLRPC$TL_messageMediaInvoice, 1);
            return;
        }
        this.nameTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 17.0f, 9.0f, 17.0f, 0.0f));
        this.detailTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 17.0f, 33.0f, 17.0f, 0.0f));
        this.detailExTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 17.0f, 90.0f, 17.0f, 9.0f));
        this.imageView.setVisibility(8);
    }

    public void setReceipt(TLRPC$TL_payments_paymentReceipt tLRPC$TL_payments_paymentReceipt, String str) {
        int iMin;
        this.nameTextView.setText(tLRPC$TL_payments_paymentReceipt.title);
        this.detailTextView.setText(tLRPC$TL_payments_paymentReceipt.description);
        this.detailExTextView.setText(str);
        if (AndroidUtilities.isTablet()) {
            iMin = AndroidUtilities.getMinTabletSide();
        } else {
            Point point = AndroidUtilities.displaySize;
            iMin = Math.min(point.x, point.y);
        }
        float f = 640;
        float fDp = f / (((int) (iMin * 0.7f)) - AndroidUtilities.dp(2.0f));
        int i = (int) (f / fDp);
        int i2 = (int) (360 / fDp);
        TLRPC$WebDocument tLRPC$WebDocument = tLRPC$TL_payments_paymentReceipt.photo;
        if (tLRPC$WebDocument != null && tLRPC$WebDocument.mime_type.startsWith("image/")) {
            TextView textView = this.nameTextView;
            boolean z = LocaleController.isRTL;
            textView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 10.0f : 123.0f, 9.0f, z ? 123.0f : 10.0f, 0.0f));
            TextView textView2 = this.detailTextView;
            boolean z2 = LocaleController.isRTL;
            textView2.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 10.0f : 123.0f, 33.0f, z2 ? 123.0f : 10.0f, 0.0f));
            TextView textView3 = this.detailExTextView;
            boolean z3 = LocaleController.isRTL;
            textView3.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 10.0f : 123.0f, 90.0f, z3 ? 123.0f : 10.0f, 0.0f));
            this.imageView.setVisibility(0);
            this.imageView.getImageReceiver().setImage(ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$TL_payments_paymentReceipt.photo)), String.format(Locale.US, "%d_%d", Integer.valueOf(i), Integer.valueOf(i2)), null, null, -1L, null, tLRPC$TL_payments_paymentReceipt, 1);
            return;
        }
        this.nameTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 17.0f, 9.0f, 17.0f, 0.0f));
        this.detailTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 17.0f, 33.0f, 17.0f, 0.0f));
        this.detailExTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 17.0f, 90.0f, 17.0f, 9.0f));
        this.imageView.setVisibility(8);
    }
}
