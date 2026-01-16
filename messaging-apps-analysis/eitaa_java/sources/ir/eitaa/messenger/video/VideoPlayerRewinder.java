package ir.eitaa.messenger.video;

import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.Components.VideoPlayer;

/* loaded from: classes.dex */
public class VideoPlayerRewinder {
    private long rewindBackSeekPlayerPosition;
    public boolean rewindByBackSeek;
    public int rewindCount;
    private boolean rewindForward;
    private long rewindLastTime;
    private long rewindLastUpdatePlayerTime;
    private long startRewindFrom;
    private Runnable updateRewindRunnable;
    private VideoPlayer videoPlayer;
    private float playSpeed = 1.0f;
    private final Runnable backSeek = new Runnable() { // from class: ir.eitaa.messenger.video.VideoPlayerRewinder.1
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayerRewinder.this.videoPlayer == null) {
                return;
            }
            long duration = VideoPlayerRewinder.this.videoPlayer.getDuration();
            if (duration == 0 || duration == -9223372036854775807L) {
                VideoPlayerRewinder.this.rewindLastTime = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - VideoPlayerRewinder.this.rewindLastTime;
            VideoPlayerRewinder.this.rewindLastTime = jCurrentTimeMillis;
            VideoPlayerRewinder videoPlayerRewinder = VideoPlayerRewinder.this;
            int i = videoPlayerRewinder.rewindCount;
            long j2 = j * (i == 1 ? 3L : i == 2 ? 6L : 12L);
            if (videoPlayerRewinder.rewindForward) {
                VideoPlayerRewinder.access$314(VideoPlayerRewinder.this, j2);
            } else {
                VideoPlayerRewinder.access$322(VideoPlayerRewinder.this, j2);
            }
            if (VideoPlayerRewinder.this.rewindBackSeekPlayerPosition < 0) {
                VideoPlayerRewinder.this.rewindBackSeekPlayerPosition = 0L;
            } else if (VideoPlayerRewinder.this.rewindBackSeekPlayerPosition > duration) {
                VideoPlayerRewinder.this.rewindBackSeekPlayerPosition = duration;
            }
            VideoPlayerRewinder videoPlayerRewinder2 = VideoPlayerRewinder.this;
            if (videoPlayerRewinder2.rewindByBackSeek && videoPlayerRewinder2.videoPlayer != null && VideoPlayerRewinder.this.rewindLastTime - VideoPlayerRewinder.this.rewindLastUpdatePlayerTime > 350) {
                VideoPlayerRewinder videoPlayerRewinder3 = VideoPlayerRewinder.this;
                videoPlayerRewinder3.rewindLastUpdatePlayerTime = videoPlayerRewinder3.rewindLastTime;
                VideoPlayerRewinder.this.videoPlayer.seekTo(VideoPlayerRewinder.this.rewindBackSeekPlayerPosition);
            }
            if (VideoPlayerRewinder.this.videoPlayer != null) {
                VideoPlayerRewinder videoPlayerRewinder4 = VideoPlayerRewinder.this;
                videoPlayerRewinder4.updateRewindProgressUi(VideoPlayerRewinder.this.rewindBackSeekPlayerPosition - VideoPlayerRewinder.this.startRewindFrom, VideoPlayerRewinder.this.rewindBackSeekPlayerPosition / VideoPlayerRewinder.this.videoPlayer.getDuration(), videoPlayerRewinder4.rewindByBackSeek);
            }
            if (VideoPlayerRewinder.this.rewindBackSeekPlayerPosition == 0 || VideoPlayerRewinder.this.rewindBackSeekPlayerPosition >= duration) {
                VideoPlayerRewinder videoPlayerRewinder5 = VideoPlayerRewinder.this;
                if (videoPlayerRewinder5.rewindByBackSeek && videoPlayerRewinder5.videoPlayer != null) {
                    VideoPlayerRewinder videoPlayerRewinder6 = VideoPlayerRewinder.this;
                    videoPlayerRewinder6.rewindLastUpdatePlayerTime = videoPlayerRewinder6.rewindLastTime;
                    VideoPlayerRewinder.this.videoPlayer.seekTo(VideoPlayerRewinder.this.rewindBackSeekPlayerPosition);
                }
                VideoPlayerRewinder.this.cancelRewind();
            }
            VideoPlayerRewinder videoPlayerRewinder7 = VideoPlayerRewinder.this;
            if (videoPlayerRewinder7.rewindCount > 0) {
                AndroidUtilities.runOnUIThread(videoPlayerRewinder7.backSeek, 16L);
            }
        }
    };

    protected void onRewindCanceled() {
    }

    protected void onRewindStart(boolean rewindForward) {
    }

    protected void updateRewindProgressUi(long timeDiff, float progress, boolean rewindByBackSeek) {
    }

    static /* synthetic */ long access$314(VideoPlayerRewinder videoPlayerRewinder, long j) {
        long j2 = videoPlayerRewinder.rewindBackSeekPlayerPosition + j;
        videoPlayerRewinder.rewindBackSeekPlayerPosition = j2;
        return j2;
    }

    static /* synthetic */ long access$322(VideoPlayerRewinder videoPlayerRewinder, long j) {
        long j2 = videoPlayerRewinder.rewindBackSeekPlayerPosition - j;
        videoPlayerRewinder.rewindBackSeekPlayerPosition = j2;
        return j2;
    }

    public void startRewind(VideoPlayer videoPlayer, boolean forward, float playbackSpeed) {
        this.videoPlayer = videoPlayer;
        this.playSpeed = playbackSpeed;
        this.rewindForward = forward;
        cancelRewind();
        incrementRewindCount();
    }

    public void cancelRewind() {
        if (this.rewindCount != 0) {
            this.rewindCount = 0;
            VideoPlayer videoPlayer = this.videoPlayer;
            if (videoPlayer != null) {
                if (this.rewindByBackSeek) {
                    videoPlayer.seekTo(this.rewindBackSeekPlayerPosition);
                } else {
                    this.videoPlayer.seekTo(videoPlayer.getCurrentPosition());
                }
                this.videoPlayer.setPlaybackSpeed(this.playSpeed);
            }
        }
        AndroidUtilities.cancelRunOnUIThread(this.backSeek);
        Runnable runnable = this.updateRewindRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.updateRewindRunnable = null;
        }
        onRewindCanceled();
    }

    private void incrementRewindCount() {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        int i = this.rewindCount + 1;
        this.rewindCount = i;
        boolean z = false;
        if (i == 1) {
            if (this.rewindForward && videoPlayer.isPlaying()) {
                this.rewindByBackSeek = false;
            } else {
                this.rewindByBackSeek = true;
            }
        }
        if (this.rewindForward && !this.rewindByBackSeek) {
            int i2 = this.rewindCount;
            if (i2 == 1) {
                this.videoPlayer.setPlaybackSpeed(4.0f);
            } else if (i2 == 2) {
                this.videoPlayer.setPlaybackSpeed(7.0f);
            } else {
                this.videoPlayer.setPlaybackSpeed(13.0f);
            }
            z = true;
        } else {
            int i3 = this.rewindCount;
            if (i3 == 1 || i3 == 2) {
                z = true;
            }
        }
        if (this.rewindCount == 1) {
            this.rewindBackSeekPlayerPosition = this.videoPlayer.getCurrentPosition();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.rewindLastTime = jCurrentTimeMillis;
            this.rewindLastUpdatePlayerTime = jCurrentTimeMillis;
            this.startRewindFrom = this.videoPlayer.getCurrentPosition();
            onRewindStart(this.rewindForward);
        }
        AndroidUtilities.cancelRunOnUIThread(this.backSeek);
        AndroidUtilities.runOnUIThread(this.backSeek);
        if (z) {
            Runnable runnable = this.updateRewindRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.messenger.video.-$$Lambda$VideoPlayerRewinder$3hLegZqKEvqaHiCg-XXOq6sLDiI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$incrementRewindCount$0$VideoPlayerRewinder();
                }
            };
            this.updateRewindRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$incrementRewindCount$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$incrementRewindCount$0$VideoPlayerRewinder() {
        this.updateRewindRunnable = null;
        incrementRewindCount();
    }

    public float getVideoProgress() {
        return this.rewindBackSeekPlayerPosition / this.videoPlayer.getDuration();
    }
}
