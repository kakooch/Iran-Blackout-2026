package ir.nasim.story.ui.viewfragment.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23008wB5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C19938rB7;
import ir.nasim.C7223Qu3;
import ir.nasim.ED1;
import ir.nasim.UA2;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.story.ui.viewfragment.views.TopBarStoryView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010 J#\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b&\u0010\u0019J\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b*\u0010\u0011J\u0015\u0010+\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b+\u0010\u0011J\u0017\u0010-\u001a\u00020\u000b2\b\b\u0001\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\rJ\u0017\u0010.\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b.\u0010\u0019R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R$\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/TopBarStoryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "visibility", "Lir/nasim/rB7;", "setMuteUnMuteVisibility", "(I)V", "", "isMuted", "setVolumeIcon", "(Z)V", "Lkotlin/Function1;", "onChange", "setOnChangeMute", "(Lir/nasim/UA2;)V", "Landroid/view/View$OnClickListener;", "onClickListener", "f0", "(Landroid/view/View$OnClickListener;)V", "visible", "n0", "h0", "", "time", "setTime", "(Ljava/lang/String;)V", "name", "setTitle", "textStr", "k0", "(ZLjava/lang/String;)Lir/nasim/rB7;", "g0", "Lir/nasim/designsystem/avatar/AvatarViewGlide;", "getAvatarView", "()Lir/nasim/designsystem/avatar/AvatarViewGlide;", "o0", "j0", "drawableRes", "setBadgeDrawable", "i0", "Lir/nasim/Qu3;", "y", "Lir/nasim/Qu3;", "binding", "z", "Z", "muteState", "A", "Lir/nasim/UA2;", "onChangeMute", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class TopBarStoryView extends ConstraintLayout {

    /* renamed from: A, reason: from kotlin metadata */
    private UA2 onChangeMute;

    /* renamed from: y, reason: from kotlin metadata */
    private final C7223Qu3 binding;

    /* renamed from: z, reason: from kotlin metadata */
    private boolean muteState;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopBarStoryView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(TopBarStoryView topBarStoryView, View view) {
        AbstractC13042fc3.i(topBarStoryView, "this$0");
        topBarStoryView.setVolumeIcon(!topBarStoryView.muteState);
    }

    public static /* synthetic */ C19938rB7 m0(TopBarStoryView topBarStoryView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return topBarStoryView.k0(z, str);
    }

    public final void f0(View.OnClickListener onClickListener) {
        this.binding.d.setOnClickListener(onClickListener);
    }

    public final void g0(View.OnClickListener onClickListener) {
        this.binding.c.setOnClickListener(onClickListener);
    }

    public final AvatarViewGlide getAvatarView() {
        AvatarViewGlide avatarViewGlide = this.binding.b;
        AbstractC13042fc3.h(avatarViewGlide, "avatarProfile");
        return avatarViewGlide;
    }

    public final void h0(View.OnClickListener onClickListener) {
        this.binding.f.setOnClickListener(onClickListener);
    }

    public final void i0(View.OnClickListener onClickListener) {
        C7223Qu3 c7223Qu3 = this.binding;
        c7223Qu3.b.setOnClickListener(onClickListener);
        c7223Qu3.h.setOnClickListener(onClickListener);
        c7223Qu3.i.setOnClickListener(onClickListener);
    }

    public final void j0(boolean visible) {
        this.binding.e.setVisibility(visible ? 0 : 4);
    }

    public final C19938rB7 k0(boolean visible, String textStr) {
        MaterialButton materialButton = this.binding.c;
        materialButton.setVisibility(visible ? 0 : 8);
        if (textStr == null) {
            return null;
        }
        materialButton.setText(textStr);
        return C19938rB7.a;
    }

    public final void n0(boolean visible) {
        this.binding.f.setVisibility(visible ? 0 : 4);
    }

    public final void o0(boolean visible) {
        AppCompatTextView appCompatTextView = this.binding.h;
        appCompatTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, visible ? AbstractC4043Dl1.f(appCompatTextView.getContext(), AbstractC23008wB5.blue_tick) : null, (Drawable) null);
    }

    public final void setBadgeDrawable(int drawableRes) {
        this.binding.e.setImageResource(drawableRes);
    }

    public final void setMuteUnMuteVisibility(int visibility) {
        this.binding.g.setVisibility(visibility);
    }

    public final void setOnChangeMute(UA2 onChange) {
        AbstractC13042fc3.i(onChange, "onChange");
        this.onChangeMute = onChange;
    }

    public final void setTime(String time) {
        AbstractC13042fc3.i(time, "time");
        this.binding.i.setText(time);
    }

    public final void setTitle(String name) {
        AbstractC13042fc3.i(name, "name");
        this.binding.h.setText(name);
    }

    public final void setVolumeIcon(boolean isMuted) {
        this.muteState = isMuted;
        this.binding.g.setImageResource(isMuted ? AbstractC23008wB5.icon_volume_off : AbstractC23008wB5.icon_volume_up);
        UA2 ua2 = this.onChangeMute;
        if (ua2 != null) {
            ua2.invoke(Boolean.valueOf(isMuted));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopBarStoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ TopBarStoryView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopBarStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        C7223Qu3 c7223Qu3B = C7223Qu3.b(LayoutInflater.from(context), this);
        AbstractC13042fc3.h(c7223Qu3B, "inflate(...)");
        this.binding = c7223Qu3B;
        c7223Qu3B.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Cs7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopBarStoryView.e0(this.a, view);
            }
        });
    }
}
