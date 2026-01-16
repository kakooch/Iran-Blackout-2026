package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIJJMatchPredRow;
import ir.resaneh1.iptv.UIJJMatchStatisticsCell;
import ir.resaneh1.iptv.UIJJMatchVenueRow;
import ir.resaneh1.iptv.UIMatchPointRow;
import ir.resaneh1.iptv.UIRowCardView;
import ir.resaneh1.iptv.UIThreeLinearRow;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJGetMatchDetailsInput;
import ir.resaneh1.iptv.model.JJGetMatchDetailsOutput;
import ir.resaneh1.iptv.model.JJMatchObject;
import ir.resaneh1.iptv.model.PredictLinkObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenters.JJMatchRowPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJMatchDetailFragment extends PresenterFragment {
    public JJMatchObject match;
    ToolbarImageView toolbarImageViewShare;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public JJMatchDetailFragment(JJMatchObject jJMatchObject) {
        this.match = jJMatchObject;
    }

    public JJMatchDetailFragment(PredictLinkObject predictLinkObject) throws NumberFormatException {
        int i;
        this.match = new JJMatchObject();
        try {
            i = Integer.parseInt(predictLinkObject.match_id);
        } catch (Exception unused) {
            i = 0;
        }
        this.match.id = i;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        this.swipeBackEnabled = true;
        this.linearLayout.getLayoutParams().width = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        callUpdateList();
    }

    private void callUpdateList() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJMatchAndTeamUpdate(new JJGetMatchAndTeamListInput(Long.valueOf(JJAppPreferences.getInstance().getLong(JJAppPreferences.Key.jjTimestamp + JJAppPreferences.currentPredictLink.id, 0L)), JJAppPreferences.currentPredictLink.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMatchDetailFragment.1
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJMatchDetailFragment.this.progressBar.setVisibility(4);
                if (response.body() != null) {
                    JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput = (JJGetMatchAndTeamListOutput) response.body();
                    JJAppPreferences.getInstance().setOrUpdateMatchAndTeamList(jJGetMatchAndTeamListOutput);
                    JJAppPreferences.getInstance().setLong(JJAppPreferences.Key.jjTimestamp + JJAppPreferences.currentPredictLink.id, jJGetMatchAndTeamListOutput.result.timestamp.longValue());
                    Iterator<JJMatchObject> it = JJAppPreferences.getInstance().getMatchAndTeam().result.matchUpdates.iterator();
                    while (it.hasNext()) {
                        JJMatchObject next = it.next();
                        int i = next.id;
                        JJMatchDetailFragment jJMatchDetailFragment = JJMatchDetailFragment.this;
                        if (i == jJMatchDetailFragment.match.id) {
                            jJMatchDetailFragment.match = next;
                        }
                    }
                    JJMatchDetailFragment.this.callGetMatch();
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJMatchDetailFragment.this.progressBar.setVisibility(4);
                JJMatchDetailFragment.this.showRetryLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetMatch() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJMatchDetail(new JJGetMatchDetailsInput(this.match.id + BuildConfig.FLAVOR, JJAppPreferences.currentPredictLink.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMatchDetailFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJMatchDetailFragment.this.progressBar.setVisibility(4);
                JJGetMatchDetailsOutput jJGetMatchDetailsOutput = (JJGetMatchDetailsOutput) response.body();
                if (jJGetMatchDetailsOutput != null) {
                    JJMatchDetailFragment.this.makeLayout(jJGetMatchDetailsOutput.result);
                }
                JJMatchDetailFragment.this.setShareImageToolbar();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJMatchDetailFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    public void makeLayout(JJGetMatchDetailsOutput.Result result) {
        String str;
        String str2;
        int i;
        this.linearLayout.removeAllViews();
        UIRowCardView uIRowCardView = new UIRowCardView();
        uIRowCardView.createView((Activity) this.mContext);
        JJMatchRowPresenter jJMatchRowPresenter = new JJMatchRowPresenter(this.mContext);
        jJMatchRowPresenter.showDetail = false;
        uIRowCardView.linearLayout.addView(jJMatchRowPresenter.createViewHolderAndBind(this.match).itemView);
        UIMatchPointRow uIMatchPointRow = new UIMatchPointRow();
        uIMatchPointRow.createView((Activity) this.mContext, NumberUtils.toPersian(result.r2 + BuildConfig.FLAVOR), "رتبه", NumberUtils.toPersian(result.r1 + BuildConfig.FLAVOR));
        uIRowCardView.linearLayout.addView(uIMatchPointRow.view);
        uIMatchPointRow.createView((Activity) this.mContext, NumberUtils.toPersian(result.p2 + BuildConfig.FLAVOR), "امتیاز", NumberUtils.toPersian(result.p1 + BuildConfig.FLAVOR));
        uIRowCardView.linearLayout.addView(uIMatchPointRow.view);
        this.linearLayout.addView(uIRowCardView.view);
        if (result.venue != null) {
            UIRowCardView uIRowCardView2 = new UIRowCardView();
            uIRowCardView2.createView((Activity) this.mContext);
            UIJJMatchVenueRow uIJJMatchVenueRow = new UIJJMatchVenueRow();
            Activity activity = (Activity) this.mContext;
            JJGetMatchDetailsOutput.Venue venue = result.venue;
            uIJJMatchVenueRow.createView(activity, venue.name, venue.city, venue.imageUrl);
            uIRowCardView2.linearLayout.addView(uIJJMatchVenueRow.view);
            this.linearLayout.addView(uIRowCardView2.view);
        }
        if (result.results != null) {
            UIRowCardView uIRowCardView3 = new UIRowCardView();
            uIRowCardView3.createView((Activity) this.mContext);
            View viewInflate = View.inflate(this.mContext, R.layout.jj_match_statistics_title_row, null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.textViewLeft);
            textView.setText(NumberUtils.toPersian(result.tcount + " نفر"));
            textView.setTextSize(1, 12.0f);
            uIRowCardView3.linearLayout.addView(viewInflate);
            UIJJMatchStatisticsCell uIJJMatchStatisticsCell = new UIJJMatchStatisticsCell();
            String name = this.match.getGuestTeam() != null ? this.match.getGuestTeam().getName() : "تیم ۲";
            ArrayList<Float> arrayList = result.results.win2;
            float fFloatValue = 0.0f;
            float fFloatValue2 = (arrayList == null || arrayList.size() <= 1) ? 0.0f : result.results.win2.get(1).floatValue();
            uIJJMatchStatisticsCell.createView((Activity) this.mContext, "برد " + name, fFloatValue2);
            UIJJMatchStatisticsCell uIJJMatchStatisticsCell2 = new UIJJMatchStatisticsCell();
            ArrayList<Float> arrayList2 = result.results.draw;
            uIJJMatchStatisticsCell2.createView((Activity) this.mContext, "تساوی", (arrayList2 == null || arrayList2.size() <= 1) ? 0.0f : result.results.draw.get(1).floatValue());
            UIJJMatchStatisticsCell uIJJMatchStatisticsCell3 = new UIJJMatchStatisticsCell();
            String name2 = this.match.getHostTeam() != null ? this.match.getHostTeam().getName() : "تیم ۱";
            ArrayList<Float> arrayList3 = result.results.win1;
            if (arrayList3 != null && arrayList3.size() > 1) {
                fFloatValue = result.results.win1.get(1).floatValue();
            }
            uIJJMatchStatisticsCell3.createView((Activity) this.mContext, "برد " + name2, fFloatValue);
            UIThreeLinearRow uIThreeLinearRow = new UIThreeLinearRow();
            uIThreeLinearRow.createView((Activity) this.mContext, uIJJMatchStatisticsCell.view, uIJJMatchStatisticsCell2.view, uIJJMatchStatisticsCell3.view);
            uIRowCardView3.linearLayout.addView(uIThreeLinearRow.view);
            this.linearLayout.addView(uIRowCardView3.view);
        }
        ArrayList<ArrayList<String>> arrayList4 = result.topPreds;
        if (arrayList4 == null || arrayList4.size() <= 0) {
            return;
        }
        UIRowCardView uIRowCardView4 = new UIRowCardView();
        uIRowCardView4.createView((Activity) this.mContext);
        uIRowCardView4.linearLayout.addView(View.inflate(this.mContext, R.layout.jj_match_pred_title_row, null));
        Iterator<ArrayList<String>> it = result.topPreds.iterator();
        while (it.hasNext()) {
            ArrayList<String> next = it.next();
            UIJJMatchPredRow uIJJMatchPredRow = new UIJJMatchPredRow();
            try {
                String strSubstring = next.get(0).substring(0, 1);
                String strSubstring2 = next.get(0).substring(1, 2);
                i = (int) ((Float.parseFloat(next.get(1)) / result.tcount) * 100.0f);
                str = strSubstring;
                str2 = strSubstring2;
            } catch (Exception unused) {
                str = "0";
                str2 = str;
                i = 0;
            }
            uIJJMatchPredRow.createView((Activity) this.mContext, ((Object) next.get(1)) + BuildConfig.FLAVOR, str, str2, i + BuildConfig.FLAVOR);
            uIRowCardView4.linearLayout.addView(uIJJMatchPredRow.view);
        }
        this.linearLayout.addView(uIRowCardView4.view);
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "آمار بازی");
        setShareImageToolbar();
    }

    public void setShareImageToolbar() {
        String str;
        if (this.toolbarImageViewShare == null) {
            ToolbarImageView toolbarImageView = new ToolbarImageView();
            this.toolbarImageViewShare = toolbarImageView;
            toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_share_grey);
            this.toolbarImageViewShare.imageView.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(16.0f));
            this.toolbarImageViewShare.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.JJMatchDetailFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MainClickHandler mainClickHandler = new MainClickHandler();
                    JJMatchDetailFragment jJMatchDetailFragment = JJMatchDetailFragment.this;
                    mainClickHandler.shareStringOrLink(jJMatchDetailFragment.mContext, jJMatchDetailFragment.match.share_link);
                }
            });
        }
        JJMatchObject jJMatchObject = this.match;
        if (jJMatchObject != null && (str = jJMatchObject.share_link) != null && !str.isEmpty()) {
            this.toolbarImageViewShare.view.setVisibility(0);
        } else {
            this.toolbarImageViewShare.view.setVisibility(8);
        }
        this.toolbarMaker.addViewToLeftLayout(this.toolbarImageViewShare.view);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        callUpdateList();
    }
}
