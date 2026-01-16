package ir.resaneh1.iptv.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PlayListPresenter;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.musicplayer.AudioPlayManager;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PlayListFragment extends PresenterFragment {
    private final String imageUrl;
    private ImageView imageView;
    private final OnPresenterItemClickListener onPresenterItemClickListener;
    private PlayListPresenter playListPresenter;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public PlayListFragment(ArrayList<PlayableAudioObject> arrayList, String str, OnPresenterItemClickListener onPresenterItemClickListener) {
        this.listInput = new ListInput(arrayList);
        this.imageUrl = str;
        this.onPresenterItemClickListener = onPresenterItemClickListener;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.playListPresenter = new PlayListPresenter(this.mContext);
        setToolbar();
        FrameLayout frameLayout = (FrameLayout) getFragmentView();
        ImageView imageView = new ImageView(this.mContext);
        this.imageView = imageView;
        frameLayout.addView(imageView, 0, LayoutHelper.createFrame(-1, -1.0f));
        this.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideHelper.loadBlur(getContext(), this.imageView, this.imageUrl);
        initWithVerticalLinearLayoutManager();
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.PlayListFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                PlayListFragment.this.loadItems();
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.PlayListFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.playableObject) {
                    return PlayListFragment.this.playListPresenter;
                }
                return new MainPresenterSelector(PlayListFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, this.onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = false;
        mainAdapter.isLoadMoreAuto = false;
        this.mainRecyclerView.setAdapter(mainAdapter);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.PlayListFragment.3
            @Override // java.lang.Runnable
            public void run() {
                PlayListFragment.this.loadItems();
            }
        }, 1000L);
    }

    private void setToolbar() {
        findViewById(R.id.toolbar_with_background).setVisibility(8);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        loadItems();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
        super.loadItems();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void setNotFoundLayout() {
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
            textView.setText("لیست خالی است");
        }
        super.setNotFoundLayout();
    }

    public void updateViews() {
        try {
            int childCount = this.mainRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mainRecyclerView.getChildAt(i);
                if (childAt.getTag() instanceof PlayListPresenter.ViewHolder) {
                    PlayListPresenter.ViewHolder viewHolder = (PlayListPresenter.ViewHolder) childAt.getTag();
                    this.playListPresenter.onBindViewHolder(viewHolder, (PlayableAudioObject) viewHolder.item);
                }
            }
            PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
            if (currentPlayingObject != null) {
                GlideHelper.loadBlur(getContext(), this.imageView, currentPlayingObject.getImageUrl());
            }
        } catch (Exception unused) {
        }
    }

    public void updateProgress() {
        try {
            int childCount = this.mainRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mainRecyclerView.getChildAt(i);
                if (childAt.getTag() instanceof PlayListPresenter.ViewHolder) {
                    PlayListPresenter.ViewHolder viewHolder = (PlayListPresenter.ViewHolder) childAt.getTag();
                    if (((PlayableAudioObject) viewHolder.item).getId().equals(AudioPlayManager.getInstance().getCurrentPlayingObject().getId())) {
                        this.playListPresenter.onBindViewHolder(viewHolder, (PlayableAudioObject) viewHolder.item);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
