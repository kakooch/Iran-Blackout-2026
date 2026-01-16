package ir.nasim.features.story.avatarwithstory;

import android.content.Context;
import android.widget.FrameLayout;
import ir.nasim.C15990kW7;
import ir.nasim.InterfaceC21926uN1;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes6.dex */
public abstract class Hilt_DialogHolderAvatarWithStory extends FrameLayout implements ME2 {
    private C15990kW7 a;
    private boolean b;

    Hilt_DialogHolderAvatarWithStory(Context context) {
        super(context);
        if (isInEditMode()) {
            return;
        }
        c();
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C15990kW7 E4() {
        if (this.a == null) {
            this.a = b();
        }
        return this.a;
    }

    protected C15990kW7 b() {
        return new C15990kW7(this, false);
    }

    protected void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        ((InterfaceC21926uN1) N2()).c((DialogHolderAvatarWithStory) SB7.a(this));
    }
}
