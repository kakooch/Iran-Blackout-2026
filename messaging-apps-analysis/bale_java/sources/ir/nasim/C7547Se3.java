package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.conversation.messages.content.adapter.holder.bubble.voicetotext.AudioToTextImageButton;
import ir.nasim.features.conversation.messages.content.adapter.view.ContentHeightMatchedTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;

/* renamed from: ir.nasim.Se3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7547Se3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ContentHeightMatchedTextView b;
    public final ContentHeightMatchedTextView c;
    public final ContentHeightMatchedTextView d;
    public final AppCompatSeekBar e;
    public final DocumentStateButton f;
    public final FrameLayout g;
    public final ImageView h;
    public final AudioToTextImageButton i;

    private C7547Se3(ConstraintLayout constraintLayout, ContentHeightMatchedTextView contentHeightMatchedTextView, ContentHeightMatchedTextView contentHeightMatchedTextView2, ContentHeightMatchedTextView contentHeightMatchedTextView3, AppCompatSeekBar appCompatSeekBar, DocumentStateButton documentStateButton, FrameLayout frameLayout, ImageView imageView, AudioToTextImageButton audioToTextImageButton) {
        this.a = constraintLayout;
        this.b = contentHeightMatchedTextView;
        this.c = contentHeightMatchedTextView2;
        this.d = contentHeightMatchedTextView3;
        this.e = appCompatSeekBar;
        this.f = documentStateButton;
        this.g = frameLayout;
        this.h = imageView;
        this.i = audioToTextImageButton;
    }

    public static C7547Se3 a(View view) {
        int i = BC5.audio_artist;
        ContentHeightMatchedTextView contentHeightMatchedTextView = (ContentHeightMatchedTextView) AbstractC11738dW7.a(view, i);
        if (contentHeightMatchedTextView != null) {
            i = BC5.audio_details;
            ContentHeightMatchedTextView contentHeightMatchedTextView2 = (ContentHeightMatchedTextView) AbstractC11738dW7.a(view, i);
            if (contentHeightMatchedTextView2 != null) {
                i = BC5.audio_name;
                ContentHeightMatchedTextView contentHeightMatchedTextView3 = (ContentHeightMatchedTextView) AbstractC11738dW7.a(view, i);
                if (contentHeightMatchedTextView3 != null) {
                    i = BC5.audio_seekbar;
                    AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) AbstractC11738dW7.a(view, i);
                    if (appCompatSeekBar != null) {
                        i = BC5.document_state_button;
                        DocumentStateButton documentStateButton = (DocumentStateButton) AbstractC11738dW7.a(view, i);
                        if (documentStateButton != null) {
                            i = BC5.frameLayout;
                            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                            if (frameLayout != null) {
                                i = BC5.more_options;
                                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView != null) {
                                    i = BC5.voiceToTextButton;
                                    AudioToTextImageButton audioToTextImageButton = (AudioToTextImageButton) AbstractC11738dW7.a(view, i);
                                    if (audioToTextImageButton != null) {
                                        return new C7547Se3((ConstraintLayout) view, contentHeightMatchedTextView, contentHeightMatchedTextView2, contentHeightMatchedTextView3, appCompatSeekBar, documentStateButton, frameLayout, imageView, audioToTextImageButton);
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

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
