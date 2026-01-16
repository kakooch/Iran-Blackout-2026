package ir.nasim.core.modules.file.entity;

import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17902nl0;
import ir.nasim.AbstractC25020zb8;
import ir.nasim.C12056dy;
import ir.nasim.C19084pl0;
import ir.nasim.C19675ql0;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB3\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b&\u0010#R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010*R\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010 R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b.\u0010-R\u0013\u00101\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lir/nasim/core/modules/file/entity/FileReference;", "Lir/nasim/zb8;", "Lir/nasim/dy;", "fileLocation", "", "fileName", "caption", "", "fileSize", "<init>", "(Lir/nasim/dy;Ljava/lang/String;Ljava/lang/String;I)V", "", "fileId", "accessHash", "(JJLjava/lang/String;Ljava/lang/String;I)V", "Lir/nasim/pl0;", "values", "Lir/nasim/rB7;", "parse", "(Lir/nasim/pl0;)V", "Lir/nasim/ql0;", "writer", "serialize", "(Lir/nasim/ql0;)V", "", "o", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "createInstance", "()Lir/nasim/dy;", "Ljava/lang/String;", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getCaption", TokenNames.I, "getFileSize", "setFileSize", "(I)V", "getFileLocation", "getFileId", "()J", "getAccessHash", "getFileStorageVersion", "()Ljava/lang/Integer;", "fileStorageVersion", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class FileReference extends AbstractC25020zb8 {
    private static final int RECORD_ID = 10;
    private final String caption;
    private String fileName;
    private int fileSize;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileReference(C12056dy c12056dy, String str, String str2, int i) {
        super(10, c12056dy);
        AbstractC13042fc3.i(c12056dy, "fileLocation");
        AbstractC13042fc3.i(str, "fileName");
        this.fileName = str;
        this.caption = str2;
        this.fileSize = i;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && AbstractC13042fc3.d(FileReference.class, o.getClass()) && ((C12056dy) getWrapped()).getFileId() == ((C12056dy) ((FileReference) o).getWrapped()).getFileId();
    }

    public final long getAccessHash() {
        return ((C12056dy) getWrapped()).getAccessHash();
    }

    public final String getCaption() {
        return this.caption;
    }

    public final long getFileId() {
        return ((C12056dy) getWrapped()).getFileId();
    }

    public final C12056dy getFileLocation() {
        AbstractC17902nl0 wrapped = getWrapped();
        AbstractC13042fc3.h(wrapped, "getWrapped(...)");
        return (C12056dy) wrapped;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final Integer getFileStorageVersion() {
        return ((C12056dy) getWrapped()).getFileStorageVersion();
    }

    public int hashCode() {
        return (int) (((C12056dy) getWrapped()).getFileId() ^ (((C12056dy) getWrapped()).getFileId() >>> 32));
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 values) {
        AbstractC13042fc3.i(values, "values");
        if (!values.c(6, false)) {
            setWrapped(new C12056dy(values.i(1), values.i(2), Integer.valueOf(values.x(3))));
        }
        super.parse(values);
        this.fileSize = values.g(3);
        this.fileName = values.r(4);
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 writer) {
        AbstractC13042fc3.i(writer, "writer");
        writer.a(6, true);
        writer.f(3, this.fileSize);
        writer.o(4, this.fileName);
        super.serialize(writer);
    }

    public final void setFileName(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.fileName = str;
    }

    public final void setFileSize(int i) {
        this.fileSize = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    public C12056dy createInstance() {
        return new C12056dy();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileReference(long j, long j2, String str, String str2, int i) {
        this(new C12056dy(j, j2, 1), str, str2, i);
        AbstractC13042fc3.i(str, "fileName");
    }
}
