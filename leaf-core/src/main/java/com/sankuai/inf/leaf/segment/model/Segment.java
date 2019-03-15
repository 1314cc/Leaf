package com.sankuai.inf.leaf.segment.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 号段
 */
public class Segment {
    /**
     * value 当前号段中准备下次下发的值
     */
    private AtomicLong value = new AtomicLong(0);

    /**
     * 此号段最大值
     */
    private volatile long max;

    /**
     * 此号段的步长,与buffer中的step同步.
     */
    private volatile int step;

    /**
     * 此号段隶属的SegmentBuffer
     */
    private SegmentBuffer buffer;

    public Segment(SegmentBuffer buffer) {
        this.buffer = buffer;
    }

    public AtomicLong getValue() {
        return value;
    }

    public void setValue(AtomicLong value) {
        this.value = value;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public SegmentBuffer getBuffer() {
        return buffer;
    }

    public long getIdle() {
        return this.getMax() - getValue().get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Segment(");
        sb.append("value:");
        sb.append(value);
        sb.append(",max:");
        sb.append(max);
        sb.append(",step:");
        sb.append(step);
        sb.append(")");
        return sb.toString();
    }
}
