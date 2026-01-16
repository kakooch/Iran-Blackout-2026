package ir.resaneh1.iptv.dialog;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class ListPresenterDialog extends PresenterDialog {
    String title;
    private ToolbarImageView toolbarImageViewClose;

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public ListPresenterDialog(String str, ListInput listInput) {
        super(ApplicationLoader.applicationActivity);
        this.listInput = listInput;
        this.title = str;
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
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.dialog.ListPresenterDialog.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                try {
                    if (ApplicationLoader.applicationActivity != null) {
                        new MainClickHandler().onClick(ApplicationLoader.applicationActivity.getLastFragment(), abstractViewHolder);
                    }
                } catch (Exception unused) {
                }
                ListPresenterDialog.this.dismiss();
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.dialog.ListPresenterDialog.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                ListPresenterDialog.this.loadItems();
            }
        };
        this.onItemLoadedListener = new ItemListRequest.Listener(this) { // from class: ir.resaneh1.iptv.dialog.ListPresenterDialog.3
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
            }
        };
        MainAdapter mainAdapter = new MainAdapter(getContext(), this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.dialog.ListPresenterDialog.4
            MainPresenterSelector mainPresenterSelector;

            {
                this.mainPresenterSelector = new MainPresenterSelector(ListPresenterDialog.this.getContext());
            }

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                return this.mainPresenterSelector.getPresenter(presenterItemType);
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
        this.toolbarMaker.toolbar.setBackgroundColor(ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_100));
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewClose = toolbarImageView;
        toolbarImageView.createView(ApplicationLoader.applicationActivity, R.drawable.ic_close_grey);
        this.toolbarImageViewClose.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.ListPresenterDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ListPresenterDialog.this.dismiss();
            }
        });
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        toolbarTextView.createView(ApplicationLoader.applicationActivity, this.title, R.color.grey_900);
        this.toolbarMaker.addViewToRightLayout(this.toolbarImageViewClose.view);
        this.toolbarMaker.addViewToRightLayout(toolbarTextView.view);
        this.toolbarMaker.leftLayout.setLayoutTransition(new LayoutTransition());
    }
}
