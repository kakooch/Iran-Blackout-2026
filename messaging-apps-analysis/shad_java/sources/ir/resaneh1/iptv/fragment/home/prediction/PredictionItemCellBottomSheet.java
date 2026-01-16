package ir.resaneh1.iptv.fragment.home.prediction;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.DrawableHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PredictionItemCellBottomSheet extends LinearLayout {
    private ImageView closeIv;
    private Context context;
    private final HomePageModels.PredictionSectionItem predictionItem;
    private FrameLayout submitBtnFl;
    private String temp_prediction_1;
    private String temp_prediction_2;

    PredictionItemCellBottomSheet(Context context, HomePageModels.PredictionSectionItem predictionSectionItem) {
        super(context);
        this.context = context;
        this.predictionItem = predictionSectionItem;
        this.temp_prediction_1 = predictionSectionItem.user_prediction_team_1;
        this.temp_prediction_2 = predictionSectionItem.user_prediction_team_2;
        setOrientation(1);
        setBackground(DrawableHelper.getDrawableWithColor(R.drawable.home_custom_bottom_sheet, context, Theme.getColor(Theme.key_windowBackgroundWhite)));
        setPadding(16, 16, 16, 16);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(initHeaderView(), LayoutHelper.createLinear(-1, -2, 0, 16, 16, 16, 16));
        linearLayout.addView(initContentView(), LayoutHelper.createLinear(-1, -1, 17, 0, 0, 0, 0));
        linearLayout.addView(initSubmitButton(), LayoutHelper.createLinear(-1, -2, 17, 16, 0, 16, 32));
        scrollView.addView(linearLayout);
        addView(scrollView, LayoutHelper.createLinear(-1, -2));
    }

    private FrameLayout initHeaderView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        this.closeIv = imageView;
        imageView.setPadding(16, 16, 16, 16);
        this.closeIv.setImageDrawable(DrawableHelper.getDrawableVector(R.drawable.home_ic_close_bottom_sheet, getContext(), Theme.getColor(Theme.key_dialogTextBlack)));
        frameLayout.addView(this.closeIv, LayoutHelper.createFrame(-2, -2, 19));
        frameLayout.addView(initHeaderTextImage(), LayoutHelper.createFrame(-2, -2, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        return frameLayout;
    }

    private FrameLayout initHeaderTextImage() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(initHeaderText(), LayoutHelper.createFrame(-2, -2, 3, 0.0f, 0.0f, 48.0f, 0.0f));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.home_ic_bottom_sheet));
        frameLayout.addView(imageView, LayoutHelper.createFrame(40, 40, 5, 8.0f, 0.0f, 0.0f, 0.0f));
        return frameLayout;
    }

    private LinearLayout initHeaderText() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        CustomTextView.Builder textSize = new CustomTextView.Builder(getContext()).setText(LocaleController.getString(R.string.socor_prediction)).setTextSize(12);
        int i = Theme.key_dialogTextBlack;
        TextView textViewBuild = textSize.setTextColor(Theme.getColor(i)).isBold(true).removeBackgrounds().build();
        TextView textViewBuild2 = new CustomTextView.Builder(getContext()).setText(getPersianDate()).setTextSize(10).setTextColor(Theme.getColor(i)).removeBackgrounds().build();
        linearLayout.addView(textViewBuild, LayoutHelper.createLinear(-2, -2, 48));
        linearLayout.addView(textViewBuild2, LayoutHelper.createLinear(-2, -2, 85));
        return linearLayout;
    }

    private String getPersianDate() {
        return NumberUtils.toPersian(DateFormatUtils.getMonthPersian(this.predictionItem.match_start_datetime * 1000)) + " " + DateFormatUtils.getMonthKeyPersian(this.predictionItem.match_start_datetime * 1000);
    }

    private LinearLayout initContentView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.addView(initContentItemView(this.predictionItem.team_1, 1), LayoutHelper.createLinear(-2, -2, 1, 16, 0, 16, 32));
        linearLayout.addView(initContentItemView(this.predictionItem.team_2, 2), LayoutHelper.createLinear(-2, -2, 1, 16, 0, 16, 32));
        return linearLayout;
    }

    private LinearLayout initContentItemView(HomePageModels.PredictionSectionTeam predictionSectionTeam, int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        TextView textViewBuild = new CustomTextView.Builder(getContext()).setText(predictionSectionTeam.name).isBold(true).setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).removeBackgrounds().setTextSize(12).build();
        linearLayout.addView(initTeamLogoView(predictionSectionTeam), LayoutHelper.createLinear(-2, -2, 1, 0, 0, 0, 8));
        linearLayout.addView(textViewBuild, LayoutHelper.createLinear(-2, -2, 1, 0, 0, 0, 16));
        linearLayout.addView(initTeamPredictionSectionView(i), LayoutHelper.createLinear(-1, -2, 17));
        return linearLayout;
    }

    private FrameLayout initTeamLogoView(HomePageModels.PredictionSectionTeam predictionSectionTeam) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackground(DrawableHelper.getDrawableWithColor(R.drawable.home_ic_shop_bottom_sheet_background_team, getContext(), Theme.getColor(Theme.key_windowBackgroundGray)));
        ImageView imageView = new ImageView(getContext());
        GlideHelper.load(getContext(), imageView, predictionSectionTeam.image_url, R.drawable.home_team_placeholder);
        frameLayout.addView(imageView, LayoutHelper.createFrame(40, 40, 17));
        return frameLayout;
    }

    private FrameLayout initTeamPredictionSectionView(final int i) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        Context context = getContext();
        int i2 = Theme.key_dialogTextBlack;
        frameLayout.setBackground(DrawableHelper.getDrawableStroke(R.drawable.home_bg_rectangle_gray_rounded_border, context, Theme.getColor(i2)));
        EditText editTextInitPredictionEt = initPredictionEt();
        editTextInitPredictionEt.setTextColor(Theme.getColor(i2));
        initEditTextValue(i, editTextInitPredictionEt);
        editTextInitPredictionEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
        editTextInitPredictionEt.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.home.prediction.PredictionItemCellBottomSheet.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PredictionItemCellBottomSheet.this.setTempPrediction(editable.toString(), i);
            }
        });
        frameLayout.addView(editTextInitPredictionEt, LayoutHelper.createFrame(-1, -1, 17));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTempPrediction(String str, int i) {
        if (i == 1) {
            this.temp_prediction_1 = str;
        } else {
            this.temp_prediction_2 = str;
        }
    }

    private void initEditTextValue(int i, EditText editText) {
        if (i == 1) {
            String str = this.predictionItem.user_prediction_team_1;
            if (str == null || str.isEmpty()) {
                return;
            }
            editText.setText(this.predictionItem.user_prediction_team_1);
            return;
        }
        String str2 = this.predictionItem.user_prediction_team_2;
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        editText.setText(this.predictionItem.user_prediction_team_2);
    }

    private EditText initPredictionEt() {
        EditText editText = new EditText(getContext());
        editText.setBackground(null);
        editText.setGravity(17);
        editText.setInputType(2);
        editText.setMaxLines(1);
        editText.setCompoundDrawablePadding(0);
        return editText;
    }

    private FrameLayout initSubmitButton() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.submitBtnFl = frameLayout;
        frameLayout.setBackground(DrawableHelper.getDrawableWithColor(R.drawable.home_bg_rectangle_light_grey_rounded, getContext(), Theme.getColor(Theme.key_dialogTextBlack)));
        TextView textViewBuild = new CustomTextView.Builder(getContext()).setText(LocaleController.getString(R.string.submit_prediction)).setTextSize(16).setTextColor(Theme.getColor(Theme.key_windowBackgroundGray)).removeBackgrounds().build();
        textViewBuild.setClickable(false);
        this.submitBtnFl.addView(textViewBuild, LayoutHelper.createFrame(-2, -2, 17, 0.0f, 16.0f, 0.0f, 16.0f));
        return this.submitBtnFl;
    }

    public FrameLayout getSubmitFl() {
        return this.submitBtnFl;
    }

    public ImageView getCloseIv() {
        return this.closeIv;
    }

    public boolean updateData() {
        if (inputIsValid()) {
            HomePageModels.PredictionSectionItem predictionSectionItem = this.predictionItem;
            predictionSectionItem.user_prediction_team_1 = this.temp_prediction_1;
            predictionSectionItem.user_prediction_team_2 = this.temp_prediction_2;
            sendPrediction();
            return true;
        }
        ToastiLikeSnack.showL(this.context, LocaleController.getString(R.string.invalidPrediction));
        return false;
    }

    private void sendPrediction() {
    }

    private HomePageModels.UserPredictionsInput getApiInputData() {
        HomePageModels.InputPredictionObject inputPredictionObject = new HomePageModels.InputPredictionObject();
        HomePageModels.PredictionSectionItem predictionSectionItem = this.predictionItem;
        inputPredictionObject.prediction_team_1 = predictionSectionItem.user_prediction_team_1;
        inputPredictionObject.prediction_team_2 = predictionSectionItem.user_prediction_team_2;
        inputPredictionObject.section_item_id = predictionSectionItem.id;
        ArrayList<HomePageModels.InputPredictionObject> arrayList = new ArrayList<>();
        arrayList.add(inputPredictionObject);
        HomePageModels.UserPredictionsInput userPredictionsInput = new HomePageModels.UserPredictionsInput();
        userPredictionsInput.predictions_list = arrayList;
        return userPredictionsInput;
    }

    private boolean inputIsValid() {
        String str = this.temp_prediction_1;
        if (str == null || this.temp_prediction_2 == null || str.isEmpty() || this.temp_prediction_2.isEmpty() || (this.temp_prediction_1.startsWith("0") && this.temp_prediction_1.length() > 1)) {
            return false;
        }
        return (!this.temp_prediction_2.startsWith("0") || this.temp_prediction_2.length() <= 1) && this.temp_prediction_1.length() <= 2 && this.temp_prediction_2.length() <= 2;
    }
}
