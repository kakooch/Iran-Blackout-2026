package ir.resaneh1.iptv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.musicplayer.AudioPlayManager;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class PlayListPresenter extends AbstractPresenter<PlayableAudioObject, ViewHolder> {
    public PlayListPresenter(Context context) {
        super(context);
        DimensionHelper.dpToPx(context, 8.0f);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.playlist_row, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, PlayableAudioObject playableAudioObject) {
        super.onBindViewHolder((PlayListPresenter) viewHolder, (ViewHolder) playableAudioObject);
        viewHolder.textView.setText(playableAudioObject.getTitle());
        viewHolder.textViewDuration.setText(playableAudioObject.getDurationString());
        GlideHelper.loadRoundedCorner(this.context, viewHolder.imageView, playableAudioObject.getImageUrl());
        PlayableAudioObject currentPlayingObject = AudioPlayManager.getInstance().getCurrentPlayingObject();
        if (currentPlayingObject != null && currentPlayingObject.getId().equals(playableAudioObject.getId())) {
            viewHolder.progressBar.setMax(AudioPlayManager.getInstance().getDuration(currentPlayingObject));
            viewHolder.progressBar.setProgress(AudioPlayManager.getInstance().getCurrentPosition(currentPlayingObject));
            viewHolder.progressBar.setVisibility(0);
        } else {
            viewHolder.progressBar.setVisibility(4);
        }
        if (playableAudioObject.type == PlayableAudioObject.Type.aod) {
            viewHolder.textView2.setVisibility(0);
            viewHolder.textView2.setText(playableAudioObject.getSubtitle());
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<PlayableAudioObject> {
        ImageView imageView;
        public ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        TextView textViewDuration;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.textViewDuration = (TextView) view.findViewById(R.id.textViewDuration);
            this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }
}
