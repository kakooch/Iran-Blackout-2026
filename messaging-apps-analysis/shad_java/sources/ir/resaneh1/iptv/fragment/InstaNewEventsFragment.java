package ir.resaneh1.iptv.fragment;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidMessenger.utilites.AppFavorUtils;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.InstaNewEventRowPresenter;
import ir.resaneh1.iptv.presenters.InstaPurchaseRowPresenter;
import ir.resaneh1.iptv.presenters.InstaSaleRowPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class InstaNewEventsFragment extends PresenterFragment {
    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public InstaNewEventsFragment(ListInput listInput) {
        this.listInput = listInput;
        this.fragmentName = "InstaNewEventsFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbar();
        initWithVerticalLinearLayoutManager();
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.InstaNewEventsFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.InstaNewEventsFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                InstaNewEventsFragment.this.loadItems();
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.InstaNewEventsFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.instaNotifLikeComment || presenterItemType == PresenterItemType.instaNotifLikePost || presenterItemType == PresenterItemType.instaNotifCommentPost || presenterItemType == PresenterItemType.instaNotifCommentReply || presenterItemType == PresenterItemType.instaNotifFollowing || presenterItemType == PresenterItemType.instaNotifYouFollowing || presenterItemType == PresenterItemType.instaNotifRequest || presenterItemType == PresenterItemType.instaNotifSale || presenterItemType == PresenterItemType.instaNotifPurchase) {
                    InstaNewEventRowPresenter instaNewEventRowPresenter = new InstaNewEventRowPresenter(InstaNewEventsFragment.this.mContext);
                    instaNewEventRowPresenter.onRemoveNotifDone = new OnDoneListener() { // from class: ir.resaneh1.iptv.fragment.InstaNewEventsFragment.3.1
                        @Override // ir.resaneh1.iptv.presenter.abstracts.OnDoneListener
                        public void onDone(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                            int iIndexOf = InstaNewEventsFragment.this.mainArrayList.indexOf(abstractViewHolder.item);
                            if (iIndexOf >= 0) {
                                InstaNewEventsFragment.this.mainArrayList.remove(abstractViewHolder.item);
                                InstaNewEventsFragment.this.mainAdapter.notifyItemRemoved(iIndexOf);
                            }
                        }
                    };
                    return instaNewEventRowPresenter;
                }
                if (presenterItemType == PresenterItemType.instaSaleNotificationObject) {
                    return new InstaSaleRowPresenter(InstaNewEventsFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.instaPurchaseNotificationObject) {
                    return new InstaPurchaseRowPresenter(InstaNewEventsFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.instaNotifUnKnow) {
                    return new AbstractPresenter(this, InstaNewEventsFragment.this.mContext) { // from class: ir.resaneh1.iptv.fragment.InstaNewEventsFragment.3.2
                        @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
                        public AbstractPresenter.AbstractViewHolder onCreateViewHolder(ViewGroup viewGroup) {
                            return new AbstractPresenter.AbstractViewHolder(new UILinearLayout().createView(ApplicationLoader.applicationActivity));
                        }
                    };
                }
                return MainPresenterSelector.getInstance(InstaNewEventsFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = true;
        mainAdapter.isLoadMoreAuto = true;
        this.mainRecyclerView.setAdapter(mainAdapter);
        if (this.mainAdapter.isLoadMoreAuto) {
            addLoadMoreItem(true);
        } else {
            addLoadMoreItem(false);
        }
        loadItems();
    }

    private void setToolbar() {
        ListInput.ItemType itemType = this.listInput.itemType;
        if (itemType == ListInput.ItemType.instaNewEvents) {
            this.toolbarMaker.setInstaToolbar(LocaleController.getString(R.string.rubinoNewEvents));
            return;
        }
        if (itemType == ListInput.ItemType.instaSaleNotif || itemType == ListInput.ItemType.instaPostSale) {
            this.toolbarMaker.setInstaToolbar(LocaleController.getString(R.string.rubinoSales));
        } else if (itemType == ListInput.ItemType.instaPurchaseNotif) {
            this.toolbarMaker.setInstaToolbar(LocaleController.getString(R.string.rubinoPurchase));
        } else {
            this.toolbarMaker.setInstaToolbar(LocaleController.getString(AppFavorUtils.rubinoNameId));
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        loadItems();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void loadItems() {
        super.loadItems();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void setNotFoundLayout() {
        SpannableString spannableStringMakeBoldSpanWithColor;
        this.notFoundLayout.setVisibility(4);
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(0);
            this.progressBar.setVisibility(4);
            ImageView imageView = (ImageView) this.notFoundLayout.findViewById(R.id.imageView);
            TextView textView = (TextView) this.notFoundLayout.findViewById(R.id.textView);
            imageView.setImageResource(R.drawable.no_event);
            imageView.getLayoutParams().width = AndroidUtilities.dp(140.0f);
            imageView.getLayoutParams().height = AndroidUtilities.dp(140.0f);
            ListInput.ItemType itemType = this.listInput.itemType;
            if (itemType == ListInput.ItemType.instaNewEvents) {
                spannableStringMakeBoldSpanWithColor = SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.no_event), this.mContext.getResources().getColor(R.color.grey_700));
            } else if (itemType == ListInput.ItemType.instaSaleNotif || itemType == ListInput.ItemType.instaPostSale) {
                spannableStringMakeBoldSpanWithColor = SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.no_sale), this.mContext.getResources().getColor(R.color.grey_700));
            } else if (itemType == ListInput.ItemType.instaPurchaseNotif) {
                spannableStringMakeBoldSpanWithColor = SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.no_purchase), this.mContext.getResources().getColor(R.color.grey_700));
            } else {
                spannableStringMakeBoldSpanWithColor = SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.nothing_found), this.mContext.getResources().getColor(R.color.grey_700));
            }
            textView.setText(spannableStringMakeBoldSpanWithColor);
        }
        super.setNotFoundLayout();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.listInput.itemType == ListInput.ItemType.instaNewEvents) {
            InstaProfileObject instaCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject();
            instaCurrentProfileObject.new_general_count = "0";
            AppRubinoPreferences.getInstance(this.currentAccount).setRubinoCurrentProfileObject(RubinoProfileObject.createFromOldObject(instaCurrentProfileObject));
        }
        return super.onBackPressed();
    }
}
