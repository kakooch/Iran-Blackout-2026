package ir.nasim;

import android.media.MediaPlayer;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.VideoView;

/* loaded from: classes6.dex */
public abstract class ZS7 extends WebChromeClient implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private View a;
    private ViewGroup b;
    private View c = null;
    private WebView d = null;
    private boolean e = false;
    private FrameLayout f;
    private WebChromeClient.CustomViewCallback g;

    public ZS7(View view, ViewGroup viewGroup) {
        this.a = view;
        this.b = viewGroup;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        View view = this.c;
        if (view == null) {
            return super.getVideoLoadingProgressView();
        }
        view.setVisibility(0);
        return this.c;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.e) {
            this.b.removeView(this.f);
            this.a.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback = this.g;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains(".chromium.")) {
                this.g.onCustomViewHidden();
            }
            this.e = false;
            this.f = null;
            this.g = null;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.e = true;
            this.f = frameLayout;
            this.g = customViewCallback;
            this.a.setVisibility(4);
            this.b.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
            this.b.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
                return;
            }
            WebView webView = this.d;
            if (webView != null && webView.getSettings().getJavaScriptEnabled() && (focusedChild instanceof SurfaceView)) {
                this.d.loadUrl((((((((("javascript:var _ytrp_html5_video_last;") + "var _ytrp_html5_video = document.getElementsByTagName('video')[0];") + "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {") + "_ytrp_html5_video_last = _ytrp_html5_video;") + "function _ytrp_html5_video_ended() {") + "_VideoEnabledWebView.notifyVideoEnd();") + "}") + "_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);") + "}");
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }
}
