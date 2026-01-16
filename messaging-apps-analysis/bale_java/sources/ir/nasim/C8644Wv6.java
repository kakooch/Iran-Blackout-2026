package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.StoryOuterClass$ResponseGetUserStoryConfig;
import ai.bale.proto.StoryStruct$UserStoryConfig;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import ir.nasim.AbstractC9599aE4;
import ir.nasim.Z06;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001FB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u001b\u0010\u0011\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0013\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u001b\u0010\u0015\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u001b\u0010\u0017\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\bJ#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u001b\u0010\u0019\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u001b\u0010\u001a\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\bJ#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\rJ\u0019\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0003J+\u0010-\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J)\u00103\u001a\u00020\u00062\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lir/nasim/Wv6;", "Lir/nasim/ov6;", "<init>", "()V", "Lir/nasim/Ku6;", "holder", "Lir/nasim/rB7;", "Ua", "(Lir/nasim/Ku6;)V", "Lir/nasim/aw6;", "Lkotlin/Function1;", "Landroid/view/View;", "va", "(Lir/nasim/aw6;)Lir/nasim/UA2;", "Na", "sa", "Qa", "ab", "Ba", "jb", "Fa", "gb", "Ha", "Xa", "xa", "db", "La", "Da", "Landroid/net/Uri;", "uri", "", "ua", "(Landroid/net/Uri;)Ljava/lang/String;", "", "za", "()Ljava/lang/CharSequence;", "Aa", "()Landroid/net/Uri;", "Ja", "mb", "Q9", "Lir/nasim/tv6;", "item", "", "position", "R9", "(Lir/nasim/Ku6;Lir/nasim/tv6;I)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "Landroid/widget/TextView;", "e1", "Landroid/widget/TextView;", "getTvSoundName", "()Landroid/widget/TextView;", "setTvSoundName", "(Landroid/widget/TextView;)V", "tvSoundName", "Landroid/widget/Switch;", "f1", "Landroid/widget/Switch;", "getSwSoundName", "()Landroid/widget/Switch;", "setSwSoundName", "(Landroid/widget/Switch;)V", "swSoundName", "g1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Wv6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8644Wv6 extends AbstractC18599ov6 {
    public static final int h1 = 8;

    /* renamed from: e1, reason: from kotlin metadata */
    private TextView tvSoundName;

    /* renamed from: f1, reason: from kotlin metadata */
    private Switch swSoundName;

    /* renamed from: ir.nasim.Wv6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C10022aw6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C10022aw6 c10022aw6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c10022aw6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
                boolean zIsChecked = this.c.H0().isChecked();
                this.b = 1;
                if (AbstractC9599aE4.a.h(aVar, zIsChecked, false, this, 2, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wv6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C10022aw6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C10022aw6 c10022aw6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c10022aw6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
                boolean zIsChecked = this.c.H0().isChecked();
                this.b = 1;
                if (aVar.g(zIsChecked, true, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wv6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C10022aw6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C10022aw6 c10022aw6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c10022aw6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
                this.b = 1;
                obj = AbstractC9599aE4.a.p(aVar, false, this, 1, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                Z06.b bVar = (Z06.b) z06;
                if (((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).isInitialized()) {
                    AbstractC13042fc3.h(((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).getConfigList(), "getConfigList(...)");
                    if (!r0.isEmpty()) {
                        Switch switchH0 = this.c.H0();
                        List<StoryStruct$UserStoryConfig> configList = ((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).getConfigList();
                        AbstractC13042fc3.h(configList, "getConfigList(...)");
                        switchH0.setChecked(((StoryStruct$UserStoryConfig) AbstractC15401jX0.q0(configList)).getNotificationConfig().getIsActive());
                    }
                }
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wv6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C10022aw6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C10022aw6 c10022aw6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c10022aw6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
                this.b = 1;
                obj = aVar.o(true, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                Z06.b bVar = (Z06.b) z06;
                if (((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).isInitialized()) {
                    AbstractC13042fc3.h(((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).getConfigList(), "getConfigList(...)");
                    if (!r0.isEmpty()) {
                        Switch switchH0 = this.c.H0();
                        List<StoryStruct$UserStoryConfig> configList = ((StoryOuterClass$ResponseGetUserStoryConfig) bVar.a()).getConfigList();
                        AbstractC13042fc3.h(configList, "getConfigList(...)");
                        switchH0.setChecked(((StoryStruct$UserStoryConfig) AbstractC15401jX0.q0(configList)).getNotificationConfig().getIsActive());
                    }
                }
            } else if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final Uri Aa() {
        return AbstractC9599aE4.a.n(AbstractC9599aE4.a, null, 1, null);
    }

    private final UA2 Ba(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Nv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.Ca(holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        aVar.f();
        c10022aw6.H0().setChecked(aVar.v());
        return C19938rB7.a;
    }

    private final UA2 Da(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Kv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.Ea(this.a, holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea(C8644Wv6 c8644Wv6, C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC10533bm0.d(AbstractC19224pz3.a(c8644Wv6), null, null, new c(c10022aw6, null), 3, null);
        return C19938rB7.a;
    }

    private final UA2 Fa(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Lv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.Ga(holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ga(C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        aVar.d();
        c10022aw6.H0().setChecked(aVar.u());
        return C19938rB7.a;
    }

    private final UA2 Ha(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Iv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.Ia(holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ia(C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        aVar.c();
        c10022aw6.H0().setChecked(aVar.s());
        return C19938rB7.a;
    }

    private final void Ja() {
        Object systemService = S7().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT < 34 || notificationManager.canUseFullScreenIntent()) {
            mb();
            return;
        }
        C24398yZ c24398yZ = C24398yZ.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        c24398yZ.i(contextS7, interfaceC18633oz3P6, new SA2() { // from class: ir.nasim.Jv6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8644Wv6.Ka(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ka(C8644Wv6 c8644Wv6) {
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        c8644Wv6.mb();
        return C19938rB7.a;
    }

    private final void La(AbstractC5782Ku6 holder) {
        holder.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Pv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.Ma(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(C8644Wv6 c8644Wv6, View view) {
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        c8644Wv6.Ja();
    }

    private final void Na(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        View viewD0 = c10022aw6.D0();
        if (viewD0 != null) {
            viewD0.setVisibility(4);
        }
        c10022aw6.H0().setChecked(AbstractC9599aE4.a.r());
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Sa = sa(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Bv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.Oa(ua2Sa, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Sa2 = sa(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Cv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.Pa(ua2Sa2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void Qa(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        final C10022aw6 c10022aw6 = (C10022aw6) holder;
        View view = c10022aw6.a;
        Switch switchH0 = c10022aw6.H0();
        this.swSoundName = switchH0;
        if (switchH0 != null) {
            switchH0.setChecked(AbstractC9599aE4.a.w());
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.wv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.Ra(this.a, c10022aw6, view2);
            }
        });
        if (Build.VERSION.SDK_INT < 26) {
            Switch r4 = this.swSoundName;
            if (r4 != null) {
                r4.setEnabled(r4 != null ? r4.isChecked() : false);
            }
            Switch r42 = this.swSoundName;
            if (r42 != null) {
                r42.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.Hv6
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        C8644Wv6.Sa(this.a, compoundButton, z);
                    }
                });
            }
        }
        Switch r43 = this.swSoundName;
        if (r43 != null) {
            r43.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ov6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C8644Wv6.Ta(this.a, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(C8644Wv6 c8644Wv6, C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        AbstractC13042fc3.i(c10022aw6, "$hldr");
        c8644Wv6.tvSoundName = c10022aw6.F0();
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        intent.putExtra("android.intent.extra.ringtone.TITLE", c8644Wv6.S7().getText(AbstractC12217eE5.setting_not_sound_select_tone));
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", c8644Wv6.Aa());
        c8644Wv6.startActivityForResult(intent, 1111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(C8644Wv6 c8644Wv6, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        Switch r0 = c8644Wv6.swSoundName;
        if (r0 != null) {
            r0.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(C8644Wv6 c8644Wv6, View view) {
        String packageName;
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        Switch r4 = c8644Wv6.swSoundName;
        if (r4 != null) {
            AbstractC9599aE4.a.C(r4.isChecked());
        }
        Switch r42 = c8644Wv6.swSoundName;
        if (r42 != null && !r42.isChecked()) {
            AbstractC9599aE4.a.B(null);
            return;
        }
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        Context contextG5 = c8644Wv6.G5();
        if (contextG5 == null || (packageName = contextG5.getPackageName()) == null) {
            packageName = "";
        }
        aVar.B(Uri.parse("android.resource://" + packageName + Separators.SLASH + AbstractC19954rD5.notification));
    }

    private final void Ua(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        c10022aw6.H0().setChecked(AbstractC9599aE4.a.t());
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Va = va(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Sv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.Va(ua2Va, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Va2 = va(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Tv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.Wa(ua2Va2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void Xa(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        c10022aw6.H0().setChecked(true);
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Xa = xa(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.Ya(ua2Xa, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Xa2 = xa(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Av6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.Za(ua2Xa2, view2);
            }
        });
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(c10022aw6, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void ab(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        c10022aw6.H0().setChecked(AbstractC9599aE4.a.v());
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Ba = Ba(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Qv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.bb(ua2Ba, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Ba2 = Ba(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Rv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.cb(ua2Ba2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void db(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        c10022aw6.H0().setChecked(true);
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Da = Da(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.eb(ua2Da, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Da2 = Da(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.fb(ua2Da2, view2);
            }
        });
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(c10022aw6, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void gb(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        c10022aw6.H0().setChecked(AbstractC9599aE4.a.s());
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Ha = Ha(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Dv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.hb(ua2Ha, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Ha2 = Ha(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ev6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.ib(ua2Ha2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void jb(AbstractC5782Ku6 holder) {
        AbstractC13042fc3.g(holder, "null cannot be cast to non-null type ir.nasim.features.settings.base.holder.SettingSwitchViewHolder");
        C10022aw6 c10022aw6 = (C10022aw6) holder;
        c10022aw6.H0().setChecked(AbstractC9599aE4.a.u());
        Switch switchH0 = c10022aw6.H0();
        final UA2 ua2Fa = Fa(c10022aw6);
        switchH0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Uv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8644Wv6.kb(ua2Fa, view);
            }
        });
        View view = c10022aw6.a;
        final UA2 ua2Fa2 = Fa(c10022aw6);
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vv6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8644Wv6.lb(ua2Fa2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    private final void mb() {
        n8(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + Q7().getPackageName())).addFlags(268435456));
    }

    private final UA2 sa(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Gv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.ta(holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        aVar.b();
        c10022aw6.H0().setChecked(aVar.r());
        return C19938rB7.a;
    }

    private final String ua(Uri uri) {
        String title = RingtoneManager.getRingtone(G5(), uri).getTitle(G5());
        if (title.equals(String.valueOf(AbstractC19954rD5.notification))) {
            CharSequence text = S7().getText(AbstractC12217eE5.default_sound);
            AbstractC13042fc3.g(text, "null cannot be cast to non-null type kotlin.String");
            title = (String) text;
        }
        AbstractC13042fc3.f(title);
        return title;
    }

    private final UA2 va(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Mv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.wa(holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wa(C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        aVar.e();
        c10022aw6.H0().setChecked(aVar.t());
        return C19938rB7.a;
    }

    private final UA2 xa(final C10022aw6 holder) {
        return new UA2() { // from class: ir.nasim.Fv6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8644Wv6.ya(this.a, holder, (View) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C8644Wv6 c8644Wv6, C10022aw6 c10022aw6, View view) {
        AbstractC13042fc3.i(c8644Wv6, "this$0");
        AbstractC13042fc3.i(c10022aw6, "$holder");
        AbstractC13042fc3.i(view, "it");
        AbstractC10533bm0.d(AbstractC19224pz3.a(c8644Wv6), null, null, new b(c10022aw6, null), 3, null);
        return C19938rB7.a;
    }

    private final CharSequence za() {
        CharSequence text = S7().getText(AbstractC12217eE5.not_sound_subtitle);
        AbstractC13042fc3.h(text, "getText(...)");
        Uri uriAa = Aa();
        return uriAa == null ? text : ua(uriAa);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        Switch r2;
        if (resultCode == -1 && requestCode == 1111) {
            Uri uri = data != null ? (Uri) data.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI") : null;
            if (uri != null) {
                AbstractC9599aE4.a.B(uri);
                TextView textView = this.tvSoundName;
                if (textView != null) {
                    textView.setText(ua(uri));
                }
                Switch r22 = this.swSoundName;
                if ((r22 == null || !r22.isChecked()) && (r2 = this.swSoundName) != null) {
                    r2.performClick();
                }
            }
        }
    }

    @Override // ir.nasim.AbstractC18599ov6
    public void Q9() {
        EnumC9185Yv6 enumC9185Yv6 = EnumC9185Yv6.h;
        CharSequence text = S7().getText(AbstractC12217eE5.setting_not_show_for);
        AbstractC13042fc3.h(text, "getText(...)");
        O9(new C21668tv6(0, enumC9185Yv6, text, null, 0, 0, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null));
        EnumC9185Yv6 enumC9185Yv62 = EnumC9185Yv6.c;
        CharSequence text2 = S7().getText(AbstractC12217eE5.setting_not_private);
        AbstractC13042fc3.h(text2, "getText(...)");
        CharSequence text3 = S7().getText(AbstractC12217eE5.setting_not_private_subtitle);
        AbstractC13042fc3.h(text3, "getText(...)");
        O9(new C21668tv6(2, enumC9185Yv62, text2, text3, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        CharSequence text4 = S7().getText(AbstractC12217eE5.setting_not_group);
        AbstractC13042fc3.h(text4, "getText(...)");
        CharSequence text5 = S7().getText(AbstractC12217eE5.setting_not_group_subtitle);
        AbstractC13042fc3.h(text5, "getText(...)");
        O9(new C21668tv6(3, enumC9185Yv62, text4, text5, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        if (C8386Vt0.hb()) {
            CharSequence text6 = S7().getText(AbstractC12217eE5.story_notification_settings_seperator);
            AbstractC13042fc3.h(text6, "getText(...)");
            O9(new C21668tv6(0, enumC9185Yv6, text6, null, 0, 0, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null));
            CharSequence text7 = S7().getText(AbstractC12217eE5.story_notification_settings_private_title);
            AbstractC13042fc3.h(text7, "getText(...)");
            CharSequence text8 = S7().getText(AbstractC12217eE5.story_notification_settings_private_subtitle);
            AbstractC13042fc3.h(text8, "getText(...)");
            O9(new C21668tv6(8, enumC9185Yv62, text7, text8, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
            if (C8386Vt0.eb()) {
                CharSequence text9 = S7().getText(AbstractC12217eE5.story_notification_settings_like_title);
                AbstractC13042fc3.h(text9, "getText(...)");
                CharSequence text10 = S7().getText(AbstractC12217eE5.story_notification_settings_like_subtitle);
                AbstractC13042fc3.h(text10, "getText(...)");
                O9(new C21668tv6(9, enumC9185Yv62, text9, text10, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
            }
        }
        CharSequence text11 = S7().getText(AbstractC12217eE5.setting_not_personalize);
        AbstractC13042fc3.h(text11, "getText(...)");
        O9(new C21668tv6(0, enumC9185Yv6, text11, null, 0, 0, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null));
        CharSequence text12 = S7().getText(AbstractC12217eE5.setting_not_sound);
        AbstractC13042fc3.h(text12, "getText(...)");
        O9(new C21668tv6(1, enumC9185Yv62, text12, za(), 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        CharSequence text13 = S7().getText(AbstractC12217eE5.setting_not_show_text);
        AbstractC13042fc3.h(text13, "getText(...)");
        CharSequence text14 = S7().getText(AbstractC12217eE5.setting_not_show_text_subtitle);
        AbstractC13042fc3.h(text14, "getText(...)");
        O9(new C21668tv6(5, enumC9185Yv62, text13, text14, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        CharSequence text15 = S7().getText(AbstractC12217eE5.setting_not_turn_on_light);
        AbstractC13042fc3.h(text15, "getText(...)");
        CharSequence text16 = S7().getText(AbstractC12217eE5.setting_not_turn_on_light_subtitle);
        AbstractC13042fc3.h(text16, "getText(...)");
        O9(new C21668tv6(6, enumC9185Yv62, text15, text16, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        CharSequence text17 = S7().getText(AbstractC12217eE5.setting_not_turn_led_on_light);
        AbstractC13042fc3.h(text17, "getText(...)");
        CharSequence text18 = S7().getText(AbstractC12217eE5.setting_not_turn_led_on_light_subtitle);
        AbstractC13042fc3.h(text18, "getText(...)");
        O9(new C21668tv6(7, enumC9185Yv62, text17, text18, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        if (Build.VERSION.SDK_INT >= 34) {
            EnumC9185Yv6 enumC9185Yv63 = EnumC9185Yv6.d;
            String string = S7().getString(AbstractC12217eE5.call_full_screen_intent_settings_title);
            AbstractC13042fc3.h(string, "getString(...)");
            String string2 = S7().getString(AbstractC12217eE5.call_full_screen_intent_settings_description);
            AbstractC13042fc3.h(string2, "getString(...)");
            O9(new C21668tv6(10, enumC9185Yv63, string, string2, 0, 0, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null));
        }
    }

    @Override // ir.nasim.AbstractC18599ov6
    public void R9(AbstractC5782Ku6 holder, C21668tv6 item, int position) {
        AbstractC13042fc3.i(holder, "holder");
        AbstractC13042fc3.i(item, "item");
        switch (item.b()) {
            case 1:
                Qa(holder);
                break;
            case 2:
                Ua(holder);
                break;
            case 3:
                Na(holder);
                break;
            case 5:
                ab(holder);
                break;
            case 6:
                jb(holder);
                break;
            case 7:
                gb(holder);
                break;
            case 8:
                Xa(holder);
                break;
            case 9:
                db(holder);
                break;
            case 10:
                La(holder);
                break;
        }
    }
}
