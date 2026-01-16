package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.EPGListInput;
import ir.resaneh1.iptv.model.EPGListTVOutput;
import ir.resaneh1.iptv.model.GetEPGPageOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.TVChannelAbs;
import ir.resaneh1.iptv.model.TimeObject;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.EpgRowPresenter;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import ir.resaneh1.iptv.presenters.TvChannelCellPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class EPGFragment extends PresenterFragment {
    private RecyclerViewListPresenter.MyViewHolder channelsRowHolder;
    GetEPGPageOutput getEPGPageOutput;
    public TVChannelAbs selectedChannel;
    public TimeObject selectedDate = null;
    private RecyclerViewListPresenter.MyViewHolder timesRowHolder;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_epg;
    }

    public EPGFragment(TVChannelAbs tVChannelAbs) {
        this.selectedChannel = null;
        this.selectedChannel = tVChannelAbs;
        this.swipeBackEnabled = false;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.mainRecyclerView.clearAnimation();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        initWithVerticalLinearLayoutManager();
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.2
            EpgRowPresenter epgRowPresenter;
            MainPresenterSelector mainPresenterSelector;

            {
                this.epgRowPresenter = new EpgRowPresenter(EPGFragment.this.mContext);
                this.mainPresenterSelector = MainPresenterSelector.getInstance(EPGFragment.this.mContext);
            }

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.tv_episode) {
                    return this.epgRowPresenter;
                }
                return this.mainPresenterSelector.getPresenter(presenterItemType);
            }
        }, new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(EPGFragment.this.baseFragment, abstractViewHolder);
            }
        }, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "جدول پخش");
        callGetEpgPage();
    }

    public void callGetEpgPage() {
        ApiRequestIPTV.getInstance(this.currentAccount).getEpgPage(new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.3
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                ArrayList<TimeObject> arrayList;
                EPGFragment.this.getEPGPageOutput = (GetEPGPageOutput) response.body();
                GetEPGPageOutput getEPGPageOutput = EPGFragment.this.getEPGPageOutput;
                if (getEPGPageOutput.tv_channels == null || (arrayList = getEPGPageOutput.avail_dates) == null || arrayList.size() == 0 || EPGFragment.this.getEPGPageOutput.tv_channels.size() == 0) {
                    return;
                }
                EPGFragment ePGFragment = EPGFragment.this;
                if (ePGFragment.selectedChannel != null) {
                    Iterator<TVChannelAbs> it = ePGFragment.getEPGPageOutput.tv_channels.iterator();
                    while (it.hasNext()) {
                        TVChannelAbs next = it.next();
                        if (next.channel_id.equals(EPGFragment.this.selectedChannel.channel_id)) {
                            next.presenterIsSelected = true;
                            EPGFragment.this.selectedChannel = next;
                        }
                    }
                }
                Iterator<TimeObject> it2 = EPGFragment.this.getEPGPageOutput.avail_dates.iterator();
                while (it2.hasNext()) {
                    TimeObject next2 = it2.next();
                    if (EPGFragment.this.getEPGPageOutput.current_time.fa_date.contains(next2.fa_date)) {
                        next2.presenterIsSelected = true;
                        EPGFragment.this.selectedDate = next2;
                        next2.isToday = true;
                    }
                }
                EPGFragment ePGFragment2 = EPGFragment.this;
                if (ePGFragment2.selectedDate == null) {
                    ePGFragment2.getEPGPageOutput.avail_dates.get(0).presenterIsSelected = true;
                    EPGFragment ePGFragment3 = EPGFragment.this;
                    ePGFragment3.selectedDate = ePGFragment3.getEPGPageOutput.avail_dates.get(0);
                }
                EPGFragment ePGFragment4 = EPGFragment.this;
                if (ePGFragment4.selectedChannel == null) {
                    ePGFragment4.getEPGPageOutput.tv_channels.get(0).presenterIsSelected = true;
                    EPGFragment ePGFragment5 = EPGFragment.this;
                    ePGFragment5.selectedChannel = ePGFragment5.getEPGPageOutput.tv_channels.get(0);
                }
                EPGFragment.this.makeLayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                EPGFragment.this.showRetryLayout();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        callGetEpgPage();
    }

    void requestEpgList() {
        try {
            this.channelsRowHolder.recyclerView.getLayoutManager().scrollToPosition(this.getEPGPageOutput.tv_channels.indexOf(this.selectedChannel));
        } catch (Exception unused) {
        }
        try {
            this.timesRowHolder.recyclerView.getLayoutManager().scrollToPosition(this.getEPGPageOutput.avail_dates.indexOf(this.selectedDate));
        } catch (Exception unused2) {
        }
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getEpgList(new EPGListInput(this.selectedChannel.channel_id, this.selectedDate.fa_date), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                EPGFragment.this.progressBar.setVisibility(4);
                EPGListTVOutput ePGListTVOutput = (EPGListTVOutput) response.body();
                EPGFragment.this.mainArrayList.clear();
                EPGFragment.this.mainArrayList.addAll(ePGListTVOutput.list);
                EPGFragment.this.mainAdapter.notifyDataSetChanged();
                for (int i = 0; i < ePGListTVOutput.list.size(); i++) {
                    if (ePGListTVOutput.list.get(i).getStatusType() == TvEpisodeObjectAbs.StatusType.playing) {
                        if (i > 1) {
                            EPGFragment.this.mainRecyclerView.getLayoutManager().scrollToPosition(i - 1);
                            return;
                        } else {
                            EPGFragment.this.mainRecyclerView.getLayoutManager().scrollToPosition(i);
                            return;
                        }
                    }
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                EPGFragment.this.progressBar.setVisibility(4);
                EPGFragment.this.mainArrayList.clear();
                EPGFragment.this.mainAdapter.notifyDataSetChanged();
                ToastiLikeSnack.showL(EPGFragment.this.mContext, "خطا در اتصال به اینترنت");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout() {
        ListInput listInput = new ListInput(this.getEPGPageOutput.tv_channels);
        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.5
            MainPresenterSelector mainPresenterSelector;
            TvChannelCellPresenter tvChannelCellPresenter;

            {
                this.tvChannelCellPresenter = new TvChannelCellPresenter(EPGFragment.this.mContext);
                this.mainPresenterSelector = MainPresenterSelector.getInstance(EPGFragment.this.mContext);
            }

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.tv_channel) {
                    return this.tvChannelCellPresenter;
                }
                return this.mainPresenterSelector.getPresenter(presenterItemType);
            }
        }, this.baseFragment);
        recyclerViewListObject.hasLoadMore = false;
        recyclerViewListObject.itemHeight = DimensionHelper.getItemHeight(this.mContext, listInput) - AndroidUtilities.dp(8.0f);
        recyclerViewListObject.hastTitle = false;
        recyclerViewListObject.isSaveSelected = true;
        recyclerViewListObject.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.6
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                TVChannelAbs tVChannelAbs = (TVChannelAbs) abstractViewHolder.item;
                EPGFragment ePGFragment = EPGFragment.this;
                ePGFragment.selectedChannel = tVChannelAbs;
                ePGFragment.requestEpgList();
            }
        };
        RecyclerViewListPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new RecyclerViewListPresenter(this.mContext).createViewHolderAndBind(recyclerViewListObject);
        this.channelsRowHolder = myViewHolderCreateViewHolderAndBind;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
        ListInput listInput2 = new ListInput(this.getEPGPageOutput.avail_dates);
        RecyclerViewListObject recyclerViewListObject2 = new RecyclerViewListObject(listInput2, new MainPresenterSelector(this.mContext), this.baseFragment);
        recyclerViewListObject2.hasLoadMore = false;
        recyclerViewListObject2.itemHeight = DimensionHelper.getItemHeight(this.mContext, listInput2);
        recyclerViewListObject2.hastTitle = false;
        recyclerViewListObject2.isSaveSelected = true;
        recyclerViewListObject2.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.EPGFragment.7
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                TimeObject timeObject = (TimeObject) abstractViewHolder.item;
                EPGFragment ePGFragment = EPGFragment.this;
                ePGFragment.selectedDate = timeObject;
                ePGFragment.requestEpgList();
            }
        };
        RecyclerViewListPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = new RecyclerViewListPresenter(this.mContext).createViewHolderAndBind(recyclerViewListObject2);
        this.timesRowHolder = myViewHolderCreateViewHolderAndBind2;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind2.itemView);
        requestEpgList();
    }
}
