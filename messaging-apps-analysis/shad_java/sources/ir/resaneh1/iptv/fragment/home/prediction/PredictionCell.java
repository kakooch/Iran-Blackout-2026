package ir.resaneh1.iptv.fragment.home.prediction;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class PredictionCell extends HomeCell {
    private PredictionAdapter adapter;
    private RecyclerListView listView;
    private CardView outerCard;
    private BaseFragment parentFragment;

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        initListView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(createOuterCardView(context), LayoutHelper.createFrame(-1, 80, 48, 0.0f, 0.0f, 0.0f, 12.0f));
        frameLayout.addView(createMainCardView(context), LayoutHelper.createFrame(-1, -2, 48, 0.0f, 40.0f, 0.0f, 0.0f));
        return frameLayout;
    }

    public PredictionCell(Context context, BaseFragment baseFragment) {
        super(context);
        this.parentFragment = baseFragment;
    }

    private CardView createMainCardView(Context context) {
        CardView cardView = new CardView(context);
        cardView.setRadius(AndroidUtilities.dp(8.0f));
        cardView.setCardElevation(0.0f);
        cardView.setCardBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        cardView.addView(createMainLl(context), LayoutHelper.createFrame(-1, -2, 17, 16.0f, 16.0f, 16.0f, 16.0f));
        return cardView;
    }

    private LinearLayout createMainLl(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(this.listView, LayoutHelper.createLinear(-1, -2, 48, 0, 0, 0, 0));
        return linearLayout;
    }

    private CardView createOuterCardView(Context context) {
        CardView cardView = new CardView(context);
        this.outerCard = cardView;
        cardView.setCardBackgroundColor(context.getResources().getColor(R.color.svc_indicator_selected));
        this.outerCard.setCardElevation(0.0f);
        this.outerCard.addView(getBannerTextView(context), LayoutHelper.createFrame(-1, 40, 48));
        return this.outerCard;
    }

    private TextView getBannerTextView(Context context) {
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("prediction_banner", R.string.prediction_banner));
        textView.setGravity(16);
        textView.setTypeface(Theme.getHomePageTypeFaceRegular());
        textView.setPadding(16, 8, 32, 8);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        return textView;
    }

    private void initListView(Context context) {
        this.listView = new RecyclerListView(context);
        PredictionAdapter predictionAdapter = new PredictionAdapter(context, this.parentFragment);
        this.adapter = predictionAdapter;
        this.listView.setAdapter(predictionAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.home.prediction.PredictionCell$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                PredictionCell.lambda$initListView$0(view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initListView$0(View view, int i) {
        if (view instanceof PredictionItemCell) {
            ((PredictionItemCell) view).onClick();
        }
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.BorderInfoObject borderInfoObject;
        resetData();
        if (isValidData(homePageSectionObject)) {
            VisibilityHelper.showViews(this);
            this.adapter.setPredictions(homePageSectionObject.prediction_section.prediction_items_list);
            setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
            HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
            if (commonSectionDataObject != null && (borderInfoObject = commonSectionDataObject.border_info) != null) {
                this.outerCard.setRadius(AndroidUtilities.dp(borderInfoObject.radius * 100.0f));
                return;
            } else {
                this.outerCard.setRadius(AndroidUtilities.dp(8.0f));
                return;
            }
        }
        VisibilityHelper.hideViews(this);
    }

    private void resetData() {
        this.adapter.setPredictions(null);
    }

    private boolean isValidData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.PredictionSectionObject predictionSectionObject;
        ArrayList<HomePageModels.PredictionSectionItem> arrayList;
        return (homePageSectionObject == null || (predictionSectionObject = homePageSectionObject.prediction_section) == null || (arrayList = predictionSectionObject.prediction_items_list) == null || arrayList.isEmpty()) ? false : true;
    }
}
