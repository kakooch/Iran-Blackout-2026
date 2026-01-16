package ir.nasim.features.story.avatarwithstory;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.j;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12888fL4;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.C14755iQ6;
import ir.nasim.C17067mL1;
import ir.nasim.C19938rB7;
import ir.nasim.C22042ua0;
import ir.nasim.EnumC18928pV;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC23301wh3;
import ir.nasim.InterfaceC24798zD3;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC7565Sg3;
import ir.nasim.features.story.avatarwithstory.DialogHolderAvatarWithStory;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00109¨\u0006;"}, d2 = {"Lir/nasim/features/story/avatarwithstory/DialogHolderAvatarWithStory;", "Landroid/widget/FrameLayout;", "Lir/nasim/ua0;", "fragment", "<init>", "(Lir/nasim/ua0;)V", "Lir/nasim/rB7;", "j", "()V", "l", "i", "k", "Lir/nasim/mL1;", "data", "h", "(Lir/nasim/mL1;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "m", "c", "Lir/nasim/ua0;", "getFragment", "()Lir/nasim/ua0;", "", "d", "Ljava/lang/Long;", "liveStreamKey", "Lir/nasim/Sg3;", "e", "Lir/nasim/Sg3;", "getJaryanNavigator", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/zD3;", "f", "Lir/nasim/zD3;", "getLiveNavigator", "()Lir/nasim/zD3;", "setLiveNavigator", "(Lir/nasim/zD3;)V", "liveNavigator", "", "g", TokenNames.I, "peerId", "", "Lir/nasim/iQ6;", "Ljava/util/List;", "list", "Lir/nasim/features/story/avatarwithstory/AvatarWithStory;", "Lir/nasim/features/story/avatarwithstory/AvatarWithStory;", "avatarWithStory", "Lir/nasim/gj3;", "Lir/nasim/gj3;", "listenerJob", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class DialogHolderAvatarWithStory extends Hilt_DialogHolderAvatarWithStory {

    /* renamed from: c, reason: from kotlin metadata */
    private final C22042ua0 fragment;

    /* renamed from: d, reason: from kotlin metadata */
    private Long liveStreamKey;

    /* renamed from: e, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: f, reason: from kotlin metadata */
    public InterfaceC24798zD3 liveNavigator;

    /* renamed from: g, reason: from kotlin metadata */
    private int peerId;

    /* renamed from: h, reason: from kotlin metadata */
    private List list;

    /* renamed from: i, reason: from kotlin metadata */
    private final AvatarWithStory avatarWithStory;

    /* renamed from: j, reason: from kotlin metadata */
    private InterfaceC13730gj3 listenerJob;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.features.story.avatarwithstory.DialogHolderAvatarWithStory$a$a, reason: collision with other inner class name */
        static final class C1234a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ DialogHolderAvatarWithStory c;

            /* renamed from: ir.nasim.features.story.avatarwithstory.DialogHolderAvatarWithStory$a$a$a, reason: collision with other inner class name */
            static final class C1235a implements InterfaceC4806Gq2 {
                final /* synthetic */ DialogHolderAvatarWithStory a;

                C1235a(DialogHolderAvatarWithStory dialogHolderAvatarWithStory) {
                    this.a = dialogHolderAvatarWithStory;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.list = list;
                    this.a.k();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1234a(DialogHolderAvatarWithStory dialogHolderAvatarWithStory, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = dialogHolderAvatarWithStory;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1234a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6A = InterfaceC23301wh3.a.a().a();
                    C1235a c1235a = new C1235a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6A.b(c1235a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1234a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = DialogHolderAvatarWithStory.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C1234a(DialogHolderAvatarWithStory.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogHolderAvatarWithStory(C22042ua0 c22042ua0) {
        super(c22042ua0.S7());
        AbstractC13042fc3.i(c22042ua0, "fragment");
        this.fragment = c22042ua0;
        this.list = AbstractC10360bX0.m();
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AvatarWithStory avatarWithStory = new AvatarWithStory(context, null, 0, 6, null);
        this.avatarWithStory = avatarWithStory;
        l();
        avatarWithStory.setAvatarState(EnumC18928pV.c);
        setClickable(false);
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tN1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogHolderAvatarWithStory.e(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DialogHolderAvatarWithStory dialogHolderAvatarWithStory, View view) {
        AbstractC13042fc3.i(dialogHolderAvatarWithStory, "this$0");
        dialogHolderAvatarWithStory.j();
    }

    private final void i() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.listenerJob;
        if (interfaceC13730gj3 == null || !interfaceC13730gj3.b()) {
            return;
        }
        InterfaceC13730gj3 interfaceC13730gj32 = this.listenerJob;
        if (interfaceC13730gj32 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
        }
        this.listenerJob = null;
    }

    private final void j() {
        if (this.liveStreamKey == null) {
            if (this.avatarWithStory.getHasStory()) {
                C22042ua0.A9(this.fragment, getJaryanNavigator().h(this.peerId, new ArrayList()), false, null, 6, null);
                return;
            }
            return;
        }
        Context context = getContext();
        InterfaceC24798zD3 liveNavigator = getLiveNavigator();
        Context context2 = getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        Long l = this.liveStreamKey;
        AbstractC13042fc3.f(l);
        context.startActivity(liveNavigator.b(context2, l.longValue(), AbstractC12888fL4.d.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        for (C14755iQ6 c14755iQ6 : this.list) {
            if (c14755iQ6.a().getPeerId() == this.peerId) {
                if (c14755iQ6.b()) {
                    this.avatarWithStory.setAvatarState(EnumC18928pV.b);
                } else {
                    this.avatarWithStory.setAvatarState(EnumC18928pV.a);
                }
                setClickable(true);
                return;
            }
        }
        this.avatarWithStory.setAvatarState(EnumC18928pV.c);
        setClickable(false);
    }

    private final void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.avatarWithStory.setSize(50);
        layoutParams.gravity = 17;
        addView(this.avatarWithStory, layoutParams);
    }

    public final C22042ua0 getFragment() {
        return this.fragment;
    }

    public final InterfaceC7565Sg3 getJaryanNavigator() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    public final InterfaceC24798zD3 getLiveNavigator() {
        InterfaceC24798zD3 interfaceC24798zD3 = this.liveNavigator;
        if (interfaceC24798zD3 != null) {
            return interfaceC24798zD3;
        }
        AbstractC13042fc3.y("liveNavigator");
        return null;
    }

    public final void h(C17067mL1 data) {
        AbstractC13042fc3.i(data, "data");
        this.avatarWithStory.b(data);
        this.peerId = data.R().getPeerId();
        k();
        i();
        Long lP = data.P();
        this.liveStreamKey = lP;
        if (lP != null) {
            setClickable(true);
        } else {
            this.listenerJob = AbstractC16751lo1.c(this.fragment, j.b.RESUMED, new a(null));
        }
    }

    public final void m() {
        this.avatarWithStory.o();
        i();
    }

    public final void setImage(Drawable drawable) {
        this.avatarWithStory.setAvatarState(EnumC18928pV.c);
        this.avatarWithStory.setPlaceHolder(drawable);
    }

    public final void setJaryanNavigator(InterfaceC7565Sg3 interfaceC7565Sg3) {
        AbstractC13042fc3.i(interfaceC7565Sg3, "<set-?>");
        this.jaryanNavigator = interfaceC7565Sg3;
    }

    public final void setLiveNavigator(InterfaceC24798zD3 interfaceC24798zD3) {
        AbstractC13042fc3.i(interfaceC24798zD3, "<set-?>");
        this.liveNavigator = interfaceC24798zD3;
    }
}
