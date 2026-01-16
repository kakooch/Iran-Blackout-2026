package ir.nasim.utils.tools.workmanager.workers;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11458d25;
import ir.nasim.C19938rB7;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C9057Yh4;
import ir.nasim.C9475a16;
import ir.nasim.I22;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC19009pd5;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC8481Wd5;
import ir.nasim.core.modules.profile.entity.ExPeer;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0097@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lir/nasim/utils/tools/workmanager/workers/UploadPinnedDialogsWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$a;", "r", "(Lir/nasim/rm1;)Ljava/lang/Object;", "i", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class UploadPinnedDialogsWorker extends CoroutineWorker {

    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return UploadPinnedDialogsWorker.this.r(this);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return UploadPinnedDialogsWorker.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long[] jArrL = UploadPinnedDialogsWorker.this.g().l("peers_uid_to_pin");
                int iJ = UploadPinnedDialogsWorker.this.g().j("folder_id_to_pin", -1);
                if (jArrL == null) {
                    return ListenableWorker.a.c();
                }
                if (AbstractC5969Lp4.d() == null) {
                    C5735Kp4.w().L();
                }
                C9057Yh4 c9057Yh4O2 = AbstractC5969Lp4.d().o2();
                if (c9057Yh4O2 != null) {
                    ArrayList arrayList = new ArrayList(jArrL.length);
                    for (long j : jArrL) {
                        C11458d25 c11458d25R = C11458d25.r(j);
                        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                        arrayList.add(new ExPeer(c9057Yh4O2.E().M1(c11458d25R), c11458d25R.getPeerId()));
                    }
                    InterfaceC8481Wd5 interfaceC8481Wd5Z = ((InterfaceC19009pd5) I22.a(C5721Ko.a.d(), InterfaceC19009pd5.class)).Z();
                    this.b = c9057Yh4O2;
                    this.c = 1;
                    objA = interfaceC8481Wd5Z.a(iJ, arrayList, this);
                    if (objA == objE) {
                        return objE;
                    }
                }
                return ListenableWorker.a.c();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            objA = ((C9475a16) obj).l();
            if (C9475a16.j(objA)) {
                return ListenableWorker.a.c();
            }
            if (C9475a16.e(objA) != null) {
                return ListenableWorker.a.b();
            }
            return ListenableWorker.a.c();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadPinnedDialogsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(workerParameters, "workerParams");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker$b r0 = (ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker$b r0 = new ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            ir.nasim.AbstractC10685c16.b(r6)     // Catch: java.lang.Exception -> L29
            goto L49
        L29:
            r6 = move-exception
            goto L4f
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L33:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = ir.nasim.C12366eV1.b()     // Catch: java.lang.Exception -> L29
            ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker$c r2 = new ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker$c     // Catch: java.lang.Exception -> L29
            r4 = 0
            r2.<init>(r4)     // Catch: java.lang.Exception -> L29
            r0.c = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)     // Catch: java.lang.Exception -> L29
            if (r6 != r1) goto L49
            return r1
        L49:
            java.lang.String r0 = "withContext(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r0)     // Catch: java.lang.Exception -> L29
            return r6
        L4f:
            java.lang.String r0 = "UploadPinnedDialogsWorker"
            java.lang.String r1 = "Error on executing UploadPinnedDialogsWorker doWork!"
            ir.nasim.C19406qI3.c(r0, r1, r6)
            androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.b()
            java.lang.String r0 = "retry(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker.r(ir.nasim.rm1):java.lang.Object");
    }
}
