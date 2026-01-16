package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes2.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    long a;
    boolean b;
    boolean c;
    boolean d;
    private final Runnable e;
    private final Runnable f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.b = false;
        this.a = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.c = false;
        if (this.d) {
            return;
        }
        this.a = System.currentTimeMillis();
        setVisibility(0);
    }

    private void e() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = -1L;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new Runnable() { // from class: ir.nasim.Uk1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };
        this.f = new Runnable() { // from class: ir.nasim.Vk1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d();
            }
        };
    }
}
