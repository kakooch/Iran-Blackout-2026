package ir.eitaa.messenger;

import ir.eitaa.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class SegmentTree {
    private int[] array;
    private Node[] heap;

    private boolean contains(int from1, int to1, int from2, int to2) {
        return from2 >= from1 && to2 <= to1;
    }

    private boolean intersects(int from1, int to1, int from2, int to2) {
        return (from1 <= from2 && to1 >= from2) || (from1 >= from2 && from1 <= to2);
    }

    public SegmentTree(int[] array) {
        this.array = array;
        if (array.length < 30) {
            return;
        }
        this.heap = new Node[(int) (Math.pow(2.0d, Math.floor((Math.log(array.length) / Math.log(2.0d)) + 1.0d)) * 2.0d)];
        build(1, 0, array.length);
    }

    private void build(int v, int from, int size) {
        this.heap[v] = new Node();
        Node[] nodeArr = this.heap;
        nodeArr[v].from = from;
        nodeArr[v].to = (from + size) - 1;
        if (size == 1) {
            Node node = nodeArr[v];
            int[] iArr = this.array;
            node.sum = iArr[from];
            nodeArr[v].max = iArr[from];
            nodeArr[v].min = iArr[from];
            return;
        }
        int i = v * 2;
        int i2 = size / 2;
        build(i, from, i2);
        int i3 = i + 1;
        build(i3, from + i2, size - i2);
        Node[] nodeArr2 = this.heap;
        nodeArr2[v].sum = nodeArr2[i].sum + nodeArr2[i3].sum;
        nodeArr2[v].max = Math.max(nodeArr2[i].max, nodeArr2[i3].max);
        Node[] nodeArr3 = this.heap;
        nodeArr3[v].min = Math.min(nodeArr3[i].min, nodeArr3[i3].min);
    }

    public int rMaxQ(int from, int to) {
        int[] iArr = this.array;
        if (iArr.length < 30) {
            int i = Integer.MIN_VALUE;
            if (from < 0) {
                from = 0;
            }
            if (to > iArr.length - 1) {
                to = iArr.length - 1;
            }
            while (from <= to) {
                int[] iArr2 = this.array;
                if (iArr2[from] > i) {
                    i = iArr2[from];
                }
                from++;
            }
            return i;
        }
        return rMaxQ(1, from, to);
    }

    private int rMaxQ(int v, int from, int to) {
        Node node = this.heap[v];
        if (node.pendingVal != null && contains(node.from, node.to, from, to)) {
            return node.pendingVal.intValue();
        }
        if (contains(from, to, node.from, node.to)) {
            return this.heap[v].max;
        }
        if (!intersects(from, to, node.from, node.to)) {
            return 0;
        }
        propagate(v);
        int i = v * 2;
        return Math.max(rMaxQ(i, from, to), rMaxQ(i + 1, from, to));
    }

    public int rMinQ(int from, int to) {
        int[] iArr = this.array;
        if (iArr.length < 30) {
            int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
            if (from < 0) {
                from = 0;
            }
            if (to > iArr.length - 1) {
                to = iArr.length - 1;
            }
            while (from <= to) {
                int[] iArr2 = this.array;
                if (iArr2[from] < i) {
                    i = iArr2[from];
                }
                from++;
            }
            return i;
        }
        return rMinQ(1, from, to);
    }

    private int rMinQ(int v, int from, int to) {
        Node node = this.heap[v];
        if (node.pendingVal != null && contains(node.from, node.to, from, to)) {
            return node.pendingVal.intValue();
        }
        if (contains(from, to, node.from, node.to)) {
            return this.heap[v].min;
        }
        if (!intersects(from, to, node.from, node.to)) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        propagate(v);
        int i = v * 2;
        return Math.min(rMinQ(i, from, to), rMinQ(i + 1, from, to));
    }

    private void propagate(int v) {
        Node[] nodeArr = this.heap;
        Node node = nodeArr[v];
        Integer num = node.pendingVal;
        if (num != null) {
            int i = v * 2;
            change(nodeArr[i], num.intValue());
            change(this.heap[i + 1], node.pendingVal.intValue());
            node.pendingVal = null;
        }
    }

    private void change(Node n, int value) {
        n.pendingVal = Integer.valueOf(value);
        n.sum = n.size() * value;
        n.max = value;
        n.min = value;
        this.array[n.from] = value;
    }

    static class Node {
        int from;
        int max;
        int min;
        Integer pendingVal = null;
        int sum;
        int to;

        Node() {
        }

        int size() {
            return (this.to - this.from) + 1;
        }
    }
}
