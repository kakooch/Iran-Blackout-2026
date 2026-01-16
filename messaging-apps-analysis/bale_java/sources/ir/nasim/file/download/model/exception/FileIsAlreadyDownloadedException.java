package ir.nasim.file.download.model.exception;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC9905al2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lir/nasim/file/download/model/exception/FileIsAlreadyDownloadedException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "Lir/nasim/al2$a;", "fileContent", "<init>", "(Lir/nasim/al2$a;)V", "a", "Lir/nasim/al2$a;", "()Lir/nasim/al2$a;", "file_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class FileIsAlreadyDownloadedException extends IllegalStateException {

    /* renamed from: a, reason: from kotlin metadata */
    private final InterfaceC9905al2.a fileContent;

    public FileIsAlreadyDownloadedException(InterfaceC9905al2.a aVar) {
        AbstractC13042fc3.i(aVar, "fileContent");
        this.fileContent = aVar;
    }

    /* renamed from: a, reason: from getter */
    public final InterfaceC9905al2.a getFileContent() {
        return this.fileContent;
    }
}
