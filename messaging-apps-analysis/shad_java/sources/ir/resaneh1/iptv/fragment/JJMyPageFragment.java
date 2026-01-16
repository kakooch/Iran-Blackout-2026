package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIJJMyPageHeader;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.model.JJApiInput;
import ir.resaneh1.iptv.model.JJGetChampionOutput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJTeamObject;
import ir.resaneh1.iptv.model.PredictLinkObject;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJMyPageFragment extends PresenterFragment {
    public PredictLinkObject predictLinkObject;
    public UIJJMyPageHeader uijjMyPageHeader;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_header_linear;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public JJMyPageFragment(PredictLinkObject predictLinkObject) {
        this.predictLinkObject = predictLinkObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setContentScrimResource(R.drawable.transparent);
        }
        this.progressBar.setVisibility(4);
        callUpdateList();
        callGetChampion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout() {
        this.retryLayout.setVisibility(4);
        this.headerContainer.removeAllViews();
        UIJJMyPageHeader uIJJMyPageHeader = new UIJJMyPageHeader();
        this.uijjMyPageHeader = uIJJMyPageHeader;
        uIJJMyPageHeader.createView((Activity) this.mContext, 0, 0, 0, 0);
        this.uijjMyPageHeader.button.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.JJMyPageFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JJMyPageFragment.this.presentFragment(new JJChampionFragment(JJMyPageFragment.this.predictLinkObject));
            }
        });
        String string = JJAppPreferences.getInstance().getString(JJAppPreferences.Key.jjMyTeamName + JJAppPreferences.currentPredictLink.id, BuildConfig.FLAVOR);
        if (!string.equals(BuildConfig.FLAVOR)) {
            onChampionSelected(string);
        }
        this.headerContainer.addView(this.uijjMyPageHeader.view);
    }

    private void callGetChampion() {
        ApiRequestIPTV.getInstance(this.currentAccount).getJJChampionTeam(new JJApiInput(JJAppPreferences.currentPredictLink.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMyPageFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJGetChampionOutput jJGetChampionOutput = (JJGetChampionOutput) response.body();
                if (jJGetChampionOutput.result != null) {
                    Iterator<JJTeamObject> it = JJAppPreferences.getInstance().getMatchAndTeam().result.teamUpdates.iterator();
                    while (it.hasNext()) {
                        JJTeamObject next = it.next();
                        if (next.id == jJGetChampionOutput.result.team) {
                            JJAppPreferences.getInstance().setString(JJAppPreferences.Key.jjMyTeamName + JJAppPreferences.currentPredictLink.id, next.getName());
                            JJMyPageFragment.this.makeLayout();
                        }
                    }
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                String string = JJAppPreferences.getInstance().getString(JJAppPreferences.Key.jjMyTeamName + JJAppPreferences.currentPredictLink.id, BuildConfig.FLAVOR);
                if (string == null || string.isEmpty()) {
                    JJMyPageFragment.this.showRetryLayout();
                } else {
                    JJMyPageFragment.this.makeLayout();
                }
            }
        });
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "قهرمان");
    }

    public void onChampionSelected(String str) {
        this.uijjMyPageHeader.button.setVisibility(8);
        this.uijjMyPageHeader.textView.setText("تیم قهرمان پیش بینی شده شما " + str + " است.");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        init();
    }

    private void callUpdateList() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJMatchAndTeamUpdate(new JJGetMatchAndTeamListInput(Long.valueOf(JJAppPreferences.getInstance().getLong(JJAppPreferences.Key.jjTimestamp + this.predictLinkObject.id, 0L)), this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMyPageFragment.3
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJMyPageFragment.this.progressBar.setVisibility(4);
                if (response.body() != null) {
                    JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput = (JJGetMatchAndTeamListOutput) response.body();
                    JJAppPreferences.getInstance().setOrUpdateMatchAndTeamList(jJGetMatchAndTeamListOutput);
                    JJAppPreferences.getInstance().setLong(JJAppPreferences.Key.jjTimestamp + JJMyPageFragment.this.predictLinkObject.id, jJGetMatchAndTeamListOutput.result.timestamp.longValue());
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJGetMatchAndTeamListOutput.Result result;
                JJMyPageFragment.this.progressBar.setVisibility(4);
                JJGetMatchAndTeamListOutput matchAndTeam = JJAppPreferences.getInstance().getMatchAndTeam();
                if (matchAndTeam == null || (result = matchAndTeam.result) == null || result.teamUpdates == null) {
                    JJMyPageFragment.this.showRetryLayout();
                } else {
                    JJMyPageFragment.this.retryLayout.setVisibility(4);
                }
            }
        });
    }
}
