package ir.resaneh1.iptv.presenter;

import android.content.Context;
import android.view.ViewGroup;
import ir.resaneh1.iptv.CourseSectionPresenter;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenters.AODCellPresenter;
import ir.resaneh1.iptv.presenters.AppAbsCellPresenter;
import ir.resaneh1.iptv.presenters.BannerItemPresenter;
import ir.resaneh1.iptv.presenters.BasketPresenter;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.ClubSettingPresenter;
import ir.resaneh1.iptv.presenters.CommentPresenter;
import ir.resaneh1.iptv.presenters.CourseCellPresenter;
import ir.resaneh1.iptv.presenters.ImageCellPresenter;
import ir.resaneh1.iptv.presenters.LinePresenter;
import ir.resaneh1.iptv.presenters.LinkItemCellPresenter;
import ir.resaneh1.iptv.presenters.LoadMorePresenter;
import ir.resaneh1.iptv.presenters.NewsRowPresenter;
import ir.resaneh1.iptv.presenters.OperatorCellPresenter;
import ir.resaneh1.iptv.presenters.OrderPresenter;
import ir.resaneh1.iptv.presenters.RatingDetailRowPresenter;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import ir.resaneh1.iptv.presenters.ScrollViewListPresenter;
import ir.resaneh1.iptv.presenters.SearchTabPresenter;
import ir.resaneh1.iptv.presenters.SearchTitlePresenter;
import ir.resaneh1.iptv.presenters.SelectableRowPresenter;
import ir.resaneh1.iptv.presenters.SessionRowPresenter;
import ir.resaneh1.iptv.presenters.ShortcutPresenter;
import ir.resaneh1.iptv.presenters.SuperLinkItemRowPresenter;
import ir.resaneh1.iptv.presenters.TVEpisodeCellPresenter;
import ir.resaneh1.iptv.presenters.TimeCellPresenter;
import ir.resaneh1.iptv.presenters.TvChannelCellPresenter;
import ir.resaneh1.iptv.presenters.VODCellPresenter;
import ir.resaneh1.iptv.presenters.VirtualChannelAbsCellPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes.dex */
public class MainPresenterSelector extends PresenterSelector {
    private static volatile MainPresenterSelector[] Instance = new MainPresenterSelector[3];
    AODCellPresenter aodCellPresenter;
    AppAbsCellPresenter appCellPresenter;
    BannerItemPresenter bannerItemPresenter;
    BasketPresenter basketPresenter;
    ButtonPresenter buttonPresenter;
    ClubSettingPresenter clubSettingPresenter;
    CommentPresenter commentPresenter;
    CourseSectionPresenter courseSectionPresenter;
    OperatorCellPresenter gridOperatorCellPresenter;
    ImageCellPresenter imageCellPresenter;
    LinePresenter linePresenter;
    private final LinkItemCellPresenter linkItemCellPresenter;
    CourseCellPresenter lmsCellPresenter;
    LoadMorePresenter loadMorePresenter;
    private Context mContext;
    NewsRowPresenter newsRowPresenter;
    OperatorCellPresenter operatorCellPresenter;
    OrderPresenter orderPresenter;
    RatingDetailRowPresenter ratingDetailRowPresenter;
    RecyclerViewListPresenter recyclerViewListHorizontalPresenter;
    ScrollViewListPresenter scrollViewListPresenter;
    SearchTabPresenter searchTabPresenter;
    SearchTitlePresenter searchTitlePresenter;
    SelectableRowPresenter selectableRowPresenter;
    SessionRowPresenter sessionRowPresenter;
    ShortcutPresenter shortcutPresenter;
    int spaceDp = 8;
    SuperLinkItemRowPresenter superLinkItemRowPresenter;
    private TimeCellPresenter timeCellPresenter;
    TVEpisodeCellPresenter tvCellPresenter;
    private final TvChannelCellPresenter tvChannelCellPresenter;
    VirtualChannelAbsCellPresenter virtualChannelAbsCellPresenter;
    VODCellPresenter vodCellPresenter;

