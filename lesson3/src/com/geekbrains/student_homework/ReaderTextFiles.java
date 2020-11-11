package com.geekbrains.student_homework;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReaderTextFiles {
    private int page;
    private long pageCount;
    private final RandomAccessFile raf;

    public ReaderTextFiles(String fileName) throws IOException {
        this.page = 1;
        this.raf = new RandomAccessFile(fileName, "r");
        if (raf.length() / 1024 < 10) {
            throw new ExceptionInInitializerError("file size < 10MB");
        }
        this.pageCount = raf.length() / 1800 + 1;
    }

    public void readPage(int pageNumber) throws IOException {
        int start;
        byte[] bytes = new byte[1800];
        if (pageNumber < 1 || pageNumber > pageCount) {
            System.out.println("This page doesn't exist");
            return;
        }
        if (pageNumber == 1) {
            start = 0;
        } else {
            start = (pageNumber - 1) * 1800;
        }
        raf.seek(start);
        raf.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char) bytes[i]);
        }
        System.out.println();
    }

    public long getPageCount() {
        return pageCount;
    }
}
