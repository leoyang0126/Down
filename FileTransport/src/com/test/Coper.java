package com.test;

import java.io.RandomAccessFile;

public class Coper extends Thread {
//    private String originFileName;
//    private String targetFileName;
//    private RandomAccessFile originFile;
//    private RandomAccessFile targetFile;
//    private String threadId;
//    private long startPosition;
//    private long endPosition;
//    private long blockCapacity;
//    public void setOriginFileName(String originFileName) {
//    this.originFileName = originFileName;
//    }
//    public void setTargetFileName(String targetFileName) {
//    this.targetFileName = targetFileName;
//    }
//    public Coper(String threadId) {
//    this.threadId = threadId;
//    }
//    public void init(RandomAccessFile originFile, RandomAccessFile targetFile, long startPosition, long endPosition) throws Exception {
//    this.originFile = originFile;
//    this.targetFile = targetFile;
//    this.startPosition = startPosition;
//    this.endPosition = endPosition;
//    this.blockCapacity = this.endPosition - this.startPosition;
//    }
//    public void run() {
//    // System.out.println(this.threadId + " 启动，开始复制文件【" +
//    // this.originFileName + "】中的文件块【" + this.startPosition + "," +
//    // this.endPosition + "】到目标文件【" + this.targetFileName + "】中...");
//    synchronized (this.originFile) {
//    try {
//    // 记录当前拷贝的字节数
//    int copyCount = 0;
//    // 数据拷贝的启示偏移量
//    long ffSet = this.startPosition;
//    byte[] b = new byte[16 * 1024 * 1024];
//    // 动态设置一次读取的字节数缓冲
//    long blockSize = 0;
//    offSet=this.originFile.
//    while (copyCount < this.blockCapacity) {
//    this.originFile.seek(offSet);
//    if (this.blockCapacity - copyCount > 16 * 1024 * 1024)
//    blockSize = 16 * 1024 * 1024;
//    else
//    blockSize = this.blockCapacity - copyCount;
//    if (blockSize > this.blockCapacity - copyCount)
//    blockSize = this.blockCapacity - copyCount;
//    int count = this.originFile.read(b, 0, (int) blockSize);
//    synchronized (this.targetFile) {
//    try {
//    if (copyCount == 0)
//    this.targetFile.seek(offSet);
//    else
//    this.targetFile.seek(offSet + 1);
//    this.targetFile.write(b, 0, count);
//    } catch (IOException e) {
//    e.printStackTrace();
//    }
//    }
//    // 增加拷贝的字节数
//    copyCount += count;
//    // 拷贝其实【偏移量下移
//    offSet += count;
//    }
//    } catch (IOException e) {
//    e.printStackTrace();
//    }
//    }
//    // System.out.println(this.threadId + " 复制文件【" + this.originFileName
//    // + "】中的文件块【" + this.startPosition + "," + this.endPosition +
//    // "】到目标文件【" + this.targetFileName + "】完成!");
//    // 通知主线程，当前线程完成复制工作
//    FileCoper.finish();
//    }
    }
