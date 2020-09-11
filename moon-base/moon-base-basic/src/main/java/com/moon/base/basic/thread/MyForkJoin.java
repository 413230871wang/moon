package com.moon.base.basic.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/11 11:26 上午
 */
public class MyForkJoin extends RecursiveTask<Integer> {
    private int start;
    private int end;

    private static final int threshold = 2;

    public MyForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean cancomputed = (end - start) <= threshold;
        int sum = 0;
        if(cancomputed){
            for(int i = start;i<=end;i++){
                System.out.println("当前线程是:"+Thread.currentThread());
                sum += i;
            }
        }else{
            int middle = (end+start)/2;
            MyForkJoin leftForkJoin = new MyForkJoin(start,middle);
            MyForkJoin rightForkJoin = new MyForkJoin(middle+1,end);

            leftForkJoin.fork();
            rightForkJoin.fork();

            int left = leftForkJoin.join();
            int right = rightForkJoin.join();
            sum = left + right;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoin mfj = new MyForkJoin(1,100);
        Future<Integer> result = forkJoinPool.submit(mfj);
        System.out.println("result:"+result.get());
    }
}
