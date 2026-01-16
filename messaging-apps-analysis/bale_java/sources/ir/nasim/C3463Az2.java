package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.story.ui.viewfragment.views.PreparingStoryView;
import ja.burhanrashid52.photoeditor.PhotoEditorView;

/* renamed from: ir.nasim.Az2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3463Az2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Barrier b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ConstraintLayout h;
    public final ImageView i;
    public final ImageView j;
    public final ConstraintLayout k;
    public final ConstraintLayout l;
    public final PhotoEditorView m;
    public final PreparingStoryView n;
    public final ImageView o;
    public final ConstraintLayout p;
    public final AppCompatTextView q;
    public final AppCompatCheckBox r;
    public final LinearLayoutCompat s;
    public final ImageView t;
    public final TextView u;
    public final ImageView v;
    public final ConstraintLayout w;
    public final ImageView x;
    public final TextView y;
    public final ImageView z;

    private C3463Az2(ConstraintLayout constraintLayout, Barrier barrier, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, PhotoEditorView photoEditorView, PreparingStoryView preparingStoryView, ImageView imageView7, ConstraintLayout constraintLayout6, AppCompatTextView appCompatTextView, AppCompatCheckBox appCompatCheckBox, LinearLayoutCompat linearLayoutCompat, ImageView imageView8, TextView textView, ImageView imageView9, ConstraintLayout constraintLayout7, ImageView imageView10, TextView textView2, ImageView imageView11) {
        this.a = constraintLayout;
        this.b = barrier;
        this.c = constraintLayout2;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = constraintLayout3;
        this.i = imageView5;
        this.j = imageView6;
        this.k = constraintLayout4;
        this.l = constraintLayout5;
        this.m = photoEditorView;
        this.n = preparingStoryView;
        this.o = imageView7;
        this.p = constraintLayout6;
        this.q = appCompatTextView;
        this.r = appCompatCheckBox;
        this.s = linearLayoutCompat;
        this.t = imageView8;
        this.u = textView;
        this.v = imageView9;
        this.w = constraintLayout7;
        this.x = imageView10;
        this.y = textView2;
        this.z = imageView11;
    }

    public static C3463Az2 a(View view) {
        int i = AbstractC18172oC5.bottomBarBarrier;
        Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
        if (barrier != null) {
            i = AbstractC18172oC5.bottom_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = AbstractC18172oC5.change_background_icon;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC18172oC5.close_link_editor;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        i = AbstractC18172oC5.draw_icon;
                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView3 != null) {
                            i = AbstractC18172oC5.edit_link;
                            ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView4 != null) {
                                i = AbstractC18172oC5.editor_container;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout2 != null) {
                                    i = AbstractC18172oC5.go_back;
                                    ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView5 != null) {
                                        i = AbstractC18172oC5.insert_link;
                                        ImageView imageView6 = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView6 != null) {
                                            i = AbstractC18172oC5.link_editor_layout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                            if (constraintLayout3 != null) {
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                i = AbstractC18172oC5.photoEditorView;
                                                PhotoEditorView photoEditorView = (PhotoEditorView) AbstractC11738dW7.a(view, i);
                                                if (photoEditorView != null) {
                                                    i = AbstractC18172oC5.preparingStoryView;
                                                    PreparingStoryView preparingStoryView = (PreparingStoryView) AbstractC11738dW7.a(view, i);
                                                    if (preparingStoryView != null) {
                                                        i = AbstractC18172oC5.remove_link;
                                                        ImageView imageView7 = (ImageView) AbstractC11738dW7.a(view, i);
                                                        if (imageView7 != null) {
                                                            i = AbstractC18172oC5.storyLinkLayout;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                            if (constraintLayout5 != null) {
                                                                i = AbstractC18172oC5.story_link_text;
                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                                                                if (appCompatTextView != null) {
                                                                    i = AbstractC18172oC5.tag_checkbox;
                                                                    AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) AbstractC11738dW7.a(view, i);
                                                                    if (appCompatCheckBox != null) {
                                                                        i = AbstractC18172oC5.tag_container;
                                                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) AbstractC11738dW7.a(view, i);
                                                                        if (linearLayoutCompat != null) {
                                                                            i = AbstractC18172oC5.tag_icon;
                                                                            ImageView imageView8 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                            if (imageView8 != null) {
                                                                                i = AbstractC18172oC5.tag_title;
                                                                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView != null) {
                                                                                    i = AbstractC18172oC5.text_icon;
                                                                                    ImageView imageView9 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                    if (imageView9 != null) {
                                                                                        i = AbstractC18172oC5.top_layout;
                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                        if (constraintLayout6 != null) {
                                                                                            i = AbstractC18172oC5.undo_icon;
                                                                                            ImageView imageView10 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                            if (imageView10 != null) {
                                                                                                i = AbstractC18172oC5.upload_button;
                                                                                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                if (textView2 != null) {
                                                                                                    i = AbstractC18172oC5.view_link;
                                                                                                    ImageView imageView11 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                    if (imageView11 != null) {
                                                                                                        return new C3463Az2(constraintLayout4, barrier, constraintLayout, imageView, imageView2, imageView3, imageView4, constraintLayout2, imageView5, imageView6, constraintLayout3, constraintLayout4, photoEditorView, preparingStoryView, imageView7, constraintLayout5, appCompatTextView, appCompatCheckBox, linearLayoutCompat, imageView8, textView, imageView9, constraintLayout6, imageView10, textView2, imageView11);
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

    public static C3463Az2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story_upload, viewGroup, false);
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
