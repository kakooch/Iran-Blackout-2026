package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ShopModels;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class PersonalDetailBottomSheet extends BottomSheet {
    private final EditText addressEditText;
    private int currentAccount;
    private PersonalDetailDelegate delegate;
    private final ShopModels.PersonalDetail detail;
    private final EditText nameEditText;
    private final EditText phoneEditText;
    private final EditText postalEditText;

    public interface PersonalDetailDelegate {
        void onDone(ShopModels.PersonalDetail personalDetail);
    }

    public void setDelegate(PersonalDetailDelegate personalDetailDelegate) {
        this.delegate = personalDetailDelegate;
    }

    public PersonalDetailBottomSheet(final Context context, int i) {
        super(context, true);
        this.currentAccount = i;
        ShopModels.PersonalDetail json = ShopModels.PersonalDetail.parseJson(AppRubinoPreferences.getInstance(i).getString(AppRubinoPreferences.Key.shopPersonalInfo));
        this.detail = json;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textViewCreateShopTextView = ViewHelper.createShopTextView(context, 18, -16777216, true);
        textViewCreateShopTextView.setText(LocaleController.getString(R.string.shopInfo));
        linearLayout.addView(textViewCreateShopTextView, LayoutHelper.createLinear(-2, -2, 17));
        linearLayout.addView(createTextView(context, LocaleController.getString(R.string.shop_name)), LayoutHelper.createLinear(-2, -2, 5, 16, 4, 16, 0));
        EditText editTextCreateEditText = createEditText(context);
        this.nameEditText = editTextCreateEditText;
        if (json != null) {
            editTextCreateEditText.setText(json.name);
        }
        linearLayout.addView(editTextCreateEditText, LayoutHelper.createLinear(-1, 48, 5, 16, 4, 16, 0));
        linearLayout.addView(createTextView(context, LocaleController.getString(R.string.shop_phone)), LayoutHelper.createLinear(-2, -2, 5, 16, 16, 16, 0));
        EditText editTextCreateEditText2 = createEditText(context);
        this.phoneEditText = editTextCreateEditText2;
        editTextCreateEditText2.setInputType(3);
        if (json != null) {
            editTextCreateEditText2.setText(json.phone);
        }
        editTextCreateEditText2.setHint(LocaleController.getString(R.string.shop_sample_phone));
        linearLayout.addView(editTextCreateEditText2, LayoutHelper.createLinear(-1, 48, 5, 16, 4, 16, 0));
        linearLayout.addView(createTextView(context, LocaleController.getString(R.string.shop_address)), LayoutHelper.createLinear(-2, -2, 5, 16, 16, 16, 0));
        EditText editTextCreateEditText3 = createEditText(context);
        this.addressEditText = editTextCreateEditText3;
        if (json != null) {
            editTextCreateEditText3.setText(json.address);
        }
        linearLayout.addView(editTextCreateEditText3, LayoutHelper.createLinear(-1, 48, 5, 16, 4, 16, 0));
        linearLayout.addView(createTextView(context, LocaleController.getString(R.string.shop_postal_code)), LayoutHelper.createLinear(-2, -2, 5, 16, 16, 16, 0));
        EditText editTextCreateEditText4 = createEditText(context, true);
        this.postalEditText = editTextCreateEditText4;
        editTextCreateEditText4.setInputType(8194);
        if (json != null) {
            editTextCreateEditText4.setText(json.postalCode);
        }
        linearLayout.addView(editTextCreateEditText4, LayoutHelper.createLinear(-1, 48, 5, 16, 4, 16, 0));
        TextView textViewCreateShopTextView2 = ViewHelper.createShopTextView(context, 14, -1, false);
        textViewCreateShopTextView2.setGravity(17);
        textViewCreateShopTextView2.setBackground(ContextCompat.getDrawable(context, R.drawable.shop_blue_rectangle_corner));
        textViewCreateShopTextView2.setText(LocaleController.getString(R.string.SendMessageShop));
        linearLayout.addView(textViewCreateShopTextView2, LayoutHelper.createLinear(-1, 48, 5, 16, 24, 16, 0));
        textViewCreateShopTextView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.PersonalDetailBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(context, view);
            }
        });
        setCustomView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Context context, View view) {
        if (this.delegate == null) {
            return;
        }
        if (!validateInputs()) {
            ToastiLikeSnack.showS(context, LocaleController.getString(R.string.shop_fill_fields));
            return;
        }
        ShopModels.PersonalDetail personalDetail = new ShopModels.PersonalDetail();
        personalDetail.name = String.valueOf(this.nameEditText.getText());
        personalDetail.address = String.valueOf(this.addressEditText.getText());
        personalDetail.postalCode = String.valueOf(this.postalEditText.getText());
        personalDetail.phone = String.valueOf(this.phoneEditText.getText());
        AppRubinoPreferences.getInstance(this.currentAccount).setString(AppRubinoPreferences.Key.shopPersonalInfo, personalDetail.getJsonString());
        this.delegate.onDone(personalDetail);
        dismiss();
    }

    private boolean validateInputs() {
        return (TextUtils.isEmpty(String.valueOf(this.nameEditText.getText())) || TextUtils.isEmpty(String.valueOf(this.phoneEditText.getText())) || TextUtils.isEmpty(String.valueOf(this.addressEditText.getText())) || TextUtils.isEmpty(String.valueOf(this.postalEditText.getText()))) ? false : true;
    }

    private EditText createEditText(Context context) {
        return createEditText(context, false);
    }

    private EditText createEditText(Context context, boolean z) {
        EditText editText = new EditText(context);
        editText.setTypeface(Theme.getRubinoTypeFaceRegular());
        editText.setBackground(ContextCompat.getDrawable(context, R.drawable.shop_rectangle_border_grey));
        editText.setFocusableInTouchMode(true);
        editText.setHint(LocaleController.getString(R.string.shop_enter));
        if (!z) {
            editText.setImeOptions(5);
        } else {
            editText.setImeOptions(6);
        }
        editText.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
        editText.setTextColor(Color.parseColor("#858585"));
        return editText;
    }

    private TextView createTextView(Context context, String str) {
        TextView textViewCreateShopTextView = ViewHelper.createShopTextView(context, 16, -16777216, false);
        textViewCreateShopTextView.setText(str);
        return textViewCreateShopTextView;
    }
}
