package com.google.android.exoplayer2t;

import com.google.android.exoplayer2t.Player;
import com.google.android.exoplayer2t.Timeline;

/* loaded from: classes.dex */
public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    protected interface ListenerInvocation {
        void invokeListener(Player.EventListener eventListener);
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    public final void stop() {
        stop(false);
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    protected static final class ListenerHolder {
        public final Player.EventListener listener;
        private boolean released;

        public ListenerHolder(Player.EventListener eventListener) {
            this.listener = eventListener;
        }

        public void invoke(ListenerInvocation listenerInvocation) {
            if (this.released) {
                return;
            }
            listenerInvocation.invokeListener(this.listener);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }
}
