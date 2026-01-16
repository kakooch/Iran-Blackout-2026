package io.sentry.android.replay.gestures;

import android.view.MotionEvent;
import io.sentry.android.replay.u;
import io.sentry.rrweb.e;
import io.sentry.rrweb.f;
import io.sentry.transport.p;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.ED1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class b {
    public static final a e = new a(null);
    public static final int f = 8;
    private final p a;
    private final LinkedHashMap b;
    private long c;
    private long d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public b(p pVar) {
        AbstractC13042fc3.i(pVar, "dateProvider");
        this.a = pVar;
        this.b = new LinkedHashMap(10);
    }

    public final List a(MotionEvent motionEvent, u uVar) {
        AbstractC13042fc3.i(motionEvent, "event");
        AbstractC13042fc3.i(uVar, "recorderConfig");
        int actionMasked = motionEvent.getActionMasked();
        int i = 0;
        if (actionMasked != 0) {
            boolean z = true;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    long jA = this.a.a();
                    long j = this.d;
                    if (j != 0 && j + 50 > jA) {
                        return null;
                    }
                    this.d = jA;
                    Set<Integer> setKeySet = this.b.keySet();
                    AbstractC13042fc3.h(setKeySet, "currentPositions.keys");
                    for (Integer num : setKeySet) {
                        AbstractC13042fc3.h(num, "pId");
                        int iFindPointerIndex = motionEvent.findPointerIndex(num.intValue());
                        if (iFindPointerIndex != -1) {
                            if (this.c == 0) {
                                this.c = jA;
                            }
                            Object obj = this.b.get(num);
                            AbstractC13042fc3.f(obj);
                            f.b bVar = new f.b();
                            bVar.i(motionEvent.getX(iFindPointerIndex) * uVar.e());
                            bVar.j(motionEvent.getY(iFindPointerIndex) * uVar.f());
                            bVar.f(i);
                            bVar.g(jA - this.c);
                            ((Collection) obj).add(bVar);
                        }
                        i = 0;
                    }
                    long j2 = jA - this.c;
                    if (j2 <= 500) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList(this.b.size());
                    for (Map.Entry entry : this.b.entrySet()) {
                        int iIntValue = ((Number) entry.getKey()).intValue();
                        ArrayList<f.b> arrayList2 = (ArrayList) entry.getValue();
                        if (arrayList2.isEmpty() ^ z) {
                            f fVar = new f();
                            fVar.f(jA);
                            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
                            for (f.b bVar2 : arrayList2) {
                                bVar2.g(bVar2.e() - j2);
                                arrayList3.add(bVar2);
                                jA = jA;
                            }
                            fVar.n(arrayList3);
                            fVar.m(iIntValue);
                            arrayList.add(fVar);
                            Object obj2 = this.b.get(Integer.valueOf(iIntValue));
                            AbstractC13042fc3.f(obj2);
                            ((ArrayList) obj2).clear();
                            z = true;
                        }
                    }
                    this.c = 0L;
                    return arrayList;
                }
                if (actionMasked == 3) {
                    this.b.clear();
                    e eVar = new e();
                    eVar.f(this.a.a());
                    eVar.u(motionEvent.getX() * uVar.e());
                    eVar.v(motionEvent.getY() * uVar.f());
                    eVar.q(0);
                    eVar.s(0);
                    eVar.r(e.b.TouchCancel);
                    return AbstractC9766aX0.e(eVar);
                }
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return null;
                    }
                }
            }
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            int iFindPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex2 == -1) {
                return null;
            }
            this.b.remove(Integer.valueOf(pointerId));
            e eVar2 = new e();
            eVar2.f(this.a.a());
            eVar2.u(motionEvent.getX(iFindPointerIndex2) * uVar.e());
            eVar2.v(motionEvent.getY(iFindPointerIndex2) * uVar.f());
            eVar2.q(0);
            eVar2.s(pointerId);
            eVar2.r(e.b.TouchEnd);
            return AbstractC9766aX0.e(eVar2);
        }
        int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
        int iFindPointerIndex3 = motionEvent.findPointerIndex(pointerId2);
        if (iFindPointerIndex3 == -1) {
            return null;
        }
        this.b.put(Integer.valueOf(pointerId2), new ArrayList(10));
        e eVar3 = new e();
        eVar3.f(this.a.a());
        eVar3.u(motionEvent.getX(iFindPointerIndex3) * uVar.e());
        eVar3.v(motionEvent.getY(iFindPointerIndex3) * uVar.f());
        eVar3.q(0);
        eVar3.s(pointerId2);
        eVar3.r(e.b.TouchStart);
        return AbstractC9766aX0.e(eVar3);
    }
}