    public static MainPresenterSelector getInstance(Context context) {
        MainPresenterSelector mainPresenterSelector;
        int i = UserConfig.selectedAccount;
        MainPresenterSelector mainPresenterSelector2 = Instance[i];
        if (mainPresenterSelector2 != null && mainPresenterSelector2.mContext != null) {
            return mainPresenterSelector2;
        }
        synchronized (MainPresenterSelector.class) {
            mainPresenterSelector = Instance[i];
            if (mainPresenterSelector == null || mainPresenterSelector.mContext == null) {
                MainPresenterSelector[] mainPresenterSelectorArr = Instance;
                MainPresenterSelector mainPresenterSelector3 = new MainPresenterSelector(context);
                mainPresenterSelectorArr[i] = mainPresenterSelector3;
                mainPresenterSelector = mainPresenterSelector3;
            }
        }
        return mainPresenterSelector;
    }

    public MainPresenterSelector(Context context) {
        this.mContext = context;
        this.recyclerViewListHorizontalPresenter = new RecyclerViewListPresenter(context);
        this.vodCellPresenter = new VODCellPresenter(this.mContext);
        this.aodCellPresenter = new AODCellPresenter(this.mContext);
        this.appCellPresenter = new AppAbsCellPresenter(this.mContext);
        this.lmsCellPresenter = new CourseCellPresenter(this.mContext);
        this.virtualChannelAbsCellPresenter = new VirtualChannelAbsCellPresenter(this.mContext);
        this.linkItemCellPresenter = new LinkItemCellPresenter(this.mContext);
        this.operatorCellPresenter = new OperatorCellPresenter(this.mContext);
        this.bannerItemPresenter = new BannerItemPresenter(this.mContext);
        this.scrollViewListPresenter = new ScrollViewListPresenter(this.mContext);
        this.imageCellPresenter = new ImageCellPresenter(this.mContext);
        this.commentPresenter = new CommentPresenter(this.mContext);
        this.sessionRowPresenter = new SessionRowPresenter(this.mContext);
        this.courseSectionPresenter = new CourseSectionPresenter(this.mContext);
        this.tvCellPresenter = new TVEpisodeCellPresenter(this.mContext);
        this.tvChannelCellPresenter = new TvChannelCellPresenter(this.mContext);
        this.timeCellPresenter = new TimeCellPresenter(this.mContext);
        this.ratingDetailRowPresenter = new RatingDetailRowPresenter(this.mContext);
        this.buttonPresenter = new ButtonPresenter(this.mContext);
        this.gridOperatorCellPresenter = new OperatorCellPresenter(this.mContext);
        this.selectableRowPresenter = new SelectableRowPresenter(this.mContext);
        this.selectableRowPresenter = new SelectableRowPresenter(this.mContext);
        this.clubSettingPresenter = new ClubSettingPresenter(this.mContext);
        this.loadMorePresenter = new LoadMorePresenter(this.mContext);
        this.searchTitlePresenter = new SearchTitlePresenter(this.mContext);
        this.linePresenter = new LinePresenter(this.mContext);
        this.newsRowPresenter = new NewsRowPresenter(this.mContext);
        this.searchTabPresenter = new SearchTabPresenter(this.mContext);
        this.shortcutPresenter = new ShortcutPresenter(this.mContext);
        this.basketPresenter = new BasketPresenter(this.mContext);
        this.orderPresenter = new OrderPresenter(this.mContext);
        this.superLinkItemRowPresenter = new SuperLinkItemRowPresenter(this.mContext);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
    public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
        MyLog.e("MediaPresenter", "ChatDate" + presenterItemType);
        if (presenterItemType == PresenterItemType.RecyclerViewList || presenterItemType == PresenterItemType.RecyclerViewGrid) {
            return this.recyclerViewListHorizontalPresenter;
        }
        if (presenterItemType == PresenterItemType.vod) {
            return this.vodCellPresenter;
        }
        if (presenterItemType == PresenterItemType.aod) {
            return this.aodCellPresenter;
        }
        if (presenterItemType == PresenterItemType.app) {
            return this.appCellPresenter;
        }
        if (presenterItemType == PresenterItemType.course) {
            return this.lmsCellPresenter;
        }
        if (presenterItemType == PresenterItemType.virtualChannelAbs) {
            return this.virtualChannelAbsCellPresenter;
        }
        if (presenterItemType == PresenterItemType.itemLink) {
            return this.linkItemCellPresenter;
        }
        if (presenterItemType == PresenterItemType.Operator) {
            if (this.isGrid) {
                setSizeOfCells(presenterItemType);
                return this.gridOperatorCellPresenter;
            }
            return this.operatorCellPresenter;
        }
        if (presenterItemType == PresenterItemType.Banner) {
            return this.bannerItemPresenter;
        }
        if (presenterItemType == PresenterItemType.ScrollViewList) {
            return this.scrollViewListPresenter;
        }
        if (presenterItemType == PresenterItemType.ImageObject) {
            return this.imageCellPresenter;
        }
        if (presenterItemType == PresenterItemType.comment) {
            return this.commentPresenter;
        }
        if (presenterItemType == PresenterItemType.session) {
            return this.sessionRowPresenter;
        }
        if (presenterItemType == PresenterItemType.section) {
            return this.courseSectionPresenter;
        }
        if (presenterItemType == PresenterItemType.tv_episode) {
            return this.tvCellPresenter;
        }
        if (presenterItemType == PresenterItemType.tv_channel) {
            return this.tvChannelCellPresenter;
        }
        if (presenterItemType == PresenterItemType.time) {
            return this.timeCellPresenter;
        }
        if (presenterItemType == PresenterItemType.ratingDetail) {
            return this.ratingDetailRowPresenter;
        }
        if (presenterItemType == PresenterItemType.Button) {
            return this.buttonPresenter;
        }
        if (presenterItemType == PresenterItemType.selectable) {
            return this.selectableRowPresenter;
        }
        if (presenterItemType == PresenterItemType.clubSettingItem) {
            return this.clubSettingPresenter;
        }
        if (presenterItemType == PresenterItemType.loadMore) {
            return this.loadMorePresenter;
        }
        if (presenterItemType == PresenterItemType.searchTitle) {
            return this.searchTitlePresenter;
        }
        if (presenterItemType == PresenterItemType.line) {
            return this.linePresenter;
        }
        if (presenterItemType == PresenterItemType.news) {
            return this.newsRowPresenter;
        }
        if (presenterItemType == PresenterItemType.searchTab) {
            return this.searchTabPresenter;
        }
        if (presenterItemType == PresenterItemType.shortcut) {
            return this.shortcutPresenter;
        }
        if (presenterItemType == PresenterItemType.basket) {
            return this.basketPresenter;
        }
        if (presenterItemType == PresenterItemType.orderObject) {
            return this.orderPresenter;
        }
        if (presenterItemType == PresenterItemType.superLinkItem) {
            return this.superLinkItemRowPresenter;
        }
        MyLog.e("MediaPresenter", "null");
        return new AbstractPresenter(this, this.mContext) { // from class: ir.resaneh1.iptv.presenter.MainPresenterSelector.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
            public AbstractPresenter.AbstractViewHolder onCreateViewHolder(ViewGroup viewGroup) {
                return new AbstractPresenter.AbstractViewHolder(new UILinearLayout().createView(ApplicationLoader.applicationActivity));
            }
        };
    }

