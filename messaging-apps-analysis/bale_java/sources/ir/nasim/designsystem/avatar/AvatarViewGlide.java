package ir.nasim.designsystem.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bumptech.glide.g;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11335cq;
import ir.nasim.C14733iO2;
import ir.nasim.C17067mL1;
import ir.nasim.C17913nm1;
import ir.nasim.C19406qI3;
import ir.nasim.C21231tK7;
import ir.nasim.C3512Be1;
import ir.nasim.C4382Ew7;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.QI2;
import ir.nasim.WU;
import ir.nasim.YE5;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b(\u0010)J#\u0010.\u001a\u00020\u00102\u0006\u0010+\u001a\u00020*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103JA\u00106\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000e2\u0006\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u001a2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u00020\u00102\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u0004\u0018\u0001082\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b?\u0010:J\r\u0010@\u001a\u00020\u0010¢\u0006\u0004\b@\u0010\u0017R\u0016\u0010C\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010MR\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010OR\u0016\u0010\u000f\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010QR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010B¨\u0006R"}, d2 = {"Lir/nasim/designsystem/avatar/AvatarViewGlide;", "Lcom/google/android/material/imageview/ShapeableImageView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatar", "", "currentId", "Lir/nasim/rB7;", "x", "(Lir/nasim/core/modules/profile/entity/Avatar;Ljava/lang/String;)V", "reference", TokenNames.C, "(Ljava/lang/String;)V", "y", "()V", "", "placeholderTextSize", "", "isCircle", "B", "(FZ)V", "Lir/nasim/mL1;", "dialog", "p", "(Lir/nasim/mL1;)V", "Lir/nasim/Be1;", "contact", "o", "(Lir/nasim/Be1;)V", "id", "nick", "n", "(ILjava/lang/String;)V", "Lir/nasim/tK7;", "user", "Landroid/graphics/drawable/Drawable;", "defaultAvatarDrawable", "s", "(Lir/nasim/tK7;Landroid/graphics/drawable/Drawable;)V", "Lir/nasim/iO2;", "group", "q", "(Lir/nasim/iO2;)V", "title", DialogEntity.COLUMN_IS_DELETED_ACCOUNT, "t", "(Lir/nasim/core/modules/profile/entity/Avatar;Ljava/lang/String;IZLandroid/graphics/drawable/Drawable;)V", "Lir/nasim/core/modules/profile/entity/AvatarImage;", "z", "(Lir/nasim/core/modules/profile/entity/Avatar;)Lir/nasim/core/modules/profile/entity/AvatarImage;", "Landroid/graphics/Bitmap;", "bitmap", "setBitmap", "(Landroid/graphics/Bitmap;)V", "A", "D", "w", "Z", "roundAsCircle", TokenNames.I, "getRadiusSizeFactor", "()I", "setRadiusSizeFactor", "(I)V", "radiusSizeFactor", "Ljava/lang/String;", "TAG", "Lir/nasim/Tm2;", "Lir/nasim/Tm2;", "bindedFile", TokenNames.F, "", "J", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class AvatarViewGlide extends ShapeableImageView {

    /* renamed from: A, reason: from kotlin metadata */
    private float placeholderTextSize;

    /* renamed from: B, reason: from kotlin metadata */
    private long currentId;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isCircle;

    /* renamed from: w, reason: from kotlin metadata */
    private boolean roundAsCircle;

    /* renamed from: x, reason: from kotlin metadata */
    private int radiusSizeFactor;

    /* renamed from: y, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: z, reason: from kotlin metadata */
    private InterfaceC7857Tm2 bindedFile;

    public static final class a implements InterfaceC8091Um2 {
        final /* synthetic */ Avatar b;

        a(Avatar avatar) {
            this.b = avatar;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AvatarViewGlide.this.C(interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            AvatarViewGlide.this.x(this.b, null);
        }
    }

    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AvatarViewGlide.this.C(interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarViewGlide(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.radiusSizeFactor = 1;
        this.TAG = "AvatarViewGlide";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String reference) {
        if (!C17913nm1.a(getContext())) {
            C19406qI3.j(this.TAG, "loadCircleImage (reference, id): context is not available!", new Object[0]);
            return;
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AbstractC13042fc3.f(((g) ((g) QI2.c(reference, context, getHeight(), getWidth()).i(AbstractC23175wU1.a)).f0(getDrawable())).Q0(this));
    }

    public static /* synthetic */ void u(AvatarViewGlide avatarViewGlide, C21231tK7 c21231tK7, Drawable drawable, int i, Object obj) {
        if ((i & 2) != 0) {
            drawable = null;
        }
        avatarViewGlide.s(c21231tK7, drawable);
    }

    public static /* synthetic */ void v(AvatarViewGlide avatarViewGlide, Avatar avatar, String str, int i, boolean z, Drawable drawable, int i2, Object obj) {
        avatarViewGlide.t(avatar, (i2 & 2) != 0 ? null : str, i, z, (i2 & 16) != 0 ? null : drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AvatarViewGlide avatarViewGlide, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(avatarViewGlide, "this$0");
        AbstractC13042fc3.i(c4382Ew7, "res");
        Object objB = c4382Ew7.b();
        AbstractC13042fc3.h(objB, "getT2(...)");
        if (!(((Object[]) objB).length == 0)) {
            avatarViewGlide.q(((C14733iO2[]) c4382Ew7.b())[0]);
            return;
        }
        Object objA = c4382Ew7.a();
        AbstractC13042fc3.h(objA, "getT1(...)");
        if (!(((Object[]) objA).length == 0)) {
            u(avatarViewGlide, ((C21231tK7[]) c4382Ew7.a())[0], null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Avatar avatar, String currentId) {
        AvatarImage avatarImageA = A(avatar);
        if (avatarImageA == null) {
            return;
        }
        y();
        this.bindedFile = AbstractC5969Lp4.d().q(avatarImageA.getFileReference(), true, new b());
    }

    private final void y() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.bindedFile;
        if (interfaceC7857Tm2 != null) {
            AbstractC13042fc3.f(interfaceC7857Tm2);
            interfaceC7857Tm2.a(true);
            this.bindedFile = null;
        }
    }

    public final AvatarImage A(Avatar avatar) {
        AbstractC13042fc3.i(avatar, "avatar");
        return avatar.getSecondImage();
    }

    public final void B(float placeholderTextSize, boolean isCircle) {
        this.placeholderTextSize = placeholderTextSize;
        this.isCircle = isCircle;
    }

    public final void D() {
        y();
        this.currentId = 0L;
        setImageURI(null);
    }

    public final int getRadiusSizeFactor() {
        return this.radiusSizeFactor;
    }

    public final void n(int id, String nick) {
        float f = this.placeholderTextSize;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        setImageDrawable(new WU(nick, id, f, context, false, this.isCircle));
        long j = id;
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j);
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(j);
        if (c21231tK7 != null) {
            u(this, c21231tK7, null, 2, null);
            return;
        }
        if (c14733iO2 != null) {
            q(c14733iO2);
            return;
        }
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        if (nick == null) {
            nick = Separators.QUESTION;
        }
        c11335cqD.J(nick).m0(new InterfaceC24449ye1() { // from class: ir.nasim.iV
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AvatarViewGlide.w(this.a, (C4382Ew7) obj);
            }
        });
    }

    public final void o(C3512Be1 contact) {
        AbstractC13042fc3.i(contact, "contact");
        try {
            v(this, contact.q(), contact.getName(), contact.r(), false, null, 16, null);
        } catch (Exception e) {
            C19406qI3.d(this.TAG, e);
        }
    }

    public final void p(C17067mL1 dialog) {
        AbstractC13042fc3.i(dialog, "dialog");
        try {
            v(this, dialog.H(), dialog.J(), dialog.R().getPeerId(), dialog.c0(), null, 16, null);
        } catch (Exception e) {
            C19406qI3.d(this.TAG, e);
        }
    }

    public final void q(C14733iO2 group) {
        try {
            AbstractC13042fc3.f(group);
            v(this, (Avatar) group.j().b(), (String) group.v().b(), group.r(), false, null, 16, null);
        } catch (Exception e) {
            C19406qI3.d(this.TAG, e);
        }
    }

    public final void r(C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(c21231tK7, "user");
        u(this, c21231tK7, null, 2, null);
    }

    public final void s(C21231tK7 user, Drawable defaultAvatarDrawable) {
        AbstractC13042fc3.i(user, "user");
        try {
            Avatar avatar = (Avatar) user.h().b();
            String str = (String) user.r().b();
            int iO = user.o();
            Object objB = user.A().b();
            AbstractC13042fc3.h(objB, "get(...)");
            t(avatar, str, iO, ((Boolean) objB).booleanValue(), defaultAvatarDrawable);
        } catch (Exception e) {
            C19406qI3.d(this.TAG, e);
        }
    }

    public final void setBitmap(Bitmap bitmap) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        QI2.a.d(bitmap, getHeight(), getWidth()).f0(getDrawable()).Q0(this);
    }

    public final void setRadiusSizeFactor(int i) {
        this.radiusSizeFactor = i;
    }

    public final void t(Avatar avatar, String title, int id, boolean isDeletedAccount, Drawable defaultAvatarDrawable) {
        if (!isDeletedAccount && avatar != null && z(avatar) != null) {
            AvatarImage avatarImageZ = z(avatar);
            AbstractC13042fc3.f(avatarImageZ);
            if (avatarImageZ.getFileReference().getFileId() == this.currentId) {
                return;
            }
        }
        if (defaultAvatarDrawable != null) {
            setImageDrawable(defaultAvatarDrawable);
        } else {
            float f = this.placeholderTextSize;
            Context context = getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            setImageDrawable(new WU(title, id, f, context, isDeletedAccount, this.isCircle));
        }
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.bindedFile;
        if (interfaceC7857Tm2 != null) {
            AbstractC13042fc3.f(interfaceC7857Tm2);
            interfaceC7857Tm2.b();
            this.bindedFile = null;
        }
        setImageURI(null);
        if (isDeletedAccount || avatar == null || z(avatar) == null) {
            this.currentId = 0L;
            return;
        }
        AvatarImage avatarImageZ2 = z(avatar);
        AbstractC13042fc3.f(avatarImageZ2);
        this.currentId = avatarImageZ2.getFileReference().getFileId();
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        AvatarImage avatarImageZ3 = z(avatar);
        AbstractC13042fc3.f(avatarImageZ3);
        this.bindedFile = c11335cqD.q(avatarImageZ3.getFileReference(), true, new a(avatar));
    }

    public final AvatarImage z(Avatar avatar) {
        AbstractC13042fc3.i(avatar, "avatar");
        return avatar.getImageDefaultSize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarViewGlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.radiusSizeFactor = 1;
        this.TAG = "AvatarViewGlide";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarViewGlide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.radiusSizeFactor = 1;
        this.TAG = "AvatarViewGlide";
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, YE5.AvatarViewGlide);
            AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            if (typedArrayObtainStyledAttributes.hasValue(YE5.AvatarViewGlide_roundAsCircle)) {
                this.roundAsCircle = typedArrayObtainStyledAttributes.getBoolean(YE5.AvatarViewGlide_roundAsCircle, false);
            }
            if (typedArrayObtainStyledAttributes.hasValue(YE5.AvatarViewGlide_roundedCornerRadius)) {
                this.radiusSizeFactor = typedArrayObtainStyledAttributes.getInt(YE5.AvatarViewGlide_roundedCornerRadius, 1);
            }
        }
    }
}
