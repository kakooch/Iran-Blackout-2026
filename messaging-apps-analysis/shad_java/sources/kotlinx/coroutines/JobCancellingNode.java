package kotlinx.coroutines;

import kotlinx.coroutines.Job;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public abstract class JobCancellingNode<J extends Job> extends JobNode<J> {
    public JobCancellingNode(J j) {
        super(j);
    }
}
