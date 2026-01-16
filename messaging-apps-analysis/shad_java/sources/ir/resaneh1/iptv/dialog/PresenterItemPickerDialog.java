package ir.resaneh1.iptv.dialog;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.SearchPresenter;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.LoadMorePresenter;
import ir.resaneh1.iptv.presenters.SelectionItemPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarProgressBar;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class PresenterItemPickerDialog extends PresenterDialog {
    public boolean hasSearch;
    private final Listener listener;
    private SearchPresenter.ViewHolder searchHolder;
    String title;
    private ToolbarImageView toolbarImageViewCheck;
    private ToolbarImageView toolbarImageViewClose;
    private ToolbarProgressBar toolbarProgressbar;
    private ToolbarTextView toolbarTextView;

    public interface Listener {
        void onItemsSelected(PresenterItem presenterItem);
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public PresenterItemPickerDialog(String str, ListInput listInput, Listener listener, boolean z) {
        super(ApplicationLoader.applicationActivity);
        new Handler();
        this.hasSearch = true;
        this.listInput = listInput;
        this.listener = listener;
        this.title = str;
        this.hasSearch = z;
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initWithVerticalLinearLayoutManager();
        setToolbar();
        ImageView imageView = (ImageView) this.notFoundLayout.findViewById(R.id.imageView);
        TextView textView = (TextView) this.notFoundLayout.findViewById(R.id.textView);
        imageView.setImageResource(R.drawable.no_profile);
        imageView.getLayoutParams().width = AndroidUtilities.dp(70.0f);
        imageView.getLayoutParams().height = AndroidUtilities.dp(70.0f);
        textView.setText(SpanHelper.makeBoldSpanWithColor("موردی یافت نشد", getContext().getResources().getColor(R.color.grey_900)));
        this.mainRecyclerView.setBackgroundColor(-657673);
        if (this.hasSearch) {
            setSearchView();
        }
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                PresenterItemPickerDialog.this.listener.onItemsSelected(abstractViewHolder.item);
                PresenterItemPickerDialog.this.dismiss();
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                PresenterItemPickerDialog.this.loadItems();
            }
        };
        this.onItemLoadedListener = new ItemListRequest.Listener(this) { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.3
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
            }
        };
        MainAdapter mainAdapter = new MainAdapter(getContext(), this.mainArrayList, new PresenterSelector(this) { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.4
            SelectionItemPresenter selectionItemPresenter = new SelectionItemPresenter(ApplicationLoader.applicationActivity);
            LoadMorePresenter loadMorePresenter = new LoadMorePresenter(ApplicationLoader.applicationActivity);

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.loadMore) {
                    return this.loadMorePresenter;
                }
                return this.selectionItemPresenter;
            }
        }, onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        MainAdapter mainAdapter2 = this.mainAdapter;
        mainAdapter2.isSaveSelected = true;
        mainAdapter2.isMultiSelection = false;
        addLoadMoreItem(true);
        loadItems();
    }

    public void setToolbar() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        this.toolbarTextView = toolbarTextView;
        toolbarTextView.createView(ApplicationLoader.applicationActivity, "تایید", 0);
        TextView textView = this.toolbarTextView.textView;
        int i = Theme.key_actionBarDefaultTitle;
        textView.setTextColor(Theme.getColor(i));
        this.toolbarTextView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PresenterItemPickerDialog.this.onCheckClick();
            }
        });
        ToolbarProgressBar toolbarProgressBar = new ToolbarProgressBar();
        this.toolbarProgressbar = toolbarProgressBar;
        toolbarProgressBar.createView(ApplicationLoader.applicationActivity);
        this.toolbarProgressbar.view.setVisibility(8);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewCheck = toolbarImageView;
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        int i2 = Theme.key_actionBarDefaultIcon;
        toolbarImageView.createView(launchActivity, R.drawable.ic_check_grey, Integer.valueOf(Theme.getColor(i2)));
        this.toolbarImageViewCheck.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PresenterItemPickerDialog.this.onCheckClick();
            }
        });
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        this.toolbarImageViewClose = toolbarImageView2;
        toolbarImageView2.createView(ApplicationLoader.applicationActivity, R.drawable.ic_close_grey, Integer.valueOf(Theme.getColor(i2)));
        this.toolbarImageViewClose.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PresenterItemPickerDialog.this.dismiss();
            }
        });
        ToolbarTextView toolbarTextView2 = new ToolbarTextView();
        toolbarTextView2.createView(ApplicationLoader.applicationActivity, this.title, 0);
        toolbarTextView2.textView.setTextColor(Theme.getColor(i));
        this.toolbarMaker.addViewToRightLayout(this.toolbarImageViewClose.view);
        this.toolbarMaker.addViewToRightLayout(toolbarTextView2.view);
        this.toolbarMaker.leftLayout.setLayoutTransition(new LayoutTransition());
    }

    public void onCheckClick() {
        dismiss();
    }

    private void setSearchView() {
        SearchPresenter.ViewHolder viewHolderCreateViewHolderAndBind = new SearchPresenter(ApplicationLoader.applicationActivity).createViewHolderAndBind(new PresenterItem());
        this.searchHolder = viewHolderCreateViewHolderAndBind;
        viewHolderCreateViewHolderAndBind.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PresenterItemPickerDialog.this.mainAdapter.getFilter().filter(editable.toString().toLowerCase());
            }
        });
        this.searchHolder.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.9
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                PresenterItemPickerDialog.this.mainAdapter.getFilter().filter(PresenterItemPickerDialog.this.searchHolder.searchEditText.getText().toString().toLowerCase());
                return true;
            }
        });
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout != null) {
            linearLayout.addView(this.searchHolder.itemView);
            this.linearLayout.setBackgroundColor(-657673);
        }
    }
}
