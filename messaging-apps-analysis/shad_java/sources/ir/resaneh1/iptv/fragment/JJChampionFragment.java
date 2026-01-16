package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJSetChampionInput;
import ir.resaneh1.iptv.model.JJSetChampionOutput;
import ir.resaneh1.iptv.model.JJTableGroupNameObject;
import ir.resaneh1.iptv.model.JJTeamObject;
import ir.resaneh1.iptv.model.PredictLinkObject;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.JJTableTitleRowPresenter;
import ir.resaneh1.iptv.presenters.JJTeamRowPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.ApplicationLoader;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJChampionFragment extends PresenterFragment {
    public PredictLinkObject predictLinkObject;
    ArrayList<JJTeamObject> teams = new ArrayList<>();

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public JJChampionFragment(PredictLinkObject predictLinkObject) {
        this.predictLinkObject = predictLinkObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        this.swipeBackEnabled = false;
        initWithVerticalLinearLayoutManager();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.JJChampionFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                if (abstractViewHolder.item.getPresenterType() == PresenterItemType.jjTeam) {
                    JJChampionFragment.this.callSetChampion((JJTeamObject) abstractViewHolder.item);
                }
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener(this) { // from class: ir.resaneh1.iptv.fragment.JJChampionFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                MyLog.e("ContactFragment", "loadMore: ");
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.JJChampionFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.jjTeam) {
                    return new JJTeamRowPresenter(JJChampionFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.title) {
                    JJTableTitleRowPresenter jJTableTitleRowPresenter = new JJTableTitleRowPresenter(JJChampionFragment.this.mContext);
                    jJTableTitleRowPresenter.hasFields = false;
                    return jJTableTitleRowPresenter;
                }
                return MainPresenterSelector.getInstance(JJChampionFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = false;
        mainAdapter.isSaveSelected = true;
        this.mainRecyclerView.setAdapter(mainAdapter);
        callUpdateList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSetChampion(final JJTeamObject jJTeamObject) {
        ApiRequestIPTV.getInstance(this.currentAccount).setJJChampionTeam(new JJSetChampionInput(jJTeamObject.id, this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJChampionFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJSetChampionOutput jJSetChampionOutput;
                JJSetChampionOutput.Result result;
                if (response.body() == null || (result = (jJSetChampionOutput = (JJSetChampionOutput) response.body()).result) == null) {
                    return;
                }
                if (result.count < 0) {
                    ToastiLikeSnack.showL(JJChampionFragment.this.mContext, "وقت پیش بینی به پایان رسیده");
                    return;
                }
                Context context = JJChampionFragment.this.mContext;
                StringBuilder sb = new StringBuilder();
                sb.append(NumberUtils.toPersian("در صورت پیش بینی درست " + jJSetChampionOutput.result.count + BuildConfig.FLAVOR));
                sb.append(" امتیاز به شما تعلق می گیرد");
                ToastiLikeSnack.showL(context, sb.toString());
                if (ApplicationLoader.applicationActivity != null) {
                    if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof JJMyPageFragment) {
                        ((JJMyPageFragment) ApplicationLoader.applicationActivity.getSecondLastFragment()).onChampionSelected(jJTeamObject.getName());
                    }
                    JJAppPreferences.getInstance().setString(JJAppPreferences.Key.jjMyTeamName + JJChampionFragment.this.predictLinkObject.id, jJTeamObject.getName());
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                ToastiLikeSnack.showL(JJChampionFragment.this.mContext, "خطا در ثبت نظر شما");
            }
        });
    }

    private void callUpdateList() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJMatchAndTeamUpdate(new JJGetMatchAndTeamListInput(Long.valueOf(JJAppPreferences.getInstance().getLong(JJAppPreferences.Key.jjTimestamp + this.predictLinkObject.id, 0L)), this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJChampionFragment.5
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJChampionFragment.this.progressBar.setVisibility(4);
                if (response.body() != null) {
                    JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput = (JJGetMatchAndTeamListOutput) response.body();
                    JJAppPreferences.getInstance().setOrUpdateMatchAndTeamList(jJGetMatchAndTeamListOutput);
                    JJAppPreferences.getInstance().setLong(JJAppPreferences.Key.jjTimestamp + JJChampionFragment.this.predictLinkObject.id, jJGetMatchAndTeamListOutput.result.timestamp.longValue());
                    JJChampionFragment.this.makeLayout();
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJChampionFragment.this.progressBar.setVisibility(4);
                JJChampionFragment.this.showRetryLayout();
            }
        });
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "انتخاب تیم قهرمان");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout() {
        ArrayList<JJTableGroupNameObject> arrayList;
        this.mainArrayList.clear();
        MainAdapter mainAdapter = this.mainAdapter;
        if (mainAdapter != null) {
            mainAdapter.notifyDataSetChanged();
        }
        if (JJAppPreferences.getInstance().getMatchAndTeam().result.teamUpdates != null) {
            this.teams = JJAppPreferences.getInstance().getMatchAndTeam().result.teamUpdates;
            if (JJAppPreferences.getInstance().getJJGroupsTabs().result == null || (arrayList = JJAppPreferences.getInstance().getJJGroupsTabs().result.groups) == null) {
                return;
            }
            Iterator<JJTableGroupNameObject> it = arrayList.iterator();
            while (it.hasNext()) {
                JJTableGroupNameObject next = it.next();
                this.mainArrayList.add(new TitleObject(next.title));
                Iterator<JJTeamObject> it2 = this.teams.iterator();
                while (it2.hasNext()) {
                    JJTeamObject next2 = it2.next();
                    if (next2.group.equals(next.group)) {
                        this.mainArrayList.add(next2);
                    }
                }
            }
            this.mainAdapter.notifyDataSetChanged();
        }
    }
}