    private void setSizeOfCells(PresenterItemType presenterItemType) {
        Context context = this.mContext;
        int iCalculateNoOfColumns = DimensionHelper.calculateNoOfColumns(context, DimensionHelper.getItemWidth(context, presenterItemType) + AndroidUtilities.dp(this.spaceDp));
        int iCalculateItemWidthBasedOnColumns = DimensionHelper.calculateItemWidthBasedOnColumns(this.mContext, iCalculateNoOfColumns, AndroidUtilities.dp(this.spaceDp));
        MyLog.e("MainPresenterSelector", "setSizeOfCells: " + iCalculateNoOfColumns + " " + DimensionHelper.getItemWidth(this.mContext, presenterItemType) + " " + AndroidUtilities.dp(this.spaceDp));
        float itemImageHeight = ((float) DimensionHelper.getItemImageHeight(this.mContext, presenterItemType)) / ((float) DimensionHelper.getItemImageWidth(this.mContext, presenterItemType));
        if (presenterItemType == PresenterItemType.Operator) {
            OperatorCellPresenter operatorCellPresenter = this.gridOperatorCellPresenter;
            operatorCellPresenter.width = iCalculateItemWidthBasedOnColumns;
            int i = (int) (itemImageHeight * iCalculateItemWidthBasedOnColumns);
            operatorCellPresenter.height = i;
            MyLog.e("MainPresenterSelector", "setSizeOfCells: " + iCalculateItemWidthBasedOnColumns + " " + i);
        }
    }
}
