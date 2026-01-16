package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.model.ClubHeaderItem;
import ir.resaneh1.iptv.model.GetClubInfoOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ClubHeaderPresenter;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class ClubFragment extends PresenterFragment {
    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_header;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.mainRecyclerView.clearAnimation();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        initWithVerticalLinearLayoutManager();
        final MainClickHandler mainClickHandler = new MainClickHandler();
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.ClubFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                mainClickHandler.onClick(ClubFragment.this.baseFragment, abstractViewHolder);
            }
        };
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), onPresenterItemClickListener, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        getClubInfo();
    }

    void setToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextWhite((Activity) this.mContext, "باشگاه");
    }

    void getClubInfo() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getClubInfo(new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.ClubFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                ClubFragment.this.progressBar.setVisibility(4);
                GetClubInfoOutput getClubInfoOutput = (GetClubInfoOutput) response.body();
                ClubFragment.this.setToolbar();
                ClubFragment clubFragment = ClubFragment.this;
                LinearLayout linearLayout = clubFragment.headerContainer;
                if (linearLayout != null) {
                    linearLayout.addView(new ClubHeaderPresenter(clubFragment.mContext).createViewHolderAndBind(new ClubHeaderItem(getClubInfoOutput.user_rank, getClubInfoOutput.user_score)).itemView);
                }
                ClubFragment.this.mainArrayList.addAll(getClubInfoOutput.items);
                ClubFragment.this.mainAdapter.notifyDataSetChanged();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                ClubFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.refreshOnResume) {
            this.refreshOnResume = false;
            ArrayList<PresenterItem> arrayList = this.mainArrayList;
            if (arrayList != null) {
                arrayList.clear();
                this.mainAdapter.notifyDataSetChanged();
            }
            this.headerContainer.removeAllViews();
            this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, BuildConfig.FLAVOR);
            getClubInfo();
        }
    }
}
