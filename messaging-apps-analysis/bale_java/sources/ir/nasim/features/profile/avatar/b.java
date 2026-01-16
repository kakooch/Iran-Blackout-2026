package ir.nasim.features.profile.avatar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.github.chrisbanes.photoview.PhotoView;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11335cq;
import ir.nasim.C14182hV;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C22042ua0;
import ir.nasim.C25226zw5;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC18243oK4;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.QI2;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002,-B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\t¨\u0006."}, d2 = {"Lir/nasim/features/profile/avatar/b;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "Y9", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatarObj", "V9", "(Lir/nasim/core/modules/profile/entity/Avatar;)V", "avatar", "T9", "aa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "c7", "Lir/nasim/Tm2;", "c1", "Lir/nasim/Tm2;", "bindedDownloadFile", "Lir/nasim/hV;", "d1", "Lir/nasim/bW7;", "R9", "()Lir/nasim/hV;", "binding", "e1", "Lir/nasim/core/modules/profile/entity/Avatar;", "S9", "()Lir/nasim/core/modules/profile/entity/Avatar;", "X9", "currentAvatar", "f1", "b", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class b extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private InterfaceC7857Tm2 bindedDownloadFile;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new d(), AbstractC20046rN7.c());

    /* renamed from: e1, reason: from kotlin metadata */
    public Avatar currentAvatar;
    static final /* synthetic */ InterfaceC5239Im3[] g1 = {AbstractC10882cM5.i(new C25226zw5(b.class, "binding", "getBinding()Lir/nasim/databinding/AvatarViewBinding;", 0))};

    /* renamed from: f1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int h1 = 8;

    /* renamed from: ir.nasim.features.profile.avatar.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final b a(Avatar avatar) {
            AbstractC13042fc3.i(avatar, "avatar");
            Bundle bundle = new Bundle();
            b bVar = new b();
            bVar.X9(avatar);
            bVar.a8(bundle);
            return bVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.profile.avatar.b$b, reason: collision with other inner class name */
    public interface InterfaceC1209b {
        void x();
    }

    public static final class c implements InterfaceC8091Um2 {
        c() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            PhotoView photoView = b.this.R9().b;
            b bVar = b.this;
            AbstractC13042fc3.f(photoView);
            QI2.v(photoView, interfaceC3346Am2.getDescriptor(), null, 2, null);
            bVar.R9().b.setZoomable(true);
            AbstractC14828iY7.l(photoView);
            AbstractC14828iY7.c(b.this.R9().c);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C14182hV.a(fragment.V7());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14182hV R9() {
        Object objA = this.binding.a(this, g1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C14182hV) objA;
    }

    private final void T9(Avatar avatar) {
        AbstractC14828iY7.l(R9().c);
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        AvatarImage largeImage = avatar.getLargeImage();
        AbstractC13042fc3.f(largeImage);
        String strG = c11335cqD.G(largeImage.getFileReference().getFileId());
        if (strG != null) {
            PhotoView photoView = R9().b;
            AbstractC13042fc3.h(photoView, "avatar");
            QI2.v(photoView, strG, null, 2, null);
            R9().b.setZoomable(false);
        } else {
            C11335cq c11335cqD2 = AbstractC5969Lp4.d();
            AvatarImage smallImage = avatar.getSmallImage();
            AbstractC13042fc3.f(smallImage);
            String strG2 = c11335cqD2.G(smallImage.getFileReference().getFileId());
            if (strG2 != null) {
                PhotoView photoView2 = R9().b;
                AbstractC13042fc3.h(photoView2, "avatar");
                QI2.v(photoView2, strG2, null, 2, null);
                R9().b.setZoomable(false);
            }
        }
        C11335cq c11335cqD3 = AbstractC5969Lp4.d();
        AvatarImage fullImage = avatar.getFullImage();
        AbstractC13042fc3.f(fullImage);
        this.bindedDownloadFile = c11335cqD3.q(fullImage.getFileReference(), true, new c());
    }

    public static final b U9(Avatar avatar) {
        return INSTANCE.a(avatar);
    }

    private final void V9(final Avatar avatarObj) {
        aa();
        if (avatarObj == null || avatarObj.getFullImage() == null) {
            R9().b.setImageBitmap(null);
            AbstractC14828iY7.c(R9().c);
            C19406qI3.a("ViewAvatarFragment", "Error!! performBind: avatar or avatar.getFullImage is null!!", new Object[0]);
            return;
        }
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        AvatarImage fullImage = avatarObj.getFullImage();
        AbstractC13042fc3.f(fullImage);
        String strG = c11335cqD.G(fullImage.getFileReference().getFileId());
        if (strG == null) {
            T9(avatarObj);
            return;
        }
        PhotoView photoView = R9().b;
        AbstractC13042fc3.h(photoView, "avatar");
        QI2.u(photoView, strG, new SA2() { // from class: ir.nasim.ZV7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.features.profile.avatar.b.W9(this.a, avatarObj);
            }
        });
        R9().b.setZoomable(true);
        AbstractC14828iY7.c(R9().c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W9(b bVar, Avatar avatar) {
        AbstractC13042fc3.i(bVar, "this$0");
        bVar.T9(avatar);
        return C19938rB7.a;
    }

    private final void Y9() {
        R9().b.setOnViewTapListener(new InterfaceC18243oK4() { // from class: ir.nasim.YV7
            @Override // ir.nasim.InterfaceC18243oK4
            public final void a(View view, float f, float f2) {
                ir.nasim.features.profile.avatar.b.Z9(this.a, view, f, f2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(b bVar, View view, float f, float f2) {
        InterfaceC1209b interfaceC1209b;
        AbstractC13042fc3.i(bVar, "this$0");
        if (!(bVar.A5() instanceof InterfaceC1209b) || (interfaceC1209b = (InterfaceC1209b) bVar.A5()) == null) {
            return;
        }
        interfaceC1209b.x();
    }

    private final void aa() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.bindedDownloadFile;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
            this.bindedDownloadFile = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(AbstractC12208eD5.avatar_view, container, false);
    }

    public final Avatar S9() {
        Avatar avatar = this.currentAvatar;
        if (avatar != null) {
            return avatar;
        }
        AbstractC13042fc3.y("currentAvatar");
        return null;
    }

    public final void X9(Avatar avatar) {
        AbstractC13042fc3.i(avatar, "<set-?>");
        this.currentAvatar = avatar;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        aa();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        V9(S9());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Y9();
    }
}
