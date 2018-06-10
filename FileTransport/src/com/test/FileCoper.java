package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class FileCoper {
//private static final String _ORIGIN_FILE_MODE = "r";
//private static final String _TARGET_FILE_MODE = "rw";
//private static long time1 = 0l;
//private String originFileName;
//private String targetFileName;
//private RandomAccessFile originFile;
//private RandomAccessFile targetFile;
//private int threadCount;
//private static int totalThreadCount = 0;
//private static int executedCount = 0;
//public FileCoper() {
//this.threadCount = 1;
//totalThreadCount = this.threadCount;
//}
//public FileCoper(String originFile, String targetFile) {
//try {
//this.originFileName = originFile;
//this.targetFileName = targetFile;
//this.originFile = new RandomAccessFile((originFile), FileCoper._ORIGIN_FILE_MODE);
//this.targetFile = new RandomAccessFile((targetFile), FileCoper._TARGET_FILE_MODE);
//this.threadCount = 1;
//totalThreadCount = this.threadCount;
//} catch (FileNotFoundException e) {
//e.printStackTrace();
//}
//}
//public FileCoper(String originFile, String targetFile, int threadCount) {
//try {
//this.originFileName = originFile;
//this.targetFileName = targetFile;
//this.originFile = new RandomAccessFile((originFile), FileCoper._ORIGIN_FILE_MODE);
//this.targetFile = new RandomAccessFile((targetFile), FileCoper._TARGET_FILE_MODE);
//this.threadCount = 1;
//totalThreadCount = this.threadCount;
//} catch (FileNotFoundException e) {
//e.printStackTrace();
//}
//}
//
//public void init(String originFile, String targetFile) throws Exception {
//this.originFileName = originFile;
//this.targetFileName = targetFile;
//this.originFile = new RandomAccessFile((originFile), FileCoper._ORIGIN_FILE_MODE);
//this.targetFile = new RandomAccessFile((targetFile), FileCoper._TARGET_FILE_MODE);
//this.threadCount = 1;
//totalThreadCount = this.threadCount;
//}
//
//public void init(String originFile, String targetFile, int threadCount) throws Exception {
//this.originFileName = originFile;
//this.targetFileName = targetFile;
//this.originFile = new RandomAccessFile((originFile), FileCoper._ORIGIN_FILE_MODE);
//this.targetFile = new RandomAccessFile((targetFile), FileCoper._TARGET_FILE_MODE);
//this.threadCount = threadCount;
//totalThreadCount = this.threadCount;
//}
//
//public void init(RandomAccessFile originFile, RandomAccessFile targetFile) throws Exception {
//this.originFile = originFile;
//this.targetFile = targetFile;
//this.threadCount = 1;
//totalThreadCount = this.threadCount;
//}
//
//public void init(RandomAccessFile originFile, RandomAccessFile targetFile, int threadCount) throws Exception {
//this.originFile = originFile;
//this.targetFile = targetFile;
//this.threadCount = threadCount;
//totalThreadCount = this.threadCount;
//}
//
//public static synchronized void finish() {
//FileCoper.executedCount ++;
//System.out.println("总线程【" + FileCoper.totalThreadCount + "】,已经完成【" + FileCoper.executedCount + "】个线程的复制！！！");
//if (FileCoper.totalThreadCount == FileCoper.executedCount){
//long time2 = System.currentTimeMillis();
//System.out.println("花费时长："+(time2-time1));
//System.out.println("所有【" + FileCoper.totalThreadCount + "】线程复制完成！！！");
//}
//}
//
//public void start() throws Exception {
//if (this.originFile.length() == 0)
//return;
//if (this.threadCount == 0)
//this.threadCount = 1;
//// 设置目标文件大小
//this.targetFile.setLength(this.originFile.length());
//this.targetFile.seek(0);
//this.originFile.seek(0);
//time1 = System.currentTimeMillis();
//System.out.println(this.originFile.length());
//// 把文件分块，每一块有一对值：当前块在文件中的起始位置和结束位置
//long[][] splits = new long[this.threadCount][2];
//long riginFileLength = this.originFile.length();
//int startPos = 0;
//long originFileLength=this.originFile.length();
//for (int i = 0; i < this.threadCount; i++) {
//splits[i][0] = 0;
//splits[i][1] = 0;
//if (i == 0) {
//splits[i][0] = 0;
//splits[i][1] = originFileLength / this.threadCount;
//} else if (i == this.threadCount - 1) {
//// 注意：此处不能加1，如果加1，线程多文件就会出现乱码
//// splits[i][0] = startPos + 1;
//splits[i][0] = startPos;
//splits[i][1] = originFileLength;
//} else {
//// 注意：此处不能加1，如果加1，线程多文件就会出现乱码
//// splits[i][0] = startPos + 1;
//splits[i][0] = startPos;
//splits[i][1] = startPos + originFileLength / this.threadCount;
//}
//startPos += originFileLength / this.threadCount;
//// System.out.println(splits[i][0] + " " + splits[i][1]);
//Coper fc = new Coper("thread-" + i);
//fc.init(this.originFile, this.targetFile, splits[i][0], splits[i][1]);
//fc.setOriginFileName(this.originFileName);
//fc.setTargetFileName(this.targetFileName);
//fc.start();
//}
//}
//public void startNew() throws Exception {
//if (this.originFile.length() == 0)
//return;
//// 设置目标文件大小
//this.targetFile.setLength(this.originFile.length());
//this.targetFile.seek(0);
//this.originFile.seek(0);
//long startPosition;
//long endPosition;
//long block = this.originFile.length() / 1029;
//if (block <= 1)
//this.threadCount = 1;
//for (int i = 0; i < this.threadCount; i++) {
//// 定义每次转移的长度
//startPosition = i * 1029 * (block / this.threadCount);
//endPosition = (i + 1) * 1029 * (block / this.threadCount);
//if (i == (this.threadCount - 1))
//endPosition = this.originFile.length();
//Coper fc = new Coper("thread-" + i);
//fc.init(this.originFile, this.targetFile, startPosition, endPosition);
//fc.setOriginFileName(this.originFileName);
//fc.setTargetFileName(this.targetFileName);
//fc.start();
//}
}