package ir.resaneh1.iptv.fragment.home.prediction;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.HomePageModels;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PredictionItemCell extends FrameLayout {
    private Context context;
    private final TextView gameStatusTextView;
    private final BaseFragment parentFragment;
    private HomePageModels.PredictionSectionItem predictionItem;
    private TextView resultTextView1;
    private TextView resultTextView2;
    private PredictionTeamItemCell teamCell1;
    private PredictionTeamItemCell teamCell2;

    public PredictionItemCell(Context context, BaseFragment baseFragment) {
        super(context);
        this.context = context;
        this.parentFragment = baseFragment;
        setBackground(context.getResources().getDrawable(R.drawable.home_bg_rectangle_gray_rounded_border));
        setPadding(16, 16, 16, 16);
        TextView textViewBuild = new CustomTextView.Builder(context).setText(BuildConfig.FLAVOR).removeBackgrounds().setTextColor(Theme.getColor(Theme.key_dialogTextBlack)).setGravity(17).build();
        this.gameStatusTextView = textViewBuild;
        addView(textViewBuild, LayoutHelper.createFrame(100, -1, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        addView(VisibilityHelper.createLine(context), LayoutHelper.createFrame(1, 80, 19, 100.0f, 0.0f, 0.0f, 0.0f));
        addView(createSoccerTeamLayout(context), LayoutHelper.createFrame(-1, -2, 5, 0.0f, 0.0f, 8.0f, 0.0f));
    }

    private LinearLayout createSoccerTeamLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(5);
        linearLayout.setOrientation(1);
        this.teamCell1 = new PredictionTeamItemCell(context);
        this.teamCell2 = new PredictionTeamItemCell(context);
        this.resultTextView1 = createResultTv(context);
        this.resultTextView2 = createResultTv(context);
        FrameLayout frameLayoutCreateTeamFrameLayoutLayout = createTeamFrameLayoutLayout(context, this.teamCell1, this.resultTextView1);
        FrameLayout frameLayoutCreateTeamFrameLayoutLayout2 = createTeamFrameLayoutLayout(context, this.teamCell2, this.resultTextView2);
        linearLayout.addView(frameLayoutCreateTeamFrameLayoutLayout, LayoutHelper.createLinear(-1, -2, 5, 0, 10, 0, 5));
        linearLayout.addView(frameLayoutCreateTeamFrameLayoutLayout2, LayoutHelper.createLinear(-1, -2, 5, 0, 5, 0, 10));
        return linearLayout;
    }

    private FrameLayout createTeamFrameLayoutLayout(Context context, PredictionTeamItemCell predictionTeamItemCell, TextView textView) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(predictionTeamItemCell, LayoutHelper.createFrame(-2, -2, 5, 0.0f, 0.0f, 0.0f, 0.0f));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2, 19, 108.0f, 0.0f, 0.0f, 0.0f));
        return frameLayout;
    }

    private TextView createResultTv(Context context) {
        return new CustomTextView.Builder(context).setText(BuildConfig.FLAVOR).removeBackgrounds().setGravity(19).build();
    }

    public void setData(HomePageModels.PredictionSectionItem predictionSectionItem) {
        resetData();
        if (dataIsValid(predictionSectionItem)) {
            VisibilityHelper.showViews(this);
            this.predictionItem = predictionSectionItem;
            setStatusData(predictionSectionItem);
            setTeamData(predictionSectionItem);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private void resetData() {
        this.predictionItem = null;
        this.gameStatusTextView.setText(BuildConfig.FLAVOR);
        this.resultTextView1.setText(BuildConfig.FLAVOR);
        this.resultTextView2.setText(BuildConfig.FLAVOR);
        this.teamCell1.resetData();
        this.teamCell2.resetData();
    }

    private boolean dataIsValid(HomePageModels.PredictionSectionItem predictionSectionItem) {
        return (predictionSectionItem == null || predictionSectionItem.team_1 == null || predictionSectionItem.team_2 == null) ? false : true;
    }

    private void setStatusData(HomePageModels.PredictionSectionItem predictionSectionItem) {
        try {
            if (isMatchEnded()) {
                this.gameStatusTextView.setText(LocaleController.getString("match_ended", R.string.match_ended));
            } else if (isMatchRunning()) {
                this.gameStatusTextView.setText(LocaleController.getString("match_running", R.string.match_running));
            } else {
                this.gameStatusTextView.setText(getPersianDate(predictionSectionItem.match_start_datetime));
            }
        } catch (NullPointerException e) {
            MyLog.e("PredictionItemCell", e.getLocalizedMessage());
            this.gameStatusTextView.setText(getPersianDate(predictionSectionItem.match_start_datetime));
        }
    }

    private String getPersianDate(long j) {
        long j2 = j * 1000;
        return NumberUtils.toPersian(DateFormatUtils.getPersianDayOfMonth(j2)) + " " + DateFormatUtils.getMonthKeyPersian(j2);
    }

    private void setTeamData(HomePageModels.PredictionSectionItem predictionSectionItem) {
        this.teamCell1.setData(predictionSectionItem.team_1);
        this.teamCell2.setData(predictionSectionItem.team_2);
        setResultData(this.resultTextView1, predictionSectionItem.result_team_1);
        setResultData(this.resultTextView2, predictionSectionItem.result_team_2);
    }

    private void setResultData(TextView textView, String str) {
        if (str == null) {
            textView.setText(BuildConfig.FLAVOR);
        } else if (isResultValid(str)) {
            textView.setText(NumberUtils.toPersian(str));
        } else {
            textView.setText("-");
        }
    }

    private boolean isResultValid(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    public void onClick() {
        if (isValidForPrediction()) {
            showButtonSheet();
        } else {
            ToastiLikeSnack.showL(this.context, LocaleController.getString(R.string.PredictionEnded));
        }
    }

    private boolean isValidForPrediction() {
        return this.predictionItem.is_prediction_allowed;
    }

    private boolean isMatchEnded() {
        return this.predictionItem.state == HomePageModels.PredictionItemEnum.Finished;
    }

    private boolean isMatchRunning() {
        return this.predictionItem.state == HomePageModels.PredictionItemEnum.Ongoing;
    }

    private void showButtonSheet() {
        if (this.parentFragment == null || this.predictionItem == null) {
            return;
        }
        final PredictionItemCellBottomSheet predictionItemCellBottomSheet = new PredictionItemCellBottomSheet(getContext(), this.predictionItem);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialog);
        bottomSheetDialog.setContentView(predictionItemCellBottomSheet);
        new BottomSheetBehavior();
        final BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) predictionItemCellBottomSheet.getParent());
        bottomSheetBehaviorFrom.setState(3);
        predictionItemCellBottomSheet.getSubmitFl().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.prediction.PredictionItemCell$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PredictionItemCell.lambda$showButtonSheet$0(predictionItemCellBottomSheet, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.resaneh1.iptv.fragment.home.prediction.PredictionItemCell$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PredictionItemCell.lambda$showButtonSheet$1(bottomSheetBehaviorFrom, predictionItemCellBottomSheet, dialogInterface);
            }
        });
        predictionItemCellBottomSheet.getCloseIv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.prediction.PredictionItemCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        this.parentFragment.showDialog(bottomSheetDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showButtonSheet$0(PredictionItemCellBottomSheet predictionItemCellBottomSheet, BottomSheetDialog bottomSheetDialog, View view) {
        if (predictionItemCellBottomSheet.updateData()) {
            bottomSheetDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showButtonSheet$1(BottomSheetBehavior bottomSheetBehavior, PredictionItemCellBottomSheet predictionItemCellBottomSheet, DialogInterface dialogInterface) {
        bottomSheetBehavior.setPeekHeight(predictionItemCellBottomSheet.getHeight());
    }
}
