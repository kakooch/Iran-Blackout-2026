package ir.nasim;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.videoplayer.ui.component.ScrollableCaption;
import ir.nasim.videoplayer.ui.component.ThumbnailContainer;
import ir.nasim.videoplayer.ui.component.VideoPlayerControllerView;
import ir.nasim.videoplayer.ui.component.button.PlayerStateButton;
import ir.nasim.videoplayer.ui.component.photoview.PhotoView;

/* renamed from: ir.nasim.Fr4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4568Fr4 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AspectRatioFrameLayout b;
    public final VideoPlayerControllerView c;
    public final ThumbnailContainer d;
    public final ThumbnailContainer e;
    public final ThumbnailContainer f;
    public final PlayerStateButton g;
    public final PlayerStateButton h;
    public final PlayerStateButton i;
    public final ScrollableCaption j;
    public final TextureView k;
    public final PhotoView l;
    public final PhotoView m;
    public final PhotoView n;
    public final BaleToolbar o;
    public final LinearLayout p;

    private C4568Fr4(ConstraintLayout constraintLayout, AspectRatioFrameLayout aspectRatioFrameLayout, VideoPlayerControllerView videoPlayerControllerView, ThumbnailContainer thumbnailContainer, ThumbnailContainer thumbnailContainer2, ThumbnailContainer thumbnailContainer3, PlayerStateButton playerStateButton, PlayerStateButton playerStateButton2, PlayerStateButton playerStateButton3, ScrollableCaption scrollableCaption, TextureView textureView, PhotoView photoView, PhotoView photoView2, PhotoView photoView3, BaleToolbar baleToolbar, LinearLayout linearLayout) {
        this.a = constraintLayout;
        this.b = aspectRatioFrameLayout;
        this.c = videoPlayerControllerView;
        this.d = thumbnailContainer;
        this.e = thumbnailContainer2;
        this.f = thumbnailContainer3;
        this.g = playerStateButton;
        this.h = playerStateButton2;
        this.i = playerStateButton3;
        this.j = scrollableCaption;
        this.k = textureView;
        this.l = photoView;
        this.m = photoView2;
        this.n = photoView3;
        this.o = baleToolbar;
        this.p = linearLayout;
    }

    public static C4568Fr4 a(View view) {
        int i = AbstractC19945rC5.aspectRatioFrameLayout;
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) AbstractC11738dW7.a(view, i);
        if (aspectRatioFrameLayout != null) {
            i = AbstractC19945rC5.controller;
            VideoPlayerControllerView videoPlayerControllerView = (VideoPlayerControllerView) AbstractC11738dW7.a(view, i);
            if (videoPlayerControllerView != null) {
                i = AbstractC19945rC5.page1;
                ThumbnailContainer thumbnailContainer = (ThumbnailContainer) AbstractC11738dW7.a(view, i);
                if (thumbnailContainer != null) {
                    i = AbstractC19945rC5.page2;
                    ThumbnailContainer thumbnailContainer2 = (ThumbnailContainer) AbstractC11738dW7.a(view, i);
                    if (thumbnailContainer2 != null) {
                        i = AbstractC19945rC5.page3;
                        ThumbnailContainer thumbnailContainer3 = (ThumbnailContainer) AbstractC11738dW7.a(view, i);
                        if (thumbnailContainer3 != null) {
                            i = AbstractC19945rC5.playerStateButton1;
                            PlayerStateButton playerStateButton = (PlayerStateButton) AbstractC11738dW7.a(view, i);
                            if (playerStateButton != null) {
                                i = AbstractC19945rC5.playerStateButton2;
                                PlayerStateButton playerStateButton2 = (PlayerStateButton) AbstractC11738dW7.a(view, i);
                                if (playerStateButton2 != null) {
                                    i = AbstractC19945rC5.playerStateButton3;
                                    PlayerStateButton playerStateButton3 = (PlayerStateButton) AbstractC11738dW7.a(view, i);
                                    if (playerStateButton3 != null) {
                                        i = AbstractC19945rC5.scrollableCaption;
                                        ScrollableCaption scrollableCaption = (ScrollableCaption) AbstractC11738dW7.a(view, i);
                                        if (scrollableCaption != null) {
                                            i = AbstractC19945rC5.textureView;
                                            TextureView textureView = (TextureView) AbstractC11738dW7.a(view, i);
                                            if (textureView != null) {
                                                i = AbstractC19945rC5.thumbnailImageView1;
                                                PhotoView photoView = (PhotoView) AbstractC11738dW7.a(view, i);
                                                if (photoView != null) {
                                                    i = AbstractC19945rC5.thumbnailImageView2;
                                                    PhotoView photoView2 = (PhotoView) AbstractC11738dW7.a(view, i);
                                                    if (photoView2 != null) {
                                                        i = AbstractC19945rC5.thumbnailImageView3;
                                                        PhotoView photoView3 = (PhotoView) AbstractC11738dW7.a(view, i);
                                                        if (photoView3 != null) {
                                                            i = AbstractC19945rC5.toolbar;
                                                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                            if (baleToolbar != null) {
                                                                i = AbstractC19945rC5.viewerBar;
                                                                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                if (linearLayout != null) {
                                                                    return new C4568Fr4((ConstraintLayout) view, aspectRatioFrameLayout, videoPlayerControllerView, thumbnailContainer, thumbnailContainer2, thumbnailContainer3, playerStateButton, playerStateButton2, playerStateButton3, scrollableCaption, textureView, photoView, photoView2, photoView3, baleToolbar, linearLayout);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4568Fr4 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C4568Fr4 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(UC5.new_activity_video_player, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
