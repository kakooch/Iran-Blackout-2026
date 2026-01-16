package okio.internal;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC6703Op6;
import ir.nasim.BJ;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.SA1;
import ir.nasim.V06;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;

@SA1(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", l = {SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lir/nasim/Op6;", "Lokio/Path;", "Lir/nasim/rB7;", "<anonymous>", "(Lir/nasim/Op6;)V"}, k = 3, mv = {1, 9, 0})
/* renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* loaded from: classes8.dex */
final class FileSystem$commonDeleteRecursively$sequence$1 extends V06 implements InterfaceC14603iB2 {
    final /* synthetic */ Path $fileOrDirectory;
    final /* synthetic */ FileSystem $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, interfaceC20295rm1);
        fileSystem$commonDeleteRecursively$sequence$1.L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override // ir.nasim.InterfaceC14603iB2
    public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }

    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        Object objE = AbstractC14862ic3.e();
        int i = this.label;
        if (i == 0) {
            AbstractC10685c16.b(obj);
            AbstractC6703Op6 abstractC6703Op6 = (AbstractC6703Op6) this.L$0;
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            BJ bj = new BJ();
            Path path = this.$fileOrDirectory;
            this.label = 1;
            if (FileSystem.collectRecursively(abstractC6703Op6, fileSystem, bj, path, false, true, this) == objE) {
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
}
