package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.netopen.hotbitmapgg.library.view.RingProgressBar;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UIBottomUpDragLayout;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.musicplayer.AudioPlayManager;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class BookAudioPlayerFragment extends PresenterFragment {
    PlayableAudioObject currentPlayingObject;
    TextView currentPositionTextView;
    TextView durationTextView;
    AudioPlayManager.Listener listener;
    ImageView nextImageView;
    View.OnClickListener onClickListener;
    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;
    ImageView pauseImageView;
    ImageView playImageView;
    private PlayListFragment playListFragment;
    private ArrayList<PlayableAudioObject> playableAudioObjects;
    ImageView previousImageView;
    ProgressBar progressBar;
    RingProgressBar ringProgressBar;
    SeekBar seekBar;
    TextView subtitleTextView;
    ImageView tenSecondNext;
    ImageView tenSecondPrevious;
    TextView titleTextView;
    FrameLayout topFrameLayout;
    private UIBottomUpDragLayout uiDragLayout;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.fragment_audio_book_play;
    }

    public BookAudioPlayerFragment(ArrayList<AODObjectAbs> arrayList) {
        this.playableAudioObjects = new ArrayList<>();
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BookAudioPlayerFragment bookAudioPlayerFragment = BookAudioPlayerFragment.this;
                if (view == bookAudioPlayerFragment.playImageView) {
                    AudioPlayManager.getInstance().play(BookAudioPlayerFragment.this.currentPlayingObject);
                    return;
                }
                if (view == bookAudioPlayerFragment.pauseImageView) {
                    AudioPlayManager.getInstance().pause(BookAudioPlayerFragment.this.currentPlayingObject);
                    return;
                }
                if (view == bookAudioPlayerFragment.previousImageView) {
                    AudioPlayManager.getInstance().playPrevious();
                    return;
                }
                if (view == bookAudioPlayerFragment.nextImageView) {
                    AudioPlayManager.getInstance().playNext();
                } else if (view == bookAudioPlayerFragment.tenSecondNext) {
                    AudioPlayManager.getInstance().tenSecondForward();
                } else if (view == bookAudioPlayerFragment.tenSecondPrevious) {
                    AudioPlayManager.getInstance().tenSecondBackward();
                }
            }
        };
        this.listener = new AudioPlayManager.Listener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.4
            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateView() {
                try {
                    PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
                    if (currentPlayingObject != null && !BookAudioPlayerFragment.this.currentPlayingObject.getId().equals(currentPlayingObject.getId())) {
                        BookAudioPlayerFragment.this.initViews(currentPlayingObject);
                        BookAudioPlayerFragment.this.currentPlayingObject = currentPlayingObject;
                    }
                    if (BookAudioPlayerFragment.this.currentPlayingObject == null) {
                        return;
                    }
                    if (AudioPlayManager.getInstance().isVisiblePlayButton(BookAudioPlayerFragment.this.currentPlayingObject)) {
                        BookAudioPlayerFragment.this.playImageView.setVisibility(0);
                    } else {
                        BookAudioPlayerFragment.this.playImageView.setVisibility(4);
                    }
                    if (AudioPlayManager.getInstance().isVisiblePauseButton(BookAudioPlayerFragment.this.currentPlayingObject)) {
                        BookAudioPlayerFragment.this.pauseImageView.setVisibility(0);
                    } else {
                        BookAudioPlayerFragment.this.pauseImageView.setVisibility(4);
                    }
                    if (AudioPlayManager.getInstance().isVisibleProgressView(BookAudioPlayerFragment.this.currentPlayingObject)) {
                        BookAudioPlayerFragment.this.progressBar.setVisibility(0);
                    } else {
                        BookAudioPlayerFragment.this.progressBar.setVisibility(4);
                    }
                    updateProgress();
                    if (BookAudioPlayerFragment.this.playListFragment != null) {
                        BookAudioPlayerFragment.this.playListFragment.updateViews();
                    }
                } catch (Exception e) {
                    MyLog.handleException(e);
                }
            }

            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateProgress() {
                BookAudioPlayerFragment.this.currentPositionTextView.setText(AudioPlayManager.getInstance().getCurrentPositionText(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.durationTextView.setText(AudioPlayManager.getInstance().getDurationText(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.seekBar.setMax(AudioPlayManager.getInstance().getDuration(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.seekBar.setProgress(AudioPlayManager.getInstance().getCurrentPosition(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.ringProgressBar.setMax(100);
                if (BookAudioPlayerFragment.this.seekBar.getMax() != 0) {
                    BookAudioPlayerFragment bookAudioPlayerFragment = BookAudioPlayerFragment.this;
                    bookAudioPlayerFragment.ringProgressBar.setMax(bookAudioPlayerFragment.seekBar.getMax());
                }
                BookAudioPlayerFragment bookAudioPlayerFragment2 = BookAudioPlayerFragment.this;
                bookAudioPlayerFragment2.ringProgressBar.setProgress(bookAudioPlayerFragment2.seekBar.getProgress());
                if (BookAudioPlayerFragment.this.playListFragment != null) {
                    BookAudioPlayerFragment.this.playListFragment.updateProgress();
                }
            }

            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateJustProgressText(String str) {
                BookAudioPlayerFragment.this.currentPositionTextView.setText(str);
            }
        };
        this.onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    AudioPlayManager.getInstance().seekByUser(BookAudioPlayerFragment.this.currentPlayingObject, i);
                    BookAudioPlayerFragment.this.ringProgressBar.setProgress(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                AudioPlayManager.getInstance().startSeekBarTouch(BookAudioPlayerFragment.this.currentPlayingObject);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                MyLog.e("scroolll", "stopToch");
                AudioPlayManager.getInstance().stopSeekbarTouchUser(BookAudioPlayerFragment.this.currentPlayingObject, seekBar.getProgress());
            }
        };
        ApplicationLoader.applicationActivity.floatingViews.hideMusicLayout();
        ApplicationLoader.applicationActivity.floatingViews.showOnPlayMusic = false;
        this.playableAudioObjects.clear();
        Iterator<AODObjectAbs> it = arrayList.iterator();
        while (it.hasNext()) {
            this.playableAudioObjects.add(new PlayableAudioObject(it.next(), this.currentAccount));
        }
        this.currentPlayingObject = this.playableAudioObjects.get(0);
        AudioPlayManager.getInstance().play(this.currentPlayingObject);
        AudioPlayManager.getInstance().setPlayList(this.playableAudioObjects);
        this.fragmentName = "BookAudioPlayerFragment";
    }

    public BookAudioPlayerFragment() {
        this.playableAudioObjects = new ArrayList<>();
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BookAudioPlayerFragment bookAudioPlayerFragment = BookAudioPlayerFragment.this;
                if (view == bookAudioPlayerFragment.playImageView) {
                    AudioPlayManager.getInstance().play(BookAudioPlayerFragment.this.currentPlayingObject);
                    return;
                }
                if (view == bookAudioPlayerFragment.pauseImageView) {
                    AudioPlayManager.getInstance().pause(BookAudioPlayerFragment.this.currentPlayingObject);
                    return;
                }
                if (view == bookAudioPlayerFragment.previousImageView) {
                    AudioPlayManager.getInstance().playPrevious();
                    return;
                }
                if (view == bookAudioPlayerFragment.nextImageView) {
                    AudioPlayManager.getInstance().playNext();
                } else if (view == bookAudioPlayerFragment.tenSecondNext) {
                    AudioPlayManager.getInstance().tenSecondForward();
                } else if (view == bookAudioPlayerFragment.tenSecondPrevious) {
                    AudioPlayManager.getInstance().tenSecondBackward();
                }
            }
        };
        this.listener = new AudioPlayManager.Listener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.4
            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateView() {
                try {
                    PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
                    if (currentPlayingObject != null && !BookAudioPlayerFragment.this.currentPlayingObject.getId().equals(currentPlayingObject.getId())) {
                        BookAudioPlayerFragment.this.initViews(currentPlayingObject);
                        BookAudioPlayerFragment.this.currentPlayingObject = currentPlayingObject;
                    }
                    if (BookAudioPlayerFragment.this.currentPlayingObject == null) {
                        return;
                    }
                    if (AudioPlayManager.getInstance().isVisiblePlayButton(BookAudioPlayerFragment.this.currentPlayingObject)) {
                        BookAudioPlayerFragment.this.playImageView.setVisibility(0);
                    } else {
                        BookAudioPlayerFragment.this.playImageView.setVisibility(4);
                    }
                    if (AudioPlayManager.getInstance().isVisiblePauseButton(BookAudioPlayerFragment.this.currentPlayingObject)) {
                        BookAudioPlayerFragment.this.pauseImageView.setVisibility(0);
                    } else {
                        BookAudioPlayerFragment.this.pauseImageView.setVisibility(4);
                    }
                    if (AudioPlayManager.getInstance().isVisibleProgressView(BookAudioPlayerFragment.this.currentPlayingObject)) {
                        BookAudioPlayerFragment.this.progressBar.setVisibility(0);
                    } else {
                        BookAudioPlayerFragment.this.progressBar.setVisibility(4);
                    }
                    updateProgress();
                    if (BookAudioPlayerFragment.this.playListFragment != null) {
                        BookAudioPlayerFragment.this.playListFragment.updateViews();
                    }
                } catch (Exception e) {
                    MyLog.handleException(e);
                }
            }

            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateProgress() {
                BookAudioPlayerFragment.this.currentPositionTextView.setText(AudioPlayManager.getInstance().getCurrentPositionText(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.durationTextView.setText(AudioPlayManager.getInstance().getDurationText(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.seekBar.setMax(AudioPlayManager.getInstance().getDuration(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.seekBar.setProgress(AudioPlayManager.getInstance().getCurrentPosition(BookAudioPlayerFragment.this.currentPlayingObject));
                BookAudioPlayerFragment.this.ringProgressBar.setMax(100);
                if (BookAudioPlayerFragment.this.seekBar.getMax() != 0) {
                    BookAudioPlayerFragment bookAudioPlayerFragment = BookAudioPlayerFragment.this;
                    bookAudioPlayerFragment.ringProgressBar.setMax(bookAudioPlayerFragment.seekBar.getMax());
                }
                BookAudioPlayerFragment bookAudioPlayerFragment2 = BookAudioPlayerFragment.this;
                bookAudioPlayerFragment2.ringProgressBar.setProgress(bookAudioPlayerFragment2.seekBar.getProgress());
                if (BookAudioPlayerFragment.this.playListFragment != null) {
                    BookAudioPlayerFragment.this.playListFragment.updateProgress();
                }
            }

            @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
            public void updateJustProgressText(String str) {
                BookAudioPlayerFragment.this.currentPositionTextView.setText(str);
            }
        };
        this.onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    AudioPlayManager.getInstance().seekByUser(BookAudioPlayerFragment.this.currentPlayingObject, i);
                    BookAudioPlayerFragment.this.ringProgressBar.setProgress(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                AudioPlayManager.getInstance().startSeekBarTouch(BookAudioPlayerFragment.this.currentPlayingObject);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                MyLog.e("scroolll", "stopToch");
                AudioPlayManager.getInstance().stopSeekbarTouchUser(BookAudioPlayerFragment.this.currentPlayingObject, seekBar.getProgress());
            }
        };
        ApplicationLoader.applicationActivity.floatingViews.hideMusicLayout();
        ApplicationLoader.applicationActivity.floatingViews.showOnPlayMusic = false;
        this.currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
        if (AudioPlayManager.getInstance().getPlaylist() != null) {
            this.playableAudioObjects = AudioPlayManager.getInstance().getPlaylist();
        }
        this.fragmentName = "BookAudioPlayerFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        PlayListFragment playListFragment = this.playListFragment;
        if (playListFragment != null) {
            playListFragment.onPause();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        ApplicationLoader.applicationActivity.floatingViews.showOnPlayMusic = true;
        AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ApplicationLoader.applicationActivity.floatingViews.showMusicLayout();
            }
        }, 100L);
        AudioPlayManager.getInstance().removeListener(this.listener);
        PlayListFragment playListFragment = this.playListFragment;
        if (playListFragment != null) {
            playListFragment.onFragmentDestroy();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        this.toolbarMaker.setToolbarTransparentWithWhiteBackButton((Activity) getContext(), BuildConfig.FLAVOR);
        AudioPlayManager.getInstance().addListener(this.listener);
        AudioPlayManager.getInstance().startAndBindToServiceIfNeeded();
        this.uiDragLayout = new UIBottomUpDragLayout();
        PlayListFragment playListFragment = new PlayListFragment(this.playableAudioObjects, this.currentPlayingObject.getImageUrl(), new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(final AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: ir.resaneh1.iptv.fragment.BookAudioPlayerFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioPlayManager.getInstance().play((PlayableAudioObject) abstractViewHolder.item);
                    }
                }, 280L);
                BookAudioPlayerFragment.this.uiDragLayout.dragLayout.minimize();
            }
        });
        this.playListFragment = playListFragment;
        playListFragment.createView(getContext());
        this.playListFragment.getFragmentView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.uiDragLayout.createView((Activity) this.mContext, this.playListFragment.getFragmentView());
        this.topFrameLayout.addView(this.uiDragLayout.view);
        initViews(this.currentPlayingObject);
    }

    void initViews(PlayableAudioObject playableAudioObject) {
        try {
            GlideHelper.loadBlur(ApplicationLoader.applicationActivity, (ImageView) findViewById(R.id.imageViewBackground), playableAudioObject.getImageUrl());
            GlideHelper.loadCircle(ApplicationLoader.applicationActivity, (ImageView) findViewById(R.id.imageViewCenterCircle), playableAudioObject.getImageUrl());
            this.titleTextView.setText(playableAudioObject.getTitle());
            this.subtitleTextView.setText(playableAudioObject.getSubtitle());
            this.currentPlayingObject = playableAudioObject;
        } catch (Exception unused) {
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.ringProgressBar = (RingProgressBar) findViewById(R.id.circleProgress);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.playImageView = (ImageView) findViewById(R.id.playImageView);
        this.pauseImageView = (ImageView) findViewById(R.id.pauseImageView);
        this.nextImageView = (ImageView) findViewById(R.id.nextImageView);
        this.previousImageView = (ImageView) findViewById(R.id.previousImageView);
        this.seekBar = (SeekBar) findViewById(R.id.seekbar);
        this.durationTextView = (TextView) findViewById(R.id.textViewDuration);
        this.currentPositionTextView = (TextView) findViewById(R.id.textViewCurrentPosition);
        this.tenSecondNext = (ImageView) findViewById(R.id.forward10SecondImageView);
        this.tenSecondPrevious = (ImageView) findViewById(R.id.back10SecondImageView);
        this.playImageView.setOnClickListener(this.onClickListener);
        this.pauseImageView.setOnClickListener(this.onClickListener);
        this.nextImageView.setOnClickListener(this.onClickListener);
        this.previousImageView.setOnClickListener(this.onClickListener);
        this.tenSecondPrevious.setOnClickListener(this.onClickListener);
        this.tenSecondNext.setOnClickListener(this.onClickListener);
        this.ringProgressBar.setProgress(50);
        this.seekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.titleTextView = (TextView) findViewById(R.id.textViewTitle);
        this.subtitleTextView = (TextView) findViewById(R.id.textViewSubtitle);
        this.topFrameLayout = (FrameLayout) findViewById(R.id.topFrameLayout);
    }
}
