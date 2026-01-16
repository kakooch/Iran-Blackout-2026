package ir.nasim;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Group;
import ir.nasim.videoplayer.ui.component.seekbar.VideoPlayerSeekbar;

/* loaded from: classes8.dex */
public final class NT7 implements InterfaceC9764aW7 {
    private final View a;
    public final FrameLayout b;
    public final ScrollView c;
    public final AppCompatTextView d;
    public final TextView e;
    public final Group f;
    public final VideoPlayerSeekbar g;
    public final TextureView h;
    public final AppCompatImageView i;
    public final Barrier j;
    public final AppCompatImageView k;

    private NT7(View view, FrameLayout frameLayout, ScrollView scrollView, AppCompatTextView appCompatTextView, TextView textView, Group group, VideoPlayerSeekbar videoPlayerSeekbar, TextureView textureView, AppCompatImageView appCompatImageView, Barrier barrier, AppCompatImageView appCompatImageView2) {
        this.a = view;
        this.b = frameLayout;
        this.c = scrollView;
        this.d = appCompatTextView;
        this.e = textView;
        this.f = group;
        this.g = videoPlayerSeekbar;
        this.h = textureView;
        this.i = appCompatImageView;
        this.j = barrier;
        this.k = appCompatImageView2;
    }

    public static NT7 a(View view) {
        int i = AbstractC19945rC5.captionContainer;
        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
        if (frameLayout != null) {
            i = AbstractC19945rC5.captionScrollView;
            ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
            if (scrollView != null) {
                i = AbstractC19945rC5.captionTextView;
                AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                if (appCompatTextView != null) {
                    i = AbstractC19945rC5.durationInfoTextView;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = AbstractC19945rC5.playerGroup;
                        Group group = (Group) AbstractC11738dW7.a(view, i);
                        if (group != null) {
                            i = AbstractC19945rC5.positionSeekbar;
                            VideoPlayerSeekbar videoPlayerSeekbar = (VideoPlayerSeekbar) AbstractC11738dW7.a(view, i);
                            if (videoPlayerSeekbar != null) {
                                i = AbstractC19945rC5.previewTextureView;
                                TextureView textureView = (TextureView) AbstractC11738dW7.a(view, i);
                                if (textureView != null) {
                                    i = AbstractC19945rC5.resizeImageButton;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                    if (appCompatImageView != null) {
                                        i = AbstractC19945rC5.seekbarBarrier;
                                        Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
                                        if (barrier != null) {
                                            i = AbstractC19945rC5.speedImageButton;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                            if (appCompatImageView2 != null) {
                                                return new NT7(view, frameLayout, scrollView, appCompatTextView, textView, group, videoPlayerSeekbar, textureView, appCompatImageView, barrier, appCompatImageView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NT7 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(UC5.video_player_controller_view, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
