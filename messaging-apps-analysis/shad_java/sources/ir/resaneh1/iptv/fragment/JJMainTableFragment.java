package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.JJApiInput;
import ir.resaneh1.iptv.model.JJGetGroupsTabsOutput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJGetTableOutput;
import ir.resaneh1.iptv.model.JJTableGroupNameObject;
import ir.resaneh1.iptv.model.JJTableRowObject;
import ir.resaneh1.iptv.model.PredictLinkObject;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.JJTableRowPresenter;
import ir.resaneh1.iptv.presenters.JJTableTitleRowPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJMainTableFragment extends PresenterFragment {
    public PredictLinkObject predictLinkObject;
    ArrayList<JJTableRowObject> teams = new ArrayList<>();

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public JJMainTableFragment(PredictLinkObject predictLinkObject) {
        this.predictLinkObject = predictLinkObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        initWithVerticalLinearLayoutManager();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.JJMainTableFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener(this) { // from class: ir.resaneh1.iptv.fragment.JJMainTableFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                MyLog.e("ContactFragment", "loadMore: ");
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.JJMainTableFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.jjTableRow) {
                    return new JJTableRowPresenter(JJMainTableFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.title) {
                    return new JJTableTitleRowPresenter(JJMainTableFragment.this.mContext);
                }
                return MainPresenterSelector.getInstance(JJMainTableFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = false;
        this.mainRecyclerView.setAdapter(mainAdapter);
        callUpdateList();
    }

    private void callUpdateList() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJMatchAndTeamUpdate(new JJGetMatchAndTeamListInput(Long.valueOf(JJAppPreferences.getInstance().getLong(JJAppPreferences.Key.jjTimestamp + this.predictLinkObject.id, 0L)), this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMainTableFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJMainTableFragment.this.progressBar.setVisibility(4);
                if (response.body() != null) {
                    JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput = (JJGetMatchAndTeamListOutput) response.body();
                    JJAppPreferences.getInstance().setOrUpdateMatchAndTeamList(jJGetMatchAndTeamListOutput);
                    JJAppPreferences.getInstance().setLong(JJAppPreferences.Key.jjTimestamp + JJMainTableFragment.this.predictLinkObject.id, jJGetMatchAndTeamListOutput.result.timestamp.longValue());
                    JJMainTableFragment.this.callGetTabs();
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJMainTableFragment.this.progressBar.setVisibility(4);
                JJMainTableFragment.this.showRetryLayout();
            }
        });
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "جدول");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        if (JJAppPreferences.getInstance().getMatchAndTeam().result.teamUpdates == null) {
            callUpdateList();
        } else if (JJAppPreferences.getInstance().getJJGroupsTabs().result.groups == null) {
            callGetTabs();
        } else {
            callGetTable();
        }
    }

    public void callGetTable() {
        ApiRequestIPTV.getInstance(this.currentAccount).getJJTable(new JJApiInput(this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMainTableFragment.5
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJMainTableFragment.this.progressBar.setVisibility(4);
                JJGetTableOutput jJGetTableOutput = (JJGetTableOutput) response.body();
                if (jJGetTableOutput == null && jJGetTableOutput.result == null) {
                    return;
                }
                JJMainTableFragment.this.teams = new ArrayList<>();
                JJMainTableFragment.this.teams.addAll(jJGetTableOutput.result.standing);
                JJMainTableFragment.this.makeLayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJMainTableFragment.this.showRetryLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout() {
        ArrayList<JJTableGroupNameObject> arrayList;
        this.mainArrayList.clear();
        if (JJAppPreferences.getInstance().getJJGroupsTabs().result == null || (arrayList = JJAppPreferences.getInstance().getJJGroupsTabs().result.groups) == null) {
            return;
        }
        Iterator<JJTableGroupNameObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JJTableGroupNameObject next = it.next();
            this.mainArrayList.add(new TitleObject(next.title));
            Iterator<JJTableRowObject> it2 = this.teams.iterator();
            int i = 1;
            while (it2.hasNext()) {
                JJTableRowObject next2 = it2.next();
                if (next2.group.equals(next.group)) {
                    next2.number = i;
                    i++;
                    this.mainArrayList.add(next2);
                }
            }
        }
        this.mainAdapter.notifyDataSetChanged();
    }

    public void callGetTabs() {
        ApiRequestIPTV.getInstance(this.currentAccount).getGroupsTabs(new JJApiInput(this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMainTableFragment.6
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJGetGroupsTabsOutput.Result result;
                JJGetGroupsTabsOutput jJGetGroupsTabsOutput = (JJGetGroupsTabsOutput) response.body();
                if (jJGetGroupsTabsOutput == null || (result = jJGetGroupsTabsOutput.result) == null || result.tabs == null) {
                    return;
                }
                JJAppPreferences.getInstance().setJJGroupsTabs(jJGetGroupsTabsOutput);
                JJMainTableFragment.this.callGetTable();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJMainTableFragment.this.showRetryLayout();
            }
        });
    }
}
