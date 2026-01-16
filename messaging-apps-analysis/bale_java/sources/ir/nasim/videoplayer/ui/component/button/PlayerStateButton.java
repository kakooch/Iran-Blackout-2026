package ir.nasim.videoplayer.ui.component.button;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C8499Wf5;
import ir.nasim.DG3;
import ir.nasim.ED1;
import ir.nasim.JA5;
import ir.nasim.KB5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lir/nasim/videoplayer/ui/component/button/PlayerStateButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "Lir/nasim/rB7;", "onMeasure", "(II)V", "c", "()V", "e", "d", "Lir/nasim/videoplayer/ui/component/button/PlayerStateButton$b;", "Lir/nasim/videoplayer/ui/component/button/PlayerStateButton$b;", "currentState", "Lir/nasim/DG3;", "Lir/nasim/DG3;", "loadingDrawable", "Lir/nasim/Wf5;", "f", "Lir/nasim/Wf5;", "playPauseDrawable", "g", "b", "a", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class PlayerStateButton extends AppCompatImageView {
    private static final a g = new a(null);
    private static final int h = (int) ((60 * AbstractC3742Cd6.c()) + 0.5d);

    /* renamed from: d, reason: from kotlin metadata */
    private b currentState;

    /* renamed from: e, reason: from kotlin metadata */
    private final DG3 loadingDrawable;

    /* renamed from: f, reason: from kotlin metadata */
    private final C8499Wf5 playPauseDrawable;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static abstract class b {

        public static final class a extends b {
            public static final a a = new a();

            private a() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -168869585;
            }

            public String toString() {
                return "Idle";
            }
        }

        /* renamed from: ir.nasim.videoplayer.ui.component.button.PlayerStateButton$b$b, reason: collision with other inner class name */
        public static final class C1723b extends b {
            public static final C1723b a = new C1723b();

            private C1723b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C1723b);
            }

            public int hashCode() {
                return 1580244481;
            }

            public String toString() {
                return "Loading";
            }
        }

        public static final class c extends b {
            private final boolean a;

            public c(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && this.a == ((c) obj).a;
            }

            public int hashCode() {
                return Boolean.hashCode(this.a);
            }

            public String toString() {
                return "Ready(isPlaying=" + this.a + Separators.RPAREN;
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerStateButton(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final void c() {
        b bVar = this.currentState;
        b.C1723b c1723b = b.C1723b.a;
        if (!AbstractC13042fc3.d(bVar, c1723b)) {
            setImageDrawable(this.loadingDrawable);
            this.playPauseDrawable.e(false);
            DG3.b(this.loadingDrawable, 30, false, 2, null);
        }
        this.currentState = c1723b;
    }

    public final void d() {
        b bVar = this.currentState;
        if (!(bVar instanceof b.c)) {
            setImageDrawable(this.playPauseDrawable);
            this.playPauseDrawable.e(false);
        } else if (((b.c) bVar).a()) {
            C8499Wf5.f(this.playPauseDrawable, false, 1, null);
        }
        this.currentState = new b.c(false);
    }

    public final void e() {
        b bVar = this.currentState;
        if (!(bVar instanceof b.c)) {
            setImageDrawable(this.playPauseDrawable);
            this.playPauseDrawable.c(false);
        } else if (!((b.c) bVar).a()) {
            C8499Wf5.d(this.playPauseDrawable, false, 1, null);
        }
        this.currentState = new b.c(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMin = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), Math.min(View.MeasureSpec.getSize(heightMeasureSpec), h));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMin, 1073741824));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerStateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ PlayerStateButton(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerStateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.currentState = b.a.a;
        this.loadingDrawable = new DG3(0, 0.0f, 0, 0, 15, null);
        this.playPauseDrawable = new C8499Wf5((int) ((28 * AbstractC3742Cd6.c()) + 0.5d), (int) ((16 * AbstractC3742Cd6.c()) + 0.5d), 200.0f);
        setBackgroundResource(KB5.circle_bubble_secondary_color);
        getBackground().setColorFilter(new PorterDuffColorFilter(AbstractC4043Dl1.c(context, JA5.bubble_background_icon_light), PorterDuff.Mode.MULTIPLY));
    }
}
