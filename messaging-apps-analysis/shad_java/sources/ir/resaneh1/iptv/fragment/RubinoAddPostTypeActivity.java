package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.InstaPostEditTextPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarProgressBar;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class RubinoAddPostTypeActivity extends PresenterFragment {
    RubinoPostObject postObject;
    ToolbarImageView toolbarImageViewCheck;
    private ToolbarImageView toolbarImageViewClose;
    private ToolbarProgressBar toolbarProgressbar;
    ToolbarTextView toolbarTextView;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_recyclerview;
    }

    public RubinoAddPostTypeActivity(RubinoPostObject rubinoPostObject) {
        this.postObject = rubinoPostObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        setToolbar();
        initWithVerticalLinearLayoutManager();
        final OnDoneListener onDoneListener = new OnDoneListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostTypeActivity.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnDoneListener
            public void onDone(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                int adapterPosition = abstractViewHolder.getAdapterPosition();
                if (adapterPosition >= RubinoAddPostTypeActivity.this.mainArrayList.size() - 1 || adapterPosition < 0) {
                    return;
                }
                RubinoAddPostTypeActivity.this.mainArrayList.remove(adapterPosition);
                RubinoAddPostTypeActivity.this.mainAdapter.notifyItemRemoved(adapterPosition);
            }
        };
        final OnDoneListener onDoneListener2 = new OnDoneListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostTypeActivity.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnDoneListener
            public void onDone(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                if (abstractViewHolder instanceof InstaPostEditTextPresenter.MyViewHolder) {
                    PresenterItem presenterItem = abstractViewHolder.item;
                    ArrayList<PresenterItem> arrayList = RubinoAddPostTypeActivity.this.mainArrayList;
                    if (presenterItem == arrayList.get(arrayList.size() - 1)) {
                        if (((InstaPostEditTextPresenter.MyViewHolder) abstractViewHolder).edittext.getText().toString().isEmpty()) {
                            return;
                        }
                        RubinoAddPostTypeActivity.this.mainArrayList.add(new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString(R.string.new_feature)));
                        RubinoAddPostTypeActivity rubinoAddPostTypeActivity = RubinoAddPostTypeActivity.this;
                        rubinoAddPostTypeActivity.mainAdapter.notifyItemInserted(rubinoAddPostTypeActivity.mainArrayList.size() - 1);
                        return;
                    }
                    if (RubinoAddPostTypeActivity.this.mainArrayList.size() > 1) {
                        if (abstractViewHolder.item == RubinoAddPostTypeActivity.this.mainArrayList.get(r1.size() - 2) && ((InstaPostEditTextPresenter.MyViewHolder) abstractViewHolder).edittext.getText().toString().isEmpty()) {
                            ArrayList<PresenterItem> arrayList2 = RubinoAddPostTypeActivity.this.mainArrayList;
                            arrayList2.remove(arrayList2.size() - 1);
                            RubinoAddPostTypeActivity.this.checkEmptyRows();
                        }
                    }
                }
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostTypeActivity.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.simpleEditText) {
                    return new InstaPostEditTextPresenter(RubinoAddPostTypeActivity.this.mContext, onDoneListener2, onDoneListener);
                }
                return MainPresenterSelector.getInstance(RubinoAddPostTypeActivity.this.mContext).getPresenter(presenterItemType);
            }
        }, null, null);
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = false;
        mainAdapter.isLoadMoreAuto = false;
        this.mainRecyclerView.setAdapter(mainAdapter);
        String[] strArr = this.postObject.post.product_types;
        if (strArr != null) {
            for (String str : strArr) {
                this.mainArrayList.add(new EditTextItem(str, LocaleController.getString(R.string.new_feature)));
            }
        }
        this.mainArrayList.add(new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString(R.string.new_feature)));
        this.mainAdapter.notifyDataSetChanged();
    }

    public void checkEmptyRows() {
        try {
            for (int size = this.mainArrayList.size() - 1; size >= 0; size--) {
                PresenterItem presenterItem = this.mainArrayList.get(size);
                if (presenterItem.getPresenterType() == PresenterItemType.simpleEditText) {
                    if (!((EditTextItem) presenterItem).text.isEmpty()) {
                        break;
                    } else {
                        this.mainArrayList.remove(presenterItem);
                    }
                }
            }
            EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString(R.string.new_feature));
            editTextItem.isRequestFocus = true;
            this.mainArrayList.add(editTextItem);
            this.mainAdapter.notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_100));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        this.toolbarTextView = toolbarTextView;
        toolbarTextView.createView((Activity) this.mContext, LocaleController.getString(R.string.save), R.color.grey_700);
        this.toolbarTextView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostTypeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoAddPostTypeActivity.this.onEditClick();
            }
        });
        ToolbarProgressBar toolbarProgressBar = new ToolbarProgressBar();
        this.toolbarProgressbar = toolbarProgressBar;
        toolbarProgressBar.createView((Activity) this.mContext);
        this.toolbarProgressbar.view.setVisibility(8);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewCheck = toolbarImageView;
        toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_check_grey);
        this.toolbarImageViewCheck.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostTypeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoAddPostTypeActivity.this.onEditClick();
            }
        });
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        this.toolbarImageViewClose = toolbarImageView2;
        toolbarImageView2.createView((Activity) this.mContext, R.drawable.ic_close_grey_700);
        this.toolbarImageViewClose.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostTypeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoAddPostTypeActivity.this.postObject.isProductTypesChange = false;
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            }
        });
        this.toolbarMaker.addViewToRightLayout(this.toolbarImageViewCheck.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarProgressbar.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarTextView.view);
        this.toolbarMaker.addViewToLeftLayout(this.toolbarImageViewClose.view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEditClick() {
        boolean z;
        Iterator<PresenterItem> it = this.mainArrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            PresenterItem next = it.next();
            if (next.getPresenterType() == PresenterItemType.simpleEditText && ((EditTextItem) next).text.isEmpty() && this.mainArrayList.indexOf(next) != this.mainArrayList.size() - 1) {
                z = true;
                break;
            }
        }
        if (z) {
            ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.please_fill_out_empty_rows));
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PresenterItem> it2 = this.mainArrayList.iterator();
        while (it2.hasNext()) {
            PresenterItem next2 = it2.next();
            if (next2.getPresenterType() == PresenterItemType.simpleEditText) {
                EditTextItem editTextItem = (EditTextItem) next2;
                if (!editTextItem.text.isEmpty()) {
                    arrayList.add(editTextItem.text);
                }
            }
        }
        try {
            this.postObject.post.product_types = new String[arrayList.size()];
            Rubino.PostObjectFromServer postObjectFromServer = this.postObject.post;
            postObjectFromServer.product_types = (String[]) arrayList.toArray(postObjectFromServer.product_types);
            this.postObject.isProductTypesChange = true;
        } catch (Exception unused) {
            this.postObject.isProductTypesChange = false;
        }
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.onBackPressed();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
    }
}
