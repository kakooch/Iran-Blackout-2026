package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;

/* loaded from: classes.dex */
public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    protected interface ListenerInvocation {
        void invokeListener(Player.EventListener listener);
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void seekTo(long positionMs) {
        seekTo(getCurrentWindowIndex(), positionMs);
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

        public ListenerHolder(Player.EventListener listener) {
            this.listener = listener;
        }

        public void invoke(ListenerInvocation listenerInvocation) {
            if (this.released) {
                return;
            }
            listenerInvocation.invokeListener(this.listener);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || ListenerHolder.class != other.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) other).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }
}
