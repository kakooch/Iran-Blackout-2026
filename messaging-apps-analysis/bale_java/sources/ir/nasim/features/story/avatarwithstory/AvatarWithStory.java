package ir.nasim.features.story.avatarwithstory;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C17067mL1;
import ir.nasim.C22078ud6;
import ir.nasim.C9164Yt3;
import ir.nasim.ED1;
import ir.nasim.EnumC18228oI7;
import ir.nasim.EnumC18928pV;
import ir.nasim.KB5;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u0010*\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\fJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\"\u0010$J\u000f\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001d¢\u0006\u0004\b(\u0010 J\u0017\u0010+\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b-\u0010\u001aJ\u0015\u0010.\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010)¢\u0006\u0004\b1\u0010,J\r\u00102\u001a\u00020\u001d¢\u0006\u0004\b2\u00103J!\u00107\u001a\u00020\n2\u0006\u00104\u001a\u00020\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J\u0015\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<JA\u0010B\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010?\u001a\u0004\u0018\u0001052\u0006\u00104\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u001d2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010)H\u0007¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\n¢\u0006\u0004\bD\u0010\fR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010FR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010HR\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010KR\u0016\u0010Q\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010P¨\u0006R"}, d2 = {"Lir/nasim/features/story/avatarwithstory/AvatarWithStory;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "h", "()V", "g", "i", "Lir/nasim/oI7;", "Lir/nasim/pV;", "n", "(Lir/nasim/oI7;)Lir/nasim/pV;", "Landroid/view/View;", "avatarView", "", "size", "l", "(Landroid/view/View;F)V", "setRingSize", "(F)V", "k", "j", "", "shouldShowOriginalAvatar", "m", "(Z)V", "state", "setAvatarState", "(Lir/nasim/pV;)V", "(Lir/nasim/oI7;)V", "getAvatarState", "()Lir/nasim/oI7;", "shouldShowPresenceIndicator", "setPresenceState", "Landroid/graphics/drawable/Drawable;", "ringDrawable", "setRingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setPlaceHolderSizeForTooltip", "setSize", "(I)V", "drawable", "setPlaceHolder", "f", "()Z", "id", "", "nick", "a", "(ILjava/lang/String;)V", "Lir/nasim/mL1;", "dialog", "b", "(Lir/nasim/mL1;)V", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatar", "title", DialogEntity.COLUMN_IS_DELETED_ACCOUNT, "defaultAvatarDrawable", "d", "(Lir/nasim/core/modules/profile/entity/Avatar;Ljava/lang/String;IZLandroid/graphics/drawable/Drawable;)V", "o", "Lir/nasim/Yt3;", "Lir/nasim/Yt3;", "binding", "Lir/nasim/pV;", "c", TokenNames.I, "Landroid/graphics/drawable/Drawable;", "unseenRingDrawable", "e", "seenRingDrawable", "liveRingDrawable", "Z", "hasStory", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class AvatarWithStory extends FrameLayout {
    public static final int i = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final C9164Yt3 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private EnumC18928pV state;

    /* renamed from: c, reason: from kotlin metadata */
    private int size;

    /* renamed from: d, reason: from kotlin metadata */
    private Drawable unseenRingDrawable;

    /* renamed from: e, reason: from kotlin metadata */
    private Drawable seenRingDrawable;

    /* renamed from: f, reason: from kotlin metadata */
    private Drawable liveRingDrawable;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean hasStory;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC18928pV.values().length];
            try {
                iArr[EnumC18928pV.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18928pV.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18928pV.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC18928pV.b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC18928pV.c.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC18228oI7.values().length];
            try {
                iArr2[EnumC18228oI7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC18228oI7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC18228oI7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC18228oI7.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarWithStory(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public static /* synthetic */ void e(AvatarWithStory avatarWithStory, Avatar avatar, String str, int i2, boolean z, Drawable drawable, int i3, Object obj) {
        avatarWithStory.d(avatar, (i3 & 2) != 0 ? null : str, i2, z, (i3 & 16) != 0 ? null : drawable);
    }

    private final void g() {
        AvatarViewGlide avatarViewGlide = this.binding.c;
        avatarViewGlide.B(18.0f, true);
        AbstractC13042fc3.f(avatarViewGlide);
        l(avatarViewGlide, this.size / 1.18f);
    }

    private final void h() {
        AvatarViewGlide avatarViewGlide = this.binding.e;
        avatarViewGlide.B(18.0f, true);
        AbstractC13042fc3.f(avatarViewGlide);
        l(avatarViewGlide, this.size);
    }

    private final void i() {
        this.binding.f.setImageDrawable(this.unseenRingDrawable);
        setRingSize(this.size);
    }

    private final void j() {
        AvatarViewGlide avatarViewGlide = this.binding.e;
        AbstractC13042fc3.h(avatarViewGlide, "originalAvatar");
        l(avatarViewGlide, this.size);
        AvatarViewGlide avatarViewGlide2 = this.binding.c;
        AbstractC13042fc3.h(avatarViewGlide2, "avatarInsideRing");
        l(avatarViewGlide2, this.size / 1.18f);
        setRingSize(this.size);
    }

    private final void k() {
        EnumC18928pV enumC18928pV = this.state;
        int[] iArr = b.a;
        int i2 = iArr[enumC18928pV.ordinal()];
        if (i2 == 1) {
            m(false);
            this.binding.f.setImageDrawable(this.liveRingDrawable);
            this.hasStory = false;
        } else if (i2 == 2) {
            m(true);
            this.binding.f.setImageDrawable(null);
            this.hasStory = false;
        } else if (i2 == 3) {
            m(false);
            this.binding.f.setImageDrawable(this.unseenRingDrawable);
            this.hasStory = true;
        } else if (i2 == 4) {
            m(false);
            this.binding.f.setImageDrawable(this.seenRingDrawable);
            this.hasStory = true;
        } else {
            if (i2 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            m(true);
            this.binding.f.setImageDrawable(null);
            this.hasStory = false;
        }
        int i3 = iArr[this.state.ordinal()];
        if (i3 == 1) {
            this.binding.b.setVisibility(0);
            this.binding.b.setImageDrawable(AbstractC4043Dl1.f(getContext(), KB5.ic_live_badge));
        } else if (i3 == 2) {
            this.binding.b.setVisibility(0);
            this.binding.b.setImageDrawable(AbstractC4043Dl1.f(getContext(), KB5.ic_call_badge_bars));
        } else {
            if (i3 != 3 && i3 != 4 && i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            this.binding.b.setVisibility(8);
        }
    }

    private final void l(View avatarView, float size) {
        ViewGroup.LayoutParams layoutParams = avatarView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = C22078ud6.a(size);
        layoutParams.height = C22078ud6.a(size);
        avatarView.setLayoutParams(layoutParams);
    }

    private final void m(boolean shouldShowOriginalAvatar) {
        AvatarViewGlide avatarViewGlide = this.binding.e;
        AbstractC13042fc3.h(avatarViewGlide, "originalAvatar");
        avatarViewGlide.setVisibility(shouldShowOriginalAvatar ? 0 : 8);
        AvatarViewGlide avatarViewGlide2 = this.binding.c;
        AbstractC13042fc3.h(avatarViewGlide2, "avatarInsideRing");
        avatarViewGlide2.setVisibility(shouldShowOriginalAvatar ^ true ? 0 : 8);
        ImageView imageView = this.binding.f;
        AbstractC13042fc3.h(imageView, "ring");
        imageView.setVisibility(shouldShowOriginalAvatar ^ true ? 0 : 8);
    }

    private final EnumC18928pV n(EnumC18228oI7 enumC18228oI7) {
        int i2 = enumC18228oI7 == null ? -1 : b.b[enumC18228oI7.ordinal()];
        if (i2 == -1) {
            return EnumC18928pV.c;
        }
        if (i2 == 1) {
            return EnumC18928pV.e;
        }
        if (i2 == 2) {
            return EnumC18928pV.d;
        }
        if (i2 == 3) {
            return EnumC18928pV.a;
        }
        if (i2 == 4) {
            return EnumC18928pV.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void setRingSize(float size) {
        ImageView imageView = this.binding.f;
        AbstractC13042fc3.f(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = C22078ud6.a(size);
        layoutParams.height = C22078ud6.a(size);
        imageView.setLayoutParams(layoutParams);
    }

    public final void a(int id, String nick) {
        this.binding.e.n(id, nick);
        this.binding.c.n(id, nick);
    }

    public final void b(C17067mL1 dialog) {
        AbstractC13042fc3.i(dialog, "dialog");
        this.binding.e.p(dialog);
        this.binding.c.p(dialog);
    }

    public final void c(Avatar avatar, String str, int i2, boolean z) {
        e(this, avatar, str, i2, z, null, 16, null);
    }

    public final void d(Avatar avatar, String title, int id, boolean isDeletedAccount, Drawable defaultAvatarDrawable) {
        this.binding.e.t(avatar, title, id, isDeletedAccount, defaultAvatarDrawable);
        this.binding.c.t(avatar, title, id, isDeletedAccount, defaultAvatarDrawable);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getHasStory() {
        return this.hasStory;
    }

    public final EnumC18228oI7 getAvatarState() {
        int i2 = b.a[this.state.ordinal()];
        if (i2 == 1) {
            return EnumC18228oI7.a;
        }
        if (i2 == 2) {
            return EnumC18228oI7.b;
        }
        if (i2 == 3) {
            return EnumC18228oI7.c;
        }
        if (i2 == 4) {
            return EnumC18228oI7.d;
        }
        if (i2 == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void o() {
        this.binding.e.D();
        this.binding.c.D();
    }

    public final void setAvatarState(EnumC18928pV state) {
        AbstractC13042fc3.i(state, "state");
        if (this.state != state) {
            this.state = state;
            k();
        }
    }

    public final void setPlaceHolder(Drawable drawable) {
        this.binding.e.setImageDrawable(drawable);
    }

    public final void setPlaceHolderSizeForTooltip(float size) {
        this.binding.c.B(size, true);
        this.binding.e.B(size, true);
    }

    public final void setPresenceState(boolean shouldShowPresenceIndicator) {
        View view = this.binding.d;
        AbstractC13042fc3.h(view, "avatarPresence");
        view.setVisibility(shouldShowPresenceIndicator ? 0 : 8);
    }

    public final void setRingDrawable(Drawable ringDrawable) {
        if (ringDrawable != null) {
            this.unseenRingDrawable = ringDrawable;
        }
    }

    public final void setSize(int size) {
        if (this.size != size) {
            this.size = size;
            j();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarWithStory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ AvatarWithStory(Context context, AttributeSet attributeSet, int i2, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarWithStory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AbstractC13042fc3.i(context, "context");
        this.state = EnumC18928pV.c;
        this.size = Avatar.ImageSize;
        this.unseenRingDrawable = AbstractC4043Dl1.f(context, KB5.drawable_ring_new_story);
        this.seenRingDrawable = AbstractC4043Dl1.f(context, KB5.drawable_ring_viewed_story);
        this.liveRingDrawable = AbstractC4043Dl1.f(context, KB5.drawable_ring_live_stream);
        this.binding = C9164Yt3.c(LayoutInflater.from(context), this, true);
        h();
        g();
        i();
    }

    public final void setAvatarState(EnumC18228oI7 state) {
        EnumC18928pV enumC18928pVN = n(state);
        if (this.state != enumC18928pVN) {
            this.state = enumC18928pVN;
            k();
        }
    }
}
