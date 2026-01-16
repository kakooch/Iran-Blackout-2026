package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.UIView.UILinearLayoutScrollable;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ColorObject;
import ir.resaneh1.iptv.model.GetTagListInput;
import ir.resaneh1.iptv.model.GetTagListOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.PageAttrObject;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.ShortcutObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ShortcutPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.Components.EditTextBoldCursor;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class TagListFragment extends PresenterFragment {
    private View clearSearchBarIcon;
    FrameLayout contentFrameLayout;
    public FrameLayout frameLayoutBottom;
    ImageView imageViewBackground;
    private String lastSearchedText;
    private EditTextBoldCursor searchEditText;
    public String taglistId;
    private final String title;
    public boolean isForSearch = false;
    private Handler handler = new Handler();
    public boolean isLastPortrait = true;
    Runnable runnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.TagListFragment.7
        @Override // java.lang.Runnable
        public void run() {
            TagListFragment.this.onSearchClick();
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.taglist_fragment;
    }

    public TagListFragment(String str, String str2) {
        this.taglistId = str;
        this.title = str2;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.frameLayoutBottom = (FrameLayout) findViewById(R.id.frameLayoutBottom);
        this.contentFrameLayout = (FrameLayout) findViewById(R.id.frameLayoutContent);
        this.imageViewBackground = (ImageView) findViewById(R.id.imageViewBackground);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        initWithVerticalLinearLayoutManager();
        setToolbar();
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), null, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        if (this.isForSearch) {
            return;
        }
        getPageRequest(this.taglistId);
    }

    private void setToolbar() {
        if (!this.isForSearch) {
            this.toolbarMaker.setToolbarWithBackButtonAndTextGrey(ApplicationLoader.applicationActivity, this.title);
        } else {
            setSearchToolbar();
        }
    }

    void setSearchToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, BuildConfig.FLAVOR);
        View viewCreateView = new ToolbarImageView().createView((Activity) this.mContext, R.drawable.ic_close_grey);
        this.clearSearchBarIcon = viewCreateView;
        this.toolbarMaker.addViewToLeftLayout(viewCreateView);
        this.clearSearchBarIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.TagListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TagListFragment.this.searchEditText.setText(BuildConfig.FLAVOR);
                TagListFragment.this.cancelTimer();
                TagListFragment.this.lastSearchedText = BuildConfig.FLAVOR;
                TagListFragment.this.notFoundLayout.setVisibility(4);
                TagListFragment.this.clearSearchBarIcon.setVisibility(4);
            }
        });
        this.clearSearchBarIcon.setVisibility(4);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(this.mContext);
        this.searchEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.searchEditText.setHintTextColor(this.mContext.getResources().getColor(R.color.grey_500));
        this.searchEditText.setTextColor(this.mContext.getResources().getColor(R.color.grey_900));
        this.searchEditText.setMaxLines(1);
        this.searchEditText.setPadding(AndroidUtilities.dp(56.0f), 0, 0, 0);
        this.searchEditText.setGravity(21);
        this.searchEditText.setImeOptions(268435456);
        this.searchEditText.setInputType(16385);
        this.searchEditText.setImeOptions(3);
        this.searchEditText.setMinHeight(AndroidUtilities.dp(56.0f));
        this.searchEditText.setHint("دنبال چی میگردی؟");
        this.searchEditText.setCursorColor(this.mContext.getResources().getColor(R.color.grey_900));
        this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.searchEditText.setCursorWidth(1.5f);
        this.searchEditText.setBackgroundColor(this.mContext.getResources().getColor(R.color.transparent));
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.resaneh1.iptv.fragment.TagListFragment.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                AndroidUtilities.hideKeyboard(TagListFragment.this.searchEditText);
                TagListFragment.this.onSearchClick();
                return true;
            }
        });
        this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.TagListFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TagListFragment.this.searchEditText.getText().toString().length() > 0) {
                    TagListFragment.this.clearSearchBarIcon.setVisibility(0);
                } else {
                    TagListFragment.this.clearSearchBarIcon.setVisibility(4);
                }
                TagListFragment.this.cancelTimer();
                TagListFragment.this.startTimer();
            }
        });
        this.searchEditText.requestFocus();
        this.toolbarMaker.addViewToRightLayout(this.searchEditText);
        this.searchEditText.getLayoutParams().width = DimensionHelper.getScreenWidth((Activity) this.mContext) - AndroidUtilities.dp(56.0f);
    }

    public void getPageRequest(String str) {
        this.mainArrayList.clear();
        MainAdapter mainAdapter = this.mainAdapter;
        if (mainAdapter != null) {
            mainAdapter.notifyDataSetChanged();
        }
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.retryLayout;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        this.progressBar.setVisibility(0);
        ApiRequestMessanger.getInstance(this.currentAccount).getTagList(new GetTagListInput(str), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.TagListFragment.4
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                TagListFragment.this.progressBar.setVisibility(4);
                GetTagListOutput getTagListOutput = (GetTagListOutput) obj;
                if (getTagListOutput == null) {
                    return;
                }
                PageAttrObject pageAttrObject = getTagListOutput.taglist_view;
                if (pageAttrObject != null) {
                    TagListFragment.this.setPageByPageAttr(pageAttrObject);
                } else {
                    Link link = getTagListOutput.search_link;
                    if (link != null) {
                        TagListFragment.this.setSearchView(link, null);
                    }
                    RecyclerView recyclerView = TagListFragment.this.mainRecyclerView;
                    recyclerView.setPadding(recyclerView.getPaddingLeft(), AndroidUtilities.dp(8.0f), TagListFragment.this.mainRecyclerView.getPaddingRight(), TagListFragment.this.mainRecyclerView.getPaddingBottom());
                }
                ArrayList<ViewTagObject> arrayList = getTagListOutput.view_tags;
                if (arrayList != null) {
                    Iterator<ViewTagObject> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ViewTagObject next = it.next();
                        final ListInput listInput = new ListInput(next);
                        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(TagListFragment.this.mContext), TagListFragment.this.baseFragment);
                        recyclerViewListObject.onMoreTextClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.TagListFragment.4.1
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
                        TagListFragment.this.mainArrayList.add(recyclerViewListObject);
                    }
                    TagListFragment.this.mainAdapter.notifyDataSetChanged();
                }
                ArrayList<ShortcutObject> arrayList2 = getTagListOutput.shortcuts;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    return;
                }
                TagListFragment.this.setShortcutView(getTagListOutput.shortcuts);
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                TagListFragment.this.progressBar.setVisibility(4);
                TagListFragment.this.mainArrayList.clear();
                TagListFragment.this.mainAdapter.notifyDataSetChanged();
                TagListFragment.this.showRetryLayout();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                TagListFragment.this.progressBar.setVisibility(4);
                TagListFragment.this.mainArrayList.clear();
                TagListFragment.this.mainAdapter.notifyDataSetChanged();
                TagListFragment.this.showRetryLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageByPageAttr(PageAttrObject pageAttrObject) {
        View viewFindViewById;
        if (pageAttrObject == null) {
            return;
        }
        float f = pageAttrObject.top_space;
        this.mainRecyclerView.setPadding(0, AndroidUtilities.dp(f > 0.0f ? (int) (f * 100.0f) : 0), 0, AndroidUtilities.dp(pageAttrObject.bottom_space > 0.0f ? (int) (r4 * 100.0f) : 0));
        int i = pageAttrObject.show_toolbar ? 56 : 0;
        if (i == 0) {
            ((FrameLayout.LayoutParams) this.progressBar.getLayoutParams()).topMargin = AndroidUtilities.dp(72.0f);
        }
        ((FrameLayout.LayoutParams) this.contentFrameLayout.getLayoutParams()).setMargins(0, AndroidUtilities.dp(i), 0, 0);
        if (pageAttrObject.show_toolbar) {
            Toolbar toolbar = this.toolbarMaker.toolbar;
            if (toolbar != null && (viewFindViewById = toolbar.findViewById(R.id.toolbar_lay)) != null) {
                viewFindViewById.setBackgroundColor(this.mContext.getResources().getColor(R.color.toolbar_grey));
            }
        } else {
            Toolbar toolbar2 = this.toolbarMaker.toolbar;
            if (toolbar2 != null) {
                toolbar2.setBackgroundColor(0);
                View viewFindViewById2 = this.toolbarMaker.toolbar.findViewById(R.id.toolbar_lay);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setBackgroundColor(0);
                }
            }
        }
        setToolbarTitleAndIcon(pageAttrObject.show_title, pageAttrObject.show_back, this.title, pageAttrObject.toolbar_items_color);
        this.imageViewBackground.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        ColorObject colorObject = pageAttrObject.background_color;
        if (colorObject != null) {
            this.imageViewBackground.setBackgroundColor(colorObject.getColor());
        }
        if (pageAttrObject.background_image != null) {
            this.fragmentView.setBackgroundColor(0);
            GlideHelper.load(this.mContext, this.imageViewBackground, pageAttrObject.background_image);
        }
        Link link = pageAttrObject.search_link;
        if (link != null) {
            setSearchView(link, pageAttrObject.toolbar_items_color);
        }
    }

    public void setToolbarTitleAndIcon(boolean z, boolean z2, String str, ColorObject colorObject) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.toolbarMaker.clearToolbar();
        if (z2) {
            View viewCreateView = this.toolbarMaker.toolbarImageView.createView(ApplicationLoader.applicationActivity, R.drawable.arrow_back_grey);
            if (colorObject != null) {
                this.toolbarMaker.toolbarImageView.imageView.setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
            }
            viewCreateView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.TagListFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            });
            this.toolbarMaker.addViewToRightLayout(viewCreateView);
        }
        if (z) {
            View viewCreateView2 = this.toolbarMaker.toolbarTextView.createView(ApplicationLoader.applicationActivity, str);
            if (colorObject != null) {
                this.toolbarMaker.toolbarTextView.textView.setTextColor(colorObject.getColor());
            } else {
                this.toolbarMaker.toolbarTextView.textView.setTextColor(this.mContext.getResources().getColor(R.color.toolbar_text_grey));
            }
            this.toolbarMaker.addViewToRightLayout(viewCreateView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchView(final Link link, ColorObject colorObject) {
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        View viewCreateView = toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_search_small_grey);
        if (colorObject != null) {
            toolbarImageView.imageView.setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
        }
        viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.TagListFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    new MainClickHandler().onLinkClick(TagListFragment.this.baseFragment, link);
                } catch (Exception unused) {
                }
            }
        });
        ToolbarMaker toolbarMaker = this.toolbarMaker;
        if (toolbarMaker != null) {
            toolbarMaker.leftLayout.removeAllViews();
            this.toolbarMaker.addViewToLeftLayout(viewCreateView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShortcutView(ArrayList<ShortcutObject> arrayList) {
        int screenMinDimension = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        ShortcutPresenter shortcutPresenter = new ShortcutPresenter(this.mContext);
        this.frameLayoutBottom.removeAllViews();
        if (arrayList.size() * AndroidUtilities.dp(72.0f) < screenMinDimension) {
            UILinearLayout uILinearLayout = new UILinearLayout();
            uILinearLayout.createView((Activity) this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            uILinearLayout.linearLayout.removeAllViews();
            uILinearLayout.linearLayout.setOrientation(0);
            if (Build.VERSION.SDK_INT >= 17) {
                uILinearLayout.linearLayout.setLayoutDirection(1);
            }
            uILinearLayout.linearLayout.getLayoutParams().width = screenMinDimension;
            Iterator<ShortcutObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ShortcutPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = shortcutPresenter.createViewHolderAndBind(it.next());
                myViewHolderCreateViewHolderAndBind.itemView.setLayoutParams(layoutParams);
                uILinearLayout.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
            }
            this.frameLayoutBottom.addView(uILinearLayout.view);
        } else {
            UILinearLayoutScrollable uILinearLayoutScrollable = new UILinearLayoutScrollable();
            uILinearLayoutScrollable.createView((Activity) this.mContext, true);
            Iterator<ShortcutObject> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                uILinearLayoutScrollable.linearLayout.addView(shortcutPresenter.createViewHolderAndBind(it2.next()).itemView);
            }
            this.frameLayoutBottom.addView(uILinearLayoutScrollable.view);
        }
        this.frameLayoutBottom.setBackground(this.mContext.getResources().getDrawable(R.drawable.gradiant_white_bottom_up));
        RecyclerView recyclerView = this.mainRecyclerView;
        recyclerView.setPadding(0, recyclerView.getPaddingTop(), 0, AndroidUtilities.dp(100.0f));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        if (!this.isForSearch) {
            getPageRequest(this.taglistId);
        } else {
            onSearchClick();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MyLog.e("HomeFragment", "onConfigurationChanged: ");
        this.mainAdapter.notifyDataSetChanged();
    }

    public void startTimer() {
        this.handler.postDelayed(this.runnable, 900L);
    }

    public void cancelTimer() {
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        MyLog.e("homeFragment", "onResume: ");
        MyLog.e("homeFragment", "onResume: isFirstTime");
        if (this.isLastPortrait != isPortrait()) {
            MyLog.e("homeFragment", "onResume: isFirstTime" + this.isLastPortrait + isPortrait());
            this.mainAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        cancelTimer();
        this.isLastPortrait = isPortrait();
    }

    public void onSearchClick() {
        String string = this.searchEditText.getText().toString();
        if (string == null || string.equals(BuildConfig.FLAVOR) || string.equals(this.lastSearchedText)) {
            return;
        }
        this.lastSearchedText = string;
        getPageRequest(this.taglistId);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public boolean isPortrait() {
        return this.mContext.getResources().getConfiguration().orientation == 1;
    }
}
