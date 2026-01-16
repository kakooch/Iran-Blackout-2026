package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.os.Handler;
import android.widget.LinearLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.JJAppPreferences;
import ir.resaneh1.iptv.model.JJApiInput;
import ir.resaneh1.iptv.model.JJGetGroupsTabsOutput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListInput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJMatchObject;
import ir.resaneh1.iptv.model.JJTabObject;
import ir.resaneh1.iptv.model.JJTableGroupNameObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.PredictLinkObject;
import ir.resaneh1.iptv.model.TabListObject;
import ir.resaneh1.iptv.presenters.MatchTabViewpagerPresenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class JJMainMatchListFragment extends PresenterFragment {
    public PredictLinkObject predictLinkObject;
    public ArrayList<JJTabObject> tablist;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_recycler_with_header_fix_linear;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public JJMainMatchListFragment(PredictLinkObject predictLinkObject) {
        new SwipeRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.JJMainMatchListFragment.2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                JJMainMatchListFragment.this.callUpdateList();
            }
        };
        this.predictLinkObject = predictLinkObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        this.swipeBackEnabled = false;
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        callUpdateList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callUpdateList() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getJJMatchAndTeamUpdate(new JJGetMatchAndTeamListInput(Long.valueOf(JJAppPreferences.getInstance().getLong(JJAppPreferences.Key.jjTimestamp + this.predictLinkObject.id, 0L)), this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMainMatchListFragment.1
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJMainMatchListFragment.this.progressBar.setVisibility(4);
                if (response.body() != null) {
                    JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput = (JJGetMatchAndTeamListOutput) response.body();
                    JJAppPreferences.getInstance().setOrUpdateMatchAndTeamList(jJGetMatchAndTeamListOutput);
                    JJAppPreferences.getInstance().setLong(JJAppPreferences.Key.jjTimestamp + JJMainMatchListFragment.this.predictLinkObject.id, jJGetMatchAndTeamListOutput.result.timestamp.longValue());
                    JJMainMatchListFragment.this.callGetTabs();
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJGetMatchAndTeamListOutput.Result result;
                ArrayList<JJMatchObject> arrayList;
                JJMainMatchListFragment.this.progressBar.setVisibility(4);
                JJGetMatchAndTeamListOutput matchAndTeam = JJAppPreferences.getInstance().getMatchAndTeam();
                if (matchAndTeam == null || (result = matchAndTeam.result) == null || (arrayList = result.matchUpdates) == null || arrayList.size() <= 0) {
                    JJMainMatchListFragment.this.showRetryLayout();
                } else {
                    JJMainMatchListFragment.this.callGetTabs();
                }
            }
        });
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "بازی ها");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        if (JJAppPreferences.getInstance().getMatchAndTeam().result.teamUpdates == null) {
            callUpdateList();
        } else {
            callGetTabs();
        }
    }

    public void setFragments() {
        final int iIndexOf;
        ArrayList<JJTabObject> arrayList = this.tablist;
        if (arrayList == null) {
            return;
        }
        Iterator<JJTabObject> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                iIndexOf = 0;
                break;
            }
            JJTabObject next = it.next();
            if (next.is_default) {
                iIndexOf = this.tablist.indexOf(next);
                break;
            }
        }
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<BaseFragment> arrayList3 = new ArrayList<>();
            Iterator<JJTabObject> it2 = this.tablist.iterator();
            while (it2.hasNext()) {
                JJTabObject next2 = it2.next();
                arrayList2.add(next2.title);
                ListInput listInput = new ListInput(ListInput.ItemType.jjMatch);
                listInput.jjTabObject = next2;
                listInput.predictLinkObject = this.predictLinkObject;
                RecyclerFragment recyclerFragment = new RecyclerFragment(listInput);
                recyclerFragment.isWantLoadMore = false;
                recyclerFragment.createView(this.mContext);
                arrayList3.add(recyclerFragment);
            }
            TabListObject tabListObject = new TabListObject();
            tabListObject.tabNames = arrayList2;
            tabListObject.selectedName = arrayList2.get(0);
            tabListObject.fragments = arrayList3;
            final MatchTabViewpagerPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new MatchTabViewpagerPresenter(this.mContext).createViewHolderAndBind(tabListObject);
            myViewHolderCreateViewHolderAndBind.tabLayout.setTabMode(0);
            new Handler().postDelayed(new Runnable(this) { // from class: ir.resaneh1.iptv.fragment.JJMainMatchListFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        myViewHolderCreateViewHolderAndBind.tabLayout.getTabAt(iIndexOf).select();
                    } catch (Exception unused) {
                    }
                }
            }, 150L);
            this.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
        }
    }

    public void callGetTabs() {
        ApiRequestIPTV.getInstance(this.currentAccount).getGroupsTabs(new JJApiInput(this.predictLinkObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.JJMainMatchListFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                JJGetGroupsTabsOutput.Result result;
                JJGetGroupsTabsOutput jJGetGroupsTabsOutput = (JJGetGroupsTabsOutput) response.body();
                if (jJGetGroupsTabsOutput == null || (result = jJGetGroupsTabsOutput.result) == null || result.tabs == null) {
                    return;
                }
                JJAppPreferences.getInstance().setJJGroupsTabs(jJGetGroupsTabsOutput);
                JJMainMatchListFragment jJMainMatchListFragment = JJMainMatchListFragment.this;
                ArrayList<JJTabObject> arrayList = jJGetGroupsTabsOutput.result.tabs;
                jJMainMatchListFragment.tablist = arrayList;
                Collections.sort(arrayList, new TabComparator(jJMainMatchListFragment));
                JJMainMatchListFragment.this.setFragments();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                JJGetGroupsTabsOutput.Result result;
                ArrayList<JJTableGroupNameObject> arrayList;
                JJGetGroupsTabsOutput jJGroupsTabs = JJAppPreferences.getInstance().getJJGroupsTabs();
                if (jJGroupsTabs == null || (result = jJGroupsTabs.result) == null || (arrayList = result.groups) == null || arrayList.size() <= 0) {
                    JJMainMatchListFragment.this.showRetryLayout();
                    return;
                }
                JJMainMatchListFragment jJMainMatchListFragment = JJMainMatchListFragment.this;
                ArrayList<JJTabObject> arrayList2 = jJGroupsTabs.result.tabs;
                jJMainMatchListFragment.tablist = arrayList2;
                Collections.sort(arrayList2, new TabComparator(jJMainMatchListFragment));
                JJMainMatchListFragment.this.setFragments();
            }
        });
    }

    public class TabComparator implements Comparator<JJTabObject> {
        public TabComparator(JJMainMatchListFragment jJMainMatchListFragment) {
        }

        @Override // java.util.Comparator
        public int compare(JJTabObject jJTabObject, JJTabObject jJTabObject2) {
            int i = jJTabObject.order;
            int i2 = jJTabObject2.order;
            if (i > i2) {
                return 1;
            }
            return i < i2 ? -1 : 0;
        }
    }
}
