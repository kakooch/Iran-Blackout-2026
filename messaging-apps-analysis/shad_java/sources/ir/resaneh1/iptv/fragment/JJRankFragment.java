package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIJJRankTable;
import ir.resaneh1.iptv.UIRowCardView;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.model.JJApiInput;
import ir.resaneh1.iptv.model.JJGetRankOutput;
import ir.resaneh1.iptv.model.JJRankObject;
import ir.resaneh1.iptv.model.PredictLinkObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJRankFragment extends PresenterFragment {
    public PredictLinkObject predictLinkObject;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public JJRankFragment(PredictLinkObject predictLinkObject) {
        this.predictLinkObject = predictLinkObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        this.progressBar.setVisibility(4);
        callGetRank();
    }

    private void callGetRank() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJRank(new JJApiInput(this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJRankFragment.1
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJRankFragment.this.progressBar.setVisibility(4);
                JJRankFragment.this.notFoundLayout.setVisibility(4);
                if (response.body() != null) {
                    JJRankFragment.this.makeLayout(((JJGetRankOutput) response.body()).result);
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJRankFragment.this.progressBar.setVisibility(4);
                JJRankFragment.this.notFoundLayout.setVisibility(4);
                JJRankFragment.this.showRetryLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout(JJGetRankOutput.Result result) {
        ArrayList<JJRankObject> arrayList;
        this.linearLayout.removeAllViews();
        ArrayList<JJRankObject> arrayList2 = result.myRanks;
        if ((arrayList2 != null && arrayList2.size() > 0) || ((arrayList = result.topRanks) != null && arrayList.size() > 0)) {
            ArrayList<JJRankObject> arrayList3 = result.topRanks;
            if (arrayList3 != null && arrayList3.size() > 0) {
                this.linearLayout.addView(View.inflate(this.mContext, R.layout.row_space, null));
                UIRowCardView uIRowCardView = new UIRowCardView();
                uIRowCardView.createView((Activity) this.mContext);
                UIJJRankTable uIJJRankTable = new UIJJRankTable();
                Collections.sort(result.topRanks, new RankComparator(this));
                uIJJRankTable.createView((Activity) this.mContext, "برترین", result.topRanks);
                uIRowCardView.linearLayout.addView(uIJJRankTable.view);
                this.linearLayout.addView(uIRowCardView.view);
            }
            ArrayList<JJRankObject> arrayList4 = result.myRanks;
            if (arrayList4 == null || arrayList4.size() <= 0) {
                return;
            }
            this.linearLayout.addView(View.inflate(this.mContext, R.layout.row_space, null));
            UIRowCardView uIRowCardView2 = new UIRowCardView();
            uIRowCardView2.createView((Activity) this.mContext);
            UIJJRankTable uIJJRankTable2 = new UIJJRankTable();
            Collections.sort(result.myRanks, new RankComparator(this));
            uIJJRankTable2.createView((Activity) this.mContext, "رتبه من", result.myRanks);
            uIRowCardView2.linearLayout.addView(uIJJRankTable2.view);
            this.linearLayout.addView(uIRowCardView2.view);
            return;
        }
        setNotFoundLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void setNotFoundLayout() {
        ImageView imageView = (ImageView) this.notFoundLayout.findViewById(R.id.imageView);
        TextView textView = (TextView) this.notFoundLayout.findViewById(R.id.textView);
        imageView.setImageResource(R.drawable.ic_jj_rank);
        textView.setText("هیچ کدام از شرکت کنندگان \nهنوز امتیازی کسب نکرده اند.");
        textView.setTextColor(-14606047);
        this.notFoundLayout.setVisibility(0);
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "برترین شرکت کنندگان");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        callGetRank();
    }

    public class RankComparator implements Comparator<JJRankObject> {
        public RankComparator(JJRankFragment jJRankFragment) {
        }

        @Override // java.util.Comparator
        public int compare(JJRankObject jJRankObject, JJRankObject jJRankObject2) {
            int i = jJRankObject.rank;
            int i2 = jJRankObject2.rank;
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 0 : -1;
        }
    }
}
