package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.ScrollViewListObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenters.ImageLargePresenter;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import ir.resaneh1.iptv.presenters.ScrollViewListPresenter;

/* loaded from: classes3.dex */
public class ImageListFragment extends PresenterFragment {
    RecyclerViewListPresenter.MyViewHolder recyclerListHolder;
    RecyclerViewListObject recyclerViewListObject;
    RecyclerViewListPresenter recyclerViewListPresenter;
    ScrollViewListPresenter.MyViewHolder scrollViewListHolder;
    ScrollViewListObject scrollViewListObject;
    ScrollViewListPresenter scrollViewListPresenter;
    String title;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.linearlayout_fragment;
    }

    public ImageListFragment(ScrollViewListObject scrollViewListObject) {
        this.scrollViewListObject = scrollViewListObject;
    }

    public ImageListFragment(ScrollViewListObject scrollViewListObject, String str) {
        this.scrollViewListObject = scrollViewListObject;
        this.title = str;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_900));
        this.progressBar.setVisibility(4);
        this.swipeBackEnabled = false;
        if (this.title == null) {
            this.title = "تصاویر";
        }
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.title);
        if (this.linearLayout != null) {
            if (this.scrollViewListObject != null) {
                makeScrollLayout();
            } else if (this.recyclerViewListObject != null) {
                makeRecyclerLayout();
            }
        }
    }

    public void makeScrollLayout() {
        final ImageLargePresenter imageLargePresenter = new ImageLargePresenter(this.mContext);
        this.scrollViewListPresenter = new ScrollViewListPresenter(this.mContext);
        this.scrollViewListObject.presenterSelector = new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.ImageListFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.ImageObject) {
                    return imageLargePresenter;
                }
                return MainPresenterSelector.getInstance(ImageListFragment.this.mContext).getPresenter(presenterItemType);
            }
        };
        ScrollViewListPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = this.scrollViewListPresenter.createViewHolderAndBind(this.scrollViewListObject);
        this.scrollViewListHolder = myViewHolderCreateViewHolderAndBind;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
    }

    public void makeRecyclerLayout() {
        final ImageLargePresenter imageLargePresenter = new ImageLargePresenter(this.mContext);
        this.recyclerViewListPresenter = new RecyclerViewListPresenter(this.mContext);
        this.recyclerViewListObject.presenterSelector = new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.ImageListFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.ImageObject) {
                    return imageLargePresenter;
                }
                return MainPresenterSelector.getInstance(ImageListFragment.this.mContext).getPresenter(presenterItemType);
            }
        };
        RecyclerViewListObject recyclerViewListObject = this.recyclerViewListObject;
        recyclerViewListObject.itemHeight = -1;
        RecyclerViewListPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = this.recyclerViewListPresenter.createViewHolderAndBind(recyclerViewListObject);
        this.recyclerListHolder = myViewHolderCreateViewHolderAndBind;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.linearLayout.removeAllViews();
        ScrollViewListPresenter.MyViewHolder myViewHolder = this.scrollViewListHolder;
        if (myViewHolder != null) {
            this.scrollViewListPresenter.onBindViewHolder(myViewHolder, (ScrollViewListObject) myViewHolder.item);
            this.linearLayout.addView(this.scrollViewListHolder.itemView);
            return;
        }
        RecyclerViewListPresenter.MyViewHolder myViewHolder2 = this.recyclerListHolder;
        if (myViewHolder2 != null) {
            this.recyclerViewListPresenter.onBindViewHolder(myViewHolder2, (RecyclerViewListObject) myViewHolder2.item);
            this.linearLayout.addView(this.recyclerListHolder.itemView);
        }
    }
}
