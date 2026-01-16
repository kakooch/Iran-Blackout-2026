package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import java.io.IOException;

/* renamed from: ir.nasim.aN4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9680aN4 {
    public static final a b = new a(null);
    public static final int c = 8;
    private MediaPlayer a;

    /* renamed from: ir.nasim.aN4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final Uri b(Context context) {
        return Uri.parse("android.resource://" + context.getPackageName() + Separators.SLASH + AbstractC19954rD5.call_waiting_sound);
    }

    private final void d() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            this.a = null;
        } catch (Exception e) {
            C19406qI3.j("OutgoingRinger", "onDestroy: " + e.getMessage(), new Object[0]);
        }
    }

    private final void e(MediaPlayer mediaPlayer) throws IllegalArgumentException {
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(1).setUsage(2).build());
    }

    private final void g(final MediaPlayer mediaPlayer, Context context) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            mediaPlayer.setDataSource(context, b(context));
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: ir.nasim.ZM4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer2) throws IllegalStateException {
                    C9680aN4.h(mediaPlayer, mediaPlayer2);
                }
            });
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            C19406qI3.d("OutgoingRinger", e);
            MediaPlayer mediaPlayer2 = this.a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) throws IllegalStateException {
        AbstractC13042fc3.i(mediaPlayer, "$this_startPlaying");
        mediaPlayer.start();
    }

    public final void c() throws IllegalStateException {
        d();
    }

    public final void f(Context context) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        AbstractC13042fc3.i(context, "context");
        d();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        e(mediaPlayer);
        mediaPlayer.setLooping(true);
        g(mediaPlayer, context);
    }
}
