package ir.resaneh1.iptv.fragment.home;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class HomeViewTagCell extends HomeCell {
    LinearLayout linearLayout;
    RecyclerViewListPresenter recyclerViewListPresenter;
    HomePageModels.HomeViewTagSectionObject viewTagArray;

    public HomeViewTagCell(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.linearLayout.setPadding(AndroidUtilities.dp(0.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(0.0f), AndroidUtilities.dp(8.0f));
        this.recyclerViewListPresenter = new RecyclerViewListPresenter(context);
        frameLayout.addView(this.linearLayout, LayoutHelper.createFrame(-1, -2.0f, 17, 8.0f, 4.0f, 8.0f, 4.0f));
        return frameLayout;
    }

    private boolean dataIsValid(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.HomeViewTagSectionObject homeViewTagSectionObject;
        return (homePageSectionObject == null || (homeViewTagSectionObject = homePageSectionObject.view_tag_section) == null || homeViewTagSectionObject.view_tag_item_list == null) ? false : true;
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject, BaseFragment baseFragment) {
        resetState();
        if (!dataIsValid(homePageSectionObject)) {
            VisibilityHelper.hideViews(this);
            return;
        }
        VisibilityHelper.showViews(this);
        this.viewTagArray = homePageSectionObject.view_tag_section;
        this.linearLayout.removeAllViews();
        HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
        if (commonSectionDataObject != null) {
            setSectionInfoData(commonSectionDataObject, homePageSectionObject.type);
        }
        addRows(baseFragment);
    }

    private void resetState() {
        this.viewTagArray = null;
    }

    private void addRows(BaseFragment baseFragment) {
        ArrayList<ViewTagObject> arrayList = this.viewTagArray.view_tag_item_list;
        if (arrayList != null) {
            Iterator<ViewTagObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ViewTagObject next = it.next();
                final ListInput listInput = new ListInput(next);
                RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(baseFragment.getContext()), baseFragment);
                recyclerViewListObject.onMoreTextClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.home.HomeViewTagCell.1
                    @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
                    public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                        new MainClickHandler().onMoreViewListClick(listInput.viewTagObject);
                    }
                };
                ViewGroupObject viewGroupObject = next.view;
                recyclerViewListObject.hasMoreText = viewGroupObject.has_more;
                recyclerViewListObject.hasLoadMore = true;
                recyclerViewListObject.hastTitle = viewGroupObject.has_title;
                recyclerViewListObject.isSaveSelected = true;
                recyclerViewListObject.itemHeight = viewGroupObject.size.getHeightPx();
                recyclerViewListObject.decorationSize = (int) (next.view.h_space * 100.0f);
                RecyclerViewListPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = this.recyclerViewListPresenter.createViewHolderAndBind(recyclerViewListObject);
                if (myViewHolderCreateViewHolderAndBind.getTitleTextView() != null) {
                    myViewHolderCreateViewHolderAndBind.getTitleTextView().setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                }
                this.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
            }
        }
    }

    public void initTestData(BaseFragment baseFragment) {
        HomePageModels.HomePageSectionObject homePageSectionObject = new HomePageModels.HomePageSectionObject();
        HomePageModels.HomeViewTagSectionObject homeViewTagSectionObject = new HomePageModels.HomeViewTagSectionObject();
        homeViewTagSectionObject.view_tag_item_list = new ArrayList<>();
        ViewTagObject viewTagObject = (ViewTagObject) ApplicationLoader.getGson().fromJson("{\"tag_id\": \"category-groups_kid_exclusive-dubs-medias\", \"title\": \"\\u062f\\u0648\\u0628\\u0644\\u0647\", \"api_url\": \"https://namavavod.iranlms.ir\", \"view\": {\"view_key\": null, \"size\": {\"width\": 1.14, \"height\": 1.98}, \"images\": [{\"x1\": 0.0, \"x2\": 1.14, \"y1\": 0.0, \"y2\": 1.54, \"type\": \"Rectangle\", \"align_type\": \"None\", \"corner\": 0.0, \"shadow\": {\"type\": \"None\"}, \"item_name\": \"movie_cover\", \"has_placeholder\": false, \"placeholder_url\": null}, {\"x1\": 0.0, \"x2\": 1.14, \"y1\": 0.0, \"y2\": 1.98, \"type\": \"Rectangle\", \"align_type\": \"None\", \"corner\": 0.0, \"shadow\": {\"type\": \"None\"}, \"item_name\": \"image_frame\", \"has_placeholder\": true, \"placeholder_url\": \"https://xcdn6.iranlms.ir/static/4/services/images/634300159dc6d6594801f4d5.jpg\"}], \"texts\": [{\"x1\": 0.04, \"y1\": 1.54, \"x2\": 1.13, \"y2\": 1.75, \"align_type\": \"None\", \"h_align\": \"Right\", \"v_align\": \"Middle\", \"font\": 0.9, \"max_line\": 2, \"type\": \"Bold\", \"item_name\": \"title_fa\", \"has_placeholder\": false, \"placeholder_text\": null, \"height_type\": \"Fix\", \"is_editable\": false, \"dynamic_height_bottom_space\": null, \"keyboard_type\": \"Text\", \"text_edit_max_char\": null, \"text_edit_style\": \"Normal\", \"color\": {\"red\": 79, \"green\": 78, \"blue\": 78, \"alpha\": 255}, \"hint_color\": {\"red\": 0, \"green\": 0, \"blue\": 0, \"alpha\": 0}, \"text_edit_style_color\": {\"red\": 0, \"green\": 0, \"blue\": 0, \"alpha\": 0}}, {\"x1\": 0.04, \"y1\": 1.71, \"x2\": 1.13, \"y2\": 1.93, \"align_type\": \"None\", \"h_align\": \"Right\", \"v_align\": \"Middle\", \"font\": 0.8, \"max_line\": 2, \"type\": \"Regular\", \"item_name\": \"genre\", \"has_placeholder\": false, \"placeholder_text\": null, \"height_type\": \"Fix\", \"is_editable\": false, \"dynamic_height_bottom_space\": null, \"keyboard_type\": \"Text\", \"text_edit_max_char\": null, \"text_edit_style\": \"Normal\", \"color\": {\"red\": 158, \"green\": 158, \"blue\": 158, \"alpha\": 255}, \"hint_color\": {\"red\": 0, \"green\": 0, \"blue\": 0, \"alpha\": 0}, \"text_edit_style_color\": {\"red\": 0, \"green\": 0, \"blue\": 0, \"alpha\": 0}}]}}", ViewTagObject.class);
        ViewGroupObject viewGroupObject = viewTagObject.view;
        viewGroupObject.h_space = 0.1f;
        viewGroupObject.v_space = 0.1f;
        viewGroupObject.has_title = true;
        viewGroupObject.has_more = true;
        homeViewTagSectionObject.view_tag_item_list.add(viewTagObject);
        homeViewTagSectionObject.view_tag_item_list.add(viewTagObject);
        homePageSectionObject.view_tag_section = homeViewTagSectionObject;
        setData(homePageSectionObject, baseFragment);
    }
}
