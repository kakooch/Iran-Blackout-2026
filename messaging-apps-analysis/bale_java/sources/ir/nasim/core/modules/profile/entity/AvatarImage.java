package ir.nasim.core.modules.profile.entity;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC25020zb8;
import ir.nasim.C19084pl0;
import ir.nasim.C19675ql0;
import ir.nasim.C7228Qv;
import ir.nasim.core.modules.file.entity.FileReference;
import java.io.IOException;

@Keep
@KeepName
/* loaded from: classes5.dex */
public class AvatarImage extends AbstractC25020zb8 {
    private static final int RECORD_ID = 10;
    private FileReference fileReference;
    private int height;
    private int width;

    public AvatarImage(C7228Qv c7228Qv) {
        super(10, c7228Qv);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AvatarImage avatarImage = (AvatarImage) obj;
        return this.height == avatarImage.height && this.width == avatarImage.width && this.fileReference.equals(avatarImage.fileReference);
    }

    public FileReference getFileReference() {
        return this.fileReference;
    }

    public int hashCode() {
        return (((this.width * 31) + this.height) * 31) + this.fileReference.hashCode();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    public void applyWrapped(C7228Qv c7228Qv) {
        this.width = c7228Qv.r();
        this.height = c7228Qv.q();
        this.fileReference = new FileReference(c7228Qv.getFileLocation(), "avatar.jpg", "Avatar", c7228Qv.getFileSize());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    public C7228Qv createInstance() {
        return new C7228Qv();
    }
}
