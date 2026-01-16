package ir.resaneh1.iptv.fragment.messanger;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.messenger.SendPostHelper;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.AddPostCaptionView;
import ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class RubinoCaptionPostActivity extends BaseFragment {
    private ListAdapter adapter;
    private int commentInfoRow;
    private int commentRow;
    private ActionBarMenuItem doneItem;
    private int greyRow1;
    private boolean isKeyboardOpened;
    private RecyclerListView listView;
    private int postAndCaptionRow;
    private int rowCount = 0;
    private final RubinoDraftManager.RubinoSendingPost sendingPost;
    private int tagRow;

    public RubinoCaptionPostActivity(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoCaptionPostActivity";
        this.sendingPost = rubinoSendingPost;
        this.needLockOrientation = true;
    }

    private void updateRowsIds() {
        this.greyRow1 = -1;
        this.postAndCaptionRow = -1;
        this.tagRow = -1;
        this.commentRow = -1;
        this.commentInfoRow = -1;
        this.rowCount = 0;
        if (this.sendingPost != null) {
            int i = 0 + 1;
            this.rowCount = i;
            this.postAndCaptionRow = 0;
            this.rowCount = i + 1;
            this.tagRow = i;
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        actionBarCreateActionBar.setCastShadows(false);
        actionBarCreateActionBar.setAddToContainer(true);
        actionBarCreateActionBar.isSmallActionBar = this.isSmallActionBar;
        actionBarCreateActionBar.setAllowOverlayTitle(true);
        actionBarCreateActionBar.setTitle(LocaleController.getString("New Post", R.string.rubinoNewPost));
        actionBarCreateActionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        actionBarCreateActionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarCreateActionBar.createMenu().addItem(1, LocaleController.getString("DONE", R.string.rubinoActionSend));
        this.doneItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.doneItem.textView.setTextColor(ContextCompat.getColor(context, R.color.rubino_blue));
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) throws InterruptedException {
                if (i == -1) {
                    RubinoCaptionPostActivity.this.finishFragment();
                }
                if (i == 1) {
                    RubinoCaptionPostActivity.this.send();
                }
            }
        });
        return actionBarCreateActionBar;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        updateRowsIds();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        RubinoDraftManager.RubinoSendingPost rubinoSendingPost;
        if (getParentActivity() == null) {
            return;
        }
        if (view instanceof TextCheckCell) {
            ((TextCheckCell) view).setChecked(!r2.isChecked());
            if (i != this.commentRow || (rubinoSendingPost = this.sendingPost) == null) {
                return;
            }
            rubinoSendingPost.allow_show_comment = !r2.isChecked();
            return;
        }
        if (i == this.tagRow) {
            presentFragment(new RubinoTagPostActivity(this.sendingPost));
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        updateRowsIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send() throws InterruptedException {
        SendPostHelper.getInstance(this.currentAccount).prepareSendPostRubino(this.sendingPost);
        new MainClickHandler().openRubinoTab();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == RubinoCaptionPostActivity.this.postAndCaptionRow || adapterPosition == RubinoCaptionPostActivity.this.commentRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoCaptionPostActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            View textCheckCell;
            if (i == 0) {
                AddPostCaptionView addPostCaptionView = new AddPostCaptionView(this.mContext);
                addPostCaptionView.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity.ListAdapter.1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        RubinoCaptionPostActivity.this.sendingPost.caption = charSequence.toString();
                    }
                });
                addPostCaptionView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                addPostCaptionView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                frameLayout = addPostCaptionView;
            } else {
                if (i == 1) {
                    textCheckCell = new TextCheckCell(this.mContext);
                    textCheckCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                } else if (i == 2) {
                    textCheckCell = new ShadowSectionCell(this.mContext);
                } else if (i == 3) {
                    textCheckCell = new TextInfoPrivacyCell(this.mContext);
                } else if (i == 4) {
                    FrameLayout textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    textSettingsCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    frameLayout = textSettingsCell;
                } else {
                    textCheckCell = new TextSettingsCell(this.mContext);
                    textCheckCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                }
                return new RecyclerListView.Holder(textCheckCell);
            }
            textCheckCell = frameLayout;
            return new RecyclerListView.Holder(textCheckCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                final AddPostCaptionView addPostCaptionView = (AddPostCaptionView) viewHolder.itemView;
                addPostCaptionView.setPost(RubinoCaptionPostActivity.this.sendingPost);
                if (RubinoCaptionPostActivity.this.isKeyboardOpened) {
                    return;
                }
                RubinoCaptionPostActivity.this.compositeDisposable.add((Disposable) Observable.timer(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoCaptionPostActivity.ListAdapter.2
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Long l) {
                        RubinoCaptionPostActivity.this.isKeyboardOpened = true;
                        addPostCaptionView.editText.requestFocus();
                        AndroidUtilities.showKeyboard(addPostCaptionView.editText);
                    }
                }));
                return;
            }
            if (itemViewType == 1) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (i == RubinoCaptionPostActivity.this.commentRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString(R.string.rubinoPostCommentSetting), false, false);
                    return;
                }
                return;
            }
            if (itemViewType == 3) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i == RubinoCaptionPostActivity.this.commentInfoRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString(R.string.rubinoPostCommentSettingInfo));
                    return;
                }
                return;
            }
            if (itemViewType != 4) {
                return;
            }
            TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
            if (i == RubinoCaptionPostActivity.this.tagRow) {
                ArrayList arrayList = new ArrayList();
                Iterator<RGHMediaHelper$PhotoEntry> it = RubinoCaptionPostActivity.this.sendingPost.entryList.iterator();
                while (it.hasNext()) {
                    HashMap<PostTagObject, Point> map = it.next().tempTaggedProfiles;
                    if (map != null) {
                        arrayList.addAll(map.keySet());
                    }
                }
                if (arrayList.isEmpty()) {
                    textSettingsCell.setText(LocaleController.getString(R.string.rubinoTagPeople), true);
                } else if (arrayList.size() == 1) {
                    textSettingsCell.setTextAndValue(LocaleController.getString(R.string.rubinoTagPeople), ((PostTagObject) arrayList.get(0)).profileObject != null ? ((PostTagObject) arrayList.get(0)).profileObject.username : BuildConfig.FLAVOR, true);
                } else {
                    textSettingsCell.setTextAndValue(LocaleController.getString(R.string.rubinoTagPeople), LocaleController.formatString(R.string.rubinoTagNumbers, Integer.valueOf(arrayList.size())).toString(), true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == RubinoCaptionPostActivity.this.postAndCaptionRow) {
                return 0;
            }
            if (i == RubinoCaptionPostActivity.this.greyRow1) {
                return 2;
            }
            if (i == RubinoCaptionPostActivity.this.commentRow) {
                return 1;
            }
            if (i == RubinoCaptionPostActivity.this.commentInfoRow) {
                return 3;
            }
            return i == RubinoCaptionPostActivity.this.tagRow ? 4 : 2;
        }
    }
}
