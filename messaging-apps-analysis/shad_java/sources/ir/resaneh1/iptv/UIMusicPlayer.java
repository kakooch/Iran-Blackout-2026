package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.musicplayer.AudioPlayManager;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class UIMusicPlayer {
    public AODObjectAbs aodObjectAbs;
    public TextView endTextView;
    public ImageView imageView;
    public ImageView imageViewBackground;
    private View pauseImageView;
    public ImageView playImageView;
    public View progressBar;
    SeekBar seekBar;
    public TextView startTextView;
    public TextView textViewBody;
    public TextView textViewTitle;
    public View view;
    private int currentAccount = UserConfig.selectedAccount;
    private ArrayList<PlayableAudioObject> playerList = new ArrayList<>();
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.UIMusicPlayer.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UIMusicPlayer uIMusicPlayer = UIMusicPlayer.this;
            if (view != uIMusicPlayer.playImageView) {
                if (view == uIMusicPlayer.pauseImageView) {
                    AudioPlayManager audioPlayManager = AudioPlayManager.getInstance();
                    UIMusicPlayer uIMusicPlayer2 = UIMusicPlayer.this;
                    audioPlayManager.pause(new PlayableAudioObject(uIMusicPlayer2.aodObjectAbs, uIMusicPlayer2.currentAccount));
                    return;
                }
                return;
            }
            AudioPlayManager audioPlayManager2 = AudioPlayManager.getInstance();
            UIMusicPlayer uIMusicPlayer3 = UIMusicPlayer.this;
            audioPlayManager2.play(new PlayableAudioObject(uIMusicPlayer3.aodObjectAbs, uIMusicPlayer3.currentAccount));
            if (UIMusicPlayer.this.playerList.size() == 0) {
                ArrayList arrayList = UIMusicPlayer.this.playerList;
                UIMusicPlayer uIMusicPlayer4 = UIMusicPlayer.this;
                arrayList.add(new PlayableAudioObject(uIMusicPlayer4.aodObjectAbs, uIMusicPlayer4.currentAccount));
            }
            AudioPlayManager.getInstance().setPlayList(UIMusicPlayer.this.playerList);
        }
    };
    public AudioPlayManager.Listener listener = new AudioPlayManager.Listener() { // from class: ir.resaneh1.iptv.UIMusicPlayer.2
        @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
        public void updateView() {
            UIMusicPlayer uIMusicPlayer = UIMusicPlayer.this;
            PlayableAudioObject playableAudioObject = new PlayableAudioObject(uIMusicPlayer.aodObjectAbs, uIMusicPlayer.currentAccount);
            PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
            if (currentPlayingObject == null || !currentPlayingObject.getId().equals(playableAudioObject.getId())) {
                UIMusicPlayer.this.progressBar.setVisibility(4);
                UIMusicPlayer.this.endTextView.setVisibility(4);
                UIMusicPlayer.this.startTextView.setVisibility(4);
                UIMusicPlayer.this.seekBar.setVisibility(4);
            } else {
                UIMusicPlayer.this.progressBar.setVisibility(0);
                UIMusicPlayer.this.endTextView.setVisibility(0);
                UIMusicPlayer.this.startTextView.setVisibility(0);
                UIMusicPlayer.this.seekBar.setVisibility(0);
            }
            if (AudioPlayManager.getInstance().isVisiblePlayButton(playableAudioObject)) {
                UIMusicPlayer.this.playImageView.setVisibility(0);
            } else {
                UIMusicPlayer.this.playImageView.setVisibility(4);
            }
            if (AudioPlayManager.getInstance().isVisiblePauseButton(playableAudioObject)) {
                UIMusicPlayer.this.pauseImageView.setVisibility(0);
            } else {
                UIMusicPlayer.this.pauseImageView.setVisibility(4);
            }
            if (AudioPlayManager.getInstance().isVisibleProgressView(playableAudioObject)) {
                UIMusicPlayer.this.progressBar.setVisibility(0);
            } else {
                UIMusicPlayer.this.progressBar.setVisibility(4);
            }
            updateProgress();
        }

        @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
        public void updateProgress() {
            UIMusicPlayer uIMusicPlayer = UIMusicPlayer.this;
            PlayableAudioObject playableAudioObject = new PlayableAudioObject(uIMusicPlayer.aodObjectAbs, uIMusicPlayer.currentAccount);
            UIMusicPlayer.this.startTextView.setText(AudioPlayManager.getInstance().getCurrentPositionText(playableAudioObject));
            UIMusicPlayer.this.endTextView.setText(AudioPlayManager.getInstance().getDurationText(playableAudioObject));
            UIMusicPlayer.this.seekBar.setMax(AudioPlayManager.getInstance().getDuration(playableAudioObject));
            UIMusicPlayer.this.seekBar.setProgress(AudioPlayManager.getInstance().getCurrentPosition(playableAudioObject));
        }

        @Override // ir.resaneh1.iptv.musicplayer.AudioPlayManager.Listener
        public void updateJustProgressText(String str) {
            UIMusicPlayer.this.startTextView.setText(str);
        }
    };
    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: ir.resaneh1.iptv.UIMusicPlayer.3
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                AudioPlayManager audioPlayManager = AudioPlayManager.getInstance();
                UIMusicPlayer uIMusicPlayer = UIMusicPlayer.this;
                audioPlayManager.seekByUser(new PlayableAudioObject(uIMusicPlayer.aodObjectAbs, uIMusicPlayer.currentAccount), i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            AudioPlayManager audioPlayManager = AudioPlayManager.getInstance();
            UIMusicPlayer uIMusicPlayer = UIMusicPlayer.this;
            audioPlayManager.startSeekBarTouch(new PlayableAudioObject(uIMusicPlayer.aodObjectAbs, uIMusicPlayer.currentAccount));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            AudioPlayManager audioPlayManager = AudioPlayManager.getInstance();
            UIMusicPlayer uIMusicPlayer = UIMusicPlayer.this;
            audioPlayManager.stopSeekbarTouchUser(new PlayableAudioObject(uIMusicPlayer.aodObjectAbs, uIMusicPlayer.currentAccount), seekBar.getProgress());
        }
    };

    public View createView(Activity activity, AODObjectAbs aODObjectAbs) {
        this.aodObjectAbs = aODObjectAbs;
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.row_music_player, (ViewGroup) null);
        this.view = viewInflate;
        this.progressBar = viewInflate.findViewById(R.id.progressBar);
        this.textViewTitle = (TextView) this.view.findViewById(R.id.textView1);
        this.textViewBody = (TextView) this.view.findViewById(R.id.textView2);
        this.startTextView = (TextView) this.view.findViewById(R.id.startText);
        this.endTextView = (TextView) this.view.findViewById(R.id.endText);
        this.seekBar = (SeekBar) this.view.findViewById(R.id.musicSeekBar);
        this.playImageView = (ImageView) this.view.findViewById(R.id.imageViewPlay);
        this.pauseImageView = this.view.findViewById(R.id.imageViewPause);
        this.imageView = (ImageView) this.view.findViewById(R.id.imageView);
        this.imageViewBackground = (ImageView) this.view.findViewById(R.id.imageViewBackground);
        this.playImageView.setOnClickListener(this.onClickListener);
        this.pauseImageView.setOnClickListener(this.onClickListener);
        FrameLayout frameLayout = (FrameLayout) this.view.findViewById(R.id.frameLayout);
        frameLayout.getLayoutParams().height = DimensionHelper.getHeaderHeight(activity) - AndroidUtilities.dp(64.0f);
        frameLayout.getLayoutParams().width = frameLayout.getLayoutParams().height;
        ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).setMargins(0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        ((FrameLayout.LayoutParams) ((FrameLayout) this.view.findViewById(R.id.frameLayout2)).getLayoutParams()).setMargins(0, AndroidUtilities.dp(8.0f), frameLayout.getLayoutParams().width + AndroidUtilities.dp(16.0f), AndroidUtilities.dp(32.0f));
        GlideHelper.load(activity, this.imageView, aODObjectAbs.image_url, R.color.grey_600);
        GlideHelper.load(activity, this.imageViewBackground, aODObjectAbs.image_url, R.color.grey_600);
        this.seekBar.setOnSeekBarChangeListener(this.onSeekBarChangeListener);
        this.progressBar.setVisibility(4);
        this.endTextView.setVisibility(4);
        this.startTextView.setVisibility(4);
        this.seekBar.setVisibility(4);
        return this.view;
    }

    public void setPlayerList(ArrayList<AODObjectAbs> arrayList) {
        ArrayList<PlayableAudioObject> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<AODObjectAbs> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PlayableAudioObject(it.next(), this.currentAccount));
        }
        arrayList2.add(new PlayableAudioObject(this.aodObjectAbs, this.currentAccount));
        this.playerList = arrayList2;
        PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
        if (currentPlayingObject == null || this.aodObjectAbs == null || !currentPlayingObject.getId().equals(this.aodObjectAbs.track_id)) {
            return;
        }
        AudioPlayManager.getInstance().setPlayList(arrayList2);
    }
}
