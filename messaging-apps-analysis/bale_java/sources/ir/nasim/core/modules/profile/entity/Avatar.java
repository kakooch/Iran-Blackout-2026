package ir.nasim.core.modules.profile.entity;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC25020zb8;
import ir.nasim.C19084pl0;
import ir.nasim.C19675ql0;
import ir.nasim.C22078ud6;
import ir.nasim.C6984Pv;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

@Keep
@KeepName
/* loaded from: classes5.dex */
public class Avatar extends AbstractC25020zb8 implements Serializable {
    public static int ImageSize = 54;
    private static final int RECORD_ID = 10;
    private AvatarImage fullImage;
    private Long id;
    private AvatarImage largeImage;
    private AvatarImage smallImage;

    public Avatar(C6984Pv c6984Pv) {
        super(10, c6984Pv);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Avatar avatar = (Avatar) obj;
        return Objects.equals(this.id, avatar.id) && Objects.equals(this.fullImage, avatar.fullImage) && Objects.equals(this.largeImage, avatar.largeImage) && Objects.equals(this.smallImage, avatar.smallImage);
    }

    public AvatarImage getFullImage() {
        return this.fullImage;
    }

    public Long getId() {
        return this.id;
    }

    public AvatarImage getImageDefaultSize() {
        return C22078ud6.a((float) ImageSize) >= 100 ? getLargeImage() : getSmallImage();
    }

    public AvatarImage getLargeImage() {
        return this.largeImage;
    }

    public AvatarImage getSecondImage() {
        return C22078ud6.a((float) ImageSize) < 100 ? getLargeImage() : getSmallImage();
    }

    public AvatarImage getSmallImage() {
        return this.smallImage;
    }

    public int hashCode() {
        AvatarImage avatarImage = this.smallImage;
        int iHashCode = (avatarImage != null ? avatarImage.hashCode() : 0) * 31;
        AvatarImage avatarImage2 = this.largeImage;
        int iHashCode2 = (iHashCode + (avatarImage2 != null ? avatarImage2.hashCode() : 0)) * 31;
        AvatarImage avatarImage3 = this.fullImage;
        return iHashCode2 + (avatarImage3 != null ? avatarImage3.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) throws IOException {
        if (!c19084pl0.c(5, false)) {
            throw new IOException("Unsupported obsolete format");
        }
        super.parse(c19084pl0);
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(5, true);
        super.serialize(c19675ql0);
    }

    public String toString() {
        return "Avatar{id=" + this.id + ", smallImage=" + this.smallImage + ", largeImage=" + this.largeImage + ", fullImage=" + this.fullImage + '}';
    }

    public Avatar(byte[] bArr) {
        super(10, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    public void applyWrapped(C6984Pv c6984Pv) {
        if (c6984Pv.s() != null) {
            this.smallImage = new AvatarImage(c6984Pv.s());
        } else {
            this.smallImage = null;
        }
        if (c6984Pv.r() != null) {
            this.largeImage = new AvatarImage(c6984Pv.r());
        } else {
            this.largeImage = null;
        }
        if (c6984Pv.q() != null) {
            this.fullImage = new AvatarImage(c6984Pv.q());
        } else {
            this.fullImage = null;
        }
        if (c6984Pv.getId() != null) {
            this.id = c6984Pv.getId();
        } else {
            this.id = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    public C6984Pv createInstance() {
        return new C6984Pv();
    }

    public Avatar() {
        super(10, new C6984Pv());
    }
}
