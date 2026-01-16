package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.widget.LinearLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.model.GetCategoryHighlightListOutput;
import ir.resaneh1.iptv.model.GetCategoryHighlightsInput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.NewsCategoryObject;
import ir.resaneh1.iptv.model.TabListObject;
import ir.resaneh1.iptv.presenters.MatchTabViewpagerPresenter;
import ir.resaneh1.iptv.presenters.NewsHighlightHeaderPresenter;
import java.util.ArrayList;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class NewsCategoryDetailFragment extends PresenterFragment {
    private NewsCategoryObject categoryObject;
    public GetCategoryHighlightListOutput.HighlightList highlightList;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_recycler_with_header_fix_linear;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public NewsCategoryDetailFragment(NewsCategoryObject newsCategoryObject) {
        this.categoryObject = newsCategoryObject;
    }

    public NewsCategoryDetailFragment(String str, String str2) {
        NewsCategoryObject newsCategoryObject = new NewsCategoryObject();
        this.categoryObject = newsCategoryObject;
        newsCategoryObject.id = str;
        newsCategoryObject.title = str2;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        this.progressBar.setVisibility(4);
        this.retryLayout.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        if (this.categoryObject != null) {
            getHighlight();
        }
        setPrimaryToolbar();
        setLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeader() {
        if (this.highlightList != null) {
            setToolbar();
            LinearLayout linearLayout = this.headerContainer;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                if (this.highlightList != null) {
                    this.headerContainer.addView(new NewsHighlightHeaderPresenter(this.mContext).createViewHolderAndBind(this.highlightList).itemView);
                    return;
                }
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.headerContainer;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        setPrimaryToolbar();
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextWhite((Activity) this.mContext, this.categoryObject.title);
    }

    private void setPrimaryToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.categoryObject.title);
    }

    public void setLayout() {
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        setFragments();
    }

    public void setFragments() {
        if (this.linearLayout != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("پر بازدیدترین");
            arrayList.add("تازه ترین");
            TabListObject tabListObject = new TabListObject();
            tabListObject.tabNames = arrayList;
            tabListObject.selectedName = arrayList.get(arrayList.size() - 1);
            ArrayList<BaseFragment> arrayList2 = new ArrayList<>();
            ListInput listInput = new ListInput(ListInput.ItemType.mostVisitedNews);
            listInput.limit = 9;
            listInput.categoryId = this.categoryObject.id;
            RecyclerFragment recyclerFragment = new RecyclerFragment(listInput);
            recyclerFragment.createView(this.mContext);
            arrayList2.add(recyclerFragment);
            ListInput listInput2 = new ListInput(ListInput.ItemType.newestNews);
            listInput2.limit = 9;
            listInput2.categoryId = this.categoryObject.id;
            RecyclerFragment recyclerFragment2 = new RecyclerFragment(listInput2);
            recyclerFragment2.createView(this.mContext);
            arrayList2.add(recyclerFragment2);
            tabListObject.fragments = arrayList2;
            this.linearLayout.addView(new MatchTabViewpagerPresenter(this.mContext).createViewHolderAndBind(tabListObject).itemView);
        }
    }

    public void getHighlight() {
        ApiRequestIPTV.getInstance(this.currentAccount).getCategoryHighlights(new GetCategoryHighlightsInput(this.categoryObject.id), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.NewsCategoryDetailFragment.1
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetCategoryHighlightListOutput getCategoryHighlightListOutput;
                GetCategoryHighlightListOutput.HighlightList highlightList;
                NewsCategoryDetailFragment.this.progressBar.setVisibility(4);
                NewsCategoryDetailFragment.this.retryLayout.setVisibility(4);
                if (response == null || response.body() == null || (getCategoryHighlightListOutput = (GetCategoryHighlightListOutput) response.body()) == null || (highlightList = getCategoryHighlightListOutput.result) == null || highlightList.highlights == null) {
                    return;
                }
                NewsCategoryDetailFragment newsCategoryDetailFragment = NewsCategoryDetailFragment.this;
                newsCategoryDetailFragment.highlightList = highlightList;
                newsCategoryDetailFragment.setHeader();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                NewsCategoryDetailFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        setHeader();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        init();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setHeader();
    }
}
